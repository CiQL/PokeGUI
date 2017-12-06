package Species.Types;
/**
 * Interface for typeless Pokémon.
 */
public interface NoneType {
   /** Type string. */
   String NONE_TYPE = "";
   /** Type color. */
   String NONE_COLOR = "";
   /** Type attacks aren't very effective against... */
   String[] NONE_NVE = {};
   /** Type attacks are super effective against... */
   String[] NONE_SE = {};
   /** Type attacks are completely ineffective against... */
   String[] NONE_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] NONE_FAST_ATTACKS = {};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] NONE_SPECIAL_ATTACKS = {};
   /** Fast attack power. */
   int[] NONE_FAST_ATK_POWER = {};
   /** Special attack power. */
   int[] NONE_SPECIAL_ATK_POWER = {};
}
