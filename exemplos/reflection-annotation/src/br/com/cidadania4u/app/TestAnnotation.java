package br.com.cidadania4u.app;

import br.com.cidadania4u.model.Aluno;
import br.com.cidadania4u.utils.ReflectionUtils;

public class TestAnnotation {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setCpf("123.456.789-10");
        aluno.setNome("Jeysel de Paula Martins");
        aluno.setNotaUm(10.0);
        aluno.setNotaDois(8.0);

        System.out.println(ReflectionUtils.validar(aluno));
    }
}
