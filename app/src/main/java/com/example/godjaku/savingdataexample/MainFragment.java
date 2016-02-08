package com.example.godjaku.savingdataexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by godjaku on 2016. 2. 7..
 */
public class MainFragment extends Fragment {
    private View wholeView= null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle data){
        wholeView= inflater.inflate(R.layout.fragment_main, null);
        return wholeView;
    }

    @Override
    public void onResume(){
        super.onResume();
        makeView();
    }
    @Override
    public void onPause(){
        super.onPause();
    }

    private void makeView(){
        String name= ((MainActivity)getActivity()).getName();
        if(name != null && name.length() > 0) setNameOnView(name);
        ((Button)wholeView.findViewById(R.id.btnFragmentMainResult)).setOnClickListener(click);
    }

    private void setNameOnView(String name){ ((TextView)wholeView.findViewById(R.id.textFragmentMainResult)).setText(Html.fromHtml("Your name is <font color=\"red\">"+name+"</font>")); }

    View.OnClickListener click= new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String name= ((EditText)wholeView.findViewById(R.id.editFragmentMainInputName)).getText().toString();
            if(name == null || name.length() < 1) Toast.makeText(getActivity(), getResources().getString(R.string.str_inputname_err), Toast.LENGTH_SHORT).show();
            else{
                setNameOnView(name);
                ((MainActivity)getActivity()).setName(name);
            }
        }
    };
}
