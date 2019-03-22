package Species.Types;
/**
 * Interface for Poison-type Pokémon.
 */
public interface PoisonType {
   /** Type string. */
   String POISON_TYPE = "Poison";
   /** Type color. */
   String POISON_COLOR = "Purple";
   /** Type attacks aren't very effective against... */
   String[] POISON_NVE = {"Poison", "Ground", "Rock", "Ghost"};
   /** Type attacks are super effective against... */
   String[] POISON_SE = {"Grass", "Fairy"};
   /** Type attacks are completely ineffective against... */
   String[] POISON_NE = {"Steel"};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] POISON_FAST_ATTACKS = {"Acid", "Poison Jab", "Poison Sting"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] POISON_SPECIAL_ATTACKS = {"Cross Poison", "Gunk Shot", 
       "Poison Fang", "Sludge", "Sludge Bomb",
       "Sludge Wave"};
   /** Fast attack power. */
   int[] POISON_FAST_ATK_POWER = {10, 12, 6};
   /** Special attack power. */
   int[] POISON_SPECIAL_ATK_POWER = {25, 65, 25, 30, 55, 70};
}