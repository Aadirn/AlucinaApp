package ui.fragmentHome;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pruebaspaceview.ControlBombilla;
import com.example.pruebaspaceview.EncenderBombilla;
import com.example.pruebaspaceview.R;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName().toLowerCase();
    Context ctx;

    public HomeFragment(Context ctx) {
        this.ctx=ctx;
    }

    private HomeFragment() {

    }


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        botonEncender(view);
        botonApagar(view);
        bombilla(view);



    }

    private void bombilla(View view) {

        if (ctx == null){
            ctx = getActivity().getApplicationContext();
        }

        Button bombilla = view.findViewById(R.id.frg_home_btn_bombilla);
        bombilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, ControlBombilla.class);
                startActivity(intent);
            }
        });
    }

    private String obtenerIp(View view) {
        Log.d(TAG, "dentro ip");
        EditText miTexto = view.findViewById(R.id.frg_home_txtIp);
        String miIp=miTexto.getText().toString();
        Log.d(TAG, miIp);
        return miIp;
    }

    private void botonApagar(View view) {
        //Apagar Bombilla
    }

    private void botonEncender(final View view) {
        Button botonEncender = view.findViewById(R.id.frg_home_encender_btn);

        botonEncender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip = obtenerIp(view);
                Log.d(TAG, ip);
                System.out.println("Existe");
                //String ip ="192.168.1.68";


                new EncenderBombilla().execute(ip);
            }
        });
    }


}
