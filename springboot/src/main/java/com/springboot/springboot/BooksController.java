package com.springboot.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BooksController {
    public static List<Book> books = new ArrayList<>();
    public static Book book;

    public BooksController() {
        addBooks();

    }

    public static void addBooks(){
         book = new Book(1l, "Journey", "Rukon");
        book.addMeta(new Meta("1", "meta 1"));
        book.addMeta(new Meta("3", "meta 3"));
         books.add(book);



        book = new Book(2l, "Journey 2", "Rukon 2");
        book.addMeta(new Meta("3", "meta 2"));
        books.add(book);

        book = new Book(3l, "Journey 3", "Rukon 2");
        book.addMeta(new Meta("3", "meta 2"));
        books.add(book);

        book = new Book(4l, "Journey 4", "Rukon 2");
        book.addMeta(new Meta("1", "meta 4"));
        books.add(book);
    }

@RequestMapping("/books")
    public String  getBooks(Model model){


    model.addAttribute("books", books);


    return "book";//rrays.asList(new Book(1l, "Journey", "Rukon"));
}

@GetMapping("/book2")
    public String getBook(){
        addBooks();
   // System.out.println(book.getClass().getClassLoader().);
    return "index";
}

@RequestMapping("/addBook")
    public String getBook3(){

        return "book";
}

}
