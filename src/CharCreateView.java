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

/**
 * Constructor for CharcreateView
 * 
 * Holds main components of the Character creation gui such as the JFrame
 * 
 */
public class CharCreateView {
    private String nameInput;
    private String selectedJob;
    private JFrame CCFrame;
    private JLabel CCTitle, CharLbl;
    private JButton inpNameBtn, selectJobBtn, confirmBtn, backBtn;
    private ArrayList<JButton> CCButtonlist = new ArrayList<JButton>();
    private ArrayList<JLabel> CCLabellist = new ArrayList<JLabel>();

    public CharCreateView() {
        CCFrame = new JFrame();
        CCFrame.setSize(720, 480);
        CCFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CCFrame.setLocationRelativeTo(null);
        CCFrame.setResizable(false);
        CCFrame.setLayout(new BoxLayout(CCFrame.getContentPane(), BoxLayout.Y_AXIS));
        CCFrame.getContentPane().setBackground(Color.black);

        CCTitle = new JLabel();
        CCTitle.setText("Character Creation\n");
        CCTitle.setForeground(Color.YELLOW);
        CCTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        CCTitle.setBounds(170, 20, 400, 60);

        CCFrame.add(CCTitle);

        // CCFrame.add(CCTitle);
        // setCCButton("Button", null);

        CCFrame.setVisible(true);

    }

    /**
     * Creates buttons and adds them to an array list of buttons called CCButtonlist
     * 
     */
    public void setCCButton(String btnLabel, ActionListener actionListener) {
        JButton CCButton = new JButton(btnLabel);

        CCButton.addActionListener(actionListener);
        CCButton.setPreferredSize(new Dimension(200, 30));

        CCButtonlist.add(CCButton);
        // CCFrame.add(CCButton);
    }

    /**
     * Composes the CCButtonlist by adding them to the JFrame
     * 
     */
    public void composeCCButtonList() {
        Iterator<JButton> i = CCButtonlist.iterator();

        while (i.hasNext()) {
            this.CCFrame.add(i.next());
        }

    }

    /**
     * Creates JLabels and adds them to an arraylist called CCLabellist
     * 
     */
    public void setCCLabel(String s) {
        JLabel CCLabel = new JLabel();

        CCLabel.setText(s);
        CCLabel.setForeground(Color.YELLOW);
        CCLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        CCLabellist.add(CCLabel);
    }

    /**
     * Composes CCLabel list by adding the labels to the JFrame
     * 
     * 
     */
    public void composeCCLabels() {
        Iterator<JLabel> i = CCLabellist.iterator();

        while (i.hasNext()) {
            this.CCFrame.add(i.next());
        }

    }

    /**
     * Setter for the nameInput of the GUI
     * 
     */
    public void setNameinput(String s) {
        this.nameInput = s;
    }

    /**
     * This gets the text that was typed into the textfield an sets it into the
     * attribute
     */
    public void getTextfrom(JTextField textfield) {
        this.nameInput = textfield.getText();
    }

    /**
     * Getter for the username input
     * 
     * @return nameInput
     */
    public String getnameInput() {
        return this.nameInput;
    }

    /**
     * Does the process of inputting the username into the jOptionPane
     * 
     * 
     */
    public void getuserNameInput() {
        String input = JOptionPane.showInputDialog(null, "Enter your name:");
        if (input != null) {
            System.out.println("Input received: " + input);
            this.nameInput = input;
        } else{
            // User canceled the input dialog
            System.out.println("Input canceled.");
        }
    }

    /**
     * Getter for selected job
     * 
     * @return selected job
     */
    public String getSelectedJob() {
        return this.selectedJob;
    }

    /**
     * JOptionpane for the jobclass options
     * Once clicked the jobclass is chosen
     * 
     */
    public void showJobchoices() {
        // Create an array of button labels
        String[] jobs = { "Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet" };

        // Show the option pane with buttons
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Title", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, jobs, jobs[0]);

        // Set the selected option based on the user's choice
        if (choice == -1) {
            selectedJob = null; // No option selected or dialog closed
        } else {
            selectedJob = jobs[choice];
        }
    }

    /**
     * Updates the JLabels that are already on the Jframe using indexes an the
     * arraylist
     */
    public void updateLabel(int index, String newText) {
        if (index >= 0 && index < CCLabellist.size()) {
            JLabel labelToUpdate = CCLabellist.get(index);
            /// final String original = labelToUpdate.getText();
            labelToUpdate.setText(newText);

            CCFrame.revalidate();
            CCFrame.repaint();
        } else {
            System.out.println("Invalid index");
        }
    }

    /**
     * Displays the system messages of Characer creation
     * 
     */
    public JLabel sysMessage(String s) {
        JLabel sysLabel = new JLabel();

        sysLabel.setText(s);
        sysLabel.setForeground(Color.YELLOW);
        sysLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        CCFrame.add(sysLabel);
        CCFrame.revalidate();
        CCFrame.repaint();

        return sysLabel;
    }

    /**
     * Removes the system message
     */
    public void clearSysMessage(JLabel label) {
        CCFrame.remove(label);
        CCFrame.revalidate();
        CCFrame.repaint();
    }

    /**
     * Closes the JFrame and disposes it
     */
    public void closeFrame() {
        CCFrame.dispose();
    }

}
