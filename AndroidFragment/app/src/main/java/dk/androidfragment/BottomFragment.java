package dk.androidfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kienm on 26/10/2016.
 */

public class BottomFragment extends Fragment {
    private TextView topText;
    private TextView bottomText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_bottom, container, false);

        topText = (TextView) view.findViewById(R.id.top_image_text);
        bottomText = (TextView) view.findViewById(R.id.bottom_image_text);

        return view;
    }

    public void showText(String topImageText, String bottomImageText) {
        topText.setText(topImageText);
        bottomText.setText(bottomImageText);
    }
}
