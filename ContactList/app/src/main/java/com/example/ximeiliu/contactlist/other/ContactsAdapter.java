package com.example.ximeiliu.contactlist.other;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ximeiliu.contactlist.R;
import com.example.ximeiliu.contactlist.model.Contact;

import java.util.List;

/**
 * Created by ximeiliu on 20/01/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private List<Contact> contacts;


    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView emailTextView;

        ContactViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            emailTextView = (TextView) itemView.findViewById(R.id.contact_email);
        }
    }

    public ContactsAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact, parent, false);
        //return a new holder instance
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.nameTextView.setText(contacts.get(position).getName());
        holder.emailTextView.setText(contacts.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return contacts == null ? 0 : contacts.size();
    }

}
