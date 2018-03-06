package kr.co.ezenac.yyy.teamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {



    @BindView(R.id.IdInput) EditText IdInput;
    @BindView(R.id.PasswordInput) EditText PasswordInput;
    @BindView(R.id.loginButton)    Button loginButton;
    @BindView(R.id.sign_upButton) Button sign_upButton;
    @BindView(R.id.facebookButton) Button facebookButton;
    @BindView(R.id.naverButton) Button naverButton;
    @BindView(R.id.kakaoButton) Button kakaoButton;
    String id;
    String Password;
    Boolean loginCheck ;/**/
    SharedPreferences pref ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ko_font1.ttf");
        Typeface englishfont1 = Typeface.createFromAsset(getAssets(),"fonts/englishfont1.ttf");


        pref = getSharedPreferences("pref", MODE_PRIVATE);
        editor = pref.edit();
       //버튼 폰트
        loginButton.setTypeface(font1);
        sign_upButton.setTypeface(font1);
        facebookButton.setTypeface(font1);
        naverButton.setTypeface(font1);
        kakaoButton.setTypeface(font1);

        IdInput.setTypeface(englishfont1);
        PasswordInput.setTypeface(englishfont1);
        id = pref.getString("ID",null);
        Password = pref.getString("Password",null);

        //아이디,패스워드칸이 아닐시, 아이디와 패스워드가 일치하면 자동로그인
        if (id != null && Password != null){
            if (id.equals(pref.getString("ID", "")) && Password.equals(pref.getString("Password", ""))) {
                Toast.makeText(this, "자동 로그인 완료", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }

    } //onCreate 끝

    //로그인버튼 클릭
    @OnClick(R.id.loginButton)
    public void login(View view) {

        String login_id = IdInput.getText().toString();
        String login_password = PasswordInput.getText().toString();

        //아이디와 패스워드가 빈칸이면
        if (login_id != null && login_password !=null) {
            if (login_id.equals("") || login_password.equals("")) {
                Toast.makeText(this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                return;
            }

            //입력한 텍스트 와 pref.id 비교  && 입력한 텍스트와 pref.password 비교
            if (login_id.equals(pref.getString("ID", "")) && login_password.equals(pref.getString("Password", ""))) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
            }
        }


    }




    //회원가입버튼 클릭
    @OnClick(R.id.sign_upButton)
    public void sign_up(View view){


        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.facebookButton)
    public void facebook(View view){

    }
    @OnClick(R.id.naverButton)
    public void naverButton(View view){

    }

}//끝

