import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryController {
    private InventoryModel im;
    private InventoryView iv;

    public InventoryController(InventoryModel im, InventoryView iv) {
        this.im = im;
        this.iv = iv;

        iv.setIButton("Select Weapon", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SELECT");
            }
        });

        iv.setIButton("BACK", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SELECT");
            }
        });
        iv.composeIButtonlist();
    }
}
