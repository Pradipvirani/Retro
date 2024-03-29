package com.example.register_retrofit_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText name,email,password;
    Button submit;
    String sname,semail,spassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.edit_name);
        email=findViewById(R.id.edit_email);
        password=findViewById(R.id.edit_password);

        submit=findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.getText().toString().equals("")){
                    name.setError("empty field ",getResources().getDrawable(R.drawable.baseline_error_24));
                }
                sname=name.getText().toString();
                semail=email.getText().toString();
                spassword=password.getText().toString();


                retro_instance.callApi().MODEL_CLASS_CALL(sname,semail,spassword).enqueue(new Callback<model_class>() {
                    @Override
                    public void onResponse(Call<model_class> call, Response<model_class> response) {
                        Log.d("TTT", "onResponse: "+response.body().toString());

                        Log.d("TTT", "onResponse: Connection"+response.body().connection);
                        if(response.body().result==1){

                            Toast.makeText(MainActivity.this, "successfully register", Toast.LENGTH_LONG).show();
                        } else if (response.body().result==2) {
                            Toast.makeText(MainActivity.this, "Already register", Toast.LENGTH_LONG).show();

                        }else if(response.body().result==0){
                            Toast.makeText(MainActivity.this, "somthing went wrong", Toast.LENGTH_LONG).show();


                        }
                    }

                    @Override
                    public void onFailure(Call<model_class> call, Throwable t) {

                    }
                });

            }
        });





    }
}