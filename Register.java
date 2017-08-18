package com.example.bilal.myapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Bilal on 6/24/2017.
 */

public class Register extends Fragment{

   private EditText name;
    private EditText email;
    private EditText pass;
    private Button reg;
    private Button back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    name=(EditText)view.findViewById(R.id.name);
        email=(EditText)view.findViewById(R.id.email);
        pass=(EditText)view.findViewById(R.id.pass);
        reg=(Button)view.findViewById(R.id.reg);
        back=(Button)view.findViewById(R.id.back);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=name.getText().toString().trim();
                String Email=email.getText().toString().trim();
                String password=pass.getText().toString().trim();

                if (username.equals("")&& password.equals("")&& email.equals(""))
                {
                    Toast.makeText(getActivity(),"please enter your username ,email and password",Toast.LENGTH_LONG).show();
                }
                else if (username.equals(""))
                {
                    Toast.makeText(getActivity(),"please enter your username",Toast.LENGTH_LONG).show();
                }
                else if (Email.equals("")){
                    Toast.makeText(getActivity(),"please enter your email",Toast.LENGTH_LONG).show();
                }
                else if (password.equals("")){
                    Toast.makeText(getActivity(),"please enter your password",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(),"welcome to home",Toast.LENGTH_LONG).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Login l=new Login();
                fragmentTransaction.replace(R.id.main_frame, l);
                fragmentTransaction.commit();
            }
        });




    }


}
