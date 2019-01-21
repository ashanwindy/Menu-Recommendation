package com.example.caiputuijian.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {

    private Context context = null;
    private List<recommendmenubean> list;
    private LayoutInflater mInflater;

    public MenuAdapter(Context context, List<recommendmenubean> list){
        this.context = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public recommendmenubean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.recommend_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.rec_name);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        recommendmenubean bean = list.get(position);
        viewHolder.name.setText(bean.getName());

        return convertView;
    }

    private static class ViewHolder{
        TextView name;
    }
}
