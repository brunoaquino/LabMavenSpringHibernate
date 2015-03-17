package br.com.servidor.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.servidor.spring")
public class AppConfig extends WebMvcConfigurerAdapter {

	// @Bean
	// public ViewResolver viewResolver() {
	// InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	// viewResolver.setViewClass(JstlView.class);
	// viewResolver.setPrefix("/WEB-INF/views/");
	// viewResolver.setSuffix(".jsp");
	// return viewResolver;
	// }
	//
	// @Bean
	// public MessageSource messageSource() {
	// ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	// messageSource.setBasename("messages");
	// return messageSource;
	// }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/jquery-ui/**").addResourceLocations("/resources/jquery-ui/").setCachePeriod(31556926);
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/resources/bootstrap/").setCachePeriod(31556926);
		registry.addResourceHandler("/extras/**").addResourceLocations("/resources/extras/").setCachePeriod(31556926);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
