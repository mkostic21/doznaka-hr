package m.kostic.doznaka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


public class InfoFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private View myView;
    private Spinner gospJedSpinner;
    private EditText odjelOdsjek;
    private EditText povrsina;
    private EditText vrstaSjece;
    private EditText vrstaPrihoda;

    private Database database = Database.getInstance();


    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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

    @SuppressWarnings("NullableProblems")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       myView = inflater.inflate(R.layout.fragment_info, container, false);

        initializeWidgets();
        setListeners();

        return myView;
    }

    private void initializeWidgets() {
        gospJedSpinner = myView.findViewById(R.id.info_spinner_gosp_jed);
        odjelOdsjek = myView.findViewById(R.id.info_editText_odjel_odsjek);
        povrsina = myView.findViewById(R.id.info_editText_povrsina);
        vrstaSjece = myView.findViewById(R.id.info_editText_vrsta_sjece);
        vrstaPrihoda = myView.findViewById(R.id.info_editText_vrsta_prihoda);
    }

    private void setListeners(){
        gospJedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateGospJed(gospJedSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        odjelOdsjek.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    database.updateOdjelOdsjek(odjelOdsjek.getText().toString());
                }
            }
        });

        povrsina.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(povrsina.getText().toString().equals(getString(R.string.info_povrsina_tooltip))) {
                    povrsina.setText("");
                }
                else if(povrsina.getText().toString().isEmpty()){
                    povrsina.setText(getString(R.string.info_povrsina_tooltip));
                }
                else{
                    database.updatePovrsina(Double.parseDouble(povrsina.getText().toString()));
                }
            }
        });

        vrstaSjece.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    database.updateVrstaSjece(vrstaSjece.getText().toString());
                }
            }
        });

        vrstaPrihoda.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    database.updateVrstaPrihoda(vrstaPrihoda.getText().toString());
                }
            }
        });
    }

}
