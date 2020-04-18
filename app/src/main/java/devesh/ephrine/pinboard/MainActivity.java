package devesh.ephrine.pinboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNote(View v){
Intent intent = new Intent(this, NotesActivity.class);

        String noteid ="String55546";
        intent.putExtra(getString(R.string.note_id), noteid);
        startActivity(intent);
    }
}
