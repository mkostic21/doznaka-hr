package m.kostic.doznaka;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class SubSumaVrstaFragment extends Fragment {
    
    private View myView;
    
    private TextView header;
    private TextView[] promjer = new TextView[5];
    private TextView[] N = new TextView[5];
    private ImageButton[] add = new ImageButton[5];
    private ImageButton[] subtract = new ImageButton[5];
    
    private Database database = Database.getInstance();

    public SubSumaVrstaFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_sub_suma_vrsta, container, false);

        initializeWidgets();
        setListeners();
        updateDisplay();

        return myView;
    }

    @SuppressLint("DefaultLocale")
    private void updateDisplay() {
        if(database.getSelectedSumaVrstaIndex()==0){
            header.setText(R.string.suma_vrsta_debSt_1);
            for(int i=0;i<5;i++){
                promjer[i].setText(String.format("%d",10+i));
            }
        }
        else if(database.getSelectedSumaVrstaIndex()==1){
            header.setText(R.string.suma_vrsta_debSt_2);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",15+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==2){
            header.setText(R.string.suma_vrsta_debSt_3);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",20+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==3){
            header.setText(R.string.suma_vrsta_debSt_4);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",25+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==4){
            header.setText(R.string.suma_vrsta_debSt_5);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",30+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==5){
            header.setText(R.string.suma_vrsta_debSt_6);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",35+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==6){
            header.setText(R.string.suma_vrsta_debSt_7);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",40+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==7){
            header.setText(R.string.suma_vrsta_debSt_8);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",45+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==8){
            header.setText(R.string.suma_vrsta_debSt_9);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",50+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==9){
            header.setText(R.string.suma_vrsta_debSt_10);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",55+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==10){
            header.setText(R.string.suma_vrsta_debSt_11);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",60+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==11){
            header.setText(R.string.suma_vrsta_debSt_12);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",65+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==12){
            header.setText(R.string.suma_vrsta_debSt_13);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",70+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==13){
            header.setText(R.string.suma_vrsta_debSt_14);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",75+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==14){
            header.setText(R.string.suma_vrsta_debSt_15);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",80+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==15){
            header.setText(R.string.suma_vrsta_debSt_16);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",85+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==16){
            header.setText(R.string.suma_vrsta_debSt_17);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",90+i));
        }
        else if(database.getSelectedSumaVrstaIndex()==17){
            header.setText(R.string.suma_vrsta_debSt_18);
            for(int i=0;i<5;i++)
                promjer[i].setText(String.format("%d",95+i));
        }

        for(int i=0;i<5;i++){
            N[i].setText(String.valueOf(database.getSubSumaVrstaInputCount(i)));
        }
    }

    private void setListeners() {
        for(int i=0;i<5;i++){
            final int index = i;
            add[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database.addVolume(database.getSelectedVrstaIndex());
                    database.incrementInputCount(index);
                    N[index].setText(String.valueOf(database.getSubSumaVrstaInputCount(index))); /* dynamic display update */
                }
            });

            subtract[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(database.getSubSumaVrstaInputCount(index)>0) {
                        database.removeVolume(database.getSelectedVrstaIndex());
                        database.decrementInputCount(index);
                        N[index].setText(String.valueOf(database.getSubSumaVrstaInputCount(index))); /* dynamic display update */
                    }
                }
            });
        }
    }

    private void initializeWidgets() {
        header = myView.findViewById(R.id.sub_suma_vrsta_header);
        
        promjer[0]= myView.findViewById(R.id.sub_suma_vrsta_promjer1);
        promjer[1]= myView.findViewById(R.id.sub_suma_vrsta_promjer2);
        promjer[2]= myView.findViewById(R.id.sub_suma_vrsta_promjer3);
        promjer[3]= myView.findViewById(R.id.sub_suma_vrsta_promjer4);
        promjer[4]= myView.findViewById(R.id.sub_suma_vrsta_promjer5);

        N[0]= myView.findViewById(R.id.sub_suma_vrsta_N1);
        N[1]= myView.findViewById(R.id.sub_suma_vrsta_N2);
        N[2]= myView.findViewById(R.id.sub_suma_vrsta_N3);
        N[3]= myView.findViewById(R.id.sub_suma_vrsta_N4);
        N[4]= myView.findViewById(R.id.sub_suma_vrsta_N5);

        add[0]= myView.findViewById(R.id.sub_suma_vrsta_add1);
        add[1]= myView.findViewById(R.id.sub_suma_vrsta_add2);
        add[2]= myView.findViewById(R.id.sub_suma_vrsta_add3);
        add[3]= myView.findViewById(R.id.sub_suma_vrsta_add4);
        add[4]= myView.findViewById(R.id.sub_suma_vrsta_add5);

        subtract[0]= myView.findViewById(R.id.sub_suma_vrsta_subtract1);
        subtract[1]= myView.findViewById(R.id.sub_suma_vrsta_subtract2);
        subtract[2]= myView.findViewById(R.id.sub_suma_vrsta_subtract3);
        subtract[3]= myView.findViewById(R.id.sub_suma_vrsta_subtract4);
        subtract[4]= myView.findViewById(R.id.sub_suma_vrsta_subtract5);
        
    }

}
