public class Device extends Thread {

  public static Router sharedRouter;
  public boolean enter = false;
  public int assignedConnection ;
  public String deviceName;
  public String deviceType;

  Device(String name, String type, Router router) {
    deviceName = name;
    deviceType = type;
    sharedRouter = router;
  }

  public void run() {
        sharedRouter.connection.on(this);
        try {
          assignedConnection=sharedRouter.occupy(this); 
        }catch (InterruptedException e){}

        try {
          System.out.println("connection " + assignedConnection + ": " + deviceName + sharedRouter.login());
        }catch (InterruptedException e){}

        try {
          System.out.println("connection " + assignedConnection + ": " + deviceName +sharedRouter.perform());
        }catch (InterruptedException e){}

        System.out.println("connection " +assignedConnection + ": " + deviceName + sharedRouter.logout(this));
        
        sharedRouter.connection.off();
  }

}


