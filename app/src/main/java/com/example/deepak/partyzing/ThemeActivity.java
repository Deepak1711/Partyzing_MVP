package com.example.deepak.partyzing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created on 25/7/16.
 */
public class ThemeActivity extends AppCompatActivity implements ShowHideInterface, View.OnClickListener {
    private final String title[] = {"Theme 1", "Theme 2", "Theme 3", "Theme 4", "Theme 5", "Theme 6", "Theme 7", "Not decided"};
    private ViewPager viewPager;
    private ItemAdapter adapter;
    private TextView textViewNext;
    private Animation animFadein, animFadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occasion_theme);
        TextView headText = (TextView) findViewById(R.id.text);
        headText.setText(R.string.partyTheme);
        initViews();
        initAnimations();
    }

    //initializing Views,Listeners and adapters
    public void initViews() {
        viewPager = (ViewPager) findViewById(R.id.view_Pager);
        adapter = new ItemAdapter(this, this, title);
        viewPager.setAdapter(adapter);
        textViewNext = (TextView) findViewById(R.id.next);
        textViewNext.setOnClickListener(this);
    }

    //Initializing animations
    public void initAnimations() {
        animFadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
    }

    //Show next button when an item is selected
    @Override
    public void showNext() {
        textViewNext.startAnimation(animFadein);
    }

    //Hide next button when no item is selected
    @Override
    public void hideNext() {
        textViewNext.startAnimation(animFadeout);
    }

    @Override
    public void onClick(View v) {
        int selectedPosition = adapter.getSelectedPosition();        //to get the final selected position
        String selectedTheme = title[selectedPosition];             //selectedTheme is not used for now,as it need to be stored in DB,which is not integrated yet.
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
}

