package com.arteaga.dao;

import com.arteaga.bean.Cliente;

import java.util.List;

public interface ClienteDao extends EntidadDao<Cliente>{

    public List<Cliente> findByTipo(String campo, String tipo);
}
