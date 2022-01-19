import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class MassageTerminal {

    private static final String COM_PORT = "COM12";

    private static Queue<String> massages;
    private static SerialPort serialPort;

    public MassageTerminal() {
        massages = new ArrayDeque<>();
        //Передаём в конструктор имя порта
        serialPort = new SerialPort(COM_PORT);
        try {
            //Открываем порт
            serialPort.openPort();
            //Выставляем параметры
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Устанавливаем ивент лисенер и маску
            serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
            //Отправляем запрос устройству
            serialPort.writeString("Get data");
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }

    public String getMassage() {
        if (availableMassage()) {
            return massages.poll();
        } else {
            return "No massage";
        }
    }

    public void sendMassage(String massage) {
        try {
            // отправляем сообщение
            serialPort.writeString("Get data");
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }

    public boolean availableMassage() {
        return massages.size() != 0;
    }


    private static class PortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent event) {
            int sizeByte = event.getEventValue();
            if (event.isRXCHAR() && sizeByte > 100) {
                try {
                    //Получаем ответ от устройства, обрабатываем данные и складываем в очередь сообщений.
                    String data = serialPort.readString();
                    Scanner buffer = new Scanner(data);
                    while (buffer.hasNextLine()){
                        massages.add(buffer.nextLine());
                    }
                } catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
