package Game;
import GameCore.GameCore;
import Constants.Theme.ThemeData;

import javax.swing.*;
import java.awt.*;

public class GameHints extends JLabel {
    StringBuilder hint = new StringBuilder();
    public GameHints(String index){
        if (index.contains("C")) {
            hint = new StringBuilder("<html>");
            for (int c : GameCore.columnhints.get(index)) hint.append(c).append("<br>");
            hint.append("</html>");
            this.setMinimumSize(new Dimension(20, 120));
            this.setPreferredSize(new Dimension(20, 120));
        }
        if(index.contains("R")){
            for (int r : GameCore.rowhints.get(index)) hint.append(r).append("  ");
            this.setMinimumSize(new Dimension(120,20));
            this.setPreferredSize(new Dimension(120,20));
        }
        this.setFont(new Font("",Font.BOLD,14));
        this.setText(hint.toString());
        this.setOpaque(true);
        this.setBackground(ThemeData.Labels.Get());
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
