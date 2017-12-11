/**
 * Main entry point to GUI.
 * @author Evan Paresa
 * @since 09-12-2017 (December 9, 2017)
 */
public class PokeGUIDriver {
   /** Main entry point to GUI.
    * @param args Command-line arguments. Unused.
    */
   public static void main(String[] args) {
      PokeGUIModel model = new PokeGUIModel();
      PokeGUIView view = new PokeGUIView();
      PokeGUIController controller = new PokeGUIController(model, view);
   }
}