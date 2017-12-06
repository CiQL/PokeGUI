package Species.Types;
/**
 * Interface for Dark-type Pokémon.
 */
public interface DarkType {
   /** Type string. */
   String DARK_TYPE = "Dark";
   /** Type color. */
   String DARK_COLOR = "Black";
   /** Type attacks aren't very effective against... */
   String[] DARK_NVE = {"Fairy", "Fighting", "Dark"};
   /** Type attacks are super effective against... */
   String[] DARK_SE = {"Ghost", "Psychic"};
   /** Type attacks are completely ineffective against... */
   String[] DARK_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] DARK_FAST_ATTACKS = {"Bite", "Feint Attack"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] DARK_SPECIAL_ATTACKS = {"Foul Play", "Dark Pulse", "Night Slash",
                                    "Crunch"};
   /** Fast attack power. */
   int[] DARK_FAST_ATK_POWER = {6, 10};
   /** Special attack power. */
   int[] DARK_SPECIAL_ATK_POWER = {70, 80, 50, 70};
}
