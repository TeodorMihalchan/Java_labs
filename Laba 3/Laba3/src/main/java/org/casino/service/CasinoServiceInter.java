package org.casino.service;

import org.casino.Bet;
import org.casino.Game;
import org.casino.Player;

import java.util.List;

public interface CasinoServiceInter {
    // Сортування гравців за балансом
    List<Player> sortPlayersByBalance(List<Player> players);

    List<Player> sortPlayersByBalanceUsingComparator(List<Player> players);

    // Фільтрація гравців за VIP статусом
    List<Player> filterVipPlayers(List<Player> players);

    // Пошук ігор з максимальними ставками
    List<Game> findGamesWithHighestBets(List<Game> games);

    // Сортування ставок за розміром ставки
    List<Bet> sortBetsByAmount(List<Bet> bets);

    // Сортування гравців за балансом
    List<Player> sortPlayersByBalanceStream(List<Player> players);

    List<Player> sortPlayersByBalanceUsingComparatorStream(List<Player> players);

    // Фільтрація гравців за VIP статусом
    List<Player> filterVipPlayersStream(List<Player> players);

    List<Player> filterVipPlayersUsingStream(List<Player> players);

    // Пошук ігор з максимальними ставками
    List<Game> findGamesWithHighestBetsStream(List<Game> games);

    // Сортування ставок за розміром ставки
    List<Bet> sortBetsByAmountStream(List<Bet> bets);
}
