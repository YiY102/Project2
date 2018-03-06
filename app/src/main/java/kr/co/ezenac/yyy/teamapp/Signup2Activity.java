package kr.co.ezenac.yyy.teamapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Signup2Activity extends AppCompatActivity {
    @BindView(R.id.successButton)   LinearLayout successButton;
    @BindView(R.id.topTitle)    TextView toptitle;
    @BindView(R.id.sign_up_suc)    TextView sign_up_suc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up2);
        ButterKnife.bind(this);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ko_font1.ttf");
        Typeface font4 = Typeface.createFromAsset(getAssets(), "fonts/ko_font4.ttf");
        toptitle.setTypeface(font1);
        sign_up_suc.setTypeface(font4);
    }

    @OnClick(R.id.successButton)
    public void setSuccessButton(View view){
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);



    }
}
