package utils;

import java.util.List;

public class ArrayUtils {

	public static void printIntArray(int[] array) {
		System.out.print("[ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("]");
	}
	
	public static String getIntArray(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i != array.length-1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static String printArray(List<String> array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < array.size(); i++) {
			sb.append(array.get(i));
			if(i != array.size()-1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
