package data_structures;

public class TreeNode {

	private int intValue = -1;
	private String strValue = null;
	private TreeNode rightChild = null;
	private TreeNode leftChild = null;
	
	public TreeNode() {
		this.strValue = "Empty Node";
	}
	public TreeNode(int value) {
		this.intValue = value;
	}
	public TreeNode(String value) {
		this.strValue = value;
	}
	
	public int getIntValue() {
		return this.intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public String getStrValue() {
		return this.strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	public TreeNode getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
}
