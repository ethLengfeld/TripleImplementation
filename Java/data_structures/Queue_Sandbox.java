package data_structures;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue_Sandbox {
	
	public static void main(String args[]) {
//		Queue<String> queue = new PriorityQueue<>(); 
//		
//		queue.add("Ethan");
//		queue.add("Michael");
//		queue.add("Millie");
//		queue.add("Darko");
//		queue.add("Gina"); // Darko -> Ethan -> Millie -> Michael -> Gina
		
		Queue<Integer> queue = new PriorityQueue<>();
		
		queue.add(3);
		queue.add(11);
		queue.add(0);
		queue.add(11);
		queue.add(14);
		queue.add(7);
		
		Iterator<Integer> itr = queue.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next());
			if(itr.hasNext()) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
		int qSize = queue.size();
		for( int i = 0; i < qSize; i++) {
			System.out.print(queue.poll()+" ");
		}
		
	}
}
