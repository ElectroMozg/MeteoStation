

public class Main {

    public static void main(String[] args)  {
//    MassageTerminal massageTerminal = new MassageTerminal();
        MeteoGUI meteoGUI = new MeteoGUI();
        Weather weatherNSK = new Weather("Novosibirsk");

        System.out.println("Температура: "+weatherNSK.getTemperature());
        System.out.println("Влажность: "+weatherNSK.getHumidity()+"%");
        System.out.println("Давление: "+weatherNSK.getPressure());
       // meteoGUI.setVisible(true);
    }

}

