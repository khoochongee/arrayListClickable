package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.myapplication.dataModel.NoticeModel;
import com.example.myapplication.dataModel.NoticeModelAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class eNoticeFragment extends Fragment {
    /*private ListView listview;
    private ArrayList<NoticeModel> data=new ArrayList<NoticeModel>();
    private OkHttpClient okHttpClient = new OkHttpClient();*/

    private ListView lv_eNotice;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ArrayList<NoticeModel> noticeList;
    private NoticeModelAdapter adapter;
    private NoticeModel enotice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_e_notice,container,false);
        //listview=v.findViewById(R.id.e_notice_list);

        lv_eNotice=v.findViewById(R.id.e_notice_list);

        noticeList=new ArrayList<NoticeModel>();
        enotice=new NoticeModel();

        database= FirebaseDatabase.getInstance();
        ref=database.getReference("eNotice");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    enotice=ds.getValue(NoticeModel.class);
                    noticeList.add(enotice);
                }
                initialize();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //getDataFromAPI();
        return v;
    }

    public void initialize(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViews();
                setListeners();
            }
        });
    }
    public void findViews(){
        adapter=new NoticeModelAdapter(getActivity(),noticeList);
        lv_eNotice.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void setListeners(){
        lv_eNotice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),NoticeProfile.class);
                intent.putExtra("title",noticeList.get(position).getTitle());
                intent.putExtra("date",noticeList.get(position).getDate());
                intent.putExtra("description",noticeList.get(position).getDescription());
                startActivity(intent);
            }
        });
    }

    /*private void findViews(){
        listview = getActivity().findViewById(R.id.e_notice_list);

        NoticeModelAdapter adapter = new NoticeModelAdapter(getContext(),data);
        listview.setAdapter(adapter);
    }

    private void setListeners(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoticeModel selectedItem = (NoticeModel)listview.getAdapter().getItem(position);

                Intent i = new Intent(getContext(), NoticeProfile.class);
                i.putExtra("title",selectedItem.getTitle());
                i.putExtra("date",selectedItem.getDate());
                i.putExtra("description",selectedItem.getDescription());

                startActivity(i);
            }
        });
    }

    private void initialize(){
        getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run(){
                findViews();
                setListeners();
            }
        });
    }

    private void getDataFromAPI(){
        Request request = new Request.Builder().url("https://api.myjson.com/bins/15z648?fbclid=IwAR1y3NTMgcXKeAiorf4PwFfrPEanre0Pt9ASbGo47Fq-DqXncEET3xuZMxs").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    JSONObject dataObject = new JSONObject(response.body().string());
                    JSONArray dataArray = dataObject.getJSONArray("data");

                    for(int i = 0 ; i < dataArray.length() ; i++){
                        JSONObject singleObject = dataArray.getJSONObject(i);

                        NoticeModel model = new NoticeModel(singleObject.getString("title"),singleObject.getString("date"),singleObject.getString("description"));
                        System.out.println(model);
                        System.out.println(model.getTitle());
                        data.add(model);
                    }
                    initialize();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
