import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import Species.Pokemon;
public class PokeGUIController {
   private PokeGUIModel model;
   private PokeGUIView view;

   public PokeGUIController(PokeGUIModel m, PokeGUIView v) {
      model = m;
      view = v;
      
      huntEvent();

      //view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      view.getCatchButton().addActionListener(captureEvent());
      view.getHuntButton().addActionListener(huntEvent());
      view.getPokedexButton().addActionListener(pokedexEvent());
      view.getBackpackButton().addActionListener(backpackEvent());
   }
   public ActionListener captureEvent() {
      return new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (model.getCurrentPokemon() == null) {
               return;
            }
            Random rand = new Random();
            if (rand.nextBoolean()) {
               String name = view.nicknameDialog(model.getCurrentPokemon());
               try {
                  model.getCurrentPokemon().setName(name);
               } catch (Exception ex) {
                  model.getCurrentPokemon().setName(
                     model.getCurrentPokemon().getSpecies()
                     );
               }
               model.capture(model.getCurrentPokemon());
               view.setHuntTextbox(view.getHuntTextbox() + "\n\n"
                                   + model.getCurrentPokemon().getSpecies() 
                                   + " captured!");
            }
            else {
               view.setHuntTextbox(view.getHuntTextbox() + "\n\n"
                                   + model.getCurrentPokemon().getSpecies()
                                   + " escaped...");
            }
         }
      };
   }
   public ActionListener huntEvent() {
      return new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            int newIndex = rand.nextInt(model.getPokeListCount());
            Pokemon p = model.getPokemon(newIndex);
            model.setCurrentPokemon(p);
            view.setHuntTextbox("A wild " + p.getSpecies() 
                                + " appeared!\n\n" + p.toString());
         }
      };
   }
   public ActionListener pokedexEvent() {
      return new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            view.setPokedexTextbox(model.printPokedex());
         }
      };
   }
   public ActionListener backpackEvent() {
      return new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (model.getCapturedCount() < 1) { 
               return;
            }
            Pokemon[] recentPokemon = model.getCaptures(
                                         view.backpackDialog()
                                      );
            String result = "";
            for (Pokemon p : recentPokemon) {
               result += (p == null ? "" : p.toString() + "\n");
            }
            view.setPokedexTextbox(result);
         }
      };
   }
}