package dao;
import java.sql.*;
import beans.*;
import dbc.JdbcUtil;
public class Register_DAO {
	public User_Info addRegisterInfo(User_Info user) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtil.getConnection();
			String registerSql="insert into user_info values(?)";
			ps=conn.prepareStatement(registerSql);
			ps.setString(1, user.getUserAccount());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return user;
	}
}
