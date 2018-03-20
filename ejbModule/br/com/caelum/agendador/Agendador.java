package br.com.caelum.agendador;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton // EJB Stateless cria um pool de objetos. Para agendar a execução não precisamos
			// de um pool. Não faz sentido configurar o agendamento várias vezes, o que
			// poderia até causar problemas.
@Startup // queremos q o ejb inicie assim q a aplicação for iniciada
public class Agendador {

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false) // hour="9,18" chama metodo as 9 e 18h. No
																				// caso, chama a qq hora, qq minuto e a
																				// caa 10s. Todo agendamento é
																				// persistido automaticamente. É
																				// obrigação do container EJB recuperar
																				// um agendamento caso o servidor tenha
																				// caído, por isso ele grava suas
																				// configurações. Podemos desabilitar
																				// isso através do atributo
																				// persistent=false
	void agendado() {// método que deve ser chamado periodicamente.
		System.out.println("verificando serviço externo periodicamente");
	}

}
