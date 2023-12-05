package casino;

public class main {
    public static void main(String[] args) {
        // Створення гри
        Game pokerGame = new Game.Builder("Poker")
                .type("Card Game")
                .minBet(10.0)
                .maxBet(1000.0)
                .build();

        // Створення гравця
        Player player = new Player.Builder("John Doe")
                .balance(1000.0)
                .isVip(true)
                .build();

        // Створення ставки
        Bet bet = new Bet.Builder(pokerGame, player)
                .amount(50.0)
                .isWin(true)
                .build();


        System.out.println("Game Information:");
        System.out.println(pokerGame.toString());

        System.out.println("\nPlayer Information:");
        System.out.println(player.toString());

        System.out.println("\nBet Information:");
        System.out.println(bet.toString());
    }
}
