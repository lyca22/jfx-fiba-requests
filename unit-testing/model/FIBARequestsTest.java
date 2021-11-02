package model;


import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import datastr.AVLTree;
import datastr.BinaryTree;


class FIBARequestsTest {

	private ArrayList<Player> playerList;
	private AVLTree<Player, Double> averageScoreTree;
	private AVLTree<Player, Double> averageAssistsTree;
	private AVLTree<Player, Double> averageBlocksTree;
	private AVLTree<Player, Double> averageStealsTree;
	private AVLTree<Player, Double> averageBouncesTree;
	
	@BeforeEach
	void FIBASC1() throws Exception {
		playerList = new ArrayList<>();
		averageScoreTree = new AVLTree<>();
		averageBouncesTree = new AVLTree<>();
		averageAssistsTree = new AVLTree<>();
	}
	
	@BeforeEach
	void FIBASC2() throws Exception {
		playerList = new ArrayList<>();
		averageScoreTree = new AVLTree<>();
		averageBouncesTree = new AVLTree<>();
		averageAssistsTree = new AVLTree<>();
	}

	@Test
	void testAddPlayer() {
		
	}
}
