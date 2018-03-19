package com.example.user.dag2app.di;


import com.example.user.dag2app.Person;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PersonModule {

    @Provides
    @Singleton
    public Person providePerson(){
        Person person = new Person("tireon2", "lanister2", "peter dincladge2");
        return person;
    }


}
