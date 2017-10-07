package com.cins.tasting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      //基本组件
      case R.id.bt_textview:

        break;
      case R.id.bt_imageview:
        break;
      case R.id.bt_viewpage:
        break;
      case R.id.bt_dialog:
        break;
      case R.id.bt_toast:
        break;
      case R.id.bt_checkbox:
        break;
    }
  }
}
