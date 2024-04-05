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

    /**
     * Constructs a LevelUpView and sets up the initial frame.
     */
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

    /**
     * Sets up buttons for choosing the stat to level up.
     * 
     * @param btnLabel       The label for the button.
     * @param actionListener The action listener for the button.
     */
    public void setLVLButton(String btnLabel, ActionListener actionListener) {
        JButton LVLButton = new JButton(btnLabel);
        LVLButton.addActionListener(actionListener);
        LVLButton.setPreferredSize(new Dimension(200, 30));

        LVLButtonlist.add(LVLButton);
    }

    /**
     * Composes the buttons onto the GUI.
     */
    public void composeLVLButtonlist() {
        Iterator<JButton> i = LVLButtonlist.iterator();

        while (i.hasNext()) {
            this.LVLFrame.add(i.next());
        }
    }

    /**
     * Sets up labels for displaying the label of each statistic that can be leveled
     * up
     * 
     * @param s The text to be displayed on the label.
     */
    public void setLVLLabel(String s) {
        JLabel LVLLabel = new JLabel();

        LVLLabel.setText(s);
        LVLLabel.setForeground(Color.YELLOW);
        LVLLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        LVLLabellist.add(LVLLabel);
    }

    /**
     * Composes the labels onto the GUI.
     */
    public void composeLVLLabels() {
        Iterator<JLabel> i = LVLLabellist.iterator();

        while (i.hasNext()) {
            this.LVLFrame.add(i.next());
        }

    }

    /**
     * Updates a specific label with new text.
     * 
     * @param index   The index of the label to be updated.
     * @param newText The new text to be displayed on the label.
     */
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

    /**
     * Sets the visibility of the level up view.
     * 
     * @param b True to make the view visible, false otherwise.
     */
    public void setVisible(boolean b) {
        LVLFrame.setVisible(b);
    }

    /**
     * Creates a system message label with the specified text.
     * 
     * @param s The text for the system message.
     * @return The system message label.
     */
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

    /**
     * Sets the visibility of a system message label.
     * 
     * @param l    The system message label.
     * @param bool True to make the label visible, false otherwise.
     */
    public void setVisibleMsg(JLabel l, boolean bool) {
        l.setVisible(bool);
    }

    /**
     * Closes the level up view frame.
     */
    public void closeFrame() {
        LVLFrame.dispose();
    }
}
