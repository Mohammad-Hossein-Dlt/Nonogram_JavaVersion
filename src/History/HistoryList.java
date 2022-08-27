package History;

import Constants.Language.Language;
import Constants.Theme.ThemeData;
import GameData.GamesFoldersManager;

import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class HistoryList extends JPanel {
    JPanel listPanel;
    JScrollPane scroll;
    JPanel overAll;
    JPanel btnPanel;
    public static JButton removeAll = new JButton();
    public static JButton back = new JButton();
    public HistoryList(JFrame mainWindow){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(ThemeData.Background.Get());

//      ------------------------------
        listPanel = new JPanel();
        scroll = new JScrollPane(listPanel);
        overAll = new JPanel();
        btnPanel = new JPanel();
//      ------------------------------
        listPanel.setLayout(new BoxLayout(listPanel,BoxLayout.Y_AXIS));
        listPanel.setBackground(ThemeData.Background.Get());
//      ------------------------------
        int win = 0;
        int lose = 0;
        int unfinished = 0;
//      ------------------------------
        ArrayList<File> destroyedFolders = new ArrayList<>();
        for (File folder: GamesFoldersManager.folderList){
            String result = "";
            try {
                InputStream input = new BufferedInputStream(Files.newInputStream(new File(folder.getPath()+"/GameConfig.txt").toPath()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String temp;
                while (( temp = reader.readLine() ) != null) result = temp;
                if(!result.isEmpty()) result = result.split(" ")[1];
            } catch (IOException ignored){}
            if(!result.isEmpty()) {
                if (result.equals("Unfinished")) unfinished++;
                if (result.equals("Win")) win++;
                if (result.equals("Lose")) lose++;
                listPanel.add(new GameHistory(mainWindow, folder, result));
            }else destroyedFolders.add(folder);
        }
        destroyedFolders.forEach(GamesFoldersManager::removeGameData);
//      ------------------------------ RemoveAll And Back Buttons
//      RemoveAll Config
        removeAll.setText(Language.RemoveAll.Get());
        removeAll.setBackground(ThemeData.Remove.Get());
        removeAll.setFont(new Font("",Font.BOLD,14));
//      Back Config
        back.setText(Language.Back.Get());
        back.setBackground(ThemeData.Back.Get());
        back.setForeground(Color.white);
        back.setFont(new Font("",Font.BOLD,14));
//      BtnPanel Config
        btnPanel.setBackground(ThemeData.Background.Get());
//      Add To BtnPanel
        btnPanel.add(removeAll);
        btnPanel.add(back);
//      ------------------------------ Scroll Config
        scroll.setMaximumSize(new Dimension(500,200));
        scroll.setPreferredSize(new Dimension(500,200));
        scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
//      ------------------------------ OverAll Config
        overAll.setBackground(ThemeData.Background.Get());
//      Win Label Config
        JLabel winLabel = new JLabel(Language.Win.Get()+": "+win);
        winLabel.setFont(new Font("",Font.BOLD,14));
        winLabel.setForeground(ThemeData.Win.Get());
        winLabel.setMinimumSize(new Dimension(150,50));
        winLabel.setPreferredSize(new Dimension(150,50));
        winLabel.setVerticalAlignment(SwingConstants.CENTER);
        winLabel.setHorizontalAlignment(SwingConstants.CENTER);
        overAll.add(winLabel);
//      Lose Label Config
        JLabel loseLabel = new JLabel(Language.Lose.Get()+": "+lose);
        loseLabel.setFont(new Font("",Font.BOLD,14));
        loseLabel.setForeground(ThemeData.Lose.Get());
        loseLabel.setMinimumSize(new Dimension(150,50));
        loseLabel.setPreferredSize(new Dimension(150,50));
        loseLabel.setVerticalAlignment(SwingConstants.CENTER);
        loseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        overAll.add(loseLabel);
//      Unfinished Label Config
        JLabel unfinishedLabel = new JLabel(Language.Unfinished.Get()+": "+unfinished);
        unfinishedLabel.setFont(new Font("",Font.BOLD,14));
        unfinishedLabel.setForeground(ThemeData.Unfinished.Get());
        unfinishedLabel.setMinimumSize(new Dimension(150,50));
        unfinishedLabel.setPreferredSize(new Dimension(150,50));
        unfinishedLabel.setVerticalAlignment(SwingConstants.CENTER);
        unfinishedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        overAll.add(unfinishedLabel);
//      ------------------------------
        this.add(scroll);
        this.add(overAll);
        this.add(btnPanel);
    }
}
