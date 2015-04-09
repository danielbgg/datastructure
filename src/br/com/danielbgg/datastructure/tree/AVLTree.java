package br.com.danielbgg.datastructure.tree;

public class AVLTree extends BinarySearchTree {

	public BinaryNode rotateRight(BinaryNode oldRoot) {
		//old root = 6
		BinaryNode newRoot = oldRoot.getLeftChild();
		//new root = 4
		oldRoot.setLeftChild(newRoot.getRightChild());
		//old root = 6, left child = 5
		newRoot.setRightChild(oldRoot);
		//new root = 4, right child = 6
		return newRoot;
	}

	public static void main(String[] args) {
		AVLTree avl = new AVLTree();
		avl.insert(6);
		avl.insert(4);
		avl.insert(2);
		avl.insert(1);
		avl.insert(5);
		avl.insert(3);
		avl.insert(7);
		System.out.println(avl.treeHeight(avl.getRoot()));
		avl.showAll(TraversalType.PRE_ORDER_SCAN_NLR);

		avl.setRoot(avl.rotateRight(avl.getRoot()));
		System.out.println(avl.treeHeight(avl.getRoot()));
		avl.showAll(TraversalType.PRE_ORDER_SCAN_NLR);
	}

}
