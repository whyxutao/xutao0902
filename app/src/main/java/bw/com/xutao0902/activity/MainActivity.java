package bw.com.xutao0902.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import bw.com.xutao0902.R;
import bw.com.xutao0902.adapter.MyListAdapter;
import bw.com.xutao0902.bean.NewsInfo;
import bw.com.xutao0902.utils.HttpUtil;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String path = "http://172.17.8.100/small/commodity/v1/bannerShow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);

        getServerData(path);

    }

    private void getServerData(String path) {

        HttpUtil.getInstance().getJson(path, new HttpUtil.ICallBack() {
            @Override
            public void onSuccess(Object obj) {

                Gson gson = new Gson();
                NewsInfo newsInfo = gson.fromJson(obj.toString(), NewsInfo.class);
                List<NewsInfo.ResultInfo> result = newsInfo.getResult();

                MyListAdapter adapter = new MyListAdapter(result,MainActivity.this);
                listView.setAdapter(adapter);

            }

            @Override
            public void onErrror(String msg) {

            }
        });

    }
}
