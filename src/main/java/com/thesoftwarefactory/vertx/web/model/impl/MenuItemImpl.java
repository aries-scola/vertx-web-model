package com.thesoftwarefactory.vertx.web.model.impl;

import java.util.Set;

import com.thesoftwarefactory.vertx.web.model.Link;
import com.thesoftwarefactory.vertx.web.model.MenuItem;

public class MenuItemImpl implements MenuItem {
	private Link link;
	private Set<MenuItem> children;
	private Set<String> roles;
	private Set<String> permissions;
	private MenuItem parent;
	
	@Override
	public Link link() {
		return link;
	}

	@Override
	public Set<MenuItem> children() {
		return children;
	}

	@Override
	public Set<String> roles() {
		return roles;
	}

	@Override
	public Set<String> permissions() {
		return permissions;
	}

	@Override
	public MenuItem parent() {
		return parent;
	}

	@Override
	public MenuItem getByPath(String path) {
		return null;
	}

}
