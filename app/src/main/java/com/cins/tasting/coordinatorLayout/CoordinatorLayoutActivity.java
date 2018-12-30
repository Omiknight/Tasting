package com.cins.tasting.coordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cins.tasting.R;
import com.cins.tasting.coordinatorLayout.data.ItemAdapter;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends AppCompatActivity {

  @BindView(R.id.list) RecyclerView recyclerView;
  @BindView(R.id.toolbar) Toolbar toolbar;

  List<String> datas;
  private ItemAdapter adapter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.coordinatorlayout);
    ButterKnife.bind(this);

     //该属性必须在setSupportActionBar之前 调用
    toolbar.setTitle("toolBar");
    setSupportActionBar(toolbar);
    initData();
  }

  private void initData() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
        LinearLayoutManager.VERTICAL);
    recyclerView.addItemDecoration(itemDecoration);

    datas = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      String s = String.format("我是第%d个item", i);
      datas.add(s);
    }
    adapter = new ItemAdapter(datas);
    recyclerView.setAdapter(adapter);
  }
}
