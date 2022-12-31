/* Group du travaille :
 *
 * BENAMAR Zaid   (MBD)
 * AARAB Yasmine  (MBD)
 *
 * */
package com.example.miniproject_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproject_frontend.model.Result;
import com.example.miniproject_frontend.retrofit.ConvertApi;
import com.example.miniproject_frontend.retrofit.RetrofitService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents() {
        Spinner inputFrom = findViewById(R.id.form_textFieldFrom);
        Spinner  inputTo = findViewById(R.id.form_textFieldTo);
        EditText  inputValue = findViewById(R.id.form_textFieldValue);
        TextView inputResult = findViewById(R.id.form_textViewResult);
        Button inputButton = findViewById(R.id.button);

        String[] dropDownList = {"USD", "MAD","EUR","NZD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dropDownList);
        inputFrom.setAdapter(adapter);
        inputTo.setAdapter(adapter);


        RetrofitService retrofitService = new RetrofitService();
        ConvertApi convertApi = retrofitService.getRetrofit().create(ConvertApi.class);

        inputButton.setOnClickListener(view -> {
            String from = String.valueOf(inputFrom.getSelectedItem().toString());
            String to = String.valueOf(inputTo.getSelectedItem().toString());
            String value = String.valueOf(inputValue.getText());

            convertApi.getResult(from, to, value)

                    .enqueue(new Callback<Result>() {
                        @Override
                        public void onResponse(Call<Result> call, Response<Result> response) {
                            inputResult.setText(response.body().getResultat().toString());
                            //Toast.makeText(MainActivity.this, response.body().getResultat().toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Result> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });


        });
}}