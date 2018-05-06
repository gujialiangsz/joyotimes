package com.qiushui.joyotimes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToolController {

	@RequestMapping("/tool/{type}/{item}")
	public String tool(@PathVariable String type,@PathVariable String item,Model model) {
		model.addAttribute("type", type);
		model.addAttribute("item", item);
		return "tool/"+type;
	}
}