package com.kvikesh800gmail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kvikesh800gmail.model.Menu;
import com.kvikesh800gmail.model.MenuNavigation;
import com.kvikesh800gmail.relativlayoutjava.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private List<Menu> menuList;
    private Context mContext;

    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    public MenuAdapter(Context mContext, List<Menu> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        holder.name.setText(menu.getName());

        Glide.with(mContext)
                .load(menu.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView image;

        public MyViewHolder (View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_menu_caption);
            image = (ImageView) view.findViewById(R.id.iv_menu_image);
        }
    }
}
