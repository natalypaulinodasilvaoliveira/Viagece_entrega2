package crud;

import java.util.Scanner;

import dao.ViajanteDAO;
import modelos.Viajantes;

public class ViajantesCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ViajanteDAO viajanteDAO = new ViajanteDAO();
		int opcao = 0, id = 0;
		
		String nome ="", email="", senha="";
		
		do {
			
			System.out.println("\n================ VIAJANTES ================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID   0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				nome = s.nextLine();
				System.out.println("Digite o email: ");
				email = s.nextLine();
				System.out.println("Digite a senha: ");
				senha = s.nextLine();
				
				
				Viajantes viajante1 = new Viajantes(nome, email, senha);
				
				viajanteDAO.create(viajante1);
				break;
			
			case 2:
				
				for (Viajantes v : viajanteDAO.read()) {
					System.out.println(v.toString());
				}
				
				break;
			
			case 3:
				
				System.out.println("Digite o id: ");
				id = s.nextInt();
				System.out.println("Digite o nome: ");
				nome = s.nextLine();
				System.out.println("Digite o email: ");
				email = s.nextLine();
				System.out.println("Digite a senha: ");
				senha = s.nextLine();
				
				Viajantes viajante2 = new Viajantes(id, nome, email, senha);
				
				viajanteDAO.update(viajante2);
				break;
			
			case 4:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
				
				viajanteDAO.delete(id);
				break;
			
			case 5:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
						
				Viajantes viajante3 = viajanteDAO.readById(id);
				
				System.out.println(viajante3.toString());
				
				break;
				
			default:
				
				break;
			}
						
		}while (opcao != 0);
		
		
			
		System.out.println("Até mais !");
		s.close();
		}

}