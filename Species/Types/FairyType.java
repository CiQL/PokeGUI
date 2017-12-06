package Species.Types;
/**
 * Interface for Fairy-type Pokémon.
 */
public interface FairyType {
   /** Type string. */
   String FAIRY_TYPE = "Fairy";
   /** Type color. */
   String FAIRY_COLOR = "Pink";
   /** Type attacks aren't very effective against... */
   String[] FAIRY_NVE = {"Fire", "Poison", "Steel"};
   /** Type attacks are super effective against... */
   String[] FAIRY_SE = {"Dark", "Dragon", "Fighting"};
   /** Type attacks are completely ineffective against... */
   String[] FAIRY_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] FAIRY_FAST_ATTACKS = {"Fairy Wind"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] FAIRY_SPECIAL_ATTACKS = {"Moonblast", "Play Rough", 
                                     "Dazzling Gleam"};
   /** Fast attack power. */
   int[] FAIRY_FAST_ATK_POWER = {10};
   /** Special attack power. */
   int[] FAIRY_SPECIAL_ATK_POWER = {130, 90, 100};
}
