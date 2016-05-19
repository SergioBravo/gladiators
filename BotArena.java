
/**
 * Write a description of class BotArena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class BotArena {
    private String[] bodyParts = {"Голова", "Туловище", "Руки", "Ноги"};
    
    private Gladiator winner = null;
    private Gladiator loser = null;
    
    public void compArena(Gladiator p, Gladiator e) {
        while (true) {
            if (p.getHealth() <= 0) {
                System.out.println("Победитель: " + e.getName());
                System.out.println("Проигравший: " + p.getName());
                winner = e;
                loser = p;
                break;
            } else {
                if (e.getHealth() <= 0) {
                    System.out.println("Победитель: " + p.getName());
                    System.out.println("Проигравший: " + e.getName());
                    winner = p;
                    loser = e;
                    break;
                }
            }
            
            int compChoice = (int) (Math.random() * (bodyParts.length - 1));
            p.setTarget(compChoice);
            compChoice = (int) (Math.random() * (bodyParts.length - 1));
            p.setBlock(compChoice);
        
            compChoice = (int) (Math.random() * (bodyParts.length - 1));
            e.setTarget(compChoice);
            compChoice = (int) (Math.random() * (bodyParts.length - 1));
            e.setBlock(compChoice);
            
            compFight(p, e);
        }
    }
    
    private void compFight(Gladiator p, Gladiator e) {
        int chanceP = (int) (Math.random() * 100);
        int chanceE = (int) (Math.random() * 100);
        if (p.getTarget() != e.getBlock()) {
            e.changeHealth(p.getStrength());
            if ((chanceP <= 10) && (p.getSpecial() > 0)) {
                e.changeHealth(p.getStrength());
                p.changeSpecial();
            }
        
        }
        
        if (e.getTarget() != p.getBlock()) {
            p.changeHealth(e.getStrength());
            if ((chanceE <= 10) && (e.getSpecial() > 0)) {
                p.changeHealth(p.getStrength());
                e.changeSpecial();
            }
        }
    }
    
    public Gladiator getWinner() {
        return winner;
    }
    
    public Gladiator getLoser() {
        return loser;
    }
}
