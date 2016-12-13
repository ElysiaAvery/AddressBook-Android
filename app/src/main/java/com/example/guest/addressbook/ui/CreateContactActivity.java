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

    private void createNewContact() {
        final String name = mContactName.getText().toString().trim();
        final String phone = mContactPhone.getText().toString().trim();
        final String email = mContactEmail.getText().toString().trim();
        final String street = mContactStreet.getText().toString().trim();
        final String city = mContactCity.getText().toString().trim();
        final String state = mContactState.getText().toString().trim();
        final String zip = mContactZip.getText().toString().trim();
        final String photo = mContactPhotoURL.getText().toString().trim();
        final String social = mContactSocialMedia.getText().toString().trim();
        boolean validName = isValidName(name);
        boolean validPhone = isValidPhone(phone);
        boolean validEmail = isValidEmail(email);
        boolean validStreet = isValidStreet(street);
        boolean validCity = isValidCity(city);
        boolean validState = isValidState(state);
        boolean validZip = isValidZip(zip);
        boolean validPhoto = isValidPhoto(photo);
        boolean validSocial = isValidSocialMedia(social);
        if (!validName || !validPhone || !validEmail || !validStreet || !validCity || !validState || !validZip || !validPhoto || !validSocial ) return;
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

    private boolean isValidName(String name) {
        if (name.equals("")) {
            mContactName.setError("Please enter a valid name!");
            return false;
        }
        return true;
    }

    private boolean isValidPhone(String phone) {
        if (phone.equals("")) {
            mContactPhone.setError("Please enter a valid phone number!");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        boolean isGoodEmail =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mContactEmail.setError("Please enter a valid email address!");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidStreet(String street) {
        if (street.equals("")) {
            mContactStreet.setError("Please enter a valid street address!");
            return false;
        }
        return true;
    }

    private boolean isValidCity(String city) {
        if (city.equals("")) {
            mContactCity.setError("Please enter a valid city!");
            return false;
        }
        return true;
    }

    private boolean isValidState(String state) {
        if (state.equals("")) {
            mContactState.setError("Please enter a valid state!");
            return false;
        }
        return true;
    }

    private boolean isValidZip(String zip) {
        if (zip.equals("")) {
            mContactZip.setError("Please enter a valid zip code!");
            return false;
        }
        return true;
    }

    private boolean isValidPhoto(String photo) {
        if (photo.equals("")) {
            mContactPhotoURL.setError("Please enter a valid photo url!");
            return false;
        }
        return true;
    }

    private boolean isValidSocialMedia(String social) {
        if (social.equals("")) {
            mContactSocialMedia.setError("Please enter a valid social url!");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v == mAddContactButton) {
            createNewContact();
        }
    }
}
