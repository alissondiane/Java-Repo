package com.arteaga.dao.impl;

import com.arteaga.bean.Cliente;
import com.arteaga.dao.ClienteDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    private Connection cn=null;
    private CallableStatement stm=null;

    @Override
    public boolean create(Cliente c) {
        boolean respuesta = false;
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_graba_cliente(?,?,?,?,?)}");
            stm.setString(1,c.getCodigo());
            stm.setString(2,c.getNombre());
            stm.setString(3,c.getApellido());
            stm.setString(4,c.getCorreo());
            stm.setString(5,c.getTelefono());
            int rs= stm.executeUpdate();
            System.out.println("Se afectaron " + rs);
            respuesta = true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                stm.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return respuesta;

    }

    @Override
    public Cliente find(Object id) {
        Cliente c=null;
        String cod = id.toString();
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_busca_cliente(?)}");
            stm.setString(1,cod);

            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return c;
    }

    @Override
    public List<Cliente> findAll() {

        List<Cliente> listClientes = new ArrayList<>();

        Cliente c=null;
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_lista_cliente()}");

            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
                listClientes.add(c);
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return listClientes;
    }

    @Override
    public boolean update(Cliente c) {

        boolean respuesta = false;
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_modifica_cliente(?,?,?,?,?)}");
            stm.setString(1,c.getCodigo());
            stm.setString(2,c.getNombre());
            stm.setString(3,c.getApellido());
            stm.setString(4,c.getCorreo());
            stm.setString(5,c.getTelefono());
            int rs= stm.executeUpdate();
            System.out.println("Se afectaron " + rs);

            respuesta = true;

            System.out.println("Valor respuesta: "+respuesta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                stm.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Valor respuesta: "+respuesta);
        return respuesta;
    }

    @Override
    public void delete(Object id) {
        String cod = id.toString();
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_elimina_cliente(?)}");
            stm.setString(1,cod);

            int rs= stm.executeUpdate();
            System.out.println("Se eliminaron: " + rs);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                stm.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Cliente> findByTipo(String campo, String tipo) {
        List<Cliente> listClientes = new ArrayList<>();

        String query = "";

        Cliente c=null;
        try {

            switch(tipo){
                case "Codigo": query = "select * from clientes where codigo=?"; break;
                case "Nombre": query = "select * from clientes where nombre=?"; break;
                case "Apellido": query = "select * from clientes where apellido=?"; break;
                default: query = "";
            }

            System.out.println("Query segun el tipo");
            System.out.println(query);

            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            PreparedStatement stm = cn.prepareStatement(query);
            stm.setString(1,campo);

            ResultSet rs=stm.executeQuery();

            while(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
                listClientes.add(c);
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return listClientes;
    }
}
