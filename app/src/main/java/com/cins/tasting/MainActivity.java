package com.cins.tasting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.cins.tasting.dialog.MyDialogActivity;
import com.cins.tasting.textview.MyTextView;

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
        Intent intent = new Intent(this, MyTextView.class);
        startActivity(intent);
        break;
      case R.id.bt_imageview:
        break;
      case R.id.bt_viewpage:
        break;
      case R.id.bt_dialog:
        Intent intent1 = new Intent(this, MyDialogActivity.class);
        startActivity(intent1);
        break;
      case R.id.bt_toast:
        break;
      case R.id.bt_checkbox:
        break;
    }
  }
}
