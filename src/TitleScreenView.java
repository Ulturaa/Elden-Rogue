import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Color;
//import java.awt.font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenView {
    private JFrame titleScreenFrame;
    private JLabel titleLbl;
    private JButton startBtn, quitBtn;

    public TitleScreenView() {
        this.titleScreenFrame = new JFrame();
        this.titleScreenFrame.setSize(720, 480);
        this.titleScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.titleScreenFrame.setLocationRelativeTo(null);
        this.titleScreenFrame.setResizable(false);
        this.titleScreenFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.titleScreenFrame.getContentPane().setBackground(Color.black);

        titleLbl = new JLabel();
        titleLbl.setText("Elden Rogue");
        titleLbl.setForeground(Color.YELLOW);
        // titleLbl.setFont(new Font("MV Boli", Font.PLAIN, 20));

        this.titleScreenFrame.add(titleLbl);
        this.titleScreenFrame.setVisible(true);
    }

    public static void main(String[] args) {
        TitleScreenView tsv = new TitleScreenView();
    }
}
