/* Group du travaille :
 *
 * BENAMAR Zaid   (MBD)
 * AARAB Yasmine  (MBD)
 *
 * */

package com.example.miniproject_frontend.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("resultat")
    @Expose
    private Float resultat;

    public Float getResultat() {
        return resultat;
    }

    public void setResultat(Float resultat) {
        this.resultat = resultat;
    }
}
