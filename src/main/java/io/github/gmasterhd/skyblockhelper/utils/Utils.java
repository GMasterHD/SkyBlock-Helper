package io.github.gmasterhd.skyblockhelper.utils;

import net.minecraft.scoreboard.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
	private static EnumUtils.Floor currentFloor = EnumUtils.Floor.F1;
	private static EnumUtils.Floor lastFloor = EnumUtils.Floor.F1;
	
	public static EnumUtils.Floor getCurrentDungeonFloor() {
		return currentFloor;
	}
	public static EnumUtils.Floor getLastFloor() {
		return lastFloor;
	}
	
	public static boolean isInDungeon = false;
	
	public static void saveFloor(Scoreboard board) {
		lastFloor = currentFloor;
		
		List<String> sideBarLines = getSidebarLines(board);
		for(String s: sideBarLines) {
			if(s.contains("F1")) {
				currentFloor = EnumUtils.Floor.F1;
				return;
			} else if(s.contains("F2")) {
				currentFloor = EnumUtils.Floor.F2;
				return;
			} else if(s.contains("F3")) {
				currentFloor = EnumUtils.Floor.F3;
				return;
			} else if(s.contains("F4")) {
				currentFloor = EnumUtils.Floor.F4;
				return;
			} else if(s.contains("F5")) {
				currentFloor = EnumUtils.Floor.F5;
				return;
			} else if(s.contains("F6")) {
				currentFloor = EnumUtils.Floor.F6;
				return;
			} else if(s.contains("F7")) {
				currentFloor = EnumUtils.Floor.F7;
				return;
			} else {
				// Should never happen but to be save
				isInDungeon = false;
			}
		}
	}
	
	public static List<String> getSidebarLines(Scoreboard board) {
		List<String> lines = new ArrayList();
		// Grab the main objective of the scoreboard.
		ScoreObjective objective = board.getObjectiveInDisplaySlot(1);
		
		List<Score> scores = (List<Score>)board.getSortedScores(objective);
		
		scores = (List<Score>)scores.stream().filter(input -> (input.getPlayerName() != null && !input.getPlayerName().startsWith("#"))).skip(Math.max(scores.size() - 15, 0)).collect(Collectors.toList());
		
		Formatter formatter = new Formatter();
		
		Collections.reverse(scores);
		for (Score score : scores) {
			int width = 30;
			ScorePlayerTeam scoreplayerteam = board.getPlayersTeam(score.getPlayerName());
			String playerName = ScorePlayerTeam.formatPlayerName((Team)scoreplayerteam, score.getPlayerName());
			playerName = RegexUtils.strip(playerName, RegexUtils.SIDEBAR_PLAYER_NAME_PATTERN);
			//if (stripControlCodes)
			//	playerName = StringUtils.func_76338_a(playerName);
			int points = score.getScorePoints();
			width = Math.max(width, (playerName + " " + points).length());
			formatter.format("%-" + width + "." + width + "s %d%n", new Object[] { playerName, Integer.valueOf(points) });
			
			lines.add(playerName);
			
			System.out.println("Width: " + width + " PlayerName: " + playerName);
		}
		
		return lines;
	}
}
