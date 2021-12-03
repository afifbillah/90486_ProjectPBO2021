package Model;

import Entity.RecordEntity;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<RecordEntity> data = new ArrayList<RecordEntity>();

    public void setData(List<RecordEntity> data) {
        this.data = data;
    }

    public List<RecordEntity> getData() {
        return data;
    }
}
