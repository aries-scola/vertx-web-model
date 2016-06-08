package com.thesoftwarefactory.vertx.web.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A modal window
 */
public class Popup {
	
	private String title;
	private String text;
	private Collection<String> additionalText = new ArrayList<>();
	private Link action;
	
	public Collection<String> getAdditionalText() {
		return additionalText;
	}

	public void setAdditionalText(Collection<String> additionalText) {
		this.additionalText = additionalText;
	}

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
