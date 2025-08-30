Teste prático para processo seletivo.

O teste se baseava em desenvolver um projeto em java com os seguintes requisitos:

1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
3 – Deve conter uma classe Principal para executar as seguintes ações:
3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
3.2 – Remover o funcionário “João” da lista.
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
• informação de data deve ser exibido no formato dd/mm/aaaa;
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
3.6 – Imprimir os funcionários, agrupados por função.
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
3.10 – Imprimir a lista de funcionários por ordem alfabética.
3.11 – Imprimir o total dos salários dos funcionários.
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

Finalizando esse teste com muito exercício de fixação de lopes com for e forEach, além do método Stream() para fluxos e leitura de dados.
Para entregar os requisitos de formatação usei alguns métodos já existentes nas classes de tipos usadas como o DataTimeFormatter para definir o formato de datas e o DecimalFormatSymbols
e o DecimalFormat para definir o formato de reprsentação do atributo salário.

Nesse teste usei uma estrutura bem simples, mas fiz a divisão de responsabilidades, oque eu considero muito importantes, ainda mais sabendo que outras pessoas irão ler o código.

