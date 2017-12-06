import java.awt.*;
import javax.swing.*;

public class PokePanel extends JPanel {
   private JLabel label;
   private JButton buttonOK;
   
   public PokePanel() {
      label = new JLabel("Hello, World!");
      
      add(label);
      setPreferredSize(new Dimension(600, 80));
   }
}