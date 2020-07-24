package apresentacao;

import sistema.Sistema;

/**
 * Processamento de desligamento da solucao
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class Sair implements Runnable {
	
	/** Processo que executa as operacoes de desligamento **/
	public void run() {
		Sistema.desligarSistema();
	}

}
