public class Book extends Item implements Borrowable {
    private String genre;

    public Book(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void borrow() {
        System.out.println("You have borrowed the book: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("You have returned the book: " + getTitle());
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}

