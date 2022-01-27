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
import java.net.*;
import java.util.*;

/**
 *
 **/
public class TheWave {
   public static void main(String[] args) {
      boolean calledRecently = false;
      while (true) {
         BufferedReader br;
         try {
            System.out.println("Reading webpage");
            URL pageUrl = new URL("https://www.blm.gov/az/paria/hikingcalendar.cfm?areaid=2");

            URLConnection getConn = pageUrl.openConnection();
            getConn.connect();
            br = new BufferedReader(new InputStreamReader(getConn.getInputStream()));

            String urlData = "";
            String currentMonth = "";
            boolean firstMonthFound = false;

            String wholePage = "";
            String foundData = "";
            while((urlData = br.readLine()) != null) {
               wholePage += urlData + "\n";

               if (urlData.contains("subheadone")) {
                  currentMonth = urlData.substring(urlData.indexOf("title") + 7, urlData.indexOf("\">"));
                  firstMonthFound = true;
                  continue;
               }

               if (firstMonthFound && urlData.contains("<td") && urlData.contains("calendar")) {
                  if (!urlData.contains("nbsp") && !urlData.contains("None")) {
                     int indexOf = urlData.indexOf("return true\">");
                     int nextIndexOf = urlData.indexOf("return true\">", indexOf + 10);
                     String currentDay = urlData.substring(indexOf + 13, indexOf + 15);
                     if (currentDay.charAt(1) == '<') {
                        currentDay = currentDay.substring(0, 1);
                     }
                     String numberOfTickets = urlData.substring(nextIndexOf + 13, nextIndexOf + 15);
                     if (numberOfTickets.charAt(1) == '<') {
                        numberOfTickets = numberOfTickets.substring(0, 1);
                     }
                     foundData += numberOfTickets + " available on " + currentDay + " " + currentMonth + "\n";
                  }
               }
            }
            br.close();
            System.out.println("Finished reading webpage");
            if (foundData.length() > 0) {
               if (!calledRecently) {
                  System.out.println(new Date().toString());
                  System.out.println(foundData);
                  System.out.println(wholePage);
                  Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Skype\\Phone\\Skype\" /callto:+16464040570");
                  try {
                     Thread.sleep(25000);// sleep for 25 seconds to allow call to start
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
                  Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Skype\\Phone\\Skype\" /shutdown");
                  calledRecently = true;
               }
            } else {
               System.out.println("No data found");
               calledRecently = false;
            }


         } catch (Exception e) {
            e.printStackTrace();
            calledRecently = false;
         }

         try {
            Thread.sleep(150000);// sleep for 2.5 minutes
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

}
