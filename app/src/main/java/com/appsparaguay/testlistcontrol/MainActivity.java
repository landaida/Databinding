package com.appsparaguay.testlistcontrol;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.appsparaguay.testlistcontrol.dao.UserDao;
import com.appsparaguay.testlistcontrol.databinding.ActivityMainBinding;
import com.appsparaguay.testlistcontrol.model.User;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user;

        if (getIntent().hasExtra("index")) {
            user = UserDao.lista.get(getIntent().getIntExtra("index", 0));
        } else {
            user = UserDao.getRandomQuote();
        }

        binding.setUser(user);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = UserDao.getRandomQuote();
                binding.setUser(user);
            }
        });
    }
}