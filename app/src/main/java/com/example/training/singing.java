package com.example.training;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class singing extends Activity implements View.OnClickListener {

    Button btn9;
    EditText name,phone,email,gov,education;
    Button buttonAddItem;
    String currentForm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        Bundle b = getIntent ( ).getExtras ( );
        currentForm = "form1";
        if (b != null) currentForm = b.getString ( "form" );
        setContentView ( R.layout.activity_singing );

        name = (EditText) findViewById ( R.id.name );
        phone = (EditText) findViewById ( R.id.phone );
        email = (EditText) findViewById ( R.id.email );
        gov = (EditText) findViewById ( R.id.gov );
        education = (EditText) findViewById ( R.id.education );

        buttonAddItem = (Button) findViewById ( R.id.buttonAddItem );
        buttonAddItem.setOnClickListener ( this );
    }

            //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls
            private void sendToNextForm() {
                final String name1 = name.getText ( ).toString ( ).trim ( );
                final String phone1 = phone.getText ( ).toString ( ).trim ( );
                final String email1 = email.getText ( ).toString ( ).trim ( );
                final String gov1 = gov.getText ( ).toString ( ).trim ( );
                final String education1 = education.getText ( ).toString ( ).trim ( );


                Intent intent = new Intent ( getApplicationContext ( ), transfer.class );
                Bundle b = new Bundle ( );
                b.putString ( "form", currentForm );
                b.putString ( "name", name1 );
                b.putString ( "phone", phone1 );
                b.putString ( "email", email1 );
                b.putString ( "gov", gov1 );
                b.putString ( "education", education1 );
                intent.putExtras ( b );

                startActivity ( intent );
            }

            private void addItemToSheet() {

                final ProgressDialog loading = ProgressDialog.show ( this, "Adding Item", "Please wait" );
                final String name1 = name.getText ( ).toString ( ).trim ( );
                final String phone1 = phone.getText ( ).toString ( ).trim ( );
                final String email1 = email.getText ( ).toString ( ).trim ( );
                final String gov1 = gov.getText ( ).toString ( ).trim ( );
                final String education1 = education.getText ( ).toString ( ).trim ( );


                StringRequest stringRequest = new StringRequest ( Request.Method.POST, "https://script.google.com/macros/s/AKfycbyGIt7Z6zm-ER9S4AcVogzzPSvuOqvqF7oXkC2IgyhAVoeKg4w/exec",
                        new Response.Listener<String> ( ) {
                            @Override
                            public void onResponse(String response) {

                                loading.dismiss ( );
                                Toast.makeText ( singing.this, response, Toast.LENGTH_LONG ).show ( );


                            }
                        },
                        new Response.ErrorListener ( ) {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<> ( );

                        //here we pass params
                        parmas.put ( "action", "addItem" );
                        parmas.put ( "form", currentForm );
                        parmas.put ( "name", name1 );
                        parmas.put ( "phone", phone1 );
                        parmas.put ( "email", email1 );
                        parmas.put ( "gov", gov1 );
                        parmas.put ( "education", education1 );

                        return parmas;
                    }
                };

                int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicy = new DefaultRetryPolicy ( socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT );
                stringRequest.setRetryPolicy ( retryPolicy );

                RequestQueue queue = Volley.newRequestQueue ( this );

                queue.add ( stringRequest );


            }


            @Override
            public void onClick(View v) {

                if(name.length()==0)
                {
                    name.requestFocus();
                    name.setError("FIELD CANNOT BE EMPTY");
                }
                else if(phone.length()==0)
                {
                    phone.requestFocus();
                    phone.setError("FIELD CANNOT BE EMPTY");
                }
                else if(gov.length()==0)
                {
                    gov.requestFocus();
                    gov.setError("FIELD CANNOT BE EMPTY");
                }
                else if(email.length()==0)
                {
                    email.requestFocus();
                    email.setError("FIELD CANNOT BE EMPTY");
                }

                else if(education.length()==0)
                {
                    education.requestFocus();
                    education.setError("FIELD CANNOT BE EMPTY");
                }

                else
                {
                    if (v == buttonAddItem)
                        //addItemToSheet();
                        sendToNextForm ( );

                }




                    //Define what to do when button is clicked
                }
            }


