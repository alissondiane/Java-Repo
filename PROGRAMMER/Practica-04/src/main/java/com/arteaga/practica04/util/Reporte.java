package com.arteaga.practica04.util;

import com.arteaga.practica04.bean.Cliente;
import com.arteaga.practica04.dao.ClienteDao;
import com.arteaga.practica04.dao.impl.DaoFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletContext;
import java.io.FileOutputStream;
import java.util.List;

public class Reporte {
    public void generaPDF(String nombre, ServletContext contexto) {
        try {

            //---------------------------------------------------------------------------------------------------------------------
            Document document = new Document(PageSize.A4, 20, 20, 20, 20);
            //document.set


            String ruta = contexto.getRealPath("/");//ruta de los JSPs

            System.out.println("Ruta:"+ruta);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "/reporte.pdf"));

            System.out.println(ruta + "reporte.pdf");
            document.open();
            float[] widths = {0.50f, 0.50f, 0.50f,0.90f,0.60f};
            float[] cabecera = {1.20f, 0.23f, 0.20f,0.20f,0.20f};
            float[] rotulo = {1.00f};
            float[] footer = {0.27f, 0.70f, 0.13f, 0.13f, 0.2f, 0.2f};

            Paragraph p = null;
            PdfPTable table = null;
            PdfPCell cell = null;

            Font negrita = FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK);
            Font text = FontFactory.getFont("Arial", 9, Font.NORMAL, BaseColor.BLACK);
            Font normal = FontFactory.getFont("Arial", 10, Font.NORMAL, BaseColor.BLACK);
            Font blanco = FontFactory.getFont("Arial", 11, Font.NORMAL, BaseColor.WHITE);

            Font linea = FontFactory.getFont("Arial", 10, Font.UNDERLINE, BaseColor.BLACK);
            /**
             * ***Insertando imagenes al PDF *************
             */

            Image logo = Image.getInstance(ruta + "/images/logo-cjava.png");
            logo.scaleAbsolute(45, 50);
            logo.setAbsolutePosition(540, 790);
            document.add(logo);



            p = new Paragraph("                                                                       ");
            document.add(p);
            document.add(p);

            table = new PdfPTable(cabecera);

            p = new Paragraph("Señores", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph(nombre);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            //---------------------------------------------------------
            table = new PdfPTable(rotulo);

            p = new Paragraph("Listado de clientes :", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            table.setTotalWidth(533);
            table.setLockedWidth(true);

            document.add(table);

            p = new Paragraph("                                                                       ");
            document.add(p);

            //---------------------------------------------------------
            table = new PdfPTable(widths);

            //Codigo
            p = new Paragraph("Codigo",blanco );
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(45, 58, 161));
            table.addCell(cell);

            //Nombres
            p = new Paragraph("Nombre", blanco);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(45, 58, 161));
            table.addCell(cell);

            //Fecha de Nacimiento
            p = new Paragraph("Apellido", blanco);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(45, 58, 161));
            table.addCell(cell);

            //Correo
            p = new Paragraph("Correo", blanco);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(45, 58, 161));
            table.addCell(cell);

            //Telefono
            p = new Paragraph("Telefono", blanco);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(45, 58, 161));
            table.addCell(cell);

            document.add(table);

            p = new Paragraph("                                                                       ");
            document.add(p);

            //---------------------------------------------------------------------------------------------------
            //Lista lista = (new AlumnoDAO()).obtenerAlumnos();


            DaoFactory factory=DaoFactory.getInstance();
            ClienteDao dao=factory.getClienteDao(1);
            List<Cliente> lista=dao.findAll();

            for( Cliente c : lista){
                table = new PdfPTable(widths);
                //Codigo
                p = new Paragraph(c.getCodigo(),text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Nombres
                p = new Paragraph(c.getNombre(), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Apellido
                p = new Paragraph(c.getApellido(),text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Correo
                p = new Paragraph(c.getCorreo(),text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Telefono
                p = new Paragraph(c.getTelefono(),text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                document.add(table);

            }
            //-------------------------------------------------------------------------------
            p = new Paragraph("                                                                       ");
            document.add(p);

            table = new PdfPTable(footer);
            p = new Paragraph("Atentamente,     ", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            table.setTotalWidth(533);
            table.setLockedWidth(true);

            document.add(table);

            document.close();

            //---------------------------------------------------------------------------------------------------------------------
        } catch (Exception de) {
            System.out.println("error: " + de.toString());
        }

    }
}
