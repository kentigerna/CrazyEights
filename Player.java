//Katsanou Aikaterini Panagiota
//AM:5249

import java.util.Scanner;


class Player {
    private String name;
    private Hand hand = new Hand();

    public Player(String name){
        this.name = name;
    }

    public void draw(Table table){
        Card card = table.drawCard();
        System.out.println(name+" drew a card");
        hand.addCard(card);
    }

    public void draw(Table table, int number){
        for (int i=0; i<number; i++){
            Card card = table.drawCard();
            hand.addCard(card);
        }
    }

    public void throwCard(Table table, Card card){
        table.throwCard(card);
        hand.removeCard(card);
        System.out.println(name+" threw card "+card.toString());
    }

    public boolean isDone(){
        return hand.isEmpty();
    }

    public String toString(){
        return name;
    }

    public Card selectCard(Table table){
        hand.printHand();
        Scanner input = new Scanner(System.in);
        System.out.println("Select a card to throw or -1 to pass");
        int x = input.nextInt();
        if (x!=-1){
            Card card = hand.getCard(x);
            if (card.matches(table.getTopCard()) && !card.isEight()){
                return card;
            }else if(card.isEight()){
                System.out.println("Select a suit");
                String suit = input.next();
                card.setSuit(suit);
                return card;
            }
        }else if(x==-1){
            return null;
        }
        selectCard(table);
        return null;
    }

    public Card computerSelectCard(Table table){
        return hand.findMatchingCard(table.getTopCard());
    }


    public static void main(String[] args){
        Player player = new Player("Katherine");
        Table table = new Table();

        System.out.println(player.toString());
        player.draw(table);
        player.draw(table,5);
        player.selectCard(table);
        System.out.println(player.computerSelectCard(table));
        System.out.println(player.isDone());
    }


    
}
