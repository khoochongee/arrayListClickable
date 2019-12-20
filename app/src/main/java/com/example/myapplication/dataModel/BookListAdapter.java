package com.example.myapplication.dataModel;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.BookProfile;
import com.example.myapplication.R;
import com.example.myapplication.dataModel.BookList;
import com.example.myapplication.libraryFunctions.bookSearch;

import java.util.ArrayList;

public class BookListAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private ArrayList<BookList> dataSet;
    private Context context;

    private static class ViewHolder{
        TextView tvBookName;
        TextView tvBookStatus;
    }

    public BookListAdapter(Context context,ArrayList<BookList> data){
        mInflater=LayoutInflater.from(context);
        this.dataSet=data;
        this.context=context;
    }


    @Override
    public int getCount() {
        return dataSet.size();
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
            convertView= LayoutInflater.from(context).inflate(R.layout.library_book_list_item,parent,false);
            holder.tvBookName=convertView.findViewById(R.id.tvBookName);
            holder.tvBookStatus=convertView.findViewById(R.id.tvBookStatus);

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }

        holder.tvBookName.setText(dataSet.get(position).getName());
        holder.tvBookStatus.setText(dataSet.get(position).getStatus());

        return convertView;
    }

}
