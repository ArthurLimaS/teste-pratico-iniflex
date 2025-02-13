package iniflex;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
	
	// 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
	
	private BigDecimal salario;
	private String funcao;
	private NumberFormat numeroFormatter = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));
	
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return "Nome: " + this.nome + "\t|\tData Nascimento: " + this.getDataNascimentoFormatada() +
				"\t|\tSalário: R$ " + this.numeroFormatter.format(this.salario) + "\t|\tFunção: " + this.funcao;
	}
}
