package uk.gov.hmcts.todolist.app;

import org.apache.log4j.Logger;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import javax.inject.Inject;


public class TodoListApp  extends ResourceConfig {

    private static final Logger LOGGER = Logger.getLogger(TodoListApp.class);

    @Inject
    public TodoListApp(ServiceLocator serviceLocator) {
        // Set package to look for resources in
        packages("uk.gov.hmcts.todolist.app", "com.fasterxml.jackson.jaxrs.base");
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(AppServletContextListener.injector);

    }
}