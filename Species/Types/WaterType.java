package Species.Types;
/**
 * Interface for Water-type Pokémon.
 */
public interface WaterType {
   /** Type string. */
   String WATER_TYPE = "Water";
   /** Type color. */
   String WATER_COLOR = "Blue";
   /** Type attacks aren't very effective against... */
   String[] WATER_NVE = {"Water", "Grass", "Dragon"};
   /** Type attacks are super effective against... */
   String[] WATER_SE = {"Fire", "Ground", "Rock"};
   /** Type attacks are completely ineffective against... */
   String[] WATER_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] WATER_FAST_ATTACKS = {"Bubble", "Splash", "Water Gun"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] WATER_SPECIAL_ATTACKS = {"Aqua Jet", "Aqua Tail", "Brine",
       "Bubble Beam", "Hydro Pump", "Scald", "Water Pulse"};
   /** Fast attack power. */
   int[] WATER_FAST_ATK_POWER = {25, 0, 6};
   /** Special attack power. */
   int[] WATER_SPECIAL_ATK_POWER = {25, 45, 25, 30, 90, 55, 35};
}