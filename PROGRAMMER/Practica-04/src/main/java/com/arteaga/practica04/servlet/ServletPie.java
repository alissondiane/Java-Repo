package com.arteaga.practica04.servlet;

import com.arteaga.practica04.bean.Cliente;
import com.arteaga.practica04.dao.ClienteDao;
import com.arteaga.practica04.dao.impl.DaoFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "ServletPie", value = "/ServletPie")
public class ServletPie extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PieDataset createDataset() {
        DefaultPieDataset datos = new DefaultPieDataset();

        DaoFactory factory=DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);
        List<Cliente> lista=dao.findAll();

        for (Cliente c : lista){
            datos.setValue(c.getCodigo()+"-"+c.getNombre()+" "+c.getApellido(),c.getTotalCompras());
        }
/*
        datos.setValue("Java", 40.2D);
        datos.setValue("Visual Basic", 7.3D);
        datos.setValue("C/C++", 17.5D);
        datos.setValue("PHP", 32.5D);
        datos.setValue("Perl", 2.5D);
*/
        return datos;
    }

    private JFreeChart createChart(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Gráfico Pie de Compras de Clientes", piedataset, true, true, false);
        PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);

        return jfreechart;
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        //--------------------------------------------------
        PieDataset pie = createDataset();
        JFreeChart grafico = createChart(pie);

        ChartUtilities.writeChartAsJPEG(out, grafico, 500, 300);
        //--------------------------------------------------
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
