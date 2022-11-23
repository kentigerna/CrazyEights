//Katsanou Aikaterini Panagiota
//AM:5249

import java.util.Scanner;


class Game {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Give the number of players: ");
        int n = input.nextInt();

        CrazyEights crazyEights = new CrazyEights(n);

        crazyEights.play();
    }
    
}
