package br.com.ligacao.persistence.interfaces;

import br.com.ligacao.persistence.model.PromotorJuridico;

public interface IPromotorJuridicoDAO {

	/**
	 * Realiza as busca dos dados do PromotorJuridico através de um usuario e senha
	 * informado por parametro.
	 * 
	 * @param user     nome de usuario cadastrado no perfil de promotor juridico.
	 * @param password senha cadastrado no perfil de promotor juridico.
	 * 
	 * @return caso seja encontrado o perfil de Promotor Juridico com os parametros
	 *         informados irá retornar uma instancia da classe com os atributos
	 *         preenchidos. Caso contrario, deverá retornar NULL.
	 */
	static PromotorJuridico login(String user, String password) {
		return null;
	}

	/**
	 * Realiza a persistencia dos dados do promotor juridico.
	 * 
	 * @param promotorFisico instancia de PromotorJuridico.
	 */
	static void cadastrarPromotor(PromotorJuridico promotorJuridico) {
		// TODO Auto-generated method stub
		
	}

}
