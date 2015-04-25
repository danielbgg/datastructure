package br.com.danielbgg.examples.tree;

public class BinarySearchTree {

	// depth-first
	public enum TraversalType {
		PRE_ORDER_SCAN_NLR, IN_ORDER_SCAN_LNR, POST_ORDER_SCAN_LRN
	};

	private BinaryNode root;

	public BinarySearchTree() {
	}
	
	protected BinaryNode getRoot() {
		return root;
	}
	
	protected void setRoot(BinaryNode root) {
		this.root = root;
	}

	public boolean insert(Integer data) {
		if (data == null) {
			return false;
		}
		BinaryNode bn = new BinaryNode(data);
		if (root == null) {
			root = bn;
		} else {
			BinaryRelationship rel = findNode(data);
			BinaryNode child = (rel == null) ? null : rel.getChild();
			if (child == null || child.getValue().equals(data)) {
				return false;
			}
			if (data.intValue() < child.getValue().intValue()) {
				child.setLeftChild(bn);
			} else {
				child.setRightChild(bn);
			}
		}
		return true;
	}

	private BinaryRelationship findNode(Integer data) {
		if (root == null) {
			return null;
		} else {
			return findNode(root, root, data);
		}
	}

	private BinaryRelationship findNode(BinaryNode bn, BinaryNode parent, Integer data) {
		if (data.intValue() == bn.getValue().intValue()) {
			return new BinaryRelationship(parent, bn);
		}
		if (data.intValue() < bn.getValue().intValue()) {
			if (bn.getLeftChild() == null) {
				return new BinaryRelationship(parent, bn);
			} else {
				return findNode(bn.getLeftChild(), bn, data);
			}
		} else if (data.intValue() > bn.getValue().intValue()) {
			if (bn.getRightChild() == null) {
				return new BinaryRelationship(parent, bn);
			} else {
				return findNode(bn.getRightChild(), bn, data);
			}
		}
		return null;
	}

	public BinaryNode fetch(Integer data) {
		BinaryRelationship rel = findNode(data);
		return (rel == null) ? null : rel.getChild().getValue().equals(data) ? rel.getChild() : null;
	}

	public boolean delete(Integer data) {
		BinaryRelationship rel = findNode(data);
		BinaryNode bn = rel.getChild();
		BinaryNode parent = rel.getParent();
		if (bn == null) {
			return false;
		}

		if (bn.getLeftChild() == null && bn.getRightChild() == null) {
			// case 1
			if (parent.getLeftChild().getValue().equals(data)) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
			return true;

		}

		if ((bn.getLeftChild() == null && bn.getRightChild() != null) || (bn.getLeftChild() != null && bn.getRightChild() == null)) {
			// case 2
			if (parent.getLeftChild().equals(bn)) {
				// deleted note is a left child - 2a or 2b
				if (bn.getLeftChild() != null) {
					// case 2a
					parent.setLeftChild(bn.getLeftChild());
				} else {
					// case 2b
					parent.setLeftChild(bn.getRightChild());
				}
			} else {
				// case 2c or 2d
				if (bn.getLeftChild() != null) {
					// case 2c
					parent.setRightChild(bn.getLeftChild());
				} else {
					// case 2d
					parent.setRightChild(bn.getRightChild());
				}
			}
			return true;
		}

		if (bn.getLeftChild() != null && bn.getRightChild() != null) {
			// case 3
			BinaryNode nextLargest = bn.getLeftChild();
			BinaryNode largest = nextLargest.getRightChild();
			if (largest != null) {
				// case 3a or 3b
				while (largest.getRightChild() != null) {
					// move down the right edge of right subtree
					nextLargest = largest;
					largest = largest.getRightChild();
				}
				// replacement has been located
				bn.setValue(largest.getValue());
				// save left subtree of the relocated node
				nextLargest.setRightChild(largest.getLeftChild());
			} else {
				// case 3c or 3d
				nextLargest.setRightChild(bn.getRightChild());
				if (parent.getLeftChild().getValue().equals(bn.getValue())) {
					parent.setLeftChild(nextLargest);
				} else {
					parent.setRightChild(nextLargest);
				}
			}
			return true;
		}

		return false;

	}

	public boolean update(Integer oldData, Integer newData) {
		if (delete(oldData)) {
			return insert(newData);
		}
		return false;
	}

	public int treeHeight(BinaryNode bn) {
		if (bn == null) {
			return 0;
		}
		return 1 + Math.max(treeHeight(bn.getLeftChild()), treeHeight(bn.getRightChild()));
	}
	
	public BinaryNode findLowestCommonAncestor(int value1, int value2) {
		BinaryNode b = root;
		while (b != null) {
			int value = b.getValue().intValue();
			if (value > value1 && value > value2) {
				b = b.getLeftChild();
			} else if (value < value1 && value < value2) {
				b = b.getRightChild();
			} else {
				return b;
			}
		}
		return null;
	}

	public void showAll(TraversalType type) {
		if (root == null) {
			System.out.println("Empty tree");
			return;
		}
		if (type == null) {
			return;
		} else if (type == TraversalType.PRE_ORDER_SCAN_NLR) {
			System.out.println("PRE ORDER SCAN NLR - Show All");
			showAllNLR(root);
		} else if (type == TraversalType.IN_ORDER_SCAN_LNR) {
			System.out.println("IN ORDER SCAN LNR - Show All");
			showAllLNR(root);
		} else if (type == TraversalType.POST_ORDER_SCAN_LRN) {
			System.out.println("POST ORDER SCAN LRN - Show All");
			showAllLRN(root);
		}
	}

	private void visit(BinaryNode bn) {
		System.out.println("Found: " + bn.getValue());
	}

	/*
	 * left, root, right
	 */
	private void showAllLNR(BinaryNode bn) {
		if (bn.getLeftChild() != null) {
			showAllLNR(bn.getLeftChild());
		}
		visit(bn);
		if (bn.getRightChild() != null) {
			showAllLNR(bn.getRightChild());
		}
	}

	/*
	 * root, left, right
	 */
	private void showAllNLR(BinaryNode bn) {
		visit(bn);
		if (bn.getLeftChild() != null) {
			showAllNLR(bn.getLeftChild());
		}
		if (bn.getRightChild() != null) {
			showAllNLR(bn.getRightChild());
		}
	}

	/*
	 * left, right, root
	 */
	private void showAllLRN(BinaryNode bn) {
		if (bn.getLeftChild() != null) {
			showAllLRN(bn.getLeftChild());
		}
		if (bn.getRightChild() != null) {
			showAllLRN(bn.getRightChild());
		}
		visit(bn);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		assert bst.insert(50) == true;
		assert bst.insert(40) == true;
		assert bst.insert(60) == true;
		assert bst.insert(60) == false;
		assert bst.insert(20) == true;
		assert bst.insert(45) == true;
		assert bst.insert(55) == true;
		assert bst.insert(65) == true;

		assert bst.fetch(60) != null;
		assert bst.fetch(60).getValue().equals(60);
		assert bst.fetch(70) == null;

		assert bst.treeHeight(bst.root) == 3;
		
		bst.showAll(TraversalType.PRE_ORDER_SCAN_NLR);
		assert bst.update(40, 41) == true;
		bst.showAll(TraversalType.PRE_ORDER_SCAN_NLR);

		assert bst.delete(65) == true;
		assert bst.delete(60) == true;
		assert bst.delete(40) == true;
		bst.showAll(TraversalType.PRE_ORDER_SCAN_NLR);
		
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(20);
		bst2.insert(8);
		bst2.insert(22);
		bst2.insert(4);
		bst2.insert(12);
		bst2.insert(10);
		bst2.insert(14);
		System.out.println(bst2.treeHeight(bst2.root));
		System.out.println(bst2.findLowestCommonAncestor(4, 14));
	}

}
