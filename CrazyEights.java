//Katsanou Aikaterini Panagiota
//AM:5249

import java.util.ArrayList;

class CrazyEights {
    private Table table = new Table();
    private ArrayList<Player> playersList = new ArrayList<Player>();
    private int number;

    public CrazyEights(int number){
        this.number = number;
        playersList.add(new Player("Human"));
        playersList.get(0).draw(table,5);

        for(int i=0; i<number-1; i++){
            playersList.add(new Player("Computer"+i));
            playersList.get(i+1).draw(table,5);
        }
    }

    public void play(){
        while(true){
            for(int i=0; i<number; i++){
                System.out.println(playersList.get(i).toString() + " turn.");
                System.out.println("Table top card: " + table.getTopCard());
                if (i==0){
                    Card card = playersList.get(i).selectCard(table);
                    if (card!=null){
                        playersList.get(i).throwCard(table,card);
                    }else if (card == null){
                        playersList.get(i).draw(table);
                    }


                }else{
                    Card card = playersList.get(i).computerSelectCard(table);
                    if (card!=null){
                        playersList.get(i).throwCard(table,card);
                    }else{
                        playersList.get(i).draw(table);
                    }

                }

                if (playersList.get(i).isDone()){
                    System.out.println("Player "+playersList.get(i).toString()+" won!");
                    return;
                }


            }
        }
    }    
}
