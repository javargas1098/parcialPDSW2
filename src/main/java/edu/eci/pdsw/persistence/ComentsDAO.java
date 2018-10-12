package edu.eci.pdsw.persistence;

import java.util.List;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;

public interface ComentsDAO {

	public List<Comment> loadByComents(String title) throws PersistenceException;

	public List<Comment> loadAllComments() throws PersistenceException;

	public List<Blog> OffensiveLanguage() throws PersistenceException;
}