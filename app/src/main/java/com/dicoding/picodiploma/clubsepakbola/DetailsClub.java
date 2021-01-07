package com.dicoding.picodiploma.clubsepakbola;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsClub extends AppCompatActivity {
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_IMG = "extra_img";
    private TextView tv_item_title, tv_item_detail;
    private ImageView img_item_photo;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_club);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Club");

        int clubImage = getIntent().getIntExtra(EXTRA_IMG,0);
        String clubTitle = getIntent().getStringExtra(EXTRA_TITLE);
        String clubDetail = getIntent().getStringExtra(EXTRA_DETAIL);

        tv_item_title = findViewById(R.id.item_title);
        tv_item_title.setText(clubTitle);

        tv_item_detail = findViewById(R.id.item_detail);
        tv_item_detail.setText(clubDetail);

        img_item_photo = findViewById(R.id.item_photo);
        img_item_photo.setImageResource(clubImage);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
