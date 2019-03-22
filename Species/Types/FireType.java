package Species.Types;
/**
 * Interface for Fire-type Pokémon.
 */
public interface FireType {
   /** Type string. */
   String FIRE_TYPE = "Fire";
   /** Type color. */
   String FIRE_COLOR = "Red";
   /** Type attacks aren't very effective against... */
   String[] FIRE_NVE = {"Water", "Fire", "Rock", "Dragon"};
   /** Type attacks are super effective against... */
   String[] FIRE_SE = {"Grass", "Ice", "Bug", "Steel"};
   /** Type attacks are completely ineffective against... */
   String[] FIRE_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] FIRE_FAST_ATTACKS = {"Ember", "Fire Fang"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] FIRE_SPECIAL_ATTACKS = {"Fire Blast", "Fire Punch", 
      "Flame Burst", "Flame Charge", 
      "Flame Wheel", "Flame Thrower", "Heat Wave"};
   /** Fast attack power. */
   int[] FIRE_FAST_ATK_POWER = {10, 10};
   /** Special attack power. */
   int[] FIRE_SPECIAL_ATK_POWER = {100, 40, 30, 25, 40, 55, 80};
}