import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class LobbyView {
    private JFrame LFrame;
    private JLabel LTitle;

    private ArrayList<JButton> LButtonlist = new ArrayList<JButton>();
    private ArrayList<JLabel> LLabellist = new ArrayList<JLabel>();

    public LobbyView() {
        LFrame = new JFrame();
        LFrame.setSize(720, 480);
        LFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LFrame.setLocationRelativeTo(null);
        LFrame.setResizable(false);
        LFrame.setLayout(new BoxLayout(LFrame.getContentPane(), BoxLayout.Y_AXIS));
        LFrame.getContentPane().setBackground(Color.black);

        LTitle = new JLabel("Lobby");
        LTitle.setForeground(Color.YELLOW);
        LTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LTitle.setBounds(170, 20, 400, 60);

        LFrame.add(LTitle);

        LFrame.setVisible(true);
    }

    public void setLButton(String btnLabel, ActionListener actionListener) {
        JButton LButton = new JButton(btnLabel);
        LButton.addActionListener(actionListener);
        LButton.setPreferredSize(new Dimension(200, 30));

        LButtonlist.add(LButton);
    }

    public void composeLButtonlist() {
        Iterator<JButton> i = LButtonlist.iterator();

        while (i.hasNext()) {
            this.LFrame.add(i.next());
        }
    }

    public void setLLabel(String s) {
        JLabel LLabel = new JLabel();

        LLabel.setText(s);
        LLabel.setForeground(Color.YELLOW);
        LLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        LLabellist.add(LLabel);
    }

    public void composeLLabels() {
        Iterator<JLabel> i = LLabellist.iterator();

        while (i.hasNext()) {
            this.LFrame.add(i.next());
        }

    }

    public void updateLabel(int index, String newText) {
        if (index >= 0 && index < LLabellist.size()) {
            JLabel labelToUpdate = LLabellist.get(index);
            /// final String original = labelToUpdate.getText();
            labelToUpdate.setText(newText);

            LFrame.revalidate();
            LFrame.repaint();
        } else {
            System.out.println("Invalid index");
        }
    }

    public void setVisible(boolean b) {
        LFrame.setVisible(b);
    }

    public void Dispose() {
        LFrame.dispose();
    }
}
