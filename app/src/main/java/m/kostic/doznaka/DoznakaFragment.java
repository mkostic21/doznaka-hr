package m.kostic.doznaka;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class DoznakaFragment extends Fragment {

    private View myView;
    private RadioButton[] radioVrsta = new RadioButton[8];
    private NumberPicker numberPicker;
    private FloatingActionButton confirmButton;
    private TextView[] history = new TextView[5];
    private int selectedIndex;

    private Database database = Database.getInstance();
    private HistoryHandler historyHandler = HistoryHandler.getInstance();


    public DoznakaFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_doznaka, container, false);

        initializeWidgets();
        displayHistory();
        setListeners();
        setRadioVrstaName();

        return myView;
    }

    private void initializeWidgets() {
        numberPicker = myView.findViewById(R.id.doznaka_numberPicker);
        numberPicker.setMaxValue(99);
        numberPicker.setMinValue(10);
        numberPicker.setWrapSelectorWheel(true);

        confirmButton = myView.findViewById(R.id.doznaka_confirm_button);

        //reverse order (0 is the latest input)
        history[0] = myView.findViewById(R.id.doznaka_history5);
        history[1] = myView.findViewById(R.id.doznaka_history4);
        history[2] = myView.findViewById(R.id.doznaka_history3);
        history[3] = myView.findViewById(R.id.doznaka_history2);
        history[4] = myView.findViewById(R.id.doznaka_history1);

        radioVrsta[0] = myView.findViewById(R.id.doznaka_radioButton1);
        radioVrsta[1] = myView.findViewById(R.id.doznaka_radioButton2);
        radioVrsta[2] = myView.findViewById(R.id.doznaka_radioButton3);
        radioVrsta[3] = myView.findViewById(R.id.doznaka_radioButton4);
        radioVrsta[4] = myView.findViewById(R.id.doznaka_radioButton5);
        radioVrsta[5] = myView.findViewById(R.id.doznaka_radioButton6);
        radioVrsta[6] = myView.findViewById(R.id.doznaka_radioButton7);
        radioVrsta[7] = myView.findViewById(R.id.doznaka_radioButton8);
        //first launch - invisible
        for(int i=0; i<8; i++){
            radioVrsta[i].setVisibility(View.GONE);
        }
    }

    private void setListeners() {
        radioVrsta[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(0);
            }
        });
        radioVrsta[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(1);
            }
        });
        radioVrsta[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(2);
            }
        });
        radioVrsta[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(3);
            }
        });
        radioVrsta[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(4);
            }
        });
        radioVrsta[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(5);
            }
        });
        radioVrsta[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(6);
            }
        });
        radioVrsta[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRadioButton(7);
            }
        });

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                database.updateNumberPickerValue(newVal);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSelected()){
                    Snackbar snackbar = Snackbar.make(myView.findViewById(R.id.nav_doznaka), "Spremljeno!", Snackbar.LENGTH_SHORT);
                    snackbar.setAction("Poništi", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            historyHandler.undo(selectedIndex);
                            displayHistory();

                        }
                    }).show();

                    try {
                        database.updateNumberPickerValue(numberPicker.getValue());
                        database.setSelectedVrstaIndex(selectedIndex);
                        database.incrementInputCount();
                        database.addVolume(selectedIndex);


                        updateHistory(selectedIndex);
                        displayHistory();

                        clearCheckedRadio();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
                else{
                    Toast.makeText(getContext(), "Greška!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void checkRadioButton(int currentIndex){
        for(int i=0;i<8;i++){
            if(radioVrsta[i].isChecked()){
                if(i!=currentIndex){
                    radioVrsta[i].setChecked(false);
                    break;
                }
            }
        }
    }

    private void clearCheckedRadio(){
        for(int i=0;i<8;i++){
            if(radioVrsta[i].isChecked()){
                radioVrsta[i].setChecked(false);
                break;
            }
        }
    }

    private boolean isSelected(){
        for(int i=0;i<8;i++){
            if(radioVrsta[i].isChecked() && database.getTarifa(i)!=0 ){
                selectedIndex = i;
                return true;
            }
        }
        return false;
    }

    private void setRadioVrstaName(){
        for(int i=0;i<8;i++){
            if((database.getVrsta(i)==null || database.getVrsta(i).isEmpty()) || database.getTarifa(i)==0){
                radioVrsta[i].setVisibility(View.GONE);
            }
            else{
                radioVrsta[i].setText(database.getVrsta(i));
                radioVrsta[i].setVisibility(View.VISIBLE);
            }
        }
    }

    private void updateHistory(int index){
        historyHandler.updateHistory(index);
    }

    private void displayHistory(){
        for(int i=0;i<5;i++) {
            history[i].setText(formatHistoryDisplay(i));
        }
    }

    private String formatHistoryDisplay(int index){
        if((historyHandler.getHistoryVrsta(index) == null) || (historyHandler.getHistoryPromjer(index) == null)){
            return "";
        }
        return (historyHandler.getHistoryVrsta(index) + " (" + historyHandler.getHistoryPromjer(index) + ')');
    }





}
