package simple.thread;

/**
 * Author:  andy.xwt
 * Date:    2020/5/15 17:23
 * Description:
 */


class PrintFunctionOrder {

    private final Object mObject = new Object();
    private boolean isFirstFinish;
    private boolean isSecondFinish;

    public static void main(String[] args) {

        PrintFunctionOrder order = new PrintFunctionOrder();

    }


    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (mObject) {
            printFirst.run();
            isFirstFinish = true;
            mObject.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (mObject) {
            while (!isFirstFinish) {
                mObject.wait();
            }
            printSecond.run();
            isSecondFinish = true;
            mObject.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (mObject) {
            while(!isSecondFinish) {
                mObject.wait();
            }
            printThird.run();
            mObject.notifyAll();
        }
    }
}
