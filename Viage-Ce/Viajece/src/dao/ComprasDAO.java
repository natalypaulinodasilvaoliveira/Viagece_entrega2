package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Compras;
import modelos.Destinos;
import modelos.Viajantes;

public class ComprasDAO {
	//create
		public void create(Compras compra) {
			String sql = "insert into Compras (codigo_reserva, valor_total, data_compra, id_destino, id_viajante) values (?, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, compra.getId());
				pstm.setString(2, compra.getData_compra());
				pstm.setDouble(3, compra.getTotal_compra());
				
				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		//read
		public List<Compras> read(){
			List<Compras> compras = new ArrayList<Compras>();
			String sql = "select * from Compras";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					Compras compra = new Compras ();
					Destinos destino = new Destinos ();
					Viajantes viajante = new Viajantes();
					
					compra.setId(rset.getInt("codigo_reserva"));
					compra.setData_compra(rset.getString("data_compra"));
					compra.setTotal_compra(rset.getDouble("total_compra"));
					
					destino.setId(rset.getInt("id_destino"));
					destino.setData_entrada(rset.getString("data_entrada"));
					destino.setData_saida(rset.getString("data_saida"));
					destino.setValor_compra(rset.getDouble("valor_compra"));
					
					
					viajante.setId(rset.getInt("id_viajante"));
					viajante.setNome(rset.getString("nome_viajante"));
					viajante.setEmail(rset.getString("email_viajante"));
					viajante.setSenha(rset.getString("senha_viajante"));
				
					compras.add(compra);
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		
			
			return compras;
		}
		
		
		//update
		
		public void update(Compras compra) {
			String sql = "update Compras set data_compra = ?, valor_total = ?, id_viajante = ?, id_destino = ?";
				
			Connection conn = null;
			PreparedStatement pstm = null;
		
		
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, compra.getData_compra());
				pstm.setDouble(2, compra.getTotal_compra());
				
				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		//delete
		
		public void delete(int id) {
			String sql = "delete from Compras where codigo_reserva = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
		
		
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		//readById
		
			public Compras readById(int id) {
				Compras compra = new Compras();
				String sql = "select * from Compras WHERE codigo_reserva = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
			
				try {
					conn = ConnectionMySQL.createConnectionMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					
					rset = pstm.executeQuery();
					
					rset.next();
					
					compra.setId(rset.getInt("codigo_reserva"));
					compra.setData_compra(rset.getString("data_compra"));
					compra.setTotal_compra(rset.getDouble("total_compra"));
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (pstm != null) {
							pstm.close();
						}
						if (conn != null) {
							conn.close();
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
					
				return compra;
			}

}
