package br.com.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.triadworks.javaweb.modelo.Caloteiro;

public class CaloteiroDAO {
	private Connection conexao;

	public CaloteiroDAO() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Caloteiro caloteiro) {
		String sql = "insert into caloteiro (nome, email, devendo, dataDivida) values (?,?,?,?);";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, caloteiro.getNome());
			ps.setString(2, caloteiro.getEmail());
			ps.setInt(3, caloteiro.getDevendo());
			ps.setDate(4, new Date(caloteiro.getDataDivida().getTimeInMillis()));//caloteiro.getDataDivida().getTime()
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Caloteiro> getLista() {
		try {
			PreparedStatement ps = this.conexao.prepareStatement("select * from caloteiro");
			List<Caloteiro> caloteiros = new ArrayList<Caloteiro>();
			Caloteiro caloteiro = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				caloteiro = new Caloteiro();
				caloteiro.setId(rs.getLong("id"));
				caloteiro.setNome(rs.getString("nome"));
				caloteiro.setEmail(rs.getString("email"));
				caloteiro.setDevendo(rs.getInt("devendo"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataDivida"));
				caloteiro.setDataDivida(data);
				
				caloteiros.add(caloteiro);
			}
			return caloteiros;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void altera(Caloteiro c) {
		String sql = "update caloteiro set nome=?, email=?, devendo=?, dataDivida=? where id=?";
		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setInt(3, c.getDevendo());
			ps.setDate(4, new Date(c.getDataDivida().getTimeInMillis()));
			ps.setLong(5, c.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void deleta(Long caloteiroId) {
		String sql = "delete from caloteiro where id=?";
		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setLong(1, caloteiroId);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public Caloteiro getCaloteiro(Long id) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement("select * from caloteiro where id=?");
			ps.setLong(1, id);
			List<Caloteiro> caloteiros = new ArrayList<Caloteiro>();
			Caloteiro caloteiro = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				caloteiro = new Caloteiro();
				caloteiro.setId(rs.getLong("id"));
				caloteiro.setNome(rs.getString("nome"));
				caloteiro.setEmail(rs.getString("email"));
				caloteiro.setDevendo(rs.getInt("devendo"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataDivida"));
				caloteiro.setDataDivida(data);
				
				caloteiros.add(caloteiro);
			}
			return caloteiros.get(0);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
}
