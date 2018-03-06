package kr.co.ezenac.yyy.teamapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.nextstepButton)    LinearLayout nextstepButton;

    //@BindView(R.id.IdInput_sign)
    EditText IdInput_sign;
  //  @BindView(R.id.PasswordInput_sign) EditText PasswordInput_sign;
 //   @BindView(R.id.sign_up_Button)    Button sign_up_Button;

    SharedPreferences pref ;
    SharedPreferences.Editor editor ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        ButterKnife.bind(this);
        Typeface englishfont1 = Typeface.createFromAsset(getAssets(),"fonts/englishfont1.ttf");
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ko_font1.ttf");
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

     //   sign_up_Button.setTypeface(font1);
     //   IdInput_sign.setTypeface(englishfont1);
     //   PasswordInput_sign.setTypeface(englishfont1);


    }
    @OnClick(R.id.nextstepButton)
    public void setNextstepButton(View view){
        Intent intent = new Intent(this,Signup2Activity.class);
        startActivity(intent);
    }




/*  @OnClick(R.id.sign_up_Button)
    public void sign_up_finsh(View view){
        Log.d("errorcheck","회원가입버튼클릭");


        String id = IdInput_sign.getText().toString();
        String password = PasswordInput_sign.getText().toString();
        //id입력
        editor.putString("ID",id);
        editor.putString("Password",password);
        editor.commit();
        Log.d("errorcheck"," 가입확인ID//pass : "+pref.getString("ID","") +"//"+pref.getString("Password",""));

        finish();

        Toast.makeText(getApplicationContext(),"회원가입에 성공헀습니다",Toast.LENGTH_SHORT).show();
    }
*/
}