
/**
 * Write a description of class Arena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class Arena {
    private String[] bodyParts = {"Голова", "Туловище", "Руки", "Ноги"};
    
    private Gladiator winner = null;
    private Gladiator loser = null;
    
    public void arena(Gladiator player, Gladiator enemy) {
         while (true) {
            System.out.println("\nВаш ход.");
            System.out.println("Ваше здоровье: " + player.getHealth());
            System.out.println("Здоровье противника: " + enemy.getHealth());
            
            if (player.getHealth() <= 0) {
                System.out.println("Победитель: " + enemy.getName());
                System.out.println("Проигравший: " + player.getName());
                winner = enemy;
                loser = player;                
                break;
            } else {
                if (enemy.getHealth() <= 0) {
                    System.out.println("Победитель: " + player.getName());
                    System.out.println("Проигравший: " + enemy.getName());
                    winner = player;
                    loser = enemy;
                    break;
                }
            }
            
            System.out.println("Выберите область атаки:");        
            int i = 1;
            for (String b : bodyParts) {
                System.out.println(i + "." + b);
                i++;
            }
            
            int userChoice = (int) getUserInput("Введите цель атаки:");
            if (userChoice > 4 || userChoice < 1) {
               System.out.println("Wrong command!");
               continue;
            }
            player.setTarget(userChoice);
            System.out.println("Вы атакуете в:" + bodyParts[userChoice - 1]);
               
            userChoice = (int) getUserInput("Введите цель блока:");
            if (userChoice > 4 || userChoice < 1) {
               System.out.println("Wrong command!");
               continue;
            }
            player.setBlock(userChoice);
            System.out.println("Вы защищаете:" + bodyParts[userChoice - 1]);
        
            int compChoice = (int) (Math.random() * (bodyParts.length - 1));
            enemy.setTarget(compChoice);
            compChoice = (int) (Math.random() * (bodyParts.length - 1));
            enemy.setBlock(compChoice);
        
            fight(player, enemy);            
        }
    }
    
    private void fight(Gladiator p, Gladiator e) {
        int chanceP = (int) (Math.random() * 100);
        int chanceE = (int) (Math.random() * 100);
        if (p.getTarget() == e.getBlock()) {
            System.out.println("Противник блокирует удар!");
            if ((chanceP <= 10) && (p.getSpecial() > 0)) {
                System.out.println("Вам неудалось нанести специальный удар.");
                p.changeSpecial();
            }
        } else {
            if ((chanceP <= 10) && (p.getSpecial() > 0)) {
                System.out.println("Вы нанесли критический урон " + p.getStrength() * 2 + " ед. урона.");
                e.changeHealth(p.getStrength() * 2);
                p.changeSpecial();
            } else {
                System.out.println("Вы нанесли " + p.getStrength() + " ед. урона.");
                e.changeHealth(p.getStrength());
            }
        }
        
        if (e.getTarget() == p.getBlock()) {
            System.out.println("Вы блокируете удар противника!");
            if ((chanceE <= 10) && (e.getSpecial() > 0)) {
                System.out.println("Противнику неудалось нанести специальный удар.");
                e.changeSpecial();
            }
        } else {
            if ((chanceE <= 10) && (e.getSpecial() > 0)) {
                System.out.println("Противник нанес критический урон в " + e.getStrength() * 2 + " ед.");
                p.changeHealth(e.getStrength() * 2);
                e.changeSpecial();
            } else {
                System.out.println("Противник нанес " + e.getStrength() + " ед. урона.");
                p.changeHealth(e.getStrength());
            }
        }
    }   
    
    public int getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            inputLine = reader.readLine();
            if (inputLine.length() <= 0) return 0;
        } catch (IOException exc) {
            System.out.println("Error!");
        }
        
        return Integer.parseInt(inputLine);
    }
    
    public Gladiator getWinner() {
        return winner;
    }
    
    public Gladiator getLoser() {
        return loser;
    }
}