package sg.edu.rp.c346.id22024852.ps_l08_c346;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText title;
    EditText singer;
    EditText year;
    RadioGroup Stars;
    Button insert;
    Button showlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.editTextTitle);
        singer = findViewById(R.id.editTextSingers);
        year = findViewById(R.id.editTextYear);
        Stars = findViewById(R.id.RadioGroupStars);
        insert = findViewById(R.id.buttonEdit);
        showlist = findViewById(R.id.btnDelete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String titleInput = title.getText().toString();
                String singerInp = singer.getText().toString();
                int yearInp = Integer.parseInt(year.getText().toString());
                int starsInp = 0;
                if (Stars.getCheckedRadioButtonId() == R.id.radioButton1) {
                    starsInp = 1;
                } else if (Stars.getCheckedRadioButtonId() == R.id.radioButton2) {
                    starsInp = 2;
                } else if (Stars.getCheckedRadioButtonId() == R.id.radioButton3){
                    starsInp = 3;
                } else if (Stars.getCheckedRadioButtonId() == R.id.radioButton4) {
                    starsInp = 4;
                } else if (Stars.getCheckedRadioButtonId() == R.id.radioButton5) {
                    starsInp = 5;
                }

                db.insertSong(titleInput, singerInp, yearInp, starsInp);

                title.setText("");
                singer.setText("");
                year.setText("");

            }
        });

        showlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }



}