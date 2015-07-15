package model;

import java.sql.Date;

public class ProfissionalDeSaude {
    private String nome;
    private Date dt_nascimento;
    private int n_coren;
    private Date dt_emissao_coren;
    private Date dt_vencimento_coren;
    private String status;
    private String nivel_acesso;
    private String login;
    private String senha;


    public int getN_coren() {
        return n_coren;
    }

    public void setN_coren(int n_coren) {
        this.n_coren = n_coren;
    }

    public Date getDt_emissao_coren() {
        return dt_emissao_coren;
    }

    public void setDt_emissao_coren(Date dt_emissao_coren) {
        this.dt_emissao_coren = dt_emissao_coren;
    }

    public Date getDt_vencimento_coren() {
        return dt_vencimento_coren;
    }

    public void setDt_vencimento_coren(Date dt_vencimento_coren) {
        this.dt_vencimento_coren = dt_vencimento_coren;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    private PerfilDeAcesso perfil;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilDeAcesso getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDeAcesso perfil) {
        this.perfil = perfil;
    }
}
