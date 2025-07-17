package org.example.model;

public class Aluno {

    private int codigo;
    private String nome;
    private String cpf;
    private int idade;
    public Aluno(String nome, String cpf, int idade) {
        setCpf(cpf);
        setNome(nome);
        setIdade(idade);
    }
    public Aluno(int codigo, String nome, String cpf, int idade) {
        setCodigo(codigo);
        setCpf(cpf);
        setNome(nome);
        setIdade(idade);
    }
    public Aluno(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
