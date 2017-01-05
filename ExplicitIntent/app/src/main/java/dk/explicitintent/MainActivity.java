package dk.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editValue = (EditText) findViewById(R.id.value_edit);
        final Button sendButton = (Button) findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueString=editValue.getText().toString();
                long value;
                if(valueString!=null) {
                    value=Long.parseLong(valueString);
                }
                else
                    value=0;
                Bundle sendBundle = new Bundle();
                sendBundle.putLong("value",value);
                //Tạo Intent để khởi chạy Activity2 và gắn sendBundble vào Intent
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtras(sendBundle);
                startActivity(i);
                //Giải phóng Activity1 khỏi Activity Stack vì ta sẽ ko quay lại nó nữa
                finish();
            }
            //Tạo một đối tượng Bundle để truyền dữ liệu đi cùng Intents

        });
    }
}
