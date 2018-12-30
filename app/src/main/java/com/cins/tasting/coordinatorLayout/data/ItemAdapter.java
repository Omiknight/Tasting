package com.cins.tasting.coordinatorLayout.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cins.tasting.R;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.VH> {
  private List<String> datas;

  public ItemAdapter(List<String> datas) {
    this.datas = datas;
  }

  @Override public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false);
    return new VH(view);
  }

  @Override public void onBindViewHolder(VH holder, int position) {
    holder.textView.setText("dafafadfafdadf");
  }

  @Override public int getItemCount() {
    return 0;
  }

  public static class VH extends RecyclerView.ViewHolder {

    TextView textView;

    public VH(View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.tv);
    }
  }
}
