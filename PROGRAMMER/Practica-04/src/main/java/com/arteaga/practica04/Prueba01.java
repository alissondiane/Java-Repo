package com.arteaga.practica04;

import com.arteaga.practica04.bean.Cliente;
import com.arteaga.practica04.dao.ClienteDao;
import com.arteaga.practica04.dao.impl.DaoFactory;

import java.util.ArrayList;
import java.util.List;

public class Prueba01 {
    public static void main(String[] args) {


        DaoFactory factory = DaoFactory.getInstance();
        ClienteDao dao = factory.getClienteDao(1);
        List<Cliente> lista = dao.findAll();

        for(Cliente c : lista){
            System.out.println(c.getCodigo());
        }
    }
}
