package com.bookStore.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.BookStore.Entity.*;
import com.bookStore.BookStore.Service.BookService;
import com.bookStore.BookStore.Service.MyBookListService;
import com.bookStore.BookStore.Service.MyCartListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@Autowired
	private MyCartListService myCartService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@GetMapping("/adminHome")
	public ModelAndView adminHome() {
		return new ModelAndView("adminHome");
	}
	
	
	@GetMapping("/book_register")
	public ModelAndView bookRegister(@ModelAttribute("user") Book book) {
		return new ModelAndView("bookRegister");
	}
	@GetMapping("/checkout")
	public ModelAndView checkout() {
		return new ModelAndView("checkout");
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
		return new ModelAndView("bookList","book",list);
	}
	
	@GetMapping("/admin_available_books")
	public ModelAndView getAllBooks() {
		List<Book>list=service.getAllBook();
		return new ModelAndView("adminbookList","book",list);
	
	}
	@PostMapping("/save")
	public ModelAndView addBook(@ModelAttribute Book b) {
		service.save(b);
		List<Book>list=service.getAllBook();
		return new ModelAndView("adminbookList","book",list);
		
	}
	@GetMapping("/my_books")
	public ModelAndView getMyBooks()
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		return new ModelAndView("myBooks","book",list);
	}
	
	@GetMapping("/my_cart")
	public ModelAndView getMyCart()
	{

		List<MyCartList>cartlist=myCartService.getAllMyBooks();
		
		return new ModelAndView("myCart","book",cartlist);
	}
	
	@GetMapping("/mylist/{id}")
	public ModelAndView getMyList(@PathVariable("id") String id, Model model) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		List<MyBookList> list = myBookService.getAllMyBooks();
		return new ModelAndView("myBooks","book",list);
	}
	
	@GetMapping("/myCartlist/{id}")
	public ModelAndView getMyCartList(@PathVariable("id") String id) {
		Book b=service.getBookById(id);
		MyCartList myCartBooks =new MyCartList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myCartService.saveMyBooks(myCartBooks);
		return new ModelAndView("myCart","book",myCartBooks);
	}
	
	@GetMapping("/editBook/{id}")
	public ModelAndView editBook(@PathVariable("id") String id,Model model) {
		Book b=service.getBookById(id);
		/*
		 * model.addAttribute("book",b); return "bookEdit";
		 */
		return new ModelAndView("bookEdit","book",b);
		
	}
	@RequestMapping("/deleteBook/{id}")
	public ModelAndView deleteBook(@PathVariable("id")String id) {
		service.deleteById(id);
		return new ModelAndView("adminbookList");
	}
	
}
