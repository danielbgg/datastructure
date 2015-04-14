package br.com.danielbgg.datastructure.tree;

public class AVLTree extends BinarySearchTree {

	public BinaryNode rotateRight(BinaryNode oldRoot) {
		BinaryNode newRoot = oldRoot.getLeftChild();
		oldRoot.setLeftChild(newRoot.getRightChild());
		newRoot.setRightChild(oldRoot);
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
