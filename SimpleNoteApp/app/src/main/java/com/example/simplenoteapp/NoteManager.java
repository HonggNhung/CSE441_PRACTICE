import android.content.Context;

import com.example.simplenoteapp.Note;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NoteManager {

    private Context context;
    private Gson gson;

    public NoteManager(Context context) {
        this.context = context;
        this.gson = new GsonBuilder().create();
    }

    public void saveNote(Note note) {
        try {
            FileOutputStream fos = context.openFileOutput("note_" + note.getId() + ".txt", Context.MODE_PRIVATE);
            String noteJson = gson.toJson(note);
            fos.write(noteJson.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Note> loadNotes() {
        List<Note> notes = new ArrayList<>();
        String[] files = context.fileList();
        for (String file : files) {
            if (file.startsWith("note_")) {
                try {
                    FileInputStream fis = context.openFileInput(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    String noteJson = stringBuilder.toString();
                    Note note = gson.fromJson(noteJson, Note.class);
                    notes.add(note);
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return notes;
    }

    public void deleteNote(Note note) {
        context.deleteFile("note_" + note.getId() + ".txt");
    }

    public Note getNoteById(int noteId) {
        try {
            FileInputStream fis = context.openFileInput("note_" + noteId + ".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String noteJson = stringBuilder.toString();

            Note note = gson.fromJson(noteJson, Note.class);
            fis.close();
            return note;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

