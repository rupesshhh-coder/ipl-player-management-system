package com.tka.service;

import java.util.List;
import com.tka.dao.PlayerDao;
import com.tka.model.Player;

public class PlayerService {

	PlayerDao dao = new PlayerDao();

	public List<Player> getAllPlayers() {
		return dao.getAllPlayers();
	}

	public List<Player> getPlayersByCategoryBatsman(String category) {
		return dao.getPlayersByCategoryBatsman(category);
	}

	public List<Player> getPlayersByCategoryBowler(String category) {
		return dao.getPlayersByCategoryBowler(category);
	}

	public Player getPlayerById(int id) {
		return dao.getPlayerById(id);
	}

	public List<Player> getPlayersByTeam(String team) {
		return dao.getPlayerByTeam(team);
	}

	public Player getHighestScorePlayer() {
		return dao.getHighestScorePlayer();
	}

	public Player getHighestWicketPlayer() {
		return dao.getHighestWicketPlayer();
	}

	public void updateScoreById(int id, int score) {
		dao.updateScoreById(id, score);
	}

	public void updateWicketsById(int id, int wickets) {
		dao.updateWicketsById(id, wickets);
	}

	public void deletePlayerById(int id) {
		dao.deletePlayerById(id);
	}
}