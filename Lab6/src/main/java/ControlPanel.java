import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        setLayout(new GridLayout(1, 4));
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
        loadBtn.addActionListener(this::load);

    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void exit(ActionEvent e) {
        System.out.println("Exit the program");
        System.exit(0);
    }

    private void reset(ActionEvent e){
        super.removeAll();
        repaint();
    }

    private void load(ActionEvent e){
        System.out.println("Load the program");
    }

}
