package Controller;

public interface RecordControllerInterface {
    public void InsertRecord(String provinsi, int TingkatKematian, int JumlahKasus, int PontensiPenularan);
    public void UpdateRecord(int index, String provinsi, int TingkatKematian, int JumlahKasus, int PontensiPenularan);
    public void DeleteRecord(int index);
    public String ViewDataRecord();
}
