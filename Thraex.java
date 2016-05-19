
/**
 * Write a description of class Thraex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thraex extends Gladiator {
    private String name;
    private String type;
    private int health;
    private int strength;   
    
    public Thraex (String n,String t, int h, int s) {
        super(n, t, h, s);
    }
    
    public void ultimate() {
        System.out.println("Гладиатор используент специальный прием");
    }
}

