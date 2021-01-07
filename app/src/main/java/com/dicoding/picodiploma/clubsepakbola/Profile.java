package com.dicoding.picodiploma.clubsepakbola;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}