package br.com.cidadania4u.app;

import br.com.cidadania4u.model.Aluno;
import br.com.cidadania4u.utils.ReflectionUtils;

import java.lang.reflect.Field;


public class TestReflection {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setCpf("123.456.789-10");
        aluno.setNome("Jeysel de Paula Martins");
        aluno.setNotaUm(10.0);
        aluno.setNotaDois(8.0);


        try {
            Class classe = Class.forName("br.com.cidadania4u.model.Aluno");
            Field[] atributos =  classe.getDeclaredFields();

            for(Field atributo : atributos){
                System.out.println(atributo.getName());
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

       // ReflectionUtils.imprimirAtributos(aluno);
    }
}