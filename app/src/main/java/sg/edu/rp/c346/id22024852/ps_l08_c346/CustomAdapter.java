package sg.edu.rp.c346.id22024852.ps_l08_c346;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

        Context parent_context;
        int layout_id;
        ArrayList<Song> SongList;
        public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
            super(context, resource, objects);

            parent_context = context;
            layout_id = resource;
            SongList = objects;

        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvT= rowView.findViewById(R.id.textViewTitle);
        TextView tvY = rowView.findViewById(R.id.textViewYear);
        TextView tvS = rowView.findViewById(R.id.textViewStars);
        TextView tvA = rowView.findViewById(R.id.textViewArt);

        // Obtain the Android Version information based on the position
       Song current = SongList.get(position);

        // Set values to the TextView to display the corresponding information
       tvT.setText(current.getTitle());
       tvY.setText(current.getYearS());
       tvS.setText(current.getStarS());
       tvA.setText(current.getSinger());

        return rowView;
    }


}
