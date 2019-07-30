package demo.covenet.com.covenetdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import demo.covenet.com.covenetdemo.R;
import demo.covenet.com.covenetdemo.ui.util.Constants;

/**
 * Created by selva on 2/26/2018.
 */

public class DetailsActivity extends AppCompatActivity {
    private final String TAG = DetailsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        overridePendingTransition(R.anim.transition_zoom_enter, 0);

        String title = getIntent().getExtras().getString(Constants.KEY_TITLE_ID);

        Log.d(TAG, "DetailsActivity Oncreate : " + title);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (title != null) actionBar.setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp");
        NavigateBackWithAnimation();
        return true;
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        super.onBackPressed();
        NavigateBackWithAnimation();
    }

    private void NavigateBackWithAnimation() {
        Log.d(TAG, "NavigateBackWithAnimation to MainActivity");
        Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, R.anim.transition_zoom_exit);
    }
}
