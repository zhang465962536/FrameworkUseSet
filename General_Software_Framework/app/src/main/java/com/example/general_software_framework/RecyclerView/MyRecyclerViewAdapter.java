package com.example.general_software_framework.RecyclerView;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.general_software_framework.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    ArrayList<String> datas;
    public MyRecyclerViewAdapter(Context context, ArrayList<String> datas) {
        mContext = context;
        this.datas = datas;
    }


/**
     * 相当于listview的 getview ()方法 中 创建view和 viewHolder
     * @param viewGroup
     * @param i
     * @return
     */

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = View.inflate(mContext, R.layout.item_recyclerview,null);
        return new MyViewHolder(itemView);
    }


/**
     * 相当于 相当于listview的 getview ()方法 中 绑定数据部分代码
     * 绑定数据  数据和view绑定
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //根据位置得到对应的数据
        String  data  = datas.get(position);
        holder.tv_title.setText(data);



    }

    //得到的总条数
    @Override
    public int getItemCount() {
        return datas.size();
    }


/**
     * 添加数据
     * @param position
     * @param data
     */

    public void addData(int position, String data) {
        datas.add(position,data);
        //刷新适配器
        notifyDataSetChanged();
    }


/**
     * 删除数据
     * @param position
     */

    public void removeData(int position) {
        datas.remove(position);
        //刷新适配器
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_icon;
        private TextView tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Toast.makeText(mContext, "data=="+datas.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(v,datas.get(getLayoutPosition()));
                    }
                }
            });

            //只点击图片有效
           iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "我是图片 =="+datas.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


/**
     * 点击RecyclerView某条的监听
     */

    public interface OnItemClickListener{


/**
         * 当RecyclerView某个被点击的时候回调
         * @param view 点击item的视图
         * @param data 点击得到的数据
         */

        public void onItemClick(View view,String data);

    }


    private  OnItemClickListener onItemClickListener;


/**
     * 设置RecyclerView某个的监听
     * @param onItemClickListener
     */

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
