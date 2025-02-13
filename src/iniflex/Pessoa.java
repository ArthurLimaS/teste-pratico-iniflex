package iniflex;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	
	//	1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
	
	protected String nome;
	protected LocalDate dataNascimento;
	protected DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimentoFormatada() {
		return this.dataNascimento.format(dateFormatter);
	}
	
	public int getIdade() {
		return Period.between(this.dataNascimento, LocalDate.now()).getYears();
	}
}
