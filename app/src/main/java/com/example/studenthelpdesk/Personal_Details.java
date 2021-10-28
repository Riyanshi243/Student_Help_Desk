package com.example.studenthelpdesk;

import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Personal_Details extends AppCompatActivity {
    private EditText fullname,fathersname,mothersname,gender,dob,aadhar,phoneno,pan;
    private String fname,fathern,mothern,gender1,dob1,aadar1,phno,pan1;
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        fullname=(EditText) findViewById(R.id.fullname);
        fathersname=(EditText) findViewById(R.id.fathersname);
        mothersname=(EditText) findViewById(R.id.mothersname);
        gender=(EditText) findViewById(R.id.gender);
        dob=(EditText) findViewById(R.id.dob);
        aadhar=(EditText) findViewById(R.id.aadhar);
        phoneno=(EditText) findViewById(R.id.phoneno);
        pan=(EditText) findViewById(R.id.pan);
        show();

    }
    public void show()
    {
        data=SignIn.data;
        fullname.setText(data.getName());
        fathersname.setText(data.getFname());
        mothersname.setText(data.getMname());
        gender.setText(data.getGender());
        dob.setText(data.getDob());
        aadhar.setText(data.getAadhar());
        phoneno.setText(data.getPno());
        pan.setText(data.getPan());
    }
    public void save()
    {

        data=SignIn.data;
        fname=fullname.getText().toString();
        data.setName(fname);
        fathern=fathersname.getText().toString();
        data.setFname(fathern);
        mothern=mothersname.getText().toString();
        data.setMname(mothern);
        gender1=gender.getText().toString();
        data.setGender(gender1);
        dob1=dob.getText().toString();
        data.setDob(dob1);
        aadar1=aadhar.getText().toString();
        data.setAadhar(aadar1);
        phno=phoneno.getText().toString();
        data.setPno(phno);
        pan1=pan.getText().toString();
        data.setPan(pan1);
    }
    public void savedata(View V)
    {
        save();
           //check the constraits
           if(fullname.getText().toString().length()==0)
           {
               fullname.setError("ENTER VALID NAME");
               return;
           }
           if(fathersname.getText().toString().trim().length()==0)
           {
               fathersname.setError("ENTER FATHERS NAME");
               return;
           }
            if(mothersname.getText().toString().trim().length()==0)
           {
               mothersname.setError("ENTER MOTHERS NAME");
               return;
           }
            if(gender.getText().toString().trim().length()==0)
           {
               gender.setError("ENTER GENDER");
               return;
           }
           if(dob.getText().toString().trim().length()==0)
           {
              dob.setError("ENTER DOB");
               return;
           }
           if((pan.getText().toString().length()!=0)&& (pan.getText().toString().length()<10 || pan.getText().toString().trim().length()>10))
           {
              pan.setError("ENTER VALID PAN");
               return;
           }
              if(phoneno.getText().toString().length()<10|| phoneno.getText().toString().trim().length()>10)
              {
                  phoneno.setError("INVALID NUMBER");
                  return;
              }
              else if(phoneno.getText().toString().length()==0)
              {
                phoneno.setError("ENTER NUMBER");
                  return;
              }
              if(aadhar.getText().toString().length()<12||aadhar.getText().toString().trim().length()>12)
              {
                  aadhar.setError("INVALID AADHAR");
                  return;
                  
              }        
               Intent i = new Intent(Personal_Details.this, Academic_data.class);
               startActivity(i);


    }

    @Override
    protected void onResume() {
        super.onResume();
        show();
    }
}