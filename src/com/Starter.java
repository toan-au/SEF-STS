package com;

import java.util.Scanner;

import com.model.Storage;
import com.view.StudentProgressSystem;

//FINISHED
public class Starter {

	public static void main(String[] args) {
		Storage.fetchStoredData();
		Global.scanner = new Scanner(System.in);
		StudentProgressSystem.run();
		Global.scanner.close();
		Storage.saveStoredData();
	}
}
