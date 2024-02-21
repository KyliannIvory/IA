public class Bucket {

    private final int capacity;
    private int currentQuantity;

    public Bucket(int capacity, int currentQuantity) {
        this.capacity = capacity;
        this.currentQuantity = currentQuantity;
    }

    public Bucket(Bucket bucketToCopy) {
        this.capacity = bucketToCopy.capacity;
        this.currentQuantity = bucketToCopy.currentQuantity;
    }

    public boolean isFull() {
        return currentQuantity == capacity;
    }

    public boolean isEmpty() {
        return currentQuantity == 0;
    }

    public void fill() {
        if (!isFull())
            setCurrentQuantity(capacity);
    }

    public void empty() {
        if (!isEmpty())
            setCurrentQuantity(0);
    }

    public void transferTo(Bucket destination) {
        if ((!this.isEmpty()) && (!destination.isFull())) {
            if (this.currentQuantity <= destination.quantityToTransfer()) {
                destination.setCurrentQuantity(destination.getCurrentQuantity() + this.currentQuantity);
                this.empty();
            } else {
                this.setCurrentQuantity(this.getCurrentQuantity() - destination.quantityToTransfer());
                destination.fill();
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int quantityToTransfer() {
        return capacity - currentQuantity;
    }
}
