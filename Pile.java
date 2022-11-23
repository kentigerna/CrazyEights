//Katsanou Aikaterini Panagiota
//AM:5249

import java.util.ArrayList;
import java.util.*;

class Pile 
{
    private ArrayList<Card> pile = new ArrayList<Card>();

    public void fill(){
        for (int i=0; i<10; i++) {
          Card card = new Card(i,"H");
          pile.add(card);          
        }

        for (int i=0; i<10; i++) {
            Card card = new Card(i,"D");
            pile.add(card);          
        }

        for (int i=0; i<10; i++) {
            Card card = new Card(i,"S");
            pile.add(card);          
        }

        for (int i=0; i<10; i++) {
            Card card = new Card(i,"C");
            pile.add(card);          
        }
        
        shuffle();  
    }

    public void fill(ArrayList<Card> pile2){
        for (int i=0; i<pile2.size(); i++){
            Card card = pile2.get(i);
            pile.add(card);
        }
        
        shuffle();
    }

    private void shuffle(){
        Collections.shuffle(pile);
    }

    public Card nextCard(){
        int x = pile.size();
        Card card = pile.get(x-1);
        pile.remove(x-1);
        return card;     
    }

    public boolean isEmpty(){
        if (pile.size() == 0){
            return true;
        }else{return false;}
    }

    public void print(){
        String print = "";
        for (int i=0; i<pile.size(); i++){
            print = print + pile.get(i) + " ";
        }
        System.out.println(print);
    }


    public static void main(String[] args)
    {
        Pile pile1 = new Pile();
        pile1.fill();

        Pile pile2 = new Pile();
        Card card1 = new Card(0, "H");
        Card card2 = new Card(1, "D");
        Card card3 = new Card(2, "S");
        Card card4 = new Card(3, "C");

        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(card1);
        arr.add(card2);
        arr.add(card3);
        arr.add(card4);

        pile2.fill(arr);
        
        pile1.print();
        pile2.print();
        
        System.out.println(pile1.nextCard());
        System.out.println(pile2.nextCard());
        pile1.print();
        pile2.print();
    }

}
 