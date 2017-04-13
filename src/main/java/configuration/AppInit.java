package configuration;

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
        System.out.println(0);
        context.register(WebApp.class);
        System.out.println(1);
        servletContext.addListener(new ContextLoaderListener());
        System.out.println(2);
        context.setServletContext(servletContext);
        System.out.println(3);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        System.out.println(4);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        System.out.println(6);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        System.out.println(7);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(ROOT_MAPPING_VALUE);


    }
}
