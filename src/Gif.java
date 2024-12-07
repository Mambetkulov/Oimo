import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Gif {
    JFrame Window;
    Container con;
    JPanel panel;
    JLabel pLabel;
    JButton button;
    ImageIcon image;
    String file ;
    ButtonHandler handler = new ButtonHandler();
    SoundEffect so = new SoundEffect();

    public static void main(String[] args) {
        new Gif();
    }
    public Gif(){
       Window = new JFrame();
       Window.setSize(380,700);
       Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Window.getContentPane().setBackground(Color.cyan);
       Window.setLayout(null);
       con = Window.getContentPane();
       panel = new JPanel();
       panel.setBounds(0,0,380,690);
       panel.setBackground(Color.white);
       con.add(panel);
       image = new ImageIcon(".//src//hell93//96633009-d1818000-1318-11eb-9f1d-7f914f4ccb16.gif");
       button = new JButton(image);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(0,0,0,0);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
       button.addActionListener(handler);
       panel.add(button);
       pLabel = new JLabel();
       pLabel.setIcon(image);
       panel.add(pLabel);

       Window.setVisible(true);
       file = ".//src//hell93//mixkit-winning-a-coin-video-game-2069.wav";


    }

    public class SoundEffect {
        Clip clip;
        public void setFile (String soundFileName){
            try{
                File file = new File (soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            } catch (Exception e) {
                System.out.println("Something gone wrong");
            }
        }
        public void play(){
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event ){
           so.setFile(file);
           so.play();
        }
    }
}
