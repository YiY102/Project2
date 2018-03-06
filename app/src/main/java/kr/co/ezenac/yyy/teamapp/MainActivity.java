package kr.co.ezenac.yyy.teamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.navdrawer.SimpleSideDrawer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.yyy.teamapp.Class.ListViewAdapter;
import kr.co.ezenac.yyy.teamapp.Class.ListViewClass;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.filipper) ViewFlipper flipper;
    //@BindView(R.id.category) Spinner category;
    @BindView(R.id.sidebar) Button sidebar;
     SimpleSideDrawer side_menu; //사이드바
    @BindView(R.id.listveiw1)   ListView listView1;
    ListViewAdapter listViewAdapter;
    ArrayList<ListViewClass>items = new ArrayList<>();
    @BindView(R.id.FoodStore) Button FoodStore;
    //@BindView(R.id.fontTest)




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);


        //뷰 페이저로 변경할곳
        Animation showln = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        flipper.setInAnimation(showln);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        flipper.setFlipInterval(1500);
        flipper.startFlipping();

        listViewAdapter = new ListViewAdapter(MainActivity.this,items);
        listView1.setAdapter(listViewAdapter);









        /* 스피너 속성 (arrry 로 수정가능)
          ArrayAdapter categoryspinner = ArrayAdapter.createFromResource(this,
                R.array.CategoryList,android.R.layout.simple_spinner_item);

        스피너 목록보여주기
       category.setAdapter(categoryspinner);
        /*글씨체바꾸는 코드 확인o
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/test.ttf");
        fontTest.setTypeface(typeface);*/

       // side_menu = new SimpleSideDrawer(this);
       // side_menu.setLeftBehindContentView(R.layout.sidemenu);

    }
//사이드바메뉴버튼 누르면
    @OnClick(R.id.sidebar)
    public void sidebar(){
        //사이드바

        side_menu.toggleLeftDrawer();
    Button logoutButton = (Button)findViewById(R.id.logoutButton);
    logoutButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            editor.clear();
            editor.commit();
            Toast.makeText(MainActivity.this, "탈퇴하였습니다", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    });

    }
  @OnClick(R.id.FoodStore)
    public void setFoodStore(){
        Intent Foodstore = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(Foodstore);
  }


}
