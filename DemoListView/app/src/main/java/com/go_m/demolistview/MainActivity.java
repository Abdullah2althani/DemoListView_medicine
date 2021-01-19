package com.go_m.demolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Adapter_medicine_item> listnewsData = new ArrayList<Adapter_medicine_item>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.ListView_mainLayout);


        //add data and view it
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_0, "Capsule ", "1/2" + " Piece", "Every " + "3" + " hours"));
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_1, "Lozenges ", "3/4" + " Piece", "Every " + "6" + " hours"));
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_2, "Eye drags ", "2" + " Piece", "Every " + "12" + " hours"));
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_3, "Aspirin ", "4" + " Piece", "Every " + "4" + " hours"));
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_1, "developer", "3" + " Piece", "Every " + "6" + " hours"));
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_2, "developer", "1/2" + " Piece", "Every " + "8" + " hours"));
        myadapter = new MyCustomAdapter(listnewsData);
        listView.setAdapter(myadapter);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Adapter_medicine_item adapterView = listnewsData.get(position);
                TextView name = (TextView) view.findViewById(R.id.DoseName);
                Toast.makeText(getApplicationContext(), "You Selected " + name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void Adding_new_MedicineItem(View view) {
        listnewsData.add(new Adapter_medicine_item(R.drawable.dose_img_1, "developer new", "1/2" + " Piece", "Every " + "8" + " hours"));
        myadapter.notifyDataSetChanged();
    }

    //display news list
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<Adapter_medicine_item> listnewsDataAdpater;

        public MyCustomAdapter(ArrayList<Adapter_medicine_item> listnewsDataAdpater) {
            this.listnewsDataAdpater = listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_medicine, null);

            final Adapter_medicine_item s = listnewsDataAdpater.get(position);

            ImageView image = (ImageView) myView.findViewById(R.id.img);
            image.setImageResource(s.ImgID);
            TextView name = (TextView) myView.findViewById(R.id.DoseName);
            name.setText(s.DoseName);

            TextView quintity = (TextView) myView.findViewById(R.id.Quintity);
            quintity.setText(s.Quintity);

            TextView repatedTimes = (TextView) myView.findViewById(R.id.RepatedTimes);
            repatedTimes.setText(s.RepatedTimes);

            return myView;
        }

    }
}
