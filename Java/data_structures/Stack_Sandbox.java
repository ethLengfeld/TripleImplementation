package data_structures;

import java.util.Arrays;
import java.util.Stack;

public class Stack_Sandbox {
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("Ethan");
		stack.push("Michael");
		stack.push("Millie");
		stack.push("Darko");
		stack.push("Gina");
		System.out.println(Arrays.toString(stack.toArray())); // Gina | Darko | Millie | Michael | Ethan
		System.out.println("Removed from stack:"+stack.pop()); // Gina
		System.out.println(Arrays.toString(stack.toArray())); // Darko | Millie | Michael | Ethan
		System.out.println("Removed from stack:"+stack.pop()); // Darko
		System.out.println(Arrays.toString(stack.toArray())); // Millie | Michael | Ethan
	}
}