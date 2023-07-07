package sg.edu.rp.c346.id22024852.ps_l08_c346;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.listView);
        back = findViewById(R.id.buttonBack);
        DBHelper db = new DBHelper(MainActivity2.this);

        ArrayList<Song> data = db.getSongs();
        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}