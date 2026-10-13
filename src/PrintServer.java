import java.util.Scanner;

public class PrintServer {
    private static Scanner input = new Scanner(System.in);
    private static QueueArrayBased serverQueue = new QueueArrayBased();
    public static void main(String[] args) {
        /*QueueArrayBased testQueue = new QueueArrayBased();
        for(int i = 0; i<40; i++){
            testQueue.enqueue(i);
        }
        testQueue.displayQueue();*/
        int selectedNum;
        do{
            System.out.println("Welcome to PrintServer! Please select a number from the list.\r\n" + //
                            "1. Enqueue a job (User enters job details).\r\n" + //
                            "2. Dequeue a job.\r\n" + //
                            "3. Peek at the job at front of the queue\r\n" + //
                            "4. Empty the queue\r\n" + //
                            "5. Display all jobs.\r\n" + //
                            "6. Quit the program");
            selectedNum = input.nextInt();
            //This nextLine is included to fix an issue that can occur in certain terminals, including mine, when following a nextInt() with a nextLine(),
            //where the nextLine will read in the enter key pressed from the nextInt
            input.nextLine();
            switch(selectedNum){
                case 1:
                    System.out.println("Enter job id, name and pages");
                    try{
                        serverQueue.enqueue(new PrintJob(input.nextLine(),input.nextLine(),input.nextLine()));
                        System.out.println("Enqueued Job");
                    } catch(QueueException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try{
                        serverQueue.dequeue();
                        System.out.println("Dequeued Job");
                    } catch(QueueException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try{
                        PrintJob peekedJob = (PrintJob)serverQueue.peek();
                        System.out.printf("id: %s , name: %s, pages: %s \n", peekedJob.getId(), peekedJob.getDoc_name(), peekedJob.getPages());
                    }catch(QueueException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    serverQueue.dequeueAll();
                    System.out.println("Queue Emptied");
                    break;
                case 5:
                    try{
                        serverQueue.displayQueue();
                    }catch(QueueException e){
                        e.printStackTrace();
                    }
                    break;
            }
        }while(selectedNum != 6);
    }
}
