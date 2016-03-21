package com.example.loon.myapplication.FragmentExample.ListFragmentExp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loon.myapplication.R;

/**
 * Created by loon on 16/3/21.
 */
public class DetailFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, null);
        TextView textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText("" + getArguments().getString("item"));
        return view;

    }
}
