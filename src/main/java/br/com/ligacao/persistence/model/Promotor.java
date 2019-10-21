package br.com.ligacao.persistence.model;

import java.util.Objects;

public class Promotor {
    private String nomePromotor;
    private String categoriaAcao;
    private String cpfResponsavel;
    private String dataFundacao;
    private String descricao;
    private String email;
    private  String imagem;
    private String redeSocial;
    private  String telefone;
    private   String usuario;
    private  String senha;
    
    public Promotor() {
        
    }
    
    public Promotor(String nomePromotor, String categoriaAcao,
            String cpfResponsavel, String dataFundacao, String descricao,
            String email, String imagem, String redeSocial, String telefone,
            String usuario, String senha) {
        super();
        this.nomePromotor = nomePromotor;
        this.categoriaAcao = categoriaAcao;
        this.cpfResponsavel = cpfResponsavel;
        this.dataFundacao = dataFundacao;
        this.descricao = descricao;
        this.email = email;
        this.imagem = imagem;
        this.redeSocial = redeSocial;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
    }
    public String getNomePromotor() {
        return nomePromotor;
    }
    public void setNomePromotor(String nomePromotor) {
        this.nomePromotor = nomePromotor;
    }
    public String getCategoriaAcao() {
        return categoriaAcao;
    }
    public void setCategoriaAcao(String categoriaAcao) {
        this.categoriaAcao = categoriaAcao;
    }
    public String getCpfResponsavel() {
        return cpfResponsavel;
    }
    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }
    public String getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public String getRedeSocial() {
        return redeSocial;
    }
    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash( nomePromotor,
               categoriaAcao,
               cpfResponsavel,
               dataFundacao,
               descricao,
               email,
               imagem,
               redeSocial,
               telefone,
               usuario,
               senha);
  }
}
