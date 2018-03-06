package kr.co.ezenac.yyy.teamapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import kr.co.ezenac.yyy.teamapp.Class.ScrollClass.ObservableScrollView;
import kr.co.ezenac.yyy.teamapp.Class.ScrollClass.ObservableScrollViewCallbacks;
import kr.co.ezenac.yyy.teamapp.Class.ScrollClass.ScrollState;
import kr.co.ezenac.yyy.teamapp.Class.ScrollClass.ScrollUtils;
import kr.co.ezenac.yyy.teamapp.Class.ScrollClass.ViewHelper;

public class DetailActivity extends AppCompatActivity implements ObservableScrollViewCallbacks{
    private View mImageView;
    private View mToolbarView;
    private ObservableScrollView mScrollView;
    private int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        //화면상단타이틀바 텍스트 변경/ 변수만들어서 변경되게하기
        setTitle("hi");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mImageView = findViewById(R.id.image);
        mToolbarView = findViewById(R.id.toolbar);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.primary)));

        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }
}
