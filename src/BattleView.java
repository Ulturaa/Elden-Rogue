import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BattleView {
    
    private JFrame battleFrm;
    private JButton atkBtn, dgeBtn;
    private JLabel eNameLbl, eHPLbl, eDmgLbl, eventLbl;

    public BattleView(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        battleFrm = new JFrame();
        battleFrm.setSize(480, 720);
        battleFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleFrm.setLocationRelativeTo(null);
        battleFrm.setResizable(false);
        battleFrm.setLayout(new GridBagLayout());
        battleFrm.getContentPane().setBackground(Color.black);

        eNameLbl = new JLabel();
        eNameLbl.setText("ENEMY NAME");
        eNameLbl.setSize(300,20);
        eNameLbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
        eNameLbl.setForeground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 0;

        eHPLbl = new JLabel();
        eHPLbl.setText("ENEMY HP");
        eHPLbl.setSize(300,20);
        eHPLbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
        eHPLbl.setForeground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 1;

        battleFrm.add(eNameLbl, gbc);
        battleFrm.add(eHPLbl, gbc);
        battleFrm.setVisible(true);
    }

    public static void main(String[] args) {
        new BattleView();
    }
}
