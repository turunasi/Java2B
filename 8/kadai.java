import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class kadai extends JFrame {
    public kadai() {
        setSize(1500,500);
        setTitle("Java programming");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyJPanel myJPanel = new MyJPanel();
        Container c = getContentPane();
        c.add(myJPanel);
        setVisible(true);
    }

    public static void main(String[] argsA) {
        new kadai();
    }
    public class MyJPanel extends JPanel {
        Image image, image90, image180, image270;
        int width,height;
        int[] data,data90,data180,data270;
        public MyJPanel () {
            setBackground(Color.white);
            ImageIcon icon = new ImageIcon("sample1.jpg");
            image = icon.getImage();
            width = image.getWidth(this);
            height = image.getHeight(this);
            data = new int[width*height];
            data90 = new int[width*height];
            data180 = new int[width*height];
            data270 = new int[width*height];
            PixelGrabber pg = new PixelGrabber(image, 0, 0, width, height, data, 0, width);
            try {
                pg.grabPixels();
            } catch (InterruptedException e) {
                System.out.println("Error.");
            }
        }
        public void paintComponent(Graphics g) {
            int i,j;
            for (i=0; i<width; i++) {
                for (j=0; j<height; j++) {
                    data90[i+j*width] = data[(width-1-i)*height+j];
                }
            }
            for (i=0; i<width; i++) {
                for (j=0; j<height; j++) {
                    data270[i+j*width] = data[i*height+height-1-j];
                }
            }
            for (i=0; i<width; i++) {
                for (j=0; j<height; j++) {
                    data180[i+j*width] = data[width-1-i+(height-1-j)*width];
                }
            }
            image90 = createImage(new MemoryImageSource(height, width, data90, 0, height));
            g.drawImage(image90, 0, 0, this);
            image180 = createImage(new MemoryImageSource(width, height, data180, 0, width));
            g.drawImage(image180, height, 0, this);
            image270 = createImage(new MemoryImageSource(height, width, data270, 0, height));
            g.drawImage(image270, width+height, 0, this);
        }
    }
}
