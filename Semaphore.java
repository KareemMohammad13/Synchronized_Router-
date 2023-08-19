public class Semaphore {
  public static int queue;

  Semaphore(int num){
      queue=num;
  }

  public synchronized void on(Device device){
    queue--;
    if(queue<0) {
        try {
            System.out.println(device.deviceName + " " + device.deviceType + " arrived and waiting");
            wait();
        } catch (InterruptedException e) {}
    }
    else {
        System.out.println(device.deviceName + " " + device.deviceType + " arrived");
    }
  }
  public synchronized void off() {
    queue++;
    if (queue <= 0)
        notify();
  }
}