package com.example.loon.myapplication.WIFI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.loon.myapplication.R;

public class WiFiActivity extends AppCompatActivity implements WifiP2pManager.ChannelListener {


    public static final String TAG = "wifi_direct";

    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel wifiDirectChannel;
    private boolean isWifiP2pEnabled = false;


    private final IntentFilter intentFilter = new IntentFilter();
    private BroadcastReceiver receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi);

        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);


        initializeWiFiDirect();
    }


    /**
     * 初始化Wi-Fi
     */
    private  void  initializeWiFiDirect(){

        wifiP2pManager= (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);

        wifiDirectChannel =wifiP2pManager.initialize(this, Looper.getMainLooper(),null);

    }

    /**
     * Wi-Fi监听
     */
    private WifiP2pManager.ActionListener actionListener = new WifiP2pManager.ActionListener() {
        @Override
        public void onSuccess() {

        }

        @Override
        public void onFailure(int reason) {

            String failureMessage="WiFi Direct  failed :";
            switch (reason){
                case WifiP2pManager.BUSY:
                    failureMessage+= " busy ";
                    break;
                case  WifiP2pManager.ERROR:
                    failureMessage+= " error ";
                    break;
                case  WifiP2pManager.P2P_UNSUPPORTED:
                    failureMessage+= " P2P_UNSUPPORTED ";
                    break;
                default:
                    failureMessage+= " unknow error ";
                    break;
            }

            Log.d("错误信息",failureMessage);
        }
    };


    @Override
    public void onChannelDisconnected() {
        wifiP2pManager.initialize(this, getMainLooper(), this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        receiver = new WIFIBroadcastReceiver(wifiP2pManager, wifiDirectChannel, this);
        registerReceiver(receiver, intentFilter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void setIsWifiP2pEnabled(boolean isWifiP2pEnabled) {
        this.isWifiP2pEnabled = isWifiP2pEnabled;
    }
}
