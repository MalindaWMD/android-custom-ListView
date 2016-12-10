package com.example.malinda.custom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    ListView lstCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstCustom = (ListView)findViewById(R.id.listView);

        String headers[] = {"John Doe", "Alex Robinson","Mika abuleru", "Chris Nonis", "Michael White"};
        String titles[] = {"Sonftware Engineer", "Senior Programmer", "CEO", "Web Designer", "UI Designer"};
        int imageID[] = {R.drawable.im1,R.drawable.im2,R.drawable.im3,R.drawable.im4,R.drawable.im5};

        Vector dataVec = new Vector();

        for(int i = 0;i<headers.length;i++){
            dataTransfer dt = new dataTransfer();
            dt.setHeader(headers[i]);
            dt.setTitle(titles[i]);
            dt.setImageID(imageID[i]);
            dataVec.add(dt);
        }

        lstCustom.setAdapter(new customListAdapter(this,dataVec));

    }

}
