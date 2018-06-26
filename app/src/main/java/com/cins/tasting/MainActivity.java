package com.cins.tasting;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.cins.tasting.bottomsheets.MyBottomSheetsActivity;
import com.cins.tasting.dialog.MyDialogActivity;
import com.cins.tasting.scrollview.ScrollViewActivity;
import com.cins.tasting.textview.MyTextView;
import com.cins.tasting.softkeboard.KeyboardPanel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override public void onClick(View view) {
    Intent intent;
    switch (view.getId()) {
      //基本组件
      case R.id.bt_textview:
        intent = new Intent(this, MyTextView.class);
        startActivity(intent);
        break;
      case R.id.bt_imageview:
        break;
      case R.id.bt_viewpage:
        break;
      case R.id.bt_dialog:
        intent = new Intent(this, MyDialogActivity.class);
        startActivity(intent);
        break;
      case R.id.bt_toast:
        break;
      case R.id.bt_checkbox:
        break;
      case R.id.bt_bottomsheet:
        intent = new Intent(this, MyBottomSheetsActivity.class);
        startActivity(intent);
        break;
      case R.id.keyboard:
        intent = new Intent(this, KeyboardPanel.class);
        startActivity(intent);
        break;

      case R.id.bt_scrollview:
        intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);
        break;
      case R.id.bt_kb:
        break;
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuItem item = menu.add(Menu.NONE, 0, Menu.NONE, "删除");
    MenuItemCompat.setShowAsAction(item,MenuItem.SHOW_AS_ACTION_ALWAYS);
    return super.onCreateOptionsMenu(menu);
  }


  //public boolean onOptionsItemSelected(MenuItem item) {
  //  if (item.getItemId() == 0 && deliverAddress != null) {
  //    showMenuDialog(deliverAddress);
  //    return true;
  //  }
  //  return super.onOptionsItemSelected(item);
  //}

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    Toast.makeText(this, "dddd", Toast.LENGTH_LONG).show();
    return super.onOptionsItemSelected(item);
  }
}
