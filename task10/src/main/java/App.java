public class App {
    private static final int THREADS_COUNT = 10;
    private static final int TASKS_COUNT = 500;
    private static final int TASK_TIME = 15;

    public static void main(String[] args) {
        try (var executor = new ThreadPool(THREADS_COUNT)) {
            for (int i = 0; i < TASKS_COUNT; ++i) {
                int taskNum = i + 1;
                executor.execute(() -> {
                    try {
                        Thread.sleep(TASK_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Task %d executed\n", taskNum);
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks finished");
    }
}
