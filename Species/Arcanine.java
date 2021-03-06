package Species;
import java.util.Random;
import Species.Types.FireType;
import Species.Types.NoneType;
/**
* Arcanine Pokémon object class.
* 
* @author Evan Paresa, with code from Lisa Miller
* @version 1.1
* @since 2017-10-14
* Updated 2017-11-24 for generalized template
*/
public class Arcanine extends Pokemon implements FireType, NoneType {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 227;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 50;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 180;
   /** The species Pokedex number. */
   static final int POKEDEX_NUM = 59;
   /** The species default height in meters. */
   static final double SPECIES_HT = 1.9;
   /** The species default weight in kilograms. */
   static final double SPECIES_WT = 155.0;
   /** Species name. **/
   static final String SPECIES_NAME = "Arcanine";

   /** A boolean for determining if fast attack is type1 or type2. */
   protected boolean fastType1 = true;
   /** A boolean for determining if special attack is type1 or type2. */
   protected boolean specType1 = true;

   /** Constructor with no name.
   * uses Pokémon superclass constructor.
   * attacks must be set after construction of Pokémon object
   * because of dependence on type interface.
    */
   public Arcanine() {
      this(SPECIES_NAME);
   }
   /** Constructor with name.
   * @param name Pokémon's desired name */
   public Arcanine(String name) {
      this(SPECIES_NAME, name, POKEDEX_NUM, SPECIES_HT, SPECIES_WT, 
            BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   /** 
   * Constructor with species and name for subclasses.
   * This allows subclass specific name, number, height, weight, and basePowers 
   * to pass through to Pokémon superclass constructor
   *@param species The Pokémon's species.
   *@param name The optional user-given name.
   *@param num The Pokédex number for this species.
   *@param ht The height of this Pokémon.
   *@param wt The weight of this Pokémon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for species. 
   */
   protected Arcanine(String species, String name, int num, double ht, 
                     double wt, int baseAttackPwr, int baseDefensePwr, 
                     int baseStaminaPwr) {
      super(species, name, num, FIRE_COLOR, ht, wt, FIRE_TYPE, 
      NONE_TYPE, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
   * Fast attack chooser.
   * Randomly picks an attack from type attack arrays
   */
   protected void chooseFastAttack() {
      chooseFastAttack(FIRE_FAST_ATTACKS, FIRE_FAST_ATK_POWER,
                       NONE_FAST_ATTACKS, NONE_FAST_ATK_POWER);
   }
   /** Fast attack chooser.
   * Randomly picks an attack from given type attack arrays.
   * @param type1Attacks String array of attack names for type 1
   * @param type1AtkPwr int array corresponding to type1Attacks
   * @param type2Attacks String array of attack names for type 2
   * @param type2AtkPwr int array corresponding to type2Attacks */
   protected void chooseFastAttack(
       String[] type1Attacks, 
       int[] type1AtkPwr,
       String[] type2Attacks, 
       int[] type2AtkPwr) {
      Random randGen = new Random();
      fastType1 = randGen.nextBoolean();
      
      if (fastType1 || type2Attacks.length == 0) {
         int index = randGen.nextInt(type1Attacks.length);
         fastAttack = type1Attacks[index];
         fastAttackPower = type1AtkPwr[index];
      } else { // is type 2
         int index = randGen.nextInt(type2Attacks.length);
         fastAttack = type2Attacks[index]; 
         fastAttackPower = type2AtkPwr[index];
      }
   }
   
   /**
   * Special attack chooser.
   * Randomly picks an attack from type attack arrays
   */
   protected void chooseSpecialAttack() {
      chooseSpecialAttack(FIRE_SPECIAL_ATTACKS, FIRE_SPECIAL_ATK_POWER,
                          NONE_SPECIAL_ATTACKS, NONE_SPECIAL_ATK_POWER);
   }
   /** Special attack chooser.
   * Randomly picks an attack from given type attack arrays.
   * @param type1Attacks String array of attack names for type 1
   * @param type1AtkPwr int array corresponding to type1Attacks
   * @param type2Attacks String array of attack names for type 2
   * @param type2AtkPwr int array corresponding to type2Attacks */

   protected void chooseSpecialAttack(
       String[] type1Attacks, 
       int[] type1AtkPwr,
       String[] type2Attacks, 
       int[] type2AtkPwr) {
      Random randGen = new Random();
      specType1 = randGen.nextBoolean();
      
      if (specType1 || type2Attacks.length == 0) {
         int index = randGen.nextInt(type1Attacks.length);
         specialAttack = type1Attacks[index];
         specialAttackPower = type1AtkPwr[index];
      } else { // is type 2
         int index = randGen.nextInt(type2Attacks.length);
         specialAttack = type2Attacks[index]; 
         specialAttackPower = type2AtkPwr[index];
      }
   }
   
   /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokémon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokémon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performFastAttack(Pokemon victim) {
      if (fastType1 || this.type2.equals("")) {
         return performAttack(false, 
                              FIRE_NVE, 
                              FIRE_SE, 
                              FIRE_NE, 
                              victim);
      }
      return performAttack(false, 
                           NONE_NVE, 
                           NONE_SE, 
                           NONE_NE, 
                           victim);
   }
   
  /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokémon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokémon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performSpecialAttack(Pokemon victim) {
      if (specType1 || this.type2.equals("")) {
         return performAttack(true, 
                              FIRE_NVE, 
                              FIRE_SE, 
                              FIRE_NE, 
                              victim);
      }
      return performAttack(true, 
                           NONE_NVE, 
                           NONE_SE, 
                           NONE_NE, 
                           victim);
   }
   
}