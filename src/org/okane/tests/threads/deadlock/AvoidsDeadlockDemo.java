/***
 **  @(#) TradeCard.com 1.0
 **
 **  Copyright (c) 2012 TradeCard, Inc. All Rights Reserved.
 **
 **
 **  THIS COMPUTER SOFTWARE IS THE PROPERTY OF TradeCard, Inc.
 **
 **  Permission is granted to use this software as specified by the TradeCard
 **  COMMERCIAL LICENSE AGREEMENT.  You may use this software only for
 **  commercial purposes, as specified in the details of the license.
 **  TRADECARD SHALL NOT BE LIABLE FOR ANY  DAMAGES SUFFERED BY
 **  THE LICENSEE AS A RESULT OF USING OR MODIFYING THIS SOFTWARE IN ANY WAY.
 **
 **  YOU MAY NOT DISTRIBUTE ANY SOURCE CODE OR OBJECT CODE FROM THE TradeCard.com
 **  TOOLKIT AT ANY TIME. VIOLATORS WILL BE PROSECUTED TO THE FULLEST EXTENT
 **  OF UNITED STATES LAW.
 **
 **  @version 1.0
 **  @author Copyright (c) 2012 TradeCard, Inc. All Rights Reserved.
 **
 **/
package org.okane.tests.threads.deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AvoidsDeadlockDemo {

   private static final int NUM_ACCOUNTS = 10;
   private static final int NUM_THREADS = 20;
   private static final int NUM_ITERATIONS = 100000;

   static final Random rnd = new Random();

   List<Account> accounts = new ArrayList<Account>();

   public static void main(String args[]) {

      AvoidsDeadlockDemo demo = new AvoidsDeadlockDemo();
      demo.setUp();
      demo.run();
   }

   void setUp() {

      for (int i = 0; i < NUM_ACCOUNTS; i++) {
         Account account = new Account(i, rnd.nextInt(1000));
         accounts.add(account);
      }
   }

   void run() {

      for (int i = 0; i < NUM_THREADS; i++) {
         new BadTransferOperation(i).start();
      }
   }

   class BadTransferOperation extends Thread {

      int threadNum;

      BadTransferOperation(int threadNum) {
         this.threadNum = threadNum;
      }

      @Override
      public void run() {

         for (int i = 0; i < NUM_ITERATIONS; i++) {

            Account toAccount = accounts.get(rnd.nextInt(NUM_ACCOUNTS));
            Account fromAccount = accounts.get(rnd.nextInt(NUM_ACCOUNTS));
            int amount = rnd.nextInt(1000);

            if (!toAccount.equals(fromAccount)) {
               try {
                  transfer(fromAccount, toAccount, amount);
                  System.out.print(".");
               } catch (OverdrawnException e) {
                  System.out.print("-");
               }

               if (i % 60 == 0) {
                  System.out.print("\n");
               }
            }
         }
         System.out.println("Thread Complete: " + threadNum);
      }

      /**
       * This is the crucial point here. The idea is that to avoid deadlock
       * you need to ensure that threads can't try to lock the same two
       * accounts in the same order
       */
      private void transfer(Account fromAccount, Account toAccount, int transferAmount) throws OverdrawnException {

         if (fromAccount.getNumber() > toAccount.getNumber()) {

            synchronized (fromAccount) {
               synchronized (toAccount) {
                  fromAccount.withDrawAmount(transferAmount);
                  toAccount.deposit(transferAmount);
               }
            }
         } else {

            synchronized (toAccount) {
               synchronized (fromAccount) {
                  fromAccount.withDrawAmount(transferAmount);
                  toAccount.deposit(transferAmount);
               }
            }
         }
      }
   }
}