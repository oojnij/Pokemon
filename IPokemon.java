import java.awt.image.BufferedImage;
public interface IPokemon {
    //accessor methods
    public String getName();
    public int getHP();
    public int getAtk();
    public int getExpPts();
    public String getType();
    public int getDef();
    public BufferedImage getImage();
    public int getMaxHP();
    
    //mutator methods
    public int damage(int damage);
    public int heal(int heal);
    public int expUp(int exp);
    public String toString();
}