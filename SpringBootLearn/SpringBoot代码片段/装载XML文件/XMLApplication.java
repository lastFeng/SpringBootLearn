// Spring ͨ��Ӧ��������װ��bean�Ķ���
// ����ʹ��ClassPathXMLApplicationContext��װ��Bean

public class XMLApplication{
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/xxx.xml");
		Knight knight = context.getBean(Knight.class);
		knight.method();
		
		context.close();
	}
}