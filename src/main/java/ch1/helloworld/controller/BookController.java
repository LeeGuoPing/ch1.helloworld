package ch1.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Value("${book.author}")
	private String bookAuthor;
	
	@Value("${book.name}")
	private String bookName;
	
	@RequestMapping("/book")
	public String getBook(){
		return "bookAuthor: "+bookAuthor+", bookName: "+bookName;
	}
}
