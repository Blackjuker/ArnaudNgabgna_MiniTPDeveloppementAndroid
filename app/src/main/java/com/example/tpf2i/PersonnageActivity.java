package com.example.tpf2i;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.tpf2i.adapter.PersonnageAdapter;
import com.example.tpf2i.model.Personnage;
import com.example.tpf2i.services.PersonnageService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonnageActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private PersonnageService personnageService;


    private static final String BASE_URL = "https://api.disneyapi.dev/";

    private Thread thread;

    private RecyclerView recyclerViewPersonnage;
    private PersonnageAdapter personnageAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Call<PersonnageRoot> personnageRootCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        recyclerViewPersonnage = findViewById(R.id.personnageRecycler);

        layoutManager = new GridLayoutManager(getApplicationContext(),2);



        // Client Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        personnageService = retrofit.create(PersonnageService.class);


        personnageRootCall = personnageService.getPersonnageList();


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Response<PersonnageRoot> response = personnageRootCall.execute();

                    if(response.isSuccessful()){
                        List<Personnage> personnageList = response.body().getPersonnageList();

                        //Log.i("xxxxx",String.valueOf(personnageList.size()));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                personnageAdapter = new PersonnageAdapter(
                                        getApplicationContext(),
                                        personnageList
                                );

                                // Connecter le recyclerView à l'adapter
                                recyclerViewPersonnage.setAdapter(personnageAdapter);
                                recyclerViewPersonnage.setLayoutManager(layoutManager);
                                recyclerViewPersonnage.setHasFixedSize(true);
                            }
                        });
                    }

                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

    }
}