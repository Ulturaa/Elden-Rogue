import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;

public class InventoryView {
    private JFrame IFrame;
    private JLabel ITitle;
    private Weapon selectedWeapon;
    private JScrollPane scrollPane;
    private JPanel ipanel;

    private ArrayList<JButton> IButtonlist = new ArrayList<JButton>();
    private ArrayList<JButton> ICButtonlist = new ArrayList<JButton>();
    private ArrayList<JLabel> ILabellist = new ArrayList<JLabel>();
    // private ArrayList<JLabel> WLabellist = new ArrayList<JLabel>();

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

    public void setWeaponButtons(ArrayList<Weapon> weaponList) {

    }

    public void setIButton(String btnLabel, ActionListener actionListener) {
        JButton IButton = new JButton(btnLabel);
        IButton.addActionListener(actionListener);
        IButton.setPreferredSize(new Dimension(200, 30));

        IButtonlist.add(IButton);
    }

    public void setICButton(String btnLabel, ActionListener actionListener) {
        JButton ICButton = new JButton(btnLabel);
        ICButton.addActionListener(actionListener);
        ICButton.setPreferredSize(new Dimension(200, 30));

        ICButtonlist.add(ICButton);
    }

    public void composeIButtonlist() {
        Iterator<JButton> i = IButtonlist.iterator();

        while (i.hasNext()) {
            this.IFrame.add(i.next());
        }
    }

    public void composeICButtonlist() {
        Iterator<JButton> i = ICButtonlist.iterator();

        while (i.hasNext()) {
            this.ipanel.add(i.next());
        }
    }

    public void removeICButtonlist() {
        Iterator<JButton> i = ICButtonlist.iterator();

        while (i.hasNext()) {
            this.ipanel.remove(i.next());
        }
    }

    public void clearICButtonlist() {
        this.ICButtonlist = new ArrayList<JButton>();
    }

    public void setILabel(String s) {
        JLabel ILabel = new JLabel();

        ILabel.setText(s);
        ILabel.setForeground(Color.YELLOW);
        ILabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ILabellist.add(ILabel);
    }

    public void setWText(String s) {
        JTextArea WText = new JTextArea();

        WText.setText(s);
        WText.setBackground(Color.BLACK);
        WText.setForeground(Color.YELLOW);
        WText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        WText.setWrapStyleWord(true);
        WText.setLineWrap(true);

        scrollPane.setViewportView(WText);
        // WLabellist.add(WText);
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

    public void closeFrame() {
        IFrame.dispose();
    }

    public void createButtonsFromArray(ArrayList<Weapon> itemList, JPanel panel) {
        for (Weapon item : itemList) {
            JButton button = new JButton("item");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Handle button click event here
                    System.out.println("Button clicked: " + item);
                }
            });
            panel.add(button);
        }
    }

    public void refresh() {
        IFrame.revalidate();
        IFrame.repaint();
    }

    public void setIButtonvisbility(int i, boolean b) {
        IButtonlist.get(i).setVisible(b);
    }

    public void scrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(Color.BLACK);
        IFrame.add(scrollPane);
        IFrame.revalidate();
        IFrame.repaint();
    }

    public void createFlowLayoutPanel() {
        // Create a JPanel
        ipanel = new JPanel();

        // Set the layout manager to FlowLayout
        ipanel.setLayout(new FlowLayout());
        ipanel.setBackground(Color.BLACK);

        // Return the created panel
        IFrame.add(ipanel);
    }

    public void panelAdd(Component comp) {
        ipanel.add(comp);
    }

    public void removeButtons() {

        for (JButton button : ICButtonlist) {
            ipanel.remove(button); // Remove the button from the panel
        }
        ipanel.revalidate();
        ipanel.repaint();
        ICButtonlist.clear();
    }

    public void setVisiblepanel(boolean b) {
        ipanel.setVisible(b);
    }

    public void setVisibleScroll(boolean b) {
        scrollPane.setVisible(b);
    }
}
