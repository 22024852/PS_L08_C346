package sg.edu.rp.c346.id22024852.ps_l08_c346;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    Button back;
    Button stars;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.listView);
        back = findViewById(R.id.buttonBack);
        stars = findViewById(R.id.btn5stars);
        spn = findViewById(R.id.spinner);

        DBHelper db = new DBHelper(MainActivity2.this);

        ArrayList<Song> data = db.getSongs();
        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = data.get(position);
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("song", song);
                startActivity(i);

            }
        });
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DBHelper db = new DBHelper(MainActivity2.this);
                switch (position){
                    case 0:
                        data.clear();
                        ArrayList<Song> allSongs = db.getSongs();
                        data.addAll(allSongs);
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        data.clear();
                        ArrayList<Song> year2021 = db.getYearSong("2021");
                        data.addAll(year2021);
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        data.clear();
                        ArrayList<Song> year2022 = db.getYearSong("2022");
                        data.addAll(year2022);
                        adapter.notifyDataSetChanged();
                        break;
                    case 3:
                        data.clear();
                        ArrayList<Song> year2023 = db.getYearSong("2023");
                        data.addAll(year2023);
                        adapter.notifyDataSetChanged();
                        break;
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity2.this);
                data.clear();
                ArrayList<Song> FiveSongs = db.get5stars();
                data.addAll(FiveSongs);
                adapter.notifyDataSetChanged();
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}