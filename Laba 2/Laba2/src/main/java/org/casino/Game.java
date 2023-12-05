package org.casino;

import java.util.Objects;

/**
 * Class representing a game in a casino.
 * Includes game name, type, minimum and maximum betting limits.
 */
public class Game {
    private String name;
    private String type;
    private double minBet;
    private double maxBet;

    private Game(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.minBet = builder.minBet;
        this.maxBet = builder.maxBet;
    }

    // Getters and setters omitted for brevity

    public static class Builder {
        private String name;
        private String type;
        private double minBet;
        private double maxBet;

        public Builder(String name) {
            this.name = name;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder minBet(double minBet) {
            this.minBet = minBet;
            return this;
        }

        public Builder maxBet(double maxBet) {
            this.maxBet = maxBet;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", minBet=" + minBet +
                ", maxBet=" + maxBet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.minBet, minBet) == 0 &&
                Double.compare(game.maxBet, maxBet) == 0 &&
                Objects.equals(name, game.name) &&
                Objects.equals(type, game.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, minBet, maxBet);

    }





}
