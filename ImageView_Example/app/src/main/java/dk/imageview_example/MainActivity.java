package dk.imageview_example;

import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int i=0;
    int t=10000;
    int imageID[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
    CountDownTimer time;
    AnimationDrawable frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        frame=(AnimationDrawable) imageView.getDrawable();
        frame.start();

        /*time= new CountDownTimer(t, 1000) {
                @Override
                public void onTick(long l) {
                    if (i < 4) {
                        imageView.setImageResource(imageID[i]);
                        i++;
                    } else
                        i = 0;
                }

                @Override
                public void onFinish() {

                }
            };
        time.start();*/
    }

}
