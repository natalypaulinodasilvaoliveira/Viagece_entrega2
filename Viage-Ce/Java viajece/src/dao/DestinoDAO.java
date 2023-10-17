package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destinos;

public class DestinoDAO {
	//create
		public void create(Destinos destino) {
			String sql = "insert into Destinos (data_entrada, data_saida, valor_compra) values (?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, destino.getData_entrada());
				pstm.setString(2, destino.getData_saida());
				pstm.setDouble(3, destino.getValor_compra());
				
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
		public List<Destinos> read(){
			List<Destinos> destinos = new ArrayList<Destinos>();
			String sql = "select * from Destinos";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					Destinos destino = new Destinos();
					
					destino.setId(rset.getInt("id_destino"));
					destino.setData_entrada(rset.getString("data_entrada"));
					destino.setData_saida(rset.getString("data_saida"));
					destino.setValor_compra(rset.getInt("valor_compra"));
				
					destinos.add(destino);
				
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
		
		
			
			return destinos;
		}
		
		
		//update
		
		public void update(Destinos destino) {
			String sql = "update Destinos set data_entrada = ?, data_saida = ?, valor_compra = ? where id_destino = ?";
				
			Connection conn = null;
			PreparedStatement pstm = null;
		
		
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, destino.getData_entrada());
				pstm.setString(2, destino.getData_saida());
				
				pstm.setInt(4, destino.getId());
				pstm.setDouble(3, destino.getValor_compra());
				
				
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
			String sql = "delete from Destinos where id_destino = ?";
			
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
		
			public Destinos readById(int id) {
				Destinos destino = new Destinos();
				String sql = "select * from Destinos WHERE id_destino = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
			
				try {
					conn = ConnectionMySQL.createConnectionMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					
					rset = pstm.executeQuery();
					
					rset.next();
					
					destino.setId(rset.getInt("id_destino"));
					destino.setData_entrada(rset.getString("data_entrada"));
					destino.setData_saida(rset.getString("data_saida"));
					destino.setValor_compra(rset.getInt("valor_compra"));
					
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
					
				return destino;
			}
}