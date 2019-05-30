/**
	������ʵ�ֶ�ÿ��������ǰ�������ص�ҵ����
		1.��������ͨ��Beanʵ��HandlerInterceptor�ӿڻ�̳�HandlerInterceptorAdapter����ʵ���Զ���������
		2. ͨ����дWebMvcConfigurerAdapter��addIntercptors��ע���Զ��������������Ḳ�������Ѷ�����������
**/

// �Զ������������̳�HandlerInterceptorAdapter����ʵ��
// ��дpreHandler��������������ǰִ��
// ��дpostHandler��������������ɺ�ִ��
class CustomInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		Long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	
	@Override
	public void postHandler(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		Long endTime = System.currentTimeMillis();
		Long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		
		System.out.println("����������ʱ��Ϊ��" + (endTime - startTime) + "ms");
		
		request.setAttribute("handleTime", endTime-startTime);
	}
}

// ����
@Configuration
@EnableWebMvc
public CustomInterceptorConfig extends WebMvcConfigurerAdapter{
	@Bean
	public CustomInterceptor customInterceptor(){
		return new CustomInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(customInterceptor());
	}
}