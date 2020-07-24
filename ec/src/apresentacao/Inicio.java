package apresentacao;

import sistema.Sistema;

/**
 * inicializador de sistema desktop jse
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class Inicio {

	/**
	 * Inicializador padrao desktop jse
	 * @param args argumento padrao jvm
	 */
	public static void main(String[] args) {
		Sistema.iniciarSistema();
		//agenda a execucao do sair qndo a jvm der system.exit
		Runtime.getRuntime().addShutdownHook(new Thread(new Sair()));
		CadastroCliente cad = new CadastroCliente();
		cad.setVisible(true);
	}

}
