package com.tzuhung.guessnumber1a2b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class guessreply extends AppCompatActivity {
    static int Answer[] = new int[4];
    static int GrandTotalCount = 0;
    static String guestresult ="";
    private TextView mTV_ans,mTV_prompt,mTV_count,mbtn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessreply);
        init();
        TV_show();
    }
    private void TV_show(){
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            guestresult = bundle.getString("guestresult");
            Answer = bundle.getIntArray("Answer");
            GrandTotalCount = bundle.getInt("GrandTotalCount");
        }
        if(guestresult.equals("4A0B")){
            mTV_ans.setText("O");
            mTV_prompt.setText("答對了");
            mTV_count.setText("總共花了"+GrandTotalCount+"次");
            mbtn_back.setText("再來一局");
        }else{
            mTV_ans.setText("X");
            mTV_prompt.setText(guestresult);
            mbtn_back.setText("繼續");
        }
    }
    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        if(!(guestresult.equals("4A0B"))){
            Bundle bundle = new Bundle();
            bundle.putIntArray("Answer",Answer);
            bundle.putInt("GrandTotalCount",GrandTotalCount);
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    private void init(){
        mTV_ans = findViewById(R.id.TV_ans);
        mTV_prompt = findViewById(R.id.TV_prompt);
        mTV_count = findViewById(R.id.TV_count);
        mbtn_back = findViewById(R.id.btn_back);
    }
}