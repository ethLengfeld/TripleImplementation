package data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList implements List<ListNode> {
	private ListNode head;

	public LinkedList() {
		this.head = new ListNode();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<ListNode> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(ListNode e) {
		if(this.head.getSuccessor() == null) {
			this.head.setSuccessor(e);
			return true;
		}
		ListNode curr = this.head;
		while(curr.getSuccessor() != null) {
			curr = curr.getSuccessor();
		}
		curr.setSuccessor(e);
		
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends ListNode> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends ListNode> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListNode get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode set(int index, ListNode element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, ListNode element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListNode remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<ListNode> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<ListNode> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListNode> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode curr = this.head;
		while(curr.getSuccessor() != null) {
			curr = curr.getSuccessor();

			if(curr.getSuccessor() != null) {
				sb.append(curr.getName() + " -> ");
			} else {
				sb.append(curr.getName());
			}
			
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		List<ListNode> linkedList = new LinkedList();
		ListNode firstStudent = new ListNode("ethan");
		ListNode secondStudent = new ListNode("ethaniel");
		
		linkedList.add(firstStudent);
		linkedList.add(secondStudent);
		
		System.out.println(linkedList.toString());
	}
}
