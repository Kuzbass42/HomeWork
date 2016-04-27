package javaSE01.t06;

import java.util.Arrays;

/**
 *Class NotePad provides storage and API to deal with notes.
 *
 * <p>Class NotePad contains an array, which stores Note's. Also NotePad provides API to create, modify, view
 * and delete notes</p>
 * @author Mikhail Sigarev
 */
public class NotePad {

    private static final int ARRAY_STEP = 8;

    private Note[] notes;
    private int    index;

    /**
     *Instatiation of NotePad class.
     *
     * </p>Instatiation of NotePad class with an array of Note's. Default dimension of this array is {@value #ARRAY_STEP}</p>
     */
    public NotePad() {

        this(ARRAY_STEP);
    }

    /**
     *Instatiation of NotePad class.
     *
     * <p>Instatiation of NotePad class with an array of Note's</p>
     *
     *@param arraySize Dimension of the array of Notes.
     */
    public NotePad(int arraySize) {
        this.notes = new Note[arraySize];
    }

    /**
     * Addition of a new Note.
     *
     * <p>Addition of a new Note. Id of Note is automatically increments {@link #index}</p>
     *
     *@param title Title of a new Note
     *@param body Body of a new Note
     */
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

    /**
     * Checking of a possibility to add a new Note.
     *
     * <p>In case of an array is not full returns is true</p>
     * <p>In case of an array is full, but it's dimension less than max value of Integer returns is true and
     * array is copied into another array in bigger dimension (pace equals {@link #ARRAY_STEP})</p>
     * <p>In case of array is full and it's dimension equals max value of Integer returns is false</p>
     */
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

    /**
     * Modify a Note.
     *
     * <p>Modifying a Note with number {@link Note#id}</p>
     */
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

    /**
     * Delete a Note.
     *
     * <p>Deleting a Note with number {@link Note#id}</p>
     */
    public void deleteNote(int id) {
        if (id > 0 && id <= index) {
            Note note;

            for (int i = id; i < index; i++) {
                note = getNote(i + 1);
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
