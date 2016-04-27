package javaSE01.t06;

public class Note {
    private String title;
    private String body;
    private int    id;

    public Note(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Note #" + id + " | title " + title + " | body " + body;
    }

    public int getId() {
        return id;
    }
}

