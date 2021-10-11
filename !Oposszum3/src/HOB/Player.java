package HOB;

import java.awt.Image;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
    int x, dx, y, nx, nx2, distanceTraveled;
    Image player;                                                                                //a player valtozo
    ImageIcon playerFacingLeft = new     ImageIcon("D:/hosszuoposszumbosszuja/!Oposszum2/!HOB/PL_gifmaker.gif");		//balra nezve a kepe
    ImageIcon playerFacingRight = new     ImageIcon("D:/hosszuoposszumbosszuja/!Oposszum2/!HOB/PR_gifmaker.gif");		//jobbra neyve a kepe

        public Player() {
            player = playerFacingRight.getImage();					//kep hozzaadasa a playerhez
            x = 75;													//player eredeti x pozicioja
            y = 485;												//player eredeti y pozicioja
            nx = -0;												//ismetlodo hatter 1
            nx2 = -575;												//ismetlodo hatter 2
            distanceTraveled = 30;
        }

        public void move() {
            if(x>0 && x<300) {													//ha a jatekos a mozgo teruleten belul van
                x = x+dx;
                nx = nx+dx;
                nx2 = nx2+dx;
            }
            if(x<=0) {															//ha a leg bal oldalara er a jatekos a kepnek(0px)
                x=1;																//, tovabbi mozgas lehetove tetele
                nx = nx+(dx*(int)0.5);
                nx2 = nx2+(dx*(int)0.5);
            }
            if(x>=300) {														//ha a jatekos a kep kozepet eri el(300px)
                x=299;																//, tovabbi mozgas lehetove tetele
                nx = nx+(dx*(int)0.5);
                nx2 = nx2+(dx*(int)0.5);
            }
            if(dx>0)distanceTraveled++;else if(dx<0)distanceTraveled--;
            if(distanceTraveled>104)x=299;
            if(x==1 && dx<0)
                distanceTraveled++;
            if(distanceTraveled<104){
                nx=0;
                nx2=-575;
            }
        }

        public int   getX()     { return x;      }
        public int   getY()     { return y;      }
        public Image getImage() { return player; }
        
        public static int height = 400, floorHeight = height - 64;
        private float jumpStrength, weight = 1;
        
        public void keyPressed(KeyEvent e) {                                                     //board class-bol hivva, barmilyen billentyu lenyomasa eseten
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_LEFT) {														//ha balra billentyu
                player = playerFacingLeft.getImage();											//balra fordul a karakter
                if(distanceTraveled<104)dx=-3;else dx=-2;
            }

            if(key == KeyEvent.VK_RIGHT) {														//ha jobbra billentyu
                player = playerFacingRight.getImage();											//jobbra fordul a karakter
                if(distanceTraveled<104)dx=3;else dx=2;
            }
            //
            if(key == KeyEvent.VK_UP) {															//ha felfele billentyu
                	jumpStrength = 24;
                    y = floorHeight; 
                    y -= jumpStrength; //javitas (smooth jumb legyen!!)
                    jumpStrength -= weight;
                    if (y >= floorHeight) y = floorHeight;
                }
            //
            }

        public void keyReleased(KeyEvent e) {													//board class-bol hivas, barmilyen billentyu elengedes
             int key = e.getKeyCode();

            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)								//ha jobb bal elengedve
                dx = 0;																			//mozgas megallitas
            //felfele elengedve
        }
}