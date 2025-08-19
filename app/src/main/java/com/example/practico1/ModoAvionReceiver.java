package com.example.practico1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class ModoAvionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

        if (isAirplaneModeOn) {
            Intent intentLlamadas = new Intent(Intent.ACTION_DIAL);
            intentLlamadas.setData(Uri.parse("tel:" + "2664553747."));
            /*
                Esta flag es crucial.
                Cuando inicias una Activity desde un contexto que no es una Activity
                (como un Service o un BroadcastReceiver),
                debes agregar esta flag.
                Le indica al sistema que la nueva actividad debe iniciarse
                en una nueva tarea. Sin esta flag, tu aplicación podría fallar.
                GEMINI
            */
            intentLlamadas.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            if (intentLlamadas.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intentLlamadas);
            }
        }
    }
}