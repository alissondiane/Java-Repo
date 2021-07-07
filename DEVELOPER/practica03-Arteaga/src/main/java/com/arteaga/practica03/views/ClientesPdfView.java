package com.arteaga.practica03.views;

import com.arteaga.practica03.model.entities.Cliente;
import com.arteaga.practica03.services.IClienteService;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component("listar")
public class ClientesPdfView extends AbstractPdfView {

	@Autowired
    private MessageSource messageSource;
	
	@Autowired
    private LocaleResolver localeResolver;

	@Autowired
	private IClienteService clienteService;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Cliente> clienteList =  clienteService.findAll();

		//Cliente cliente = (Cliente) model.get("clientes");
		
		Locale locale = localeResolver.resolveLocale(request);
		
		MessageSourceAccessor mensajes =  getMessageSourceAccessor();


		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);

		PdfPCell cell = null;

		cell = new PdfPCell(new Phrase(messageSource.getMessage("text.ver.datos.cliente", null, locale)));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		tabla.addCell(cell);

		float numero = 0.5f;

		PdfPTable tabla3 = new PdfPTable(5);
		tabla3.setWidths(new float [] {numero, 1, 1, 1, 1});
		tabla3.addCell("Id");
		tabla3.addCell("Nombre");
		tabla3.addCell("Apellido");
		tabla3.addCell("Correo");
		tabla3.addCell("Telefono");
		for(Cliente cliente: clienteList) {
			tabla3.addCell(cliente.getId().toString());
			tabla3.addCell(cliente.getNombre());
			tabla3.addCell(cliente.getApellido());
			tabla3.addCell(cliente.getEmail());
			tabla3.addCell(cliente.getTelefono());
		}
		document.add(tabla);
		document.add(tabla3);
	}

}
