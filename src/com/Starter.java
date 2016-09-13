package com;

import com.model.Storage;
import com.view.StudentProgressSystem;

public class Starter {

	public static void main(String[] args) {
		Storage.fetchStoredData();
		Storage.init();
		StudentProgressSystem.run();
		Storage.saveStoredData();
	}

}
