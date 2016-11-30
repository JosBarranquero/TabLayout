package com.barranquero.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment
 */
public class CustomFragment extends Fragment {
    public static String KEY_REG_TEXT = "text";
    private TextView txvFrg;

    public static Fragment newInstance(Bundle arguments) {
        CustomFragment customFragment = new CustomFragment();
        if (arguments != null) {
            customFragment.setArguments(arguments);
        }
        return customFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        if (view != null) {
            txvFrg = (TextView)view.findViewById(R.id.tvText);

        }
        return view;
    }
}
