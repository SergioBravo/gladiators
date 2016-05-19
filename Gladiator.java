
/**
 * Abstract class Gladiator - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Gladiator {
    private String name;
    private String type;
    private int health;
    private int strength;
    private int target;
    private int block;
    private int special = 3;
    
    public Gladiator(String n, String t, int h, int s) {
        name = n;
        type = t;
        health = h;
        strength = s;
    }
    
    public abstract void ultimate();
    
    public void changeSpecial() {
        special -= 1;
    }
    
    public int getSpecial() {
        return special;
    }
    
    public String getName() {
        return name;
    }
    
    public void changeHealth(int damage) {
        health -= damage;
    }
    
    public void setHealth(int h) {
        health = h;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getStrength() {
        return strength;
    }
    
    public String getType() {
        return type;
    }
    
    public void setTarget(int t) {
        target = t;
    }
    
    public int getTarget() {
        return target;
    }
    
    public void setBlock(int b) {
        block = b;
    }
    
    public int getBlock() {
        return block;
    } 
}
