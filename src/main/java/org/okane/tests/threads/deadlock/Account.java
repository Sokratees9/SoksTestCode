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

public class Account {
   private final int number;
   private int balance;

   public Account(int number, int openingBalance) {
      this.number = number;
      this.balance = openingBalance;
   }

   public void withDrawAmount(int amount) throws OverdrawnException {
      if (amount > balance) {
         throw new OverdrawnException();
      }
      balance -= amount;
   }

   public void deposit(int amount) {
      balance += amount;
   }

   public int getNumber() {
      return number;
   }

   public int getBalance() {
      return balance;
   }
}