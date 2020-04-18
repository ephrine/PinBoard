package devesh.ephrine.pinboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import devesh.ephrine.pinboard.room.AppDatabase;
import devesh.ephrine.pinboard.room.Note;
import devesh.ephrine.pinboard.room.UserDao;

public class NotesActivity extends AppCompatActivity {
String TAG="NotesActivity";

    EditText editTextNote;
    Note mynote= new Note();
    AppDatabase noteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        editTextNote=findViewById(R.id.editTextNote);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String id="";
        if(intent!=null){
            id = intent.getStringExtra(getString(R.string.note_id));


        }
        noteDB = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, getString(R.string.DATABASE_NOTES)).allowMainThreadQueries().build();

        getDatabase(id);

        editTextNote.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0){
                    Log.d(TAG, "onTextChanged: Note: "+s);
                    mynote.NOTE_content=s.toString();
                    addtoDB(mynote);
                }

            }
        });


    }

    public void clickOnNote(View v){
        editTextNote.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editTextNote, InputMethodManager.SHOW_IMPLICIT);
        Log.d(TAG, "clickOnNote: clickOnNote Click");
    }

    void getDatabase(String UID){
        List<Note> n=new ArrayList<>();

                n= noteDB.userDao().loadSelected(UID);
                mynote=n.get(0);

    }
    void addtoDB(Note note){
       /* String last_modified=String.valueOf(System.currentTimeMillis());
        mynote.NOTE_content=note;
        mynote.TITLE=title;
        mynote.LAST_MODIFIED=last_modified;
        */
        noteDB.userDao().insertAllr(note);
    }
}
