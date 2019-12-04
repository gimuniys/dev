package com.gmail.gimuniys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmail.gimuniys.util.HttpUsageCall;
import com.google.gson.JsonObject;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/cors", method=RequestMethod.GET)
	public String cors() {
		return "cors";
	}

	@RequestMapping(value="/client")
	public String httpClient(Model model) {
		//HttpUsageCall.get("http://localhost:81/test");
		
		Map<String, Object> map = new HashMap<>();
		map.put("test", "테스트중입니다.");
		
		JsonObject postResult = HttpUsageCall.post("http://localhost:81/test", map);
		//if(postResult.isJsonNull("result"))
		model.addAttribute("result", postResult);
		
		return "httpClient";
	}
}
