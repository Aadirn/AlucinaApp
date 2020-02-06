package com.example.pruebaspaceview;


import android.os.AsyncTask;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class AsyncApagarBombilla extends AsyncTask<YeelightDevice,Object,Void> {


    @Override
    protected Void doInBackground(YeelightDevice... yeelightDevices) {
        try {
            yeelightDevices[0].setPower(false);
        }  catch (YeelightResultErrorException ex) {
            Log.d("Bombilla","Fallo de apagado de bombilla");
        } catch (YeelightSocketException e) {
            Log.d("Socket","Fallo de conexion");
        } catch(java.lang.NoSuchMethodError err){
            Log.d("API","Problema de otro");
        }
        return null;
    }



}