package com.cins.tasting.tryto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2017/10/31.
 */

public class KeyboardPanel extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.keyboard);
    //AndroidBug5497Workaround.assistActivity(this);
  }
}
