package tc.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tc.main.parsing.CommandsParser;
import tc.main.points.PointCounter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    PointCounter game;
    @Test
    void gameTest01R1() {
        String input="coin,coin,coin,coin";
        game = simulation(input);
        assertEquals(game.getLives(),3);
        assertEquals(game.getPoints(),2040);
    }

    @Test
    void gameTest02R2() {
        String input="InvincibleBlargg,InvincibleBeach_Koopa,InvincibleBig_Boo,InvincibleBlargg";
        simulation(input);
        game = simulation(input);
        assertEquals(game.getLives(),-1);
        assertEquals(game.getPoints(),2000);
    }

    @Test
    void gameTest03R2() {
        String input="InvincibleBlargg,InvincibleBeach_Koopa,InvincibleBig_Boo";
        game = simulation(input);
        assertEquals(game.getLives(),0);
        assertEquals(game.getPoints(),2000);
    }

    @Test
    void gameTest04R3() {
        //this should not increment lives nr (default=3)
        String input="ConsecutivelyJumpOnBanzai_Bill,Coin,ConsecutivelyJumpOnBig_Boo";
        game = simulation(input);
        assertEquals(game.getLives(),4);
        assertEquals(game.getPoints(),2010);
    }

    @Test
    void gameTest05R3() {
        //this should increment lives nr (default=3)
        String input="ConsecutivelyJumpOnBanzai_Bill,ConsecutivelyJumpOnBig_Boo,Coin";
        game = simulation(input);
        assertEquals(game.getLives(),5);
        assertEquals(game.getPoints(),2010);
    }

    @Test
    void gameTest06R4() {
        //this should increment lives nr (default=3)
        String input="FireballOnBanzai_Bill,FireballOnBig_Boo,FireballOnBlargg";
        game = simulation(input);
        assertEquals(game.getLives(),3);
        assertEquals(game.getPoints(),2150);
    }

    @Test
    void gameTest07ScoringSystem(){
        // 1600+800+400+200+10 = 3010 + 2000 default points
        // 3 life added for consecutively jumps
        String input="ConsecutivelyJumpOnBanzai_Bill,ConsecutivelyJumpOnBig_Boo,ConsecutivelyJumpOnBlargg,ConsecutivelyJumpOnBeach_Koopa,Coin";
        game = simulation(input);
        assertEquals(game.getLives(),9);
        assertEquals(game.getPoints(),2010);
    }

    @Test
    void gameTest08R5(){
        String input="ConsecutivelyJumpOnBig_Boo,Coin,ConsecutivelyJumpOnBeach_Koopa";
        game = simulation(input);
        assertEquals(game.getLives(),4);
        assertEquals(game.getPoints(),2210);
    }

    @Test
    void gameTest09R5(){
        String input="ConsecutivelyJumpOnBanzai_Bill,Coin,ConsecutivelyJumpOnBanzai_Bill";
        game = simulation(input);
        assertEquals(game.getLives(),3);
        assertEquals(game.getPoints(),2410);
    }

    @Test
    void gameTest09ExampleA(){
        String input="ConsecutivelyJumpOnBanzai_Bill,FireballOnBanzaiBill, Coin,Coin,Coin,ConsecutivelyJumpOnBlargg,InvincibleBig_Boo";
        game = simulation(input);
        assertEquals(game.getLives(),3);
        assertEquals(game.getPoints(),2880);
    }

    @Test
    void gameTest10BigExample(){
        String input="ConsecutivelyJumpOnBanzai_Bill,FireballOnBanzai_Bill,Coin,Coin,Coin,Coin,Coin,InvincibleBig_Boo,FireballOnBanzai_Bill,InvincibleBlargg," +
                "Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin," +
                "FireballOnBanzai_Bill,ConsecutivelyJumpOnBeach_Koopa," +
                "ConsecutivelyJumpOnBig_Boo" +
                ",InvincibleBeach_Koopa," +
                "Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin";
        game = simulation(input);
        assertEquals(game.getLives(),2);
        assertEquals(game.getPoints(),2880);

        /*
        points:2000
        gainedPoints:0 (when over 1000 will be reset to 0  and point decreased by 1000 and one life added)
        lives: 3

        ConsecutivelyJumpOnBanzai_Bill (200)
        FireballOnBanzai_Bill (50)
        Coin,Coin,Coin,Coin,Coin (50)
        InvincibleBig_Boo (-1 life)
        FireballOnBanzai_Bill (50)
        InvincibleBlargg (-1 life, so 1 life left)
        Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin (150, 500 gained so far)
        FireballOnBanzai_Bill (50)
        ConsecutivelyJumpOnBeach_Koopa (400, 950 gained so far)
        ConsecutivelyJumpOnBig_Boo (800, + 1 life without touching the ground R3)

        points:3750
        gainedPoints:1750
        lives: 2

        points:2750
        gainedPoints:750
        lives: 3

        InvincibleBeach_Koopa (-1, still 2 lives)
        Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin (130)

        points:2880
        lives: 2

         */
    }

    private PointCounter simulation(String input){

        CommandsParser cp = new CommandsParser(input);
        ArrayList<String> actions = cp.getTokens();
        PointCounter pc = new PointCounter(actions);
        boolean win = pc.gameSimulation();
        if(win){
            System.out.println("Winning game, life count never went down to zero.");
        }
        else{
            System.out.println("Fail, life count went down to zero at least one time.");
        }

        System.out.println("Points: "+pc.getPoints());
        System.out.println("Lives: "+pc.getLives());
        System.out.println("Action received: "+actions.toString());
        return pc;
    }
}