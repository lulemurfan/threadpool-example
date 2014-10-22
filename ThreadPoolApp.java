import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.io.Console;

public class ThreadPoolApp {
    public static void main(String[] args) {
        Console c = System.console();
        try {
            int numberOfJobs = Integer.parseInt(c.readLine("Number of jobs: "));
            int numberOfThreads = Integer.parseInt(c.readLine("Number of threads: "));
            if ((numberOfJobs < 1) || (numberOfThreads < 1))
                ThreadPoolApp.error();
            ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);
            Job[] jobs = new Job[numberOfJobs];
            for (int i = 0; i <numberOfJobs; i++) {
                jobs[i] = new Job(i);
                pool.execute(jobs[i]); //exec the given command at some future time
            }
            pool.shutdown();
            System.out.println("Last line " + Thread.currentThread().getName());
        } catch (NumberFormatException e) {
            ThreadPoolApp.error();
        }
    }
    
    private static void error() {
        System.out.println("ThreadPoolApp must be run with two positive valued integer arguments."+
        " The first detailing the number of jobs and the second the number of processing threads in the pool");
        System.exit(0);
    }
}