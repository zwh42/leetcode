//292. Nim Game
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    public static void main(String... args){
        //unit test
        NimGame nimGame = new NimGame();
        System.out.println("n = 4, " + nimGame.canWinNim(4));
        System.out.println("n = 5, " + nimGame.canWinNim(5));
    }
}