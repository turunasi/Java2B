import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_Mouse extends JFrame{ 
	public Sample_Mouse(){ 
		setSize(1000,500);
		setTitle("Java Programing"); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyJPanel myJPanel= new MyJPanel();
		Container c = getContentPane();
		c.add(myJPanel);
		setVisible(true);
	}

	public static void main(String[] args){
		new Sample_Mouse(); 
	}

	public class MyJPanel extends JPanel implements MouseListener, MouseMotionListener{
		static int x,y;
		public MyJPanel(){ 
			setBackground(Color.white); 
			addMouseListener(this); 
			addMouseMotionListener(this);
		}

		public void paintComponent(Graphics g){
			g.fillOval(x,y,20,20);
		}
		public void mouseClicked(MouseEvent me){
			System.out.println("Click");
		}
		public void mousePressed(MouseEvent me){
			System.out.println("Press");
		}
		public void mouseEntered(MouseEvent me){
			System.out.println("Enter");
		}
		public void mouseExited(MouseEvent me){
			System.out.println("Exit");
		}
		public void mouseReleased(MouseEvent me){
			System.out.println("Release");
		}
		public void mouseMoved(MouseEvent me){
			System.out.println("Move");
		}
		public void mouseDragged(MouseEvent me){
			x = me.getX();
			y = me.getY();
			repaint();
		}
	}
}

