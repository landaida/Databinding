package com.appsparaguay.testlistcontrol;

/**
 * Created by Administrador on 9/7/2015.
 */
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.appsparaguay.testlistcontrol.adapter.UserAdapter;
import com.appsparaguay.testlistcontrol.dao.UserDao;
import com.appsparaguay.testlistcontrol.databinding.ActivityListBinding;
import com.appsparaguay.testlistcontrol.event.ItemClickEvent;

import de.greenrobot.event.EventBus;

public class ListActivity extends AppCompatActivity {

    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setTotal(UserDao.getTotal());
        adapter = new UserAdapter(UserDao.lista);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onEvent(ItemClickEvent event) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("index", event.getPosition());
        startActivity(intent);
    }
}