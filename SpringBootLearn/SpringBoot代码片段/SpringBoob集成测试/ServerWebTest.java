// ʹ��Selenium��ģ���ֶ���ȡ��ַ
// ������selenium-java

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebIntegrationTest(radomPort=true)   // ��������˿ں�
public class ServerWebTest{
	private Static FirefoxDriver browser;   // ������������
	
	@Value("${local.server.port}")				// ע��˿ں�
	private int port;
	
	@BeforeClass
	public static void openBrowser(){		// �ᴴ��FirefoxDriverʵ��
		browser = new FirefoxDriver();
		browser.manage().timeouts()
					 .implicitlyWait(10, TimeUnit.SECONDS);		// ����Firefox����
	}
	
	@AfterClass
	public static void closeBrowser(){
		browser.quit();			// �ر������
	}
	
	@Test
	public void addBookToEmptyList(){
		String baseUrl = "http://localhost:" + port;
		
		browser.get(baseUrl);
		
		// �ж�ͼ���б��Ƿ�Ϊ��
		assertEquals("You have no books in your book list", browser.findElementByTagName("div").getText());
		
		// ��䲢���ͱ�
		browser.findElementByName("title").sendKeys("BOOK TITLE");
		browser.findElementByName("author").snedKeys("BOOK AUTHOR");
		browser.findElementByName("isbn").sendKeys("1234567890");
		browser.findElementByName("description").sendKeys("DESCRIPTION");
		browser.findElementByName("form").submit();
		
		WebElement dl = browser.findElementByCssSelector("dt.bookHeadline");
		assertEquals("BOOK TITLE by BOOK AUTHOR (ISN: 1234567890)", dl.getText());
		
		WebElement dt = browser.findElementByCssSelector("dd.bookDescription");
		assertEquals("DESCRIPTION", dt.getText());
	}
}