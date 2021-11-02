package model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastr.AVLTree;

class AVLTreeTest {

	AVLTree<Integer, Integer> tree;
	
	@BeforeEach
	void AVLTSC1() throws Exception {
		tree = new AVLTree<>();
	}
	
	@BeforeEach
	void AVLTSC2() throws Exception {
		tree = new AVLTree<>();
		tree.add(9, 9);
		tree.add(5, 5);
		tree.add(11, 11);
	}
	
	@BeforeEach
	void AVLTSC3() throws Exception {
		tree = new AVLTree<>();
		tree.add(45, 45);
		tree.add(18, 18);
		tree.add(74, 74);
		tree.add(28, 28);
		tree.add(50, 50);
		tree.add(19, 19);
		tree.add(60, 60);
	}
	
	@BeforeEach
	void AVLTSC4() throws Exception {
		tree = new AVLTree<>();
		tree.add(45, 45);
		tree.add(18, 18);
		tree.add(74, 74);
		
		tree.add(16, 16);
		tree.add(28, 28);
		tree.add(50, 50);
		tree.add(90, 90);
	}
	
	@BeforeEach
	void AVLTSC5() throws Exception {
		tree = new AVLTree<>();
		tree.add(45, 45);
		tree.add(18, 18);
		tree.add(74, 74);
		
		tree.add(16, 16);
		tree.add(60, 60);
		tree.add(90, 90);
		tree.add(95, 95);
	}
	
	@BeforeEach
	void AVLTSC6() throws Exception {
		tree = new AVLTree<>();
		tree.add(45, 45);
		tree.add(18, 18);
		tree.add(74, 74);
		
		tree.add(16, 16);
		tree.add(60, 60);
		tree.add(90, 90);
		tree.add(55, 55);
		tree.add(65, 65);
	}
	
	@BeforeEach
	void AVLTSC7() throws Exception {
		tree = new AVLTree<>();
		tree.add(45, 45);
		tree.add(18, 18);
		tree.add(90, 90);
		
		tree.add(16, 16);
		tree.add(60, 60);
		tree.add(55, 55);
		tree.add(65, 65);
		tree.add(64, 64);
	}

	@BeforeEach
	void AVLTSC8() throws Exception {
		tree = new AVLTree<>();
		tree.add(45, 45);
		tree.add(18, 18);
		tree.add(74, 74);
		
		tree.add(16, 16);
		tree.add(65, 65);
		tree.add(90, 90);
		tree.add(60, 60);
		tree.add(55, 55);
		tree.add(64, 64);
	}
	
	@BeforeEach
	void AVLTSC9() throws Exception {
		tree = new AVLTree<>();
		tree.add(9, 9);
		tree.add(15, 15);
	}
	
	@Test
	void testAdd() throws Exception {
		AVLTSC1();
	
		tree.add(7, 7);
		assertTrue(tree.getRoot().getSearchParameter() == 7);
		
		AVLTSC2();
		
		tree.add(7, 7);
		assertTrue(tree.getRoot().getSearchParameter() == 9);
		assertTrue(tree.getRoot().getLeft().getRight().getSearchParameter() == 7);
		
		AVLTSC4();
		
		tree.add(55, 55);
		
		assertTrue(tree.getRoot().getRight().getLeft().getRight().getSearchParameter() == 55);
		
		AVLTSC9();
		
		tree.add(30, 30);
		
		assertTrue(tree.getRoot().getSearchParameter()==15);
		
	}
	
	@Test
	void testDelete() throws Exception {
		AVLTSC2();
	
		tree.delete(7, 7);
		assertTrue(tree.getRoot()==null);
		
		/*AVLTSC2();
		
		tree.add(7, 7);
		assertTrue(tree.getRoot().getSearchParameter() == 9);
		assertTrue(tree.getRoot().getLeft().getRight().getSearchParameter() == 7);
		
		AVLTSC4();
		
		tree.add(55, 55);
		
		assertTrue(tree.getRoot().getRight().getLeft().getRight().getSearchParameter() == 55);
		
		AVLTSC9();
		
		tree.add(30, 30);
		
		assertTrue(tree.getRoot().getSearchParameter()==15);
		*/
	}
}
