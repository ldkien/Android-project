package dk.lukynumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randNumber;
    int sumScore=0;
    Button btnTemp;
    int i;
    TextView textViewScore;
    int btnNumber[]={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18,R.id.button19,R.id.button20,R.id.button21,R.id.button22,R.id.button23,R.id.button24,R.id.button25};
    Button btn[]=new Button[25];
    View.OnClickListener myOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btnTemp=(Button) view;
            if(Integer.parseInt(btnTemp.getText().toString())==randNumber)
            {
                Toast.makeText(MainActivity.this,btnTemp.getText(),Toast.LENGTH_SHORT).show();
                sumScore+=10;
                textViewScore.setText("Your Score:" +sumScore+"");
                Random r=new Random();
                randNumber=r.nextInt(25)+1;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewScore=(TextView) findViewById(R.id.textViewScore);
        Random r=new Random();
        randNumber=r.nextInt(25)+1;
        for(i=0;i<25;i++)
        {
            btn[i]=(Button) findViewById(btnNumber[i]);
            btn[i].setText(i+1+"");
            btn[i].setOnClickListener(myOnClick);
        }

        //Toast.makeText(MainActivity.this,randNumber+"",Toast.LENGTH_LONG).show();
    }
}
