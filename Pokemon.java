//Leah Yi
import java.awt.image.*;
import java.util.*;
public class Pokemon implements IPokemon {
    //Fields
    private String name;
    private int hp;
    private String type;
    private int atk;
    private int expPts;
    private int def;
    private int maxHP;
    private BufferedImage image;
    public Pokemon(String name, String type, int hp, BufferedImage image) {
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.image = image;
        maxHP = hp;
        expPts = 0;
    }
    public String getName() {
        return name;
    }
    public int getHP() {
        return hp;
    }
    public int getAtk() {
        Random r = new Random();
        int x = r.nextInt(101)+20;
        atk = x;
        if(expPts > 0) {
            atk += expPts;
        }
        return atk;
    }
    public int getExpPts() {
        return expPts;
    }
    public String getType() {
        return type;
    }
    public int getDef() {
        Random r = new Random();
        int x = r.nextInt(101)+20;
        def = x;
        return def;
    }
    public BufferedImage getImage() {
        return image;
    }
    public int getMaxHP() {
        return maxHP;
    }
    //mutators
    public int damage(int damage) {
        hp -= damage;
        if(hp < 0) {
            hp = 0;
        }
        return hp;
    }
    public int heal(int heal) {
        hp += heal;
        if(hp > maxHP) {
            hp = maxHP;
        }
        return hp;
    }
    public int expUp(int exp) {
        if(maxHP - hp >=10) {
            expPts++;
        }
        return expPts;
    }
    public String toString() {
        return "Name: " + name + "\nType: " + type + "\nMaxHP: " + maxHP + "\nExp: " + expPts;
    }
}