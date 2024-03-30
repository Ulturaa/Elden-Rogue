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
                if(am.movePlayer('W') == true){
                    av.printArea(av.area);
                } else {
                    System.out.println("OOB");
                }
            }
        });

        this.av.downBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("down");
                if(am.movePlayer('S') == true){
                    av.printArea(av.area);
                } else {
                    System.out.println("OOB");
                }
            }
        });
        
        this.av.leftBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left");
                if(am.movePlayer('A') == true){
                    av.printArea(av.area);
                } else {
                    System.out.println("OOB");
                }
            }
        });

        this.av.rightBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
                if(am.movePlayer('D') == true){
                    av.printArea(av.area);
                } else {
                    System.out.println("OOB");
                }
            }
        });

        this.av.intBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("interact");
                am.interact();
                av.printArea(av.area);
            }
        });
    }

    public static void main(String[] args) {
        Character c = new Character();
        //Area a = new StormveilCastle(c);
        Area a = new RayaLucaria(c);
        //Area a = new EldenThrone(c);
        new AreaController(new AreaView(a), new AreaModel(a,c));
    }
}
