package com.example.loon.myapplication.WIFI;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.loon.myapplication.R;

/**
 * Created by loon on 16/3/17.
 */
public class WIFIBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel channel;
    private WiFiActivity activity;


    public WIFIBroadcastReceiver(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, WiFiActivity activity) {
        this.wifiP2pManager = wifiP2pManager;
        this.channel = channel;
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        

        switch (action){
            case  WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION:
                int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
                if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {

                    activity.setIsWifiP2pEnabled(true);
                } else {

                    activity.setIsWifiP2pEnabled(false);
//                    activity.resetData();
                }
            case  WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION:
                if (wifiP2pManager != null) {
//                    wifiP2pManager.requestPeers(channel, (WifiP2pManager.PeerListListener) activity.getFragmentManager()
//                            .findFragmentById(R.id.device_list));
                }
                Log.d(WiFiActivity.TAG, "P2P peers changed");
                break;
            case  WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION:
                break;
            case  WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION:
                break;
            default:
                break;

        }

    }
}
