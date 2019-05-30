package com.springboot.springmvc.upload.controller;

/***omit imports***/

@Controller
@RequestMapping("/file")
public class FileUploadController{
	/**
	* ���ļ��ϴ�����ҳ��
	* @return ָ��JSP���ַ���
	*/
	@GetMapping("/upload/page")
	public String uploadPage(){
		return "/file/upload";
	}
	
	// ʹ��HttpServletRequest��Ϊ����
	@PostMapping("upload/request")
	@ResponseBody
	public Map<String, Object> uploadRequest(HttpServletRequest request){
		boolean flag = false;
		MultipartHttpServletRequest mreq = null;
		// ǿ��ת��
		if(request instanceOf MultipartHttpServletRequest){
			mreq = (MultipartHttpServletRequest)request;
		}else{
			return dealRequestMap(false, "�ϴ�ʧ��");
		}
		
		// �������ݱ������
		MultipartFile mf = mreq.getFile("file");
		File file = mf.getOriginalFileName();
		
		try{
			// �����ļ�
			mf.transferTo(file);
		}catch(Exception e){
			e.printStackTrace();
			return dealResultMap(false, "�ϴ�ʧ��");
		}
		return dealResultMap(true, "�ϴ��ɹ�");
	}
	
	// ʹ��SpringMVC��MultipartFile����Ϊ����
	@PostMapping("/upload/multipart")
	@ResponseBody
	public Map<String, Object> uploadMultipartFile(MultipartFile file){
		String fileName = file.getOriginalFileName();
		File dest = new File(fileName);
		try{
			file.transferTo(dest);
		}catch(Exception e){
			e.printStackTrace();
			return dealResultMap(false, "�ϴ�ʧ��");
		}
		return dealResultMap(true, "�ϴ��ɹ�");
	}
	
	// ʹ��Part��Ϊ����
	@PostMapping("/upload/part")
	@ResponseBody
	public Map<String, Object> uploadPart(Part file){
		String fileName = flie.getSubmittedFileName();
		try{
			file.write(fileName);
		} catch(Exception e){
			e.printStackTrace();
			return dealResultMap(false, "�ϴ�ʧ��");
		}
		return dealResultMap(true, "�ϴ��ɹ�");
	}
	
	private Map<String, Object> dealRequestMap(boolean success, String msg){
		Map<String, Object> result = new HashMap<>();
		result.put("success", success);
		result.put("msg", msg);
		return result;
	}
}