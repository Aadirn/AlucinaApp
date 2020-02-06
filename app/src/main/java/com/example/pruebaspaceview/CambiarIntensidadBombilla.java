
package com.example.pruebaspaceview;
import android.os.AsyncTask;
import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

public class CambiarIntensidadBombilla extends AsyncTask<String,Object,Void> {

    private final BombillaListener listener;

    public interface BombillaListener{
        void bombilla(YeelightDevice result);
    }

    public CambiarIntensidadBombilla(BombillaListener listener){
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(String... strings) {

        YeelightDevice device = null;
        try {
            device = new YeelightDevice(strings[0]);

            if (listener != null){
                listener.bombilla(device);
            }

            System.out.println("llego aqui");
        } catch (YeelightSocketException ex) {
            System.err.println("no se ha podido conectar con la bombilla");
        }
  try {


            device.setRGB(10,26,35);
        } catch (YeelightResultErrorException ex) {

            System.err.println("no se ha podido encender");
        } catch (YeelightSocketException e) {
            System.err.println("no se ha podido conectar con la bomibilla para encender");
        }
     return null;
    }

}