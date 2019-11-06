package com.example.general_software_framework.Picasso.Activity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.general_software_framework.ImageLoader.Constants;
import com.example.general_software_framework.R;
import com.squareup.picasso.Picasso;

public class PicassoListviewAdapter extends BaseAdapter {
    private Context mContext;

    public PicassoListviewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_picasso_listview,null);
            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.iv_picasso_item);
            holder.tv = convertView.findViewById(R.id.tv_picasso_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 名称
        holder.tv.setText("item"+(position+1));

        // 加载图片
        Picasso.with(mContext)
                .load(Constants.IMAGES[position])
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.iv);

        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
