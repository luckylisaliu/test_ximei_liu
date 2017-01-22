package com.example.ximeiliu.contactlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.ximeiliu.contactlist.R;
import com.example.ximeiliu.contactlist.model.Contact;
import com.example.ximeiliu.contactlist.other.RecyclerItemClickListner;
import com.example.ximeiliu.contactlist.other.RetroClient;
import com.example.ximeiliu.contactlist.other.ApiService;
import com.example.ximeiliu.contactlist.other.ContactsAdapter;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {
    private static final String TAG = ContactActivity.class.getSimpleName();
    private List<Contact> contactList;
    private RecyclerView recyclerView;
    private ContactsAdapter contactsAdapter;

    private ProgressBar circleProgress;
    private TextView progressText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        circleProgress = (ProgressBar) findViewById(R.id.progressBar);
        progressText = (TextView) findViewById(R.id.progreeBarText);

        /*loading animation effect*/
        circleProgress.setVisibility(View.VISIBLE);
        progressText.setVisibility(View.VISIBLE);
        /*loading animation effect*/

        recyclerView = (RecyclerView) findViewById(R.id.userContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        ApiService service = RetroClient.getApiService();

        Call<List<Contact>> call = service.getContactList();


        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (response.isSuccessful()) {
                    contactList = response.body();
                    /*making animaiont effect disappear */
                    circleProgress.setVisibility(View.GONE);
                    progressText.setVisibility(View.GONE);
                    /*making animaiont effect disappear */
                    Log.i(TAG, "Got user numbers :" + contactList.size());
                    contactsAdapter = new ContactsAdapter(contactList, getApplicationContext());
                    recyclerView.setAdapter(contactsAdapter);
                    recyclerView.addOnItemTouchListener(
                            new RecyclerItemClickListner(getApplicationContext(), new RecyclerItemClickListner.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Contact contact = contactList.get(position);

                                    Intent intent = new Intent(getApplicationContext(), ContactDetailActivity.class);
                                    intent.putExtra("NAME", contact.getName());
                                    intent.putExtra("USERNAME", contact.getUserName().toUpperCase());
                                    intent.putExtra("PHONE", contact.getPhone());
                                    intent.putExtra("ADDRESS", contact.getAddress().getCompleteAddress());
                                    intent.putExtra("WEBSITE", contact.getWebsite().toUpperCase());
                                    intent.putExtra("COMPANY", contact.getCompany().getCompanyName().toUpperCase());

                                    startActivity(intent);
                                }
                            })
                    );

                } else {
                    Log.e(TAG, "Fail to fetch Json file");
                }

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                //log error if request fails
                Log.e(TAG, t.toString());

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.sortByAscend:
                //sort alphabetically ascending
                Collections.sort(contactList);
                break;

            case R.id.sortByDescend:
                //sort alphabetically descending
                Collections.sort(contactList, Collections.reverseOrder());
                break;
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        return true;
    }

}
