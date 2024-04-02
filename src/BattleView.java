import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class BattleView{
    
    private Character chara;
    private Entity ene;
    private JFrame battleFrm;
    private JButton atkBtn, dgeBtn;
    private JPanel nPnl, hPnl, iPnl, dPnl, pPnl, ePnl, bPnl;
    private JLabel eNameLbl, eHPLbl, eIcnLbl, eDmgLbl, pHpLbl, eventLbl;

    public BattleView(Entity enemy, Character character){
        ene = enemy;
        chara = character;
        
        battleFrm = new JFrame();
        battleFrm.setSize(480, 720);
        battleFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleFrm.setLocationRelativeTo(null);
        battleFrm.setResizable(false);
        battleFrm.setLayout(null);
        battleFrm.getContentPane().setBackground(Color.black);

        iPnl = new JPanel();
        iPnl.setOpaque(false);
        iPnl.setBounds(0,0,480,360);
        iPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        iPnl.setBackground(Color.WHITE);

        eIcnLbl = new JLabel();
        eIcnLbl.setIcon(ene.getBSprite());
        eIcnLbl.setSize(480,20);
        eIcnLbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        eIcnLbl.setForeground(Color.WHITE);
        iPnl.add(eIcnLbl);

        nPnl = new JPanel();
        nPnl.setBounds(0,360,480,40);
        nPnl.setOpaque(false);
        nPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        nPnl.setBackground(Color.CYAN);

        eNameLbl = new JLabel();
        eNameLbl.setText(ene.getName());
        eNameLbl.setSize(480,20);
        eNameLbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
        eNameLbl.setForeground(Color.WHITE);
        nPnl.add(eNameLbl);

        hPnl = new JPanel();
        hPnl.setBounds(0,400,480,40);
        hPnl.setOpaque(false);
        hPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        hPnl.setBackground(Color.BLUE);

        eHPLbl = new JLabel();
        eHPLbl.setText("HP: " + ene.getHP());
        eHPLbl.setSize(480,20);
        eHPLbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        eHPLbl.setForeground(Color.WHITE);
        hPnl.add(eHPLbl);

        dPnl = new JPanel();
        dPnl.setBounds(0,440,480,40);
        dPnl.setOpaque(false);
        dPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        dPnl.setBackground(Color.GRAY);

        eDmgLbl = new JLabel();
        eDmgLbl.setText("Incoming damage: " + ene.getATK());
        eDmgLbl.setSize(480,20);
        eDmgLbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        eDmgLbl.setForeground(Color.WHITE);
        dPnl.add(eDmgLbl);

        ePnl = new JPanel();
        ePnl.setBounds(0,480,480,40);
        ePnl.setOpaque(true);
        ePnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        ePnl.setBackground(Color.GRAY);

        eventLbl = new JLabel();
        eventLbl.setText("");
        eventLbl.setSize(480,20);
        eventLbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        eventLbl.setForeground(Color.WHITE);
        ePnl.add(eventLbl);

        pPnl = new JPanel();
        pPnl.setBounds(0,520,480,40);
        pPnl.setOpaque(true);
        pPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        pPnl.setBackground(Color.WHITE);

        pHpLbl = new JLabel();
        pHpLbl.setText("HP: " + chara.getCurrHP());
        pHpLbl.setSize(480,20);
        pHpLbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
        pHpLbl.setForeground(Color.GREEN);
        pPnl.add(pHpLbl);

        bPnl = new JPanel();
        bPnl.setBounds(0,560,480,120);
        bPnl.setOpaque(false);
        bPnl.setLayout(new FlowLayout(FlowLayout.CENTER,80,30));
        bPnl.setBackground(Color.GREEN);

        atkBtn = new JButton();
        atkBtn.setText("Attack");
        atkBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
        atkBtn.setPreferredSize(new Dimension(120, 60));
        atkBtn.setFocusable(false);
        bPnl.add(atkBtn);
        
        dgeBtn = new JButton();
        dgeBtn.setText("Dodge");
        dgeBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dgeBtn.setPreferredSize(new Dimension(120, 60));
        dgeBtn.setFocusable(false);
        bPnl.add(dgeBtn);

        battleFrm.add(nPnl);
        battleFrm.add(hPnl);
        battleFrm.add(iPnl);
        battleFrm.add(dPnl);
        battleFrm.add(ePnl);
        battleFrm.add(pPnl);
        battleFrm.add(bPnl);
        battleFrm.setVisible(true);
    }

    public void updateLabels(double eHp, double eDmg, int pHp) {
        if(eHp <= 0)
            eHPLbl.setText("HP: 0" );
        else
            eHPLbl.setText("HP: " + eHp);

        if(pHp <= 0)
            pHpLbl.setText("HP: 0");
        else
            pHpLbl.setText("HP: " + pHp);

        eDmgLbl.setText("Incoming damage: " + eDmg);
    }

    /**
     * The method sets the text for the Enemy HP label.
     * Is used to update the health of the enemy.
     * 
     * @param hp The current health of the player.
     */
    public void setEHPLbl(Double eHp) {
        eHPLbl.setText("HP: " + eHp);
    }
    
    /**
     * The method sets the text for the Damage label.
     * Is used to update the damage.
     * 
     * @param dmg The incoming damage.
     */
    public void setDmgLbl(double dmg) {
        eDmgLbl.setText("Incoming damage: " + dmg);
    }

    /**
     * The method sets the text for the Player HP label.
     * Is used to update the health of the player.
     * 
     * @param hp The current health of the player.
     */
    public void setPHPLbl(int hp) {
        pHpLbl.setText("HP: " + hp);
    }

    /**
     * The method sets the text for the Event label.
     * Is used to print any event that happens.
     * 
     * @param text The string to be printed.
     */
    public void setEventLbl(String text) {
        this.eventLbl.setText(text);
    }

    /**
     * Sets an action listener for the Attack button.
     *
     * @param actionListener The action listener for the attack button.
     */
    public void atkBtnActionListener(ActionListener actionListener) {
		this.atkBtn.addActionListener(actionListener);
	}

    /**
     * Sets an action listener for the Dodge button.
     *
     * @param actionListener The action listener for the Dodge button.
     */
    public void dgeBtnActionListener(ActionListener actionListener) {
		this.dgeBtn.addActionListener(actionListener);
	}

    /**
     * Sets a window adapter for the Dodge button.
     * Listens for when the window is disposed/closed.
     *
     * @param actionListener The action listener for the Dodge button.
     */
    public void areaFrameWindowListener(WindowAdapter windowAdapter) {
        battleFrm.addWindowListener(windowAdapter);
    }

    public void Dispose() {
        battleFrm.dispose();
    }
}
