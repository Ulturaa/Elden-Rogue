import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditsController {
    private CreditsModel cm;
    private CreditsView cv;

    /**
     * This is the constructor for the class Area. This sets up the MVC for
     * area. The button listeners are located here.
     * 
     * @param cm    The CreditsModel Class for data.
     * @param cv    The CreditsView Class for visual.
     */
    public CreditsController(CreditsModel cm,CreditsView cv) {
        this.cm = cm;
        this.cv = cv;

        this.cv.ReturnBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cv.Dispose();
            }
        });
    }
}
