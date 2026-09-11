package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tka.model.Player;
import com.tka.utility.MyDbCong;

public class PlayerDao {

	Connection con;
	Statement st;
	ResultSet rs;
	String query;
	Player player;
	List<Player> playersList;

	// 1. Get All Players.
	public List<Player> getAllPlayers() {
		List<Player> playersList = new ArrayList<>();
		try {
			con = MyDbCong.getMyConnect();
			st = con.createStatement();
			query = "select * from player";
			rs = st.executeQuery(query);

			while (rs.next()) {
				player = new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7));
				playersList.add(player);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersList;
	}

	// 2. Players By Category(Batsman).
	public List<Player> getPlayersByCategoryBatsman(String category) {
		List<Player> list = new ArrayList<>();
		try {
			con = MyDbCong.getMyConnect();
			st = con.createStatement();
			query = "SELECT * FROM player WHERE category = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, category);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 3. Players By Category(Bowler).
	public List<Player> getPlayersByCategoryBowler(String category) {
		List<Player> list = new ArrayList<>();
		try {
			con = MyDbCong.getMyConnect();
			st = con.createStatement();
			query = "SELECT * FROM player WHERE category = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, category);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 4. Player By ID.
	public Player getPlayerById(int id) {
		Player p = null;
		try {
			con = MyDbCong.getMyConnect();
			st = con.createStatement();
			query = "select * from player where id= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				p = new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	// 5. Players By Team Name.
	public List<Player> getPlayerByTeam(String team) {
		List<Player> list = new ArrayList<>();
		try {
			con = MyDbCong.getMyConnect();
			query = "select * from player where teamName= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, team);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 6. Highest Score.
	public Player getHighestScorePlayer() {
		Player p = null;
		try {
			con = MyDbCong.getMyConnect();
			query = "select * from player order by score desc limit 1";
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				p = new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	// 7. Highest Wickets.
	public Player getHighestWicketPlayer() {
		Player p = null;
		try {
			con = MyDbCong.getMyConnect();
			query = "select * from player order by wickets desc limit 1";
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				p = new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	// 8. Update Score By ID.
	public void updateScoreById(int id, int newScore) {
		try {
			con = MyDbCong.getMyConnect();
			query = "update player set score = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, newScore);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Score Updated Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 9. Update Wickets By ID.
	public void updateWicketsById(int id, int newWickets) {
		try {
			con = MyDbCong.getMyConnect();
			query = "update player set wickets = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, newWickets);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Wickets Updated Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10. Delete Player By ID.
	public void deletePlayerById(int id) {
		try {
			con = MyDbCong.getMyConnect();
			query = "delete from player where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Player Deleted Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
