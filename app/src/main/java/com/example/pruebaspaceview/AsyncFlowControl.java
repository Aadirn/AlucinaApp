package com.example.pruebaspaceview;

import android.os.AsyncTask;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.enumeration.YeelightEffect;


public class AsyncFlowControl extends AsyncTask<YeelightDevice,Void,Void> {


    @Override
    protected Void doInBackground(YeelightDevice... yeelightDevices) {
        YeelightDevice yd = yeelightDevices[0];
        if(ControlBombilla.smoothTime == 0){
            yd.setEffect(null);
            Log.d("Bombilla","Flow apagado");
        }else{
            yd.setEffect(YeelightEffect.SMOOTH);
            yd.setDuration(ControlBombilla.smoothTime*1000);
            Log.d("Bombilla","Flow encendido a "+ControlBombilla.smoothTime+" segundos");
        }
        return null;
    }
}
