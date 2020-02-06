package com.example.pruebaspaceview;

import android.os.AsyncTask;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class AsyncEncenderBombilla extends AsyncTask<YeelightDevice,Void,Void> {


    @Override
    protected Void doInBackground(YeelightDevice... yeelightDevices) {

        try {
            yeelightDevices[0].setPower(true);
        } catch (YeelightResultErrorException ex) {

            Log.d("Bombilla","Fallo al encender");
        } catch (YeelightSocketException e) {
            Log.d("Socket","Fallo de conexion al encender");
        } catch(java.lang.NoSuchMethodError err){
            Log.d("API","Problema de otro");
        }
        return null;
    }



}