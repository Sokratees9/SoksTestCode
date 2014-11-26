package org.okane.tests;
import java.util.*;


public class Super10Random {

	public static void main(String[] args) {
		Map<String, Integer> englandTeamValueMap = new HashMap<>();
		Map<String, Integer> europeTeamValueMap = new HashMap<>();
		Map<String, Integer> allTeamsValueMap = new HashMap<>();
		int count = 0;
		int europeCount = 0;
		for (String teamValue : args) {
			String[] split = teamValue.split("\t");
			if (split.length == 2) {
				try {
					if (count < 92) {
						englandTeamValueMap.put(split[0].trim(), Integer.valueOf(split[1]));
					} else {
						europeTeamValueMap.put(split[0].trim(), Integer.valueOf(split[1]));
						europeCount++;
					}
					allTeamsValueMap.put(split[0].trim(), Integer.valueOf(split[1]));
					count++;
				} catch (NumberFormatException e) {
					// no op
				}
			}
		}

		List<String> selectedTeams;
		List<String> englishTeams = new ArrayList<>(englandTeamValueMap.keySet());
		List<String> europeanTeams = new ArrayList<>(europeTeamValueMap.keySet());
		Random r = new Random(System.currentTimeMillis());
		int total;
		do {
			total = 0;
			selectedTeams = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				if (i < 7) {
					selectedTeams.add(englishTeams.get(r.nextInt(92)));
				} else {
					selectedTeams.add(europeanTeams.get(r.nextInt(europeCount)));
				}
			}
			
			for (String selected : selectedTeams) {
				total += allTeamsValueMap.get(selected);
			}
			
			System.out.println("Teams: " + selectedTeams + " - value: " + total);
		} while (total != 900);
		
		System.out.print("Result!");
	}

}
