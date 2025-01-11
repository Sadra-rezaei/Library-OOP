public class Book {
    private String title;
    private int pages;
    private String author;
    private boolean avaiablity;

    public Book (String title,String author, int pages) {
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.avaiablity = true;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPages() {
        return this.pages;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean isAvaiable() {
        return this.avaiablity;
    }

    public void changeAvaiable() {
        this.avaiablity = !this.avaiablity;
    }




}
