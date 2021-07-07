package com.arteaga.practica03.model.daos;

import ch.qos.logback.core.net.server.Client;
import com.arteaga.practica03.model.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
