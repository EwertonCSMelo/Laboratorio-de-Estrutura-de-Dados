
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaFinal {
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 8) {
			// MENU PRINCIPAL
			int opcao2 = 0;
			int opcao3 = 0;
			int tipoORD = 0;

			try {

				System.out.println("-------------------------------------------------");
				System.out.println("---------------------LEDA------------------------");
				System.out.println("-------------------------------------------------");
				System.out.println(
						" 1. Selection Sort \n 2. Isertion Sort \n 3. Merge Sort \n 4. Quick Sort \n 5. Quick Sort Com Mediana 3 \n 6. Heap Sort \n 7. Countig Sort \n 8. Sair \n");
				System.out.println("-------------------------------------------------");
				System.out.println("INFORME OPCAO: ");
				opcao = sc.nextInt();
				System.out.println("-------------------------------------------------");
			} catch (InputMismatchException e) {

				System.out.println("Digite uma opcao valida!");
				System.out.printf("Opção: ");
				opcao = input.nextInt();

			}
			switch (opcao) {
			case 1: {
				// Selection Sort
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA ORDENAR:");
					System.out.println(" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						while (opcao2 != 4) {
							System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
							System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
							System.out.println("-------------------------------------------------");
							System.out.printf("INFORME OPCAO:");
							opcao2= input.nextInt();
							System.out.println("-------------------------------------------------");
							switch(opcao2) {
							case 1:{
								System.out.println("Ordenar Pior Caso");
							
							}break;
							case 2:{
								System.out.println("Ordenar Por Caso Medio");
							
							}break;
							case 3:{
								System.out.println("Ordenar Por Melhor Caso");
							}break;
							case 4:{
								
							}break;
							default:
								System.out.println("OPÇÃO INVÁLIDA!");
							}
						}
						
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}

				break;
			case 2: {
				// Isertion Sort
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA CADASTRAR:");
					System.out.println(
							" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}

				break;
			case 3: {
				// Merge Sort
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA CADASTRAR:");
					System.out.println(
							" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}

				break;
			case 4: {
				// Quick Sort
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA CADASTRAR:");
					System.out.println(
							" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}

				break;
			case 5: {
				// Quick Sort Com Media de 3
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA CADASTRAR:");
					System.out.println(
							" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}
				break;
			case 6: {
				// Heap Sort
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA CADASTRAR:");
					System.out.println(
							" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}
				break;
			case 7: {
				// Countig Sort
				while (tipoORD != 4) {
					System.out.println("INFORME A MODALIDADE QUE DESEJA CADASTRAR:");
					System.out.println(
							" 1 - Ordenar Por Casos \n 2 - Ordenar Por Obitos \n 3 - Ordenar Por Nomes \n 4 - Sair\n  ");
					System.out.println("-------------------------------------------------");
					System.out.printf("INFORME OPCAO:");
					tipoORD = input.nextInt();
					System.out.println("-------------------------------------------------");
					switch (tipoORD) {
					case 1: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 2: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;
					case 3: {
						System.out.println("INFORME A COMPLEXIDADE DO TIPO DE ORDENAÇÃO POR CASOS :");
						System.out.println(" 1 - Ordenar - Pior Caso \n 2 - Ordenar Por Caso Medio \n 3 - Ordenar Por Melhor Caso \n 4 - Sair\n  ");
						System.out.println("-------------------------------------------------");
						System.out.printf("INFORME OPCAO:");
						opcao2= input.nextInt();
						System.out.println("-------------------------------------------------");
						switch(opcao2) {
						case 1:{
							System.out.println("Ordenar Pior Caso");
						
						}break;
						case 2:{
							System.out.println("Ordenar Por Caso Medio");
						
						}break;
						case 3:{
							System.out.println("Ordenar Por Melhor Caso");
						}break;
						case 4:{
							
						}break;
						default:
							System.out.println("OPÇÃO INVÁLIDA!");
						}
					}
						break;

					case 4: {

					}
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			}
				break;
			case 8: {
				System.out.println("Fim Do Aplicativo!");
			}
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
			}
		}
	}

}