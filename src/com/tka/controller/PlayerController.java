package com.tka.controller;

import java.util.List;

import com.tka.model.Player;
import com.tka.service.PlayerService;

public class PlayerController {

	PlayerService service = new PlayerService();

	public List<Player> getAllPlayers() {
		return service.getAllPlayers();
	}

	public List<Player> getPlayersByCategoryBatsman(String category) {
		return service.getPlayersByCategoryBatsman(category);
	}

	public List<Player> getPlayersByCategoryBowler(String category) {
		return service.getPlayersByCategoryBowler(category);
	}

	public Player getPlayerById(int id) {
		return service.getPlayerById(id);
	}

	public List<Player> getPlayersByTeam(String team) {
		return service.getPlayersByTeam(team);
	}

	public Player getHighestScorePlayer() {
		return service.getHighestScorePlayer();
	}

	public Player getHighestWicketPlayer() {
		return service.getHighestWicketPlayer();
	}

	public void updateScoreById(int id, int score) {
		service.updateScoreById(id, score);
	}

	public void updateWicketsById(int id, int wickets) {
		service.updateWicketsById(id, wickets);
	}

	public void deletePlayerById(int id) {
		service.deletePlayerById(id);
	}
}
