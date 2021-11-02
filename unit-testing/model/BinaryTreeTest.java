package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastr.BinaryTree;
import datastr.ComparisonCriteria;
import datastr.Node;

class BinaryTreeTest {

	BinaryTree<Integer, Integer> tree;
	
	@BeforeEach
	void BTTSC1() throws Exception {
		tree = new BinaryTree<>();
	}

	@BeforeEach
	void BTTSC2() throws Exception {
		tree = new BinaryTree<>();
		tree.add(7, 7);
	}
	
	@BeforeEach
	void BTTSC3() throws Exception {
		tree = new BinaryTree<>();
		tree.add(7, 7);
		tree.add(9, 9);
	}
	
	@BeforeEach
	void BTTSC4() throws Exception {
		tree = new BinaryTree<>();
		tree.add(7, 7);
		tree.add(5, 5);
	}
	
	@BeforeEach
	void BTTSC5() throws Exception {
		tree = new BinaryTree<>();
		tree.add(9, 9);
		tree.add(5, 5);
		tree.add(13, 13);
		tree.add(3, 3);
		tree.add(7, 7);
		tree.add(11, 11);
		tree.add(15, 15);
	}
	
	@BeforeEach
	void BTTSC6() throws Exception {
		tree = new BinaryTree<>();
		tree.add(7, 7);
		tree.add(5, 5);
		tree.add(3, 3);
	}

	@Test
	void testAdd() throws Exception {
		BTTSC1();
		tree.add(7,7);
		
		assertTrue(!tree.isEmpty());
		assertEquals(tree.getRoot().getSearchParameter(), 7);
		
		BTTSC2();
		tree.add(9, 9);
		
		assertTrue(tree.getRoot().getRight()!=null);
		assertTrue(tree.getRoot().getLeft()==null);
		assertEquals(tree.getRoot().getRight().getSearchParameter(), 9);
		
		BTTSC2();
		tree.add(5, 5);
		
		assertTrue(tree.getRoot().getRight()==null);
		assertTrue(tree.getRoot().getLeft()!=null);
		assertEquals(tree.getRoot().getLeft().getSearchParameter(), 5);
		
		BTTSC3();
		tree.add(8, 8);
		
		assertTrue(tree.getRoot().getRight().getLeft()!=null);
		assertEquals(tree.getRoot().getRight().getLeft().getSearchParameter(), 8);
		
		BTTSC4();
		tree.add(6, 6);
		
		assertTrue(tree.getRoot().getLeft().getRight()!=null);
		assertEquals(tree.getRoot().getLeft().getRight().getSearchParameter(), 6);
		
		BTTSC5();
		tree.add(15, 15);
		
		assertTrue(tree.getRoot().getRight().getRight().getLeft() == null);
		assertTrue(tree.getRoot().getRight().getRight().getElement().size()==2);
	}

	@Test
	void testSearch() throws Exception {
		Node<Integer, Integer> foundNode;
		
		BTTSC1();
		foundNode = tree.search(7);
		
		assertTrue(foundNode == null);
		
		BTTSC2();
		foundNode = tree.search(7);
		
		assertTrue(foundNode != null);
		assertTrue(foundNode.getSearchParameter() == 7);
		
		BTTSC2();
		foundNode = tree.search(5);
		
		assertTrue(foundNode == null);
		
		BTTSC5();
		foundNode = tree.search(10);
		
		assertTrue(foundNode == null);
	}
	
	@Test
	void testDelete() throws Exception {
		BTTSC2();
		tree.delete(7, 7);
		
		assertTrue(tree.isEmpty());
		
		BTTSC3();
		tree.delete(9, 9);
		
		assertTrue(tree.getRoot().getRight()==null);
		
		BTTSC4();
		tree.delete(5, 5);
		
		assertTrue(tree.getRoot().getLeft()==null);
		
		BTTSC6();
		tree.delete(5,5);
		assertTrue(tree.getRoot().getLeft().getLeft() == null);
		assertEquals(tree.getRoot().getLeft().getSearchParameter(), 3);

		BTTSC5();
		tree.delete(9, 9); 
		 
		assertTrue(tree.getRoot().getSearchParameter() == 11);
	}
	
	@Test
	void testsearchList() throws Exception {
		ArrayList<Integer> obtained;
		ArrayList<Integer> expected;
		
		BTTSC3();
		obtained = (ArrayList<Integer>) tree.searchList(10, ComparisonCriteria.MINOR);
		
		expected = new ArrayList<>();
		expected.add(9);expected.add(7);
		
		
		assertEquals(obtained, expected);
		
		BTTSC4();
		obtained = (ArrayList<Integer>) tree.searchList(10, ComparisonCriteria.MINOR);
		
		expected = new ArrayList<>();
		expected.add(7);expected.add(5);
		
		
		assertEquals(obtained, expected);
		
		BTTSC5();
		obtained = (ArrayList<Integer>) tree.searchList(12, ComparisonCriteria.MINOR_EQUAL);
		
		expected = new ArrayList<>();
		expected.add(11);expected.add(9);expected.add(7);expected.add(5);expected.add(3);
		
		
		assertEquals(obtained, expected);
		
		/*BTTSC5();
		obtained = (ArrayList<Integer>) tree.searchList(10, ComparisonCriteria.EQUAL);
		
		expected = new ArrayList<>();		
		
		assertEquals(obtained, expected);*/	
		
		BTTSC5();
		obtained = (ArrayList<Integer>) tree.searchList(7, ComparisonCriteria.GREATER);
		
		expected = new ArrayList<>();		
		expected.add(9);expected.add(11);expected.add(13);expected.add(15);
		
		assertEquals(obtained, expected);
		
		BTTSC5();
		obtained = (ArrayList<Integer>) tree.searchList(7, ComparisonCriteria.GREATER_EQUAL);
		
		expected = new ArrayList<>();		
		expected.add(7);expected.add(9);expected.add(11);expected.add(13);expected.add(15);
		
		assertEquals(obtained, expected);
	}
	
	@Test
	void testGetMinimun() throws Exception {
		ArrayList<Integer> mins;
		
		BTTSC1();
		mins = tree.getMinimum();
		
		assertTrue(mins==null);
		
		BTTSC2();
		mins = tree.getMinimum();
		
		assertTrue(mins.get(0) == 7);
		
		BTTSC4();
		mins = tree.getMinimum();
		
		assertTrue(mins.get(0) == 5);	 
		
		BTTSC5();
		mins = tree.getMinimum();
		
		assertTrue(mins.get(0) == 3);
	}
	
	@Test
	void testGetMaximun() throws Exception {
		
		ArrayList<Integer> maxs;
		BTTSC1();
		maxs = tree.getMaximum();
		
		assertTrue(maxs == null);
		
		BTTSC2();
		maxs = tree.getMaximum();
		
		assertTrue(maxs.get(0) == 7);
		
		BTTSC4();
		maxs = tree.getMaximum();
		
		assertTrue(maxs.get(0) == 7);	 
		
		BTTSC5();
		maxs = tree.getMaximum();
		
		assertTrue(maxs.get(0) == 15);
	}
	
	@Test
	void testIsEmpty() throws Exception {
		BTTSC1();
		assertTrue(tree.isEmpty());
		
		BTTSC2();
		assertFalse(tree.isEmpty());
		
		BTTSC5();
		assertFalse(tree.isEmpty());
	}
}
