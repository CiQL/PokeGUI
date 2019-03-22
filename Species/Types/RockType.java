package Species.Types;
/**
 * Interface for Rock-type Pokémon.
 */
public interface RockType {
   /** Type string. */
   String ROCK_TYPE = "Rock";
   /** Type color. */
   String ROCK_COLOR = "Brown";
   /** Type attacks aren't very effective against... */
   String[] ROCK_NVE = {"Fighting", "Ground", "Steel"};
   /** Type attacks are super effective against... */
   String[] ROCK_SE = {"Bug", "Fire", "Flying", "Ice"};
   /** Type attacks are completely ineffective against... */
   String[] ROCK_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] ROCK_FAST_ATTACKS = {"Rock Throw"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] ROCK_SPECIAL_ATTACKS = {"Rock Slide", "Power Gem"};
   /** Fast attack power. */
   int[] ROCK_FAST_ATK_POWER = {12};
   /** Special attack power. */
   int[] ROCK_SPECIAL_ATK_POWER = {80, 80};
}
