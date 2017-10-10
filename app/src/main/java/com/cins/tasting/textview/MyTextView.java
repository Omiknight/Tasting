package com.cins.tasting.textview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cins.tasting.R;
import com.cins.tasting.R2;

/**
 * Created by jinjianping on 2017/10/7.
 */

public class MyTextView extends AppCompatActivity {

  @BindView(R2.id.tv_another)public TextView textView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.textview);
    ButterKnife.bind(this);

    textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,0,0,0);
  }
}
