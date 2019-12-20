package com.example.myapplication.dataModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NoticeModelAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<NoticeModel> data;
    private Context mContext;

    private static class ViewHolder{
        TextView tvTitle,tvDate;
    }

    public NoticeModelAdapter(Context context, ArrayList<NoticeModel> data){
        mInflater=LayoutInflater.from(context);
        this.data = data;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.notice_list_item,parent,false);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvDate = convertView.findViewById(R.id.tv_date);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvDate.setText(data.get(position).getDate());

        return convertView;
    }

}
