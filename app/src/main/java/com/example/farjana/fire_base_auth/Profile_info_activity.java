package com.example.farjana.fire_base_auth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile_info_activity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    Button save_btn;
    TextView edit_profile_txt,name_txt,designation_txt,department_txt;
    EditText editName;
    Spinner designation_spinner, department_spinner;
    Bitmap bitmap;
    int flag = 0;
    private LayoutInflater inflator = null;
    String imageEncoded,user_name,department_name,designation_name,email;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info_activity);

        firebaseAuth= FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),nav_activity.class));
        }

        initializeAll();

        databaseReference = FirebaseDatabase.getInstance().getReference("User Profile");

        imageView.setOnClickListener(this);
        save_btn.setOnClickListener(this);
    }

    private void initializeAll() {
        imageView = findViewById(R.id.image_icon);
        save_btn = findViewById(R.id.save_btn);
        edit_profile_txt = findViewById(R.id.edit_profile_txt);
        name_txt = findViewById(R.id.name_txt);
        designation_txt = findViewById(R.id.designation_txt);
        department_txt = findViewById(R.id.department_txt);
        editName = findViewById(R.id.edit_name);
        designation_spinner = findViewById(R.id.designation_spinner);
        department_spinner = findViewById(R.id.department_spinner);
        firebaseAuth = FirebaseAuth.getInstance();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 99 && resultCode == RESULT_OK && data != null){
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            flag = 1;
        }
    }

    private void savePicSDcard(Bitmap bitmap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd_HH_mm_ss");
        String string = simpleDateFormat.format(new Date());

        String root = Environment.getExternalStorageDirectory().toString();
        File folder = new File(root+"/Fire_Base_Auth_Images");
        folder.mkdirs();

        File file = new File(folder,string+".png");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, stream);
            stream.flush();
            stream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View view) {
        if ( view == imageView){
            if(flag == 0) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 99);

            }else if(flag == 1){

                savePicSDcard(bitmap);
                Toast.makeText(getApplicationContext(), "Photo saved to SD CARD", Toast.LENGTH_SHORT).show();
             }
        }
        if( view == save_btn){
            if(flag==0){
                Toast.makeText(this,"your image is empty...",Toast.LENGTH_SHORT).show();

            }else {
                save_All_info();
               flag = 0;
            }

        }
    }

    private void save_All_info() {
        user_name = editName.getText().toString().trim();
        department_name = department_spinner.getSelectedItem().toString();
        designation_name = designation_spinner.getSelectedItem().toString();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        email = user.getEmail();
        encodeBitmapAndSaveToFirebase(bitmap);

        if(!(TextUtils.isEmpty(user_name))){
            String id = firebaseAuth.getCurrentUser().getUid();
            User_profile_adder profile_adder = new User_profile_adder(email,user_name,designation_name,department_name,imageEncoded);
            databaseReference.child(id).setValue(profile_adder);
            Toast.makeText(this,"Profile created..",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,nav_activity.class));
        }
        else{
            Toast.makeText(this,"Please Fill up the Name Field....",Toast.LENGTH_SHORT).show();
        }
    }

    public String encodeBitmapAndSaveToFirebase(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        imageEncoded = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
        return imageEncoded;
    }
}

