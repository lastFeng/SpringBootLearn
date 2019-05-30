// Web Controller Test
/**
* Web Controller ʾ��

	@RequestMapping(method=RequestMethod.POST)
	public String addToReadingList(Book book){
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/readingList";
	}

*/
/**
	  SpringMockMVC: ����һ��������ʵ��ģ��Servlet��������Կ�������������ʵ������Ӧ�÷�����������ʱʹ�ã�
	  Web���ɲ��ԣ���Ƕ��ʽServlet����������Tomcat��Jetty��������Ӧ�ó�����������Ӧ�÷�������ִ�в���
*/

/**
		�ڲ���ʱ����Mock MVC������ʹ��MockMVCBuilders�������ṩ��������̬����
			1. standaloneSetup()������һ��Mock MVC���ṩһ�������ֹ����������õĿ�����-------�ֹ���ʼ����ע��Ҫ���ԵĿ�����
			2. webAPPContextSetup()��ʹ��SpringӦ�ó���������������Mock MVC��������������԰���һ���������úõĿ�����-------����һ��WebApplicationContext��ʵ������Spring����
*/

import static org.hamcrest.Matchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadlingListApplication.class)
@WebAppConfiguration   // ����Web�����Ĳ���
public class MockMvcWebControllerTest{
	@Autowired
	private  WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	// ����MockMvc���ڲ���ִ��ǰִ��
	@Before
	public void setupMockMvc(){
		mockMvc = MockMvcBuilders
							.webAppContextSetup(webContext)
							.build();
	}
	
	/**
		��/readlingList����һ��HTTP GET�����ж�ģ�ͺ���ͼ�Ƿ��������ǵ�����
	*/
	@Test
	public void homePage() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/readlingList")) 	//	 ��ȡ/readingListҳ���Get����
					 .andExpect(MockMvcResultMatchers.status().isOK()) 	// �鿴��ȡ��״̬
					 .andExpect(MockMvcResultMatchers.view().name("readlingList"))		// �鿴��ȡ����ͼ�����Ƿ��ǡ�readlingList��
					 .andExpect(MockMvcResultMatchers.model().attributeExists("books"))		// �鿴��ȡģ�����Ƿ�������ԡ�books��
					 .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())))	// �鿴��ȡ��books�����Ƿ�Ϊ�� 
	}
	
	/**
			HTTP POST ����
	*/
	@Test
	public void postBook() throws Exception{
		mockMvc.perform(MockMvcRequstBuilders.post("/readingList")
					 .contentType(MediaType.APPLICATION_FORM_URLENCODED)
					 .param("title", "BOOK TITLE")
					 .param("author", "BOOK AUTHOR")
					 .param("isbn", "1234567890")
					 .param("description", "DESCRIPTION"))
					 .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
					 .andExpect(MockMvcResultMatchers.header().string("Location", "readingList"));
		
		Book expectBook = new Book();
		expectBook.setId(1L);
		expectBook.setReader("craig");
		expectBook.setTitle("BOOK TITLE");
		expectBook.setAuthor("BOOK AUTHOR");
		expectBook.setIsbn("1234567890");
		expectBook.setDescription("DESCRIPTION");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/readlingList"))
					 .andExpect(MockMvcResultMatchers.status().isOK())
					 .andExpect(MockMvcResultMatchers.view().name("readlingList")
					 .andExpect(MockMvcResultMatchers.model.attributeExists("books"))
					 .andExpect(MockMvcResultMatchers.model.attribute("books", Matchers.contains(Matchers.samePropertyValuesAs(expectBook))));
	}
	
}