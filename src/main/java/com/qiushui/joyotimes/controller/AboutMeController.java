package com.qiushui.joyotimes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutMeController {

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
