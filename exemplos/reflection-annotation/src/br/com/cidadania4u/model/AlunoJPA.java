package br.com.cidadania4u.model;

import br.com.cidadania4u.annotation.Validator;


@Tabela("TB_ALUNO")
public class AlunoJPA {
    @Coluna("NOME")
    private String nome;
    @Coluna("CPF")
    private String cpf;
    @Coluna("NOTA_UM")
    private Double notaUm;
    @Coluna("NOTA_DOIS")
    private Double notaDois;

    public Aluno(){}

    public Aluno(String nome, String cpf, Double notaUm, Double notaDois) {
        this.nome = nome;
        this.cpf = cpf;
        this.notaUm = notaUm;
        this.notaDois = notaDois;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getNotaUm() {
        return notaUm;
    }

    public void setNotaUm(Double notaUm) {
        this.notaUm = notaUm;
    }

    public Double getNotaDois() {
        return notaDois;
    }

    public void setNotaDois(Double notaDois) {
        this.notaDois = notaDois;
    }

    public Double getMedia(){
        return (getNotaUm() + getNotaDois()) / 2;
    }
}
