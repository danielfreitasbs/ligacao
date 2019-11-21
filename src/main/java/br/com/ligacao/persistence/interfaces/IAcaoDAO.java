package br.com.ligacao.persistence.interfaces;

import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.PromotorJuridico;

public interface IAcaoDAO {

    /**
     * Método responsável por cadastrar ou atualizar uma nova
     * ação de um promotor físico no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     *
     * @param promotorFisico Objeto promotor de ação.
     * @param acao Objeto ação.
     */
     static void cadastraAcao(PromotorFisico promotorFisico, Acao acao){
         // TODO Auto-generated method stub
     }

    /**
     * Método responsável por cadastrar ou atualizar uma nova
     * ação de um promotor jurídico no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     *
     * @param promotorJuridico Objeto promotor de ação.
     * @param acao Objeto ação.
     */
    static void cadastraAcao(PromotorJuridico promotorJuridico, Acao acao){
        // TODO Auto-generated method stub
    }
}
