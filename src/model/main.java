// SISTEMA DESENVOLVIDO PARA USO PROMPT
// GERENCIADOR DE ACESSOS DE VEÍCULOS
// GRUPO:

// * Daniel Rodrigues da Rocha;
// * Bruno;
// * Amanda;
// * Jésus Gabriel;
// * Gabriel Fenelon.

// VERSÃO 1.0

package model;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;


public class main {
	

	public static void main(String[] args) {
		
		// VARIÁVEIS NECESSÁRIAS PARA O SISTEMA:
		List<Estacionamento> registros;
		
		
		// INSTÂNCIAS NECESSÁRIAS PARA O SISTEMA:
		registros = new LinkedList<Estacionamento>();
		
		// INÍCIO DO SISTEMA:
		exibirMenuPrincipal(registros);
		
		
		

	}
	
	// FUNÇÕES(métodos) NECESSÁRIAS PARA O FUNCIONAMENTO DO SISTEMA:
		public static void exibirMenuPrincipal(List<Estacionamento> banco) {
			
			int escolha = 0;
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			System.out.println("==================================================\n   GERENCIADOR DE ACESSOS DE ESTACIONAMENTO:\n\n"
					+ "Digite a Opção desejada:\n\n" + "(1) Visualizar Estacionamentos;\n(2) Criar um Estacionamento\n"
					+ "(3) Criar um Acesso \n\n================================================== \n\n");
			
				System.out.println("Digite: ");
				escolha = scanner.nextInt();
				distribuidoraDaEscolha(escolha, banco);
		}
		
		public static void distribuidoraDaEscolha(int escolha, List<Estacionamento> banco) {
			
			switch (escolha) {
			
				case 1:
					escolha1(banco);
					break;
				
				case 2:
					escolha2(banco);
					break;
					
				case 3:
					escolha3(banco);
					break;
					
				default:
					limparPrompt();
					System.out.println("Digite somente o número, dentro das possibilidades mencionadas! \n\n Direcionando ao menu...");
					aplicarDelay(3000);
					limparPrompt();
					exibirMenuPrincipal(banco);
			}
			
			
		}
		
		public static void escolha1(List<Estacionamento> banco) {
			
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			System.out.println("==================================================\n         ESTACIONAMENTOS REGISTRADOS:\n========="
					+ "=========================================");
			
			if (banco.size() == 0) {
				System.out.println("\n\n");
				System.out.println("Registre Estacionamentos para Listá-los!");
				aplicarDelay(3000);
				limparPrompt();
				System.out.println("Redirecinando ao menu principal, Aguarde...");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco);
			}
			else {
				for (Estacionamento e: banco) {
					System.out.println("\n\n");
					System.out.println("Nome do Estacionamento: " + e.getNome() + "\nCapacidade: " + e.getCapacidade()
					+ "\nPorcentagem de Retorno: " + e.getRetornoContratante() + "%\nHorário de Funcionamento: Das " +
					e.getHorarioFuncionamento().get(0).getHoraMinuto() + " até " + e.getHorarioFuncionamento().get(1).getHoraMinuto());
					
					System.out.println("\n\n LUCRO TOTAL: R$" +  e.calcularTotalContratante() + "\n\n\n==============="
					+ "===================================");
					
				}
				System.out.println("\n\n\n");
				System.out.println("Dê scroll para cima para visualizar os seus registros.\n\n");
				aplicarDelay(7000);
				System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Verificar Acessos;\n(2) Apagar Estacionamento;\n"
				+ "(3) Voltar ao Menu Principal\n\nDigite: ");
				int resposta = 0; 
				
				resposta = scanner.nextInt();
				distribuicaoEscolha2(resposta, banco);
				
				}
			}
		
		public static void distribuicaoEscolha2(int escolha, List<Estacionamento> banco) {
			
			switch (escolha) {
				case 1:
					escolha1_1(banco);
					break;
				case 2:
				escolha1_2(banco);
					break;
				case 3:
					limparPrompt();
					System.out.println("Redirecinando ao menu principal, Aguarde...");
					aplicarDelay(3000);
					exibirMenuPrincipal(banco);
			}
			
		}
		
		public static void escolha1_1(List<Estacionamento> banco) {
			
			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			int resposta = 0;
			int contador = 0;
			
			while (resposta < 1 || resposta > contador) {
				contador ++;
				
				System.out.println("\n\n");
				System.out.println("Para qual estacionamento você gostaria de verificar os acessos?\n(Digite o número do estacionamento desejado)\n\n");
				
				
				for (Estacionamento e: banco) {
					System.out.println("(" + contador + ") " + e.getNome() + "\n");
					contador ++;
				}
				
				System.out.println("Digite: ");
				resposta = scanner.nextInt();
				
				if (resposta < 1 || resposta > contador) {
					limparPrompt();
					System.out.println("Selecione dentre as opções listadas!");
					aplicarDelay(5000);
					limparPrompt();
					contador = 0;
				}
				
			}

			
			limparPrompt();
			System.out.println("==================================================\n         ACESSOS LIBERADOS:\n========="
					+ "=========================================\n\n");
			
			if (banco.get(resposta - 1).getAcessos().size() == 0) {
				System.out.println("\n\nSem Nenhum Acesso! Faça Acessos através do menu princial.");
				aplicarDelay(3000);
				escolha1(banco);
			}
			else {
				for (Acesso v: banco.get(resposta -1).getAcessos()) {

					System.out.println("Placa do veículo: " + v.getPlacaCarro() + "\n\n");
					System.out.println("==================================================");

				}
			}
			
		}

		public static void escolha1_2(List<Estacionamento> banco) {

			limparPrompt();
			// CLASSE PARA APAGAR UM ESTACIONAMENTO

			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);

			int resposta = 0;
			int contador = 0;

			while (resposta < 1 || resposta >= contador) {
				contador++;

				System.out.println("Qual estacionamento você gostaria de apagar?\n");
			
				for(Estacionamento e: banco) {
					System.out.println("(" + contador + ") " + e.getNome());
					contador++;
				}
	
				System.out.println("\nDigite a sua opção:\n");
				resposta = scanner.nextInt();
	
				
				if (resposta < 1 || resposta >= contador) {
					limparPrompt();
					System.out.println("Escolha dentre as opções listadas!");
					aplicarDelay(3000);
					contador = 0;
				}
				else {
					banco.remove(resposta - 1);
					limparPrompt();
					System.out.println("Estacionamento Apagado!");
					aplicarDelay(3000);

					resposta = 0;

					limparPrompt();

					while (resposta < 1 || resposta > 2) {

						System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Voltar para o Menu Principals;\n(2) Voltar para a Lista de Estacionamentos\n"
						+ "\n\nDigite:");
						resposta = scanner.nextInt();

						if (resposta < 1 || resposta > 2) {
							limparPrompt();
							System.out.println("Escolha dentre as opções listadas!");
							aplicarDelay(3000);
						}
					}

					switch (resposta) {
						case 1:
							limparPrompt();
							System.out.println("Redirecinando ao menu principal, Aguarde...");
							aplicarDelay(3000);
							exibirMenuPrincipal(banco);
							break;
						case 2:
							escolha1(banco);
							break;
					}
				}
			}
			
		} 
			
		
		public static void escolha2(List<Estacionamento> banco) {
			
			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);
			
			// VARIÁVEL DE DIRECIONAMENTO DO SISTEMA:
			int escolha = 1;
			
			while (escolha == 1) {
				// VARIÁVEIS DE CRIAÇÃO:
				String nome;
				int capacidade;
				double retorno;
				
				// INSTRUÇÕES AO USUÁRIO:
				limparPrompt();
				System.out.println("Qual será o nome do estacionamento?\n(Não use espaçamento)\n");
				nome = scanner.next();
				
				System.out.println("\n\nQual a capacidade deste estacionamento?\n(Digite somente os números)\n");
				capacidade = scanner.nextInt();
				
				System.out.println("\n\nQual a taxa -em porcentagem- de retorno do lucro?\n(Digite somente os números)\n");
				retorno = scanner.nextDouble();
				
				// VARIÁVEIS PARA CONFIGURAÇÃO:
				int hI = 0;
				int mI = 0;
				int hF = 0;
				int mF = 0;
				String horaCompleta = "";
				
				while(((hI < 0) || (hI > 23)) || ((mI < 0) || (mI > 59)) || !horaCompleta.contains(":")) {
					
					System.out.println("\n\nQue horas o estacionamento abre?\n(Digite no Formato 'hora:minuto')\n");
					horaCompleta = scanner.next();
					
					if (! horaCompleta.contains(":")) {
						limparPrompt();
						System.out.println("Insira o horário no formato correto: hora:minutos");
						aplicarDelay(3000);
						limparPrompt();
					}
					else {
						//Formatação da String:
						String[] partes = horaCompleta.split(":");
						String horaString = partes[0];  // Hora como string
						String minutoString = partes[1];  // Minuto como string
						
						hI = Integer.parseInt(horaString);  // Hora como int
						mI = Integer.parseInt(minutoString);  // Minuto como int
						
						if (((hI < 0) || (hI > 23)) || ((mI < 0) || (mI > 59))) {
							limparPrompt();
							System.out.println("Insira um horário válido!\n(min: 0:00, máx: 23:59)");
							aplicarDelay(3000);
							limparPrompt();
						}
					}	
				}
				
				horaCompleta = "";
				
				while(((hF < 0) || (hF > 23)) || ((mF < 0) || (mF > 59)) || !horaCompleta.contains(":")) {
					System.out.println("\n\nQue horas o estacionamento fecha?\n(Digite no Formato 'hora:minuto')\n");
					horaCompleta = scanner.next();
					
					if (! horaCompleta.contains(":")) {
						limparPrompt();
						System.out.println("Insira o horário no formato correto: hora:minutos");
						aplicarDelay(3000);
						limparPrompt();
					}
					else {
						//Formatação da String:
						String[] partes = horaCompleta.split(":");
						String horaString = partes[0];  // Hora como string
						String minutoString = partes[1];  // Minuto como string
						
						hF = Integer.parseInt(horaString);  // Hora como int
						mF = Integer.parseInt(minutoString);  // Minuto como int
						
						
						if (((hF < 0) || (hF > 23)) || ((mF < 0) || (mF > 59))) {
							limparPrompt();
							System.out.println("Insira um horário válido!\n(min: 0:00, máx: 23:59)");
							aplicarDelay(3000);
							limparPrompt();
						}
					}
					
				}
				
				Estacionamento criacao = new Estacionamento(nome, capacidade, retorno, hI, mI, hF, mF);
				banco.add(criacao);
				
				limparPrompt();
				
				System.out.println("Estacionamento Criado!");
				aplicarDelay(2000);
				limparPrompt();
				System.out.println("==================================================\n Gostaria de criar outro"
						+ " estacionamento?\n\n Digite a opção desejada: \n\n(1) Sim; \n(2) Não"
						+ "\n==================================================\n\nDigite: ");
				escolha = scanner.nextInt();
				
				
			}
				exibirMenuPrincipal(banco);
			
		}
		
		public static void escolha3(List<Estacionamento> banco) {
			
			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);
						
			limparPrompt();
			System.out.println("==================================================\n         CRIAR NOVO ACESSO:\n========="
					+ "=========================================");
			
			if (banco.size() == 0) {
				System.out.println("\n\n");
				System.out.println("Registre Estacionamentos para criar Acessos!!");
				aplicarDelay(3000);
				limparPrompt();
				System.out.println("Redirecinando ao menu principal, Aguarde...");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco);
			}
			else {
				int resposta = 0;
				int contador = 0;
				boolean situacaoLotado = false;
				
				while (resposta < 1 || resposta >= contador || situacaoLotado == false) {
					contador ++;
					
					System.out.println("\n\n");
					System.out.println("Para qual estacionamento você gostaria de autorizar o acesso?\n(Digite o número do estacionamento desejado)\n\n");
					
					
					for (Estacionamento e: banco) {
						System.out.println("(" + contador + ") " + e.getNome() + "\n");
						contador ++;
					}
					
					System.out.println("Digite: ");
					resposta = scanner.nextInt();
					
					if (resposta < 1 || resposta >= contador) {
						limparPrompt();
						System.out.println("Selecione dentre as opções listadas!");
						aplicarDelay(5000);
						limparPrompt();
						contador = 0;
					}

					situacaoLotado = banco.get(resposta - 1).getSituacaoCapacidade();

					if (situacaoLotado == false) {
						limparPrompt();
						System.out.println("Estacionamento Lotado! Tente apagar algum Acesso");
						aplicarDelay(5000);
						limparPrompt();
						contador = 0;
					}
				}
				
				String placa;
				System.out.println("Insira a placa do Carro:\n");
				placa = scanner.next();
				
				banco.get(resposta - 1).setAcessos(placa);
				
				if (banco.get(resposta - 1).getAcessos().size() == banco.get(resposta - 1).getCapacidade()) {

				}

				limparPrompt();
				System.out.println("Acesso Liberado!");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco);
				
			}
		}
		
		public static void limparPrompt() {
			 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		
		
		public static void aplicarDelay(int tempo) {
			 try {
		            Thread.sleep(tempo);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		}

}
