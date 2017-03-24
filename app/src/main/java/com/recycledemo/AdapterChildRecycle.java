package com.recycledemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by softbunch on 3/23/17.
 */

public class AdapterChildRecycle extends RecyclerView.Adapter<AdapterChildRecycle.MyHolder> {

    Context context;
    ArrayList<M_child> m_children;

    public AdapterChildRecycle(Context context, ArrayList<M_child> m_children) {
        this.context = context;
        this.m_children = m_children;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_child_recycle_row, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        M_child mChild = m_children.get(position);
       // String name = m_children.get(position);
        String name = mChild.getChildname();

        holder.text_cname.setText(name);

    }

    @Override
    public int getItemCount() {
        return m_children.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView text_cname;

        public MyHolder(View itemView) {
            super(itemView);
            text_cname = (TextView) itemView.findViewById(R.id.text_cname);

        }
    }
}
