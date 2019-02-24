package com.example.hp.customdrawingdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    Toast toast;

    String[] items = {"abc", "deg", "Xyz"};
    String[] sitem = {"orange", "red", "blue"};
    String[] mitem = {"bold", "italics", "normal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v = getLayoutInflater().inflate(R.layout.toastview,(ViewGroup) findViewById(R.id.toastlayout));
        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(v);
        toast.show();

//        myView = new MyView(this);
//        setContentView(myView);




    }

    public void showAlert(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("MyAlertDialog");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,items[i],Toast.LENGTH_LONG).show();
            }
        });

//        builder.setSingleChoiceItems(sitem, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, sitem[i],Toast.LENGTH_LONG).show();
//            }
//        });

//        builder.setMultiChoiceItems(mitem, null, new DialogInterface.OnMultiChoiceClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                Toast.makeText(MainActivity.this, b+","+i, Toast.LENGTH_LONG).show();
//            }
//        });

        builder.setView(getLayoutInflater().inflate(R.layout.toastview, null));
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
