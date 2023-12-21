package conta;
import java.io.IOException;
import java.util.InputMismatchException;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
public class Menu {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		//instanciando a classe
		Scanner read = new Scanner(System.in);
		ContaController contas = new ContaController();
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		System.out.println("\n Criar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while (true) {//declarando variaveis

			System.out.println(conta.util.Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
							  +"********************************************");
			System.out.println("                                            ");
			System.out.println("                                            ");
			System.out.println("********************************************");
			System.out.println("                                            ");
			System.out.println("         1 - Criar Conta                    ");
			System.out.println("         2 - Listar todas as Contas         ");
			System.out.println("         3 - Buscar Conta por Numero        ");
			System.out.println("         4 - Atualizar Dados da Conta       ");
			System.out.println("         5 - Apagar Conta                   ");
			System.out.println("         6 - Sacar                          ");
			System.out.println("         7 - Depositar                      ");
			System.out.println("         8 - Transferir valores entre Contas");
			System.out.println("         9 - Sair                           ");
			System.out.println("********************************************");
			System.out.println("Entre com a opção desejada:                 ");
			System.out.println("                                            "+ Cores.TEXT_RESET);
			try {
			opcao = read.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				read.nextLine();
				opcao=0;
			}
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				Sobre();
				read.close();
				System.exit(0);
			}
			switch (opcao) {
				case 1:
						System.out.println(Cores.TEXT_WHITE_BOLD+ "Criar conta\n\n");
						
						System.out.println("Digite o Número da Agência: ");
						agencia = read.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						read.skip("\\R?");
						titular = read.nextLine();
						
						do {
							System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
							tipo = read.nextInt();
						}while(tipo < 1 && tipo > 2);
						
						System.out.println("Digite o Saldo da Conta (R$):  ");
						saldo = read.nextFloat();
						switch(tipo) {
							case 1 ->
							{
								System.out.println("Digite o Limite de Crédito (R$): ");
								limite = read.nextFloat();
								contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
							}
							case 2 -> {
								System.out.println("Digite o dia do Aniversário da Conta: ");
								aniversario = read.nextInt();
								contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
							
							}
						}
						keyPress();
						break;
				case 2:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
					contas.listarTodas();
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar dados da Conta\n\n");
					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
					keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
					keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_WHITE_BOLD+"\n Opção Inválida!\n");
					keyPress();
					break;
					
			}
		}
	}
		public static void Sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: Eduardo Freitas ");
			System.out.println("Eduardo Freitas - efnascimento.filho2@gmail.com");
			System.out.println("https://github.com/EduFreitas2");
			System.out.println("*********************************************************");
		}	
		public static void keyPress() {

			try {

				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
				System.in.read();

			} catch (IOException e) {
				System.out.println("Você pressionou uma tecla diferente de enter!");

			}
		}
	}


