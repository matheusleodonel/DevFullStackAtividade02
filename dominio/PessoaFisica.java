package dominio;

import java.util.Calendar;
import java.util.Date;

public class PessoaFisica extends Pessoa {
	
	public PessoaFisica(Integer id, String nome, String endereco, Integer cpf, Date dtNascimento, String genero) {
		super(id, nome, endereco);
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
	}

	private Integer cpf;
	private Date dtNascimento;
	private String genero;
	
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Integer getIdade() {
		Calendar calHoje = Calendar.getInstance();
		Calendar calNascimento = Calendar.getInstance();
		calNascimento.setTime(dtNascimento);
		
		@SuppressWarnings("deprecation")
		int anoNascimento = dtNascimento.getYear(); 
		int anoAtual = calHoje.get(Calendar.YEAR);
		
		if (calNascimento.getTimeInMillis() >= calHoje.getTimeInMillis()) { 
			return anoAtual - anoNascimento; 
		} else {
			return anoAtual - anoNascimento - 1;
		}
		
	}
	
	
}
