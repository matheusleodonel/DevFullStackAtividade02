package aula3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dominio.CategoriaConta;
import dominio.Conta;
import dominio.ContaEspecial;
import dominio.ContaPoupanca;
import dominio.Pessoa;
import dominio.PessoaFisica;
import dominio.PessoaJuridica;

public class Main {

	static List<Conta> contas = new ArrayList<Conta>();
	static List<Pessoa> clientes = new ArrayList<Pessoa>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		@SuppressWarnings("deprecation")
		PessoaFisica luiz = new PessoaFisica(1, "Luiz", "Anápolis", 999, new Date(2002, 12, 1), "Masculino");
		@SuppressWarnings("deprecation")
		PessoaFisica maria = new PessoaFisica(2, "Maria", "Goiânia", 888, new Date(2001, 9, 10), "Feminino");

		System.out.println(luiz.getIdade());
		System.out.println(maria.getIdade());
		
		PessoaJuridica apple = new PessoaJuridica(3, "Apple SA", "Califónia", 111, "Tecnologia");
		PessoaJuridica padaria = new PessoaJuridica(4, "Pão de Queijo e Companhia", "Setor Universitário", 222, "Alimentos");
	
		ContaEspecial ceLuiz = new ContaEspecial(luiz, 1, 1000.0, CategoriaConta.SIMPLES, 500.0);
		ContaPoupanca cpMaria = new ContaPoupanca(maria, 2, 500.0, CategoriaConta.PREMIUM, 0.02);
		ContaEspecial ceApple = new ContaEspecial(apple, 3, 100000.0, CategoriaConta.PERSONALITE, 10000.0);
		ContaPoupanca cpPadaria = new ContaPoupanca(padaria, 4, 1500.0,CategoriaConta.EXECUTIVA, 0.03);
		
		Main.clientes.add(luiz);
		Main.clientes.add(maria);
		Main.clientes.add(apple);
		Main.clientes.add(padaria);
		
		Main.contas.add(ceLuiz);
		Main.contas.add(cpMaria);
		Main.contas.add(ceApple);
		Main.contas.add(cpPadaria);
		
		Menu menu = new Menu();
		System.out.println("-------------------------");
		System.out.println("---- Seja Bem Vindo!-----");
		System.out.println("-------------------------");
		menu.menuPrincipal(sc);
		System.out.println("-------------------------");
		System.out.println("-- Programa encerrado!---");
		System.out.println("------- Até Mais!--------");
		System.out.println("-------------------------");
		
		sc.close();

	}

}
