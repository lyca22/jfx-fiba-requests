package model;

import java.util.ArrayList;
import java.util.List;

import datastr.AVLTree;
import datastr.ComparisonCriteria;

public class FIBARequests {

	private ArrayList<Player> playerList;
	private AVLTree<Player, Integer> averageScoreTree;
	private AVLTree<Player, Integer> averageAssistsTree;
	private AVLTree<Player, Integer> averageBlocksTree;
	private AVLTree<Player, Integer> averageStealsTree;
	private AVLTree<Player, Integer> averageBouncesTree;

	public FIBARequests() {}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public AVLTree<Player, Integer> getAverageScoreTree() {
		return averageScoreTree;
	}

	public void setAverageScoreTree(AVLTree<Player, Integer> averageScoreTree) {
		this.averageScoreTree = averageScoreTree;
	}

	public AVLTree<Player, Integer> getAverageAssistsTree() {
		return averageAssistsTree;
	}

	public void setAverageAssistsTree(AVLTree<Player, Integer> averageAssistsTree) {
		this.averageAssistsTree = averageAssistsTree;
	}

	public AVLTree<Player, Integer> getAverageBlocksTree() {
		return averageBlocksTree;
	}

	public void setAverageBlocksTree(AVLTree<Player, Integer> averageBlocksTree) {
		this.averageBlocksTree = averageBlocksTree;
	}

	public AVLTree<Player, Integer> getAverageStealsTree() {
		return averageStealsTree;
	}

	public void setAverageStealsTree(AVLTree<Player, Integer> averageStealsTree) {
		this.averageStealsTree = averageStealsTree;
	}

	public AVLTree<Player, Integer> getAverageBouncesTree() {
		return averageBouncesTree;
	}

	public void setAverageBouncesTree(AVLTree<Player, Integer> averageBouncesTree) {
		this.averageBouncesTree = averageBouncesTree;
	}

	public void addPlayer(Player player) {
		//TODO Implement Method.
	}

	public void deletePlayer(Player player) {
		//TODO Implement Method.
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
	
	public int searchMinimum(String input, int i, int j, int minimum) {
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

	public int searchMaximum(String input, int i, int j, int maximum) {
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

	public List<Player> searchCriteria(TreeCriteria treeCriterion, ComparisonCriteria comparisonCriterion) {
		switch(treeCriterion) {
		case ASSISTS:
			break;
		case BLOCKS:
			break;
		case BOUNCES:
			break;
		case SCORE:
			break;
		case STEALS:
			break;
		}
		return null;
	}

}
