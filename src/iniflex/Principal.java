package iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
	public static void main(String[] args) {
		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
		List<Funcionario> funcionarios = List.of(
				new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
				new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
				new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
				new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
				new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
				new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
				new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
				new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
				new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
				new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
		);
		
		// 3.2 – Remover o funcionário “João” da lista.
		funcionarios = funcionarios.stream()
								   .filter(func -> func.getNome() != "João")
								   .toList();
		
		/* 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
	    • informação de data deve ser exibido no formato dd/mm/aaaa;
	    • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula. */
		System.out.println("IMPRIMIR TODOS OS FUNCIONÁRIOS COM TODAS SUAS INFORMAÇÕES");
		funcionarios.forEach(func -> System.out.println(func));
		System.out.println();
		
		// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
		funcionarios.forEach(func -> {
			
			BigDecimal novoSalario = func.getSalario().multiply(BigDecimal.valueOf(1.1));
			func.setSalario(novoSalario.setScale(2, RoundingMode.CEILING));
		
		});
		
		
		// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
		Map<String, List<Funcionario>> funcionariosAgrupadosChaves = funcionarios.stream()
																			     .collect(Collectors.groupingBy(func -> func.getFuncao()));
		
        // 3.6 – Imprimir os funcionários, agrupados por função.
		System.out.println("IMPRIMIR OS FUNCIONÁRIOS, AGRUPADOS POR FUNÇÃO");
		funcionariosAgrupadosChaves.forEach((funcao, grupoFuncionarios) -> {
			
			System.out.print(funcao + ":");
			grupoFuncionarios.forEach(func -> System.out.print(" " + func.getNome()));
			System.out.println();
		
		});
		System.out.println();

		// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
		System.out.println("IMPRIMIR OS FUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO NO MÊS 10 E 12");
		funcionarios.stream()
					.filter(func -> (func.getDataNascimento().getMonthValue() == 10) || 
									(func.getDataNascimento().getMonthValue() == 12))
					.toList()
					.forEach(func -> System.out.println(func.getNome() + " - Data Aniversário: " + func.getDataNascimentoFormatada()));
		System.out.println();
		
        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
		System.out.println("IMPRIMIR O FUNCIONÁRIO COM A MAIOR IDADE, EXIBIR OS ATRIBUTOS: NOME E IDADE");
		Funcionario funcMaisVelho = funcionarios.stream()
												.max(Comparator.comparingInt(func -> func.getIdade()))
												.get();
		System.out.println(funcMaisVelho.getNome() + " - Idade: " + funcMaisVelho.getIdade() + "\n");
		
        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
		System.out.println("IMPRIMIR A LISTA DE FUNCIONÁRIOS POR ORDEM ALFABÉTICA");
		funcionarios.stream()
					.sorted(Comparator.comparing(func -> func.getNome()))
					.toList()
					.forEach(func -> System.out.println(func.getNome()));
		System.out.println();
		
        // 3.11 – Imprimir o total dos salários dos funcionários.
		System.out.println("IMPRIMIR O TOTAL DOS SALÁRIOS DO FUNCIONÁRIOS");
		BigDecimal totalSalarios = funcionarios.stream()
											   .map(func -> func.getSalario())
											   .reduce(BigDecimal.ZERO, (total, novoSalario) -> total.add(novoSalario));
		
		System.out.println("Soma dos salários: " + totalSalarios + "\n");
		
        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
		System.out.println("IMPRIMIR QUANTOS SALÁRIOS MÍNIMOS GANHA CADA FUNCIONÁRIO, CONSIDERANDO QUE O SALÁRIO MÍNIMO É R$ 1212,00");
		funcionarios.forEach(func -> {
			BigDecimal qntSalariosMin = func.getSalario().divide(BigDecimal.valueOf(1212), RoundingMode.HALF_UP);
			System.out.println(func.getNome() + ": " + qntSalariosMin + " salários mínimos");
		});
		
	}
}
