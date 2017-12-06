import javax.swing.JFrame;

public class PokeGUI {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Pokemon GO!");
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setSize(600,800);
      
      frame.getContentPane().add(new PokePanel());
      frame.pack();
      
      frame.setVisible(true);
   }
}