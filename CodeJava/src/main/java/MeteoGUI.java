
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MeteoGUI extends JFrame{

    private  Weather weatherNSK = new Weather("Novosibirsk");

    private JLabel labelDegree = new JLabel("Температура");
    private JLabel labelPressure = new JLabel("Давление");
    private JLabel labelHumidity = new JLabel("Влажность");
    private JButton buttonRefresh = new JButton("Обновить");
    private JTextField degreeTextArea = new JTextField(weatherNSK.getTemperature()+"℃",4);
    private JTextField pressureTextArea = new JTextField(weatherNSK.getPressure()+"",4);
    private JTextField humidityTextArea = new JTextField(weatherNSK.getHumidity()+"%",4);


    public static void main(String[] args)  {
        new MeteoGUI();
    }

    public MeteoGUI()  {

        super("MeteoStation");

        this.setBounds(1450,100,400,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont = new Font("",Font.PLAIN,22);
        labelDegree.setHorizontalAlignment(JLabel.CENTER);
        labelDegree.setFont(mainFont);

        labelPressure.setHorizontalAlignment(JLabel.CENTER);
        labelPressure.setFont(mainFont);

        labelHumidity.setHorizontalAlignment(JLabel.CENTER);
        labelHumidity.setFont(mainFont);
        Font mainFontText = new Font("",Font.PLAIN,30);
        degreeTextArea.setEditable(false);
        degreeTextArea.setFont(mainFontText);
        degreeTextArea.setHorizontalAlignment(JTextField.CENTER);

        pressureTextArea.setEditable(false);
        pressureTextArea.setFont(mainFontText);
        pressureTextArea.setHorizontalAlignment(JTextField.CENTER);

        humidityTextArea.setEditable(false);
        humidityTextArea.setFont(mainFontText);
        humidityTextArea.setHorizontalAlignment(JTextField.CENTER);

        buttonRefresh.setFont(mainFont);

        buttonRefresh.addActionListener(new ListenerAction());

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(labelDegree);
        container.add(labelPressure);
        container.add(labelHumidity);
        container.add(degreeTextArea);
        container.add(pressureTextArea);
        container.add(humidityTextArea);
        container.add(buttonRefresh);

        this.setVisible(true);
    }

    class ListenerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            weatherNSK.refreshMeasures();
            degreeTextArea.setText(weatherNSK.getTemperature()+"℃");
            pressureTextArea.setText(weatherNSK.getPressure()+"");
            humidityTextArea.setText(weatherNSK.getHumidity()+"%");
        }
    }
}
