import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenController {
    private TitleScreenView tsv;
    private TItleScreenModel tsm;

    TitleScreenController(TitleScreenView tsv, TItleScreenModel tsm) {

        this.tsv = tsv;
        this.tsm = tsm;

        tsv.StartBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("To Character Creation.");
            }
        });

        tsv.ExitBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new TitleScreenController(new TitleScreenView(), new TItleScreenModel());
    }

}
