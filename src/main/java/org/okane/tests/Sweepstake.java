package org.okane.tests;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Sweepstake {
	
	private String[] particpants = {
			"Drew","Drew","Drew","Stephen","Sunny","Edward","Edward","Ivy",
			"Corbin","Tao","Wayne","Wayne","Kelvin","Gladys","Joan","Richard",
			"Richard","Ting","Raymond","Jennifer","Stephanie","Michelle","Tony","Tony",
			"Calvin","Andy","Connie","Lanny","Frank","Francis","Bible","Stephen"
	};
	
	private String[] competitors = {
			"Argentina","Algeria","Australia","Belgium","Bosnia","Brazil","Cameroon","Chile",
			"Columbia","Costa Rica","Croatia","Ecuador","England","France","Germany","Ghana",
			"Greece","Honduras","Iran","Italy","Ivory Coast","Japan","Mexico","Netherlands",
			"Nigeria","Portugal","Russia","South Korea","Spain","Switzerland","USA","Uruguay"};
	
	public static void main(String[] args) {
		new Sweepstake();
	}
	
	public Sweepstake() {
		Random r = new Random(System.currentTimeMillis());
		Map<String, Map<String, Integer>> stats = new HashMap<>(); 

		List<String> participantList = Arrays.asList(particpants);
		for (String participant : participantList) {
			stats.put(participant, new HashMap<String, Integer>());
		}
		
		for (int i = 0; i < 10; i++) {
		
			List<String> competitorList = new ArrayList<>();
			for (String competitor : competitors) {
				competitorList.add(competitor);
			}
			
			int teamsLeft = 32;
			for (String participant : participantList) {
				int nextInt = r.nextInt(teamsLeft--);
				String competitor = competitorList.remove(nextInt);
				
				if (stats.get(participant).get(competitor) == null) {
					stats.get(participant).put(competitor, 0);
				}
				
				stats.get(participant).put(competitor, (stats.get(participant).get(competitor)) + 1);
			}
		}
		
		Set<String> uniqueParticipants = new HashSet<>(participantList);
		for (String participant : uniqueParticipants) {
			Map<String, Integer> participantStats = stats.get(participant);
			for (String competitor : participantStats.keySet()) {
				System.out.println(participant + " got " + competitor + " " + participantStats.get(competitor) + " times");
			}
		}
	}
}
