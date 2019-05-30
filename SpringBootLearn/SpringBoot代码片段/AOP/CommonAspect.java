/**
*
* Spring����AspectJ���е���ʽ����������Spring���棺
				AspectJָʾ��											����
				arg()								�������ӵ�ƥ�����Ϊָ�����͵�ִ�з���
				@args()							�������ӵ�ƥ�������ָ��ע���ע��ִ�з���
				execution()					����ƥ�������ӵ��ִ�з���
				this()							�������ӵ�ƥ��AOP�����bean����Ϊָ�����͵���
				target							�������ӵ�ƥ��Ŀ�����Ϊָ�����͵���
				@target()						�������ӵ�ƥ���ض���ִ�ж�����Щ�����Ӧ����Ҫ����ָ�����͵�ע��
				within							�������ӵ�ƥ��ָ��������
				@within()						�������ӵ�ƥ��ָ��ע������ע�����ͣ���ʹ��SpringAOPʱ��������������ָ����ע������ע�����
				@annotation()				�޶�ƥ�����ָ��ע������ӵ�
				
	example��
		execution(* concert.Performance.perform(..))
		�ڷ���    ����		����������            ƥ��
		ִ��ʱ    ����    ����������з�����		����
		����      ����    ����ʹ��*��ʾ         ����
		
		
		execution(* concert.Performance.*(..)) && within(concert.*)
		
		����ʹ��&&��||�������ж���������
*/
// ����Ŀ�����
package concert;
public interface Performance{
	public void perform();
}

// ��������
package concert;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// ����Ϊ������
@Apect
pubilc class Audience{
	@Pointcut("execution(* concert.Performance.perform(..))")
	public void performance(){}
	
	@Before("performance()")
	public void silenceCellPhones(){
		System.out.println("Silencing cell phones");
	}
	
	@Before("performance()")
	public void takeSeats(){
		System.out.println("Taking seats");
	}
	
	@AfterReturning("performance()")
	public void applause(){
		System.out.println("CLAP CLAP CLAP!!!");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("Demanding a refund!");
	}
}

// ����AspectJע����Զ�����
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig{
	@Bean
	public Audience audience(){
		return new Audience();
	}
}