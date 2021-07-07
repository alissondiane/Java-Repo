package com.arteaga.practica04.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.arteaga.practica04.bean.Cliente;
import com.arteaga.practica04.dao.ClienteDao;
import com.arteaga.practica04.dao.impl.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletClienteCrud", value = "/ServletClienteCrud")
public class ServletClienteCrud extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory factory= DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);
        String action = request.getParameter("action");
        String result="";
        if(action.equals("elimina")) {
            dao.delete(request.getParameter("codigo"));
            result = "Se elimino satisfactoriamente";
        }
        response.sendRedirect("index.jsp?mensaje="+result);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory factory=DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);

        Cliente a=new Cliente();
        a.setCodigo(request.getParameter("txtCodigo"));
        a.setNombre(request.getParameter("txtNombre"));
        a.setApellido(request.getParameter("txtApellido"));
        a.setCorreo(request.getParameter("txtCorreo"));
        a.setTelefono(request.getParameter("txtTelefono"));
        a.setTotalCompras(Double.parseDouble(request.getParameter("txtCompras")));

        String action = request.getParameter("action");
        boolean respuesta = false;
        String result="";
        if(action.equals("graba")){
            respuesta = dao.create(a);
            if(respuesta){
                result = "Cliente creado con exito";
            }else{
                result = "Surgio un error al crear el cliente";
            }
        }else if(action.equals("modifica")){
            respuesta = dao.update(a);
            if(respuesta){
                result = "Cliente actualizado con exito";
            }else{
                result = "Surgio un error al actualizar el cliente";
            }
        }
        response.sendRedirect("index.jsp?mensaje="+result);
    }
}