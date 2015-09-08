package com.appsparaguay.testlistcontrol.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsparaguay.testlistcontrol.databinding.ItemUserBinding;
import com.appsparaguay.testlistcontrol.event.ItemClickEvent;
import com.appsparaguay.testlistcontrol.model.User;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


/**
 * Created by Administrador on 9/7/2015.
 */
public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemUserBinding binding;

        public ViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        public ItemUserBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            EventBus.getDefault().post(new ItemClickEvent(getAdapterPosition()));
        }
    }

    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemUserBinding binding = ItemUserBinding.
                inflate(LayoutInflater.from(viewGroup.getContext()));

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.getBinding().setUser(users.get(i));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}