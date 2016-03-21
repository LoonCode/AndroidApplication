package com.example.loon.myapplication.FragmentExample.ListFragmentExp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.loon.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class ArticleListFragment extends ListFragment {

    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //定义一个数组
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            data.add("test" + i);
        }
        //将数组加到ArrayAdapter当中
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        //绑定适配器时，必须通过ListFragment.setListAdapter()接口，而不是ListView.setAdapter()或其它方法
        setListAdapter(adapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        String item = adapter.getItem(position);
//        Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        //记住：这个地方必须用replace，而不是用add
        transaction.replace(R.id.right, detailFragment, "detailFragment");

        //将中间的item的内容放到Bundle对象当中，然后放到最右侧Frament的参数当中
        String item = adapter.getItem(position);
        Bundle args = new Bundle();
        args.putString("item", item);
        detailFragment.setArguments(args);

        transaction.commit();

    }
}
