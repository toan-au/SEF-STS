package com;

import com.model.Storage;
import com.view.StudentProgressSystem;

public class Starter {

	public static void main(String[] args) {
		Storage.init();
		StudentProgressSystem.run();
	}

}
