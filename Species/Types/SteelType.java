package Species.Types;
/**
 * Interface for Steel-type Pokémon.
 */
public interface SteelType {
   /** Type string. */
   String STEEL_TYPE = "Steel";
   /** Type color. */
   String STEEL_COLOR = "Silver";
   /** Type attacks aren't very effective against... */
   String[] STEEL_NVE = {"Electric", "Fire", "Steel", "Water"};
   /** Type attacks are super effective against... */
   String[] STEEL_SE = {"Fairy", "Ice", "Rock"};
   /** Type attacks are completely ineffective against... */
   String[] STEEL_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] STEEL_FAST_ATTACKS = {"Steel Wing", "Iron Tail", "Metal Claw", 
                                  "Bullet Punch"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] STEEL_SPECIAL_ATTACKS = {"Flash Cannon", "Heavy Slam", "Iron Head",
                                     "Magnet Bomb", "Gyro Ball"};
   /** Fast attack power. */
   int[] STEEL_FAST_ATK_POWER = {11, 15, 8, 9};
   /** Special attack power. */
   int[] STEEL_SPECIAL_ATK_POWER = {100, 70, 60, 70, 80};
}
