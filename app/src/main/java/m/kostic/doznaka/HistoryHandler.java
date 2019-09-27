package m.kostic.doznaka;


class HistoryHandler {
    private static HistoryHandler instance = null;

    private Database database = Database.getInstance();

    private String[] historyVrsta = new String[5];
    private String[] historyPromjer = new String[5];
    private String lastVrsta;
    private String lastPromjer;
    


    static HistoryHandler getInstance(){
        if(instance == null){
            instance = new HistoryHandler();
        }
        return instance;
    }

    void updateHistory(int index){
        lastVrsta = historyVrsta[4];
        historyVrsta[4] = historyVrsta[3];
        historyVrsta[3] = historyVrsta[2];
        historyVrsta[2] = historyVrsta[1];
        historyVrsta[1] = historyVrsta[0];
        historyVrsta[0] = database.getVrsta(index);

        lastPromjer = historyPromjer[4];
        historyPromjer[4] = historyPromjer[3];
        historyPromjer[3] = historyPromjer[2];
        historyPromjer[2] = historyPromjer[1];
        historyPromjer[1] = historyPromjer[0];
        historyPromjer[0] = String.valueOf(database.getNumberPickerValue());

    }

    void undo(int index){
        database.decrementInputCount();
        database.removeVolume(index);

        historyVrsta[0] = historyVrsta[1];
        historyVrsta[1] = historyVrsta[2];
        historyVrsta[2] = historyVrsta[3];
        historyVrsta[3] = historyVrsta[4];
        historyVrsta[4] = lastVrsta;

        historyPromjer[0] = historyPromjer[1];
        historyPromjer[1] = historyPromjer[2];
        historyPromjer[2] = historyPromjer[3];
        historyPromjer[3] = historyPromjer[4];
        historyPromjer[4] = lastPromjer;
    }

    String getHistoryVrsta(int index){
        return historyVrsta[index];
    }
    String getHistoryPromjer(int index){
        return historyPromjer[index];
    }
}
