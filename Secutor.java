
/**
 * Write a description of class Secutor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Secutor extends Gladiator {
    private String name;
    private String type;
    private int health;
    private int strength;   
    
    public Secutor (String n,String t, int h, int s) {
        super(n, t, h, s);
    }
    
    public void ultimate() {
        System.out.println("Гладиатор используент специальный прием");
    }    
}
