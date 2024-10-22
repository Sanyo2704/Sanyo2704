package tema1.ejercicio05.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tema1.ejercicio05.modelo.User;

public class UserDao {
	public Long insert(Connection conn, User user) throws SQLException {
		String sql = "insert into users values (?,?,?,?)";
		try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setLong(1, user.getId());
            stmt.setString(2,user.getUsername());
            stmt.setString(3, user.getPswd());
            stmt.setString(4, user.getEmail());
            stmt.setDate(4, Date.valueOf(user.getDischargeDate()));
            stmt.setDate(6, Date.valueOf(user.getLastLoginDate()));
            stmt.execute();
            //Devuelve el valor del id del usuario creado
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
		}
	}
	
	public User getByEmail(Connection conn, String email) throws SQLException {
		String sql = "select * from users where email = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery(sql);
			User user = getBy(rs);
			return user;
		}
	}
	
	public User getById(Connection conn, Long id) throws SQLException {
		String sql = "select * from users where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery(sql);
			User user = getBy(rs);
			return user;
		}
	}
	
	public User getByUser(Connection conn, String username) throws SQLException {
		String sql = "select * from users where username = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery(sql);
			User user = getBy(rs);
			return user;
		}
	}
	
	public User getBy(ResultSet rs) throws SQLException {
		
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPswd(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setDischargeDate(rs.getDate("discharge_Date").toLocalDate());
			user.setLastLoginDate(rs.getDate("last_Login_Date").toLocalDate());
			return user;
		}
		else {
			return null;
		}
	}
	
	public void update(Connection conn, User user) throws SQLException {
		String sql = "update users set username = ?, password = ?, email = ?, discharge_Date = ?, last_Login_Date = ? where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,user.getUsername());
            stmt.setString(2, user.getPswd());
            stmt.setString(3, user.getEmail());
            stmt.setDate(4, Date.valueOf(user.getDischargeDate()));
            stmt.setDate(5, Date.valueOf(user.getLastLoginDate()));
            stmt.setLong(6, user.getId());
            stmt.execute();
		}
	}
}
