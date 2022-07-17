package basic.thread;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx2_1 threadEx2_1 = new ThreadEx2_1();
        threadEx2_1.start();

        System.out.println("thread.start()!");
    }
}

class ThreadEx2_1 extends Thread {

    public void run() {
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
