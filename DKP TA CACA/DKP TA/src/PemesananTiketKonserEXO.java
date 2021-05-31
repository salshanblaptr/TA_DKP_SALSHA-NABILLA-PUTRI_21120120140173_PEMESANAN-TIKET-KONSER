import javax.swing.*;

public class PemesananTiketKonserEXO {

    public JPanel panel;
    private JTextField txtNama;
    private JTextField txtIdentitas;
    private JTextField txtHargaTiket;
    private JTextField txtTotalHarga;
    private JRadioButton festivalEXO;
    private JRadioButton festivalPN;
    private JRadioButton festivalL;
    private JComboBox<String> cbJumlahTiket;
    private JButton submitButton;
    private JButton cancelButton;
    private FestivalType selectedFestivalType;

    public PemesananTiketKonserEXO() {

        // memberi listener (aksi) ketika radio button jenis konser di pilih.
        // info singkat juga, umumnya komponen radio button itu digunakan untuk
        // single selection, jadi pastikan hapus selection pada radio button lain
        // ketika salah radio button dipilih pengguna
        festivalEXO.addActionListener(e -> {
            festivalPN.setSelected(false);
            festivalL.setSelected(false);
            txtHargaTiket.setText("3000000");
            selectedFestivalType = new FestivalType();
            selectedFestivalType.setName("Festival E-X-O");
        });
        festivalPN.addActionListener(e -> {
            festivalEXO.setSelected(false);
            festivalL.setSelected(false);
            txtHargaTiket.setText("1650000");
            selectedFestivalType = new FestivalType();
            selectedFestivalType.setName("Festival P-N");
        });
        festivalL.addActionListener(e -> {
            festivalEXO.setSelected(false);
            festivalPN.setSelected(false);
            txtHargaTiket.setText("2500000");
            selectedFestivalType = new FestivalType();
            selectedFestivalType.setName("Festival L");
        });

        // memberi data option ke combo box jumlah tiket
        cbJumlahTiket.addItem("Pilih Jumlah Tiket");
        for (int i = 1; i <= 3; i++) cbJumlahTiket.addItem(String.valueOf(i));

        // memberi listener (aksi) ketika combo box jumlah tiket dipilih
        cbJumlahTiket.addActionListener(e -> {
            int selectedTicketCount = cbJumlahTiket.getSelectedIndex();
            if (selectedTicketCount <= 0) {
                JOptionPane.showMessageDialog(null, "Mohon pilih jumlah tiket yang diinginkan!");
            } else if (selectedFestivalType == null) {
                JOptionPane.showMessageDialog(null, "Mohon pilih tipe festival yang diinginkan!");
            } else {
                int hargaTiket = Integer.parseInt(txtHargaTiket.getText());
                int totalPrice = hargaTiket * selectedTicketCount;
                txtTotalHarga.setText(String.valueOf(totalPrice));
            }
        });

        // memberi listener (aksi) ketika button submit ditekan
        submitButton.addActionListener(e -> {
            int selectedTicketCount = cbJumlahTiket.getSelectedIndex();
            String name = txtNama.getText().trim();
            String identity = txtIdentitas.getText().trim();
            if (name.isEmpty() && identity.isEmpty() && selectedTicketCount == 0 && selectedFestivalType == null) {
                JOptionPane.showMessageDialog(null, "Formnya diisi dong!");
            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Duh, kayanya kamu lupa nulis namamu...");
            } else if (identity.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nomor identitas kamu tolong ditulis dulu ya...");
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        String.format(
                                "Hai %s, %d tiket %s kamu sudah berhasil dipesan!",
                                name,
                                selectedTicketCount,
                                selectedFestivalType.getName()
                        )
                );
            }
        });

        // memberi listener (aksi) ketika button cancel ditekan
        cancelButton.addActionListener(e -> {
            // kode dibawah ini buat exit aplikasi ya
            this.panel.setVisible(false);
            System.exit(0);
        });
    }
}


