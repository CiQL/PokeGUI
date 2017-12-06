package Species.Types;
/**
 * Interface for Ice-type Pokémon.
 */
public interface IceType {
   /** Type string. */
   String ICE_TYPE = "Ice";
   /** Type color. */
   String ICE_COLOR = "Light blue";
   /** Type attacks aren't very effective against... */
   String[] ICE_NVE = {"Fire", "Ice", "Steel", "Water"};
   /** Type attacks are super effective against... */
   String[] ICE_SE = {"Dragon", "Flying", "Grass", "Ground"};
   /** Type attacks are completely ineffective against... */
   String[] ICE_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] ICE_FAST_ATTACKS = {"Frost Breath", "Ice Shard", "Powder Snow"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] ICE_SPECIAL_ATTACKS = {"Blizzard", "Avalanche", "Ice Beam", 
                                   "Ice Punch"};
   /** Fast attack power. */
   int[] ICE_FAST_ATK_POWER = {10, 12, 6};
   /** Special attack power. */
   int[] ICE_SPECIAL_ATK_POWER = {130, 90, 90, 50};
}
