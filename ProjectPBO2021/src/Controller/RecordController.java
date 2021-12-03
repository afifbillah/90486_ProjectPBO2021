package Controller;
import Entity.*;
import Model.*;

public class RecordController implements RecordControllerInterface{
    @Override
    public void InsertRecord(String provinsi, int TingkatKematinan, int JumlahKasus, int PotensiPenularan) {
        AllObjectModel.record.getData().add(new RecordEntity(provinsi, TingkatKematinan,JumlahKasus,PotensiPenularan));
    }

    @Override
    public void UpdateRecord(int index, String provinsi, int TingkatKematian, int JumlahKasus, int PontensiPenularan) {
        AllObjectModel.record.getData().set(index, new RecordEntity(provinsi,TingkatKematian,JumlahKasus,PontensiPenularan));
    }

    @Override
    public void DeleteRecord(int index) {
        AllObjectModel.record.getData().remove(index);
    }
    @Override
    public String ViewDataRecord() {
        String text;
        text="Provinsi\tTingkat Kematian\tJumlah Kasus\tPotensi Penularan\n";

        for (int i=0;i<AllObjectModel.record.getData().size();i++){
            text+=""+AllObjectModel.record.getData().get(i).getProvinsi() + "\t\t" +AllObjectModel.record.getData().get(i).getTingkatKematian()
                    +"\t\t\t\t\t"+AllObjectModel.record.getData().get(i).getJumlahKasus()
                    +"\t\t\t\t"+AllObjectModel.record.getData().get(i).getPotensiPenularan()+"\n";
        } return text;
    }
}
