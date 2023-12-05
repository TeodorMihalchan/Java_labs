package casino;

import java.util.Objects;

/**
 * Class representing a player in a casino.
 * Includes player's name, balance, and VIP status.
 */
public class Player {
    private String name;
    private double balance;
    private boolean isVip;

    private Player(Builder builder) {
        this.name = builder.name;
        this.balance = builder.balance;
        this.isVip = builder.isVip;
    }

    // Getters and setters

    public static class Builder {
        private String name;
        private double balance;
        private boolean isVip;

        public Builder(String name) {
            this.name = name;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder isVip(boolean isVip) {
            this.isVip = isVip;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", isVip=" + isVip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Double.compare(player.balance, balance) == 0 &&
                isVip == player.isVip &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, isVip);
    }
}
