package kr.co.ezenac.yyy.teamapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.yyy.teamapp.IntroPageClass.Intro0;
import kr.co.ezenac.yyy.teamapp.IntroPageClass.Intro1;

public class IntroActivity extends FragmentActivity {

    @BindView(R.id.intro_page)    ViewPager intro_page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        ButterKnife.bind(this);
        intro_page.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        intro_page.setCurrentItem(0);




    }

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
                    return new Intro0();
                case 1:
                    return new Intro1();

                default:
                    return null;
            }
        }
        @Override
        public int getCount()
        {
            return 2;
        }
    }

}
