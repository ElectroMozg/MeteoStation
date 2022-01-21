public class Main {

    public static void main(String[] args) {
    MassageTerminal massageTerminal = new MassageTerminal();
    MeteoGUI meteoGUI = new MeteoGUI();
    meteoGUI.setVisible(true);
        while (true){
            if(massageTerminal.availableMassage()){
                String massage = massageTerminal.getMassage();
                System.out.println(massage);
                meteoGUI.textArea.setText(massage);
            }
        }
    }
}
