//Katsanou Aikaterini Panagiota
//AM:5249

import java.util.ArrayList;
import java.util.HashMap;



class Hand {
    private ArrayList<Card> cardHand = new ArrayList<Card>();
    private HashMap<String,Integer> map = new HashMap<String,Integer>();

    public Hand(){
        map.put("H",0);
        map.put("D",0);
        map.put("S",0);
        map.put("C",0);        
    }

    public void addCard(Card card){
        cardHand.add(card);
        if (!card.isEight()){
            String suit = card.getSuit();
            int x = map.get(suit);
            map.put(suit,x+1);
        }
    }

    public void removeCard(Card card){
        cardHand.remove(card);
        if (!card.isEight()){
            String suit = card.getSuit();
            int x = map.get(suit);
            map.put(suit,x-1);
        }
    }

    public Card getCard(int k){
        return cardHand.get(k);
    }

    public void printHand(){
        String print = "";
        for (int i = 0; i<cardHand.size(); i++){
            print = print + "       " + i +": "+ cardHand.get(i);
        }
        System.out.println(print);
    }

    public boolean isEmpty(){
        return cardHand.size() == 0;
    }

    public Card findMatchingCard(Card topCard){
        Card card = null;
        for(int i=0; i<cardHand.size(); i++){
            card = cardHand.get(i);
            if (card.matches(topCard) && !card.isEight()){
                return card;
            }else if(card.isEight()){
                String suit = "";
                int number = 0;
                for (String key: map.keySet()){
                    if (map.get(key) >= number){
                        suit = key;
                        number = map.get(key);
                    }
                }
                card.setSuit(suit);
                return card;
            }
        }
        return null;

    }

    public static void main(String[] args){
        Hand hand = new Hand();
        Card card1 = new Card(3,"S");
        Card card2 = new Card(8,"D");
        Card card3 = new Card(4,"D");
        Card card4 = new Card(6,"S");
        Card topCard = new Card(3,"H");

        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);

        System.out.println(hand.findMatchingCard(topCard));

        hand.removeCard(card1);
        System.out.println(hand.findMatchingCard(topCard));
    }
    
}
