public class ThreadManager {
    private boolean threadFlag = true;

    public void setThreadFlag(boolean threadFlag){
        this.threadFlag = threadFlag;
    }

    public void printThreadGroupHierarchy(ThreadGroup mainThreadGroup){
        if (mainThreadGroup == null) {
            return;
        }

        Runnable printThreadInfo;
        printThreadInfo = () -> {
            synchronized (this) {
                while (!mainThreadGroup.isDestroyed() && threadFlag) {
                    ThreadGroup[] allThreadGroups = new ThreadGroup[mainThreadGroup.activeCount()];
                    int sizeThreadArray = mainThreadGroup.activeCount();
                    mainThreadGroup.enumerate(allThreadGroups, true);

                    if (mainThreadGroup.activeCount() > 0) {
                        System.out.println(mainThreadGroup.getName());
                    }

                    for (int i = 0; i < sizeThreadArray; i++) {
                        if (allThreadGroups[i] != null) {
                            allThreadGroups[i].list();
                        }
                    }

                    try {
                        wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\n");
                }
            }
        };

        Thread printingThread = new Thread(printThreadInfo);
        printingThread.start();
    }
}
