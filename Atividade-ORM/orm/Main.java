package orm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConexaoDB.inicializarBanco();
        VeiculoDAO orm = new VeiculoDAO();

        System.out.println("\n--- EXECUÇÃO DAS OPERAÇÕES CRUD ---");

        System.out.println("\n>> 1. Testando o CREATE:");
        Veiculo v1 = new Veiculo("ABC-1234", "Civic", 2022);
        Veiculo v2 = new Veiculo("XYZ-9876", "Uno com Escada", 2015);
        orm.criar(v1);
        orm.criar(v2);

        System.out.println("\n>> 2. Testando o RETRIEVE:");
        List<Veiculo> veiculosNoBanco = orm.listarTodos();
        for (Veiculo v : veiculosNoBanco) {
            System.out.println(v);
        }

        System.out.println("\n>> 3. Testando o UPDATE:");
        if (!veiculosNoBanco.isEmpty()) {
            Veiculo veiculoParaAlterar = veiculosNoBanco.get(0);
            veiculoParaAlterar.setModelo("Civic Touring Turbo");
            orm.atualizar(veiculoParaAlterar);
            
            System.out.println("Lista após o UPDATE:");
            for (Veiculo v : orm.listarTodos()) System.out.println(v);
        }

        System.out.println("\n>> 4. Testando o DELETE:");
        if (!veiculosNoBanco.isEmpty()) {
            orm.deletar(veiculosNoBanco.get(veiculosNoBanco.size() - 1).getId());
            System.out.println("Lista final após o DELETE:");
            for (Veiculo v : orm.listarTodos()) System.out.println(v);
        }
    }
}