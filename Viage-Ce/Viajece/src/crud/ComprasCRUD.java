package crud;

import java.util.Scanner;

import dao.ComprasDAO;
import dao.DestinoDAO;
import dao.ViajanteDAO;
import modelos.Compras;
import modelos.Destinos;
import modelos.Viajantes;


public class ComprasCRUD {
public static void main(String[] args) {
		

		Scanner s = new Scanner(System.in);
		
		ComprasDAO compraDAO = new ComprasDAO();
		ViajanteDAO viajanteDAO = new ViajanteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();		
		
		int opcao = 0, id = 0, id_viajante = 0, id_destino = 0;
		
		String data_compra ="";
		double valor_total = 0;
		
		do {
			
			System.out.println("\n================ COMPRAS ================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID   0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data da compra: ");
				data_compra = s.nextLine();
				System.out.println("Digite o id do viajante: ");
				id_viajante = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor total: ");
				valor_total = s.nextDouble();
				
		
				Viajantes viajante1 = viajanteDAO.readById(id_viajante);
				Destinos destino1 = destinoDAO.readById(id_destino);				
				
				Compras compra1 = new Compras();
				
				compraDAO.create(compra1);
				
				
				break;
			
			case 2:
				
				for (Compras v : compraDAO.read()) {
					System.out.println(v.toString());
				}
				
				break;
			
			case 3:
				System.out.println("Digite o Id da compra: ");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data da compra: ");
				data_compra = s.nextLine();
				System.out.println("Digite o valor total: ");
				valor_total = s.nextDouble();				
				System.out.println("Digite o id do viajante: ");
				id_viajante = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = s.nextInt();
				s.nextLine();
				
				
				Viajantes viajante2 = viajanteDAO.readById(id_viajante);
				Destinos destino2 = destinoDAO.readById(id_destino);				
				
				Compras compra2 = new Compras ();
				
				compraDAO.update(compra2);
				break;
			
			case 4:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
				
				compraDAO.delete(id);
				break;
			
			case 5:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
						
				Compras compra3 = compraDAO.readById(id);
				
				System.out.println(compra3.toString());
				
				break;
				
			default:
				
				break;
			}
						
		}while (opcao != 0);
		
		
			
		System.out.println("Até mais !");
		s.close();
		}
}