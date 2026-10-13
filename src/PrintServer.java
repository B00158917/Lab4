public class PrintServer {
    public static void main(String[] args) {
        QueueArrayBased testQueue = new QueueArrayBased();
        for(int i = 0; i<40; i++){
            testQueue.enqueue(i);
        }
        testQueue.displayQueue();
    }
}
