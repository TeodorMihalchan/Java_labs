package org.casino;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class representing a player in a casino.
 * Includes player's name, balance, and VIP status.
 */
public class Player implements Serializable {
    private String name;
    private double balance;
    private boolean vip;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean  getVip() {
        return  vip;
    }

    private Player(Builder builder) {
        this.name = builder.name;
        this.balance = builder.balance;
        this.vip = builder.vip;
    }
    private Player() {

    }

    // Getters and setters

    public static class Builder {
        private String name;
        private double balance;
        private boolean vip;



        public Builder(String name) {
            this.name = name;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder vip(boolean vip) {
            this.vip = vip;
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
                ", vip=" + vip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Double.compare(player.balance, balance) == 0 &&
                vip == player.vip &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, vip);
    }
}
