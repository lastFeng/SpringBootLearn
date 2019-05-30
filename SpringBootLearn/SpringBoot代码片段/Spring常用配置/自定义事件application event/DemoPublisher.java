// Spring���¼���Ҫ��ѭ������Ϊ��
/**
*	1. �Զ����¼����̳�ApplicationEvent
* 2. �����¼���������ʵ��ApplicationListener
* 3. ʹ�����������¼�
*/

// 1. �Զ����¼�
class DemoEvent extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public DemoEvent(Object source, String msg){
		super(source);
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
	}
}

// 2. �Զ����¼�������
@Component
class DemoListener implements ApplicationListener<DemoEvent>{
	@Override
	public void onApplicationEvent(DemoEvent event){
		String msg = event.getMsg();
		System.out.println("�յ���Ϣ��" + msg);
	}
}

// 3. �����¼�

@Component
public class DemoPublisher{
	@Autowired
	private ApplicationContext applicatinoContext;
	
	public void public(String msg){
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
}