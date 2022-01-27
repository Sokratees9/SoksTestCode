package org.okane.x11;

import java.io.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class X11Team {
	public static final String testTextFile = "C:\\Users\\sokane\\Documents\\X11Team.txt";
	public static final String player1 = "ctl00_cphMain_dgPlayers_ctl";
	public static final String player2 = "_HyperLink1";
	public static final String retiring = "_imgQuiter";
	public static final String playersId = "ctl00_cphMain_dgPlayers";
	
	
	
	public static void main(String[] args) {
		String htmlText = "";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(testTextFile))))) {
			String nextLine;
			while ((nextLine = reader.readLine()) != null) {
				htmlText += nextLine;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Document doc = Jsoup.parse(htmlText);
		Element teamData = doc.getElementById(playersId);
		
		Elements players = teamData.getElementsByTag("tr");
		for (int j = 1; j < players.size(); j++) {
			String number = "" + (j + 1);
			if (j < 9) {
				number = "0" + number;
			}
			
			Element playerData = players.get(j);
			X11Player player = new X11Player(playerData, number);
			
			System.out.println(player);
		}
	}
}