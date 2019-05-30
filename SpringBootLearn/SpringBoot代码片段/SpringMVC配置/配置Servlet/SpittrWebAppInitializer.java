// ͨ���̳�AbstractAnnotationConfigDispatchServletInitializer������DispatchServlet

package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatchServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatchServletInitializer{
	// ������ӳ��
	@Override
	protected String[] getServletMappings(){
		return new String[] {"/"};
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class<?>[] {RootConfig.class};
	}
	
	// ָ��������
	@Override
	protected Class<?>[] getServletConfigClasses(){
		return new Class<?>[] {WebConfig.class};
	}
}


// ��С�����õ�SpringMvc������
package spittr.config;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")

public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	// ����̬��Դ
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
			configurer.enable();
	}
}

// RootConfig.class
@Configuration
@ComponentScan(basePackages={"spittr"}, excludeFilter={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig{
	
}