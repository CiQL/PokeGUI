package Species.Types;
/**
 * Interface for Ground-type Pokémon.
 */
public interface GroundType {
   /** Type string. */
   String GROUND_TYPE = "Ground";
   /** Type color. */
   String GROUND_COLOR = "Light brown";
   /** Type attacks aren't very effective against... */
   String[] GROUND_NVE = {"Bug", "Grass"};
   /** Type attacks are super effective against... */
   String[] GROUND_SE = {"Electric", "Fire", "Poison", "Rock", "Steel"};
   /** Type attacks are completely ineffective against... */
   String[] GROUND_NE = {"Flying"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] GROUND_FAST_ATTACKS = {"Mud Slap", "Mud Shot"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] GROUND_SPECIAL_ATTACKS = {"Earthquake", "Drill Run", "Mud Bomb"};
   /** Fast attack power. */
   int[] GROUND_FAST_ATK_POWER = {15, 5};
   /** Special attack power. */
   int[] GROUND_SPECIAL_ATK_POWER = {120, 80, 55};
}
