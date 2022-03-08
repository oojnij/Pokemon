import java.io.IOException;
public class PokedexTester {
        public static void main(String[] args) throws IOException{
        test1();
    }

    public static void test1() throws IOException{
        System.out.println("No arguement test: ");
        IPokedex dex = new Pokedex();
        IPokemon[] actors = dex.getPokedex();
        printArray(actors, 1);
        dex.shuffle();
        actors = dex.getPokedex();
        printArray(actors, 2);
        dex.shuffle();
        actors = dex.getTeam();
        printArray(actors, 3);
        actors = dex.getTeam();
        printArray(actors, 4);
    }
    
    public static IPokemon[] getArray(){
        return null;
    }
    
    public static void printArray(IPokemon[] actors, int instance){
        if(instance == 1){
            System.out.println("Initial List");
        } else if(instance == 2){
            System.out.println("Shuffled");
        } else if(instance == 3){
            System.out.println("Team 1");
        } else if(instance == 4){
            System.out.println("Team 2 (no advanced shuffle)");
        } else {
            System.out.println("error");
        }
        for(IPokemon p: actors){
            System.out.println(p);
        }
        System.out.println();
    }
}