import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenView{
    private JFrame titleScreenFrame;
    private JLabel titleLbl;
    private JButton startBtn, exitBtn;
    
    public TitleScreenView() {
        titleScreenFrame = new JFrame();
		titleScreenFrame.setSize(720, 480);
        titleScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleScreenFrame.setLocationRelativeTo(null);
        titleScreenFrame.setResizable(false);
		titleScreenFrame.setLayout(null);
        titleScreenFrame.getContentPane().setBackground(Color.black);

        titleLbl = new JLabel();
        titleLbl.setText("Elden Rogue");
        titleLbl.setForeground(Color.YELLOW);
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 70));
        titleLbl.setBounds(170, 50, 500,80);

        startBtn = new JButton();
        startBtn.setText("Start");
        startBtn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        startBtn.setFocusable(false);
        startBtn.setOpaque(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setBorderPainted(false);
        startBtn.setForeground(Color.YELLOW);
        startBtn.setBounds(300, 200, 110, 45);

        exitBtn = new JButton();
        exitBtn.setText("Exit");
        exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        exitBtn.setFocusable(false);
        exitBtn.setOpaque(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setBorderPainted(false);
        exitBtn.setForeground(Color.YELLOW);
        exitBtn.setBounds(300, 275, 110, 45);

        titleScreenFrame.add(titleLbl);
        titleScreenFrame.add(startBtn);
        titleScreenFrame.add(exitBtn);
        titleScreenFrame.setVisible(true);
    }

    /**
     * Sets an action listener for the Start button.
     *
     * @param actionListener The ActionListener to be set for the Start button.
     */
    public void StartBtnActionListener(ActionListener actionListener) {
        this.startBtn.addActionListener(actionListener);
	}

    /**
     * Sets an action listener for the Exit button.
     *
     * @param actionListener The ActionListener to be set for the Exit button.
     */
    public void ExitBtnActionListener(ActionListener actionListener) {
        this.exitBtn.addActionListener(actionListener);
	}

    public static void main(String[] args) {
        TitleScreenView tsv = new TitleScreenView();
    }
}


