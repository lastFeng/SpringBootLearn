package com.springboot.springmvc.view.pdf;

/***omit imports***/

public class PdfView extends AbstractPdfView{
	// ��������ӿ�
	private PdfExportService pdfExportService;
	
	// ��������ʱ���뵼������ӿ�
	public PdfView(PdfExportService pdfExportService){
		this.pdfExportService = pdfExportService;
	}
	
	// �ӿ�ʵ��
	@Override
	public void buildPdfDocument((Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception{
		pdfExportService.make(model, document, writer, request, response);
	}
}