package com.example.ximeiliu.contactlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ximeiliu.contactlist.R;
import com.example.ximeiliu.contactlist.model.ItemInfo;
import com.example.ximeiliu.contactlist.other.ContactDetailAdapter;

import java.util.ArrayList;

import java.util.List;

public class ContactDetailActivity extends AppCompatActivity {
    private List<ItemInfo> inforList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        this.setTitle(name);
        this.buildInfoList(intent);

        this.setTitle(name);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.contactDetail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        ContactDetailAdapter contactDetailAdapter = new ContactDetailAdapter(inforList, getApplicationContext());
        recyclerView.setAdapter(contactDetailAdapter);
    }

    private void buildInfoList(Intent intent) {
        inforList = new ArrayList<>();

        inforList.add(new ItemInfo(intent.getStringExtra("USERNAME"), "USERNAME"));
        inforList.add(new ItemInfo(intent.getStringExtra("PHONE"), "PHONE"));
        inforList.add(new ItemInfo(intent.getStringExtra("ADDRESS"), "ADDRESS"));
        inforList.add(new ItemInfo(intent.getStringExtra("WEBSITE"), "WEBSITE"));
        inforList.add(new ItemInfo(intent.getStringExtra("COMPANY"), "COMPANY"));

    }


}
