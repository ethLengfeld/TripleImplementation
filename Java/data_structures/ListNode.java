package data_structures;

public class ListNode {
	private String name;
	private ListNode successor;
	
	public ListNode() {
		this.name = null;
		this.successor = null;
	}
	
	public ListNode(String name) {
		this.name = name;
		this.successor = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ListNode getSuccessor() {
		return this.successor;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSuccessor(ListNode newNode) {
		this.successor = newNode;
	}
}
