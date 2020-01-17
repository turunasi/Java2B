import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.util.Arrays;
public class kadai extends JFrame{
    public kadai(){
        setSize(500,800);
        setTitle("Game Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyJPanel myJPanel= new MyJPanel();
        Container c = getContentPane();
        c.add(myJPanel);
        setVisible(true);
    }
    public static void main(String[] args){
        new kadai();
    }
    public class MyJPanel extends JPanel
    implements ActionListener, KeyListener
    {
        int my_y;
        int player_width,player_height;
        int enemy_width,enemy_height;
        int bom_flag;
        int bom_num;
        int my_life;
        int n;
        public static final int missile_number = 5;
        public static final int move_y = 20;
        int enemy_x[];
        int enemy_y[];
        int enemy_move[];
        int enemy_alive[];
        int num_of_alive;
        int my_missile_x[];
        int my_missile_y[];
        int enemy_missile_x[];
        int enemy_missile_y[];
        int enemy_missile_move[];
        int enemy_missile_flag[];
        int missile_flags[];
        public static final int MY_X=400;
        Image image,image2;
        Timer timer;
        public MyJPanel(){
            my_y = 250;
            missile_flags = new int[missile_number];
            Arrays.fill(missile_flags, 0);
            int i;
            n = 14;
            num_of_alive = 14;
            my_life = 3;
            bom_num = 2;
            enemy_x = new int[n];
            enemy_y = new int[n];
            enemy_move = new int[n];
            enemy_alive= new int[n];
            enemy_missile_x = new int[n];
            enemy_missile_y = new int[n];
            enemy_missile_move = new int[n];
            enemy_missile_flag = new int[n];
            my_missile_x = new int[missile_number];
            my_missile_y = new int[missile_number];
            for(i=0;i<7;i++){
                enemy_y[i] = 70*(i+1)-50;
                enemy_x[i] = 50;
            }
            for(i=7;i<n;i++){
                enemy_y[i] = 70*(i-5)- 50;
                enemy_x[i] = 100;
            }
            for(i=0;i<n;i++){
                enemy_alive[i] = 1;
                enemy_move[i] = -10;
            }
            for(i=0;i<n;i++ ){
                enemy_missile_y[i] = enemy_x[i]+enemy_height/2;
                enemy_missile_x[i] = enemy_y[i]+enemy_width;
                enemy_missile_move[i] = 10 + (i%3);
                enemy_missile_flag[i] = 1;
            }
            ImageIcon icon = new ImageIcon("player_v.jpg");
            image = icon.getImage();
            ImageIcon icon2 = new ImageIcon("enemy_v.jpg");
            image2 = icon2.getImage();
            player_width = image.getWidth(this);
            player_height= image.getHeight(this);
            enemy_width = image2.getWidth(this);
            enemy_height= image2.getHeight(this);
            setBackground(Color.black);
            setFocusable(true);
            addKeyListener(this);
            timer = new Timer(50, this);
            timer.start();
        }
        public void paintComponent(Graphics g){
            int i;
            super.paintComponent(g);
            g.drawImage(image,400,my_y,this);
            for(i=0;i<my_life;i++){
                g.setColor(Color.red);
                g.fillRect(10+20*i,10,10,10);
            }
            for(i=0;i<bom_num;i++){
                g.setColor(Color.blue);
                g.fillRect(10+20*i,30,10,10);
            }
            for(i=0;i<n;i++){
                if(enemy_alive[i] == 1){
                    g.drawImage(image2,enemy_x[i],enemy_y[i],this);
                }
            }
            for(i=0;i<n;i++){
                if(enemy_missile_flag[i] == 1){
                    g.setColor(Color.white);
                    g.fillRect(enemy_missile_x[i],enemy_missile_y[i],2,5);
                }
            }
            for (i=0;i<missile_number;i++) {
                if(missile_flags[i] == 1){
                    g.setColor(Color.white);
                    g.fillRect(my_missile_x[i],my_missile_y[i],2,5);
                }
            }
        }
        public void actionPerformed(ActionEvent e){
            int i;
            Dimension dim=getSize();
            if (my_y < 0) my_y = dim.height - player_height;
            if (dim.width < my_y) my_y = 0 + player_height;
            for(i=0; i< n;i++){
                enemy_y[i] +=enemy_move[i];
                if( (enemy_y[i] < 0) || ( enemy_y[i]> (dim.height - enemy_height) ) ){
                    enemy_move[i] = - enemy_move[i];
                }
                if(enemy_missile_flag[i]==1){
                    enemy_missile_x[i] += enemy_missile_move[i];
                    if (enemy_missile_x[i] > 500){
                        enemy_missile_flag[i] = 0;
                    }
                }else{
                    if (enemy_alive[i] == 1) {
                        enemy_missile_y[i] = enemy_y[i]+ enemy_height/2;
                        enemy_missile_x[i] = enemy_x[i];
                        enemy_missile_flag[i] = 1;
                    }
                }
                if( ((enemy_missile_y[i]+2) >= my_y) &&
                ((my_y+player_height) > enemy_missile_y[i]) &&
                ( (enemy_missile_x[i]+5) >= MY_X ) &&
                ((MY_X + player_width) > enemy_missile_x[i]) ){
                    if (my_life == 0) {
                        System.out.println("===Game End===");
                        System.exit(0);
                    } else {
                        my_life--;
                        enemy_missile_flag[i] = 0;
                    }
                }
            }
            for (i=0;i<missile_number;i++) {
                if(missile_flags[i] == 1){
                    my_missile_x[i] -= 15;
                    my_missile_y[i] -= 15 * Math.cos(Math.toRadians(60 + i*15));
                    if(0 > my_missile_x[i]){
                        missile_flags[i] = 0;
                    }
                }
            }
            for(i=0; i < n;i++){
                if(enemy_alive[i] == 1){
                    for (int j=0;j<missile_number;j++) {
                        if( (enemy_y[i] <= my_missile_y[j]) &&
                        ( my_missile_y[j] < (enemy_y[i]+enemy_height)) &&
                        ((enemy_x[i]+enemy_width) >= my_missile_x[j]) &&
                        enemy_x[i] < (my_missile_x[j]+5) ){
                            enemy_alive[i]=0;
                            missile_flags[j] = 0;
                            num_of_alive--;
                            if (num_of_alive == 0){
                                System.out.println("===Game Clear===");
                                System.exit(0);
                            }
                        }
                    }
                }
            }
            repaint();
        }
        public void keyReleased(KeyEvent e)
        {}
        public void keyTyped(KeyEvent e)
        {}
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            int mask = e.getModifiersEx();
            switch( key ){
                case KeyEvent.VK_DOWN:
                if ((mask & InputEvent.SHIFT_DOWN_MASK) != 0){
                    my_y = my_y + move_y/2;
                } else {
                    my_y = my_y + move_y;
                }
                break;
                case KeyEvent.VK_UP:
                if ((mask & InputEvent.SHIFT_DOWN_MASK) != 0){
                    my_y = my_y - move_y/2;
                } else {
                    my_y = my_y - move_y;
                }
                break;
                case KeyEvent.VK_Z:
                for (int i=0;i<missile_number;i++) {
                    if(missile_flags[i] == 0){
                        my_missile_y[i] = my_y + player_height / 2;
                        my_missile_x[i] = MY_X;//MY_Y=400
                        missile_flags[i] = 1;
                    }
                }
                break;
                case KeyEvent.VK_X:
                for (int i=0;i<missile_number;i++) {
                    if(missile_flags[i] == 0){
                        my_missile_y[i] = my_y + player_height / 2;
                        my_missile_x[i] = MY_X;//MY_Y=400
                        missile_flags[i] = 1;
                    }
                }
                break;
            }
        }
    }
}