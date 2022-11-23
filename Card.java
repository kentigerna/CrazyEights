//Katsanou Aikaterini Panagiota
//AM:5249


class Card 
{
    private int number;
    private String suit;

    public Card(int number, String suit)
    {
        this.number = number;
        this.suit = suit;
    }

    public String getSuit(){
        return suit;
    }

    public void setSuit(String s){
        suit = s;
    }

    public boolean isEight(){
        if (number == 8){
            return true;
        }else{return false;}
    }

    public boolean matches(Card card2){
        if ((number == card2.number) || (suit.equals(card2.suit))){
            return true;

        }else{return false;}
    }

    public String toString(){
        return number + suit;
    }


}
