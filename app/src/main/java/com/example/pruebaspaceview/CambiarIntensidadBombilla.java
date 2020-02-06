
package com.example.pruebaspaceview;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class CambiarIntensidadBombilla extends AsyncTask<YeelightDevice,Object,Void> {

 @Override

    protected Void doInBackground(YeelightDevice... yeelightDevices) {
        try {

            // Switch on the device
            yeelightDevices[0].setBrightness(ControlBombilla.valor);
        } catch (YeelightResultErrorException ex) {

            System.err.println("no se ha podido encender");
        } catch (YeelightSocketException e) {
            System.err.println("no se ha podido conectar con la bomibilla para encender");
        }catch(java.lang.NoSuchMethodError err){
            Log.d("API","Problema de otro");
        }
        return null;
    }

}