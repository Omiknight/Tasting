package com.cins.tasting.scrollview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2018/2/5.
 */

public class ScrollViewActivity extends AppCompatActivity {

  private LinearLayout linearLayout;
  private ObservableScrollView scrollView;
  private int imageHeight = 300;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.scrollview);

    linearLayout = findViewById(R.id.line);
    scrollView = findViewById(R.id.scrollView);

    //搜索框在布局最上面（一定要用RelativeLayout布局）
    linearLayout.bringToFront();

    scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
      @Override
      public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx,
          int oldy) {
        if (y <= 0) {
          linearLayout.setBackgroundColor(Color.argb(0, 227, 29, 26));
        } else if (y > 0 && y < imageHeight) {
          float scale = y / imageHeight;
          float alpha = (255 * scale);
          // 只是layout背景透明
          linearLayout.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
        } else {
          linearLayout.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
        }
      }
    });
  }
}
