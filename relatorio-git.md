# Relatório de Prática: Implementação de Camada ORM/CRUD

Este documento apresenta a persistência de dados da classe de modelo `Veiculo` pertencente ao projeto de Gestão de Manutenção Automotiva, mapeada de forma relacional utilizando JDBC e SQLite.

## Demonstração das Operações CRUD

Todos os testes foram executados com sucesso em uma única rotina na classe `Main`, conforme demonstrado na captura de tela unificada abaixo.

### 1. Inserção de Dados (Create)
O método mapeia os atributos da instância do objeto para parâmetros de uma query `INSERT`. No terminal, vemos o sucesso na inserção do Civic e do Uno.

![CRUD Executado com Sucesso](images/print_crud.png)

### 2. Recuperação e Mapeamento de Linhas para Objetos (Retrieve)
O método executa um `SELECT`, percorre o ponteiro de resultados (`ResultSet`) e monta instâncias reais da classe Java populando uma lista.

![CRUD Executado com Sucesso](images/print_crud.png)

### 3. Atualização de Registros (Update)
Altera os dados textuais/numéricos diretamente nas colunas correspondentes através do ID do objeto representativo (Modificação do Civic para a versão Touring Turbo).

![CRUD Executado com Sucesso](images/print_crud.png)

### 4. Remoção Física (Delete)
Exclui o registro da tabela correspondente utilizando a chave primária (Remoção do Uno, deixando apenas o Civic no banco).

![CRUD Executado com Sucesso](images/print_crud.png)