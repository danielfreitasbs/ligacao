package br.com.ligacao.persistence.interfaces;

import br.com.ligacao.persistence.model.PromotorFisico;

public interface IPromotorFisicoDAO {

	/**
	 * Realiza a persistencia dos dados do promotor físico.
	 * 
	 * @param promotorFisico instancia de PromotorFisico
	 */
	static void cadastraPromotor(PromotorFisico promotorFisico) {
	}

	/**
	 * Realiza as busca dos dados do PromotorFisico através de um usuario e senha
	 * informado por parametro.
	 * 
	 * @param user     nome de usuario cadastrado no perfil de promotor juridico.
	 * @param password senha cadastrado no perfil de promotor juridico.
	 * 
	 * @returncaso seja encontrado o perfil de Promotor Juridico com os parametros
	 *             informados irá retornar uma instancia da classe com os atributos
	 *             preenchidos. Caso contrario, deverá retornar NULL.
	 */
	static PromotorFisico fazerLogin(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
