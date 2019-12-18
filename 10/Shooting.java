import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;

public class kadai extends JFrame{
    public kadai(){
        setSize(800,500);
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
    public class MyJPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener
    {
        int my_x;
        int player_width,player_height;
        int enemy_width,enemy_height;
        int n;
        int enemy_x[];
        int enemy_y[];
        int enemy_move[];
        int enemy_alive[];
        int my_missile_x, my_missile_y;
        int missile_flag;
        public static final int MY_Y = 400;
        Image image,image2;
        Timer timer;

        public MyJPanel(){
            my_x = 250;
            missile_flag = 0;
            int i;
            n =14;
            enemy_x = new int[n];
            enemy_y = new int[n];
            enemy_move = new int[n];
            enemy_alive = new int[n];
            ImageIcon icon = new ImageIcon("player.jpg");
            image = icon.getImage();
            player_width = image.getWidth(this);
            player_height= image.getHeight(this);
            setBackground(Color.black);
            addMouseListener(this);
            addMouseMotionListener(this);
            timer = new Timer(50, this);
            timer.start();
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image,my_x,400,this);
        }
        public void actionPerformed(ActionEvent e){
            repaint();
        }
        public void mouseClicked(MouseEvent me)
        { }
        public void mousePressed(MouseEvenrt me)
        { }
        public void mouseReleased(MouseEvent me)
        { }
        public void mouseExited(MouseEvent me)
        { }
        public void mouseEntered(MouseEvent me)
        { }
        public void mouseMoved(MouseEvent me){
            my_x = me.getX();
        }
        public void mouseDragged(MouseEvent me)
        { }
    }
}
