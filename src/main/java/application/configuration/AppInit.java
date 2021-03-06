package application.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by nazar on 10.04.17.
 *
 */
public class AppInit implements WebApplicationInitializer{
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String ROOT_MAPPING_VALUE = "/";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
       // context.setConfigLocation("config");
        context.register(WebApp.class);

        servletContext.addListener(new ContextLoaderListener());

        context.setServletContext(servletContext);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(ROOT_MAPPING_VALUE);
      //  context.scan("WebApp");


    }


}
