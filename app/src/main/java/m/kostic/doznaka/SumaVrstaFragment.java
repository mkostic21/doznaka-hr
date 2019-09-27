package m.kostic.doznaka;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class SumaVrstaFragment extends Fragment {

    private View myView;

    private TextView header;
    private TextView totalVolumen;
    private TextView totalN;
    private TextView[] debSt = new TextView[18];
    private TextView[] tarifa = new TextView[18];
    private TextView[] N = new TextView[18];
    private TextView[] V = new TextView[18];
    
    private Database database = Database.getInstance();
    private SubSumaVrstaFragment subSumaVrstaFragment = new SubSumaVrstaFragment();

    public SumaVrstaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_suma_vrsta, container, false);

        initializeWidgets();
        getData();
        setListeners();


        return myView;
    }

    @SuppressLint("DefaultLocale")
    private void getData() {
        try {
            int index = database.getSelectedVrstaIndex();

            header.setText(database.getVrsta(index));
            totalN.setText(String.valueOf(database.getInputCount(index)));
            totalVolumen.setText(String.format("%.3f", database.getVolume(index)));

            for (int i = 0; i < 18; i++) {
                tarifa[i].setText(String.valueOf(database.getTarifaFromTable(database.getTarifa(index), i)));
                N[i].setText(String.valueOf(database.getSumaVrstaInputCount(database.getSelectedVrstaIndex(),i)));
                V[i].setText(String.format("%.3f",database.getSumaVrstaVolume(database.getSelectedVrstaIndex(), i)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setListeners() {
        for(int i=0;i<18;i++) {
            final int index = i;
            debSt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database.setSelectedSumaVrstaIndex(index);
                    if (getFragmentManager() != null) {
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main, subSumaVrstaFragment).addToBackStack(null).commit();
                    }
                }
            });
        }
    }

    private void initializeWidgets() {
        header = myView.findViewById(R.id.suma_vrsta_header);
        totalVolumen = myView.findViewById(R.id.suma_vrsta_total_volumen);
        totalN = myView.findViewById(R.id.suma_vrsta_total_N);

        debSt[0]= myView.findViewById(R.id.suma_vrsta_debSt1);
        debSt[1]= myView.findViewById(R.id.suma_vrsta_debSt2);
        debSt[2]= myView.findViewById(R.id.suma_vrsta_debSt3);
        debSt[3]= myView.findViewById(R.id.suma_vrsta_debSt4);
        debSt[4]= myView.findViewById(R.id.suma_vrsta_debSt5);
        debSt[5]= myView.findViewById(R.id.suma_vrsta_debSt6);
        debSt[6]= myView.findViewById(R.id.suma_vrsta_debSt7);
        debSt[7]= myView.findViewById(R.id.suma_vrsta_debSt8);
        debSt[8]= myView.findViewById(R.id.suma_vrsta_debSt9);
        debSt[9]= myView.findViewById(R.id.suma_vrsta_debSt10);
        debSt[10]= myView.findViewById(R.id.suma_vrsta_debSt11);
        debSt[11]= myView.findViewById(R.id.suma_vrsta_debSt12);
        debSt[12]= myView.findViewById(R.id.suma_vrsta_debSt13);
        debSt[13]= myView.findViewById(R.id.suma_vrsta_debSt14);
        debSt[14]= myView.findViewById(R.id.suma_vrsta_debSt15);
        debSt[15]= myView.findViewById(R.id.suma_vrsta_debSt16);
        debSt[16]= myView.findViewById(R.id.suma_vrsta_debSt17);
        debSt[17]= myView.findViewById(R.id.suma_vrsta_debSt18);

        tarifa[0]= myView.findViewById(R.id.suma_vrsta_tarifa1);
        tarifa[1]= myView.findViewById(R.id.suma_vrsta_tarifa2);
        tarifa[2]= myView.findViewById(R.id.suma_vrsta_tarifa3);
        tarifa[3]= myView.findViewById(R.id.suma_vrsta_tarifa4);
        tarifa[4]= myView.findViewById(R.id.suma_vrsta_tarifa5);
        tarifa[5]= myView.findViewById(R.id.suma_vrsta_tarifa6);
        tarifa[6]= myView.findViewById(R.id.suma_vrsta_tarifa7);
        tarifa[7]= myView.findViewById(R.id.suma_vrsta_tarifa8);
        tarifa[8]= myView.findViewById(R.id.suma_vrsta_tarifa9);
        tarifa[9]= myView.findViewById(R.id.suma_vrsta_tarifa10);
        tarifa[10]= myView.findViewById(R.id.suma_vrsta_tarifa11);
        tarifa[11]= myView.findViewById(R.id.suma_vrsta_tarifa12);
        tarifa[12]= myView.findViewById(R.id.suma_vrsta_tarifa13);
        tarifa[13]= myView.findViewById(R.id.suma_vrsta_tarifa14);
        tarifa[14]= myView.findViewById(R.id.suma_vrsta_tarifa15);
        tarifa[15]= myView.findViewById(R.id.suma_vrsta_tarifa16);
        tarifa[16]= myView.findViewById(R.id.suma_vrsta_tarifa17);
        tarifa[17]= myView.findViewById(R.id.suma_vrsta_tarifa18);

        N[0]= myView.findViewById(R.id.suma_vrsta_n1);
        N[1]= myView.findViewById(R.id.suma_vrsta_n2);
        N[2]= myView.findViewById(R.id.suma_vrsta_n3);
        N[3]= myView.findViewById(R.id.suma_vrsta_n4);
        N[4]= myView.findViewById(R.id.suma_vrsta_n5);
        N[5]= myView.findViewById(R.id.suma_vrsta_n6);
        N[6]= myView.findViewById(R.id.suma_vrsta_n7);
        N[7]= myView.findViewById(R.id.suma_vrsta_n8);
        N[8]= myView.findViewById(R.id.suma_vrsta_n9);
        N[9]= myView.findViewById(R.id.suma_vrsta_n10);
        N[10]= myView.findViewById(R.id.suma_vrsta_n11);
        N[11]= myView.findViewById(R.id.suma_vrsta_n12);
        N[12]= myView.findViewById(R.id.suma_vrsta_n13);
        N[13]= myView.findViewById(R.id.suma_vrsta_n14);
        N[14]= myView.findViewById(R.id.suma_vrsta_n15);
        N[15]= myView.findViewById(R.id.suma_vrsta_n16);
        N[16]= myView.findViewById(R.id.suma_vrsta_n17);
        N[17]= myView.findViewById(R.id.suma_vrsta_n18);

        V[0] = myView.findViewById(R.id.suma_vrsta_volumen1);
        V[1] = myView.findViewById(R.id.suma_vrsta_volumen2);
        V[2] = myView.findViewById(R.id.suma_vrsta_volumen3);
        V[3] = myView.findViewById(R.id.suma_vrsta_volumen4);
        V[4] = myView.findViewById(R.id.suma_vrsta_volumen5);
        V[5] = myView.findViewById(R.id.suma_vrsta_volumen6);
        V[6] = myView.findViewById(R.id.suma_vrsta_volumen7);
        V[7] = myView.findViewById(R.id.suma_vrsta_volumen8);
        V[8] = myView.findViewById(R.id.suma_vrsta_volumen9);
        V[9] = myView.findViewById(R.id.suma_vrsta_volumen10);
        V[10] = myView.findViewById(R.id.suma_vrsta_volumen11);
        V[11] = myView.findViewById(R.id.suma_vrsta_volumen12);
        V[12] = myView.findViewById(R.id.suma_vrsta_volumen13);
        V[13] = myView.findViewById(R.id.suma_vrsta_volumen14);
        V[14] = myView.findViewById(R.id.suma_vrsta_volumen15);
        V[15] = myView.findViewById(R.id.suma_vrsta_volumen16);
        V[16] = myView.findViewById(R.id.suma_vrsta_volumen17);
        V[17] = myView.findViewById(R.id.suma_vrsta_volumen18);

    }


}
