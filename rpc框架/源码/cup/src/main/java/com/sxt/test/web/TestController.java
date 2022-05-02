package com.sxt.test.web;

import com.sxt.core.anno.Inject;
import com.sxt.test.service.TestService;

public class TestController {

	@Inject
	private TestService service;
}
