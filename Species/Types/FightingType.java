package Species.Types;
/**
 * Interface for Fighting-type Pokémon.
 */
public interface FightingType {
   /** Type string. */
   String FIGHTING_TYPE = "Fighting";
   /** Type color. */
   String FIGHTING_COLOR = "Dark red";
   /** Type attacks aren't very effective against... */
   String[] FIGHTING_NVE = {"Dark", "Ice", "Normal", "Rock", "Steel"};
   /** Type attacks are super effective against... */
   String[] FIGHTING_SE = {"Bug", "Fairy", "Flying", 
                           "Poison", "Psychic"};
   /** Type attacks are completely ineffective against... */
   String[] FIGHTING_NE = {"Ghost"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] FIGHTING_FAST_ATTACKS = {"Rock Smash", "Karate Chop", "Low Kick"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] FIGHTING_SPECIAL_ATTACKS = {"Close Combat", "Focus Blast", 
                                        "Dynamic Punch", "Cross Chop",
                                        "Submission", "Brick Break"};
   /** Fast attack power. */
   int[] FIGHTING_FAST_ATK_POWER = {15, 8, 6};
   /** Special attack power. */
   int[] FIGHTING_SPECIAL_ATK_POWER = {100, 140, 90, 50, 60, 40};
}
