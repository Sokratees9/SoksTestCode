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
package org.okane.tests.annotation;

import java.lang.annotation.*;

/**
 *
 **/
@MultivalueAnnotation(message = "sample message")
public class AnnotationTests {
   public static void main(String[] args) {

      Annotation[] annotations = Book.class.getAnnotations();
      for (Annotation annotation : annotations) {
         System.out.println("Type of annotation is " + annotation.annotationType());
         if (annotation instanceof Author) {
            Author a1 = (Author) annotation;
            System.out.println("author first name is " + a1.first());
            System.out.println("author last name is " + a1.last());
         }
      }

      AnnotationTests test = new AnnotationTests();

      //check is annotation is available
      if (test.getClass().isAnnotationPresent(MultivalueAnnotation.class)) {
          MultivalueAnnotation ma = test.getClass().getAnnotation(MultivalueAnnotation.class);
          System.out.println("annotation message " + ma.message());
          System.out.println("annotation print number " + ma.printNumber());
      }
   }
}
