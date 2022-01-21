
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MeteoGUI extends JFrame{
    private JButton button = new JButton("Press");
    private JLabel label = new JLabel("Lable");
    public JTextArea textArea = new JTextArea(10,20);


    public MeteoGUI()  {
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(button);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        container.add(textArea);
    }
}
