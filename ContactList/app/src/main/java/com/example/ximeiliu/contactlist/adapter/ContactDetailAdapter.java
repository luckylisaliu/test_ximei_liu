package com.example.ximeiliu.contactlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ximeiliu.contactlist.R;
import com.example.ximeiliu.contactlist.model.DetailInfo;

import java.util.List;

/**
 * Created by ximeiliu on 21/01/17.
 */

public class ContactDetailAdapter extends RecyclerView.Adapter<ContactDetailAdapter.ContactDetailViewHolder> {
    //Store fields for each contact
    private List<DetailInfo> contactFields;

    class ContactDetailViewHolder extends RecyclerView.ViewHolder {
        TextView contactInfoValueView;
        TextView contactInfoView;

        ContactDetailViewHolder(View itemView) {
            super(itemView);
            contactInfoValueView = (TextView) itemView.findViewById(R.id.contact_info);
            contactInfoView = (TextView) itemView.findViewById(R.id.contact_info_value);

        }
    }

    public ContactDetailAdapter(List<DetailInfo> contactFields, Context context) {
        this.contactFields = contactFields;
    }

    @Override
    public void onBindViewHolder(ContactDetailViewHolder holder, int position) {
        holder.contactInfoValueView.setText(contactFields.get(position).getItemValue());
        holder.contactInfoView.setText(contactFields.get(position).getItem());

    }


    @Override
    public ContactDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact_detail, parent, false);
        //return a new holder instance
        return new ContactDetailViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return contactFields == null ? 0 : contactFields.size();

    }
}
