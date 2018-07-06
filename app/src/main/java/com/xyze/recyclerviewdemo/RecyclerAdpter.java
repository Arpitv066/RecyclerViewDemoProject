package com.xyze.recyclerviewdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Netcomm on 6/7/2018.
 */

public class RecyclerAdpter extends RecyclerView.Adapter<RecyclerAdpter.DataHolder> {

    private ArrayList<DataModel> dataModelArrayList;
    Context context;
    private Activity activityy;

    public RecyclerAdpter(ArrayList<DataModel> dataModelArrayList, Context context, Activity activityy) {
        this.dataModelArrayList = dataModelArrayList;
        this.context = context;
        this.activityy = activityy;
    }

    @Override
    public RecyclerAdpter.DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new DataHolder(itemView, context, dataModelArrayList);
    }

    @Override
    public void onBindViewHolder(RecyclerAdpter.DataHolder holder, int position) {

        DataModel dataModel = dataModelArrayList.get(position);

        holder.tv.setText(dataModelArrayList.get(position).getText());
        holder.iv.setImageResource(dataModelArrayList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        if (dataModelArrayList == null)
            return 0;
        return dataModelArrayList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView iv;

        public DataHolder(View itemView, Context context, ArrayList<DataModel> dataModelArrayList)
        {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_text);
            iv = (ImageView) itemView.findViewById(R.id.iv_image);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activityy, "Image", Toast.LENGTH_SHORT).show();
                }
            });


            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activityy, "text", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activityy, "Row", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
