// Spring Security����
// ������	spring-security-test

/*
* ����֮ǰ������MockMvcʵ��ʱ������Spring Security��������
**/



@RunWith(SpringJUint4ClassRunner.class)
@SpringApplicationConfiguration(classes=xxx.class)
@WebAppConfiguration
public class MockMvcSecurityTest{
	
	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setupMockMvc{
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
														 .apply(SecurityMockMvcConfigurers.springSecurity())   // springSecurity() ��SecurityMockMvcConfigurers��һ����̬������
														 .build();
	}
	
	@Test
	public void homePage_unauthenticatedUser() throws Exception{
		mockMvc.perform("/")
					 .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
					 .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/login"));
	}
	
	
	/**
	* ������֤��Spring Security�ṩ������ע��
	*		@WithMockUser��			���ذ�ȫ�����ģ����а���һ��UserDetails��ʹ���˸������û������������Ȩ��
	*   @WithUserDetails��  ���ݸ������û�������UserDetails���󣬼��ذ�ȫ������
	*/
	@Test
	@WithMockUser(username="craig",
								password="password",
								role="READER")
	public void homePage_authenticatedUser() throws Exception{
		...
	}
	
	@Test
	@WithUserDetails("craig")				// craig�û�
	public void homePage_authenticatedUser() throws Exception{
		Reader expectedReader = new Reader();			// ������Reader
		expectedReader.setUsername("craig");
		expectedReader.setPassword("password");
		expectedReader.setFullname("Craig Walls");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/"))					// ����GET����
					 .andExpect(MockMvcResutltMatchers.status().isOK())
					 .andExpect(MockMvcResutltMatchers.view().name("readingList"))
					 .andExpect(MockMvcResutltMatchers.model.attribute("reader", Mathcers.samePropertyValuesAs(expectedReader)))
					 .andExpect(MockMvcResutltMatchers.model.attribute("books", Matchers.hasSize(0)));
	}
}