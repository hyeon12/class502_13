package game;

public class Game {
    public static void main(String[] args) {
        int wins = 0; //연승 횟수

        int money = 200000, goal = 100000000;
        while(money <= goal){
            wins++;
            money *= 2;
        }

        /*
        for(int i = 0; i < wins; i++){
          percent = 0.5 * 0.5;
        }

         */


        //double continuity = Math.pow(0.5, wins);

        System.out.println("");
    }

}
