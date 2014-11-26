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
public class StringTests {
   public static void main(String[] args) {
      String s1 = null;
      if ("".equals(s1)) {
         System.out.println("empty string .equals null are the same");
      } else {
         System.out.println("empty string .equals null are not the same");
      }

//      testMethod(null);  // will not compile
      testMethod((String) null);
      testMethod((Integer) null);
      
      String value1 = null;
      String value2 = null;
      if (!(value2 == null ? value1 == null : value2.equals(value1))) {
         System.out.println(value2 + " is not equal to " + value1);
      } else {
         System.out.println(value2 + " is equal to " + value1);
      }
      value1 = "test";
      if (!(value2 == null ? value1 == null : value2.equals(value1))) {
         System.out.println(value2 + " is not equal to " + value1);
      } else {
         System.out.println(value2 + " is equal to " + value1);
      }
      value2 = "test";
      if (!(value2 == null ? value1 == null : value2.equals(value1))) {
         System.out.println(value2 + " is not equal to " + value1);
      } else {
         System.out.println(value2 + " is equal to " + value1);
      }
      value2 = "test2";
      if (!(value2 == null ? value1 == null : value2.equals(value1))) {
         System.out.println(value2 + " is not equal to " + value1);
      } else {
         System.out.println(value2 + " is equal to " + value1);
      }
      value1 = null;
      if (!(value2 == null ? value1 == null : value2.equals(value1))) {
         System.out.println(value2 + " is not equal to " + value1);
      } else {
         System.out.println(value2 + " is equal to " + value1);
      }
   }

   private static void testMethod(String s) {
      System.out.println("testMethod for String s: " + s);
   }
   private static void testMethod(Integer s) {
      System.out.println("testMethod for Integer s: " + s);
   }
}
