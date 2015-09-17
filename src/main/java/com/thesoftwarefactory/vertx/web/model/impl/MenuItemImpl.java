package com.thesoftwarefactory.vertx.web.model.impl;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import com.thesoftwarefactory.vertx.web.model.Link;
import com.thesoftwarefactory.vertx.web.model.MenuItem;

public class MenuItemImpl implements MenuItem {
	private Set<MenuItem> children;
	private Link link;
	private MenuItem parent;
	private Set<String> permissions;
	private Set<String> roles;
	
	public MenuItemImpl(Link link) {
		Objects.requireNonNull(link);
		
		this.link = link;
	}
	
	@Override
	public Set<MenuItem> children() {
		if (children==null) {
			children = new TreeSet<MenuItem>() {
				private static final long serialVersionUID = -358488236862298675L;

				@Override
				public boolean add(MenuItem menuItem) {
					boolean result = super.add(menuItem);
					if (result) {
						reparent(menuItem);
					}
					return result;
				}

				@Override
				public boolean addAll(Collection<? extends MenuItem> menuItems) {
					boolean result = super.addAll(menuItems);
					if (result) {
						// reparent each menu item
						for (MenuItem menuItem: menuItems) {
							reparent(menuItem);
						}
					}
					return result;
				}
				
			};
		}
		return children;
	}

	private MenuItem getRootMenu(MenuItem menuItem) {
		MenuItem result = menuItem;
		while (menuItem!=null) {
			menuItem = menuItem.parent();
		}
		return result;
	}
	
	@Override
	public MenuItem getByUrl(String url) {
		Objects.requireNonNull(url);
		
		MenuItem rootItem = getRootMenu(this);
		if (rootItem!=null) {
			// depth-first search
			Deque<MenuItem> stack = new ArrayDeque<>();
			stack.addFirst(rootItem);
			while (!stack.isEmpty()) {
				MenuItem currentItem = stack.removeFirst();
				// found the item, get out
				if (url.equals(currentItem.link().getUrl())) {
					return currentItem;
				}
				else {
					// push all children into the stack
					currentItem.children().forEach(child -> stack.addFirst(child));
				}
			}
		}
		return null;
	}

	
	@Override
	public Link link() {
		return link;
	}

	@Override
	public MenuItem parent() {
		return parent;
	}

	@Override
	public MenuItem parent(MenuItem parent) {
		this.parent = parent;
		return this;
	}
	
	@Override
	public Set<String> permissions() {
		if (permissions==null) {
			permissions = new HashSet<>();
		}
		return permissions;
	}

	private void reparent(MenuItem menuItem) {
		// remove the item from its current parent if any
		if (menuItem.parent()!=null) {
			menuItem.parent().children().remove(menuItem);
		}
		// set it new parent
		menuItem.parent(this);
	}

	@Override
	public Set<String> roles() {
		if (roles==null) {
			roles = new HashSet<>();
		}
		return roles;
	}

}
