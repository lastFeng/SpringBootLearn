// ����ע�⣺@Conditional
// @Conditional ��������ĳһ���ض���������һ���ض���Bean��

// 1. ʵ��Condition�ӿڵ�matches�������������ж����������㣬�������true������ƥ���
// 2. ������Ӧ��@Bean��ͬʱ����@Conditional��ָ�������������Ż�ʵ������Ӧ��Bean

// 1. �ж���������

// a. �ж�Windows������
class WindowsCondition implements Condition{
	@Override
	public boolean matches(ConditionContext context, AnnotationTypeMetadate metadate){
		return context.getEnvironment().getProperty("os.name").contains("Windows");
	}
}

// b. �ж�Linux������
class LinuxCondition implments Condition{
	@Override
	public boolean matches(ConditionContext context, AnnotationTypeMetadate metadate){
		return context.getEnvironment().getProperty("os.name").contains("Linux");
	}
}

// 2. ��ͬϵͳ�µ�Bean��
// a. �ӿ�
interface ListService{
	public String showListCmd();
}

// Windows����Ҫ������Bean��
class WindowsListService implements ListService{
	@Override
	public String showListCmd(){
		return "dir";
	}
}

// Linux����Ҫ������Bean��
class LinuxListService implements ListService{
	@Override
	public String showListCmd(){
		return "ls";
	}
}

// ������
@Configuration
public class ConditionConfig{
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowsListService(){
		return new WindowsListService();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService linuxListService(){
		return new LinuxListService();
	}
}