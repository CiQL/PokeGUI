package Species.Types;
/**
 * Interface for Electric-type Pokémon.
 */
public interface ElectricType {
   /** Type string. */
   String ELECTRIC_TYPE = "Electric";
   /** Type color. */
   String ELECTRIC_COLOR = "Yellow";
   /** Type attacks aren't very effective against... */
   String[] ELECTRIC_NVE = {"Grass", "Electric", "Dragon"};
   /** Type attacks are super effective against... */
   String[] ELECTRIC_SE = {"Water", "Flying"};
   /** Type attacks are completely ineffective against... */
   String[] ELECTRIC_NE = {"Ground"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] ELECTRIC_FAST_ATTACKS = {"Charge Beam", "Spark", "Thundershock"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] ELECTRIC_SPECIAL_ATTACKS = {"Discharge", "Parabolic Charge",
                                        "Thunder Punch", "Thunder", 
                                        "Thunderbolt"};
   /** Fast attack power. */
   int[] ELECTRIC_FAST_ATK_POWER = {8, 6, 5};
   /** Special attack power. */
   int[] ELECTRIC_SPECIAL_ATK_POWER = {35, 15, 40, 100, 55};
}