package Entity;

public class ClusterEntity {
    private int TingkatKematianCentroid;
    private int JumlahKasusCentroid;
    private int PotensiPenularan;
    private int clusterNumber;

    public ClusterEntity(int TingkatKematianCentroid, int JumlahKasusCentroid, int PotensiPenularan, int clusterNumber) {
        super();
        this.TingkatKematianCentroid = TingkatKematianCentroid;
        this.JumlahKasusCentroid = JumlahKasusCentroid;
        this.PotensiPenularan = PotensiPenularan;
        this.clusterNumber = clusterNumber;
    }

    public int getTingkatKematianCentroid() {
        return TingkatKematianCentroid;
    }
    public int getJumlahKasusCentroid() {
        return JumlahKasusCentroid;
    }
    public int getPotensiPenularan() {
        return PotensiPenularan;
    }
    public int getClusterNumber() {
        return clusterNumber;
    }
    public void setTingkatKematianCentroid(int tingkatKematianCentroid) {
        this.TingkatKematianCentroid = tingkatKematianCentroid;
    }
    public void setJumlahKasusCentroid(int jumlahKasusCentroid) {
        this.JumlahKasusCentroid = jumlahKasusCentroid;
    }
    public void setPotensiPenularan(int potensiPenularan) {
        this.PotensiPenularan = potensiPenularan;
    }
    public void setClusterNumber(int clusterNumber) {
        this.clusterNumber = clusterNumber;
    }
    public double calculateDistance(RecordEntity record) {
        return Math.sqrt(Math.pow((getTingkatKematianCentroid() -record.getTingkatKematian()),2) + Math.pow((getJumlahKasusCentroid() - record.getJumlahKasus()),2) + Math.pow((getPotensiPenularan() - record.getPotensiPenularan()),2));
    }
    public void updateCentroid(RecordEntity record) {
        setTingkatKematianCentroid((getTingkatKematianCentroid() + record.getTingkatKematian())/2);
        setJumlahKasusCentroid((getJumlahKasusCentroid()+ record.getJumlahKasus())/2);
        setPotensiPenularan((getPotensiPenularan()+ record.getPotensiPenularan())/2);
    }
    @Override
    public String toString() {
        return "Cluster[TingkatKematianCentroid=" + TingkatKematianCentroid + ",JumlahKasusCentroid=" + JumlahKasusCentroid + ",PotensiPenularan=" + PotensiPenularan + ",clusterNumber=" + clusterNumber + "]";
    }
}
