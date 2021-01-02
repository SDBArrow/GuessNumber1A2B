package com.tzuhung.guessnumber1a2b;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    static int Answer[] = new int [4];
    static int finalchose[] = new int [4];
    static int GrandTotalCount = 0;
    static int chosenumber = 0;
    static int chosecount = 0;
    private Button mbtn_check;
    private TextView mTV_chose0,mTV_chose1,mTV_chose2,mTV_chose3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Answerchose();
    }

    public void click0(View v) {
        chosenumber = 0;
        inputnumber();
    }
    public void click1(View v) {
        chosenumber = 1;
        inputnumber();
    }
    public void click2(View v) {
        chosenumber = 2;
        inputnumber();
    }
    public void click3(View v) {
        chosenumber = 3;
        inputnumber();
    }
    public void click4(View v) {
        chosenumber = 4;
        inputnumber();
    }
    public void click5(View v) {
        chosenumber = 5;
        inputnumber();
    }
    public void click6(View v) {
        chosenumber = 6;
        inputnumber();
    }
    public void click7(View v) {
        chosenumber = 7;
        inputnumber();
    }
    public void click8(View v) {
        chosenumber = 8;
        inputnumber();
    }
    public void click9(View v) {
        chosenumber = 9;
        inputnumber();
    }
    public void clickback(View v) {
        delnumber();
    }
    public void check(View v) {
        GrandTotalCount++;
        String guestresult = Comparison();
        Intent intent = new Intent(this, guessreply.class);
        Bundle bundle = new Bundle();
        bundle.putString("guestresult",guestresult);
        bundle.putIntArray("Answer",Answer);
        bundle.putInt("GrandTotalCount",GrandTotalCount);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void restart(View v) {
        mTV_chose0.setText("");
        mTV_chose1.setText("");
        mTV_chose2.setText("");
        mTV_chose3.setText("");
        randommake();
        GrandTotalCount = 0;
        chosecount = 0;
        showToast("已重新計算");
    }

    private void inputnumber(){
        if(chosecount == 0){
            mTV_chose0.setText(String.valueOf(chosenumber));
            chosecount++;
        }else if (chosecount == 1){
            mTV_chose1.setText(String.valueOf(chosenumber));
            chosecount++;
        }else if (chosecount == 2){
            mTV_chose2.setText(String.valueOf(chosenumber));
            chosecount++;
        }else if (chosecount == 3){
            mTV_chose3.setText(String.valueOf(chosenumber));
            mbtn_check.setEnabled(true);
            chosecount++;
        }
    }
    private void delnumber(){
        if(chosecount == 4){
            mbtn_check.setEnabled(false);
            mTV_chose3.setText("");
            chosecount--;
        }else if (chosecount == 3){
            mTV_chose2.setText("");
            chosecount--;
        }else if (chosecount == 2){
            mTV_chose1.setText("");
            chosecount--;
        }else if (chosecount == 1){
            mTV_chose0.setText("");
            chosecount--;
        }
    }
    private void Answerchose(){
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            Answer = bundle.getIntArray("Answer");
            GrandTotalCount = bundle.getInt("GrandTotalCount");
        }else{
            randommake();
        }
        chosecount = 0;
        //TextView mTV_title = findViewById(R.id.TV_title);
        //mTV_title.setText(String.valueOf(Answer[0])+String.valueOf(Answer[1])+String.valueOf(Answer[2])+String.valueOf(Answer[3]));
    }
    private void randommake(){
        for (int i = 0 ; i <= 3 ; i++){
            Answer[i] = (int)(Math.random()*10);
            for ( int j = 0 ; j < i ; j++)
            {
                if(Answer[i] == Answer[j]){
                    i--;
                    break;
                }
            }
        }
    }
    private String Comparison(){
        int A = 0; int B = 0;
        finalchose[0] = Integer.parseInt(mTV_chose0.getText().toString());
        finalchose[1] = Integer.parseInt(mTV_chose1.getText().toString());
        finalchose[2] = Integer.parseInt(mTV_chose2.getText().toString());
        finalchose[3] = Integer.parseInt(mTV_chose3.getText().toString());
        for (int i = 0 ; i <= 3 ; i++){
            if ( finalchose[i] == Answer[i]){
                A++;
            }else{
                for ( int j = 0 ; j <= 3 ; j++){
                    if (finalchose[i] == Answer[j]){
                        B++;
                    }
                }
            }
        }
        return(A+"A"+B+"B");
    }
    private void init(){
        mTV_chose0 = findViewById(R.id.TV_chose0);
        mTV_chose1 = findViewById(R.id.TV_chose1);
        mTV_chose2 = findViewById(R.id.TV_chose2);
        mTV_chose3 = findViewById(R.id.TV_chose3);
        mbtn_check = findViewById(R.id.btn_check);
    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}