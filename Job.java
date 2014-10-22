import java.io.Console;

public class Job implements Runnable {
  private int jobNumber;
  
  Job(int jobNumber) {
    this.jobNumber = jobNumber;
  }
  
  public void run() {
    //undertake the required work, here will will emulate it by sleeping for a period
    System.out.println("Job: " + jobNumber + " is being processed by thread: " + Thread.currentThread().getName());
    try {
      Thread.sleep((int)(Integer.parseInt(System.console().readLine("How long to sleep for: "))));
    } catch (InterruptedException e) {
      //no catching as example should not experience interruptions
    }
    System.out.println("Job: " + jobNumber + " is ending in thread: " + Thread.currentThread().getName());
  }
}
