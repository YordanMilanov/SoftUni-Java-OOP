package CardRank_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Ranks:");
        CardsRank[] cardsRanks = CardsRank.values();
        for (CardsRank cardsRank : cardsRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardsRank.ordinal(), cardsRank.name());
        }
    }
}
