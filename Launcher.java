
/**
 * Write a description of class Launcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class Launcher {
    private ArrayList<Gladiator> glList;
    private Gladiator player;
    private Gladiator enemy;
    private String[] bodyParts = {"Голова", "Туловище", "Руки", "Ноги"};
    private Arena arena = new Arena();
    private BotArena bArena = new BotArena();
    
    private void setUpGame() {
        glList = new ArrayList<>();
        Secutor secutor = new Secutor("Арминий", "секутор", 100, 6);
        Retiarius retiarius = new Retiarius("Марк", "ретиарий", 100, 5);
        Thraex thraex = new Thraex("Луций", "фракиец", 100, 7);
        Murmillo murmillo = new Murmillo("Децим", "мурмиллон", 100, 5);
        
        glList.add(secutor);
        glList.add(retiarius);
        glList.add(thraex);
        glList.add(murmillo);
        
        mainMenu();
    }
    
    private void mainMenu() {        
              
       int i = 1;
       for (Gladiator gl : glList) {
           System.out.println(i + "." + gl.getName() + " -- " + gl.getType()
           + " | урон: " + gl.getStrength() + ", жизни: " + gl.getHealth());
           i++;
       }
       
       while (true) {
           int userChoice = (int) arena.getUserInput("Введите номер выбранного гладиатора:");
           if (userChoice > 4 || userChoice < 1) {
               System.out.println("Wrong command!");
               continue;
           }
           player = glList.get(userChoice - 1);
           glList.remove(player);
           System.out.println("Ваш выбор: " + player.getName());
       
           int choice = (int) (Math.random() * glList.size());
           enemy = glList.get(choice);
           System.out.println("Ваш противник: " + enemy.getName());
           glList.remove(enemy);
           break;
       }  
       
       System.out.println("\nБой начался!\n");
       arena.arena(player, enemy);
       bArena.compArena(glList.get(0), glList.get(1));
       secondRound();
    }
    
    private void secondRound() {
        Gladiator glad1 = arena.getWinner();
        Gladiator glad2 = bArena.getWinner();
        Gladiator glad3 = arena.getLoser();
        Gladiator glad4 = bArena.getLoser();
        glad1.setHealth(100);
        glad2.setHealth(100);
        glad3.setHealth(100);
        glad4.setHealth(100);
        if (player == arena.getWinner()) {           
            arena.arena(player, glad2);
            bArena.compArena(glad3, glad4);
            System.out.println();
            System.out.println("----------------------------------------------------------------");
            System.out.println("Турнир окончен!");
            System.out.println("----------------------------------------------------------------");
            System.out.println("Список победителей:");
            System.out.println("1 место -- " + arena.getWinner().getName() + " -- " + arena.getWinner().getType());
            System.out.println("2 место -- " + arena.getLoser().getName() + " -- " + arena.getLoser().getType());
            System.out.println("3 место -- " + bArena.getWinner().getName() + " -- " + bArena.getWinner().getType());
            System.out.println("4 место -- " + bArena.getLoser().getName() + " -- " + bArena.getLoser().getType());
        } else {
            if(player == arena.getLoser()) {                
                bArena.compArena(glad1, glad2);
                arena.arena(player, glad4);
                System.out.println("Турнир окончен!");
                System.out.println("Список победителей:");
                System.out.println("1 место -- " + bArena.getWinner().getName() + " -- " + bArena.getWinner().getType());
                System.out.println("2 место -- " + bArena.getLoser().getName() + " -- " + bArena.getLoser().getType());
                System.out.println("3 место -- " + arena.getWinner().getName() + " -- " + arena.getWinner().getType());
                System.out.println("4 место -- " + arena.getLoser().getName() + " -- " + arena.getLoser().getType());
            }
        }
    }
    
    public static void main(String[] args) {  
       System.out.println("Добро пожаловать на арену!");
       System.out.println("Выберите гладиатора из списка:");
       new Launcher().setUpGame();        
    }
}































