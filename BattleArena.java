/* Battle Arena is a Game made for 
 * Kamiak High School AP Computer Science Course
 * Mr. Binz 2/2/2018
 * Version 1.2
 * This version of Battle Arena uses:
 * Button Class (Nathan Binz, 2018)
 * ActorButton Class (Nathan Binz, 2018)
 * IPokemon interface (Nathan Binz, 2018)
 * IPokedex interface (Nathan Binz, 2018)
 * DrawingPanel Class(Marty Stepp, 2010)
 * 
 * Students are expected to create Pokemon and Pokedex class using the IPokemon interface
 * After they complete this, they upload all the above classes into their project
 * 
 * Created on the BlueJ IDE
 * 
 */

import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class BattleArena implements MouseInputListener{
    
    private int counter = 0;
    private ActorButton[][] actors;
    private Graphics g;
    private DrawingPanel panel;
    private final int SIZE = 150;  
    private ActorButton temp;
    private int tempVal;

    
    public BattleArena() throws IOException {
        tempVal = -1;
        panel = new DrawingPanel(SIZE*5,9*SIZE/2);
        g = panel.getGraphics();
        IPokedex dex1 = new Pokedex();
        IPokedex dex2 = new Pokedex();
        IPokemon[][] teams = getTeams(dex1, dex2);
        actors = new ActorButton[2][5];
        for(int i = 0; i<5; i++){
            actors[0][i] = new ActorButton(i*SIZE, 0, SIZE, SIZE, teams[0][i]);
            actors[1][i] = new ActorButton(i*SIZE, 5*SIZE/2, SIZE, SIZE, teams[1][i]);
        }
        panel.addMouseListener(this);
        drawArena();
    }
    
    //This method gets two distict teams from the Pokedex.  It is only called by the constructor.  The teams are then stored in ActorButtons.
    private IPokemon[][] getTeams(IPokedex a, IPokedex b){
        IPokemon[][] toReturn = new IPokemon[2][5];
        IPokemon[] t1 = a.getTeam();
        IPokemon[] t2 = b.getTeam();
        for(int i = 0; i<5; i++){
            toReturn[0][i] = t1[i];
            toReturn[1][i] = t2[i];
        }
        return toReturn;
    }
    
    //Draw Arena is to populate the board with all of the components.  It is called by the client code.
    public void drawArena(){
        g.setColor(Color.WHITE);
        g.fillRect(0,0, panel.getWidth(),panel.getHeight());
        g.setColor(Color.BLACK);
        g.setFont(new Font("Veranda", Font.BOLD, panel.getWidth()/35));        
        for(int i = 0; i<actors.length; i++){
            for(int j = 0; j<actors[i].length; j++){
                
                int x = actors[i][j].getX();
                int y = actors[i][j].getY();
                int h = actors[i][j].getHeight() + 25;
                g.drawString(actors[i][j].getName(), x,y+h + SIZE/16);
                g.drawString(actors[i][j].getType(), x,y+h+SIZE/5);
                g.drawString(actors[i][j].getHP() + "/" + actors[i][j].getMaxHP(), x, y+h+SIZE/3);
                if(actors[i][j].getHP()>0){
                    actors[i][j].drawButton(g);
                }
            }
        }
        Button turn = getPlayer();       
        int x = turn.getX();
        int y = turn.getY() + turn.getHeight();
        g.setColor(Color.RED);
        g.fillRect(x, y, turn.getWidth(), 5);
    }
    
    //Used in the class to get the Button representing the Actor.
    private Button getPlayer(){
        int player = counter%2 == 0 ? 0:1;
        int index = counter/2;
        if(actors[player][index].getHP()<=0){
            counter++;
            if(counter == 10) counter = 0;
            return getPlayer();
        }
        return actors[player][index]; 
    }
    
    //used to help the mouse listener to determine if it is an event that relates to an actor
    //the integer returned represents the row and column of ActionButton[][].  ex  13 represents row 1 column 3; 2 represents row 0 column 2.
    private int event(MouseEvent me){
        int mouseX = me.getX();
        int mouseY = me.getY();
        for(int i = 0; i< actors.length; i++){
            for(int j = 0; j<actors[i].length; j++){
                Button check = actors[i][j];
                if(mouseX>check.getX() && mouseX<check.getX()+check.getWidth() && mouseY>check.getY() && mouseY<check.getY() +check.getHeight()){
                    return 10*i+j;
                }
            }
        }
        return -1;
    }
    
    //Used to determine if there are still pokemon on both sides.    
    private boolean inPlay(){
        boolean player1 = false;
        boolean player2 = false;
        for(int j = 0; j<actors[0].length; j++){
            if(actors[0][j].getHP()>0) player1 = true;
            if(actors[1][j].getHP()>0) player2 = true;
            if(player1 && player2) return true;    
        }
        return false;
    }
    //If only one side has pokemon, the endgame will display.
    public void endGame(){
        g.setColor(Color.WHITE);
        g.fillRect(0,0, panel.getWidth(),panel.getHeight());
        g.setColor(Color.RED);
        g.setFont(new Font("Veranda", Font.BOLD, panel.getWidth()/10));
        g.drawString("GAME OVER",0,panel.getHeight()/4*3);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        int val = event(me);
        if(val>=0 && actors[val/10][val%10].getHP()>0){
            int row = val/10;
            int col = val%10;
            IPokemon target = actors[row][col].getActor();
            IPokemon primary = actors[counter%2==0? 0:1][counter/2].getActor();
            if(row%2 == counter%2){//heal
                target.heal(primary.getAtk());
            } else {//damage
                target.damage(Math.abs(primary.getAtk()-target.getDef()));
            }
            counter++;
            if(counter==10) counter = 0;
            if(inPlay()){
                drawArena();
            } else {
                endGame();
            }
        }
    }

                
    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {    
        int val = event(me);
        if(val>=0 && val != tempVal){
            tempVal = val;
            if(temp!= null){
                temp.imageSwap();
            }
            temp = actors[val/10][val%10];
            temp.imageSwap();
            drawArena();
        } else if(val<0 && temp != null){
            tempVal = -1;
            temp.imageSwap();
            temp = null;
            drawArena();
        }
       
    }
    
    
}
    
