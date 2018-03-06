package kr.co.ezenac.yyy.teamapp.Tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import kr.co.ezenac.yyy.teamapp.R;

/**
 * Created by Administrator on 2018-02-09.
 */

public class Food_two extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.food_two, container, false);
        return layout;
    }
}
