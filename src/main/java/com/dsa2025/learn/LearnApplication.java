package com.dsa2025.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	public static void print(int[] listToSort) {
		for (int el : listToSort) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public static void printString(String[] listToSort) {
		for (String el : listToSort) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public static void swap(int[] listToSort, int iIndex, int jIndex) {
		int temp = listToSort[iIndex];
		listToSort[iIndex] = listToSort[jIndex];
		listToSort[jIndex] = temp;

	}

}
