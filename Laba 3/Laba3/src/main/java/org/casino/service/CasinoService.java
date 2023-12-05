package org.casino.service;

import org.casino.Bet;
import org.casino.Game;
import org.casino.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CasinoService implements CasinoServiceInter {
    @Override
    // Сортування гравців за балансом
    public List<Player> sortPlayersByBalance(List<Player> players) {
        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers);
        return sortedPlayers;
    }
    @Override
    public List<Player> sortPlayersByBalanceUsingComparator(List<Player> players) {
        Comparator<Player> playerComparator = Comparator.comparingDouble(Player::getBalance);
        Collections.sort(players, playerComparator);
        return players;
    }
    @Override
    // Фільтрація гравців за VIP статусом
    public List<Player> filterVipPlayers(List<Player> players) {
        List<Player> vipPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getVip()) {
                vipPlayers.add(player);
            }
        }
        return vipPlayers;
    }


    @Override
    // Пошук ігор з максимальними ставками
    public List<Game> findGamesWithHighestBets(List<Game> games) {
        games.sort(Comparator.comparingDouble(Game::getMaxBet).reversed());
        return games;
    }
    @Override
    // Сортування ставок за розміром ставки
    public List<Bet> sortBetsByAmount(List<Bet> bets) {
        bets.sort(Comparator.comparingDouble(Bet::getAmount));
        return bets;
    }
    @Override
    // Сортування гравців за балансом
    public List<Player> sortPlayersByBalanceStream(List<Player> players) {
        return players.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    @Override
    public List<Player> sortPlayersByBalanceUsingComparatorStream(List<Player> players) {
        Comparator<Player> playerComparator = Comparator.comparingDouble(Player::getBalance);
        return players.stream()
                .sorted(playerComparator)
                .collect(Collectors.toList());
    }
    @Override
    // Фільтрація гравців за VIP статусом
    public List<Player> filterVipPlayersStream(List<Player> players) {
        return players.stream()
                .filter(Player::getVip)
                .collect(Collectors.toList());
    }
    @Override
    public List<Player> filterVipPlayersUsingStream(List<Player> players) {
        return players.stream()
                .filter(Player::getVip)
                .collect(Collectors.toList());
    }
    @Override
    // Пошук ігор з максимальними ставками
    public List<Game> findGamesWithHighestBetsStream(List<Game> games) {
        return games.stream()
                .sorted(Comparator.comparingDouble(Game::getMaxBet).reversed())
                .collect(Collectors.toList());
    }
    @Override
    // Сортування ставок за розміром ставки
    public List<Bet> sortBetsByAmountStream(List<Bet> bets) {
        return bets.stream()
                .sorted(Comparator.comparingDouble(Bet::getAmount))
                .collect(Collectors.toList());
    }
}
