package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

	Integer operacao;
	List<Cliente> clientes = new ArrayList<>();
	Scanner menu = new Scanner(System.in);

	public Banco() {

	}

	public void cadastrar() {

		Cliente cliente = new Cliente();

		System.out.println("Insira seu nome: ");
		
		menu.nextLine();
		
		cliente.setNome(menu.next());

		System.out.println("Insira seu sal?rio: ");

		cliente.setSalario(menu.nextDouble());

		if (cliente.getSalario() != null) {

			clientes.add(cliente);

			System.out.println("Cliente cadastrado!");

		}

	}

	public void emprestimo() {

		for (Cliente cliente : this.clientes) {

			aplicaEmprestimo(cliente);

		}

	}

	public void aplicaEmprestimo(Cliente cliente) {

		if (cliente.getSalario() >= 500.0) {

			System.out.println("Emprestimo liberado para o cliente " + cliente.getNome()  + " valor = "
					+ (cliente.getSalario() * 0.05));

			cliente.setEmprestimo(cliente.getSalario() * 0.05);

		} else {

			System.out.println("Emprestimo n?o liberado para o cliente " + cliente.getNome());

		}
	}

	public void listar() {

		for (Cliente cliente : this.clientes) {

			System.out.println(cliente.toString());

		}

	}

	public void selecionaOperacao() {

		do {

			System.out.print("##--Bem vindo ao Banco--##\n\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("| Op??o 1 - Novo Cadastro     |\n");
			System.out.print("| Op??o 2 - Empr?stimos       |\n");
			System.out.print("| Op??o 3 - Listar            |\n");
			System.out.print("| Op??o 4 - Sair              |\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("Digite uma op??o: ");

			operacao = menu.nextInt();

			if (operacao == 1) {

				cadastrar();

			} else if (operacao == 2) {

				emprestimo();

			} else {

				listar();

			}

		} while (operacao != 4);

	}

}
