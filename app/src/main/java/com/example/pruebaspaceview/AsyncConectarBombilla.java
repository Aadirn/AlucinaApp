package com.example.pruebaspaceview;

import android.graphics.Color;
import android.os.AsyncTask;
import android.sax.EndElementListener;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class AsyncConectarBombilla extends AsyncTask<String,Object,Void> {

    private final BombillaListener listener;

    public interface BombillaListener{
        void bombilla(YeelightDevice result);
    }

    public AsyncConectarBombilla(BombillaListener listener){
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(String... strings) {

        YeelightDevice device ;
        try {
            device = new YeelightDevice(strings[0]);

            if (listener != null){
                listener.bombilla(device);
            }
        } catch (YeelightSocketException ex) {
            Log.d("Socket","Fallo de conexión al establecer conexión");
        }
        return null;
    }

}