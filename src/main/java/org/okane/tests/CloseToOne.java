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

/**
 *
 **/
public class CloseToOne {
   public static double makeDouble(long first, long second) {
      return ((first << 27) + second) / (double) (1L << 53);
   }

   public static void main(String[] args) {

      System.out.println((((1L << 53) - 1)) / (double) (1L << 53));

      long first = (1 << 26) - 1;
      long second = (1 << 27) - 1;

      System.out.println(makeDouble(first, second));
      System.out.println((int)(makeDouble(first, second)+1));

      second--;
      System.out.println(makeDouble(first, second));
      System.out.println((int)(makeDouble(first, second)+1));
   }
}
