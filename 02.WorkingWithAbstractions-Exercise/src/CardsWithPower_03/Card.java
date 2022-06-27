package CardsWithPower_03;

public class Card {

    private CardSuits cardSuit;
    private CardsRank cardsRank;
    private int power;

    public Card(CardSuits cardSuit, CardsRank cardsRank) {
        this.cardSuit = cardSuit;
        this.cardsRank = cardsRank;
    }


    public CardSuits getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuits cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardsRank getCardsRank() {
        return cardsRank;
    }

    public void setCardsRank(CardsRank cardsRank) {
        this.cardsRank = cardsRank;
    }

    public int getPower() {
        return this.cardSuit.getPower() + this.cardsRank.getPowerRank() ;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
