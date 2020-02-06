package com.example.pruebaspaceview;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import ui.fragmentBulbs.BulbFragment;
import yuku.ambilwarna.AmbilWarnaDialog;

public class ControlBombilla extends AppCompatActivity {

    public static YeelightDevice miBombilla;
    Context ctx;
    TextView tvRed;
    TextView tvGreen;
    TextView tvBlue;
    private int currentColor;
    FrameLayout frame;
    public static int r;
    public static int g;
    public static int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_bombilla);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }
    public void btnSelectColor(View view) {

        openDialog(false);

    }
    private void openDialog(boolean supportAlpha){

        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                currentColor = color;

                String hexColor = "#" + Integer.toHexString(currentColor).substring(2);

                 r = Integer.valueOf(hexColor.substring(1,3), 16);
                 g = Integer.valueOf(hexColor.substring(3,5), 16);
                 b = Integer.valueOf(hexColor.substring(5,7), 16);

                frame.setBackgroundColor(currentColor);

                    new CambiarColorBombilla().execute(miBombilla);


                tvRed.setText(""+ r);
                tvBlue.setText(""+ b);
                tvGreen.setText(""+ g);

                Window win = getWindow();
                win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            }


        });

        dialog.show();

    }



    private void init() {

         tvRed=findViewById(R.id.act_cntrl_txt_red);
         tvGreen=findViewById(R.id.act_cntrl_txt_green);
         tvBlue=findViewById(R.id.act_cntrl_txt_blue);
         frame = findViewById(R.id.act_control_view_prueba_color);


        final Switch switche=findViewById(R.id.act_cntrBombilla_switch);
        switche.setText("Encender");
        switche.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (miBombilla == null) {
                    return;
                }

                if(isChecked){
                    switche.setText("Apagar");
                    new EncenderBombilla().execute(miBombilla);
                }else{
                    switche.setText("Encender");
                    new ApagarBombilla().execute(miBombilla);
                }
            }
        });

        Button btn = findViewById(R.id.act_cntrl_btn_selector);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSelectColor(v);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        ctx=this;
    }


}