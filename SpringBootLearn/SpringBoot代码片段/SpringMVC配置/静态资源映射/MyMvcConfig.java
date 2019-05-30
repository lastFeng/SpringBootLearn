@Configuration
@EnableWebMvc
@Component("xxx")
public class MyMvcConfig extends WebMvcConfigurationAdapter{
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/classes/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHanderRegistry registry){
	
		// ���ö��Ⱪ¶�ķ���·�����Լ��ļ����õ�Ŀ¼
		registry.addResorceHandler("/assets/**").addResourceLocations("classpath:/assets/")
	}
}