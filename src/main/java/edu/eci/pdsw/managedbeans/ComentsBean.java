/*
 * Copyright (C) 2016 salzate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.sun.mail.imap.protocol.ID;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.entities.User;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.ServicesException;

/**
 *
 * @author salzate
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "comentsBean")
@RequestScoped
public class ComentsBean extends BasePageBean {
	@ManagedProperty(value = "#{param.title}")
	private String title;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;
	private List<Comment> coments;

	@Inject
	private BlogServices blogServices;

	public List<Comment> getBlog() throws Exception {
		try {

			List<Comment> c = blogServices.searchCommentsByBlogTitle(title);
			System.out.println(c);
			if (title == null) {
				return blogServices.listAllComments();
			} else {
				return blogServices.searchCommentsByBlogTitle(title);
			}

		} catch (ServicesException ex) {

			throw ex;
		}
	}

	public String getTitle() {
		return title;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public List<Blog> getBad() throws Exception {
		try {
			List<Blog> c = blogServices.searchOffensiveLanguageComments();
			System.out.println(c);

			return blogServices.searchOffensiveLanguageComments();

		} catch (

		ServicesException ex) {

			throw ex;
		}
	}

	public List<Comment> getComents(String title) throws Exception {
		try {
			List<Blog> lista = blogServices.searchOffensiveLanguageComments();
			for (Blog blog : lista) {
				if (blog.getTitle().equals(title)) {
					coments = blog.getComments();
					break;

				}

			}

			return coments;

		} catch (

		ServicesException ex) {

			throw ex;
		}
	}

}
