package com.recycledemo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by softbunch on 3/23/17.
 */

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.MyHolder> {

    Context context;
    ArrayList<M_Main> m_mainArrayList;
    ArrayList<M_child> m_children;

    public AdapterRecycle(Context context, ArrayList<M_Main> m_mainArrayList) {
        this.context = context;
        this.m_mainArrayList = m_mainArrayList;
        m_children = new ArrayList<>();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_row, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        M_Main mMain = m_mainArrayList.get(position);
        int type = mMain.getType();

        if (type == 0) {
            holder.ll_recycle.setVisibility(View.GONE);
            holder.card_view.setVisibility(View.VISIBLE);
            String name = mMain.getName();
            holder.text_name.setText(name);
        } else if (type == 1) {
            holder.ll_recycle.setVisibility(View.VISIBLE);
            holder.card_view.setVisibility(View.GONE);
            m_children.clear();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.ll_recycle.setLayoutManager(linearLayoutManager);

            int iCount = mMain.getmChildren().size();
            Log.e("iCount",iCount+"");
            for (int i = 0; i < iCount; i++) {
                String cName = mMain.getmChildren().get(i).getChildname();
                String cDesc = mMain.getmChildren().get(i).getChilddesc();

                M_child mChild = new M_child();
                mChild.setChildname(cName);
                mChild.setChilddesc(cDesc);

                m_children.add(mChild);
            }
            AdapterChildRecycle childRecycle = new AdapterChildRecycle(context, m_children);
            holder.ll_recycle.setAdapter(childRecycle);

        }


    }

    @Override
    public int getItemCount() {
        return m_mainArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView text_name;
        RecyclerView ll_recycle;
        CardView card_view;


        public MyHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            ll_recycle = (RecyclerView) itemView.findViewById(R.id.ll_recycle);
            card_view = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
