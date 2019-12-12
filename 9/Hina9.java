import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hina9 extends JFrame{
	public Hina9(){
		setSize(500, 500);
		setTitle("Java Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyJPanel myJPanel = new MyJPanel();
		Container c = getContentPane();
		c.add(myJPanel);
		setVisible(true);
	}

	public static void main(String[] args){
		new Hina9();
	}

	public class MyJPanel extends JPanel implements ActionListener{
		Timer timer;
		int x=0;
		int right=1;
		public MyJPanel(){
			timer = new Timer(10,this);
			timer.start();
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.fillOval(x,250,30,30);
		}

		public void actionPerformed(ActionEvent e){
			repaint();
			Dimension d;
			d=getSize();
			if(right==1){
				x += 5;
			}else{
				x -= 5;
			}
			if(x>d.width-30){
				right = 0;
			}
			if((x<0)&&(right==0)){
				right = 1;
			}
		}
	}
}
