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

import java.io.*;
import java.util.*;
import com.google.common.collect.*;
import com.google.common.io.*;
import com.google.common.base.*;

/**
 * 
 **/
public class StringHashCodeCollisionTest {
   public static void main(String[] args) throws IOException {
      List<String> words = CharStreams.readLines(new InputStreamReader(StringHashCodeCollisionTest.class.getResourceAsStream("corncob_lowercase.txt")));
      Multimap<Integer, String> wordMap = ArrayListMultimap.create();
      for (String word : words) {
          wordMap.put(word.hashCode(), word);
          String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
          wordMap.put(capitalizedWord.hashCode(), capitalizedWord);
      }

      Map<Integer, Collection<String>> collisions = Maps.filterValues(wordMap.asMap(), new Predicate<Collection<String>>() {
          public boolean apply(Collection<String> strings) {
              return strings.size() > 1;
          }
      });

      System.out.println("Number of collisions: " + collisions.size());
      for (Collection<String> collision : collisions.values()) {
          System.out.println(collision);
      }
   }
}
