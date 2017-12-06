package Species.Types;
/**
 * Interface for Normal-type Pokémon.
 */
public interface NormalType {
   /** Type string. */
   String NORMAL_TYPE = "Normal";
   /** Type color. */
   String NORMAL_COLOR = "White";
   /** Type attacks aren't very effective against... */
   String[] NORMAL_NVE = {"Rock", "Steel"};
   /** Type attacks are super effective against... */
   String[] NORMAL_SE = {};
   /** Type attacks are completely ineffective against... */
   String[] NORMAL_NE = {"Ghost"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] NORMAL_FAST_ATTACKS = {"Cut", "Pound", "Quick Attack",
                                   "Scratch", "Tackle"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] NORMAL_SPECIAL_ATTACKS = {"Wrap", "Hyper Beam", "Vice Grip",
                                      "Swift", "Horn Attack", "Stomp",
                                      "Hyper Fang", "Body Slam"};
   /** Fast attack power. */
   int[] NORMAL_FAST_ATK_POWER = {12, 7, 8, 6, 5};
   /** Special attack power. */
   int[] NORMAL_SPECIAL_ATK_POWER = {25, 120, 25, 30, 25, 30, 35, 40};
}