package com.example.todaynews;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.todaynews.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ScarpFragment extends Fragment {

    private ListView list;
    final ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> list_item;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scarp, container, false);

        list = root.findViewById(R.id.list);

        SimpleAdapter simpleAdapter = new SimpleAdapter(root.getContext(), data, android.R.layout.simple_list_item_2,
                new String[]{"item 1", "item 2"},
                new int[]{android.R.id.text1, android.R.id.text2});

        list.setAdapter(simpleAdapter);

        for (int i=1;i<100;i++) {
            list_item = new HashMap<String,String>();
            list_item.put("item 1", "키워드 "+String.valueOf(i));
            list_item.put("item 2", "기사내용 "+String.valueOf(i));
            data.add(list_item);
        }
        simpleAdapter.notifyDataSetChanged();
        list.setOnItemClickListener(listener);

        return root;
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        //ListView의 아이템 중 하나가 클릭될 때 호출되는 메소드
        //첫번째 파라미터 : 클릭된 아이템을 보여주고 있는 AdapterView 객체(여기서는 ListView객체)
        //두번째 파라미터 : 클릭된 아이템 뷰
        //세번째 파라미터 : 클릭된 아이템의 위치(ListView이 첫번째 아이템(가장위쪽)부터 차례대로 0,1,2,3.....)
        //네번재 파리미터 : 클릭된 아이템의 아이디(특별한 설정이 없다면 세번째 파라이터인 position과 같은 값)
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getContext(),Summary.class);
            startActivity(intent);
        }

    };
}