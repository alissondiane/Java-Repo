package com.arteaga.practica04.servlet;

import com.arteaga.practica04.bean.Cliente;
import com.arteaga.practica04.dao.ClienteDao;
import com.arteaga.practica04.dao.impl.DaoFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;

@WebServlet(name = "ServletExcel1", value = "/ServletExcel1")
public class ServletExcel1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {


        DaoFactory factory=DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);
        List<Cliente> lista=dao.findAll();

        response.setContentType("application/vnd.ms-excel");
        HSSFWorkbook wb = new HSSFWorkbook();				// crea libro;
        HSSFSheet sheet = wb.createSheet("Hoja Clientes");	// crea hoja

        HSSFRow row1 = sheet.createRow((short) 0);			// crea fila1
        HSSFCell a1 = row1.createCell((short) 0);			// crea A1
        HSSFCell b1 = row1.createCell((short) 1);           // crea B1
        HSSFCell c1 = row1.createCell((short) 2);           // crea B1
        HSSFCell d1 = row1.createCell((short) 3);           // crea B1
        HSSFCell e1 = row1.createCell((short) 4);           // crea B1



        a1.setCellValue("Codigo");
        b1.setCellValue("Nombre");
        c1.setCellValue("Apellido");
        d1.setCellValue("Correo");
        e1.setCellValue("Telefono");

        HSSFCellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        b1.setCellStyle(cellStyle);

        int contador = 1;
        for(Cliente c: lista){
            HSSFRow row2 = sheet.createRow((short) contador);			// crea fila 2+
            row2.createCell((short) 0).setCellValue(c.getCodigo());	// A2
            row2.createCell((short) 1).setCellValue(c.getNombre());
            row2.createCell((short) 2).setCellValue(c.getApellido());
            row2.createCell((short) 3).setCellValue(c.getCorreo());
            row2.createCell((short) 4).setCellValue(c.getTelefono()); // B2
            contador = contador+1;
        }

        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
