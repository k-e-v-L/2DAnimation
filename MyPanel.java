import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image vastane;
    Image taust;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.green);
        vastane = new ImageIcon("vastane.png").getImage();
        taust = new ImageIcon("taust.png").getImage();
        timer = new Timer(10, this); //Every 10 ms it will move the picture
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(taust, 0, 0, null);

        g2D.drawImage(vastane, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Once the picture touches one of the borders it will change the velocity. Means it will run right-left until program is stopped.
        if (x>=PANEL_WIDTH-vastane.getWidth(null) || x<0){
            xVelocity = xVelocity * -1; //Moves the picture left
        }
        x = x + xVelocity; //Moves the picture right

        if (y >= PANEL_HEIGHT - vastane.getHeight(null) || y < 0) {
            yVelocity = yVelocity * -1; //Moves the picture down
        }
        y = y + xVelocity; //Moves the picture up

        repaint(); //Now using repaint we can see that the picture is moving, without it we would have to resize it to see change.
    }
}
