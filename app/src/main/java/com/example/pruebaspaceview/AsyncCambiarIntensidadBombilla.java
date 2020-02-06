
package com.example.pruebaspaceview;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class AsyncCambiarIntensidadBombilla extends AsyncTask<YeelightDevice,Object,Void> {


    protected Void doInBackground(YeelightDevice... yeelightDevices) {
        try {

            yeelightDevices[0].setBrightness(ControlBombilla.lumValor);
        } catch (YeelightResultErrorException ex) {
            Log.d("Bombilla","Fallo de cambio de luminosidad");
        } catch (YeelightSocketException e) {
            Log.d("Socket","Fallo de conexion");
        } catch(java.lang.NoSuchMethodError err){
            Log.d("API","Problema de otro");
        }

        return null;
    }



}