package com.example.loon.myapplication.FragmentExample.DynamicFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loon.myapplication.R;

/**
 * Created by loon on 16/3/21.
 */
public class DynamicFragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_fragment_activity_main);

        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //步骤一：添加一个FragmentTransaction的实例
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //步骤二：用add()方法加上Fragment的对象rightFragment
                RightFragment rightFragment = new RightFragment();
                transaction.add(R.id.right, rightFragment);

                //步骤三：调用commit()方法使得FragmentTransaction实例的改变生效
                transaction.commit();
            }
        });
    }
}
