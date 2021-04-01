package data_structures;

public class Tree implements TreeInterface {

	private TreeNode root = null;
	private int height = -1;

	public Tree(TreeNode node, int height) {
		this.root = node;
		this.height = height;
	}

	@Override
	public void getDepth() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTreeBoustrophedonOrder(TreeNode node) {
		int treeHeight = this.getHeight();

		for (int i = 1; i <= treeHeight; i++) {

			if (i % 2 == 0) {
				this.getNodeValsAtLevel(this.root, i, true);
			} else {
				this.getNodeValsAtLevel(this.root, i, false);
			}
		}
	}

	private void getNodeValsAtLevel(TreeNode root, int level, boolean readRightToLeft) {

		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.getIntValue() + " ");
		} else if (level > 1) {
			if (readRightToLeft) {
				this.getNodeValsAtLevel(root.getRightChild(), level - 1, readRightToLeft);
				this.getNodeValsAtLevel(root.getLeftChild(), level - 1, readRightToLeft);
			} else {
				this.getNodeValsAtLevel(root.getLeftChild(), level - 1, readRightToLeft);
				this.getNodeValsAtLevel(root.getRightChild(), level - 1, readRightToLeft);
			}
		}
	}

	public TreeNode getRoot() {
		return this.root;
	}

	public int getHeight() {
		return this.height;
	}

	public static void main(String[] args) {

		TreeNode n1 = new TreeNode(1);

		TreeNode n2 = new TreeNode(2);
		n2.setLeftChild(new TreeNode(4));
		n2.setRightChild(new TreeNode(5));

		TreeNode n3 = new TreeNode(3);
		n3.setLeftChild(new TreeNode(6));
		n3.setRightChild(new TreeNode(7));

		n1.setLeftChild(n2);
		n1.setRightChild(n3);

		Tree tree = new Tree(n1, 3);
		tree.printTreeBoustrophedonOrder(tree.getRoot());

	}

}
