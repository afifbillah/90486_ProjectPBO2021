/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpbo2021;

import Controller.AllObjectController;
import Model.AllObjectModel;

import java.util.Scanner;
/**
 *
 * @author mhsb
 */
public class ProjectPBO2021 {
static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  int pil;
        do {
            System.out.println("1. insert");
            System.out.println("2. update");
            System.out.println("3. delete");
            System.out.println("4. Lihat Hasil Clustering");
            System.out.println("0. Keluar");

            pil = input.nextInt();
            switch (pil) {
                case 1 : 
                    InputDataRecord();
                    System.out.println(AllObjectController.recordcontroller.ViewDataRecord());
                break;
                case 2 : 
                    UpdateDataRecord();
                    System.out.println(AllObjectController.recordcontroller.ViewDataRecord());
                break;
                case 3 : 
                    delete();
                    System.out.println(AllObjectController.recordcontroller.ViewDataRecord());
                break;
                case 4 : 
                    AllObjectController.clustercontroller.initiateClusterAndCentroid(3);
                    System.out.println(AllObjectController.clustercontroller.ViewDataCluster());
                    break;
            }
        } while(pil!=0);
    }

    static void InputDataRecord() {
        System.out.print("Provinsi = ");
        String provinsi = input.next();
        System.out.print("Tingkat Kematian = ");
        int tingkatkematian = input.nextInt();
        System.out.print("Jumlah Kasus = ");
        int jumlahkasus = input.nextInt();
        System.out.print("Potensi Penularan = ");
        int potensipenularan = input.nextInt();
        AllObjectController.recordcontroller.InsertRecord(provinsi, tingkatkematian, jumlahkasus, potensipenularan);
        System.out.println("Data berhasil diinput");
    }

    static void UpdateDataRecord() {
        boolean ketemu = false;
        int index = 0;
        System.out.print("Provinsi yang diupdate = ");
        String provinsi_cek = input.next();
        for (int i = 0;i< AllObjectModel.record.getData().size();i++) {
            if (provinsi_cek.equals(AllObjectModel.record.getData().get(i).getProvinsi())){
                ketemu = true;
                index = i;
            }
        }
        if (ketemu == true){
            System.out.print("Provinsi =");
            String provinsi = input.next();
            System.out.print("Tingkat Kematian =");
            int tingkatkematian = input.nextInt();
            System.out.print("Jumlah Kasus =");
            int jumlahkasus = input.nextInt();
            System.out.print("Potensi Penularan =");
            int potensipenularan = input.nextInt();
            AllObjectController.recordcontroller.UpdateRecord(index,provinsi,tingkatkematian,jumlahkasus,potensipenularan);
            System.out.println("Data berhasil terupdate");
        }else {
            System.out.println("Data tidak ada");
        }
    }

    static void delete() {
        boolean ketemu = false;
        int index = 0;
        System.out.print("Provinsi yang dihapus = ");
        String provinsi_cek = input.next();
        for (int i = 0; i < AllObjectModel.record.getData().size();i++) {
            if (provinsi_cek.equals(AllObjectModel.record.getData().get(i).getProvinsi())){
                ketemu = true;
                index = i;
            }
        }
        if (ketemu==true){
            AllObjectController.recordcontroller.DeleteRecord(index);
            System.out.println("Data berhasil dihapus");
        }else{
            System.out.println("Data tidak ada");
        }
    }
    
}
