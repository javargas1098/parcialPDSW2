/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services.impl;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.BlogDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.services.ServicesException;
import edu.eci.pdsw.services.BlogServices;
import java.util.List;

/**
 *
 * @author fchaves
 * @author salzate
 */
public class BlogServicesImpl implements BlogServices {

    @Override
	public List<Blog> listAll() throws ServicesException {
    	throw new UnsupportedOperationException("Not supported yet.");
	}

	@Inject
    private BlogDAO blogDAO;

	@Override
	public List<Comment> searchCommentsByBlogTitle(String title) throws ServicesException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Comment> searchOffensiveLanguageComments() throws ServicesException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Blog searchBlog(int blogID) throws ServicesException {
		try {
            return blogDAO.load(blogID);
        } catch (PersistenceException ex) {
            throw new ServicesException("Search error:"+ex.getLocalizedMessage(), ex);
        }
	}
   
}
