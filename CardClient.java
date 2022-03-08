import java.awt.image.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
public class CardClient{
    public static void main(String[] args) throws IOException {
        //Mickey Mouse
        BufferedImage image1 = ImageIO.read(new File("Mickey_Mouse.png"));
        Pokemon actor1 = new Pokemon("Mickey Mouse", "Magic", 60, image1);
        PokemonCard a = new PokemonCard(actor1);
        
        //Saber
        BufferedImage image2 = ImageIO.read(new File("Saber.jpg"));
        Pokemon actor2 = new Pokemon("Saber", "Magic", 200, image2);
        PokemonCard b = new PokemonCard(actor2);
        
        //Joker
        BufferedImage image3 = ImageIO.read(new File("joker.png"));
        Pokemon actor3 = new Pokemon("Joker (Akira Kurusu)", "Stand", 150, image3);
        PokemonCard c = new PokemonCard(actor3);
        
        //Jotaro
        BufferedImage image4 = ImageIO.read(new File("Jotaro.jpg"));
        Pokemon actor4 = new Pokemon("Jotaro", "Stand", 200, image4);
        PokemonCard d = new PokemonCard(actor4);
        
        //Edward
        BufferedImage image5 = ImageIO.read(new File("Edward.jpg"));
        Pokemon actor5 = new Pokemon("Edward", "Alchemy", 140, image5);
        PokemonCard e = new PokemonCard(actor5);
        
        //Roy
        BufferedImage image6 = ImageIO.read(new File("roy.jpg"));
        Pokemon actor6 = new Pokemon("Roy", "Alchemy", 150, image6);
        PokemonCard f = new PokemonCard(actor6);
        
        //Guts
        BufferedImage image7 = ImageIO.read(new File("Guts.jpg"));
        Pokemon actor7 = new Pokemon("Guts", "Over powered", 350, image7);
        PokemonCard g = new PokemonCard(actor7);
        
        //Griffith
        BufferedImage image8 = ImageIO.read(new File("griffith.jpg"));
        Pokemon actor8 = new Pokemon("Griffith", "Over powered", 350, image8);
        PokemonCard h = new PokemonCard(actor8);
        
        //Shrek
        BufferedImage image9 = ImageIO.read(new File("shrek.jpg"));
        Pokemon actor9 = new Pokemon("Shrek", "Swamp", 80, image9);
        PokemonCard i = new PokemonCard(actor9);
        
        //Swamp
        BufferedImage image10 = ImageIO.read(new File("swamp.jpg"));
        Pokemon actor10 = new Pokemon("Swamp", "Swamp", 80, image10);
        PokemonCard j = new PokemonCard(actor10);
        
        //Pikachu
        BufferedImage image11 = ImageIO.read(new File("Pikachu.png"));
        Pokemon actor11 = new Pokemon("Pikachu", "Electricity", 100, image11);
        PokemonCard k = new PokemonCard(actor11);
        
        //Misaka
        BufferedImage image12 = ImageIO.read(new File("Misaka.jpg"));
        Pokemon actor12 = new Pokemon("Misaka", "Electricity", 150, image12);
        PokemonCard l = new PokemonCard(actor12);
        
        //Gojo
        BufferedImage image13 = ImageIO.read(new File("Gojo.png"));
        Pokemon actor13 = new Pokemon("Gojo", "Jujutsu", 300, image13);
        PokemonCard m = new PokemonCard(actor13);
        
        //Kugisaki
        BufferedImage image14 = ImageIO.read(new File("kugisaki.jpg"));
        Pokemon actor14 = new Pokemon("Kugisaki", "Jujutsu", 300, image14);
        PokemonCard n = new PokemonCard(actor14);
        
        //GodAndAnime
        BufferedImage image15 = ImageIO.read(new File("God-and-anime.jpg"));
        Pokemon actor15 = new Pokemon("I got the power of God and anime on my side", "Memes", 350, image15);
        PokemonCard o = new PokemonCard(actor15);
        
        //Elmo
        BufferedImage image16 = ImageIO.read(new File("elmo.png"));
        Pokemon actor16 = new Pokemon("Elmo", "Memes", 70, image16);
        PokemonCard p = new PokemonCard(actor16);
        
        //Spike
        BufferedImage image17 = ImageIO.read(new File("Spike.jpg"));
        Pokemon actor17 = new Pokemon("Spike", "Gun", 180, image17);
        PokemonCard q = new PokemonCard(actor17);
        
        //Faye
        BufferedImage image18 = ImageIO.read(new File("Faye.png"));
        Pokemon actor18 = new Pokemon("Faye", "Gun", 180, image18);
        PokemonCard r = new PokemonCard(actor18);
        
        //Johan
        BufferedImage image19 = ImageIO.read(new File("Johan.jpg"));
        Pokemon actor19 = new Pokemon("Johan", "Manipulation", 130, image19);
        PokemonCard s = new PokemonCard(actor19);
        
        //Walter White
        BufferedImage image20 = ImageIO.read(new File("Walter.png"));
        Pokemon actor20 = new Pokemon("Walter White", "Manipulation", 130, image20);
        PokemonCard t = new PokemonCard(actor20);
    }
}