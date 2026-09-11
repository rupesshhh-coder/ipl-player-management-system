package com.tka;

import java.util.List;
import com.tka.controller.PlayerController;
import com.tka.model.Player;

public class IPL_APP {

	public static void main(String[] args) throws Exception {

		PlayerController pc = new PlayerController();

		System.out.println("1. All Plyers Details: ");
		List<Player> allPlayerList = pc.getAllPlayers();
		allPlayerList.forEach(System.out::println);

		System.out.println("\n2. Batsman Players:");
		pc.getPlayersByCategoryBatsman("Batsman").forEach(System.out::println);

		System.out.println("\n3. Bowler Players:");
		pc.getPlayersByCategoryBowler("Bowler").forEach(System.out::println);

		System.out.println("\n4. Players Details Given By ID: ");
		Player playerById = pc.getPlayerById(1);
		System.out.println(playerById);

		System.out.println("\n5️. Players by Team:");
		pc.getPlayersByTeam("MI").forEach(System.out::println);

		System.out.println("\n6️. Highest Score Player:");
		System.out.println(pc.getHighestScorePlayer());

		System.out.println("\n7️. Highest Wickets Player:");
		System.out.println(pc.getHighestWicketPlayer());

		System.out.println("\n8️. Update Score (ID=1):");
		pc.updateScoreById(1, 5000);

		System.out.println("\n9️. Update Wickets (ID=2):");
		pc.updateWicketsById(2, 99);

		System.out.println("\n10. Delete Player (ID=3):");
		pc.deletePlayerById(3);
	}
}
