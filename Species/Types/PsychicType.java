package Species.Types;
/**
 * Interface for Psychic-type Pokémon.
 */
public interface PsychicType {
   /** Type string. */
   String PSYCHIC_TYPE = "Psychic";
   /** Type color. */
   String PSYCHIC_COLOR = "Purple";
   /** Type attacks aren't very effective against... */
   String[] PSYCHIC_NVE = {"Psychic", "Steel"};
   /** Type attacks are super effective against... */
   String[] PSYCHIC_SE = {"Fighting", "Poison"};
   /** Type attacks are completely ineffective against... */
   String[] PSYCHIC_NE = {"Dark"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] PSYCHIC_FAST_ATTACKS = {"Confusion", "Extrasensory", "Zen Headbutt",
                                    "Psycho Cut"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] PSYCHIC_SPECIAL_ATTACKS = {"Psychic", "Psyshock", "Psybeam"};
   /** Fast attack power. */
   int[] PSYCHIC_FAST_ATK_POWER = {20, 12, 12, 5};
   /** Special attack power. */
   int[] PSYCHIC_SPECIAL_ATK_POWER = {100, 65, 70};
}
