package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import modelos.Destinos;

public class DestinosCRUD {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		DestinoDAO destinoDAO = new DestinoDAO();
		
		int opcao = 0, id = 0;
		
		String data_entrada ="", data_saida="";
		
		double valor_compra = 0;
		
		do {
			
			System.out.println("\n================ DESTINOS ================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID   0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data de entrada: ");
				data_entrada = s.nextLine();
				System.out.println("Digite a data saida: ");
				data_saida = s.nextLine();
				System.out.println("Digite o valor da compra: ");
				valor_compra = s.nextInt();
				
				
				Destinos destino1 = new Destinos(data_entrada, data_saida, valor_compra);
				
				destinoDAO.create(destino1);
				break;
			
			case 2:
				
				for (Destinos v : destinoDAO.read()) {
					System.out.println(v.toString());
				}
				
				break;
			
			case 3:
				
				System.out.println("Digite o id: ");
				id = s.nextInt();
				System.out.println("Digite a data de entrada: ");
				data_entrada = s.nextLine();
				System.out.println("Digite a data saida: ");
				data_saida = s.nextLine();
				System.out.println("Digite o valor da compra: ");
				valor_compra = s.nextInt();
			
				
				Destinos destino2 = new Destinos(data_entrada, data_saida, valor_compra);
				
				destinoDAO.update(destino2);
				
				break;
			
			case 4:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
				
				destinoDAO.delete(id);
				break;
			
			case 5:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
						
				Destinos destino3 = destinoDAO.readById(id);
				
				System.out.println(destino3.toString());
				
				break;
				
			default:
				
				break;
			}
						
		}while (opcao != 0);
		
		
			
		System.out.println("Até mais !");
		s.close();
		}

}
