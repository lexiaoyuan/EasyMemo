package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.*;
import dbc.JdbcUtil;
public class Memo_DAO {
	public Memo_User addMemoInfo(Memo_User memo) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtil.getConnection();
			String addmemoinfoSql="insert into memo_user(user_account,memo_content,"+
			"memo_account,memo_password,memo_note,memo_date) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(addmemoinfoSql);
			ps.setString(1, memo.getUser_account());
			ps.setString(2, memo.getMemo_content());
			ps.setString(3, memo.getMemo_account());
			ps.setString(4, memo.getMemo_password());
			ps.setString(5, memo.getMemo_note());
			ps.setString(6, memo.getMemo_date());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return memo;
	}
	
	public List<Memo_User> lookMemoInfo(Memo_User memo) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Memo_User> memoList=new ArrayList<Memo_User>();
		try {
			conn=JdbcUtil.getConnection();
			String lookmemoinfoSql="select * from memo_user where user_account=?";
			ps=conn.prepareStatement(lookmemoinfoSql);
			ps.setString(1, memo.getUser_account());
			rs=ps.executeQuery();
			while(rs.next()) {
				Memo_User tmpUserMemoInfo=new Memo_User();
				tmpUserMemoInfo.setMemo_id(rs.getInt(1));
				tmpUserMemoInfo.setUser_account(rs.getString(2));
				tmpUserMemoInfo.setMemo_content(rs.getString(3));
				tmpUserMemoInfo.setMemo_account(rs.getString(4));
				tmpUserMemoInfo.setMemo_password(rs.getString(5));
				tmpUserMemoInfo.setMemo_note(rs.getString(6));
				tmpUserMemoInfo.setMemo_date(rs.getString(7));
				memoList.add(tmpUserMemoInfo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return memoList;
	}
}
