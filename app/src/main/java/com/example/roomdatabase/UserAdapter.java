package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> userList;
    public void setData(List<User> list){
        this.userList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        if(user == null)
            return;

        holder.tvname.setText(user.getName());
        holder.tvdesc.setText(user.getDesc());
        holder.img.setImageResource(R.drawable.ic_wifi_48);
    }

    @Override
    public int getItemCount() {
        if(userList != null)
            return userList.size();
        return 0;
    }

    public  class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvname, tvdesc;
        private ImageView img;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tv_name);
            tvdesc = itemView.findViewById(R.id.tv_desc);
            img = itemView.findViewById(R.id.hisIcon);

        }
    }
}
