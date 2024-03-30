import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaController {

    AreaView av;
    AreaModel am;

    public AreaController(AreaView av, AreaModel am) {
        this.av = av;
        this.am = am;

        this.av.upBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up");

                
                printArea(area);
            }
        });

        this.av.downBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("down");
            }
        });
        
        this.av.leftBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left");
            }
        });

        this.av.rightBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
            }
        });

        this.av.intBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("interact");
            }
        });
    }

    public static void main(String[] args) {
        Character c = new Character();
        Area a = new StormveilCastle(c);
        new AreaController(new AreaView(a), new AreaModel());
    }
}
