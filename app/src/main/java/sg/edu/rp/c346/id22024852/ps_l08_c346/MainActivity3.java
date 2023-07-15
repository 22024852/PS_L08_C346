package sg.edu.rp.c346.id22024852.ps_l08_c346;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity3 extends AppCompatActivity {

    EditText title;
    EditText singer;
    EditText year;
    RadioGroup stars;
    Button edit;
    Button cancel;
    Button Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        title = findViewById(R.id.editTextTitle);
        singer = findViewById(R.id.editTextSingers);
        year = findViewById(R.id.editTextYear);
        stars = findViewById(R.id.RadioGroupStars);
        edit = findViewById(R.id.buttonEdit);
        cancel = findViewById(R.id.btnCancel);
        Delete = findViewById(R.id.btnDelete);

        Intent i = getIntent();
        Song song = (Song) i.getSerializableExtra("song");
        title.setText(song.getTitle());
        singer.setText(song.getSinger());


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity3.this);
                song.setTitle(title.getText().toString());
                song.setSingers(singer.getText().toString());
                song.setYear(Integer.parseInt(year.getText().toString()));
                if (stars.getCheckedRadioButtonId() == R.id.radioButton1){
                    song.setStars(1);
                } else if (stars.getCheckedRadioButtonId() == R.id.radioButton2) {
                    song.setStars(2);
                } else if (stars.getCheckedRadioButtonId() == R.id.radioButton3) {
                    song.setStars(3);
                } else if (stars.getCheckedRadioButtonId() == R.id.radioButton4) {
                    song.setStars(4);
                }else if (stars.getCheckedRadioButtonId() == R.id.radioButton5) {
                    song.setStars(5);
                }
                db.updateSong(song);
                db.close();
                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity3.this);
                db.deleteSong(song.get_id());
                db.close();
                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}