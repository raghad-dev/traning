package com.example.training;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class transfer extends Activity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 123;

    Button buttonAddItem1;
    Button btnPick;
    String p_name, p_phone, p_email, p_gov, p_education;
    String currentForm;

    ImageView imageViewTransfer;
    String transferImage;
    Bitmap rbitmap;

    int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_transfer );

        imageViewTransfer=(ImageView)findViewById(R.id.myImageView);
        //imageView = (ImageView) findViewById ( R.id.myImageView );


        //myimage =(ImageView) findViewById ( R.id.myImageView );

        Bundle b = getIntent().getExtras();
        currentForm = "form1";
        if(b != null) currentForm = b.getString("form");
        if(b != null) p_name = b.getString("name");
        if(b != null) p_phone = b.getString("phone");
        if(b != null) p_email = b.getString("email");
        if(b != null) p_gov = b.getString("gov");
        if(b != null) p_education = b.getString("education");

        buttonAddItem1=(Button) findViewById(R.id.bank11);
        buttonAddItem1.setOnClickListener(this);

        btnPick = findViewById ( R.id.btnPickImage );
        btnPick.setOnClickListener(this);

        /*
        btnPick.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( );
                intent.setType ( "image/*" );
                intent.setAction ( Intent.ACTION_GET_CONTENT );
                startActivityForResult ( Intent.createChooser ( intent, "ارفاق" ), GALLERY_REQUEST_CODE );

            }
        } );
        */

    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);

    }


    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);

        return encodedImage;
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                rbitmap = getResizedBitmap(bitmap,250);//Setting the Bitmap to ImageView
                transferImage = getStringImage(rbitmap);
                imageViewTransfer.setImageBitmap(rbitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
/*
    private void uploadToDrive() {
        StringRequest stringRequest = new StringRequest( Request.Method.POST, "https://www.googleapis.com/upload/drive/v3/files?uploadType=media",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(transfer.this,response,Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<> ();

                //here we pass params
                parmas.put("file","addItem");

                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy (socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);
    }
*/
    private void   addItemToSheet() {

        final ProgressDialog loading = ProgressDialog.show(this,"يتم ارسال طلبك","فضلا انتظر");
        final String name1 = p_name.toString().trim();
        final String phone1 = p_phone.toString().trim();
        final String email1 = p_email.toString().trim();
        final String gov1 = p_gov.toString().trim();
        final String education1 = p_education.toString().trim();

        //final String myimage = imageView.getResources().toString().trim();




        StringRequest stringRequest = new StringRequest( Request.Method.POST, "https://script.google.com/macros/s/AKfycbyGIt7Z6zm-ER9S4AcVogzzPSvuOqvqF7oXkC2IgyhAVoeKg4w/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(transfer.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),regesterDone.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<> ();

                //here we pass params
                parmas.put("action","addItem");
                parmas.put("form",currentForm);
                parmas.put("name",name1);
                parmas.put("phone",phone1);
                parmas.put("email",email1);
                parmas.put("gov",gov1);
                parmas.put("education",education1);
                parmas.put("image",transferImage);

                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy (socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }



    @Override
    public void onClick(View v) {
        if(v==buttonAddItem1){
            addItemToSheet();


            //Define what to do when button is clicked
        }
        if(v == btnPick){
            showFileChooser();
        }
    }

}
