package edu.eci.pdsw.services;


import java.util.List;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;

public interface BlogServices {

    /**
     * Consultar todos los comentarios a partir de un título de un blog
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<Comment> searchCommentsByBlogTitle(String title) throws ServicesException;


    /**
     * Consultar todos los comentarios con lenguaje ofensivo
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<Comment> searchOffensiveLanguageComments() throws ServicesException;
    
    /**
     * Consultar un blog con sus comentarios por el id del blog
     * @return el blog
     * @throws ServicesException 
     */
    public Blog searchBlog(int blogID) throws ServicesException;

}
