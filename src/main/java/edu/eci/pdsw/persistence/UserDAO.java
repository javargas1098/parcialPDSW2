package edu.eci.pdsw.persistence;

import java.util.List;

import edu.eci.pdsw.entities.User;

public interface UserDAO {

	public List<User> loadAll() throws PersistenceException;
	
}
