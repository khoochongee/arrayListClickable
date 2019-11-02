package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.myapplication.dataModel.LibraryFunction;

import java.util.ArrayList;

public class LibraryFunctionAdapter extends ArrayAdapter<LibraryFunction>{
    private ArrayList<LibraryFunction> dataSet;
    private Context context;

    private static class ViewHolder{
        TextView functionName;
    }

    public LibraryFunctionAdapter(ArrayList<LibraryFunction> data,Context context){
        super(context, R.layout.library_function_list,data);
        this.dataSet=data;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LibraryFunction fuction=getItem(position);
        ViewHolder holder;

        if(convertView == null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.library_function_list,parent,false);

            holder.functionName=convertView.findViewById(R.id.tvFunctionName);

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.functionName.setText(fuction.getLibraryFunction());

        return convertView;
    }
}
