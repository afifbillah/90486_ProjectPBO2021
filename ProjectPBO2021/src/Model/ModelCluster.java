package Model;

import Entity.ClusterEntity;

import java.util.ArrayList;
import java.util.List;

public class ModelCluster {
    List<ClusterEntity> clusters = new ArrayList<ClusterEntity>();

    public void setClusters(List<ClusterEntity> clusters) {
        this.clusters = clusters;
    }

    public List<ClusterEntity> getClusters() {
        return clusters;
    }
}
