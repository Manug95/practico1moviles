package com.example.practico1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ModoAvionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isModoAvionOn = intent.getBooleanExtra("state", false);

        if (isModoAvionOn) {
            Intent intentAppLlamadas = new Intent(Intent.ACTION_DIAL);
            intentAppLlamadas.setData(Uri.parse("tel:" + "2664553747"));
            /*
                Esta flag es crucial.
                Cuando inicias una Activity desde un contexto que no es una Activity
                (como un Service o un BroadcastReceiver), debes agregar esta flag.
                Le indica al sistema que la nueva actividad debe iniciarse
                en una nueva tarea. Sin esta flag, tu aplicación podría fallar.
                - EXPLICACION DE GEMINI
            */
            intentAppLlamadas.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intentAppLlamadas);
        }
    }
}