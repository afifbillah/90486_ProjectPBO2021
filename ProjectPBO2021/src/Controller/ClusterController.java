package Controller;

import Entity.*;
import Model.*;

import java.util.*;

public class ClusterController implements ClusterControllerInterface{
    Map<ClusterEntity, List<RecordEntity>> clusterRecords = new HashMap<ClusterEntity, List<RecordEntity>>();
    String text;

    @Override
    public void initiateClusterAndCentroid(int clusterNumber) {
        int counter = 1;

        Iterator<RecordEntity> iterator = AllObjectModel.record.getData().iterator();
        RecordEntity record = null;

        while (iterator.hasNext()) {
            record = iterator.next();
            if (counter<=clusterNumber)
            {
                record.setClusterNumber(counter);
                initializeCluster(counter,record);
                counter++;
            } else {
                text+=""+record+"\n";
                text+=""+"-Cluster Information-"+"\n";
                for (ClusterEntity cluster : AllObjectModel.modelcluster.getClusters()) {
                    text+=""+cluster+"\n";
                }
                text+=""+"-----------------"+"\n";
                double minDistance = Integer.MAX_VALUE;
                ClusterEntity whichCluster=null;

                for(ClusterEntity cluster : AllObjectModel.modelcluster.getClusters()) {
                    double distance = cluster.calculateDistance(record);
                    text+=""+cluster+"\n";
                    if (minDistance >distance) {
                        minDistance = distance;
                        whichCluster = cluster;
                    }
                }

                record.setClusterNumber(whichCluster.getClusterNumber());
                whichCluster.updateCentroid(record);
                clusterRecords.get(whichCluster).add(record);
            }

            text+=""+"-Cluster Information 1-"+"\n";
            for(ClusterEntity cluster : AllObjectModel.modelcluster.getClusters()) {
                text+=""+cluster+"\n";
            }
            text+=""+"----------------------"+"\n";
        }
    }

    @Override
    public void initializeCluster(int clusterNumber, RecordEntity record) {
        ClusterEntity cluster = new ClusterEntity(record.getTingkatKematian(),record.getJumlahKasus(),record.getPotensiPenularan(),clusterNumber);
        AllObjectModel.modelcluster.getClusters().add(cluster);
        List<RecordEntity> clusterRecord = new ArrayList<RecordEntity>();
        clusterRecord.add(record);
        clusterRecords.put(cluster, clusterRecord);
    }

    @Override
    public void FinalCluster() {
        text+="-- Final Cluster Information --\n";
        for(Map.Entry<ClusterEntity, List<RecordEntity> > entry : clusterRecords.entrySet()) {
            text+="Key = " + entry.getKey() + ",Value = "+entry.getValue()+"\n";
        }
        for (RecordEntity record : AllObjectModel.record.getData()) {
            text+=""+record+"\n";
        }

    }

    @Override
    public String ViewDataCluster() {
        FinalCluster();
        return this.text;
    }
}
