package com.thesoftwarefactory.vertx.web.model;

/**
 * A modal window
 */
public class Popup {
	
	private String title;
	private String text;
	private Link action;
	
	public String getTitle() {
		return title;
	}

	public Popup setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getText() {
		return text;
	}
	
	public Popup setText(String text) {
		this.text = text;
		return this;
	}
	
	public Link getAction() {
		return action;
	}
	
	public Popup setAction(Link action) {
		this.action = action;
		return this;
	}
}
