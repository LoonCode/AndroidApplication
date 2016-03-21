package com.example.loon.myapplication.FragmentExample.DynamicFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.loon.myapplication.R;

/**
 * Created by loon on 16/3/21.
 */
public class RightFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_right, null);
        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "我是fragment", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
