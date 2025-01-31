public class DVD extends Item implements Borrowable {
    private int duration;  // duration in minutes

    public DVD(String title, String author, String isbn, int duration) {
        super(title, author, isbn);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void borrow() {
        System.out.println("You have borrowed the DVD: " + getTitle() + ", Duration: " + duration + " minutes");
    }

    @Override
    public void returnItem() {
        System.out.println("You have returned the DVD: " + getTitle());
    }

    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " minutes";
    }
}

