package com.springboot.springmvc.view.pdfview.controller;

/***omit imports***/
@Controller
@RequestMapping("/user")
public class UserController{
	@Autowired
	private UserService userService;
	
	// �����ӿ�
	@GetMapping("/export/pdf")
	public ModelAndView exportPdf(String name, String note){
		List<User> userList = userService.findUserByUserNameAndNote(userName, note);
		View view = new PdfView(exportService());
		ModelAndView mv = new ModelAndView();
		
		mv.setView(view);
		mv.addObject("userList", userList);
		return mv;
	}
	
	// ����PDF�Զ���
	@SuppressWarnings("unchecked")
	private PdfExportService exportService(){
		// ʹ��lambda���ʽ�Զ��嵼��
		return (model, document, writer, request, response) -> {
			try{
				// A4ֽ
				document.setPageSize(PageSize.A4);
				// title
				document.addTitle("UserInfo")
				// new line
				document.add(new Chunk("\n"));
				// table 3��
				PdfTable table = new PdfTable(3);
				// ��Ԫ��
				PdfCell cell = null;
				// font
				Font f8 = new Font();
				f8.setColor(Color.BULE);
				f8.setStyle(Font.BLOD);
				
				// table title
				cell = new PdfPCell(new Paragraph("id", f8));
				// center
				cell.setHorizontalAlignment(1);
				
				// add cell
				table.addCell(cell);
				cell = new PdfPCell(new Paragraph("userName", f8));
				cell.setHorizontalAlignment(1);
								
				// table title
				table.addCell(cell);
				cell = new PdfPCell(new Paragraph("note", f8));
				// center
				cell.setHorizontalAlignment(1);
				
				table.addCell(cell);
				List<User> userList = (List<User>) model.get("userList");
				for(User u : userList){
					document.add(new Chunk("\n"));
					cell = new PdfPCell(new Paragraph(u.getId() + ""));
					table.addCell(cell);
					cell = new PdfPCell(new Paragraph(u.getUserName()));
					table.addCell(cell);
					cell = new PdfPCell(new Paragraph(u.getNote() == null ? "" : u.getNote()));
					table.addCell(cell);
				}
				document.add(table);
			} catch(DocumentExecption e){
				e.printStackTrace();
			}
		};
	}
}