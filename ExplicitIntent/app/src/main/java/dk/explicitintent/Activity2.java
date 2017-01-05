package dk.explicitintent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class Activity2 extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_layout);
        final EditText receiveValueEdit = (EditText) findViewById(R.id.value_receive);
        final Button callReceiverButton = (Button) findViewById(R.id.call_button);
        //lấy bundle gửi kèm với intent về
        Bundle receiveBundle = this.getIntent().getExtras();
        final long receiveValue;
        receiveValue=receiveBundle.getLong("value");
        receiveValueEdit.setText(receiveValue+"");
        callReceiverButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tạo intent để gửi đến broadcast receive
                //Gắn giá trị vào intent lần này ko cần tạo bundle nữa
                Intent i=new Intent(Activity2.this,Receiver.class);
                i.putExtra("new value",receiveValue-10);
                sendBroadcast(i);
            }
        });
    }
}