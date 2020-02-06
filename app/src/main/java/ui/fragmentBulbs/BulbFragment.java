package ui.fragmentBulbs;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pruebaspaceview.ConectarBombilla;
import com.example.pruebaspaceview.R;
import com.example.pruebaspaceview.commBombilla;
import com.mollin.yapi.YeelightDevice;

import static com.example.pruebaspaceview.ControlBombilla.miBombilla;

public class BulbFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context ctx;
    private commBombilla comm;
    private  YeelightDevice device;


    public BulbFragment() {
        // Required empty public constructor
    }

    public BulbFragment(Context ctx) {
        this.ctx=ctx;
    }

    public BulbFragment(Context ctx, commBombilla commBombilla) {
        this.ctx=ctx;
        this.comm=commBombilla;
    }

    // TODO: Rename and change types and number of parameters
    public static BulbFragment newInstance(String param1, String param2) {
        BulbFragment fragment = new BulbFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private void init(View view) {
        if (ctx == null){
            ctx = getActivity().getApplicationContext();
        }
        final TextView txtIp=view.findViewById(R.id.frg_home_txtIp);
        Button btn = view.findViewById(R.id.frg_bulb_btn_conectar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conectarBombilla(txtIp);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.bulb_fragment, container, false);
        init(view);
        return view;
    }
    public void conectarBombilla(TextView txtIp){
        CharSequence ipChar= txtIp.getText();
        final String ip = ipChar.toString();
        Log.d("conexion",ip);
        new ConectarBombilla(new ConectarBombilla.BombillaListener() {
            @Override
            public void bombilla(YeelightDevice device) {
               Log.d("BOMBILLA","NULL: "+(device == null));
                miBombilla=device;

             }
        }).execute(ip);
    }


}
