package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datastr.AVLTree;
import datastr.ComparisonCriteria;

public class FIBARequests {

	private ArrayList<Player> playerList;
	private AVLTree<Player, Double> averageScoreTree;
	private AVLTree<Player, Double> averageAssistsTree;
	private AVLTree<Player, Double> averageBlocksTree;
	private AVLTree<Player, Double> averageStealsTree;
	private AVLTree<Player, Double> averageBouncesTree;

	public FIBARequests() {
		setPlayerList(new ArrayList<Player>());
		setAverageScoreTree(new AVLTree<Player, Double>());
		setAverageAssistsTree(new AVLTree<Player, Double>());
		setAverageBlocksTree(new AVLTree<Player, Double>());
		setAverageStealsTree(new AVLTree<Player, Double>());
		setAverageBouncesTree(new AVLTree<Player, Double>());
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public AVLTree<Player, Double> getAverageScoreTree() {
		return averageScoreTree;
	}

	public void setAverageScoreTree(AVLTree<Player, Double> averageScoreTree) {
		this.averageScoreTree = averageScoreTree;
	}

	public AVLTree<Player, Double> getAverageAssistsTree() {
		return averageAssistsTree;
	}

	public void setAverageAssistsTree(AVLTree<Player, Double> averageAssistsTree) {
		this.averageAssistsTree = averageAssistsTree;
	}

	public AVLTree<Player, Double> getAverageBlocksTree() {
		return averageBlocksTree;
	}

	public void setAverageBlocksTree(AVLTree<Player, Double> averageBlocksTree) {
		this.averageBlocksTree = averageBlocksTree;
	}

	public AVLTree<Player, Double> getAverageStealsTree() {
		return averageStealsTree;
	}

	public void setAverageStealsTree(AVLTree<Player, Double> averageStealsTree) {
		this.averageStealsTree = averageStealsTree;
	}

	public AVLTree<Player, Double> getAverageBouncesTree() {
		return averageBouncesTree;
	}

	public void setAverageBouncesTree(AVLTree<Player, Double> averageBouncesTree) {
		this.averageBouncesTree = averageBouncesTree;
	}

	public void addPlayer(Player player) {
		playerList.add(player);
		averageScoreTree.add(player, player.getAverageScore());
		averageAssistsTree.add(player, player.getAverageAssists());
		averageBlocksTree.add(player, player.getAverageBlocks());
		averageStealsTree.add(player, player.getAverageSteals());
		averageBouncesTree.add(player, player.getAverageBounces());
	}

	public void sortPlayerList() {
		Collections.sort(playerList);
	}

	public void addWithCSV(String filename) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		br.readLine();
		String line = br.readLine();
		while(line != null) {
			String[] playerData = line.split(";");
			String name = playerData[0];
			int age = Integer.parseInt(playerData[1]);
			String team = playerData[2];
			Double averageScore = Double.valueOf(playerData[3]);
			Double averageAssists = Double.valueOf(playerData[4]);
			Double averageBlocks = Double.valueOf(playerData[5]);
			Double averageSteals = Double.valueOf(playerData[6]);
			Double averageBounces = Double.valueOf(playerData[7]);
			Player player = new Player(name, age, team, averageScore, averageAssists, averageBlocks, averageSteals, averageBounces);
			addPlayer(player);
			line = br.readLine();
		}
		sortPlayerList();
		br.close();
	}

	public void deletePlayer(Player player) {
		playerList.remove(player);
		averageScoreTree.delete(player, player.getAverageScore());
		averageAssistsTree.delete(player, player.getAverageAssists());
		averageBlocksTree.delete(player, player.getAverageBlocks());
		averageStealsTree.delete(player, player.getAverageSteals());
		averageBouncesTree.delete(player, player.getAverageBounces());
	}

	public void modifyPlayer(Player deletedPlayer, Player newPlayer) {
		deletePlayer(deletedPlayer);
		addPlayer(newPlayer);
	}

	public Player searchPlayer(String input, int i, int j) {
		if(j >= i) {
			int mid = (i+j)/2;
			Player player = playerList.get(mid);
			if(player.getName().compareTo(input) == 0) {
				return player;
			}else if(player.getName().compareTo(input) > 0) {
				return searchPlayer(input, i, mid-1);
			}else {
				return searchPlayer(input, mid+1, j);
			}
		}else {
			return null;
		}
	}

	public List<Player> searchPlayers(String input){
		int minimum = searchMinimum(input, 0, playerList.size(), -1);
		int maximum = searchMaximum(input, 0, playerList.size(), -1);
		ArrayList<Player> filteredList = new ArrayList<Player>(playerList.subList(minimum, maximum+1));
		return filteredList;
	}

	public List<Player> searchPlayers(ArrayList<Player> list, String input){
		int minimum = searchMinimum(input, 0, list.size(), -1);
		int maximum = searchMaximum(input, 0, list.size(), -1);
		ArrayList<Player> filteredList = new ArrayList<Player>(list.subList(minimum, maximum+1));
		return filteredList;
	}

	private int searchMinimum(String input, int i, int j, int minimum) {
		if(i > j) {
			return minimum;
		}else {
			int mid = (i+j)/2;
			Player player = playerList.get(mid);
			if(player.getName().toLowerCase().startsWith(input.toLowerCase())) {
				return searchMinimum(input, i, mid-1, mid);
			}else {
				if(player.getName().compareToIgnoreCase(input) > 0) {
					return searchMinimum(input, i, mid-1, minimum);
				}else {
					return searchMinimum(input, mid+1, j, minimum);
				}
			}
		}
	}

	private int searchMaximum(String input, int i, int j, int maximum) {
		if(i > j) {
			return maximum;
		}else {
			int mid = (i+j)/2;
			Player player = playerList.get(mid);
			if(player.getName().toLowerCase().startsWith(input.toLowerCase())) {
				return searchMaximum(input, mid+1, j, mid);
			}else {
				if(player.getName().compareToIgnoreCase(input) > 0) {
					return searchMaximum(input, i, mid-1, maximum);
				}else {
					return searchMaximum(input, mid+1, j, maximum);
				}
			}
		}
	}

	public List<Player> searchCriteria(TreeCriteria treeCriterion, Double parameter, ComparisonCriteria comparisonCriterion) {
		switch(treeCriterion) {
		case SCORE:
			return averageScoreTree.searchList(parameter, comparisonCriterion);
		case ASSISTS:
			return averageAssistsTree.searchList(parameter, comparisonCriterion);
		case BLOCKS:
			return averageBlocksTree.searchList(parameter, comparisonCriterion);
		case STEALS:
			return averageStealsTree.searchList(parameter, comparisonCriterion);
		case BOUNCES:
			return averageBouncesTree.searchList(parameter, comparisonCriterion);
		}
		return null;
	}

}
