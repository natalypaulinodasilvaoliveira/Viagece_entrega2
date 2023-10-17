package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Viajantes;

public class ViajanteDAO {
	
	//create
	public void create(Viajantes viajante) {
		String sql = "insert into Viajantes (nome_viajante, email_viajante, senha_viajante) values (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viajante.getNome());
			pstm.setString(2, viajante.getEmail());
			pstm.setString(3, viajante.getSenha());
			
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
	public List<Viajantes> read(){
		List<Viajantes> viajantes = new ArrayList<Viajantes>();
		String sql = "select * from Viajantes";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Viajantes viajante = new Viajantes();
				
				viajante.setId(rset.getInt("id_viajante"));
				viajante.setNome(rset.getString("nome_viajante"));
				viajante.setEmail(rset.getString("email_viajante"));
				viajante.setSenha(rset.getString("senha_viajante"));
			
				viajantes.add(viajante);
			
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
	
	
		
		return viajantes;
	}
	
	
	//update
	
	public void update(Viajantes viajante) {
		String sql = "update Viajantes set nome_viajante = ?, email_viajante = ?, senha_viajante = ? where id_viajante = ?";
			
		Connection conn = null;
		PreparedStatement pstm = null;
	
	
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viajante.getNome());
			pstm.setString(2, viajante.getEmail());
			pstm.setString(3, viajante.getSenha());
			
			pstm.setInt(4, viajante.getId());
			
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
		String sql = "delete from Viajantes where id_viajante = ?";
		
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
	
		public Viajantes readById(int id) {
			Viajantes viajante = new Viajantes();
			String sql = "select * from Viajantes WHERE id_viajante = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
		
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				viajante.setId(rset.getInt("id_viajante"));
				viajante.setNome(rset.getString("nome_viajante"));
				viajante.setEmail(rset.getString("email_viajante"));
				viajante.setSenha(rset.getString("senha_viajante"));
				
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
				
			return viajante;
		}
}
