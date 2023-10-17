package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Contato;

public class ContatoDAO {
	// adicionar
	public void cadastrar(Contato contato) {
		String sql = "INSERT INTO contato (Assunto, Mensagem, fk_Cliente_CPF_Cliente) " + "VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getAssunto());
			pstm.setString(2, contato.getMensagem());
			pstm.setString(3, contato.getCliente().getCpf());
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

	public List<Contato> getContato() {
		String sql = "SELECT * FROM contato";
		List<Contato> contato = new ArrayList<Contato>();
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
				Contato contat = new Contato();
				Cliente client = new Cliente();
				contat.setAssunto(rset.getString("Assunto"));
				contat.setMensagem(rset.getString("Mensagem"));
				client.setCpf(rset.getString("fk_Cliente_CPF_Cliente"));
				contat.setCliente(client);
				contato.add(contat);
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
		return contato;
	}

	public void atualizar(Contato contato) {
		String sql = "UPDATE contato SET Assunto = ?, Mensagem = ?" + "WHERE fk_Cliente_CPF_Cliente = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getAssunto());
			pstm.setString(2, contato.getMensagem());
			pstm.setString(3, contato.getCliente().getCpf());
			// Cliente clien = new Cliente();
			// pstm.setString(3, clien.getCpf());
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
		String sql = "DELETE FROM contato WHERE fk_Cliente_CPF_Cliente = ?";
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

	public Contato consultarByCpf(String cpf) {
		String sql = "SELECT * FROM contato WHERE fk_Cliente_CPF_Cliente = ?";
		
		Contato contato = new Contato();
		Cliente cliente = new Cliente();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			
			rset = pstm.executeQuery();
			rset.next();
			
			cliente.setCpf(rset.getString("fk_Cliente_CPF_Cliente"));
			contato.setCliente(cliente);
			contato.setAssunto(rset.getString("Assunto"));
			contato.setMensagem(rset.getString("Mensagem"));
			
			pstm.execute();
			
		}catch(

	Exception e)
	{
		e.printStackTrace();
	}finally
	{
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
	}return contato;
}}
