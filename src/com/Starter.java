package com;

import com.model.Storage;
import com.view.StudentProgressSystem;

public class Starter {

	public static void main(String[] args) {
		StudentProgressSystem sps = new StudentProgressSystem();
		Storage.init();
		sps.run();
	}

}
