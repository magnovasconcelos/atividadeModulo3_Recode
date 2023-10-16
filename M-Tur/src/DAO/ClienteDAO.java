package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Conexao;
import Modal.Cliente;

public class ClienteDAO {
	// adicionar
	public void cadastrar(Cliente cliente) {
		String sql = "INSERT INTO cliente (CPF_Cliente, Nome_Cliente, Email_Cliente, Telefone_Cliente) "
				+ "VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());
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

	public List<Cliente> getCliente() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> cliente = new ArrayList<Cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		// classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// enquanto existir dados no banco de dados faça
			while (rset.next()) {
				Cliente client = new Cliente();
				client.setCpf(rset.getString("CPF_Cliente"));
				client.setNome(rset.getString("Nome_Cliente"));
				client.setEmail(rset.getString("Email_Cliente"));
				client.setTelefone(rset.getString("Telefone_Cliente"));
				cliente.add(client);
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
		return cliente;
	}

	public void atualizar(Cliente cliente) {
		String sql = "UPDATE cliente SET Nome_Cliente = ?, Email_Cliente = ?, Telefone_Cliente = ?"
				+ "WHERE CPF_Cliente = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getCpf());
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

	// exluir
	public void removerByCpf(String cpf) {
		String sql = "DELETE FROM cliente WHERE CPF_Cliente = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
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
	public Cliente consultarByCpf(String cpf) {
		Cliente cliente = new Cliente();
		String sql = "SELECT * FROM cliente WHERE CPF_Cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			
			rset = pstm.executeQuery();
			rset.next();
			cliente.setCpf(rset.getString("CPF_Cliente"));
			cliente.setNome(rset.getString("Nome_Cliente"));
			cliente.setEmail(rset.getString("Email_Cliente"));
			cliente.setTelefone(rset.getString("Telefone_Cliente"));
			
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
		return cliente;
	}
	
}
