package com.dragonyang.listtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * listView进阶版，自定义适配器通俗解读
 * 小白必看！！！
 */
public class MainActivity extends AppCompatActivity {
    ListView list2;
    static final String TAG = "ListViewSimple";
    String[] DATA = {"11111", "22222", "33333", "44444", "55555", "66666", "77777", "88888", "99999", "10-10-10", "11-11-11", "12-12-12"};
    int[] icons = {R.drawable.i1, R.drawable.i2, R.drawable.i3,
            R.drawable.i4, R.drawable.i5, R.drawable.i6,
            R.drawable.i7, R.drawable.i8, R.drawable.i9,
            R.drawable.i10, R.drawable.i11, R.drawable.i12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list2 = findViewById(R.id.list2);
        /**
         * 句柄，布局文件，字符资源，图片资源
         */
        EffivientAdapter adapter = new EffivientAdapter(this, R.layout.listview_item, DATA, icons);
        list2.setAdapter(adapter);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "选择:" + DATA[position]);
            }
        });
    }
}
