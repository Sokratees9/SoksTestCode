/***
 **  @(#) TradeCard.com 1.0
 **
 **  Copyright (c) 2013 TradeCard, Inc. All Rights Reserved.
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
 **  @author Copyright (c) 2013 TradeCard, Inc. All Rights Reserved.
 **
 **/
package org.okane.tests;

import java.util.*;

/**
 *
 **/
public class EratosthenesPrimeTest {
   public static void main(String[] args) {
      int square = 1000;

      // populate the array, ignore 0 and 1
      List<Integer> numbers = new ArrayList<Integer>(square * square);
      for (int i = 2; i < square * square; i++) {
         numbers.add(i);
      }

      int nextPrime = numbers.remove(0);
      List<Integer> primes = new ArrayList<>();
      primes.add(nextPrime);
      while (nextPrime <= square) {
         List<Integer> nonPrimes = new ArrayList<>();
         for (int number : numbers) {
            if ((number >= nextPrime * nextPrime) && (number % nextPrime == 0)) {
               nonPrimes.add(number);
            }
         }
         numbers.removeAll(nonPrimes);
         nextPrime = numbers.remove(0);
         System.out.println(nextPrime);
         primes.add(nextPrime);
      }
      primes.addAll(numbers);
      System.out.println(primes);
   }
}
