import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private final Semaphore fooSemaphore = new Semaphore(1); // Starts with 1 permit for foo
    private final Semaphore barSemaphore = new Semaphore(0); // Starts with 0 permits for bar

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire(); // Wait for permission to print "foo"
            printFoo.run();         // Outputs "foo"
            barSemaphore.release(); // Grant permission to print "bar"
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire(); // Wait for permission to print "bar"
            printBar.run();         // Outputs "bar"
            fooSemaphore.release(); // Grant permission to print "foo"
        }
    }
}
