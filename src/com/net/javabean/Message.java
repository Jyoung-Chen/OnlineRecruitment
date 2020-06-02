package com.net.javabean;

import java.util.List;

import com.google.gson.Gson;

public class Message {
	private List<Jobs> list;

	public Message(List<Jobs> list) {
		super();
		this.list = list;
	}
	public Message() {
		super();
		
	}

	public List<Jobs> getList() {
		return list;
	}
	public void setList(List<Jobs> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this);
	}
	
}
