import static java.lang.Thread.sleep;


public class Router {

    public boolean[] connectionArray;
    public int nConnections;
    public Semaphore connection;
    public int nOccupied;


    Router(int x) { 
        nConnections = x;
        connection = new Semaphore(nConnections);
        connectionArray = new boolean[nConnections];
    }

    public synchronized int occupy(Device device) throws InterruptedException {

        for (int i = 0; i < nConnections; i++) {
            if (connectionArray[i] == false) { 
                nOccupied++;
                device.assignedConnection = i+1;
                System.out.println("Connection " + device.assignedConnection + ": " + device.deviceName + " occupied");
                connectionArray[i] = true;
                sleep(1000);
                break;
            }
        }
        return device.assignedConnection;
    }
    public String login() throws InterruptedException {
        sleep(1000);
        return " login";
    }
    public String perform() throws InterruptedException {
        sleep(1000);
        return " performs online activity";
    }
    public synchronized String logout(Device device) {

        nOccupied--;
        connectionArray[device.assignedConnection-1] = false;

        notify();
        return " Logged out";
    }

}
