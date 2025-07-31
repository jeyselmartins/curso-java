package br.com.cidadania4u.utils;

import br.com.cidadania4u.annotation.Validator;
import br.com.cidadania4u.model.Aluno;

import java.lang.reflect.*;

public class ReflectionUtils {

    public static void imprimirAtributos(Object obj) {
        if (obj == null) {
            System.out.println("Objeto nulo.");
            return;
        }

        Class<?> clazz = obj.getClass();
        System.out.println("Classe: " + clazz.getName());

        while (clazz != null) { // Inclui superclasses
            Field[] campos = clazz.getDeclaredFields();

            for (Field campo : campos) {
                campo.setAccessible(true); // Permite acesso a campos privados

                try {
                    Object valor = campo.get(obj);
                    System.out.printf("Campo: %-20s | Tipo: %-15s | Valor: %s%n",
                            campo.getName(),
                            campo.getType().getSimpleName(),
                            valor);
                } catch (IllegalAccessException e) {
                    System.out.printf("Campo: %-20s | [Acesso negado]%n", campo.getName());
                }
            }

            clazz = clazz.getSuperclass(); // Continua para superclasse
        }
    }

    public static boolean validar(Object obj) {
        boolean valido = true;

        for (Field atributo : obj.getClass().getDeclaredFields()) {
            atributo.setAccessible(true);//private

            if (atributo.isAnnotationPresent(Validator.class)) {
                Validator validator = atributo.getAnnotation(Validator.class);

                try {
                    Object valor = atributo.get(obj);//pegar o valor que está dentro do atributo

                    if (valor instanceof Number) {
                        Number numero = (Number)valor;
                        double num = numero.doubleValue();

                        if (num < validator.min() || num > validator.max()) {
                            System.out.printf("Erro: atributo '%s' fora do intervalo [%.2f, %.2f]%n",
                                    atributo.getName(), validator.min(), validator.max());
                            valido = false;
                        }
                    } else {
                        System.out.printf("Aviso: atributo '%s' com @Validator não é numérico.%n", atributo.getName());
                    }

                } catch (IllegalAccessException e) {
                    System.out.printf("Erro ao acessar o atributo '%s'%n", atributo.getName());
                    valido = false;
                }
            }
        }

        return valido;
    }
}
