package com.innobiz.academiapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.VISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class InscriptionFragment extends Fragment {


    public InscriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inscription, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button curso1 = (Button) view.findViewById(R.id.curso1Btn);
        final TextView inscripcion = (TextView) view.findViewById(R.id.inscriptionTv);
        final EditText phone = (EditText) view.findViewById(R.id.phone);
        final CheckBox promo = (CheckBox) view.findViewById(R.id.promoCb);
        final Button send = (Button) view.findViewById(R.id.sendBtn);


        curso1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inscripcion.setVisibility(VISIBLE);
                phone.setVisibility(VISIBLE);
                promo.setVisibility(VISIBLE);
                send.setVisibility(VISIBLE);

            }
        });


        promo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getContext(), "Gracias!", Toast.LENGTH_SHORT).show();
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("*/*");
                intent.setData(Uri.parse("mailto:contacto@academiapp.cl"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Inscripción curso");
                intent.putExtra(Intent.EXTRA_TEXT, "Favor contactar al " + phone.getText().toString());
                startActivity(intent);
            }
        });


    }


}

