package Default;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.ContatoDAO;
import DAO.DestinoDAO;
import DAO.ReservaDAO;
import Modal.Cliente;
import Modal.Contato;
import Modal.Destino;
import Modal.Reserva;

public class TesteAplicacao {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAO();
		ContatoDAO contatoDAO = new ContatoDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		DestinoDAO destinoDAO = new DestinoDAO();

		int opcao = 0, opcao2 = 0;
		Scanner entradaMenu = new Scanner(System.in);

		do {
			System.out.println(
					"\n                             M-Tur - a sua agencia de viagem                        \n");
			System.out.println(
					"***********************************   1 - Menu Cliente   *******************************");
			System.out.println(
					"***********************************   2 - Menu Contato   *******************************");
			System.out.println(
					"***********************************   3 - Menu Reserva   *******************************");
			System.out.println(
					"***********************************   4 - Menu Destino   *******************************");
			System.out.println(
					"***********************************   0 - Menu Sair      *******************************");

			opcao = entradaMenu.nextInt();

			switch (opcao) {
			case 1:
				// Menu Cliente
				System.out.println(
						"\n                                  M-Tur - Menu Cliente                              \n");
				System.out.println(
						"*************************************   1 - Cadastrar   ********************************");
				System.out.println(
						"*************************************   2 - Consultar   ********************************");
				System.out.println(
						"*************************************   3 - Atualizar   ********************************");
				System.out.println(
						"*************************************   4 - Deletar     ********************************");
				System.out.println(
						"*************************************   5 - Consultar Por CPF     **********************");
				System.out.println(
						"*************************************   0 - Voltar      ********************************");

				String cpfCliente = "", nome = "", email = "", telefone = "";
				opcao2 = entradaMenu.nextInt();

				switch (opcao2) {
				// Início cliente
				case 1:
					Scanner cadastrar = new Scanner(System.in);

					System.out.print("Digite o CPF: ");
					cpfCliente = cadastrar.nextLine();

					System.out.print("Digite o Nome: ");
					nome = cadastrar.nextLine();

					System.out.print("Digite o Email: ");
					email = cadastrar.nextLine();

					System.out.print("Digite o Telefone: ");
					telefone = cadastrar.nextLine();

					Cliente clienteCadastrar = new Cliente(cpfCliente, nome, email, telefone);

					clienteDAO.cadastrar(clienteCadastrar);
					break;
				case 2:

					for (Cliente c : clienteDAO.getCliente()) {
						System.out.println(c.toString());
					}
					break;
				case 3:
					Scanner atualizar = new Scanner(System.in);

					System.out.print("Digite o CPF: ");
					cpfCliente = atualizar.nextLine();

					System.out.print("Digite o Nome: ");
					nome = atualizar.nextLine();

					System.out.print("Digite o Email: ");
					email = atualizar.nextLine();

					System.out.print("Digite o Telefone: ");
					telefone = atualizar.nextLine();

					Cliente clienteAtualizar = new Cliente(cpfCliente, nome, email, telefone);
					clienteDAO.atualizar(clienteAtualizar);
					break;
				case 4:
					Scanner remover = new Scanner(System.in);

					System.out.println("Digite o CPF: ");
					cpfCliente = remover.next();

					clienteDAO.removerByCpf(cpfCliente);
					break;

				case 5:
					Scanner consultar = new Scanner(System.in);

					System.out.println("Digite o CPF: ");
					cpfCliente = consultar.next();
					Cliente clienteConsultar = new Cliente();
					clienteConsultar = clienteDAO.consultarByCpf(cpfCliente);
					System.out.println(clienteConsultar.toString());
					break;

				default:
					System.out.println("Menu Principal...");
					break;
				}
				// Fim cliente
				break;
			case 2:
				// Menu Contato
				System.out.println(
						"\n                                  M-Tur - Menu Contato                              \n");
				System.out.println(
						"*************************************   1 - Cadastrar   ********************************");
				System.out.println(
						"*************************************   2 - Consultar   ********************************");
				System.out.println(
						"*************************************   3 - Atualizar   ********************************");
				System.out.println(
						"*************************************   4 - Deletar     ********************************");
				System.out.println(
						"*************************************   5 - Consultar Por CPF     **********************");
				System.out.println(
						"*************************************   0 - Voltar      ********************************");

				String assunto = "", mensagem = "", cpfContato = "";
				opcao2 = entradaMenu.nextInt();

				switch (opcao2) {
				// Início contato
				case 1:
					Scanner cadastrar = new Scanner(System.in);

					System.out.print("Digite o Assunto: ");
					assunto = cadastrar.nextLine();

					System.out.print("Digite a Mensagem: ");
					mensagem = cadastrar.nextLine();

					System.out.print("Digite o CPF: ");
					cpfContato = cadastrar.nextLine();

					Cliente clienteContato = new Cliente();
					clienteContato.setCpf(cpfContato);

					Contato contatoCadastrar = new Contato(assunto, mensagem, clienteContato);

					contatoDAO.cadastrar(contatoCadastrar);

					break;
				case 2:

					for (Contato c : contatoDAO.getContato()) {
						System.out.println(c.toString());
					}

					break;
				case 3:
					Scanner atualizar = new Scanner(System.in);

					System.out.print("Digite o CPF: ");
					cpfContato = atualizar.nextLine();

					System.out.print("Digite o Assunto: ");
					assunto = atualizar.nextLine();

					System.out.print("Digite a Mensagem: ");
					mensagem = atualizar.nextLine();

					Cliente clienteAtualizar = new Cliente();
					clienteAtualizar.setCpf(cpfContato);
					Contato contatoAtualizar = new Contato(assunto, mensagem, clienteAtualizar);

					contatoDAO.atualizar(contatoAtualizar);

					break;
				case 4:
					Scanner remover = new Scanner(System.in);
					System.out.print("Digite o CPF: ");
					cpfContato = remover.nextLine();

					Cliente clienteRemover = new Cliente();

					clienteRemover.setCpf(cpfContato);
					contatoDAO.removerByCpf(cpfContato);

					break;

				case 5:
					Scanner consultar = new Scanner(System.in);
					System.out.print("Digite o CPF: ");
					cpfContato = consultar.nextLine();

					Contato clienteconsultar = contatoDAO.consultarByCpf(cpfContato);

					System.out.println(clienteconsultar.toString());

					break;
				default:
					System.out.println("Menu Principal...");
					break;
				}
				// Fim contato
				break;
			case 3:
				// inicio reserva
				System.out.println(
						"\n                                  M-Tur - Menu Reserva                              \n");
				System.out.println(
						"*************************************   1 - Cadastrar   ********************************");
				System.out.println(
						"*************************************   2 - Consultar   ********************************");
				System.out.println(
						"*************************************   3 - Atualizar   ********************************");
				System.out.println(
						"*************************************   4 - Deletar     ********************************");
				System.out.println(
						"*************************************   5 - Consultar Por Numero da Reserva     ********");
				System.out.println(
						"*************************************   0 - Voltar      ********************************");

				String dataReserva = "", formaPagamento = "", cpfReserva = "";
				int idReserva = 0, numeroReserva;
				double valorReserva = 0;
				opcao2 = entradaMenu.nextInt();

				switch (opcao2) {
				case 1:
					Scanner cadastrar = new Scanner(System.in);

					System.out.print("Digite a Data de Reserva (yyyy-MM-dd): ");
					dataReserva = cadastrar.next();
					SimpleDateFormat formatoDataCadastro = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date converterDataCadastro = null;

					try {
						converterDataCadastro = formatoDataCadastro.parse(dataReserva);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					LocalDate dataCadastrar = converterDataCadastro.toInstant().atZone(ZoneId.systemDefault())
							.toLocalDate();

					System.out.print("Digite o Valor da Reserva: ");
					valorReserva = cadastrar.nextDouble();
					cadastrar.nextLine();

					System.out.print("Digite a Forma de Pagamento: ");
					formaPagamento = cadastrar.nextLine();

					System.out.print("Digite o CPF do Usuario: ");
					cpfReserva = cadastrar.nextLine();

					System.out.print("Digite o Id do Destino: ");
					idReserva = cadastrar.nextInt();

					Cliente clienteReserva = new Cliente();
					clienteReserva.setCpf(cpfReserva);

					Destino destinoReserva = new Destino();
					destinoReserva.setId(idReserva);

					Reserva reservaCadastrar = new Reserva(dataCadastrar, valorReserva, formaPagamento, clienteReserva,
							destinoReserva);

					reservaDAO.cadastrar(reservaCadastrar);

					break;
				case 2:

					for (Reserva r : reservaDAO.getReserva()) {
						System.out.println(r.toString());
					}

					break;
				case 3:

					Scanner atualizar = new Scanner(System.in);

					System.out.print("Digite o Numero da Reserva: ");
					numeroReserva = atualizar.nextInt();
					atualizar.nextLine();

					System.out.print("Digite a Data de Reserva (yyyy-MM-dd): ");
					dataReserva = atualizar.next();
					SimpleDateFormat formatoDataatualizar = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date converterDataAtualizar = null;

					try {
						converterDataAtualizar = formatoDataatualizar.parse(dataReserva);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					LocalDate dataAtualizar = converterDataAtualizar.toInstant().atZone(ZoneId.systemDefault())
							.toLocalDate();

					System.out.print("Digite o Valor da Reserva: ");
					valorReserva = atualizar.nextDouble();
					atualizar.nextLine();

					System.out.print("Digite a Forma de Pagamento: ");
					formaPagamento = atualizar.nextLine();

					Reserva destinoAtualizar = new Reserva(numeroReserva, dataAtualizar, valorReserva, formaPagamento);

					reservaDAO.atualizar(destinoAtualizar);

					break;
				case 4:

					Scanner remover = new Scanner(System.in);

					System.out.print("Digite o Numero da sua Reserva: ");
					numeroReserva = remover.nextInt();

					Reserva removerReserva = new Reserva();
					removerReserva.setNumeroReserva(numeroReserva);
					reservaDAO.removerByNumeroReserva(numeroReserva);

					break;

				case 5:

					Scanner consultar = new Scanner(System.in);

					System.out.print("o Numero da sua Reserva: ");
					numeroReserva = consultar.nextInt();

					Reserva consultarReserva = new Reserva();
					consultarReserva = reservaDAO.consultarByNumeroReserva(numeroReserva);
					System.out.println(consultarReserva.toString());

					break;

				default:
					System.out.println("Menu Principal...");
					break;
				}

				break;

			case 4:
				// inicio destino
				System.out.println(
						"\n                                  M-Tur - Menu Destino                              \n");
				System.out.println(
						"*************************************   1 - Cadastrar   ********************************");
				System.out.println(
						"*************************************   2 - Consultar   ********************************");
				System.out.println(
						"*************************************   3 - Atualizar   ********************************");
				System.out.println(
						"*************************************   4 - Deletar     ********************************");
				System.out.println(
						"*************************************   5 - Consultar Por Id     **********************");
				System.out.println(
						"*************************************   0 - Voltar      ********************************");

				String nomeDestino = "";
				double precoDestino = 0;
				int idDestino = 0;
				opcao2 = entradaMenu.nextInt();

				switch (opcao2) {
				case 1:

					Scanner cadastrar = new Scanner(System.in);

					System.out.println("Digite o nome do destino: ");
					nomeDestino = cadastrar.nextLine();

					System.out.println("Digite o valor do destino: ");
					precoDestino = cadastrar.nextDouble();

					Destino destinoCadastrar = new Destino(nomeDestino, precoDestino);

					destinoDAO.cadastrar(destinoCadastrar);

					break;
				case 2:

					for (Destino d : destinoDAO.getDestino()) {
						System.out.println(d.toString());
					}

					break;
				case 3:

					Scanner atualizar = new Scanner(System.in);

					System.out.println("Digite o Id do Destino");
					idDestino = atualizar.nextInt();
					atualizar.nextLine();

					System.out.println("Digite o nome do destino: ");
					nomeDestino = atualizar.nextLine();

					System.out.println("Digite o valor do destino: ");
					precoDestino = atualizar.nextDouble();

					Destino destinoAtualizar = new Destino(idDestino, nomeDestino, precoDestino);

					destinoDAO.atualizar(destinoAtualizar);

					break;
				case 4:

					Scanner remover = new Scanner(System.in);

					System.out.println("Digite o Id do Destino");
					idDestino = remover.nextInt();

					Destino destinoRemover = new Destino();
					destinoRemover.setId(idDestino);
					destinoDAO.removerById(idDestino);

					break;

				case 5:

					Scanner consultar = new Scanner(System.in);

					System.out.println("Digite o Id do Destino");
					idDestino = consultar.nextInt();

					Destino consultarDestino = new Destino();
					consultarDestino = destinoDAO.consultarById(idDestino);
					System.out.println(consultarDestino.toString());

					break;

				default:
					System.out.println("Menu Principal...");
					break;
				}

				break;

			}

		} while (opcao != 0);

		System.out.println("Sair do sistema");
	}
}
