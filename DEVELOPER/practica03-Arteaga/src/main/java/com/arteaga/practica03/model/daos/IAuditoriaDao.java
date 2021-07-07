package com.arteaga.practica03.model.daos;

import com.arteaga.practica03.model.entities.Auditoria;
import com.arteaga.practica03.model.entities.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAuditoriaDao extends PagingAndSortingRepository<Auditoria, Long> {

}
