//Leah Yi
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import java.io.File;
import java.util.*;
public class Pokedex implements IPokedex {
    private IPokemon[] pokedex;
    public Pokedex() throws IOException {
        pokedex = new IPokemon[20];
        pokedex[0] = new Pokemon("Mickey Mouse", "Magic", 60, ImageIO.read(new File("Mickey_Mouse.png")));
        pokedex[1] = new Pokemon("Saber", "Magic", 200, ImageIO.read(new File("Saber.jpg")));
        pokedex[2] = new Pokemon("Joker", "Stand", 150, ImageIO.read(new File("joker.png")));
        pokedex[3] = new Pokemon("Jotaro", "Stand", 200, ImageIO.read(new File("Jotaro.jpg")));
        pokedex[4] = new Pokemon("Edward", "Alchemy", 140, ImageIO.read(new File("Edward.jpg")));
        pokedex[5] = new Pokemon("Roy", "Alchemy", 150, ImageIO.read(new File("roy.jpg")));
        pokedex[6] = new Pokemon("Guts", "Over powered", 350, ImageIO.read(new File("Guts.jpg")));
        pokedex[7] = new Pokemon("Griffith", "Over powered", 350, ImageIO.read(new File("griffith.jpg")));
        pokedex[8] = new Pokemon("Shrek", "Swamp", 80, ImageIO.read(new File("shrek.jpg")));
        pokedex[9] = new Pokemon("Swamp", "Swamp", 80, ImageIO.read(new File("swamp.jpg")));
        pokedex[10] = new Pokemon("Pikachu", "Electricity", 100, ImageIO.read(new File("Pikachu.png")));
        pokedex[11] = new Pokemon("Misaka", "Electricity", 150, ImageIO.read(new File("Misaka.jpg")));
        pokedex[12] = new Pokemon("Gojo", "Jujutsu", 300, ImageIO.read(new File("Gojo.png")));
        pokedex[13] = new Pokemon("Kugisaki", "Jujutsu", 300, ImageIO.read(new File("kugisaki.jpg")));
        pokedex[14] = new Pokemon("I got the power of God and anime on my side", "Memes", 350, ImageIO.read(new File("God-and-anime.jpg")));
        pokedex[15] = new Pokemon("Elmo", "Memes", 70, ImageIO.read(new File("elmo.png")));
        pokedex[16] = new Pokemon("Spike", "Gun", 180, ImageIO.read(new File("Spike.jpg")));
        pokedex[17] = new Pokemon("Faye", "Gun", 180, ImageIO.read(new File("Faye.png")));
        pokedex[18] = new Pokemon("Johan", "Manipulation", 130, ImageIO.read(new File("Johan.jpg")));
        pokedex[19] = new Pokemon("Walter White", "Manipulation", 130, ImageIO.read(new File("Walter.png")));
    }
    public void shuffle() {
        Random rand = new Random();
        for(int i = pokedex.length - 1; i > 0; i--) {
            int x = rand.nextInt(pokedex.length);
            IPokemon temp = pokedex[i];
            pokedex[i] = pokedex[x];
            pokedex[x] = temp;
        }
    }
    public IPokemon[] getPokedex() {
        return pokedex;
    }
    public IPokemon[] getTeam() {
        shuffle();
        IPokemon[] team = new IPokemon[5];
        for(int i = 0; i < 5; i++) {
            team[i] = pokedex[i];
        }
        return team;
    }
}