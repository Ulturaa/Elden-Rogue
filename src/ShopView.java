import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ShopView {
    private JFrame SFrame;
    private JLabel STitle;

    private ArrayList<JButton> SButtonlist = new ArrayList<JButton>();
    private ArrayList<JLabel> SLabellist = new ArrayList<JLabel>();
    private ArrayList<JPanel> WPanellist = new ArrayList<JPanel>();
    private ArrayList<JButton> SwordButtonlist = new ArrayList<JButton>();
    private ArrayList<JButton> KatanaButtonlist = new ArrayList<JButton>();
    private ArrayList<JButton> WhipButtonlist = new ArrayList<JButton>();
    private ArrayList<JButton> GreatSwordButtonlist = new ArrayList<JButton>();
    private ArrayList<JButton> StaffButtonlist = new ArrayList<JButton>();
    private ArrayList<JButton> SealButtonlist = new ArrayList<JButton>();

    private ArrayList<JScrollPane> ScrollList = new ArrayList<JScrollPane>();
    private ArrayList<JTextArea> WeaponTextList = new ArrayList<JTextArea>();
    private ArrayList<JLabel> wImageList = new ArrayList<JLabel>();

    public ShopView() {
        SFrame = new JFrame();
        SFrame.setSize(720, 480);
        SFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SFrame.setLocationRelativeTo(null);
        SFrame.setResizable(false);
        SFrame.setLayout(new BoxLayout(SFrame.getContentPane(), BoxLayout.Y_AXIS));
        // SFrame.setLayout(new FlowLayout());
        SFrame.getContentPane().setBackground(Color.black);

        STitle = new JLabel("Shop");
        STitle.setForeground(Color.YELLOW);
        STitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        STitle.setBounds(170, 20, 400, 60);

        ImageIcon img = new ImageIcon(
                new ImageIcon("Weapons/ShortSword.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel ia = new JLabel();
        ia.setText("hello");
        ia.setIcon(img);

        SFrame.add(STitle);
        SFrame.add(ia);
        SFrame.setVisible(true);

    }

    public void setSButton(String btnLabel, ActionListener actionListener) {
        JButton SButton = new JButton(btnLabel);
        SButton.addActionListener(actionListener);
        SButton.setPreferredSize(new Dimension(200, 30));

        SButtonlist.add(SButton);
    }

    public void composeSButtonlist() {
        Iterator<JButton> i = SButtonlist.iterator();

        while (i.hasNext()) {
            this.SFrame.add(i.next());
        }
    }

    public void setSLabel(String s) {
        JLabel SLabel = new JLabel();

        SLabel.setText(s);
        SLabel.setForeground(Color.YELLOW);
        SLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        SLabellist.add(SLabel);
    }

    public void composeSLabels() {
        Iterator<JLabel> i = SLabellist.iterator();

        while (i.hasNext()) {
            this.SFrame.add(i.next());
        }

    }

    public void updateLabel(int index, String newText) {
        if (index >= 0 && index < SLabellist.size()) {
            JLabel labelToUpdate = SLabellist.get(index);
            /// final String original = labelToUpdate.getText();
            labelToUpdate.setText(newText);

            SFrame.revalidate();
            SFrame.repaint();
        } else {
            System.out.println("Invalid index");
        }
    }

    public void setVisible(boolean b) {
        SFrame.setVisible(b);
    }

    public void setSButtonvisbility(int i, boolean b) {
        SButtonlist.get(i).setVisible(b);
    }

    public void setWPanel() {
        JPanel wpanel = new JPanel();

        wpanel.setLayout(new FlowLayout());
        wpanel.setBackground(Color.BLACK);
        wpanel.setVisible(false);

        WPanellist.add(wpanel);
    }

    public void composeWPanellist() {
        Iterator<JPanel> i = WPanellist.iterator();

        while (i.hasNext()) {
            this.SFrame.add(i.next());
        }
    }

    public void setPanelVisible(int i, boolean b) {
        WPanellist.get(i).setVisible(b);
    }

    public void setSwordButton(String btnLabel, ActionListener actionListener) {
        JButton WButton = new JButton(btnLabel);
        WButton.addActionListener(actionListener);
        WButton.setPreferredSize(new Dimension(200, 30));

        SwordButtonlist.add(WButton);
    }

    public void setKatanaButton(String btnLabel, ActionListener actionListener) {
        JButton WButton = new JButton(btnLabel);
        WButton.addActionListener(actionListener);
        WButton.setPreferredSize(new Dimension(200, 30));

        KatanaButtonlist.add(WButton);
    }

    public void setWhipButton(String btnLabel, ActionListener actionListener) {
        JButton WButton = new JButton(btnLabel);
        WButton.addActionListener(actionListener);
        WButton.setPreferredSize(new Dimension(200, 30));

        WhipButtonlist.add(WButton);
    }

    public void setGreatSwordButton(String btnLabel, ActionListener actionListener) {
        JButton WButton = new JButton(btnLabel);
        WButton.addActionListener(actionListener);
        WButton.setPreferredSize(new Dimension(200, 30));

        GreatSwordButtonlist.add(WButton);
    }

    public void setStaffButton(String btnLabel, ActionListener actionListener) {
        JButton WButton = new JButton(btnLabel);
        WButton.addActionListener(actionListener);
        WButton.setPreferredSize(new Dimension(200, 30));

        StaffButtonlist.add(WButton);
    }

    public void setSealButton(String btnLabel, ActionListener actionListener) {
        JButton WButton = new JButton(btnLabel);
        WButton.addActionListener(actionListener);
        WButton.setPreferredSize(new Dimension(200, 30));

        SealButtonlist.add(WButton);
    }

    public void addtoPanel(int j, int type) {
        Iterator<JButton> i = SwordButtonlist.iterator();
        switch (type) {
            case 1:
                i = SwordButtonlist.iterator();
                break;
            case 2:
                i = KatanaButtonlist.iterator();
                break;
            case 3:
                i = WhipButtonlist.iterator();
                break;
            case 4:
                i = GreatSwordButtonlist.iterator();
                break;
            case 5:
                i = StaffButtonlist.iterator();
                break;
            case 6:
                i = SealButtonlist.iterator();
                break;

        }
        while (i.hasNext()) {
            this.WPanellist.get(j).add(i.next());
        }
    }

    public void setVisibleLabel(int i, boolean b) {
        SLabellist.get(i).setVisible(b);
    }

    public void setScroll() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(Color.BLACK);
        scrollPane.setPreferredSize(new Dimension(600, 200));

        ScrollList.add(scrollPane);
    }

    public void addScrolltoPanel(int j, int k) {
        WPanellist.get(j).add(ScrollList.get(k));

    }

    public void setVisibleScroll(int i, boolean b) {
        ScrollList.get(i).setVisible(b);
    }

    public void setWText(String s) {
        JTextArea WText = new JTextArea();

        WText.setText(s);
        WText.setBackground(Color.BLACK);
        WText.setForeground(Color.YELLOW);
        WText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        WText.setWrapStyleWord(true);
        WText.setLineWrap(true);

        WeaponTextList.add(WText);
        // scrollPane.setViewportView(WText);
        // WLabellist.add(WText);
    }

    public void addTexttoScroll(int j, int k) {
        // Iterator<JTextArea> i = WeaponTextList.iterator();

        // while (i.hasNext()) {
        this.ScrollList.get(j).setViewportView(WeaponTextList.get(k));
        // WPanellist.get(j).add(WeaponTextList.get(k));
        // ScrollList.get(j).setViewportView(WPanellist.get(j));
        SFrame.revalidate();
        SFrame.repaint();
        // }
    }

    public void setWeaponImage(String s) {
        ImageIcon wImage = new ImageIcon(s);
        JLabel wIMG = new JLabel();
        wIMG.setIcon(wImage);
        // JLabel wIMG = new JLabel(s);
        wImageList.add(wIMG);
    }

    public void addImagetoScroll(int j, int k) {
        JPanel viewportPanel = new JPanel(new FlowLayout());
        viewportPanel.add(wImageList.get(k));
        JScrollPane scrollPane = ScrollList.get(j);
        scrollPane.setViewportView(viewportPanel);

        SFrame.revalidate();
        SFrame.repaint();
    }

    public void addImagetoPanel(int j, int k) {
        WPanellist.get(j).add(wImageList.get(0));
    }
}
