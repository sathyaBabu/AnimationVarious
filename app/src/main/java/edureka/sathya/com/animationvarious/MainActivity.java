package edureka.sathya.com.animationvarious;


        import android.animation.ObjectAnimator;
        import android.animation.PropertyValuesHolder;
        import android.animation.ValueAnimator;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAlpha, buttonRotate, buttonTranslate, buttonScale, buttonSet;
    private RadioGroup rdAnimationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAlpha      = (Button) findViewById(R.id.buttonAlphaAnimation)    ;
        buttonRotate     = (Button) findViewById(R.id.buttonRotateAnimation)    ;
        buttonTranslate  = (Button) findViewById(R.id.buttonTranslateAnimation);
        buttonScale      = (Button) findViewById(R.id.buttonScaleAnimation)    ;
        buttonSet        = (Button) findViewById(R.id.buttonSetAnimation)      ;

        rdAnimationType = (RadioGroup) findViewById(R.id.rdAnimationType);

        buttonAlpha.setOnClickListener(this);
        buttonRotate.setOnClickListener(this);
        buttonTranslate.setOnClickListener(this);
        buttonScale.setOnClickListener(this);
        buttonSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonAlphaAnimation:

                if (getAnimationType() == R.id.rdTwinAnimation) {
                    playAlphaAnimation();
                } else {
                    playAlphaObjectAnimator();
                }
                break;
            case R.id.buttonRotateAnimation:

                if (getAnimationType() == R.id.rdTwinAnimation) {
                    playRotateAnimation();
                } else {
                    playRotateObjectAnimator();
                }
                break;
            case R.id.buttonTranslateAnimation:
                if (getAnimationType() == R.id.rdTwinAnimation) {
                    playTranslateAnimation();
                } else {
                    playTranslateObjectAnimator();
                }
                break;
            case R.id.buttonScaleAnimation:
                if (getAnimationType() == R.id.rdTwinAnimation) {
                    playScaleAnimation();
                } else {
                    playScaleObjectAnimator();
                }

                break;
            case R.id.buttonSetAnimation:
                if (getAnimationType() == R.id.rdTwinAnimation) {
                    playSetAnimation();
                } else {
                    playSetObjectAnimator();
                }
                break;
        }
    }

    private int getAnimationType() {
        return rdAnimationType.getCheckedRadioButtonId();
    }

    private void playAlphaAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        buttonAlpha.startAnimation(animation);
    }

    private void playRotateAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        buttonRotate.startAnimation(animation);

    }

    private void playTranslateAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transalte);
        buttonTranslate.startAnimation(animation);

    }

    private void playScaleAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        buttonScale.startAnimation(animation);
    }

    private void playSetAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        buttonSet.startAnimation(animation);
    }

    private void playAlphaObjectAnimator() {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(buttonAlpha, View.ALPHA, 0f, 1f);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setDuration(600);
        objectAnimator.start();

        objectAnimator.cancel();
    }

    private void playRotateObjectAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(buttonRotate, View.ROTATION, 0f, 360f);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setDuration(600);
        objectAnimator.start();
    }

    private void playTranslateObjectAnimator() {
        PropertyValuesHolder propertyXValuesHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 0f, 100f);
        PropertyValuesHolder propertyYValuesHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0f, 200f);
        ValueAnimator valueAnimator = ObjectAnimator.ofPropertyValuesHolder(buttonTranslate, propertyXValuesHolder, propertyYValuesHolder);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setDuration(600);
        valueAnimator.start();
    }

    private void playScaleObjectAnimator() {
        PropertyValuesHolder propertyXValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 2f);
        PropertyValuesHolder propertyYValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 2f);
        ValueAnimator valueAnimator = ObjectAnimator.ofPropertyValuesHolder(buttonScale, propertyXValuesHolder, propertyYValuesHolder);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setDuration(600);
        valueAnimator.start();
    }

    private void playSetObjectAnimator() {

        buttonRotate.clearAnimation(); // Stops the tween buttonRotate  here...
        buttonTranslate.clearAnimation();

        PropertyValuesHolder propertyScaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 2f);
        PropertyValuesHolder propertyScaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 2f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0, 1);

        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat(View.ROTATION, 0f, 360f);
        ValueAnimator valueAnimator = ObjectAnimator.ofPropertyValuesHolder(buttonSet, propertyScaleX, propertyScaleY, alpha, rotate);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setDuration(600);
        valueAnimator.start();
    }
}
