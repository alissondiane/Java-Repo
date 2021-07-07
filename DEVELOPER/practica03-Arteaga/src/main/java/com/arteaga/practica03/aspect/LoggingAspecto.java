package com.arteaga.practica03.aspect;

import com.arteaga.practica03.model.daos.IAuditoriaDao;
import com.arteaga.practica03.model.entities.Auditoria;
import com.arteaga.practica03.model.entities.Cliente;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Calendar;

@Component
@Aspect
public class LoggingAspecto {

	@Autowired
	private IAuditoriaDao auditoriaDao;

	@Around("execution(* com.arteaga.practica03.services.ClienteServiceImpl.save(..)) ||" +
			"execution(* com.arteaga.practica03.services.ClienteServiceImpl.delete(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result =  null;
		Long currTime = System.currentTimeMillis();
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		String metodo = joinPoint.getSignature().getName()+"()";

		String input = "";
		Long id = null;

		if(joinPoint.getArgs().length > 0){

			if(metodo.startsWith("save")){
				Object[] parametros = joinPoint.getArgs();
				Cliente cliente = (Cliente)parametros[0];
				id = cliente.getId();
			}
			else if(metodo.startsWith("delete")){
				Object[] parametros = joinPoint.getArgs();
				Long idRegistro = (Long)parametros[0];
				id = idRegistro;
			}

			logger.info(metodo + " INPUT:" + Arrays.toString(joinPoint.getArgs()));
		}
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
		Auditoria auditoria = new Auditoria();
		auditoria.setTabla("clientes");
		auditoria.setIdRegistro(id);
		auditoria.setFecha(Calendar.getInstance().getTime());
		auditoria.setUsuario("usuario");
		auditoria.setTipo(metodo);
		auditoriaDao.save(auditoria);
		return result;
	}
}
