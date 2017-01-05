package dk.basicgridview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kienm on 14/11/2016.
 */

public class ShowImage extends AppCompatActivity {
    TextView txtpImage;
    ImageView imgContent;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_item_gridview);
        Bundle extras = getIntent().getExtras();
        int[] lstIDImg = extras.getIntArray("lstIDImn");
        int posistion = extras.getInt("posistion");
        txtpImage = (TextView) findViewById(R.id.txtNameImg);
        imgContent = (ImageView) findViewById(R.id.imgContent);
        btnBack = (Button) findViewById(R.id.btnBack);
        txtpImage.setText("Ảnh Số " + posistion);
        imgContent.setImageResource(lstIDImg[posistion]);
        btnBack.setOnClickListener(Back_click);
    }
    View.OnClickListener Back_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
