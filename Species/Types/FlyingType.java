package Species.Types;
/**
 * Interface for Flying-type Pokémon.
 */
public interface FlyingType {
   /** Type string. */
   String FLYING_TYPE = new String("Flying");
   /** Type color. */
   String FLYING_COLOR = new String("Sky blue");
   /** Type attacks aren't very effective against... */
   String[] FLYING_NVE = {"Electric", "Rock", "Steel"};
   /** Type attacks are super effective against... */
   String[] FLYING_SE = {"Grass", "Fighting", "Bug"};
   /** Type attacks are completely ineffective against... */
   String[] FLYING_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] FLYING_FAST_ATTACKS = {"Peck", "Wing Attack"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] FLYING_SPECIAL_ATTACKS = {"Aerial Ace", "Air Cutter", 
       "Drill Peck", "Hurricane"};
   /** Fast attack power. */
   int[] FLYING_FAST_ATK_POWER = {10, 9};
   /** Special attack power. */
   int[] FLYING_SPECIAL_ATK_POWER = {30, 30, 40, 80};
}