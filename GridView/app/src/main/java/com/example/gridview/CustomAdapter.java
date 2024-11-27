package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] titles;
    private String[] subtitles;
    private int[] images;

    public CustomAdapter(Context context, String[] titles, String[] subtitles, int[] images) {
        this.context = context;
        this.titles = titles;
        this.subtitles = subtitles;
        this.images = images;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView title = convertView.findViewById(R.id.title);
        TextView subtitle = convertView.findViewById(R.id.subtitle);

        imageView.setImageResource(images[position]);
        title.setText(titles[position]);
        subtitle.setText(subtitles[position]);

        return convertView;
    }
}