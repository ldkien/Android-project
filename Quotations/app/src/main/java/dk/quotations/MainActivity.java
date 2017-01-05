package dk.quotations;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    RelativeLayout relativeLayout;
    int i=0;
    String arr[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textViewQuotations);
        relativeLayout=(RelativeLayout) findViewById(R.id.rltLayout);
        arr=getResources().getStringArray(R.array.textQuotations);
        new CountDownTimer(10000,100) {
            @Override
            public void onTick(long l) {
                if(i<3){
                    textView.setText(arr[i].toString());
                    relativeLayout.setBackgroundResource(R.drawable.ice_cream_2);
                    i++;
                }
                else
                    i=0;

            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"Time out",Toast.LENGTH_LONG).show();

            }
        }.start();


    }
}
