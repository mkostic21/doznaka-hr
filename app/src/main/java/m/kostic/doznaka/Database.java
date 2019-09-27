package m.kostic.doznaka;

import java.io.File;

class Database {
    private static Database instance = null;

    private Double[][] tablicaTarifa; //TODO: maybe make a separate class for this


    //InfoFragment data
    private String gospodarskaJedinica;
    private String odjelOdsjek;
    private Double povrsina;
    private String vrstaSjece;
    private String vrstaPrihoda;

    //VrsteFragment spinners data
    private String[] vrsta = new String[8];
    private int[] tarifa = new int[8];

    //DoznakaFragment data
    private int numberPickerValue;
    private int[] inputCount = new int[8];
    private int debStupanj;
    private double[] volume = new double[8];

    private double totalVolume = 0;
    private int totalInputCount = 0;


    //SumaFragment data
    private int selectedVrstaIndex = 0;

    //SumaVrstaFragment data
    private int selectedSumaVrstaIndex = 0;
    private double[][] sumaVrstaVolume = new double[8][18];
    private int[][] sumaVrstaInputCount = new int[8][18];

    //SubSumaVrstaData
    private int[][][] subSumaVrstaInputCount = new int[8][18][5];

    //XLS File
    File XLSdoznaka = null;

    //database core methods
    static Database getInstance() {
        if(instance == null)
            instance = new Database();
        return instance;
    }

    void setTablicaTarifa(Double[][] tablicaTarifa) {
        this.tablicaTarifa = tablicaTarifa;
    }



    //infoFragment methods
    void updateGospJed(String data){ gospodarskaJedinica = data; }
    void updateOdjelOdsjek(String data){ odjelOdsjek = data; }
    void updatePovrsina(Double data){ povrsina = data; }
    void updateVrstaSjece(String data){ vrstaSjece = data; }
    void updateVrstaPrihoda(String data){ vrstaPrihoda = data; }
    String getGospodarskaJedinica() {
        return gospodarskaJedinica;
    }
    String getOdjelOdsjek() {
        return odjelOdsjek;
    }
    double getPovrsina() {
        return povrsina;
    }
    String getVrstaSjece() {
        return vrstaSjece;
    }
    String getVrstaPrihoda() {
        return vrstaPrihoda;
    }


    //vrstaFragment methods
    void updateVrsta(String vrsta, int i){
        this.vrsta[i] = vrsta;
    }
    void updateTarifa(int tarifa, int i){
        this.tarifa[i] = tarifa;
    }
    String getVrsta(int i){
        return vrsta[i];
    }
    int getTarifa(int i){
        return tarifa[i];
    }


    //DoznakaFragment methods
    void updateNumberPickerValue(int value){
        numberPickerValue = value;
        calculateDebStupanj(value);
    }
    private void calculateDebStupanj(int value){
        if (value < 15)
            debStupanj = 0; //12.5
        else if (value < 20)
            debStupanj = 1; //17.5;
        else if (value < 25)
            debStupanj = 2; //22.5;
        else if (value < 30)
            debStupanj = 3; //27.5;
        else if (value < 35)
            debStupanj = 4; //32.5;
        else if (value < 40)
            debStupanj = 5; //37.5;
        else if (value < 45)
            debStupanj = 6; //42.5;
        else if (value < 50)
            debStupanj = 7; //47.5;
        else if (value < 55)
            debStupanj = 8; //52.5;
        else if (value < 60)
            debStupanj = 9; //57.5;
        else if (value < 65)
            debStupanj = 10; //62.5;
        else if (value < 70)
            debStupanj = 11; //67.5;
        else if (value < 75)
            debStupanj = 12; //72.5;
        else if (value < 80)
            debStupanj = 13; //77.5;
        else if (value < 85)
            debStupanj = 14; //82.5;
        else if (value < 90)
            debStupanj = 15; // 87.5;
        else if (value < 95)
            debStupanj = 16; //92.5;
        else if (value < 120)
            debStupanj = 17; // 97.5;
    }
    int getDebStupanj(){
        return debStupanj;
    }
    int getNumberPickerValue(){
        return numberPickerValue;
    }
    void incrementInputCount(){
        int index = calculateSubSumaVrstaIndex();

        inputCount[selectedVrstaIndex]++;
        sumaVrstaInputCount[selectedVrstaIndex][getDebStupanj()]++;
        subSumaVrstaInputCount[selectedVrstaIndex][getDebStupanj()][index]++;
        totalInputCount++;
    }
    void incrementInputCount(int index){
        inputCount[selectedVrstaIndex]++;
        sumaVrstaInputCount[selectedVrstaIndex][selectedSumaVrstaIndex]++;
        subSumaVrstaInputCount[selectedVrstaIndex][selectedSumaVrstaIndex][index]++;
        totalInputCount++;
    }
    void decrementInputCount(int index){
        inputCount[selectedVrstaIndex]--;
        sumaVrstaInputCount[selectedVrstaIndex][selectedSumaVrstaIndex]--;
        subSumaVrstaInputCount[selectedVrstaIndex][selectedSumaVrstaIndex][index]--;
        totalInputCount--;
    }
    void decrementInputCount(){
        int index = calculateSubSumaVrstaIndex();

        inputCount[selectedVrstaIndex]--;
        sumaVrstaInputCount[selectedVrstaIndex][getDebStupanj()]--;
        subSumaVrstaInputCount[selectedVrstaIndex][getDebStupanj()][index]--;
        totalInputCount--;
    }
    int getInputCount(int index){
        return inputCount[index];
    }
    Double getTarifaFromTable(int i, int j){
        return tablicaTarifa[i-1][j];
    }
    Double getVolume(int index){
        return volume[index];
    }
    void addVolume(int index){
        double value = getTarifaFromTable(tarifa[index], getDebStupanj());
        volume[index] += value;
        sumaVrstaVolume[selectedVrstaIndex][getDebStupanj()] += value;
        totalVolume += value;
    }
    void removeVolume(int index){
        double value = getTarifaFromTable(tarifa[index], getDebStupanj());
        volume[index] -= value;
        sumaVrstaVolume[selectedVrstaIndex][getDebStupanj()] -= value;
        totalVolume -= value;
    }
    Double getTotalVolume(){
        return totalVolume;
    }
    int getTotalInputCount(){
        return totalInputCount;
    }

    //SumaFragment methods
    void setSelectedVrstaIndex (int index){
        selectedVrstaIndex = index;
    }
    int getSelectedVrstaIndex(){
        return selectedVrstaIndex;
    }

    //SumaVrstaFragment methods

    double getSumaVrstaVolume(int vrsta, int stupanj){
        return sumaVrstaVolume[vrsta][stupanj];
    }
    int getSumaVrstaInputCount(int vrsta, int stupanj){
        return sumaVrstaInputCount[vrsta][stupanj];
    }
    void setSelectedSumaVrstaIndex(int index){
        selectedSumaVrstaIndex = index;
    }
    int getSelectedSumaVrstaIndex(){ return selectedSumaVrstaIndex; }

    //SubSumaVrstaFragment methods
    int calculateSubSumaVrstaIndex(){
        int value = numberPickerValue;
        value %= 10;
        if(value == 0 || value == 5)
            return 0;
        else if(value == 1 || value == 6)
            return 1;
        else if(value == 2 || value == 7)
            return 2;
        else if(value == 3 || value == 8)
            return 3;
        else if(value == 4 || value == 9)
            return 4;
        return -1;
    }
    int getSubSumaVrstaInputCount(int index){
        return subSumaVrstaInputCount[selectedVrstaIndex][selectedSumaVrstaIndex][index];
    }

    //XLS get/set
    File getDoznaka (){
        return XLSdoznaka;
    }
    void setDoznaka(File doznaka){
        XLSdoznaka = doznaka;
    }







}
