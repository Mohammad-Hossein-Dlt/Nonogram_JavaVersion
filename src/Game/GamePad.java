package Game;
import Constants.Language.Language;
import Constants.Theme.ThemeData;
import GameData.Read.ReadData;

import java.awt.*;
import javax.swing.*;

public class GamePad extends JPanel{
    public static JButton restart = new JButton();
    public static JButton tryAgain = new JButton();
    public static JButton menu = new JButton();
    public GamePad(int scale, boolean continueGame) {
        this.setLayout( new GridBagLayout());
//      ------------------------------ Defining Panels
        JPanel control = new JPanel();
        JPanel columnPanel = new JPanel(new GridBagLayout());
        JPanel rowPanel = new JPanel(new GridBagLayout());
        JPanel btnpanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
//      ------------------------------ Restart And Menu Config
//      Restart
        restart.setText(Language.Restart.Get());
        restart.setFont(new Font("",Font.BOLD,14));
        restart.setMinimumSize(new Dimension(110,30));
        restart.setPreferredSize(new Dimension(110,30));
        restart.setAlignmentY(Component.CENTER_ALIGNMENT);
        restart.setAlignmentX(Component.CENTER_ALIGNMENT);
        restart.setBackground(ThemeData.Restart.Get());
        restart.setForeground(ThemeData.Text.Get());
        restart.setEnabled(!continueGame);
//      Try Again
        tryAgain.setText(Language.TryAgain.Get());
        tryAgain.setFont(new Font("",Font.BOLD,14));
        tryAgain.setMinimumSize(new Dimension(110,30));
        tryAgain.setPreferredSize(new Dimension(110,30));
        tryAgain.setAlignmentY(Component.CENTER_ALIGNMENT);
        tryAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
        tryAgain.setBackground(ThemeData.TryAgain.Get());
        tryAgain.setForeground(ThemeData.Text.Get());
        tryAgain.setEnabled(continueGame && !(ReadData.WrongClicked.isEmpty() && ReadData.CorrectClicked.isEmpty()));
//      Menu
        menu.setText(Language.Menu.Get());
        menu.setFont(new Font("",Font.BOLD,14));
        menu.setMinimumSize(new Dimension(110,30));
        menu.setPreferredSize(new Dimension(110,30));
        menu.setAlignmentY(Component.CENTER_ALIGNMENT);
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.setBackground(ThemeData.Background.Get());
        menu.setForeground(ThemeData.Text.Get());
//      ------------------------------ Set ControlPanel Background And Add Buttons To It
        control.setBackground(ThemeData.Control.Get());
        control.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0,0,5,0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        control.add(restart,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        control.add(tryAgain,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        control.add(menu,gbc);
//      ------------------------------ Set Column And Row Panels Background
        columnPanel.setBackground(ThemeData.ColumnColor.Get());
        rowPanel.setBackground(ThemeData.RowColor.Get());
//      ------------------------------ Set btnpanel Background And Layout
        btnpanel.setBackground(ThemeData.ColumnColor.Get());
        btnpanel.setLayout(new GridBagLayout());
//      ------------------------------
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
//      ------------------------------ Create btnpanel Buttons
        for (int i = 1; i <= scale; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.insets = new Insets(0,5,0,5);
            columnPanel.add(new GameHints("C"+i),gbc);
//            ------------------------------
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.insets = new Insets(5,0,5,0);
            rowPanel.add(new GameHints("R"+i),gbc);
//            -------------------------------
            for (int j = 1; j <= scale; j++){
//            -------------------------------
                gbc.insets = new Insets(0,0,0,0);
                gbc.gridx = j;
                gbc.gridy = i;
//            -------------------------------
                btnpanel.add(new Button(i, j, continueGame),gbc);
            }
        }
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,0,0,0);
//        ------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(control,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        this.add(columnPanel,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 4;
        this.add(rowPanel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 4;
        this.add(btnpanel,gbc);
    }
}


