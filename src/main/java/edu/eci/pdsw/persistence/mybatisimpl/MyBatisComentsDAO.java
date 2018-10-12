package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.ComentsDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.ComentsMapper;




public class MyBatisComentsDAO implements ComentsDAO {

	@Inject
	ComentsMapper comentsMapper;
	
	
	public List<Comment> loadByComents(String title) throws PersistenceException {
		// TODO Auto-generated method stub
		return comentsMapper.findByComent(title);

	}

	
	public List<Comment> loadAllComments() throws PersistenceException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}


	@Override
	public List<Blog> OffensiveLanguage() throws PersistenceException {
		// TODO Auto-generated method stub
		return comentsMapper.findByOffensiveLanguage();
	}
}
