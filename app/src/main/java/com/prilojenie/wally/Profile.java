package com.prilojenie.wally;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class Profile extends Fragment{

    Activity activity;
    View parentHolder;
    Button btnLogOut;

    SharedPreferences sp;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = getActivity();
        parentHolder = inflater.inflate(R.layout.profile, container, false);

        btnLogOut = parentHolder.findViewById(R.id.btnLogOut);
        sp = activity.getSharedPreferences("LoginState", Context.MODE_PRIVATE);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

        return parentHolder;
    }

    private void logOut()
    {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("LoggedIn", false);
        editor.commit();
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
        activity.overridePendingTransition(0, 0);
    }
}

