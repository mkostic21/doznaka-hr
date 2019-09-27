package m.kostic.doznaka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


public class VrsteFragment extends Fragment {
    private View myView;
    private Spinner[] vrste = new Spinner[8];
    private Spinner[] tarifa = new Spinner[8];

    private Database database = Database.getInstance();


    public VrsteFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_vrste, container, false);
        
        initializeWidgets();
        setListeners();

        return myView;
    }

    private void initializeWidgets(){
        
        vrste[0]= myView.findViewById(R.id.vrste_spinnerVrste1);
        vrste[1]= myView.findViewById(R.id.vrste_spinnerVrste2);
        vrste[2]= myView.findViewById(R.id.vrste_spinnerVrste3);
        vrste[3]= myView.findViewById(R.id.vrste_spinnerVrste4);
        vrste[4]= myView.findViewById(R.id.vrste_spinnerVrste5);
        vrste[5]= myView.findViewById(R.id.vrste_spinnerVrste6);
        vrste[6]= myView.findViewById(R.id.vrste_spinnerVrste7);
        vrste[7]= myView.findViewById(R.id.vrste_spinnerVrste8);

        tarifa[0]= myView.findViewById(R.id.vrste_spinnerTarifa1);
        tarifa[1]= myView.findViewById(R.id.vrste_spinnerTarifa2);
        tarifa[2]= myView.findViewById(R.id.vrste_spinnerTarifa3);
        tarifa[3]= myView.findViewById(R.id.vrste_spinnerTarifa4);
        tarifa[4]= myView.findViewById(R.id.vrste_spinnerTarifa5);
        tarifa[5]= myView.findViewById(R.id.vrste_spinnerTarifa6);
        tarifa[6]= myView.findViewById(R.id.vrste_spinnerTarifa7);
        tarifa[7]= myView.findViewById(R.id.vrste_spinnerTarifa8);
    }

    private void setListeners() {
        vrste[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[0].getSelectedItem().toString(), 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[1].getSelectedItem().toString(), 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[2].getSelectedItem().toString(), 2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[3].getSelectedItem().toString(), 3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[4].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[4].getSelectedItem().toString(), 4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[5].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[5].getSelectedItem().toString(), 5);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[6].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[6].getSelectedItem().toString(), 6);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vrste[7].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                database.updateVrsta(vrste[7].getSelectedItem().toString(), 7);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tarifa[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[0].getSelectedItem().toString()), 0);
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[1].getSelectedItem().toString()), 1);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[2].getSelectedItem().toString()), 2);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[3].getSelectedItem().toString()), 3);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[4].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[4].getSelectedItem().toString()), 4);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[5].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[5].getSelectedItem().toString()), 5);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[6].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[6].getSelectedItem().toString()), 6);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tarifa[7].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    database.updateTarifa(Integer.parseInt(tarifa[7].getSelectedItem().toString()), 7);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
