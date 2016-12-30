package clock;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;
import java.awt.image.*;

class Interface extends JFrame {
    
    private JLabel currentTimeLabel = new JLabel(Control.c1.getCurrentTime(Control.c1), JLabel.CENTER);
    private Timer timer = new Timer();
    private JFrame showClock = new JFrame();
    private Font sans = new Font("SansSerif", Font.BOLD, 64);
    private Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
    
    public Interface() {
        
        currentTimeLabel.setOpaque(true); 
       currentTimeLabel.setForeground(Color.blue);
        currentTimeLabel.setBackground(Color.yellow);
        currentTimeLabel.setFont(sans);
        setIconImage(icon);
        setTitle("The time");
        setSize(400,150);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        timer.schedule(new TimerTask() {
        @Override
            public void run() {
                currentTimeLabel.setText(Control.c1.getCurrentTime(Control.c1));
                add(currentTimeLabel);
            }
        }, 0, 1000);
    }
}
