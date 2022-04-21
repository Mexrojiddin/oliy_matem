package uz.mexboy.oliy_matem.model;

public class MundarijaModel {
    String title;
    int page;

    public MundarijaModel(String title, int page) {
        this.title = title;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
