package dk.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dk.fragmentexample.R;
/**
 * Created by kienm on 26/10/2016.
 */

public class LM_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(android.R.layout.lm, container, savedInstanceState);
        return inflater.inflate(R.layout.lm_fragment, container, false);
    }
}
