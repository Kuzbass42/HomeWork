package javaSE01.t06;

import java.util.Arrays;

public class NotePad {

    private static final int ARRAY_STEP = 8;

    private Note[] notes;
    private int    index;

    public NotePad() {

        this(ARRAY_STEP);
    }

    public NotePad(int arraySize) {
        this.notes = new Note[arraySize];
    }

    public Note addNote(String title, String body) {
        Note ret = null;

        if (canAdd()) {
            Note note = new Note(++index);
            note.setTitle(title);
            note.setBody(body);

            notes[note.getId() - 1] = note;

            ret = note;
        }

        return ret;
    }

    private boolean canAdd() {

        if (index >= notes.length && index < Integer.MAX_VALUE) {
            int arraySize = (Integer.MAX_VALUE - index < ARRAY_STEP) ? Integer.MAX_VALUE : notes.length + ARRAY_STEP;

            notes = Arrays.copyOf(notes, arraySize);
        }

        return index <= notes.length;
    }

    public Note getNote(int id) {

        return (id > 0 && id <= index) ? notes[id - 1] : null;
    }

    public Note editNote(int id, String newTitle, String newBody) {
        Note note = getNote(id);

        if (note == null) {
            System.out.println("Не удалось обновить запись. Запись с номером " + id + " не существует!");
        } else {
            note.setTitle(newTitle);
            note.setBody(newBody);
        }

        return note;
    }

    public void deleteNote(int id) {
        if (id > 0 && id <= index) {
            for (int i = id; i < index; i++) {
                Note note = getNote(i + 1);
                notes[i - 1] = note;
            }

            notes[--index] = null;
        } else {
            System.out.println("Не удалось удалить запись. Запись с номером " + id + " не существует!");
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 1; i <= index; i++) {
            result += getNote(i).toString() + "\n";
        }

        return result;
    }

    public static void main(String[] args) {
        NotePad notePad = new NotePad();

        notePad.addNote("ere", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ads", "asdas");


        System.out.println(notePad.toString());

        notePad.addNote("ere", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ere", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ere", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ere", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ere", "asdas");
        notePad.addNote("ads", "asdas");
        notePad.addNote("ads", "asdas");

        System.out.println(notePad.toString());

        notePad.editNote(12, "newTitle", "newBody");

        System.out.println(notePad.toString());

        notePad.deleteNote(7);

        System.out.println(notePad.toString());
    }
}
