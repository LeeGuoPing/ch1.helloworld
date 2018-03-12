package ch1.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch1.helloworld.entity.AuthorSettings;

@RestController
public class BookSafeController {
	
	@Autowired
	private AuthorSettings authorSettings;
	
	@RequestMapping("/booksafe")
	public String bookSafe(){
		return "name: "+authorSettings.getName()+", age: "+authorSettings.getAge();
	}
}
