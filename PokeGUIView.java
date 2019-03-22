import java.awt.*;
import javax.swing.*;
import Species.Pokemon;
public class PokeGUIView {
   private JFrame frame;

   private JTextArea pokemonHunt;
   private JTextArea pokedexResult;
   private JButton buttonHunt;
   private JButton buttonCatch;
   private JButton buttonPokedex;
   private JButton buttonBackpack;

   public PokeGUIView () {
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      
      JPanel panelTop = new JPanel();
      JPanel panelBottom = new JPanel();
            
      pokemonHunt = new JTextArea();
      pokedexResult = new JTextArea();
      JScrollPane huntTextPane = new JScrollPane(pokemonHunt);
      JScrollPane dexTextPane = new JScrollPane(pokedexResult);
      buttonHunt = new JButton("Hunt");
      buttonCatch = new JButton("Catch");
      buttonPokedex = new JButton("Pokemon");
      buttonBackpack = new JButton("Backpack");
      
      panelTop.setLayout(new GridLayout(1, 1, 10, 10));
      panelBottom.setLayout(new GridLayout(1, 1, 10, 10));
                  
      panelTop.add(huntTextPane);
      panelTop.add(buttonHunt);
      panelTop.add(buttonCatch);
      panelBottom.add(buttonPokedex);
      panelBottom.add(buttonBackpack);
      panelBottom.add(dexTextPane);

      JPanel content = new JPanel();
      content.setLayout(new GridLayout(0, 1));
      content.add(panelTop);
      content.add(panelBottom);

      frame.setContentPane(content);
      frame.setTitle("Pokemon GO!");
      frame.pack();
      frame.setSize(800, 600);
      frame.setVisible(true);
   }
   public JButton getHuntButton() {
      return buttonHunt;
   }
   public JButton getCatchButton() {
      return buttonCatch;
   }
   public JButton getPokedexButton() {
      return buttonPokedex;
   }
   public JButton getBackpackButton() {
      return buttonBackpack;
   }
   public String getHuntTextbox() {
      return pokemonHunt.getText();
   }
   public String getPokedexTextbox() {
      return pokedexResult.getText();
   }
   public void setHuntTextbox(String text) {
      pokemonHunt.setText(text);
   }
   public void setPokedexTextbox(String text) {
      pokedexResult.setText(text);
   }
   public String nicknameDialog(Pokemon p) {
      return (String) JOptionPane.showInputDialog(
                         frame,
                         "You caught a " + p.getSpecies()
                         + "!\n\nWould you like to name it?"
                         + " (Leave blank for default name)",
                         "You caught it!",
                         JOptionPane.PLAIN_MESSAGE);
   }
   public boolean backpackDialog() {
      Object[] options = { "Recent", "Numbers" };
      int result = JOptionPane.showOptionDialog(
                         frame,
                         "Would you like to sort by"
                         + " recent, or by Pokedex number?",
                         "Backpack sorting method",
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.PLAIN_MESSAGE,
                         null,
                         options,
                         options[0]);
      return result == 0;
   }
}