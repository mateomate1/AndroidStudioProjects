package com.example.examen2ev_mariogarcia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        }

        Contact contact = contactList.get(position);

        ImageView imageView = convertView.findViewById(R.id.contactImage);
        TextView nameTextView = convertView.findViewById(R.id.contactName);
        TextView phoneTextView = convertView.findViewById(R.id.contactPhone);
        TextView emailTextView = convertView.findViewById(R.id.contactEmail);

        imageView.setImageResource(contact.getImageResourceId());
        nameTextView.setText(contact.getName());
        phoneTextView.setText(contact.getPhone());
        emailTextView.setText(contact.getEmail());

        return convertView;
    }
}
