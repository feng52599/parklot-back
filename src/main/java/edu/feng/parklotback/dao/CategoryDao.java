package edu.feng.parklotback.dao;

import edu.feng.parklotback.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}