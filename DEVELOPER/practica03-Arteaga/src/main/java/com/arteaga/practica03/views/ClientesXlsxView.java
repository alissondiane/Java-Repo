package com.arteaga.practica03.views;

import com.arteaga.practica03.model.entities.Cliente;
import com.arteaga.practica03.services.IClienteService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component("listar.xlsx")
public class ClientesXlsxView extends AbstractXlsxView {

	@Autowired
	private IClienteService clienteService;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"clientes_view.xlsx\"");
		List<Cliente> clienteList =  clienteService.findAll();
		Sheet sheet = workbook.createSheet("Reporte de Clientes");
		
		MessageSourceAccessor mensajes =  getMessageSourceAccessor();
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(mensajes.getMessage("text.ver.datos.cliente"));

		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle tbodyStyle = workbook.createCellStyle();
		tbodyStyle.setBorderBottom(BorderStyle.THIN);
		tbodyStyle.setBorderTop(BorderStyle.THIN);
		tbodyStyle.setBorderRight(BorderStyle.THIN);
		tbodyStyle.setBorderLeft(BorderStyle.THIN);
		
		Row header = sheet.createRow(3);
		header.createCell(0).setCellValue("Id");
		header.createCell(1).setCellValue("Nombre");
		header.createCell(2).setCellValue("Apellido");
		header.createCell(3).setCellValue("Correo");
		header.createCell(4).setCellValue("Telefono");
		
		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		header.getCell(4).setCellStyle(theaderStyle);


		int rownum = 4;
		
		for(Cliente cliente: clienteList) {
			Row fila = sheet.createRow(rownum ++);
			cell = fila.createCell(0);
			cell.setCellValue(cliente.getId());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(1);
			cell.setCellValue(cliente.getNombre());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(2);
			cell.setCellValue(cliente.getApellido());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(3);
			cell.setCellValue(cliente.getEmail());
			cell.setCellStyle(tbodyStyle);

			cell = fila.createCell(4);
			cell.setCellValue(cliente.getTelefono());
			cell.setCellStyle(tbodyStyle);
		}
	}

}
