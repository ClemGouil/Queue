public class QueueImpl<E> implements Queue<E> {

    private Object[] queue;
    private Integer index;
    public QueueImpl(Integer s){
        this.queue = new Object[s];
        this.index=0;
    }
    @Override
    public void push(Object o) throws FullQueueException {
        if( queue.length == index) {throw new FullQueueException();}
        this.queue[index] = o;
        index++;
    }
    @Override
    public E pop() throws EmptyQueueException {
        if( index == 0) {throw new EmptyQueueException();}
        Object first;
        first = this.queue[0];
        for(int k=0;k<this.queue.length-1;k++){
            this.queue[k]= this.queue[k+1];
        }
        this.index-=1;
        return (E) first;

    }

    @Override
    public int size() {
        return index;
    }
}
