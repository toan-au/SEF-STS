package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacAdminTest {

	@Test
	public void test() {
		FacAdmin facAd1 = new FacAdmin("s3514782", "Ana Teo", "password");
                String facAd1Id = facAd1.getId();
                String facAd1Name = facAd1.getName();
                String facAd1Pass = facAd1.getPassword(); 
                
                assertEquals("s351478", facAd1Id);
                assertEquals("Ana Teo", facAd1Name);
                assertEquals("password", facAd1Pass);
	}

}
