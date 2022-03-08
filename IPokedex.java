public interface IPokedex
{
    
    public void shuffle();//command to shuffle your pokemon in your pokedex
    public IPokemon[] getPokedex();//all pokemon in your pokedex
    public IPokemon[] getTeam();//5 random pokemon from your pokedex
}