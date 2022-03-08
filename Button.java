import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Button {
    private int xInit;
    private int yInit;
    private int width;
    private int height;
    private BufferedImage image;
    private BufferedImage image2;
    private String text;
    public Button(int xStart, int yStart, int width, int height, String text, BufferedImage image){
        this(xStart,yStart,width,height, text);
        this.image = resize(image);   
        resize(1.25);
    }
    
    public Button(int xStart, int yStart, int width, int height, String text){
        xInit = xStart;
        yInit = yStart;
        this.width = width;
        this.height = height;
        this.text = text;
    }
    
    public boolean pressed(int x, int y){
        return x>xInit && x<(xInit+width) && y>yInit && y<(yInit+height);
    }
    
    public BufferedImage resize(BufferedImage image){
        BufferedImage scaled = new BufferedImage(width,height,image.getType());
        Graphics g2 = scaled.createGraphics();
        g2.drawImage(image,0,0,width, height,null);
        g2.dispose();
        return scaled;
    }
    
    private void resize(double percent){
        image2 = new BufferedImage(width,height, image.getType());
        Graphics g2 = image2.createGraphics();
        g2.drawImage(image,0,0,(int) (width*percent),(int) (height*percent),null);
        g2.dispose();        
    }
    
    public void imageSwap(){
        BufferedImage temp = image;
        image = image2;
        image2 = temp;
    }
    
    public void drawButton(Graphics g){
        if(image != null){
            image = this.resize(image);
            g.drawImage(image, xInit, yInit, null);
        }else{
            g.setColor(Color.GRAY);
            g.fillRect(xInit,yInit,width,height);
            g.setColor(Color.BLACK);
            int fontScale = width/text.length() - width/10;
            g.setFont(new Font("Veranda", Font.BOLD, fontScale));
            g.drawString(text, xInit + width/10, yInit+height/10);
        }        
    }
    
    public int getX(){
        return xInit;
    }
    public int getY(){
        return yInit;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}