package kr.co.ezenac.yyy.teamapp.IntroPageClass;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.yyy.teamapp.LoginActivity;
import kr.co.ezenac.yyy.teamapp.R;

/**
 * Created by Administrator on 2018-02-21.
 */

public class Intro1 extends Fragment {
    @BindView(R.id.testbutton) Button testbutton;
    @BindView(R.id.topText)    TextView topText;
    @BindView(R.id.topText1)    TextView topText1;
    @BindView(R.id.topText2)    TextView topText2;
    @BindView(R.id.topText3)    TextView topText3;
    @BindView(R.id.topText4)    TextView topText4;

    public Intro1()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.intro1, container, false);
        ButterKnife.bind(this,layout);
        Typeface ko_font3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ko_font3.ttf");
        Typeface ko_font4 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ko_font4.ttf");
        topText.setTypeface(ko_font3);
        topText1.setTypeface(ko_font3);
        topText2.setTypeface(ko_font4);
        topText3.setTypeface(ko_font4);
        topText4.setTypeface(ko_font4);

        return layout;
    }
    @OnClick(R.id.testbutton)
    public void test(){
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);

    }
}