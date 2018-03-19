package com.example.user.dag2app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.dag2app.di.IComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    TextView tv3;

    @Inject
    Person tireon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        IComponent component = App.component(this);
        component.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tireon = new Person("Tireon", "Lanisters", "Peter Dinclage");

        tv = findViewById(R.id.name);
        tv2 = findViewById(R.id.house);
        tv3 = findViewById(R.id.actor_name);

        tv.setText(tireon.name);
        tv2.setText(tireon.house);
        tv3.setText(tireon.actorName);


    }
}



/**

 http://javainside.ru/ispolzovanie-dagger-2-v-android-prilozhenii/


 //возможны видимо и др подходы ...

 1) устанавливаем зависимости в градл

     For ex,

         dependencies {
         implementation 'com.google.dagger:dagger-android:2.11'
         implementation 'com.google.dagger:dagger-android-support:2.11' // if you use the support libraries
         annotationProcessor 'com.google.dagger:dagger-android-processor:2.11'
         annotationProcessor 'com.google.dagger:dagger-compiler:2.11'
         }


 2) смотрим что инжектировать, помечаем аннотацией @inject
 3) создаем module класс c provides методами для предоставления (инжектирования) необходимых зависимостей
 4) создаем компонент - там указываем какие модули будем использовать и видимо где их инжектить (еще уточняется)
 5) создаем класс App extends Application (в манифесте в Application добавляем android:name:".App")
 там настраиваем компоненты

     <application
     android:allowBackup="true" - for what?
     android:name=".MyApp">

 6) далее в нужных классых -> Например, MainActivity:

     IComponent component = App.component(this);
     component.inject(this);


 P.S.:
     -  методы inject(MainActivity mainActivity), inject(SomeClass someClass) - нужны для вызова inject(this) - в этих классах
     - Declare your singletons

 Можно заменять компоненты с помощью flavour или при тестировании.
 При тестировании:

 1) Создать новый модуль (можно заМОКанный модуль)
 2) создать TestApp extends Application (or extends already exist App : Application and use @Overrade method for use needed components(modules))

 3a)
    create TestMockerRunner : AndroidJUnitRunner and @Override  newApplication method
    config builf.gradle config testInstrumentationRunner 'com.your.package.TestMockerRunner'
    and maybe (or maybe not necessary  ) need activityTestRule.getActivity().runOnUIThread((runnable) -> ...)

 http://jordifierro.com/android-view-unit-testing


 3b) OR need init on @Before - https://medium.com/@oznusem/easy-way-to-mock-ui-espresso-tests-with-dagger-b2b7eba51272
 ... OR another way more - https://medium.com/appunite-edu-collection/ui-testing-on-android-with-dagger-espresso-and-mockito-12d37e5f613d
 ... https://engineering.circle.com/instrumentation-testing-with-dagger-mockito-and-espresso-f07b5f62a85b



    P.S.2:
  There are also :
    Scopes - for define singleton scope (App, Activity, Authorization)
    Subcomponents






 */