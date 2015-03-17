package br.com.servidor.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	// public void onStartup(ServletContext container) throws ServletException {
	//
	// AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	// ctx.register(AppConfig.class);
	// ctx.setServletContext(container);
	//
	// ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
	//
	// servlet.setLoadOnStartup(1);
	// servlet.addMapping("/");
	// }

	public void onStartup(ServletContext arg0) throws ServletException {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		// Manage the lifecycle of the root application context
		// container.addListener(new ContextLoaderListener(rootContext));
		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherConfig.class);
		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = arg0.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
