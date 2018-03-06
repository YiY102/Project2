package kr.co.ezenac.yyy.teamapp.Class;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.yyy.teamapp.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-02-08.
 */


@AllArgsConstructor
public class ListViewAdapter extends BaseAdapter{
    Context context;
    ArrayList<ListViewClass>items;



    @Override
    //몇개를 가지고있는가
    public int getCount() {
        return items.size();
    }

    @Override
    //어떤부분을 보여줄것인가
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    //연동부분
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        if (view==null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.listview, viewGroup, false);
            holder.Listview_img =(ImageView)view.findViewById(R.id.Listview_img);
            holder.Listview_name =(TextView) view.findViewById(R.id.Listview_name);
            holder.Listview_adress =(TextView)view.findViewById(R.id.Listview_adress);
            holder.Listview_time =(TextView)view.findViewById(R.id.Listview_time);
            holder.Listview_star =(ImageView)view.findViewById(R.id.Listview_star);
            view.setTag(holder);

        }//리스트뷰.xml이랑 뷰랑 연결
        else {
            holder = (Holder)view.getTag();
        }


        return view;

    }

    private  class  Holder{
        ImageView Listview_img;
        TextView Listview_name;
        TextView  Listview_adress;
        TextView  Listview_time;
        ImageView Listview_star;



    }
}
