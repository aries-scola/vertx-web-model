package com.thesoftwarefactory.vertx.web.model;

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;

/**
 * test class for {@link Form}
 */
public class FormTest {
	
	protected static class Bean {
		
		private String prop1;
		private Instant prop2;
		private boolean prop3;
		
		public boolean isProp3() {
			return prop3;
		}

		public void setProp3(boolean prop3) {
			this.prop3 = prop3;
		}

		public String getProp1() {
			return prop1;
		}

		public void setProp1(String prop1) {
			this.prop1 = prop1;
		}

		public Instant getProp2() {
			return prop2;
		}

		public void setProp2(Instant prop2) {
			this.prop2 = prop2;
		}
	}

	@Test
	public void test() {
		
		Bean bean = new Bean();
		bean.setProp1("val1");
		bean.setProp2(Instant.parse("2015-12-11T16:00:00Z"));
		bean.setProp3(true);
		Form<Bean> form = Form.fromBean(bean, "prefix.");
		
		assertEquals("val1", form.field("prefix.prop1").value());
		assertEquals("11/12/2015", form.field("prefix.prop2").value());
		assertEquals("true", form.field("prefix.prop3").value());
		
	}

}
