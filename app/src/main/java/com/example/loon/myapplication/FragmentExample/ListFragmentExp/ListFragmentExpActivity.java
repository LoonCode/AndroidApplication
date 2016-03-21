package com.example.loon.myapplication.FragmentExample.ListFragmentExp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loon.myapplication.FragmentExample.DynamicFragment.RightFragment;
import com.example.loon.myapplication.R;

/**
 * Created by loon on 16/3/21.
 */
public class ListFragmentExpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fragment_activity_main);


        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //步骤一：添加一个FragmentTransaction的实例
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //步骤二：用add()方法加上Fragment的对象rightFragment
                ArticleListFragment articleListFragment = new ArticleListFragment();
                transaction.add(R.id.center, articleListFragment, "article");

                //步骤三：调用commit()方法使得FragmentTransaction实例的改变生效
                transaction.commit();
            }
        });

    }
}
