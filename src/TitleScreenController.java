import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenController {
    private TitleScreenView tsv;
    private TitleScreenModel tsm;

    public TitleScreenController(TitleScreenView tsv, TitleScreenModel tsm) {
        this.tsv = tsv;
        this.tsm = tsm;

        this.tsv.StartBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("To Character Creation.");
            }
        });

        this.tsv.ExitBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TitleScreenView tsv = new TitleScreenView();
        TitleScreenModel tsm = new TitleScreenModel();
        TitleScreenController tsc = new TitleScreenController(tsv, tsm);
    }

}
