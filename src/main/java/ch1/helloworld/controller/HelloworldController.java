package ch1.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {
	
	@RequestMapping("/sayhello.html")
	public @ResponseBody String say(String name){
		return "hello"+name;
	}
}
