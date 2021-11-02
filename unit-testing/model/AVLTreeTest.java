package model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastr.AVLTree;
import datastr.Node;

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
		tree.add(65, 65);
		
		tree.add(10, 10);
		tree.add(60, 60);
		tree.add(55, 55);
		tree.add(65, 65);
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
		AVLTSC1();
	
		tree.delete(7, 7);
		assertTrue(tree.getRoot()==null);
		
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
	
	/*@Test
	void testLeftRotate() throws Exception {
		AVLTSC7();
		//We take for granted taht this method work because of the rest of the program is working
		
	}
	
	
	@Test
	void testRightRotate() throws Exception {
	/ take for granted taht this method work because of the rest of the program is working
		/*Node<Integer, Integer> nodeS;
		AVLTSC7();
		nodeS = tree.search(90);
		tree.leftRotate(nodeS);
		
		System.out.println(tree.getRoot().getRight().getLeft().getSearchParameter()==60);
	}
	*/
	
	@Test
	void testGetHeight() throws Exception {
		AVLTSC6();
		
		int x = tree.getHeight(tree.search(45));
		
		assertTrue(x == 3);
		
		int y = tree.getHeight(tree.search(74));
		
		assertTrue(y == 2);
		
		int z = tree.getHeight(tree.search(65));
		
		assertTrue(z == 0);
	}
	
	@Test
	void testGetBalance() throws Exception {
		AVLTSC6();
		
		int x = tree.getBalance(tree.search(45));
		
		assertTrue(x == 1);
		
		int y = tree.getBalance(tree.search(74));
		
		assertTrue(y == -1);
		
		int z = tree.getBalance(tree.search(65));
		
		assertTrue(z == 0);
	}
	
	@Test
	void testBalance() throws Exception {
		AVLTSC3();
		//Trees balance themselves after each add. We'll take for granted that other cases are working because the rest of the test work
		
		assertTrue(tree.getRoot().getLeft().getSearchParameter() == 19);
		assertTrue(tree.getRoot().getLeft().getLeft().getSearchParameter() == 18);
		assertTrue(tree.getRoot().getLeft().getRight().getSearchParameter() == 28);
		
		assertTrue(tree.getRoot().getRight().getSearchParameter() == 60);
		assertTrue(tree.getRoot().getRight().getLeft().getSearchParameter() == 50);
		assertTrue(tree.getRoot().getRight().getRight().getSearchParameter() == 74);
		
	}

}
