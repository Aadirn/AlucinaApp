package com.example.pruebaspaceview;

import android.graphics.Color;
import android.os.AsyncTask;
import android.sax.EndElementListener;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class AsyncConectarBombilla extends AsyncTask<String,Void,Void> {

    private final BombillaListener listener;
    YeelightDevice device ;
    public interface BombillaListener{
        void bombilla(YeelightDevice result);
    }

    public AsyncConectarBombilla(BombillaListener listener){
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(String... strings) {


        try {
            device = new YeelightDevice(strings[0]);

            if (listener != null){
                listener.bombilla(device);
            }
        } catch (YeelightSocketException ex) {
            device = null;
            if (listener != null){
                listener.bombilla(device);
            }
            Log.d("Socket","Fallo de conexión al establecer conexión");

        }
        return null;
    }

}