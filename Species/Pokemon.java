package Species;
import java.util.Random;
import Species.Types.*;
/**
* Abstract parent class for Pokémon species.
* 
* @author Evan Paresa, based on code from Lisa Miller
* @since 2017-10-11
*/
public abstract class Pokemon
   // implementing A6 - Comparable
    implements java.lang.Comparable<Pokemon> {

   /** Instance variables. **/

   /** Species name. */
   protected String species;
   /** Given name. */
   protected String name;
   /** Pokédex number. */
   protected int number;
   /** Pokémon body color. **/
   protected String color;
   /** Species height. */
   protected double height;
   /** Species weight. */
   protected double weight;
   /** Pokémon's primary type. */
   protected String type1;
   /** Pokémon's secondary type. Optional. */
   protected String type2;
   
   /** Attack stat. */
   private int attackPower;
   /** Defense stat. */
   private int defensePower;
   /** Stamina stat. */
   private int staminaPower;
   /** Species base Attack. */
   private int baseAtk;
   /** Species base Defense. */
   private int baseDef;
   /** Species base Stamina. */
   private int baseSta;
   /** IV in Attack. */
   private int ivAtk;
   /** IV in Defense. */
   private int ivDef;
   /** IV in Stamina. */
   private int ivSta;
   
   /** Pokémon's level. */
   protected int level;
   /** Pokémon's hit points. */
   protected int hp;
   /** Pokémon's combat power. */
   protected int cp;
   /** Fast attack move. */
   protected String fastAttack;
   /** Fast attack move power. */
   protected int fastAttackPower;
   /** Charge attack (special attack) move. */
   protected String specialAttack;
   /** Charge attack move power. */
   protected int specialAttackPower;

   /** CP multiplier table. Converts level to CP. */
   private final double[] cpMultiplier = {
      0.094,  0.16639787,  0.21573247,  0.25572005,  0.29024988,
      0.3210876,   0.34921268,  0.37523559,  0.39956728,  0.42250001,
      0.44310755,  0.46279839,  0.48168495,  0.49985844,  0.51739395,
      0.53435433,  0.55079269,  0.56675452,  0.58227891,  0.59740001,
      0.61215729,  0.62656713,  0.64065295,  0.65443563,  0.667934,
      0.68116492,  0.69414365,  0.70688421,  0.71939909,  0.7317,
      0.73776948,  0.74378943,  0.74976104,  0.75568551,  0.76156384,
      0.76739717,  0.7731865,   0.77893275,  0.78463697,  0.79030001};
   
   /** Pokémon constructor.
   * @param species Species name
   * @param name Given name
   * @param number Pokédex number
   * @param color Body color
   * @param height Species height, in feet
   * @param weight Species weight, in lbs
   * @param type1 Species primary type
   * @param type2 Species secondary type
   * @param baseAttackPower Species base ATK
   * @param baseDefensePower Species base DEF
   * @param baseStaminaPower Species base STA
   */
   public Pokemon(String species, String name, int number, 
       String color, double height, double weight,
       String type1, String type2, int baseAttackPower, 
       int baseDefensePower, int baseStaminaPower) {
      
      //for initial level
      Random randGen = new Random();
      //for calc of CP
      double cpMult;

      //set simple instance variables
      this.species = species;
      if (name.equals("") || name.equals(null)) {
         throw new PokemonException("Name must not be empty");
      }
      else {
         this.name = name;
      }
      this.number = number;
      this.color = color;
      this.height = height;
      this.weight = weight;
      this.type1 = type1;
      this.type2 = type2;
      this.baseAtk = baseAttackPower;
      this.baseDef = baseDefensePower;
      this.baseSta = baseStaminaPower;
      
      //generate initial level
      this.level = randGen.nextInt(30);
  
      //calculate multiplier for stats
      cpMult = cpMultiplier[(int) level];
      
      //calculate hidden stats attack. defense, stamina power
      ivAtk = randGen.nextInt(16);
      ivDef = randGen.nextInt(16);
      ivSta = randGen.nextInt(16);
      attackPower  = (int) ((baseAtk + ivAtk) * cpMult);
      defensePower = (int) ((baseDef + ivDef) * cpMult);
      staminaPower = (int) ((baseSta + ivSta) * cpMult);

      //set Pokémon's HP and CP from attack, defense and stamina
      hp = calculateHP(staminaPower);
      cp = calculateCP(cpMult, attackPower, defensePower, staminaPower);
      
      //attacks null here, have to be set separately in subclasses due to type
      fastAttack = null;
      fastAttackPower = 0;
      specialAttack = null;
      specialAttackPower = 0;
   }
   
   /** Calculates HP. Conveniently, same as Stamina Power. 
   * @param sta Stamina Power.
   * @return HP value.
   */
   private int calculateHP(int sta) {
      return sta;
   }
   /** Calculates CP. Nowhere near as convenient as HP.
   * uses formula from here: 
   * https://pokemongo.gamepress.gg/pokemon-stats-advanced
   * @param cpMult the current CP multiplier
   * @param atk Attack power
   * @param def Defense power
   * @param sta Stamina power
   * @return Current CP.
   */
   private int calculateCP(double cpMult, int atk, int def, int sta) {
      int newCP = (int) Math.floor((atk * Math.pow(def, 0.5) 
          * Math.pow(sta, 0.5) * Math.pow(cpMult, 2)) / 10);
      if (newCP < 10) { newCP = 10; }
      return newCP;
   }
   
   /*** public class methods ***/
   /**
   * Increases Pokémon's level by 1.
   * Adjusts HP and CP accordingly.
   */
   public void levelUp() {
      double cpMult = cpMultiplier[((level < 40) ? ++level : 40) - 1];
      attackPower  = (int) ((baseAtk + ivAtk) * cpMult);
      defensePower = (int) ((baseDef + ivDef) * cpMult);
      staminaPower = (int) ((baseSta + ivSta) * cpMult);
      hp = calculateHP(staminaPower);
      cp = calculateCP(cpMult, attackPower, defensePower, staminaPower);
   }
   
   /**
   * Returns Pokémon information as a formatted String.
   * @return String representing Pokémon object data
   */
   public String toString() {
      String s = "";
      
      s = "Species: " + species + "\n";
      if (!name.equals(species)) {
         s = s + "Name: " + name + "\n";
      }
      s = s + "Number: " + String.format("%03d", number) + "\n";
      s = s + "Height: " + height + "\n";
      s = s + "Weight: " + weight + "\n";
      s = s + "Type: " + type1;
      if (this.type2.length() > 0) {
         s = s + " | " + this.type2;
      }
      s = s + "\n";
      s = s + "HP: " + hp + "\n";
      s = s + "CP: " + cp + "\n";
      
      return s;
   }
   /* A6 - Comparable Pokémon */
   /** Implementing equals() method.
   * Required for compareTo() method.
   * @param other Pokémon to compare to.
   * @return whether the main values match with each other.
   */
   public boolean equals(Pokemon other) {
      return this.number == other.number
            && this.name.equals(other.name)
            && this.hp == other.hp
            && this.cp == other.cp
            && this.fastAttack == other.fastAttack
            && this.specialAttack == other.specialAttack;
   }

   /** Implementing compareTo() method. 
   * @param other Pokémon to compare to
   * @return priority queue number
   */
   public int compareTo(Pokemon other) {
      if (this.equals(other)) {
         return 0;
      }
      if (this.number < other.number) {
         return -1;
      }
      else if (this.number > other.number) {
         return 1;
      }
      else {
         if (this.name.compareTo(other.name) < 0) {
            return -1;
         }
         else if (this.name.compareTo(other.name) > 0) {
            return 1;
         }
         else {
            if (this.hp < other.hp) {
               return -1;
            }
            else if (this.hp > other.hp) {
               return 1;
            }
            else {
               if (this.cp < other.cp) {
                  return -1;
               }
               else if (this.cp > other.cp) {
                  return 1;
               }
               else {
                  if (this.fastAttack.compareTo(other.fastAttack) < 0) {
                     return -1;
                  }
                  else if (this.fastAttack.compareTo(other.fastAttack) > 0) {
                     return 1;
                  }
                  else {
                     if (this.specialAttack.compareTo(
                               other.specialAttack) < 0) {
                        return -1;
                     }
                     else if (this.specialAttack.compareTo(
                                    other.specialAttack) > 0) {
                        return 1;
                     }
                     else { 
                        return 0;
                     }
                  }
               }
            }
         }
      }
   }
   
   /**
   * Game-play attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokémon's type and attack type.
   * Calls beAttacked method on attacked victim.
   * 
   * Based on information from:
   * https://pokemongo.gamepress.gg/damage-mechanics
   *
   * @param isSpecialAtk determine if attack is fast or special
   * @param typeNVE the attacking Pokémon's TYPE_NVE array
   * @param typeSE the attacking Pokémon's TYPE_SE array
   * @param typeNE the attacking Pokémon's TYPE_NE array
   * @param victim the Pokémon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performAttack(boolean isSpecialAtk, String[] typeNVE, 
       String[] typeSE, String[] typeNE, Pokemon victim) {
      
      // if either Pokémon's HP is 0, an attack should not happen
      if (hp == 0) { 
         return "The attack failed! This Pokémon's HP is 0; it cannot attack!";
      }
      if (victim.hp == 0) {
         return "The attack failed! The defending Pokémon is already fainted!";
      }
      
      // Niantic's modifiers are different from the real game's modifiers:
      double modifierNVE = 0.714; // should be 0.5
      double modifierSE = 1.4; // should be 2.0
      double modifierNE = 0.51; // should be 0
      double modifierSTAB = 1.2; // should be 1.5

      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      //double damageDivisor = 250.0;
      String moveAttack = (isSpecialAtk) ? specialAttack : fastAttack;
      int moveAtkPower = (isSpecialAtk) ? specialAttackPower : fastAttackPower;
      
      String s1 = "";
      String s2 = "";
      String vType1 = victim.getType1();
      String vType2 = victim.getType2();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;
      s1 = name + " (" + species + ") performed " + moveAttack
          + " against " + victim.getName() + " ("
          + victim.getSpecies() + ")";
      //check effectiveness of attack
      boolean nve = false;
      boolean se = false;
      boolean ne = false;
      for (String weak : typeSE) { // checking super effective
         // doesn't check for 4x SE damage (double type weakness)
         if (weak.equals(vType1) || weak.equals(vType2)) {
            se = true;
         }         
      } 
      for (String strong : typeNVE) { // checking not very effective
         // doesn't check for 1/4x NVE damage (double type resist)
         if (strong.equals(vType1) || strong.equals(vType2)) {
            nve = true;
         }
      }
      for (String nosell : typeNE) { // checking immune
         if (nosell.equals(vType1) || nosell.equals(vType2)) {
            ne = true;
         }
      }
      if (nve && se && !ne) { // if atk is both nve and se:
         // nve and se cancel out
         nve = false;
         se = false;
      }
      if (nve && !se && !ne) { // if attack is nve:
         s2 = "\n It was not very effective.";
         modifier *= modifierNVE; 
      }
      if (se && !nve && !ne) { // if attack is se:
         s2 = "\n It was super effective!";
         modifier *= modifierSE; 
      }
      if (ne) { // if ne is triggered at all, ne modifier is applied
         s2 = "\n It was not effective...";
         modifier *= modifierNE;
      }
      //check for same types for bonus
      /*if ((type1.equals(vType1) || type1.equals(vType2))
             && (type2.equals(vType1) || type2.equals(vType2))) {
         modifier *= modifierSTAB;
      }*/

      // STAB = same type attack bonus: if the attacking Pokemon's type
      // is the same as its move's type, you gain a STAB bonus.
      // Since this code only allows for moves from your Pokemon's type anyway,
      // we just implement the modifier:
      modifier *= modifierSTAB;

      //bulbapedia damage formula:
      //damage = (((2 * level) + 10) / damageDivisor) 
      //   * attackPower * (moveAtkPower + 2) * modifier;
      
      //gamepress damage formula:
      damage = Math.floor(0.5 * moveAtkPower
                          * (attackPower / victim.defensePower)
                          * modifier) + 1;
            
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s1 + s2;
   }

   
   /**
   * Reduces Pokemon's HP by damage/defensePower.
   * Doesn't allow HP to go less than 0
   * Implementation of "fainting" not done here
   * @param damage Hit points to take off HP
   */
   protected void beAttacked(int damage) {
      //part of bulbapedia damage formula
      //damage /= defensePower;
      if (hp > damage) {
         hp -= damage;
      } else {
         hp = 0; //"Pokemon fainted"
         //System.out.println(name + " fainted!");
      }
   }
     
      /*** abstract methods required for sub-classes ***/
   /**
   * Retrieves victim Pokemon's type.
   * Determines if the attack is super effective or not effective
   * Performs beAttacked on victim
   * @param victim The Pokemon object being attacked.
   * @return String "<species> performed <fastAttack> 
   * + <it <was super, wasn't very, was not> effective>" depending on type
   */
   public abstract String performFastAttack(Pokemon victim);
   
   /**
   * Retrieves victim Pokemon's type.
   * Determines if the attack is super effective or not effective
   * Calculates amount of HP to knock off victim
   * Performs beAttacked on victim
   * @param victim The Pokemon object being attacked.
   * @return String "<species> performed <specialAttack> 
   * + <it <was super, wasn't very, was not> effective>" depending on type
   */
   public abstract String performSpecialAttack(Pokemon victim);
   
      /*** protected abstract methods, for use only within subclasses ***/
   /*
   * Use the type interface lists to set Pokemon
   * Fast and Special Attacks
   */
   /** Set fast attack. */
   protected abstract void chooseFastAttack();
   /** Set special attack. */
   protected abstract void chooseSpecialAttack();

   
   /** Get Methods **/
   
   /** returns Pokemon species.
    * @return String
   */
   public String getSpecies() {
      return species;
   }
   
   /** returns Pokemon user-defined name.
    * @return String
   */
   public String getName() {
      return name;
   }
   /** returns Pokemon color.
    * @return String
   */
   public String getColor() {
      return color;
   }
   /** returns Pokemon height.
   * @return double
   */   
   public double getHeight() {
      return height;
   }
   /** returns weight.
    * @return double
   */   
   public double getWeight() {
      return weight;
   }
   /** returns Pokemon number from Pokedex.
   * @return int
   */   
   public int getNumber() {
      return number;
   }
   /** returns Pokemon primary type.
    * @return String
   */   
   public String getType1() {
      return type1;
   }
   /** returns Pokemon secondary type.
    * @return String
    * empty if no secondary type
   */   
   public String getType2() {
      return type2;
   }
   /** returns Pokemon Hit Power.
   * @return int
   */   
   public int getHP() {
      return hp;
   }
  /** returns Pokemon Combat Power.
   * @return int
   */   
   public int getCP() {
      return cp;        
   }
   /** returns fast/simple attack.
    * @return String
   */   
   public String getFastAttack() {
      return fastAttack;
   }   
   /** returns special attack.
    * @return String
   */   
   public String getSpecialAttack() {
      return specialAttack;
   }
   /** Set methods */
   /** sets Pokemon's user-defined name.
   * @param newName new name
   */
   public void setName(String newName) {
      if (newName.equals("") || newName.equals(null)) {
         throw new PokemonException("Name must not be empty");
      }
      name = newName;
   }
   /** sets Pokemon's primary type.
   * @param newType1 primary type
   */
   public void setType1(String newType1) {
      type1 = newType1;
   } 
   /** sets Pokemon's secondary type.
   * @param newType2 secondary type
   */
   public void setType2(String newType2) {
      type2 = newType2;
   }
}
