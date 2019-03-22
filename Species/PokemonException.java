package Species;
/** An exception for use with the Pokemon class.
  *
  * @author Evan Paresa
  */
public class PokemonException extends RuntimeException {
   /** Constructor for the exception.
     * @param message Describes the cause of the error.
     */
   public PokemonException(String message) {
      super(message);
   }
}
