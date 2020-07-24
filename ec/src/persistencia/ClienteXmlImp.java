package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import negocio.Cliente;
import sistema.Parametros;

/**
 * Implementacao do contrato de persistencia de clientes utilizando o framework JSE XML
 * Padrao de projeto Strategy do livro Padroes de Projeto Java
 * A classe nao é publica para nao expor o servico para fora da camada
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
 class ClienteXmlImp implements ClienteRepositorio {

	@Override
	public void inserir(Cliente cliente) throws PersistenciaException {
		try {
			XMLEncoder xe = new XMLEncoder(new FileOutputStream(Parametros.BASE_XML+ cliente.getNome() + ".xml")); 
			xe.writeObject(cliente);
			xe.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro na persistencia em xml");
		}
		
	}

	@Override
	public List<Cliente> getClientes() throws PersistenciaException {
		List<Cliente> temp = new ArrayList<>();
		File dir = new File(Parametros.BASE_XML);
		File[] files = dir.listFiles();
		try {
			for (File xml : files) {
				FileInputStream fis = new FileInputStream(xml);
				BufferedInputStream bis = new BufferedInputStream(fis);
				XMLDecoder xmlDecoder = new XMLDecoder(bis);
				Cliente cliente = (Cliente) xmlDecoder.readObject();
				xmlDecoder.close();
				temp.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro na leitura dos xml's");
		}
		return temp;				
	}

}
