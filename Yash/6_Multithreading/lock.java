import java.util.concurrent.locks.*;

public class lock {
    class SharedResource {
        private int number = 0;
        private final ReadWriteLock lock = new ReentrantReadWriteLock();

        public void write(int value) {
            lock.writeLock().lock();
            try {
                number = value;
                System.out.println("Write: " + value);
            } finally {
                lock.writeLock().unlock();
            }
        }

        public int read() {
            lock.readLock().lock();
            try {
                System.out.println("Read: " + number);
                return number;
            } finally {
                lock.readLock().unlock();
            }
        }
    }

}
