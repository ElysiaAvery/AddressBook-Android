package com.example.guest.addressbook.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

import com.example.guest.addressbook.Constants;
import com.example.guest.addressbook.R;
import com.example.guest.addressbook.models.Contact;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private DatabaseReference mContactReference;
    private Contact mContact;


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
            String name = mContactName.getText().toString().trim();
            String phone = mContactPhone.getText().toString().trim();
            String email = mContactEmail.getText().toString().trim();
            String street = mContactStreet.getText().toString().trim();
            String city = mContactCity.getText().toString().trim();
            String state = mContactState.getText().toString().trim();
            String zip = mContactZip.getText().toString().trim();
            String photo = mContactPhotoURL.getText().toString().trim();
            String social = mContactSocialMedia.getText().toString().trim();
            mContact = new Contact(name, phone, email, street, city, state, zip, photo, social);
            mContactReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CONTACT_QUERY);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference contactRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CONTACT_QUERY)
                    .child(uid);

            DatabaseReference pushRef = contactRef.push();
            String pushId = pushRef.getKey();
            mContact.setPushId(pushId);
            pushRef.setValue(mContact);
            Context context = getApplicationContext();
            CharSequence text = "Saved!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent intent = new Intent(CreateContactActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
