public class WebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException{
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		
		context.register(MyMvcConfig.class);
		context.setServletContext(servletContext);
		
		// ע��DispatcherServlet
		Dynamic servletContext.adServlet("dispatcher", new DispatcherServlet(context));
		
		// ���Servlet��ӳ��
		servlet.addMapping("/");
		// ���ø�Servlet�ļ���˳��
		servlet.setLoadOnStartup(1);
	}
}