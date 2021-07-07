package com.arteaga.practica02.aspect;

import com.arteaga.practica02.model.entities.Cliente;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Component
@Aspect
public class LoggingAspecto {

	private Long tx;

	@Before("execution(* com.arteaga.practica02.service.*ServiceImpl.save(..))")
	public void logBefore(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		logger.info("logBefore() esta ejecutandose!");
		logger.info("logBefore() método : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.arteaga.practica02.service.*ServiceImpl.save(..)) ||" +
			"execution(* com.arteaga.practica02.service.*ServiceImpl.delete(..))")
	public void logAfter(JoinPoint joinPoint) throws Throwable {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		String metodo = joinPoint.getSignature().getName();
		Long id = null;
		if(metodo.startsWith("save")){
			Object[] parametros = joinPoint.getArgs();
			Cliente cliente = (Cliente) parametros[0];
			id = cliente.getId();
		}
		else if(metodo.startsWith("delete")){
			Object[] parametros = joinPoint.getArgs();
			id = (Long)parametros[0];
		}
		String traza = "tx[] - " + metodo;
		logger.info(traza + "(ID):" + id);
	}


	@AfterReturning(pointcut = "execution(* com.arteaga.practica02.service.*ServiceImpl.save(..))", returning = "resultado")
	public void logAfterReturning(JoinPoint joinPoint, Object resultado) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		logger.info("logAfterReturning() esta ejecutandose!");
		logger.info("logAfterReturning() método: " + joinPoint.getSignature().getName());
		logger.info("logAfterReturning() respuesta : " + resultado);
	}

	@AfterThrowing(pointcut = "execution(* com.arteaga.practica02.service.*ServiceImpl.delete(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		logger.info("logAfterThrowing() esta ejecutandose!");
		logger.info("logAfterThrowing() método: " + joinPoint.getSignature().getName());
		logger.error("Exception : " + error);
	}

	@Around("execution(* com.arteaga.practica02.service.*ServiceImpl.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result =  null;
		Long currTime = System.currentTimeMillis();
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		String metodo = "tx[] - " + joinPoint.getSignature().getName();
		logger.info(metodo + "()");
		if(joinPoint.getArgs().length > 0)
			logger.info(metodo + "() INPUT:" + Arrays.toString(joinPoint.getArgs()));
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
		return result;

	}

}
