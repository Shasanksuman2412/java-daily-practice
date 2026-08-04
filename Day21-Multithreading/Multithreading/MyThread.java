public class MyThread extends Thread {
    private String taskName;

    MyThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - step " + i + " on thread: " + Thread.currentThread().getName());
        }
    }
}
