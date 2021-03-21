package dominio;

public class ContaEspecial extends Conta {
	private Double limite;

	public ContaEspecial(Pessoa cliente, Integer nrConta, Double saldo, CategoriaConta categoria, Double limite) {
		super(cliente, nrConta, saldo, categoria);
		this.limite = limite;
	}


	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	protected Boolean temSaldo(Double valor) {
		return (valor <= (this.saldo + this.limite));
	}
}
