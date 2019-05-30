// Dependency ---- commons-io
// properties classpath: com/wisely/hightlight_spring4/el/test.properties
//				book.author=wangyunfei
//				book.name=spring boot


@Configuration
@ComponentScan("com.wisely.hightlight_spring4.el") // ɨ��λ��
@PropertySource("classpath:com/wisely/hightlight_spring4/el/test.properties")  // ע��ָ���������ļ�
//@ConfigurationProperties(prefix="book")   // ָ��ע�������ļ��У����ݵ�ǰ׺��֮��ĵ������ļ��е�������������һ�¼���ע��
public class ELConfig{
	
	// ע����ͨ�ַ�
	@Value("I Love You!")
	private String normalString;
	
	// ע�����ϵͳ����
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	// ע����ʽ���, �������ú�������ע��
	@Value("#{T(java.lang.Math).random() * 100.0}")
	private double randomNumber;
	
	// ע������Bean����
	@Value("#{demoService.another}")
	private String fromAnother;
	
	// ע��ָ���ļ���Դ�����ļ��д洢��������
	@Value("classpath:com/wisely/hightligth_spring4/el/test.txt")
	private Resource testFile;
	
	// ע����ַ��Դ
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	// ע�������ļ�
	@Value("${book.name}")
	private String bookName;
	
}