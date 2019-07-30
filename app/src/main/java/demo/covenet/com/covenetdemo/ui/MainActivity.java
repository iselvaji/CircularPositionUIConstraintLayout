package demo.covenet.com.covenetdemo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import demo.covenet.com.covenetdemo.R;
import demo.covenet.com.covenetdemo.ui.util.AppUtils;
import demo.covenet.com.covenetdemo.ui.util.Constants;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();
    private Animation mAnimation;
    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onProductClick(View view) {
        Log.d( TAG, "onProductClick : " + view.getId());

        view.setBackground(getDrawable(R.drawable.ripple_effect));

        switch (view.getId()) {
            case R.id.imageProductCar:
                view.setTag(R.drawable.ic_car);
                title = getString(R.string.feature_travel);
                break;
            case R.id.imageViewProductApple:
                view.setTag(R.drawable.ic_apple);
                title = getString(R.string.feature_health);
                break;
            case R.id.imageViewProductSafety:
                view.setTag(R.drawable.ic_safety);
                title = getString(R.string.feature_security);
                break;
            case R.id.imageViewProductChat:
                view.setTag(R.drawable.ic_chat);
                title = getString(R.string.feature_chat);
                break;
        }

        Bitmap image = AppUtils.getBitmap(this, (int)(view.getTag()));
        showAnimation(view, image);
    }

   private final Animation.AnimationListener animationListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            activityTransition(title);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private void showAnimation(final View view, Bitmap image) {

        if(view != null) {

           /* int dominantColor = getDominantColor(image);
            Log.d( TAG, "showAnimation :: dominant color :" + dominantColor);
            RippleDrawable ripple = new RippleDrawable(ColorStateList.valueOf(dominantColor), null, null);
            ripple.setRadius(R.dimen.ripple_radius);
            view.setBackground(ripple);*/

            // animation
            mAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
            mAnimation.setAnimationListener(animationListener);
            view.startAnimation(mAnimation);
        }
    }

    // show details activity
    private void activityTransition(String title) {
        Log.d( TAG, "activityTransition :: title :" + title);

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(Constants.KEY_TITLE_ID, title);
        startActivity(intent);
    }

}
