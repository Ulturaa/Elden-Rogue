import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class LevelUpView {
    private JFrame LVLFrame;
    private JLabel LVLTitle;

    private ArrayList<JButton> LVLButtonlist = new ArrayList<JButton>();
    private ArrayList<JLabel> LVLLabellist = new ArrayList<JLabel>();

    public LevelUpView() {
        LVLFrame = new JFrame();
        LVLFrame.setSize(720, 480);
        LVLFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LVLFrame.setLocationRelativeTo(null);
        LVLFrame.setResizable(false);
        LVLFrame.setLayout(new BoxLayout(LVLFrame.getContentPane(), BoxLayout.Y_AXIS));
        LVLFrame.getContentPane().setBackground(Color.black);

        LVLTitle = new JLabel("Choose the Stat you want to LEVEL UP");
        LVLTitle.setForeground(Color.YELLOW);
        LVLTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LVLTitle.setBounds(170, 20, 400, 60);

        LVLFrame.add(LVLTitle);

        LVLFrame.setVisible(true);
    }

    public void setLVLButton(String btnLabel, ActionListener actionListener) {
        JButton LVLButton = new JButton(btnLabel);
        LVLButton.addActionListener(actionListener);
        LVLButton.setPreferredSize(new Dimension(200, 30));

        LVLButtonlist.add(LVLButton);
    }

    public void composeLVLButtonlist() {
        Iterator<JButton> i = LVLButtonlist.iterator();

        while (i.hasNext()) {
            this.LVLFrame.add(i.next());
        }
    }

    public void setLVLLabel(String s) {
        JLabel LVLLabel = new JLabel();

        LVLLabel.setText(s);
        LVLLabel.setForeground(Color.YELLOW);
        LVLLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        LVLLabellist.add(LVLLabel);
    }

    public void composeLVLLabels() {
        Iterator<JLabel> i = LVLLabellist.iterator();

        while (i.hasNext()) {
            this.LVLFrame.add(i.next());
        }

    }

    public void updateLabel(int index, String newText) {
        if (index >= 0 && index < LVLLabellist.size()) {
            JLabel labelToUpdate = LVLLabellist.get(index);
            /// final String original = labelToUpdate.getText();
            labelToUpdate.setText(newText);

            LVLFrame.revalidate();
            LVLFrame.repaint();
        } else {
            System.out.println("Invalid index");
        }
    }

    public void compose() {
        Iterator<JLabel> i = LVLLabellist.iterator();
        Iterator<JButton> j = LVLButtonlist.iterator();
        while (i.hasNext()) {
            this.LVLFrame.add(i.next());
            this.LVLButtonlist.add(j.next());
        }
    }

    public void setVisible(boolean b) {
        LVLFrame.setVisible(b);
    }

    public JLabel sysMessage(String s) {
        JLabel sysLabel = new JLabel();

        sysLabel.setText(s);
        sysLabel.setForeground(Color.RED);
        sysLabel.setFont(new Font("Times New Roman", Font.BOLD, 10));
        sysLabel.setVisible(false);
        LVLFrame.add(sysLabel);
        LVLFrame.revalidate();
        LVLFrame.repaint();

        return sysLabel;

    }

    public void setVisibleMsg(JLabel l, boolean bool) {
        l.setVisible(bool);
    }

    public void closeFrame() {
        LVLFrame.dispose();
    }
}
