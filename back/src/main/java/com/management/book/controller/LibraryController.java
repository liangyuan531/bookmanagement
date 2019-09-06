package com.management.book.controller;

import com.management.book.pojo.Book;
import com.management.book.pojo.Search;
import com.management.book.service.BookService;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/book")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        if(book != null){
            bookService.addOrUpdate(book);
            return book;
        }else {
            return null;
        }
    }

    @CrossOrigin
    @DeleteMapping("/delete/{bookId}")
    public void delete(@PathVariable("bookId") int bookId) throws Exception {
        bookService.deleteById(bookId);
    }

    @CrossOrigin
    @GetMapping("/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if(cid != 0) {
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }

    @CrossOrigin
    @PostMapping("/search")
    public List<Book> searchResult(@RequestBody Search s) throws Exception {
        System.out.println(s);
        if("".equals(s.getKeywords())){
            return bookService.list();
        }else {
            return bookService.search(s.getKeywords());
        }
    }
}
