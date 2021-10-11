package HOB;
import javax.swing.JFrame;

public class Frame {                                                                         //fo osztaly
        public static void main(String[] args) {
                JFrame frame = new JFrame("Hosszu Oposszum Bosszuja");                     //JFrame keszitese frame neven

                frame.getContentPane().add(new Board());                       //menjen a board class-ba
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                //X kilep
                frame.setSize(700,700);                                                              //frame meretenek beallitasa a hatterhez
                frame.setResizable(false);                                                           //a felhasznalo igy nem valtoztathatja meg
                frame.setLocation(150, 100);                                                           //pozicio beallitas
                frame.setVisible(true);                                                              //lathato legyen

                int frameWidth  = frame.getContentPane().getWidth();
                int frameHeight  = frame.getContentPane().getHeight();
        }
}