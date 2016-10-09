package com.model.users;

import com.model.Storage;

@SuppressWarnings("serial")
public class FacAdmin extends User {

	public FacAdmin(String id, String name, String password) {
		super(id, name, password);
		Storage.users.add(this);

	}

}
