package com.example.guest.addressbook.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.addressbook.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateContactActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.contactName) EditText mContactName;
    @Bind(R.id.contactPhone) EditText mContactPhone;
    @Bind(R.id.contactEmail) EditText mContactEmail;
    @Bind(R.id.contactStreet) EditText mContactStreet;
    @Bind(R.id.contactCity) EditText mContactCity;
    @Bind(R.id.contactState) EditText mContactState;
    @Bind(R.id.contactZip) EditText mContactZip;
    @Bind(R.id.contactPhotoUrl) EditText mContactPhotoURL;
    @Bind(R.id.contactSocialMedia) EditText mContactSocialMedia;
    @Bind(R.id.addContactButton) Button mAddContactButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        ButterKnife.bind(this);

        mAddContactButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAddContactButton) {

        }
    }
}
