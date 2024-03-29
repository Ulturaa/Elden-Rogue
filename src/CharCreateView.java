import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class CharCreateView {
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

    public void setCCButton(String btnLabel, ActionListener actionListener) {
        JButton CCButton = new JButton(btnLabel);

        CCButton.addActionListener(actionListener);
        CCButton.setPreferredSize(new Dimension(200, 30));

        CCButtonlist.add(CCButton);
        // CCFrame.add(CCButton);
    }

    public void composeCCButtonList() {
        Iterator<JButton> i = CCButtonlist.iterator();

        while (i.hasNext()) {
            this.CCFrame.add(i.next());
        }

    }

    public void setCCLabel(String s) {
        JLabel CCLabel = new JLabel();

        CCLabel.setText(s);
        CCLabel.setForeground(Color.YELLOW);
        CCLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        CCLabellist.add(CCLabel);
    }

    public void composeCCLabels() {
        Iterator<JLabel> i = CCLabellist.iterator();

        while (i.hasNext()) {
            this.CCFrame.add(i.next());
        }

    }

    public String createAndGetInput() {

        JTextField textField = new JTextField(25);

        // Create a JButton to submit the input
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 30));

        // Add ActionListener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String input = textField.getText();

                System.out.println("Input received: " + input);
            }
        });

        // Add the components to the frame
        JLabel inpLbl = new JLabel("Input Name: ");
        inpLbl.setForeground(Color.YELLOW);
        CCFrame.add(inpLbl);
        CCFrame.add(textField);
        CCFrame.add(submitButton);
        CCFrame.revalidate();
        CCFrame.repaint();
        // Set frame visibility
        // CC.setVisible(true);

        // Wait for input and return it
        return textField.getText();
    }

}
