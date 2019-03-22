package Species.Types;
/**
 * Interface for Ghost-type Pokémon.
 */
public interface GhostType {
   /** Type string. */
   String GHOST_TYPE = "Ghost";
   /** Type color. */
   String GHOST_COLOR = "Deep purple";
   /** Type attacks aren't very effective against... */
   String[] GHOST_NVE = {"Ghost", "Psychic"};
   /** Type attacks are super effective against... */
   String[] GHOST_SE = {"Dark"};
   /** Type attacks are completely ineffective against... */
   String[] GHOST_NE = {"Normal"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] GHOST_FAST_ATTACKS = {"Shadow Claw", "Lick", "Hex",
                                    "Astonish"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] GHOST_SPECIAL_ATTACKS = {"Shadow Ball", "Shadow Punch",
                                     "Night Shade", "Ominous Wind",
                                     "Shadow Sneak"};
   /** Fast attack power. */
   int[] GHOST_FAST_ATK_POWER = {9, 5, 10, 8};
   /** Special attack power. */
   int[] GHOST_SPECIAL_ATK_POWER = {100, 40, 60, 50, 50};
}
