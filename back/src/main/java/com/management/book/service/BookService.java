package com.management.book.service;

import com.management.book.dao.BookDao;
import com.management.book.dao.CategoryDao;
import com.management.book.pojo.Book;
import com.management.book.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int id) {
        Category category = categoryService.get(id);
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDao.findAllByCategory(category);
    }

    public List<Book> search(String keywords) {
        return bookDao.findAllByTitleLikeOrAuthorLike('%'+keywords+'%', '%'+keywords+'%');
    }
}
