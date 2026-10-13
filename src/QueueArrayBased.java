public class QueueArrayBased implements QueueInterface {
  private final int MAX_QUEUE = 50; // maximum size of queue
  private Object[] items;
  private int front, back, count;
  
  public QueueArrayBased() {
    items = new Object[MAX_QUEUE];  
    front = 0;
    back = MAX_QUEUE-1; 
    count = 0;
  }  // end default constructor

  // queue operations:
  public boolean isEmpty() {
    return count == 0;
  }  // end isEmpty

  public boolean isFull() {
    return count == MAX_QUEUE;
  }  // end isFull
  
  public void enqueue(Object newItem) {
    if (!isFull()) {
      back = (back+1) % (MAX_QUEUE);
      items[back] = newItem;
      ++count;
    }
    else {
      throw new QueueException("QueueException on enqueue: "
                             + "Queue full");
    }  // end if
  }  // end enqueue

  public Object dequeue() throws QueueException {
    if (!isEmpty()) {
      // queue is not empty; remove front
      Object queueFront = items[front];
      front = (front+1) % (MAX_QUEUE);
      --count;
      return queueFront;
    }
    else {
      throw new QueueException("QueueException on dequeue: "+
                              "Queue empty");
    }   // end if
  }  // end dequeue

  public void dequeueAll() {
    items = new Object[MAX_QUEUE];  
    front = 0;
    back = MAX_QUEUE-1;
    count = 0;
  }  // end dequeueAll

  public Object peek() throws QueueException {
    if (!isEmpty()) {  
      // queue is not empty; retrieve front
      return items[front];
    }
    else {
      throw new QueueException("Queue exception on peek: " + 
                              "Queue empty");
    }  // end if
  }  // end peek
  //Create a displayQueue method in the QueueArrayBased class that displays or prints out the
  //Queue horizontally and indicates which end is the front and which is the back.
  public void displayQueue(){
    if(!isEmpty()){
      System.out.print("Front : ");
      for(int i = front; i != back + 1; i = (i + 1) % 50){
        System.out.print(items[i].toString() + " : ");
      }
      System.out.println("Back");
    }else{
      throw new QueueException("Queue exception on display: " + 
                              "Queue empty");
    }
  }
} // end QueueArrayBased