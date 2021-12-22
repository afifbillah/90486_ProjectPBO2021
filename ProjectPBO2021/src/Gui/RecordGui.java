package Gui;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import Model.AllObjectModel;
import Controller.AllObjectController;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RecordGui {
    JFrame frame_record;
    JButton insert,update,delete,hasil;

    JTextField textProvinsi, textTingkatKematian, textJumlahKasus, textPotensiPenularan;

    public RecordGui() {
        frame_record = new JFrame("GUI");
        frame_record.setSize(1000,700);

        frame_record.getContentPane().setBackground(Color.CYAN);

        JLabel judul = new JLabel("Klaster Covid 19");
        judul.setBounds(300,30,400,50);
        judul.setFont(new Font("Times New Roman", Font.BOLD,40));
        frame_record.add(judul);

        JLabel labelProvinsi = new JLabel("Provinsi");
        labelProvinsi.setBounds(30,100,100,30);
        frame_record.add(labelProvinsi);

        textProvinsi = new JTextField();
        textProvinsi.setBounds(140,100,320,30);
        frame_record.add(textProvinsi);

        JLabel labelTingkatKematian = new JLabel("Tingkat Kematian");
        labelTingkatKematian.setBounds(30,200,100,30);
        frame_record.add(labelTingkatKematian);

        textTingkatKematian = new JTextField();
        textTingkatKematian.setBounds(140,200,320,30);
        frame_record.add(textTingkatKematian);

        JLabel labelJumlahKasus = new JLabel("Jumlah Kasus");
        labelJumlahKasus.setBounds(30,300,100,30);
        frame_record.add(labelJumlahKasus);

        textJumlahKasus =  new JTextField();
        textJumlahKasus.setBounds(140,300,320,30);
        frame_record.add(textJumlahKasus);

        JLabel labelPotensiPenularan = new JLabel("Jumlah Potensi Kasus");
        labelPotensiPenularan.setBounds(30,400,100,30);
        frame_record.add(labelPotensiPenularan);

        textPotensiPenularan = new JTextField();
        textPotensiPenularan.setBounds(140,400,320,30);
        frame_record.add(textPotensiPenularan);

        insert = new JButton("Insert");
        insert.setBounds(140,500,80,30);
        insert.setBackground(Color.GREEN);
        frame_record.add(insert);

        update = new JButton("Update");
        update.setBounds(260,500,80,30);
        insert.setBackground(Color.GREEN);
        frame_record.add(update);

        delete = new JButton("Delete");
        delete.setBounds(380,500,80,30);
        delete.setBackground(Color.RED);
        frame_record.add(delete);

        JTable tabelRecord = new JTable();
        JScrollPane scroll = new JScrollPane(tabelRecord);
        scroll.setBounds(500,100,450,430);
        frame_record.add(scroll);
        tabelRecord.setModel(viewTabelBarang());

        tabelRecord.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ae) {
                int i = tabelRecord.getSelectedRow();
                String provinsi = tabelRecord.getModel().getValueAt(i, 0).toString();
                String tingkatKematian = tabelRecord.getModel().getValueAt(i, 1).toString();
                String jumlahKasus = tabelRecord.getModel().getValueAt(i, 2).toString();
                String potensiPenularan = tabelRecord.getModel().getValueAt(i, 3).toString();
                textProvinsi.setText(provinsi);
                textTingkatKematian.setText(tingkatKematian);
                textJumlahKasus.setText(jumlahKasus);
                textPotensiPenularan.setText(potensiPenularan);
            }
        });

        insert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String provinsi = textProvinsi.getText();
                    int tingkatKematian = Integer.parseInt(textTingkatKematian.getText());
                    int jumlahKasus = Integer.parseInt(textJumlahKasus.getText());
                    int potensiPenularan = Integer.parseInt(textPotensiPenularan.getText());
                    AllObjectController.recordcontroller.InsertRecord(provinsi, tingkatKematian, jumlahKasus, potensiPenularan);
                    tabelRecord.setModel(viewTabelBarang());
                    refreshText();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Format ada yang salah","information",JOptionPane.INFORMATION_MESSAGE);
                    refreshText();
                }
            }
        });

        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String provinsi = textProvinsi.getText();
                    int tingkatKematian = Integer.parseInt(textTingkatKematian.getText());
                    int jumlahKasus = Integer.parseInt(textJumlahKasus.getText());
                    int potensiPenularan = Integer.parseInt(textPotensiPenularan.getText());
                    int i = tabelRecord.getSelectedRow();
                    AllObjectController.recordcontroller.UpdateRecord(i,provinsi,tingkatKematian,jumlahKasus,potensiPenularan);
                    tabelRecord.setModel(viewTabelBarang());
                    refreshText();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Format ada yang salah","information",JOptionPane.INFORMATION_MESSAGE);
                    refreshText();
                }
            }
        });
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = tabelRecord.getSelectedRow();
                int result = JOptionPane.showConfirmDialog(null,"Yakin Hapus Data?", null, JOptionPane.YES_NO_OPTION);
                if (result==JOptionPane.YES_OPTION) {
                    AllObjectController.recordcontroller.DeleteRecord(i);
                    tabelRecord.setModel(viewTabelBarang());
                    refreshText();
                }else {
                    refreshText();
                }
            }
        });
        hasil = new JButton("Hasil");
        hasil.setBounds(870,600,80,30);
        hasil.setBackground(Color.yellow);
        frame_record.add(hasil);

        frame_record.setLocationRelativeTo(null);
        frame_record.setLayout(null);
        frame_record.setVisible(true);
        frame_record.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hasil.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                AllObjectController.clustercontroller.initiateClusterAndCentroid(3);
                ResultGui res = new ResultGui();
                frame_record.dispose();
            }
        });
    }
    public DefaultTableModel viewTabelBarang() {
        DefaultTableModel dataRecord = new DefaultTableModel();
        Object[] kolom = {"Provinsi", "TIngkat Kematian", "Jumlah Kasus", "Potensi Kematian"};
        dataRecord.setColumnIdentifiers(kolom);
        int panjang = AllObjectController.modelrecord.getData().size();
        for (int i = 0; i<panjang; i++) {
            Object[] data = new Object[4];
            data [0] = AllObjectModel.record.getData().get(i).getProvinsi();
            data [1] = AllObjectModel.record.getData().get(i).getTingkatKematian();
            data [2] = AllObjectModel.record.getData().get(i).getJumlahKasus();
            data [3] = AllObjectModel.record.getData().get(i).getPotensiPenularan();
            dataRecord.addRow(data);
        }
        return dataRecord;
    }
    public void refreshText() {
        textProvinsi.setText(null);
        textTingkatKematian.setText(null);
        textJumlahKasus.setText(null);
        textPotensiPenularan.setText(null);
    }
}
