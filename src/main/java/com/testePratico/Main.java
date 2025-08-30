package com.testePratico;


import com.testePratico.entities.Funcionario;
import com.testePratico.service.FuncionarioService;

public class Main {
    public static void main(String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();

        //3.1 - Adiciona todos os funcionários da tabela
        funcionarioService.inserirFuncionario();

        //3.2 - Remove o funcionário "João" e imprimindo a tabela sem o próprio
        funcionarioService.excluirJoao();

        //3.4 - Lista atualizada com aumento salárial em 10%
        funcionarioService.darAumento();

        //3.6 - Imprime funcionários agrupados por função
        funcionarioService.imprimirAgrupadosPorFuncao();

        //3.8 - Imprime funcionários aniversariantes dos meses 10 e 12
        funcionarioService.buscarAniversariantesOutDez();

        //3.9 - Imprime o Funcionário mais velho
        funcionarioService.buscarFuncMaisVelho();

        //3.10 - Imprime lista de funcionários por ordem alfabética
        funcionarioService.ordemAlfabetica();

        //3.11 - Imprime soma total de salários dos funcionários
        funcionarioService.totalSalarios();

        //3.12 - Imprime a quantidade de salários mínimos que ganha cada funcionário
        funcionarioService.salarioMinimo();



    }
}