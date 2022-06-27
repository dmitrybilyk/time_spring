package com.learn.bases.forkjoin;

public class Main {
	public static void main(String[] args) {
//		new CustomRecursiveAction("some string").compute();

		int[] arr = {5, 6, 7, 3, 20};
		CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);
		System.out.println(customRecursiveTask.compute());
	}
}
