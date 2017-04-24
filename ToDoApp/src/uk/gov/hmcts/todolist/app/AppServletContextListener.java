package uk.gov.hmcts.todolist.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import org.apache.log4j.Logger;

public class AppServletContextListener extends GuiceServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(AppServletContextListener.class);
    public static Injector injector;

    @Override
    protected Injector getInjector() {
        LOGGER.info(" Getting injector.");

        injector = Guice.createInjector(new ServletModule() {
          
            @Override
            protected void configureServlets() {
                //    bind(Service.class);
            }
        });

        return injector;

    }
}