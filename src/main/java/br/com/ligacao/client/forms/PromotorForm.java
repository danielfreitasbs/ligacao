package br.com.ligacao.client.forms;

import br.com.ligacao.persistence.model.Promotor;

public class PromotorForm {

	public static Promotor preencherForm() {
		Promotor promotor = new Promotor("Joãozinho do Trenó", "Ações Etílicas", "700.000.231-00", "02-02-2002",
				"Teste de Descrição Geral", "trenotunado@email.com", "imagem1.jpg", "instagram.com/meprocuraqueacha",
				"6299999999");
		return promotor;
	}

	public static Promotor preencherFormAlterado(String cpf) {
		Promotor promotor = new Promotor("Joãozinho do Trenó com Nó", "Ações Etílicas", cpf, "02-02-2002",
				"Teste de Descrição Geral", "trenotunado@email.com", "imagem1.jpg", "instagram.com/meprocuraqueacha",
				"6299999999");
		return promotor;
	}
}
