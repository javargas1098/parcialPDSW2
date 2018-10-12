package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;

public interface ComentsMapper {
	List<Comment> findByComent(@Param("Title") String Title);

	List<Blog> findByOffensiveLanguage();

}
