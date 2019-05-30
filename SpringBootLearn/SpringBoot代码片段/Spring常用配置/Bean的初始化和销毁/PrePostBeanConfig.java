/**
* Java���ã�ʹ��@Bean��initMethod��destroyMethod�������ö���ķ���
* ע�����ã�����JSR250��@PostConstruct��@PreDestroy�ڷ����Ͻ���ע��------  dependency������jsr-250-api
**/

// @Bean ��ʽ
class BeanWayService{
	public void init(){
		System.out.println("@Bean-init-method");
	}
	
	public void destroy(){
		System.out.println("@Bean-destroy-method");
	}
}

// JSR250��ʽ
class JSR250WayService{
	@PostConstruct
	public void init(){
		System.out.println("@Bean-init-method");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("@Bean-destroy-method");
	}
}

public class PrePostBeanConfig{
	@Bean(initMethod="init", destroyMethod="destroy")
	public BeanWayService beanWayService(){
		return new BeanWayService();
	}
	
	@Bean
	pubilc JSR250WayService jsr250WayService(){
		return new JSR250WayService();
	}
}