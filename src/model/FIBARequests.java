package model;

import java.util.List;

import datastr.AVLTree;
import datastr.ComparisonCriteria;

public class FIBARequests {

	private AVLTree<Player, Integer> averageScoreTree;
	private AVLTree<Player, Integer> averageAssistsTree;
	private AVLTree<Player, Integer> averageBlocksTree;
	private AVLTree<Player, Integer> averageStealsTree;
	private AVLTree<Player, Integer> averageBouncesTree;
	
	public FIBARequests() {
		
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
	
	public List<Player> search(TreeCriteria treeCriterion, ComparisonCriteria comparisonCriterion) {
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
