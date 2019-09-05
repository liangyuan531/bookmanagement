package com.management.book.controller;

import com.management.book.pojo.Book;
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

    @GetMapping("/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/book")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if(cid != 0) {
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }
}
