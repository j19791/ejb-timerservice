package br.com.caelum.agendador;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton // EJB Stateless cria um pool de objetos. Para agendar a execu��o n�o precisamos
			// de um pool. N�o faz sentido configurar o agendamento v�rias vezes, o que
			// poderia at� causar problemas.
@Startup // queremos q o ejb inicie assim q a aplica��o for iniciada
public class Agendador {

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false) // hour="9,18" chama metodo as 9 e 18h. No
																				// caso, chama a qq hora, qq minuto e a
																				// caa 10s. Todo agendamento �
																				// persistido automaticamente. �
																				// obriga��o do container EJB recuperar
																				// um agendamento caso o servidor tenha
																				// ca�do, por isso ele grava suas
																				// configura��es. Podemos desabilitar
																				// isso atrav�s do atributo
																				// persistent=false
	void agendado() {// m�todo que deve ser chamado periodicamente.
		System.out.println("verificando servi�o externo periodicamente");
	}

}
