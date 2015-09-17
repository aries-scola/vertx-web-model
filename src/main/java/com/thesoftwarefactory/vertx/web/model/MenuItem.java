package com.thesoftwarefactory.vertx.web.model;

import java.util.Set;

public interface MenuItem {

	public Link link();
	
	public Set<MenuItem> children();

	public Set<String> roles();

	public Set<String> permissions();

	public MenuItem parent();

	public void parent(MenuItem parent);

	public MenuItem getByPath(String path);
	
}
