package com.example.lab2broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_FIRST_ACTION  = "fpoly.android.CUSTOM_INTENT";
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("onReceive", "onReceive");
        Bundle extras = intent.getExtras();
        String data = extras.getString("data");

        if (extras != null) {
            // Bắt sự kiện có cuộc gọi đến
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            try {
                if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Toast.makeText(context, phoneNumber, Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.e("Exception", String.valueOf(e));
            }
            try {
                // Get custom action
                if (intent.getAction().equals(MyBroadcastReceiver.ACTION_FIRST_ACTION)) {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                }

                // Kiểm tra dữ liệu nhập vào
                if (data.contains("MEM") || data.contains("VIP")) {
                    switch (data) {
                        case "MEM537128":
                            Toast.makeText(context, "Khuyến mãi 10%", Toast.LENGTH_SHORT).show();
                            break;
                        case "MEM537129":
                            Toast.makeText(context, "Khuyến mãi 20%", Toast.LENGTH_SHORT).show();
                            break;
                        case "VIP537128":
                            Toast.makeText(context, "Khuyến mãi 30%", Toast.LENGTH_SHORT).show();
                            break;
                        case "VIP537129":
                            Toast.makeText(context, "Khuyến mãi 50%", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(context, "Mã khuyến mãi không hợp lệ!", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(context, "Mã phải bắt đầu bằng MEM hoặc VIP", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
            }

        }

    }

}
