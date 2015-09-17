package com.thesoftwarefactory.vertx.web.model;

import static org.junit.Assert.*;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestCharsetAwareResourceControl {

	@Test
	public void test() {
		CharsetAwareResourceControl control = new CharsetAwareResourceControl(StandardCharsets.UTF_8);
		ResourceBundle bundle = ResourceBundle.getBundle("test", Locale.FRANCE, control);
		assertTrue(bundle!=null);

		assertEquals(bundle.getString("name1"), "value 1");
		assertEquals(bundle.getString("name2"), "value 2");
		assertEquals(bundle.getString("name3"), "valeur 3");

		assertEquals(bundle.getString("nestedname1"), "nested value 1");
		assertEquals(bundle.getString("nestedname2"), "nested value 2");
		assertEquals(bundle.getString("nestedname3"), "nested valeur 3");
}

}
