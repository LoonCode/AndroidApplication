package com.example.loon.myapplication.WIFI;


import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import com.example.loon.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class DeviceListFragment extends ListFragment implements WifiP2pManager.PeerListListener {


    private List<WifiP2pDevice> peers = new ArrayList<WifiP2pDevice>();
    ProgressDialog progressDialog = null;
    View mContentView = null;
    private WifiP2pDevice device;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        this.setListAdapter(new WiFiPeerListAdapter(getActivity(), R.layout.row_devices, peers));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mContentView = inflater.inflate(R.layout.device_list, null);
        return mContentView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        WifiP2pDevice device = (WifiP2pDevice) getListAdapter().getItem(position);
//        ((DeviceActionListener) getActivity()).showDetails(device);
    }

    @Override
    public void onPeersAvailable(WifiP2pDeviceList peers) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
//        peers.clear();
//        peers.addAll(peerList.getDeviceList());
//        ((WiFiPeerListAdapter) getListAdapter()).notifyDataSetChanged();
//        if (peers.size() == 0) {
//            Log.d(WiFiDirectActivity.TAG, "No devices found");
//            return;
//        }
    }


    private static String getDeviceStatus(int deviceStatus) {
        Log.d(WiFiActivity.TAG, "Peer status :" + deviceStatus);
        switch (deviceStatus) {
            case WifiP2pDevice.AVAILABLE:
                return "Available";
            case WifiP2pDevice.INVITED:
                return "Invited";
            case WifiP2pDevice.CONNECTED:
                return "Connected";
            case WifiP2pDevice.FAILED:
                return "Failed";
            case WifiP2pDevice.UNAVAILABLE:
                return "Unavailable";
            default:
                return "Unknown";

        }
    }

    private class WiFiPeerListAdapter extends ArrayAdapter<WifiP2pDevice> {

        private List<WifiP2pDevice> items;

        public WiFiPeerListAdapter(Context context, int resource,List<WifiP2pDevice> objects) {
            super(context, resource,objects);
            items = objects;
        }
    }
}
