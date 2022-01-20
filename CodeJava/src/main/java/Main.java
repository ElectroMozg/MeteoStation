public class Main {

    public static void main(String[] args) {
    MassageTerminal massageTerminal = new MassageTerminal();
        System.out.println("massage");
        while (true){
            if(massageTerminal.availableMassage()){

                String massage = massageTerminal.getMassage();
                System.out.println(massage);
            }
        }
    }
}
