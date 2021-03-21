package aula3;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import dominio.CategoriaConta;
import dominio.Conta;
import dominio.ContaEspecial;
import dominio.ContaPoupanca;
import dominio.Pessoa;
import dominio.PessoaFisica;
import dominio.PessoaJuridica;

public class Menu {

	public void menuPrincipal(Scanner sc) {
		Integer escolha = 1;
		Conta conta;
		Pessoa cliente;
		do {
			this.showMenuPrincipal();
			try {
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					this.cadatrarConta(sc);
					break;

				case 2:
					conta = this.buscarConta(sc);
					this.menuConta(sc, conta);
					break;

				case 3:
					this.cadatrarCliente(sc);
					break;

				case 4:
					this.relatorio(sc);
					break;

				case 5:
					System.out.println("5 – Sair");
					break;

				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 5;
			}
		} while (escolha != 5);

	}

	private void cadatrarCliente(Scanner sc) {

		System.out.println("--- Novo Cliente-----");
		System.out.println("Selecione o tipo de Pessoa");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica");

		Integer tipo = sc.nextInt();

		System.out.println("--- Informe o ID -----");
		Integer id = sc.nextInt();

		System.out.println("--- Informe o Nome -----");
		String nome = sc.nextLine();

		System.out.println("--- Informe o Endereço -----");
		String endereco = sc.nextLine();

		if (tipo == 1) {
			System.out.println("--- Informe o CPF -----");
			String cpf = sc.nextLine();

			System.out.println("--- Informe a Data de Nascimento -----");
			String[] dtAux = sc.next().trim().split("/");

			Date dtNascimento = Date.from(Instant.parse(dtAux[2] + "-" + dtAux[2] + "-" + dtAux[0] + "T00:00:00Z"));

			System.out.println("--- Informe o Genero (M/F) -----");
			String genero = sc.next();

			Main.clientes.add(new PessoaFisica(id, nome, endereco, id, dtNascimento, genero));

		} else {
			System.out.println("--- Informe o Nome -----");
			String cnpj = sc.nextLine();

			System.out.println("--- Informe o Endereço -----");
			String atividade = sc.nextLine();

			Main.clientes.add(new PessoaJuridica(id, nome, endereco, id, atividade));
		}

	}

	private void cadatrarConta(Scanner sc) {

		System.out.println("--- Nova Conta-----");
		System.out.println("Selecione o tipo de Conta");
		System.out.println("1 - Conta Especial");
		System.out.println("2 - Conta Poupanca");

		Integer tipo = sc.nextInt();
		Pessoa cliente = null;

		cliente = this.buscarPessoa(sc);

		System.out.println("--- Informe o Numero da Conta -----");
		Integer nrConta = sc.nextInt();

		System.out.println("--- Informe o Saldo inicial da Conta -----");
		Double saldo = sc.nextDouble();

		Integer cat = 1;
		CategoriaConta categoria = null;

		do {
			System.out.println("Selecione a Categoria da Conta");
			System.out.println("1 - SIMPLES");
			System.out.println("2 - EXECUTIVA");
			System.out.println("3 - PREMIUM");
			System.out.println("4 - PERSONALITE");
			try {
				cat = sc.nextInt();

				
				switch (cat) { 
				case 1:
					categoria = CategoriaConta.SIMPLES;
					break;
				case 2:
					categoria = CategoriaConta.EXECUTIVA;
					break;
				case 3:
					categoria = CategoriaConta.PREMIUM;
					break;
				case 4:
					categoria = CategoriaConta.PERSONALITE;
					break;
				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				cat = 1;
			}
		} while (cat != 1 & cat != 2 & cat != 3 & cat != 4);
		
		if(tipo == 1) {
			System.out.println("--- Informe o limite inicial da Conta Especial -----");
			Double limite = sc.nextDouble();
			
			Main.contas.add(new ContaEspecial(cliente, nrConta, saldo, categoria, limite));
		}
		
		else if(tipo == 2) {
			System.out.println("--- Informe a Taxa de Correcao da Conta Poupanca -----");
			Double txCorrecao = sc.nextDouble();
			
			Main.contas.add(new ContaPoupanca(cliente, nrConta, saldo, categoria, txCorrecao));
		}
	}

	private void menuConta(Scanner sc, Conta conta) {

		Integer escolha = 1;
		do {
			this.showMenuConta(conta);
			try {
				escolha = sc.nextInt();
				Double vr;
				switch (escolha) {
				case 1:
					conta = this.buscarConta(sc);
					break;
				case 2:
					System.out.println("Informe o Valor do Depósito");
					vr = sc.nextDouble();
					conta.depositar(vr);
					break;
				case 3:
					System.out.println("Informe o Valor para Saque");
					vr = sc.nextDouble();
					conta.sacar(vr);

					break;
				case 4:
					Conta dest = this.buscarConta(sc);
					System.out.println("Informe o Valor para Transferência");
					vr = sc.nextDouble();
					conta.transferir(vr, dest);
					break;
				case 5:
					System.out.println("-------------------------");
					System.out.println("--- SALDO: R$ " + conta.getSaldo());
					System.out.println("-------------------------");

					break;
				default:
					escolha = 6;
					break;
				}

			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 6;
			}
		} while (escolha != 6);
	}

	private void showMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 – Abrir Nova Conta");
		System.out.println("2 – Selecionar Conta");
		System.out.println("3 – Cadastrar Cliente");
		System.out.println("4 – Relatórios");
		System.out.println("5 – Sair");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta conta) {
		System.out.println("-------------------------");
		System.out.println("Cliente: " + conta.getCliente().getNome());
		System.out.println("Nr Conta: " + conta.getNrConta());
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 – Alterar Conta");
		System.out.println("2 – Deposito");
		System.out.println("3 – Saque");
		System.out.println("4 – Transferência");
		System.out.println("5 – Saldo");
		System.out.println("6 – Sair");
		System.out.println("-------------------------");
	}

	public Conta buscarConta(Scanner sc) {

		Conta conta = null;
		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o número da Conta---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Conta c : Main.contas) {

				if (c.getNrConta().equals(escolha)) {
					conta = c;
					break;
				}
			}
			if (conta == null) {
				System.out.println("------------------------------");
				System.out.println("-----Conta Não Encontrada-----");
				System.out.println("------------------------------");
			}

		} while (conta == null);

		return conta;
	}

	public Pessoa buscarPessoa(Scanner sc) {
		Pessoa cliente = null;

		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o número do ID do Cliente titular da Conta---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Pessoa cl : Main.clientes) {

				if (cl.getId().equals(escolha)) {
					cliente = cl;
					break;
				}
			}
			if (cliente == null) {
				System.out.println("------------------------------");
				System.out.println("-----Cliente Não Encontrado-----");
				System.out.println("------------------------------");
			}

		} while (cliente == null);

		return cliente;
	}
	
	public void relatorio(Scanner sc) throws MinhaException {
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 – Saldo das Contas");
		System.out.println("2 – Total das Contas");
		
		Integer escolha = sc.nextInt();
		Double saldo = 0.00;
		
		if(escolha == 1) {
			for (Conta c : Main.contas) {
				System.out.println("-------------------------");
				System.out.println("Cliente: " + c.getCliente().getNome());
				System.out.println("Nr Conta: " + c.getNrConta());
				System.out.println("Saldo: R$ " + c.getSaldo());
				System.out.println("-------------------------");
				}
		}
		
		else if (escolha == 2){
			for (Conta c : Main.contas) {
				saldo += c.getSaldo(); 
				}
			System.out.println("-------------------------");
			System.out.println("Saldo total de todas as contas registradas: R$ " +saldo);
			System.out.println("-------------------------");
		}
		else {
			throw new MinhaException("Opção inválida"); 
		}
	}
}
