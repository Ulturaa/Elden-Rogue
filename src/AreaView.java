import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AreaView {

    private JFrame areaFrame;
    private JButton upBtn, downBtn, leftBtn, rightBtn, intBtn;
    private JLabel areaLbl, hpLbl, runesLbl;
    private JPanel areaPanel, buttonPanel;


    public AreaView(Area area) {
        areaFrame = new JFrame();
        areaFrame = new JFrame();
        areaFrame.setSize(820, 920);
        areaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        areaFrame.setLocationRelativeTo(null);
        areaFrame.setResizable(false);
        areaFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        areaFrame.getContentPane().setBackground(Color.black);

        areaPanel = new JPanel();
        areaPanel.setBackground(Color.WHITE);
        areaPanel.setLayout(new GridLayout(area.getFloors().getYBounds(),area.getFloors().getXBounds()));
        areaPanel.setPreferredSize(new Dimension(area.getFloors().getXBounds()*75, area.getFloors().getYBounds()*75));

        for(int i=0; i < area.getFloors().getYBounds(); i++) {
            for(int j=0; j < area.getFloors().getXBounds(); j++) {
                areaPanel.add(area.getFloors().getTile(i,j));
            }
        }
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GREEN);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(null);
        buttonPanel.setPreferredSize(new Dimension(720, 280));

        areaLbl = new JLabel();
        areaLbl.setText(area.getAreaName());
        areaLbl.setBounds(15,15,300,20);
        areaLbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        areaLbl.setForeground(Color.WHITE);
        buttonPanel.add(areaLbl);

        hpLbl = new JLabel();
        hpLbl.setText("HP: " + Integer.toString(area.getCharacter().getCurrHP()));
        hpLbl.setBounds(15,55,300,20);
        hpLbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        hpLbl.setForeground(Color.WHITE);
        buttonPanel.add(hpLbl);

        runesLbl = new JLabel();
        runesLbl.setText("Runes: " + Integer.toString(area.getCharacter().getRunes()));
        runesLbl.setBounds(15,95,300,20);
        runesLbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        runesLbl.setForeground(Color.WHITE);
        buttonPanel.add(runesLbl);

        upBtn = new JButton("UP");
        upBtn.setFocusable(false);
        upBtn.setBounds(520,40,80,50);
        buttonPanel.add(upBtn);

        downBtn = new JButton("DOWN");
        downBtn.setFocusable(false);
        downBtn.setBounds(520,140,80,50);
        buttonPanel.add(downBtn);

        leftBtn = new JButton("LEFT");
        leftBtn.setFocusable(false);
        leftBtn.setBounds(430,90,80,50);
        buttonPanel.add(leftBtn);

        rightBtn = new JButton("RIGHT");
        rightBtn.setFocusable(false);
        rightBtn.setBounds(610,90,80,50);
        buttonPanel.add(rightBtn);

        intBtn = new JButton("Interact");
        intBtn.setFocusable(false);
        intBtn.setBounds(315,90,80,50);
        buttonPanel.add(intBtn);
        
        areaFrame.add(areaPanel);
        areaFrame.add(buttonPanel);
        areaFrame.setVisible(true);
    }

    /**
     * Sets an action listener for the "Up" button.
     *
     * @param actionListener The action listener for the "Up" button.
     */
    public void upBtnActionListener(ActionListener actionListener) {
		this.upBtn.addActionListener(actionListener);
	}

    /**
     * Sets an action listener for the "Down" button.
     *
     * @param actionListener The action listener for the "Down" button.
     */
    public void downBtnActionListener(ActionListener actionListener) {
		this.downBtn.addActionListener(actionListener);
	}

    /**
     * Sets an action listener for the "Left" button.
     *
     * @param actionListener The action listener for the "Left" button.
     */
    public void leftBtnActionListener(ActionListener actionListener) {
		this.leftBtn.addActionListener(actionListener);
	}

    /**
     * Sets an action listener for the "Right" button.
     *
     * @param actionListener The action listener for the "Right" button.
     */
    public void rightBtnActionListener(ActionListener actionListener) {
		this.rightBtn.addActionListener(actionListener);
	}
    
    /**
     * Sets an action listener for the "Interact" button.
     *
     * @param actionListener The action listener for the "Interact" button.
     */
    public void intBtnActionListener(ActionListener actionListener) {
		this.intBtn.addActionListener(actionListener);
	}


    public void printArea(Area area) {
        this.areaPanel = new JPanel();
        this.areaPanel.setBackground(Color.WHITE);
        this.areaPanel.setLayout(new GridLayout(area.getFloors().getYBounds(),area.getFloors().getXBounds()));
        this.areaPanel.setPreferredSize(new Dimension(area.getFloors().getXBounds()*75, area.getFloors().getYBounds()*75));
        
        for(int i=0; i < area.getFloors().getYBounds(); i++) {
            for(int j=0; j < area.getFloors().getXBounds(); j++) {
                areaPanel.add(area.getFloors().getTile(i,j));
            }
        }
    }

    public static void main(String[] args) {
        Character c = new Character();
        Area a = new StormveilCastle(c);
        new AreaView(a);
    }
}
