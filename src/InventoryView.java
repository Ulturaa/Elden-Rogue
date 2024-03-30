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

public class InventoryView {
    private JFrame IFrame;
    private JLabel ITitle;

    private ArrayList<JButton> IButtonlist = new ArrayList<JButton>();
    private ArrayList<JLabel> ILabellist = new ArrayList<JLabel>();

    public InventoryView() {
        IFrame = new JFrame();
        IFrame.setSize(720, 480);
        IFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IFrame.setLocationRelativeTo(null);
        IFrame.setResizable(false);
        IFrame.setLayout(new BoxLayout(IFrame.getContentPane(), BoxLayout.Y_AXIS));
        IFrame.getContentPane().setBackground(Color.black);

        ITitle = new JLabel("Inventory");
        ITitle.setForeground(Color.YELLOW);
        ITitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        ITitle.setBounds(170, 20, 400, 60);

        IFrame.add(ITitle);

        IFrame.setVisible(true);
    }

    public void setIButton(String btnLabel, ActionListener actionListener) {
        JButton IButton = new JButton(btnLabel);
        IButton.addActionListener(actionListener);
        IButton.setPreferredSize(new Dimension(200, 30));

        IButtonlist.add(IButton);
    }

    public void composeIButtonlist() {
        Iterator<JButton> i = IButtonlist.iterator();

        while (i.hasNext()) {
            this.IFrame.add(i.next());
        }
    }

    public void setILabel(String s) {
        JLabel ILabel = new JLabel();

        ILabel.setText(s);
        ILabel.setForeground(Color.YELLOW);
        ILabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ILabellist.add(ILabel);
    }

    public void composeILabels() {
        Iterator<JLabel> i = ILabellist.iterator();

        while (i.hasNext()) {
            this.IFrame.add(i.next());
        }

    }

    public void updateLabel(int index, String newText) {
        if (index >= 0 && index < ILabellist.size()) {
            JLabel labelToUpdate = ILabellist.get(index);
            /// final String original = labelToUpdate.getText();
            labelToUpdate.setText(newText);

            IFrame.revalidate();
            IFrame.repaint();
        } else {
            System.out.println("Invalid index");
        }
    }

    public void setVisible(boolean b) {
        IFrame.setVisible(b);
    }
}
