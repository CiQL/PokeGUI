package Species.Types;
/**
 * Interface for Dragon-type Pokémon.
 */
public interface DragonType {
   /** Type string. */
   String DRAGON_TYPE = "Dragon";
   /** Type color. */
   String DRAGON_COLOR = "Purple";
   /** Type attacks aren't very effective against... */
   String[] DRAGON_NVE = {"Steel"};
   /** Type attacks are super effective against... */
   String[] DRAGON_SE = {"Dragon"};
   /** Type attacks are completely ineffective against... */
   String[] DRAGON_NE = {"Fairy"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] DRAGON_FAST_ATTACKS = {"Dragon Tail", "Dragon Breath"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] DRAGON_SPECIAL_ATTACKS = {"Dragon Claw", "Outrage",
                                      "Dragon Pulse"};
   /** Fast attack power. */
   int[] DRAGON_FAST_ATK_POWER = {15, 6};
   /** Special attack power. */
   int[] DRAGON_SPECIAL_ATK_POWER = {50, 110, 90};
}
