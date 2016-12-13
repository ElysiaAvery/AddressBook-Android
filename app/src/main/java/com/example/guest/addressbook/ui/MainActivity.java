package com.example.guest.addressbook.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.guest.addressbook.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.addNewActivityButton) Button mAddButton;
    @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAddButton) {
            Intent intent = new Intent(MainActivity.this, CreateContactActivity.class);
            startActivity(intent);
        }
    }
}
