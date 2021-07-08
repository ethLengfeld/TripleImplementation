package data_structures;

import java.util.Arrays;

abstract class Heap {
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
	
	private void checkCapacity() {
		if (this.size == this.capacity) {
			this.elements = Arrays.copyOf(elements, this.capacity*2);
			this.capacity *= 2;
		}
	}
	
	public int peek() throws IllegalStateException {
		if (this.size ==0) throw new IllegalStateException();
		return this.elements[0];
	}
	
	public int poll() throws IllegalStateException {
		if (this.size ==0) throw new IllegalStateException();
		int pollElement = this.elements[0];
		this.elements[0] = this.elements[this.size-1];
		this.size--;
		this.heapifyDown();
		return pollElement;
	}
	
	public void add(int element) {
		checkCapacity();
		this.elements[this.size] = element;
		this.size++;
		this.heapifyUp();
	}
	
	private void heapifyDown() {
		int index = 0;
		while(this.hasLeftChild(index)) {
			int smallerChildIndex = this.getLeftChildIndex(index);
			if(this.hasRightChild(index) && this.rightChild(index) < this.leftChild(index)) {
				smallerChildIndex = this.getRightChildIndex(index);
			}
			
			if(this.elements[index] < this.elements[smallerChildIndex] ) {
				break;
			}
			else {
				this.swap(index, smallerChildIndex);
			}
		}
		
	}
	
	private void heapifyUp() {
		int index = this.size-1;
		while(this.hasParent(index) && parent(index) > this.elements[index]) {
			this.swap(index, this.getParentIndex(index));
			index = this.getParentIndex(index);
		}
	}
}
