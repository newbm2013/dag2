package com.example.user.dag2app.di;


import com.example.user.dag2app.MainActivity;
import com.example.user.dag2app.Person;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
    modules = {
        PersonModule.class,
    }
)
public interface IComponent {
    //todo вот это пока не понял, обязательно и места указывать где должно инжектиться?
    void inject(MainActivity mainActivity);
    Person person();
}
