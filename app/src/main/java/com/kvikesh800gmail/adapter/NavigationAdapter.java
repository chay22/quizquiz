package com.kvikesh800gmail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kvikesh800gmail.model.MenuNavigation;
import com.kvikesh800gmail.relativlayoutjava.R;

import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {

    private List<MenuNavigation> menuNavigationList;
    private Context mContext;

    @Override
    public NavigationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    public NavigationAdapter(Context mContext, List<MenuNavigation> menuNavigationList) {
        this.mContext = mContext;
        this.menuNavigationList = menuNavigationList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuNavigation menuNavigation = menuNavigationList.get(position);
        holder.name.setText(menuNavigation.getName());

        Glide.with(mContext)
                .load(menuNavigation.getImage())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return menuNavigationList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView image;

        public MyViewHolder (View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_navigation_name);
            image = (ImageView) view.findViewById(R.id.iv_navigation_image);
        }
    }
}
