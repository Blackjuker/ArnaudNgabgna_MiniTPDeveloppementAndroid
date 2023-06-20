package com.example.tpf2i;

import com.example.tpf2i.model.Personnage;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonnageRoot {

    @SerializedName("data")
    private List<Personnage> personnageList;

    public PersonnageRoot(List<Personnage> personnageList) {
        this.personnageList = personnageList;
    }

    public List<Personnage> getPersonnageList() {
        return personnageList;
    }

    public void setPersonnageList(List<Personnage> personnageList) {
        this.personnageList = personnageList;
    }
}
