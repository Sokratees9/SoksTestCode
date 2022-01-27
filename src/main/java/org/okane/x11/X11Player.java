package org.okane.x11;

import java.util.*;

import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class X11Player {
	public static final String PLAYER1 = "ctl00_cphMain_dgPlayers_ctl";
	public static final String PLAYER2 = "_HyperLink1";
	public static final String RETIRING = "_imgQuiter";
	public static final String FITNESS = "_imgThumbup";
	
	private String position;
	private String id;
	private String name;
	private Boolean retiring;
	private Integer age;
	private Integer skill;
	private Boolean fit;
	private Set<X11SpecialQualities> specialQualities = new HashSet<>();

	public X11Player(Element playerData, String number) {
		Elements playerDataElements = playerData.getElementsByTag("td");
		position = playerDataElements.get(1).ownText();
		Element nameAndId = playerDataElements.get(2);
		id = nameAndId.getElementsByTag("div").get(0).ownText();
		name = nameAndId.getElementById(PLAYER1 + number + PLAYER2).ownText();
		retiring = nameAndId.getElementById(PLAYER1 + number + RETIRING) == null ? Boolean.FALSE : Boolean.TRUE;
		age = new Integer(playerDataElements.get(3).ownText());
		skill = new Integer(playerDataElements.get(4).getElementsByTag("span").get(0).attr("title"));
		fit = playerData.getElementById(PLAYER1 + number + FITNESS) == null ? Boolean.FALSE : Boolean.TRUE;
		Element sqElement = playerDataElements.get(5);
		Elements sqImages = sqElement.getElementsByTag("img");
		for (Element image : sqImages) {
			String imageURL = image.attr("src");
			specialQualities.add(X11SpecialQualities.getSQ(imageURL.substring(imageURL.lastIndexOf('/') + 1, imageURL.lastIndexOf('.'))));
		}
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean isRetiring() {
		return retiring;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public Integer getSkill() {
		return skill;
	}
	
	public Boolean isFit() {
		return fit;
	}
	
	public boolean hasSpecialQuality(X11SpecialQualities quality) {
		return specialQualities.contains(quality);
	}
	
	@Override
	public String toString() {
		return "X11Player [position=" + position + ", id=" + id + ", name="
				+ name + ", retiring=" + retiring + ", age=" + age + ", skill="
				+ skill + ", fit=" + fit + ", specialQualities="
				+ specialQualities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		X11Player other = (X11Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
