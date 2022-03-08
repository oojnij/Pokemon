import java.awt.Graphics;

public class ActorButton extends Button{
      private IPokemon actor;
    
    public ActorButton(int xStart, int yStart, int width, int height, IPokemon actor){
        super(xStart, yStart, width, height, null, actor.getImage());
        this.actor = actor;
    }
    
    public IPokemon getActor(){
        return actor;
    }
    
    public String getName(){
        return actor.getName();   
    }        
    
    public int getHP(){
        return actor.getHP();
    } 
    
    public int getMaxHP(){
        return actor.getMaxHP();
    }
    
    public int getAtk(){
        return actor.getAtk();
    }
    
    public String getType(){
        return actor.getType();
    }
    
    public int getDef(){
        return actor.getDef();
    }
    
    public int damage(int damage){
        return actor.damage(damage);
    }
    
    public int heal(int heal){
        return actor.heal(heal);
    }
    
    public String toString(){
        return actor.toString();
    }
}