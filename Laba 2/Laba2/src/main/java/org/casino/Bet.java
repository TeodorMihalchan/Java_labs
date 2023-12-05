package org.casino;

import java.util.Objects;

/**
 * Class representing a bet made in a casino game.
 * Includes the game being bet on, the player making the bet, the amount bet, and whether the bet was a win.
 */
public class Bet {
    private Game game;
    private Player player;
    private double amount;
    private boolean isWin;

    private Bet(Builder builder) {
        this.game = builder.game;
        this.player = builder.player;
        this.amount = builder.amount;
        this.isWin = builder.isWin;
    }

    // Getters and setters

    public static class Builder {
        private Game game;
        private Player player;
        private double amount;
        private boolean isWin;

        public Builder(Game game, Player player) {
            this.game = game;
            this.player = player;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder isWin(boolean isWin) {
            this.isWin = isWin;
            return this;
        }

        public Bet build() {
            return new Bet(this);
        }
    }

    @Override
    public String toString() {
        return "Bet{" +
                "game=" + game +
                ", player=" + player +
                ", amount=" + amount +
                ", isWin=" + isWin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bet)) return false;
        Bet bet = (Bet) o;
        return Double.compare(bet.amount, amount) == 0 &&
                isWin == bet.isWin &&
                Objects.equals(game, bet.game) &&
                Objects.equals(player, bet.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, player, amount, isWin);
    }
}
