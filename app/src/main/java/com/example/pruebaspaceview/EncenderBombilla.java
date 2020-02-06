package com.example.pruebaspaceview;

import android.graphics.Color;
import android.os.AsyncTask;
import android.sax.EndElementListener;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class EncenderBombilla extends AsyncTask<YeelightDevice,Void,Void> {


    @Override
    protected Void doInBackground(YeelightDevice... yeelightDevices) {

        try {

            // Switch on the device

            yeelightDevices[0].setPower(true);
        } catch (YeelightResultErrorException ex) {

            System.err.println("no se ha podido apagar");
        } catch (YeelightSocketException e) {
            System.err.println("no se ha podido conectar con la bomibilla para encender");
        } catch(java.lang.NoSuchMethodError err){
            Log.d("API","Problema de otro");
        }
        return null;
    }



}