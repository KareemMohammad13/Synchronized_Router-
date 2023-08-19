import java.util.Scanner;

public class Network{
    public static void main(String [] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.println("What is the number of WI-FI Connections? ");
        int nConnections = input.nextInt();
        Router myRouter = new Router(nConnections); 


        System.out.println("What is the number of devices Clients want to connect");
        int nDevices = input.nextInt();
        Device[] devices = new Device[nDevices];

        
        System.out.println("What is the Device's Name and type?");
        input=new Scanner(System.in);
        
        for (int j = 0; j < nDevices; j++) {
            String s = input.nextLine();
            String[] parts = s.split(" "); 
            if (parts.length == 2) {
                String name = parts[0]; 
                String type = parts[1]; 
                devices[j] = new Device(name, type, myRouter);
            } else {
                System.out.println("Input format is incorrect.");
            }
        }
        
        for (int j = 0; j < nDevices; j++) {
            System.out.println(devices[j].deviceName + " " + devices[j].deviceType);
        }
        /* Starting all the Devices threads */
        for (int j = 0; j < nDevices; j++) {
            Thread.sleep(1000);
            devices[j].start();
        }
        
    }

}
