package edu.feng.parklotback.dao;

import edu.feng.parklotback.pojo.Book;
import edu.feng.parklotback.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {
        List<Book> findAllByCategory(Category category);
        List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
        }