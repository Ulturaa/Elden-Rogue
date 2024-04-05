import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;


public class CreditsView {
    
    JFrame creditsFrame;
    JLabel thanksLbl, titleLbl, devsTitleLbl, devsNameLbl, bar;
    JButton returnBtn;

    /**
     * This is the constructor for the Credits view. This sets up the Frame, Labels, and Buttons
     * of the view.
     * 
     * @param devs  An ArrayList of the names of the developers.
     */
    public CreditsView(ArrayList<String> devs) {

        creditsFrame = new JFrame();
        creditsFrame.setTitle("Elden Rogue");
        creditsFrame.setSize(720, 480);
        creditsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creditsFrame.setLocationRelativeTo(null);
        creditsFrame.setResizable(false);
        creditsFrame.setLayout(null);
        creditsFrame.getContentPane().setBackground(Color.black);
        
        thanksLbl = new JLabel("<html><div style='text-align: center;'>" + "THANK YOU FOR PLAYING"+ "</div></html>", SwingConstants.CENTER);
        thanksLbl.setForeground(Color.white);
        thanksLbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thanksLbl.setAlignmentX(JLabel.CENTER);
        thanksLbl.setBounds(0, 50, 720, 25);

        titleLbl = new JLabel("<html><div style='text-align: center;'>" + "ELDEN ROGUE" + "</div></html>", SwingConstants.CENTER);
        titleLbl.setForeground(Color.YELLOW);
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 55));
        titleLbl.setAlignmentX(JLabel.CENTER);
        titleLbl.setBounds(0, 80, 720, 65);

        devsTitleLbl = new JLabel("<html><div style='text-align: center;'>" + "DEVELOPERS" + "</div></html>", SwingConstants.CENTER);
        devsTitleLbl.setForeground(Color.YELLOW);
        devsTitleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        devsTitleLbl.setAlignmentX(JLabel.CENTER);
        devsTitleLbl.setBounds(0, 175, 720, 25);

        bar = new JLabel("<html><div style='text-align: center;'>" + "__________________________________" + "</div></html>", SwingConstants.CENTER);
        bar.setForeground(Color.YELLOW);
        bar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        bar.setAlignmentX(JLabel.CENTER);
        bar.setBounds(0, 190, 720, 25);


        String devNames = "";
        for(int i = 0; i < devs.size(); i++) {
            devNames += devs.get(i) + "<br>";
        }

        devsNameLbl = new JLabel("<html><div style='text-align: center;'>" + devNames + "</div></html>", SwingConstants.CENTER);
        devsNameLbl.setForeground(Color.white);
        devsNameLbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        devsNameLbl.setAlignmentX(JLabel.CENTER);
        devsNameLbl.setBounds(0, 225, 720, 35*devs.size());

        returnBtn = new JButton();
        returnBtn.setText("RETURN");
        returnBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        returnBtn.setFocusable(false);
        returnBtn.setOpaque(false);
        returnBtn.setContentAreaFilled(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setForeground(Color.WHITE);
        returnBtn.setBounds(5, 395, 115, 25);

        creditsFrame.add(thanksLbl);
        creditsFrame.add(titleLbl);
        creditsFrame.add(devsTitleLbl);
        creditsFrame.add(bar);
        creditsFrame.add(devsNameLbl);
        creditsFrame.add(returnBtn);
        creditsFrame.setVisible(true);
    }

    /**
     * Sets an action listener for the Start button.
     *
     * @param actionListener The ActionListener to be set for the Start button.
     */
    public void ReturnBtnActionListener(ActionListener actionListener) {
        this.returnBtn.addActionListener(actionListener);
    }

    public void CreditsFrameWindowListener(WindowAdapter windowAdapter) {
        this.creditsFrame.addWindowListener(windowAdapter);
    }

    /**
     * This method closes/disposes of the areaFrame
     * 
     */
    public void Dispose() {
        creditsFrame.dispose();
    }
}
