
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MeteoGUI extends JFrame{

    private JLabel labelDegree = new JLabel("Температура");
    private JLabel labelPressure = new JLabel("Давление");
    private JLabel labelHumidity = new JLabel("Влажность");
    private JButton buttonRefresh = new JButton("Обновить");
    public JTextField degreeTextArea = new JTextField("-15"+"℃",3);
    public JTextField pressureTextArea = new JTextField("763",3);
    public JTextField humidityTextArea = new JTextField("82%",3);



    public MeteoGUI()  {
        super("Simple Example");
        this.setBounds(100,100,400,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        labelDegree.setHorizontalAlignment(JLabel.CENTER);
        labelDegree.setFont(new Font("",Font.PLAIN,22));
        labelPressure.setHorizontalAlignment(JLabel.CENTER);
        labelPressure.setFont(new Font("",Font.PLAIN,22));
        labelHumidity.setHorizontalAlignment(JLabel.CENTER);
        labelHumidity.setFont(new Font("",Font.PLAIN,22));


        Container labelContainer = this.getContentPane();
        labelContainer.setLayout(new FlowLayout(FlowLayout.CENTER));

        labelContainer.add(labelDegree);
        labelContainer.add(labelPressure);
        labelContainer.add(labelHumidity);

        degreeTextArea.setEditable(false);
        degreeTextArea.setFont(new Font("",Font.PLAIN,40));
        degreeTextArea.setHorizontalAlignment(JTextField.CENTER);

        pressureTextArea.setEditable(false);
        pressureTextArea.setFont(new Font("",Font.PLAIN,40));
        pressureTextArea.setHorizontalAlignment(JTextField.CENTER);

        humidityTextArea.setEditable(false);
        humidityTextArea.setFont(new Font("",Font.PLAIN,40));
        humidityTextArea.setHorizontalAlignment(JTextField.CENTER);

        Container textAreaContainer = this.getContentPane();
        textAreaContainer.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonRefresh.setFont(new Font("",Font.PLAIN,22));

        textAreaContainer.add(degreeTextArea);
        textAreaContainer.add(pressureTextArea);
        textAreaContainer.add(humidityTextArea);
        textAreaContainer.add(buttonRefresh);
    }
}
