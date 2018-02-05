package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2017/12/6.
 */

public class CustomDialogs extends Dialog{

  public CustomDialogs(@NonNull Context context) {
    super(context);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = View.inflate(getContext(), R.layout.bk_required_food_popup, null);
    setContentView(view);
  }
}
