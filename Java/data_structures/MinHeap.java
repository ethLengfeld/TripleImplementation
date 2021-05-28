package data_structures;

public class MinHeap {
	private int capacity = 10;
	private int size = 0;
	int[] elements = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex) {
		return (2*parentIndex) + 1;
	}
	private int getRightChildIndex(int parentIndex) {
		return (2*parentIndex) + 2;
	}
	private int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	private boolean hasLeftChild(int index) {
		return this.getLeftChildIndex(index) < this.size;
	}
	private boolean hasRightChild(int index) {
		return this.getRightChildIndex(index) < this.size;
	}
	private boolean hasParent(int index) {
		return this.getParentIndex(index) >= 0;
	}
	
	private int leftChild(int index) {
		return this.elements[this.getLeftChildIndex(index)];
	}
	private int rightChild(int index) {
		return this.elements[this.getRightChildIndex(index)];
	}
	private int parent(int index) {
		return this.elements[this.getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = this.elements[indexOne];
		this.elements[indexOne] = this.elements[indexTwo];
		this.elements[indexTwo] = temp;
	}
}
