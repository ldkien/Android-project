package dk.basicgridview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by kienm on 14/11/2016.
 */

public class MyImageAdapter extends BaseAdapter {

    private Context Context;
    private Integer [] lstIdImg;
    public MyImageAdapter(Context c){
        Context =c;
    }
    public MyImageAdapter(Context c,Integer []arrIds){
        Context =c;
        lstIdImg =arrIds;
    }
    @Override
    public int getCount() {
        return lstIdImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgView;
        ViewHolder viewHolder;
        if(view==null){
            imgView=new ImageView(Context);
            //can chỉnh lại hình cho đẹp
            imgView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8, 8, 8, 8);
        }else{
            imgView=(ImageView) view;
        }
        //lấy đúng vị trí hình ảnh được chọn
        //gán lại ImageResource
        imgView.setImageResource(lstIdImg[i]);
        return imgView;
    }
    static class ViewHolder {
        ImageView imageView;
    }
}
