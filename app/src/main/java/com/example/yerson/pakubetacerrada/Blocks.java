package com.example.yerson.pakubetacerrada;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Blocks.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Blocks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Blocks extends Fragment {
    private LinearLayout layoutPadre, layoutSup, layoutInfIzq, layoutInfDer;
    String[] ColorList;
    int[] indices;
    private int Ca = 0, Cb = 1, Cc = 2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Blocks() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Blocks.
     */
    // TODO: Rename and change types and number of parameters
    public static Blocks newInstance(String param1, String param2) {
        Blocks fragment = new Blocks();
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
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_blocks, container, false);

        layoutPadre = (LinearLayout) v.findViewById(R.id.Padre);
        layoutSup = (LinearLayout) v.findViewById(R.id.Sup);
        layoutInfIzq = (LinearLayout) v.findViewById(R.id.InfIzq);
        layoutInfDer = (LinearLayout) v.findViewById(R.id.InfDer);
        ColorList=getResources().getStringArray(R.array.colorsH);

        indices = indice(ColorList.length);
        layoutSup.setBackgroundColor(Color.parseColor(ColorList[indices[0]]));
        layoutInfIzq.setBackgroundColor(Color.parseColor(ColorList[indices[1]]));
        layoutInfDer.setBackgroundColor(Color.parseColor(ColorList[indices[2]]));
        layoutPadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indices = indice(ColorList.length);
                layoutSup.setBackgroundColor(Color.parseColor(ColorList[indices[0]]));
                layoutInfIzq.setBackgroundColor(Color.parseColor(ColorList[indices[1]]));
                layoutInfDer.setBackgroundColor(Color.parseColor(ColorList[indices[2]]));
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private  int[] indice(int tamaño) {
        Random rand = new Random();
        int ciclo = 0;
        int[] result = new int[3];
        while (ciclo == 0) {
            result[0] = rand.nextInt(tamaño);
            result[1] = rand.nextInt(tamaño);
            result[2] = rand.nextInt(tamaño);
            if (result[0]!=result[1] && result[1]!=result[2] && result[0]!=result[2] && result[0]!=Ca && result[1]!=Cb && result[0]!=Cc ) {
                Ca=result[0];
                Cb=result[1];
                Cc=result[2];
                ciclo = 1;
            }
        }

        return result;
    }
}
