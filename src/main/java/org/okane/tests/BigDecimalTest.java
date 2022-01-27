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

import java.math.*;

/**
 * 
 **/
public class BigDecimalTest {
   public static void main(String[] args) {
      BigDecimal bg1 = new BigDecimal("1.234");
      BigDecimal bg3 = bg1.setScale(2, BigDecimal.ROUND_HALF_UP);
      BigDecimal bg2 = new BigDecimal("1.2");
      BigDecimal bg4 = bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
      System.out.println(bg3.toString());
      System.out.println(bg4.toString());
      
      System.out.println(58.0 / 100 * 100);
      BigDecimal bd58 = new BigDecimal(58);
      BigDecimal bd100 = new BigDecimal(100);
      System.out.println(bd58.divide(bd100).multiply(bd100));
   }
}
