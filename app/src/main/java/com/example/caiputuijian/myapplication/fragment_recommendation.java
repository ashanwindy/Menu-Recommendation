package com.example.caiputuijian.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_recommendation.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_recommendation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_recommendation extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listView;
    private List<recommendmenubean> menulist;
    private MenuAdapter menuadapter;
    private View contentview;

    private OnFragmentInteractionListener mListener;

    public fragment_recommendation() {

    }

    public static fragment_recommendation newInstance(String param1, String param2) {
        fragment_recommendation fragment = new fragment_recommendation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        initmenulist();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentview = inflater.inflate(R.layout.fragment_recommendation, container, false);
        listView = contentview.findViewById(R.id.list);
        menuadapter = new MenuAdapter(getContext(), menulist);
        listView.setAdapter(menuadapter);
        return contentview;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initmenulist(){
        menulist = new ArrayList<>();
        menulist.add(new recommendmenubean("apple"));
        menulist.add(new recommendmenubean("banana"));
        menulist.add(new recommendmenubean("pear"));
        menulist.add(new recommendmenubean("watermelon"));
        menulist.add(new recommendmenubean("shit"));
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
