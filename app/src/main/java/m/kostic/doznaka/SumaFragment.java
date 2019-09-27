package m.kostic.doznaka;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;


public class SumaFragment extends Fragment {

    private View myView;
    
    private TextView[] vrsta = new TextView[8];
    private TextView[] volumen = new TextView[8];
    private TextView[] N = new TextView[8];
    private TextView totalN;
    private TextView totalVolumen;

    private Database database = Database.getInstance();
    private SumaVrstaFragment sumaVrstaFragment = new SumaVrstaFragment();

    public SumaFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_suma, container, false);
        
        initializeWidgets();
        setListeners();
        updateDisplay();

        return myView;
    }
    
    private void initializeWidgets(){

        totalN = myView.findViewById(R.id.suma_total_N);
        totalVolumen = myView.findViewById(R.id.suma_total_volumen);

        vrsta[0] = myView.findViewById(R.id.suma_vrsta1);
        vrsta[1] = myView.findViewById(R.id.suma_vrsta2);
        vrsta[2] = myView.findViewById(R.id.suma_vrsta3);
        vrsta[3] = myView.findViewById(R.id.suma_vrsta4);
        vrsta[4] = myView.findViewById(R.id.suma_vrsta5);
        vrsta[5] = myView.findViewById(R.id.suma_vrsta6);
        vrsta[6] = myView.findViewById(R.id.suma_vrsta7);
        vrsta[7] = myView.findViewById(R.id.suma_vrsta8);

        volumen[0] = myView.findViewById(R.id.suma_volumen1);
        volumen[1] = myView.findViewById(R.id.suma_volumen2);
        volumen[2] = myView.findViewById(R.id.suma_volumen3);
        volumen[3] = myView.findViewById(R.id.suma_volumen4);
        volumen[4] = myView.findViewById(R.id.suma_volumen5);
        volumen[5] = myView.findViewById(R.id.suma_volumen6);
        volumen[6] = myView.findViewById(R.id.suma_volumen7);
        volumen[7] = myView.findViewById(R.id.suma_volumen8);

        N[0] = myView.findViewById(R.id.suma_N1);
        N[1] = myView.findViewById(R.id.suma_N2);
        N[2] = myView.findViewById(R.id.suma_N3);
        N[3] = myView.findViewById(R.id.suma_N4);
        N[4] = myView.findViewById(R.id.suma_N5);
        N[5] = myView.findViewById(R.id.suma_N6);
        N[6] = myView.findViewById(R.id.suma_N7);
        N[7] = myView.findViewById(R.id.suma_N8);
    }

    private void setListeners(){
        if(database.getTarifa(0)>0) {
            if (database.getVrsta(0) != null)
                if (!database.getVrsta(0).equals("")) {
                    vrsta[0].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(0);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(1)>0) {
            if (database.getVrsta(1) != null)
                if (!database.getVrsta(1).equals("")) {
                    vrsta[1].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(1);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(2)>0) {
            if (database.getVrsta(2) != null)
                if (!database.getVrsta(2).equals("")) {
                    vrsta[2].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(2);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(3)>0) {
            if (database.getVrsta(3) != null)
                if (!database.getVrsta(3).equals("")) {
                    vrsta[3].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(3);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(4)>0) {
            if (database.getVrsta(4) != null)
                if (!database.getVrsta(4).equals("")) {
                    vrsta[4].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(4);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(5)>0) {
            if (database.getVrsta(5) != null)
                if (!database.getVrsta(5).equals("")) {
                    vrsta[5].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(5);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(6)>0) {
            if (database.getVrsta(6) != null)
                if (!database.getVrsta(6).equals("")) {
                    vrsta[6].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(6);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
        if(database.getTarifa(7)>0) {
            if (database.getVrsta(7) != null)
                if (!database.getVrsta(7).equals("")) {
                    vrsta[7].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                database.setSelectedVrstaIndex(7);
                                if (getFragmentManager() != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.content_main, sumaVrstaFragment).addToBackStack(null).commit();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
        }
    }

    @SuppressLint("DefaultLocale")
    private void updateDisplay(){

        totalVolumen.setText(String.format("%.3f", database.getTotalVolume()));
        totalN.setText(String.valueOf(database.getTotalInputCount()));

        for(int i=0;i<8;i++){
            vrsta[i].setText(database.getVrsta(i));
            if(database.getVrsta(i) == null|| database.getVrsta(i).equals("")){
                volumen[i].setText("");
                N[i].setText("");
            }
            else {
                volumen[i].setText(String.format("%.3f", database.getVolume(i)));
                N[i].setText(String.valueOf(database.getInputCount(i)));
            }
        }
    }

}
