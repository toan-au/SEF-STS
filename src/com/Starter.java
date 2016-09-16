package com;

import com.model.Storage;
import com.view.StudentProgressSystem;

public class Starter {

	public static void main(String[] args) {
		init();
		StudentProgressSystem.run();
		cleanUp();
	}

	private static void init(){
//		Storage.fetchStoredData();
		Storage.init();
		
	}
	
	private static void cleanUp(){
//		Storage.saveStoredData();
		
	}
	
	
	/* students should get their ID assigned, not set, if students have the same name and brithdate, ask the creator if he's sure
	 * storage shouldn't have that init method. it should be in starter
	 */
	
}
