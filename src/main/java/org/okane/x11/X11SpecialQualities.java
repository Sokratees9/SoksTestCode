package org.okane.x11;


public enum X11SpecialQualities {
	INJURY_PRONE,
	GREEDY,
	HARD_TRAINER,
	ALL_ROUNDER,
	INTELLIGENT,
	HEART,
	GOLD_HEART,
	FREE_TAKER,
	COOL,
	LEADER,
	TOUGH,
	MOUTHY,
	CHEAT,
	MOODY,
	DIVA,
	POWER_SHOTS,
	QUICK,
	HEADER,
	GOAL_INSTINCT,
	STAMINA,
	POSITIONING,
	ONE_ON_ONE,
	GOOD_IN_THE_AIR,
	REACTIONS;
	
	public static X11SpecialQualities getSQ(String imageURL) {
		switch (imageURL) {
		case "intelligent15":
			return INTELLIGENT;
		case "heart15":
			return HEART;
		case "oneonone15":
			return ONE_ON_ONE;
		case "header15":
			return HEADER;
		case "goldheart15":
			return GOLD_HEART;
		case "cool15":
			return COOL;
		case "freekick15":
			return FREE_TAKER;
		case "allround15":
			return ALL_ROUNDER;
		case "quick15":
			return QUICK;
		case "shooter15":
			return POWER_SHOTS;
		case "goalinstinct15":
			return GOAL_INSTINCT;
		case "stamina15":
			return STAMINA;
		default:
			System.out.println("As yet unknown SQ: " + imageURL);
			return null;
		}
	}
}
