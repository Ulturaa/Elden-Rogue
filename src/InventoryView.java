
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
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

    /**
     * Constructs an InventoryView and sets up the initial frame.
     */
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

    /**
     * Sets up buttons for general actions in the inventory view.
     * 
     * @param btnLabel       The label for the button.
     * @param actionListener The action listener for the button.
     */
    public void setIButton(String btnLabel, ActionListener actionListener) {
        JButton IButton = new JButton(btnLabel);
        IButton.addActionListener(actionListener);
        IButton.setPreferredSize(new Dimension(200, 30));

        IButtonlist.add(IButton);
    }

    /**
     * Sets up buttons for specific inventory item actions.
     * 
     * @param btnLabel       The label for the button.
     * @param actionListener The action listener for the button.
     */
    public void setICButton(String btnLabel, ActionListener actionListener) {
        JButton ICButton = new JButton(btnLabel);
        ICButton.addActionListener(actionListener);
        ICButton.setPreferredSize(new Dimension(100, 30));

        ICButtonlist.add(ICButton);
    }

    /**
     * Composes the general action buttons onto the GUI.
     */
    public void composeIButtonlist() {
        Iterator<JButton> i = IButtonlist.iterator();

        while (i.hasNext()) {
            this.IFrame.add(i.next());
        }
    }

    /**
     * Composes the specific item action buttons onto the GUI.
     */
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

    /**
     * Sets up labels for displaying information on the inventory view.
     * 
     * @param s The text to be displayed on the label.
     */
    public void setILabel(String s) {
        JLabel ILabel = new JLabel();

        ILabel.setText(s);
        ILabel.setForeground(Color.YELLOW);
        ILabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ILabellist.add(ILabel);
    }

    /**
     * Sets up a text area for displaying the weapons and their details
     * 
     * @param s The text to be displayed on the text area.
     */
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

    /**
     * Composes the labels onto the GUI.
     */
    public void composeILabels() {
        Iterator<JLabel> i = ILabellist.iterator();

        while (i.hasNext()) {
            this.IFrame.add(i.next());
        }

    }

    /**
     * Updates a specific label with new text.
     * 
     * @param index   The index of the label to be updated.
     * @param newText The new text to be displayed on the label.
     */
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

    /**
     * Sets the visibility of the inventory view.
     * 
     * @param b True to make the view visible, false otherwise.
     */
    public void setVisible(boolean b) {
        IFrame.setVisible(b);
    }

    /**
     * Closes the inventory view frame.
     */
    public void closeFrame() {
        IFrame.dispose();
    }

    /**
     * Refreshes the view of the JFrame to update to the latest
     */
    public void refresh() {
        IFrame.revalidate();
        IFrame.repaint();
    }

    /**
     * Sets the visibility of the button.
     */
    public void setIButtonvisbility(int i, boolean b) {
        IButtonlist.get(i).setVisible(b);
    }

    /**
     * Adds a scrollpane to the JFrame
     */
    public void scrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        scrollPane.setBackground(Color.BLACK);
        IFrame.add(scrollPane);
        IFrame.revalidate();
        IFrame.repaint();
    }

    /**
     * Creates a flow layout panel
     */
    public void createFlowLayoutPanel() {

        ipanel = new JPanel();

        ipanel.setLayout(new FlowLayout());
        ipanel.setBackground(Color.BLACK);

        IFrame.add(ipanel);
    }

    /**
     * Adds component to the panel
     */
    public void panelAdd(Component comp) {
        ipanel.add(comp);
    }

    /**
     * Removes the bttons from the panel
     */
    public void removeButtons() {

        for (JButton button : ICButtonlist) {
            ipanel.remove(button); // Remove the button from the panel
        }
        ipanel.revalidate();
        ipanel.repaint();
        ICButtonlist.clear();
    }

    /**
     * Sets the visibility of the panel
     */
    public void setVisiblepanel(boolean b) {
        ipanel.setVisible(b);
    }

    /**
     * Sets the visibility of the scrollpane
     */
    public void setVisibleScroll(boolean b) {
        scrollPane.setVisible(b);
    }

    /**
     * Sets the visibility of the label
     */
    public void setVisibleLabel(int i, boolean b) {
        ILabellist.get(i).setVisible(b);
    }
}
