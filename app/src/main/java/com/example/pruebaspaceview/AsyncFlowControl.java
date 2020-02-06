package com.example.pruebaspaceview;

import android.os.AsyncTask;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.enumeration.YeelightEffect;


public class AsyncFlowControl extends AsyncTask<YeelightDevice,Void,Void> {


    @Override
    protected Void doInBackground(YeelightDevice... yeelightDevices) {
        YeelightDevice yd = yeelightDevices[0];
        if(ControlBombilla.flowTime == 0){
            yd.setEffect(null);
        }else{
            yd.setEffect(YeelightEffect.SMOOTH);
            yd.setDuration(ControlBombilla.flowTime);
        }
        return null;
    }
}
