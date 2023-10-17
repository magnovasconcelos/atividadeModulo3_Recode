package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Destino;
import model.Reserva;

public class ReservaDAO {
	// adicionar
	public void cadastrar(Reserva reserva) {
		String sql = "INSERT INTO reserva (Data_Reserva, Valor_Reserva, Forma_Pagamento, fk_Cliente_CPF_Cliente, fk_Destino_Id_Destino) "
				+ "VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			
			LocalDate data = reserva.getDataReserva();
			java.sql.Date sqlDate = java.sql.Date.valueOf(data);
			
			pstm.setDate(1, sqlDate);
			pstm.setDouble(2, reserva.getValorReserva());
			pstm.setString(3, reserva.getFormaPagamento());
			pstm.setString(4, reserva.getCliente().getCpf());
			pstm.setInt(5, reserva.getDestino().getId());
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

	public List<Reserva> getReserva() {
		String sql = "SELECT * FROM reserva";
		List<Reserva> reserva = new ArrayList<Reserva>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Reserva reserv = new Reserva();
				Cliente cliente = new Cliente();
				Destino destino = new Destino();
				
				java.sql.Date sqlDate = rset.getDate("Data_Reserva");
				LocalDate data = sqlDate.toLocalDate();
				
				
				reserv.setNumeroReserva(rset.getInt("Numero_Reserva"));
				reserv.setDataReserva(data);
				reserv.setValorReserva(rset.getDouble("Valor_Reserva"));
				reserv.setFormaPagamento(rset.getString("Forma_Pagamento"));
				cliente.setCpf(rset.getString("fk_Cliente_CPF_Cliente"));
				reserv.setCliente(cliente);
				destino.setId(rset.getInt("fk_Destino_Id_Destino"));
				reserv.setDestino(destino);
				reserva.add(reserv);
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
		return reserva;
	}

	public void atualizar(Reserva reserva) {
		String sql = "UPDATE reserva SET Data_Reserva = ?, Valor_Reserva = ?, Forma_Pagamento = ? "
				+ " WHERE Numero_Reserva = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			
			LocalDate data = reserva.getDataReserva();
			java.sql.Date sqlDate = java.sql.Date.valueOf(data);
			
			pstm.setDate(1, sqlDate);
			pstm.setDouble(2, reserva.getValorReserva());
			pstm.setString(3, reserva.getFormaPagamento());
			pstm.setInt(4, reserva.getNumeroReserva());
			pstm.executeUpdate();
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

	// exluir
	public void removerByNumeroReserva(int numeroReserva) {
		String sql = "DELETE FROM reserva WHERE Numero_Reserva = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, numeroReserva);
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
	
	public Reserva consultarByNumeroReserva(int numeroReserva) {
		Reserva reserva = new Reserva();
		Cliente cliente = new Cliente();
		Destino destino = new Destino();
		String sql = "SELECT * FROM reserva WHERE Numero_Reserva = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, numeroReserva);

			rset = pstm.executeQuery();
			rset.next();

			java.sql.Date sqlDate = rset.getDate("Data_Reserva");
			LocalDate data = sqlDate.toLocalDate();
			
			reserva.setNumeroReserva(rset.getInt("Numero_Reserva"));
			reserva.setDataReserva(data);
			reserva.setValorReserva(rset.getDouble("Valor_Reserva"));
			reserva.setFormaPagamento(rset.getString("Forma_Pagamento"));
			cliente.setCpf(rset.getString("fk_Cliente_CPF_Cliente"));
			reserva.setCliente(cliente);
			destino.setId(rset.getInt("fk_Destino_Id_Destino"));
			reserva.setDestino(destino);
			
		} catch (

		Exception e) {
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
		return reserva;
	}
}
