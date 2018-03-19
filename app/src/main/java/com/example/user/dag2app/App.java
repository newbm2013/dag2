package com.example.user.dag2app;

import android.app.Application;
import android.content.Context;

import com.example.user.dag2app.di.DaggerIComponent;
import com.example.user.dag2app.di.IComponent;
import com.example.user.dag2app.di.PersonModule;

public class App extends Application {


    IComponent component;


    public static IComponent component(Context context){
        return ((App) context.getApplicationContext()).component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerIComponent.builder()
                .personModule(new PersonModule())
                .build();
    }
}
