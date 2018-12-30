package com.cins.tasting.picture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cins.tasting.R;

public class PictureActivity extends AppCompatActivity {
  @BindView(R.id.picture) protected ImageView imageView;
  @BindView(R.id.switch_box) protected SwitchCompat switchCompat;
  @BindView(R.id.text) protected TextView textView;

  SearchView searchView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_picture);
    ButterKnife.bind(this);
    loadPic();

    switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          textView.setText("fdafafaf");
        } else {

          textView.setText("无法打对");
        }
      }
    });
  }

  @OnCheckedChanged(R.id.switch_box)
  public void onCheckChanged(CompoundButton button, boolean ischanged) {
    if (ischanged) {
      textView.setText("fdafafaf");
    } else {

      textView.setText("无法打法是否对");
    }
  }


  private void loadPic() {

    String gitfUrl = "http://p1.pstatp.com/large/166200019850062839d3";
    String url = "http://i.imgur.com/rFLNqWI.jpg";

    RequestOptions options = new RequestOptions()
        .placeholder(R.mipmap.ic_launcher)
        .override(300,300);

    Glide.with(this)
        .load(gitfUrl)
        .apply(options)
        .into(imageView);
  }

  private void append(CharSequence s, CharSequence s2) {
    CharSequence a = s2 + s;
  }
}
