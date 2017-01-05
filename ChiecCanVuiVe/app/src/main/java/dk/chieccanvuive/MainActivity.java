package dk.chieccanvuive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnResult;
    EditText editTextHeight;
    EditText editTextWeight;
    ImageView imageView;
    TextView textViewInfo;
    double chieuCao;
    double canNang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.image);
        editTextHeight=(EditText) findViewById(R.id.textViewHeight);
        editTextWeight=(EditText) findViewById(R.id.textViewWeight);
        textViewInfo=(TextView) findViewById(R.id.textViewInfo);
        btnResult=(Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    chieuCao = Double.parseDouble(editTextHeight.getText().toString());
                    canNang =Double.parseDouble(editTextWeight.getText().toString());
                    if(chieuCao==0||canNang==0)
                    {
                        Toast.makeText(MainActivity.this,"Nhập lại",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Double ketQua=canNang/(chieuCao*chieuCao);
                        if(ketQua<18.5)
                        {
                            textViewInfo.setText("Bạn quá gầy");
                        }
                        else
                        {
                            if(ketQua<24.9)
                            {
                                textViewInfo.setText("Thân hình bình thường");
                            }
                            else
                            {
                                if(ketQua==25)
                                    textViewInfo.setText("Bạn hơi thừa cân");
                                else
                                {
                                    textViewInfo.setText("Bạn chỉ kém con lợn còi");
                                }

                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    Toast.makeText(MainActivity.this,"Nhập lại",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
