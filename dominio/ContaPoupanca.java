package dominio;

public class ContaPoupanca extends Conta {

	private Double txCorrecao;
	
	public ContaPoupanca(Pessoa cliente, Integer nrConta, Double saldo, CategoriaConta categoria, Double txCorrecao) {
		super(cliente, nrConta, saldo, categoria);
		this.txCorrecao = txCorrecao;
	}

	public Double getTxCorrecao() {
		return txCorrecao;
	}

	public void setTxCorrecao(Double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}

	
	
}
