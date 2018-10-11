/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.tests;

import edu.eci.pdsw.entities.User;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.BlogServicesFactory;
import edu.eci.pdsw.services.ServicesException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.List;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.lists;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 *
 * @author hcadavid
 */
public class BlogServicesTest {

    @Inject
    private SqlSession sqlSession;

    BlogServices blogServices;

    
    public BlogServicesTest() {
    	this.blogServices = BlogServicesFactory.getInstance().getBlogServicesTesting();
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
    	/*
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from BLOG");
        stmt.execute("delete from BLOG_USUARIO");
        stmt.execute("delete from BLOG_COMMENT");
        conn.commit();
        conn.close();
        */
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    /*
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
    }
    */
    
    @Test
    public void pruebaCeroTest() throws SQLException, ServicesException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

    	qt().forAll(lists().of(Generators.users()).ofSizeBetween(1, 5))
    		.check((users) -> {
    	    	Connection conn = null;
				try {
					conn = getConnection();
	    			
					String query = "INSERT INTO `BLOG_USUARIO` (`login`, `name`, `lastname`) VALUES (?,?,?)";

					Hashtable<String, User> usersMap = new Hashtable<>();
					for(User user : users) {
						PreparedStatement st = conn.prepareStatement(query);
						st.setString(1, user.getLogin());
						st.setString(2, user.getName());
						st.setString(3, user.getLastName());
						int rowsAffected = st.executeUpdate();
						if (rowsAffected == 0) {
							throw new SQLException("User not created");
						}
						usersMap.put(user.getLogin(),user);
						st.close();
					}
					
					
					
					
				    // Clear inserted records	
	    	        conn.rollback();
	    			return true;
	    		} catch (SQLException e) {
					e.printStackTrace();
					return false;
				} finally {
					if (conn != null) {
						try {
	    	                conn.close();
						} catch(SQLException e) {
							e.printStackTrace();
							return false;
						}
					}
				}
    	    });
    	


	
        //Realizar la operacion de la logica y la prueba
        
        
//        List<Paciente> pacientes = ServiciosPacientesFactory.getInstance().getTestingForumServices().consultarPacientes();

        
//        for (Paciente paciente : pacientes){
//            System.out.println(paciente);
//        }
        //assert ...
        // Assert.fail("Pruebas no implementadas aun...");
        
    }    
    

}
