package com.example.tpf2i.services;

import com.example.tpf2i.PersonnageRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonnageService {

    @GET("character")
    Call<PersonnageRoot> getPersonnageList();
}
