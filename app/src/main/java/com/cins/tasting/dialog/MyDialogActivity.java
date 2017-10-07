package com.cins.tasting.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2017/10/7.
 */

public class MyDialogActivity extends AppCompatActivity implements
    EventBackDialogFragment.EventBackDialogListener {

  @BindView(R.id.bt_dialog) Button mButton;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dialog);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.bt_dialog)
  public void showBaseDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(MyDialogActivity.this);
    builder.setTitle("SimpleAlert");
    builder.setMessage("are you ok");
    builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(), "you click cancle", Toast.LENGTH_LONG).show();
      }
    });
    builder.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(), "you click sure", Toast.LENGTH_LONG).show();
      }
    });
    builder.create().show();
  }

  @OnClick(R.id.bt_dialogFrag)
  public void showDialogFrag() {
    MyDialogFragment dialogFragment = new MyDialogFragment();
    dialogFragment.show(getSupportFragmentManager(), "");
  }

  @OnClick(R.id.bt_addBtnDialog)
  public void showAddBtnDialog() {
    NatureButtonFragment natureButtonFragment = new NatureButtonFragment();
    natureButtonFragment.show(getSupportFragmentManager(), "");
  }

  @OnClick(R.id.bt_listDialog)
  public void showListDialog() {
    ListDialogFragment listDialogFragment = new ListDialogFragment();
    listDialogFragment.show(getSupportFragmentManager(), "");
  }

  @OnClick(R.id.bt_multipChoiceDialog)
  public void showMultipChoiceDialog() {
    MultipChoiceDialogFragment multipChoiceDialogFragment = new MultipChoiceDialogFragment();
    multipChoiceDialogFragment.show(getSupportFragmentManager(), "");
  }

  @OnClick(R.id.bt_customDialog)
  public void showCustomDialog() {
    CustomerDialogFragment cdf = new CustomerDialogFragment();
    cdf.show(getSupportFragmentManager(), "");
  }

  //在 activity 中处理按钮事件
  @OnClick(R.id.bt_eventDialog)
  public void showeventDialog() {
    EventBackDialogFragment eventBackDialogFragment = new EventBackDialogFragment();
    eventBackDialogFragment.show(getSupportFragmentManager(), "");
  }

  @Override public void OnPositiveClick(DialogFragment dialogFragment) {
    Toast.makeText(getApplicationContext(), "you click Sure", Toast.LENGTH_LONG).show();
  }

  @Override public void OnNegativeClick(DialogFragment dialogFragment) {
    Toast.makeText(getApplicationContext(), "you click Cancle", Toast.LENGTH_LONG).show();
  }

  @OnClick(R.id.bt_progressDialog)
  public void showProgressDialog() {
    ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
    progressDialogFragment.show(getSupportFragmentManager(),"");
  }

  @OnClick(R.id.bt_progressHorizatalDialog)
  public void showProgressHorizatalDialog() {
    ProgressHorizatalDialogFragment progressHorizatalDialogFragment =
        new ProgressHorizatalDialogFragment();
    progressHorizatalDialogFragment.show(getSupportFragmentManager(),"");
  }

  @OnClick(R.id.bt_datePickerDialog)
  public void showDatePickerDialog() {
    DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
    datePickerDialogFragment.show(getSupportFragmentManager(),"");
  }

  @OnClick(R.id.bt_timePickerDialog)
  public void showTimePickerDialog() {
    TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
    timePickerDialogFragment.show(getSupportFragmentManager(),"");
  }
}
