package br.com.cidadania4u.model;

public class App {
    public static void main(String[] args) {
        AlunoJPA a = new AlunoJPA();
        a.setNome("Jeysel");
        a.setCpf("324567");
        a.setNotaUm(9);
        a.setNotaUm(4);

        JPAManager jpa = new JPAManager();
        jpa.persist(a);
    }
}
