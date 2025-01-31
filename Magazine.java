public class Magazine extends Item implements Borrowable {
    private int issueNumber;

    public Magazine(String title, String author, String isbn, int issueNumber) {
        super(title, author, isbn);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void borrow() {
        System.out.println("You have borrowed the magazine: " + getTitle() + ", Issue: " + issueNumber);
    }

    @Override
    public void returnItem() {
        System.out.println("You have returned the magazine: " + getTitle() + ", Issue: " + issueNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", Issue Number: " + issueNumber;
    }
}

