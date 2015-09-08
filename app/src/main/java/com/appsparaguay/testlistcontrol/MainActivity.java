package com.appsparaguay.testlistcontrol;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.appsparaguay.testlistcontrol.dao.UserDao;
import com.appsparaguay.testlistcontrol.databinding.ActivityMainBinding;
import com.appsparaguay.testlistcontrol.model.User;
import com.appsparaguay.testlistcontrol.util.RestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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

        this.getPublicTimeline();


    }

    public void getPublicTimeline() {
        RestUtil.get("getEmpresas", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                try {
                    // Pull out the first event on the public timeline
                    JSONObject firstEvent = (JSONObject) timeline.get(0);
                    String tweetText = firstEvent.getString("nome");
                    // Do something with the response

                    ObjectMapper mapper = new ObjectMapper();
                    User user = mapper.readValue( "{\"firstName\":\"Ariel\", \"lastName\":\"Landaida\"}", User.class);
                    Log.i("mylogs", user.getFirstName());
                    Log.i("mylogs", user.getLastName());
                } catch (Exception e) {
                    Log.e("mylogs", e.getMessage());
                }
            }
        });
    }
}