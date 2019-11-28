import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class kadai extends JFrame{
  public kadai(){
    setSize(1000,1000);
    setTitle("Java Programing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    MyJPanel myJPanel= new MyJPanel();
    Container c = getContentPane();
    c.add(myJPanel);
    setVisible(true);
  }
  public static void main(String[] args){
    new kadai();
  }
  public class MyJPanel extends JPanel implements MouseListener, MouseMotionListener{
    JSlider slider_R, slider_G, slider_B, slider_thick;
    JLabel red, green, blue, thick;
    JToggleButton button;
    int x=0,y=0;
    public MyJPanel(){
      addMouseMotionListener(this);
      addMouseListener(this);
      setBackground(Color.white);
      slider_R = new JSlider(0, 255, 0);
      slider_G = new JSlider(0, 255, 0);
      slider_B = new JSlider(0, 255, 0);
      slider_thick = new JSlider(0, 255, 20);
      red = new JLabel("red");
      green = new JLabel("green");
      blue = new JLabel("blue");
      thick = new JLabel("thickness");
      button = new JToggleButton("eraser");
      button.setPreferredSize(new Dimension(100, 50));
      add(red);
      add(slider_R);
      add(green);
      add(slider_G);
      add(blue);
      add(slider_B);
      add(thick);
      add(slider_thick);
      add(button);
    }
    public void paintComponent(Graphics g){
      if (button.isSelected()) {
        g.setColor(new Color(255, 255,255));
      } else {
        g.setColor(
          new Color(
            slider_R.getValue(),
            slider_G.getValue(),
            slider_B.getValue()
          )
        );
      }
      g.fillOval(x,y,slider_thick.getValue(),slider_thick.getValue());
    }
      public void mouseClicked(MouseEvent me){}
      public void mousePressed(MouseEvent me){}
      public void mouseEntered(MouseEvent me){}
      public void mouseExited(MouseEvent me){}
      public void mouseReleased(MouseEvent me){}
      public void mouseMoved(MouseEvent me){}
      public void mouseDragged(MouseEvent me){
        x = me.getX();
        y = me.getY();
        repaint();
      }
    }
  }
