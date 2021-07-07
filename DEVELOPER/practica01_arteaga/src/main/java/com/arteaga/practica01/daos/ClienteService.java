package com.arteaga.practica01.daos;

import com.arteaga.practica01.pojos.Cliente;
import com.arteaga.practica01.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClienteService {
 
 public void insertCliente(Cliente cliente) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
  ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
   clienteMapper.insertCliente(cliente);
  sqlSession.commit();
  }finally{
   sqlSession.close();
  }
 }

 public Cliente getClienteById(Integer idCliente) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
  ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
  return clienteMapper.getClienteById(idCliente);
  }finally{
   sqlSession.close();
  }
 }

 public List<Cliente> getAllClientes() {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
   ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
  return clienteMapper.getAllClientes();
  }finally{
   sqlSession.close();
  }
 }

 public void updateCliente(Cliente cliente) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
   ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
   clienteMapper.updateCliente(cliente);
  sqlSession.commit();
  }finally{
   sqlSession.close();
  }
  
 }

 public void deleteCliente(Integer idCliente) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
   ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
   clienteMapper.deleteCliente(idCliente);
  sqlSession.commit();
  }finally{
   sqlSession.close();
  }
  
 }

}
