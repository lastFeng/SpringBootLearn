// �ƻ�������Ժ��첽������н��

// 1. ����@EnableScheduling������ʱ����
// 2. ͨ��@Scheduled���������Ķ�ʱ���񣬿���ʹ�ã�cron��fixDelay��fixRate����������嶨ʱ��

// ������ʱ��������
@Configuration
@EnableScheduling
public class TaskSchedulingConfig{

}

// 2. �ڷ�����ʹ��@Scheduled��������ʱ����
@Service
class ScheduledTaskService{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("ÿ������ִ��һ�� " + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron="0 28 11 ? * *")
	public void fixTimeExecution(){
		System.out.println("��ָ��ʱ�� " + dateForm.format(new Date()) + "ִ��");
	}
}