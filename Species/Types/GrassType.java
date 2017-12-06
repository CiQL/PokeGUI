package Species.Types;
/**
* Interface for Grass-type Pokémon.
*/
public interface GrassType {
   /** Type string. */
   String GRASS_TYPE = new String("Grass");
   /** Type color. */
   String GRASS_COLOR = new String("Green");
   /** Type attacks aren't very effective against... */
   String[] GRASS_NVE = {"Fire", "Grass", "Poison", "Flying", 
       "Bug", "Dragon", "Steel"};
   /** Type attacks are super effective against... */
   String[] GRASS_SE = {"Water", "Ground", "Rock"};
   /** Type attacks are completely ineffective against... */
   String[] GRASS_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] GRASS_FAST_ATTACKS = {"Razor Leaf", "Vine Whip"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] GRASS_SPECIAL_ATTACKS = {"Leaf Blade", "Petal Blizzard", 
       "Power Whip", "Seed Bomb", "Solar Beam"};
   /** Fast attack power. */
   int[] GRASS_FAST_ATK_POWER = {15, 7};
   /** Special attack power. */      
   int[] GRASS_SPECIAL_ATK_POWER = {55, 65, 70, 40, 120}; 
}