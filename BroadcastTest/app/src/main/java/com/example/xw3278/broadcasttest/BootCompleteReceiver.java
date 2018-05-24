package com.example.xw3278.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Toast.makeText(context, "Boot complete", Toast.LENGTH_LONG).show();
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
