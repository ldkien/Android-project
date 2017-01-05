package dk.spinnerbasic;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by kienm on 22/11/2016.
 */

public class SpinnerActivity extends Activity {
    //Tạo một mảng dữ liệu giả
    String arr[] = {
            "Hàng điện tử",
            "Hàng hóa chất",
            "Hàng gia dụng"};
    TextView selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        selection = (TextView) findViewById(R.id.selection);
        //Lấy đối tượng Spinner ra
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spin.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spin.setOnItemSelectedListener(new MyProcessEvent());
    }

    //Class tạo sự kiện
    private class MyProcessEvent implements
            OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 là phần tử được chọn trong data source
            selection.setText(arr[arg2]);
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            selection.setText("");
        }
    }
}
