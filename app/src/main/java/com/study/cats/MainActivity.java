package com.study.cats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    int[] ids = {R.drawable.threecolors, R.drawable.yeonnim, R.drawable.moo, R.drawable.raegi,
            R.drawable.marilyn, R.drawable.tungtang};
    String[] names = {"삼색이","연님","무","래기","마를린","뚱땅이"};
    String[] cats = {"Three Colors","YeonNim","Moo","Raegi","Marilyn","Tungtang"};
    ArrayList<HashMap<String,Object>> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        for (int i=0;i<cats.length;i++){
            //value로 String, int가 오니까 둘 다 받을 수 있는 Object로 씀.
            HashMap<String, Object> map = new HashMap<>();
            map.put("nick",cats[i]);
            map.put("name",names[i]);
            map.put("image",ids[i]);
            list.add(map);
        }

        String[] keys = {"nick","name","image"};
        int[] resId = {R.id.txt_nick_item,R.id.txt_name_item,R.id.imageView_item};

        listView = findViewById(R.id.listview);
        //2개 이상일 때 SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(this,list, R.layout.layout_item,keys,resId);
        listView.setAdapter(adapter);
        ItemClickListener listener = new ItemClickListener();
        listView.setOnItemClickListener(listener);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            /*intent에 자신을 밝히고 만들어주길 원하는 액티비티를 담아 안드로이드에 요청하면
              안드로이드가 액티비티를 만들어주고 인텐트를 만든 액티비티에 전달해줌(startActivity).*/
            HashMap<String,Object> map = list.get(position);
            String nick = (String) map.get("nick");
            String name = (String) map.get("name");
            int img = (Integer) map.get("image");

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("nick", nick); //인텐트에 데이터 담기
            intent.putExtra("name", name);
            intent.putExtra("image", img);
            
            startActivity(intent);
        }
    }
}