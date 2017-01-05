package dk.basicgridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    GridView grAlbum;
    //mảng lưu danh sách các id hình ảnh có sẵn
    Integer[] lstIDImg;
    int[] intArray;
    //Adapter cho GridView
    MyImageAdapter adapter = null;
    ImageView imgContent;
    Button btnBack;
    TextView txtNameImg;
    Bundle myBackupBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBackupBundle = savedInstanceState;
        setContentView(R.layout.activity_main);


        lstIDImg = new Integer[]{R.drawable.a, R.drawable.b,
                R.drawable.c, R.drawable.d,
                R.drawable.e, R.drawable.f};
        grAlbum = (GridView) findViewById(R.id.grAlbumImage);
        adapter = new MyImageAdapter(this, lstIDImg);
        grAlbum.setAdapter(adapter);
        // Chuyển đổi từ Interge[] sang int [] để truyền qua Intent
        intArray = new int[lstIDImg.length];
        for (int i = 0; i < lstIDImg.length; i++) {
            intArray[i] = lstIDImg[i].intValue();
        }

        //thiết lập sự kiện để mở từng hình ảnh chitiết
        grAlbum.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public void onItemClick(AdapterView adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, ShowImage.class);
        intent.putExtra("lstIDImn",intArray);
        intent.putExtra("posistion", i);
        this.startActivity(intent);
    }
}
