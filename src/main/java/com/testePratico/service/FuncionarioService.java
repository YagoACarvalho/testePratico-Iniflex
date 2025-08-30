package com.testePratico.service;

import com.testePratico.entities.Funcionario;
import com.testePratico.entities.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
    DecimalFormat df = new DecimalFormat("#,##0.00", symbols);


    private List<Funcionario> funcionarios = new ArrayList<>();



    //Insere os funcionários da tabela.

    public List<Funcionario> inserirFuncionario() {
        System.out.println("------------------------------------------------");
        System.out.println("Lista de funcionários");
        System.out.println("------------------------------------------------");

        funcionarios.add(
            new Funcionario(
                    "Maria",
                    LocalDate.parse("08/10/2000", formatter ),
                    new BigDecimal("2009.44"),
                    "Operador"
            )
        );

        funcionarios.add(
                new Funcionario(
                        "João",
                        LocalDate.parse("12/05/1990", formatter ),
                        new BigDecimal("2284.38"),
                        "Operador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Caio",
                        LocalDate.parse("02/05/1961", formatter ),
                        new BigDecimal("9836.14"),
                        "Cordenador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Miguel",
                        LocalDate.parse("14/10/1988", formatter ),
                        new BigDecimal("19119.88"),
                        "Diretor"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Alice",
                        LocalDate.parse("05/01/1995", formatter ),
                        new BigDecimal("2234.68"),
                        "Recepcionista"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Heitor",
                        LocalDate.parse("19/11/1999", formatter ),
                        new BigDecimal("1582.72"),
                        "Operador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Arthur",
                        LocalDate.parse("31/03/1993", formatter ),
                        new BigDecimal("4071.84"),
                        "Contador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Laura",
                        LocalDate.parse("08/07/1994", formatter ),
                        new BigDecimal("3017.45"),
                        "Gerente"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Heloísa",
                        LocalDate.parse("24/05/2003", formatter ),
                        new BigDecimal("1606.85"),
                        "Eletricísta"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Helena",
                        LocalDate.parse("02/09/1996", formatter ),
                        new BigDecimal("2799.93"),
                        "Gerente"
                )
        );


        return funcionarios;
    }

    //Imprime tabela de funcionários
    private void impimirTabela() {

        System.out.printf("%-10s %-12s %-10s %-15s%n", "Nome", "Nascimento", "Salario", "Cargo");

        for (Funcionario f: funcionarios) {
            System.out.printf("%-10s %-12s %-10s %-15s%n",
                    f.getNome(),
                    f.getDataNascimento().format(formatter),
                    df.format(f.getSalario()),
                    f.getFuncao()
                    );
        }

        System.out.println();

    }

    public void excluirJoao() {
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        System.out.println("------------------------------------------------");
        System.out.println("Excluindo o Funcionário 'João' ");
        System.out.println("------------------------------------------------");
        impimirTabela();
    }

    public void darAumento() {
        System.out.println("------------------------------------------------");
        System.out.println("Salários atualizados com aumento de 10%");
        System.out.println("------------------------------------------------");
        for(Funcionario f: funcionarios) {
        BigDecimal novoSalario = f.getSalario().multiply(BigDecimal.valueOf(1.1));
        f.setSalario(novoSalario);
        }

        impimirTabela();
    }

    private Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirAgrupadosPorFuncao() {
        System.out.println("------------------------------------------------");
        System.out.println("Funcionários agrupados por função");
        System.out.println("------------------------------------------------");
        Map<String, List<Funcionario>> agrupados = agruparPorFuncao();


        for (Map.Entry<String, List<Funcionario>> entry: agrupados.entrySet()) {
            System.out.println("Função: " + entry.getKey());

            for (Funcionario f: entry.getValue()) {
                System.out.printf("   - %-10s %-12s %-10s%n",
                        f.getNome(),
                        f.getDataNascimento().format(formatter),
                        df.format(f.getSalario())
                );
            }
        }

        System.out.println();
    }

    public void buscarAniversariantesOutDez() {
        System.out.println("------------------------------------------------");
        System.out.println("Aniversariantes Outubro e Dezembro");
        System.out.println("------------------------------------------------");
        System.out.printf("%-10s %-12s %-15s %-15s%n", "Nome", "Nascimento", "Salario", "Cargo");

        for(Funcionario f: funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if(mes == 10 || mes == 12) {
                System.out.printf("%-10s %-12s %-15s %-15s%n",
                        f.getNome(),
                        f.getDataNascimento().format(formatter),
                        df.format(f.getSalario()),
                        f.getFuncao()
                );
            }
        }

        System.out.println();
    }

    public void buscarFuncMaisVelho() {
        System.out.println("------------------------------------------------");
        System.out.println("Funcionário com mais idade");
        System.out.println("------------------------------------------------");

     Funcionario maisVelho = funcionarios.stream()
             .min(Comparator.comparing(Funcionario::getDataNascimento))
             .orElse(null);

     if(maisVelho != null) {
         int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
         System.out.printf("Nome: %s, Idade: %d anos%n",
                 maisVelho.getNome(),
                 idade
         );
     }
        System.out.println();
    }

    public void ordemAlfabetica() {

        System.out.println("------------------------------------------------");
        System.out.println("Lista de funcionários em ordem alfabética");
        System.out.println("------------------------------------------------");

        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.printf("%-10s %-12s %-15s %-15s%n",
                        f.getNome(),
                        f.getDataNascimento().format(formatter),
                        df.format(f.getSalario()),
                        f.getFuncao()
                ));

        System.out.println();
    }



    public void totalSalarios() {
        System.out.println("------------------------------------------------");
        System.out.println("Soma total dos salários dos funcionários");
        System.out.println("------------------------------------------------");


        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        System.out.println("Total dos salários: R$ " + df.format(totalSalarios));
        System.out.println();

    }



    public void salarioMinimo() {
        System.out.println("------------------------------------------------");
        System.out.println("Quantidade de salários mínimos que cada funcionário ganha");
        System.out.println("------------------------------------------------");

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.printf("%-10s %-12s %-15s %-20s%n", "Nome", "Nascimento", "Salario", "Qtd. Salários Mínimos");

        for(Funcionario f: funcionarios) {
            BigDecimal qtdSalarios = f.getSalario()
                    .divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.printf("%-10s %-12s %-15s %-20s%n",
                    f.getNome(),
                    f.getDataNascimento().format(formatter),
                    f.getSalario(),
                    qtdSalarios);
        }

    }




}
