package kr.co.ezenac.yyy.teamapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.yyy.teamapp.Tab.Food_five;
import kr.co.ezenac.yyy.teamapp.Tab.Food_four;
import kr.co.ezenac.yyy.teamapp.Tab.Food_one;
import kr.co.ezenac.yyy.teamapp.Tab.Food_six;
import kr.co.ezenac.yyy.teamapp.Tab.Food_three;
import kr.co.ezenac.yyy.teamapp.Tab.Food_two;

public class FoodActivity extends AppCompatActivity {
    @BindView(R.id.ViewScreen) ViewPager ViewScreen;
    @BindView(R.id.hansik) TextView hansik;
    @BindView(R.id.ilsik) TextView ilsik;
    @BindView(R.id.joongsik) TextView joongsik;
    @BindView(R.id.yangsik) TextView yangsik;
    @BindView(R.id.hamberger) TextView hamberger;
    @BindView(R.id.boonsik) TextView boonsik;
    @BindView(R.id.TabBar) LinearLayout TabBar;
    @BindView(R.id.topFood) TextView topFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        ButterKnife.bind(this);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ko_font1.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/ko_font2.ttf");
        Typeface font3 = Typeface.createFromAsset(getAssets(), "fonts/ko_font3.ttf");
        Typeface font4 = Typeface.createFromAsset(getAssets(), "fonts/ko_font4.ttf");
        topFood.setTypeface(font4);
        ilsik.setTypeface(font2);
        joongsik.setTypeface(font2);
        yangsik.setTypeface(font2);
        hamberger.setTypeface(font2);
        boonsik.setTypeface(font2);



        //뷰랑 어댑터연결
        ViewScreen.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        ViewScreen.setCurrentItem(0);
        //앱실행하면 첫번째 탭으로 초기화

        hansik.setOnClickListener(movePageListener);
        hansik.setTag(0);
        ilsik.setOnClickListener(movePageListener);
        ilsik.setTag(1);
        joongsik.setOnClickListener(movePageListener);
        joongsik.setTag(2);
        yangsik.setOnClickListener(movePageListener);
        yangsik.setTag(3);
        hamberger.setOnClickListener(movePageListener);
        hamberger.setTag(4);
        boonsik.setOnClickListener(movePageListener);
        boonsik.setTag(5);

        hansik.setSelected(true);
        //페이지변화가있으면 호출되는부분이래요,
        ViewScreen.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i =0;
                while (i<6){
                    if (position==i){
                        TabBar.findViewWithTag(i).setSelected(true);
                    }else {
                        TabBar.findViewWithTag(i).setSelected(false);
                    }
                    i++;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }
//탭화면 스왚,클릭//while문 통해 현재선택활성화 그외 비활성화
    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            int i =0;
            while (i<6){
                if (tag==i){
                    TabBar.findViewWithTag(i).setSelected(true);
                }else {
                    TabBar.findViewWithTag(i).setSelected(false);
                }
                i++;
            }
            ViewScreen.setCurrentItem(tag);

        }
    };
//탭화면 어댑터연결
    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            switch(position)
            {
                case 0:
                    return new Food_one();
                case 1:
                    return new Food_two();
                case 2:
                    return new Food_three();
                case 3:
                    return new Food_four();
                case 4:
                    return new Food_five();
                case 5:
                    return new Food_six();

                default:
                    return null;
            }
        }
        @Override
        public int getCount()
        {
            return 6;
        }
    }
}


