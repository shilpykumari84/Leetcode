class ZeroEvenOdd {
    private int n;

    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);
    private Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // Thread A
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            zeroSemaphore.acquire();

            printNumber.accept(0);

            if (i % 2 == 1) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
    }

    // Thread B
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {

            evenSemaphore.acquire();

            printNumber.accept(i);

            zeroSemaphore.release();
        }
    }

    // Thread C
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {

            oddSemaphore.acquire();

            printNumber.accept(i);

            zeroSemaphore.release();
        }
    }
}