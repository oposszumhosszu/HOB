package HOB;

import java.awt.*;                                                                           //kepek hasznalatahoz
import java.awt.event.*;                                                                     //ActionListener hasznalatahoz

import javax.swing.*;

public class Board extends JPanel implements ActionListener {
        Player p;                                                                            //jatekos osztaly peldanya
        Image background, menuBg;                                                            //hatterkepek
        Timer time;                                                                          //A timer
        private Menu Menu;
        private Frame Frame;

        public static enum STATE {MENU,GAME};

        public static STATE State = STATE.MENU;

        public Board() {
                this.addMouseListener(new MouseInput());
                p = new Player();                                                           //player class futtatasanak megkezdese
                Menu = new Menu();

                addKeyListener(new AL());                                                            //kulcsokra valo figyeles
                setFocusable(true);                                                                  //mozgas engedelyezese        
                ImageIcon i = new ImageIcon("D:/hosszuoposszumbosszuja/!Oposszum2/!HOB/menu.png");   //menu kep
                menuBg = i.getImage();
                i = new ImageIcon("D:/hosszuoposszumbosszuja/!Oposszum2/!HOB/bg.png");  			 //hatterkep
                background = i.getImage();                                                           //hatterhez hozzaadja a kepet
                time = new Timer(20,this);                                                           //az idozito beallitasa, hogy ezt az osztalyt 20 ezredmasodpercenkent, kb 50fps 
                time.start();                                                                        //timer inditasa
        }

        public void actionPerformed(ActionEvent e) {
                p.move();                                                                            //move method hivasa a player classbol
                repaint();                                                                           //repaint
        }

        public void paintComponent(Graphics g) {                                                 //grafikus metodus
                if(State==STATE.GAME) {
                        super.paintComponent(g);
                                Graphics2D g2d = (Graphics2D) g;                                             //graafikus vetites 2dben
                                
                                g2d.drawImage(background, -p.nx, 0, null);                                   //hatterkep rajzolasa
                                g2d.drawImage(background, -p.nx2, 0, null);                                  //hatterkep rajzolasa

                                if(-p.nx<-575)                                                              //ha egyenesen megy
                                        p.nx=-575;                                                              //elkezdi elore pakolni
                                else if(-p.nx>575)                                                          //ha hatra megy
                                        p.nx=575;                                                               //elkezdi hatra pakolni

                                if(-p.nx2<-575)                                                             //ha egyenesen megy
                                        p.nx2=-575;                                                             //elkezdi elore pakolni
                                else if(-p.nx2>575)                                                         //ha hatra megy
                                        p.nx2=575;                                                              //elkezdi hatra pakolni

                                g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);                      //a playert a jelenlegi poziciojaba rajzolja(koordinalja a player class bol vett erteket)
                } else {
                        g.drawImage(menuBg, 0, 0, null);
                        Menu.render(g);
                }
        }

        private class AL extends KeyAdapter {
                public void keyPressed(KeyEvent e) {                                                 //billentyu lenyomas
                        p.keyPressed(e);                                                                 //amilyen billenyu le lett nyomva elkuldi a player class ban levo keyPressed method-ba
                }
                public void keyReleased(KeyEvent e) {                                                //billentyu elengedes
                        p.keyReleased(e);                                                                //amilyen billenyu el lett eresztve elkuldi a player class ban levo keyPressed method-ba
                }
        }
}