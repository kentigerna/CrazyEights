//Katsanou Aikaterini Panagiota
//AM:5249

import java.util.ArrayList;

class Table {
    private Pile pile = new Pile();
    private ArrayList<Card> oldCards = new ArrayList<Card>();
    private Card topCard;

    public Table()
    {
        pile.fill();
        topCard = pile.nextCard();
        oldCards.add(topCard);
    }

    public void throwCard(Card card){
        topCard = card;
        oldCards.add(card);
    }

    public Card drawCard(){
        if (!pile.isEmpty()){
            return pile.nextCard();
        }else{
            pile.fill(oldCards);
            return pile.nextCard();
        }
    }

    public Card getTopCard(){
        return topCard;
    }

    public void printTable(){
        pile.print();
    }

    public static void main(String[] args){
        Table table = new Table();
        Card card2 = null;
        table.printTable();

        for (int i=0; i<33; i++){
            table.drawCard();
            card2 = table.drawCard();
            table.throwCard(card2);
            System.out.print(table.getTopCard()+" ");
        }
       
    }



}
