package es.ciudadescolar.examen2evmariogarcia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class ContactAdapter extends BaseAdapter {
    private Context context;
    private List<Contact> contacts;

    public ContactAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        }

        Contact contact = contacts.get(position);

        ImageView imageView = convertView.findViewById(R.id.contact_image);
        TextView nameView = convertView.findViewById(R.id.contact_name);
        TextView phoneView = convertView.findViewById(R.id.contact_phone);
        TextView emailView = convertView.findViewById(R.id.contact_email);

        imageView.setImageResource(contact.getImageResourceId());
        nameView.setText(contact.getName());
        phoneView.setText(contact.getPhone());
        emailView.setText(contact.getEmail());

        return convertView;
    }
}

