package com.arteaga.practica03.schedule;

import com.arteaga.practica03.model.daos.IAuditoriaDao;
import com.arteaga.practica03.model.entities.Auditoria;
import com.arteaga.practica03.model.entities.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyNotification {

	@Autowired
	private IAuditoriaDao auditoriaDao;

	private static Logger logger = LoggerFactory.getLogger(DailyNotification.class);


	@Scheduled(cron= "0/60 * * * * ?")
	public void sendNotification() {

		logger.info("*****************************");
		logger.info("**Mostrando tabla Auditoria**");
		logger.info("*****************************");

		for(Auditoria auditoria: auditoriaDao.findAll()) {
			logger.info(auditoria.toString());
		}

		logger.info("*****************************");

	}
	

	/*
	 * 	1.Seconds

		2.Minutes

		3.Hours

		4.Day-of-Month

		5.Month

		6.Day-of-Week

		7.Year (opcional)

	 * 
	 */
	
	//A las 12 todos los dias
	//0 12 * * ?
	
	//5 minutos iniciando a la 1pm y termiando a la 1.55  iniciando a las 6pm y acabando a las 6.55
	//0/5 13,18 * * ?
	
	//A las 9:30 el 15 de cada mes
	//30 9 15 * ?

	
/*
 * Anotaciones Especiales
 * @reboot – correr una vez al arrancar
 * @yearly o @annualy – una vez al año
 * @monthly – corre una vez al mes
 * @weekly – corre una vez a la semana
 * @daily o @midnight – Corre una vez al dia
 * @hourly – corre cada hora
 */
	
	//@EnableScheduling
}
