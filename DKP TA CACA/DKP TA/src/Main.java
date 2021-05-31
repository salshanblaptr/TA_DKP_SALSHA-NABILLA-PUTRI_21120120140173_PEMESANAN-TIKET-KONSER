import javax.swing.*;

public class Main {

    // ini method main untuk menampilkan form utama aplikasi mu
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("EXO PLANET");
        jFrame.setContentPane(new PemesananTiketKonserEXO().panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(true);
        jFrame.setVisible(true);
    }
}
