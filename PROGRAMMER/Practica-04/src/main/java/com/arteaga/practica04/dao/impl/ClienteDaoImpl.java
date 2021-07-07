package com.arteaga.practica04.dao.impl;

import com.arteaga.practica04.bean.Cliente;
import com.arteaga.practica04.dao.ClienteDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    private Connection cn=null;
    private CallableStatement stm=null;

    @Override
    public boolean create(Cliente c) {
        boolean respuesta = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_graba_cliente(?,?,?,?,?,?)}");
            stm.setString(1,c.getCodigo());
            stm.setString(2,c.getNombre());
            stm.setString(3,c.getApellido());
            stm.setString(4,c.getCorreo());
            stm.setString(5,c.getTelefono());
            stm.setDouble(6,c.getTotalCompras());
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
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                c.setTotalCompras(rs.getDouble("totalCompras"));
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

            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

            stm = cn.prepareCall("{call sp_lista_cliente()}");

            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
                c.setTotalCompras(rs.getDouble("totalCompras"));
                listClientes.add(c);
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return listClientes;
    }

    @Override
    public boolean update(Cliente c) {

        System.out.println("Actualizacion de un cliente:::");
        System.out.println(c.getCodigo() + "-"+c.getNombre());

        boolean respuesta = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/rfclientes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
            stm = cn.prepareCall("{call sp_modifica_cliente(?,?,?,?,?,?)}");
            stm.setString(1,c.getCodigo());
            stm.setString(2,c.getNombre());
            stm.setString(3,c.getApellido());
            stm.setString(4,c.getCorreo());
            stm.setString(5,c.getTelefono());
            stm.setDouble(6,c.getTotalCompras());
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
            Class.forName("com.mysql.cj.jdbc.Driver");
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

}
