package com.example.ximeiliu.contactlist.other;

import retrofit2.Call;
import retrofit2.http.GET;


import com.example.ximeiliu.contactlist.model.Contact;

import java.util.List;

/**
 * Created by ximeiliu on 20/01/17.
 */

public interface ApiService {
    @GET("/users")
    Call<List<Contact>> getContactList();
}
