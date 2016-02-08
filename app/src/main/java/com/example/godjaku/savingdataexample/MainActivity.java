package com.example.godjaku.savingdataexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    // for save data on local
    private SharedPreferences pref= null;

    private FragmentTransaction mFrgTransaction= null;
    private MainFragment mMain= null;

    private String mName= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume(){
        super.onResume();
        loadSharedPreference();
        makeView();
        moveFragment(0);
    }
    @Override
    public void onPause(){
        super.onPause();
        saveSharedPreference();
    }

    private void makeView(){
        mMain= new MainFragment();
    }
    public void moveFragment(int type){
        mFrgTransaction= getSupportFragmentManager().beginTransaction();
        switch(type){
            case 0: mFrgTransaction.add(R.id.container, mMain); break;
        }
        mFrgTransaction.commit();
    }

    public void setName(String name){ mName= name; }
    public String getName(){ return mName; }

    // save data on local
    private void saveSharedPreference(){
        if(pref == null) pref= getSharedPreferences("myapplication", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit= pref.edit();
        if(mName != null) edit.putString("name", mName);
        edit.commit();
    }
    // load data on local
    private void loadSharedPreference(){
        pref= getSharedPreferences("myapplication", Context.MODE_PRIVATE);
        mName= pref.getString("name", null);
    }
}