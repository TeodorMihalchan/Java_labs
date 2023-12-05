package org.casino;

import org.casino.service.CasinoService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasinoServiceTest {

    private CasinoService casinoService;
    private List<Player> players;
    private List<Game> games;
    private List<Bet> bets;

    @BeforeClass
    public void setUp() {


        players = new ArrayList<>(Arrays.asList(
                new Player.Builder("Alice").balance(1000.0).vip(true).build(),
                new Player.Builder("Bob").balance(500.0).vip(false).build(),
                new Player.Builder("Charlie").balance(750.0).vip(true).build(),
                new Player.Builder("David").balance(1200.0).vip(false).build()
        ));

        games = new ArrayList<>(Arrays.asList(
                new Game.Builder("Blackjack").minBet(100.0).maxBet(1000.0).build(),
                new Game.Builder("Roulette").minBet(200.0).maxBet(2000.0).build(),
                new Game.Builder("Slot Machine").minBet(50.0).maxBet(500.0).build()
        ));

        bets = new ArrayList<>(Arrays.asList(
                new Bet.Builder(games.get(0), players.get(0)).amount(150.0).isWin(true).build(),
                new Bet.Builder(games.get(1), players.get(1)).amount(250.0).isWin(false).build(),
                new Bet.Builder(games.get(2), players.get(2)).amount(100.0).isWin(true).build(),
                new Bet.Builder(games.get(0), players.get(3)).amount(300.0).isWin(false).build()
        ));

        casinoService = new CasinoService();
    }

    @Test
    public void testSortPlayersByBalance() {
        List<Player> sortedPlayers = casinoService.sortPlayersByBalance(players);
        List<String> playerNames = new ArrayList<>();
        for (Player player : sortedPlayers) {
            playerNames.add(player.getName());
        }
        List<String> expectedNames = Arrays.asList("Bob", "Charlie", "Alice", "David");
        Assert.assertEquals(playerNames, expectedNames);
    }

    @Test
    public void testFilterVipPlayers() {
        List<Player> vipPlayers = casinoService.filterVipPlayers(players);
        for (Player player : vipPlayers) {
            Assert.assertTrue(player.getVip());
        }
    }

    @Test
    public void testFindGamesWithHighestBets() {
        List<Game> highBetGames = casinoService.findGamesWithHighestBets(games);
        List<String> gameNames = new ArrayList<>();
        for (Game game : highBetGames) {
            gameNames.add(game.getName());
        }
        List<String> expectedNames = Arrays.asList("Roulette", "Blackjack", "Slot Machine");
        Assert.assertEquals(gameNames, expectedNames);
    }

    @Test
    public void testSortBetsByAmount() {
        List<Bet> sortedBets = casinoService.sortBetsByAmount(bets);
        List<Double> betAmounts = new ArrayList<>();
        for (Bet bet : sortedBets) {
            betAmounts.add(bet.getAmount());
        }
        List<Double> expectedAmounts = Arrays.asList(100.0, 150.0, 250.0, 300.0);
        Assert.assertEquals(betAmounts, expectedAmounts);
    }
}