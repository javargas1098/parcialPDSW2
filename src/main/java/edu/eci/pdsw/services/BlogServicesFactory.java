package edu.eci.pdsw.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Injector;

import edu.eci.pdsw.persistence.BlogDAO;
import edu.eci.pdsw.persistence.UserDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisBlogDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisUserDAO;

public class BlogServicesFactory {

	private static BlogServicesFactory instance = new BlogServicesFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(BlogDAO.class).to(MyBatisBlogDAO.class);
            }
        });
    }

    private BlogServicesFactory() {
		optInjector = Optional.empty();
    }

    public BlogServices getBlogServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(BlogServices.class);
    }


    public BlogServices getBlogServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(BlogServices.class);
    }



    public static BlogServicesFactory getInstance(){
        return instance;
    }

}
