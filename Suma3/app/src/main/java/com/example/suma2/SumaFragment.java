package com.example.suma2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SumaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SumaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText dig1;
    private EditText dig2;
    private TextView resultado;
    private Button sumar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SumaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SumaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SumaFragment newInstance(String param1, String param2) {
        SumaFragment fragment = new SumaFragment();
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
        View view =inflater.inflate(R.layout.fragment_suma, container, false);
        super.onCreate(savedInstanceState);

        dig1 = view.findViewById(R.id.dig1);
        dig2 = view.findViewById(R.id.dig2);
        resultado = view.findViewById(R.id.resul);
        sumar = view.findViewById(R.id.btn_suma);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1,num2;
                int resul_int;
                num1 = dig1.getText().toString();
                num2 = dig2.getText().toString();
                resul_int = (Integer.parseInt(num1)+Integer.parseInt(num2));
                resultado.setText(Integer.toString(resul_int));

            }
        });
        return view;
    }


}