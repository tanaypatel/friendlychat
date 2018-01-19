package com.google.firebase.example.fireeats.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by tp0986611 on 1/19/2018.
 */

public class TeacherViewModel extends ViewModel {

    public List mClasses;

    public  TeacherViewModel(){

    }

    public List getmClasses() {
        return mClasses;
    }

    public void setmClasses(List mClasses) {
        this.mClasses = mClasses;
    }
}
