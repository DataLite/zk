package org.zkoss.zktest.zats.bind.issue;

import static org.junit.Assert.*;

import jakarta.validation.constraints.AssertTrue;

import org.junit.Test;
import org.zkoss.zktest.zats.ZATSTestCase;

public class B01016NestedFormTest extends ZATSTestCase {
	@Test
	public void test() {
		try {
			connect();
		} catch (Exception e) {
			assertTrue(e.getCause().toString().contains("UiException: doesn't support to load a nested form"));
		}
	}
}
