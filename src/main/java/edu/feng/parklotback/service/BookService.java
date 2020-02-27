package edu.feng.parklotback.service;

import edu.feng.parklotback.dao.BookDao;
import edu.feng.parklotback.pojo.Book;
import edu.feng.parklotback.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-01-12 10:43
 */



import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDao.findAllByCategory(category);
    }

    public List<Book> Search(String keywords) {
        return bookDao.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }

}


