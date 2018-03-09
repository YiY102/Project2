package kr.co.ezenac.yyy.teamapp.Tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.yyy.teamapp.R;

/**
 * Created by voler on 2018-03-06.
 */

public class Food_one_Adapter extends BaseAdapter {

    Context context;
    ArrayList<Food_one_Item> food_one_itemArrayList = new ArrayList<>();

    public Food_one_Adapter (Context context, ArrayList<Food_one_Item> food_one_itemArrayList) {
        this.context = context;
        this.food_one_itemArrayList = food_one_itemArrayList;
    }

    @Override
    public int getCount() {
        return food_one_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return food_one_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.food_one_row, parent, false);
            holder.food_one_row_text1 = convertView.findViewById(R.id.food_one_row_text1);
            holder.food_one_row_text2 = convertView.findViewById(R.id.food_one_row_text2);
            holder.food_one_row_text3 = convertView.findViewById(R.id.food_one_row_text3);
            holder.food_one_row_text4 = convertView.findViewById(R.id.food_one_row_text4);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.food_one_row_text1.setText(food_one_itemArrayList.get(position).getBizesNm());
        holder.food_one_row_text2.setText(food_one_itemArrayList.get(position).getIndsSclsNm());
        holder.food_one_row_text3.setText(food_one_itemArrayList.get(position).getLnoAdr());
        holder.food_one_row_text4.setText(food_one_itemArrayList.get(position).getRdnmAdr());
        return convertView;
    }

    private class Holder {
        TextView food_one_row_text1;
        TextView food_one_row_text2;
        TextView food_one_row_text3;
        TextView food_one_row_text4;
    }
}
