package multithreading.executorExample;

import java.util.concurrent.Executor;

class NewThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread executed under an executor");
    }
}
class ExecutorImp implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}

public class c {
    public static void main(String[] args)
    {
        ExecutorImp obj = new ExecutorImp();
        obj.execute(new NewThread());
    }
}


