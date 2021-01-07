package com.dicoding.picodiploma.clubsepakbola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dicoding.picodiploma.clubsepakbola.adapter.ListClub;
import com.dicoding.picodiploma.clubsepakbola.model.Club;
import com.dicoding.picodiploma.clubsepakbola.model.ClubData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean btnBackToExit = false;
    private RecyclerView rvClub;
    private ArrayList<Club> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (getSupportActionBar()).setTitle("Club Sepakbola Inggris");

        rvClub =findViewById(R.id.rv_clubs);
        rvClub.setHasFixedSize(true);

        list.addAll(ClubData.getListData());
        showRecyclerList();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_utama, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about_me:
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    private void showRecyclerList() {
        rvClub.setLayoutManager(new LinearLayoutManager(this));
        ListClub ListClub = new ListClub(list);
        rvClub.setAdapter(ListClub);
        ListClub.setOnItemClickCallBack(new ListClub.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Club data) {
                showSelectedClub(data);
            }
        });
    }

    private void showSelectedClub(Club Club){
        Intent intentDetail = new Intent(MainActivity.this,DetailsClub.class);
        intentDetail.putExtra(DetailsClub.EXTRA_TITLE,Club.getTitle());
        intentDetail.putExtra(DetailsClub.EXTRA_DETAIL,Club.getDetail());
        intentDetail.putExtra(DetailsClub.EXTRA_IMG,Club.getPhoto());
        startActivity(intentDetail);
    }

    @Override
    public void onBackPressed() {
        if (btnBackToExit) {
            super.onBackPressed();
            return;
        }

        this.btnBackToExit = true;
        Toast.makeText(this, "Press again to exit the app", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                btnBackToExit = false;
            }
        }, 2000);
    }
}