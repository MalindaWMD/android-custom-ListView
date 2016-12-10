package com.example.malinda.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Malinda on 5/2/2016.
 */
public class customListAdapter extends BaseAdapter {

    Context context;
    Vector vector;
    LayoutInflater inflater = null;

    public customListAdapter(Context context, Vector vector){
        this.context = context;
        this.vector = vector;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return vector.size();
    }

    @Override
    public Object getItem(int position) {
        return vector.elementAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // important method

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.customlist, null);

        ///customList is the inflated view
        /// components in inflated view

        ImageView imgImage = (ImageView)view.findViewById(R.id.imageView);
        TextView txtHeader = (TextView)view.findViewById(R.id.textHeader);
        TextView txtTitle = (TextView)view.findViewById(R.id.textViewSub);

        final dataTransfer dt = (dataTransfer) vector.elementAt(position);
        txtHeader.setText(dt.getHeader());
        txtTitle.setText(dt.getTitle());

        Bitmap image = BitmapFactory.decodeResource(view.getResources(),dt.getImageID());
        imgImage.setImageBitmap(image);

        // Set listener for a list item
        // only need to set listener for the view
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,dt.getHeader().toString(),Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
