package by.grodno.zagart.observer.observerandroid.activities;

import android.os.Bundle;

import by.grodno.zagart.observer.observerandroid.MainActivity;

public class A1 extends A {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNextActivity(A2.class);
        setPreviousActivity(MainActivity.class);
    }

}
