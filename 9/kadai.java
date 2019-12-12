import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class kadai extends JFrame{
	public kadai(){
		setSize(500, 500);
		setTitle("Java Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyJPanel myJPanel = new MyJPanel();
		Container c = getContentPane();
		c.add(myJPanel);
		setVisible(true);
	}

	public static void main(String[] args){
		new kadai();
	}

	public class MyJPanel extends JPanel implements ActionListener{
		Timer timer;
		int x1=120,y1=120;
		int right1=1,up1=1;
		int x2=90,y2=90;
		int right2=1,up2=1;
		int x3=60,y3=60;
		int right3=1,up3=1;
		int x4=30,y4=30;
		int right4=1,up4=1;
		int x5=0,y5=0;
		int right5=1,up5=1;
		public MyJPanel(){
			timer = new Timer(1,this);
			timer.start();
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.fillOval(x1,y1,10,10);
			g.fillOval(x2,y2,10,10);
			g.fillOval(x3,y3,10,10);
			g.fillOval(x4,y4,10,10);
			g.fillOval(x5,y5,10,10);
		}

		public void actionPerformed(ActionEvent e){
			repaint();
			Dimension d;
			d=getSize();
			if(right1==1) x1 += 5;
			else x1 -= 5;
			if(x1>d.width-10) right1 = 0;
			if((x1<0)&&(right1==0)) right1 = 1;
			if(up1==1) y1 += 5;
			else y1 -= 5;
			if(y1>d.height-10) up1 = 0;
			if((y1<0)&&(up1==0)) up1 = 1;

			if(right2==1) x2 += 5;
			else x2 -= 5;
			if(x2>d.width-10) right2 = 0;
			if((x2<0)&&(right2==0)) right2 = 1;
			if(up2==1) y2 += 5;
			else y2 -= 5;
			if(y2>d.height-10) up2 = 0;
			if((y2<0)&&(up2==0)) up2 = 1;

			if(right3==1) x3 += 5;
			else x3 -= 5;
			if(x3>d.width-10) right3 = 0;
			if((x3<0)&&(right3==0)) right3 = 1;
			if(up3==1) y3 += 5;
			else y3 -= 5;
			if(y3>d.height-10) up3 = 0;
			if((y3<0)&&(up3==0)) up3 = 1;

			if(right4==1) x4 += 5;
			else x4 -= 5;
			if(x4>d.width-10) right4 = 0;
			if((x4<0)&&(right4==0)) right4 = 1;
			if(up4==1) y4 += 5;
			else y4 -= 5;
			if(y4>d.height-10) up4 = 0;
			if((y4<0)&&(up4==0)) up4 = 1;

			if(right5==1) x5 += 5;
			else x5 -= 5;
			if(x5>d.width-10) right5 = 0;
			if((x5<0)&&(right5==0)) right5 = 1;
			if(up5==1) y5 += 5;
			else y5 -= 5;
			if(y5>d.height-10) up5 = 0;
			if((y5<0)&&(up5==0)) up5 = 1;

		}
	}
}
