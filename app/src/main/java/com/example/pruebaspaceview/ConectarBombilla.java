package com.example.pruebaspaceview;

import android.graphics.Color;
import android.os.AsyncTask;
import android.sax.EndElementListener;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class ConectarBombilla extends AsyncTask<String,Object,Void> {

    private final BombillaListener listener;

    public interface BombillaListener{
        void bombilla(YeelightDevice result);
    }

    public ConectarBombilla(BombillaListener listener){
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

            System.out.println("llego aqui");
        } catch (YeelightSocketException ex) {
            ex.printStackTrace();
            System.err.println("no se ha podido conectar con la bombilla");
        }
        return null;
    }

}