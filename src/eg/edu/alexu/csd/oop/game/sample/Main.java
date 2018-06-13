package eg.edu.alexu.csd.oop.game.sample;

import Memento.Caretaker;
import Memento.Orginator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.sample.world.Clown;
import static eg.edu.alexu.csd.oop.game.sample.world.Clown.setTime;
import eg.edu.alexu.csd.oop.game.sample.world.GameDataManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        System.out.println("Uncomment any of the lines in the Main to run a new game, Have Fun :)");

        String[] list = {"Easy","Medium", "Hard"};
        JComboBox comboBox = new JComboBox(list);
        JOptionPane.showMessageDialog(null, comboBox, "Choose Difficulty", JOptionPane.OK_CANCEL_OPTION);
        final String selected = (String) comboBox.getSelectedItem();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        JMenuItem ExitItem = new JMenuItem("Exit");

        JButton ReturnToCheckPoint = new JButton("Return to CheckPoint ");

        menu.add(ExitItem);
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        menuBar.add(ReturnToCheckPoint);
        final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Clown(800, 700, selected), menuBar, Color.WHITE);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] list = {"Easy","Medium", "Hard"};
                JComboBox comboBox = new JComboBox(list);
                JOptionPane.showMessageDialog(null, comboBox, "Choose Difficulty", JOptionPane.OK_CANCEL_OPTION);
                final String selected = (String) comboBox.getSelectedItem();
                gameController.changeWorld(new eg.edu.alexu.csd.oop.game.sample.world.Clown(800, 700, selected));
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
        ExitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ReturnToCheckPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int Scores[] = Orginator.getInstance().RestoreLastMemento(Caretaker.getInstance().getLastMemento());
                GameDataManager.getInstance().setFuckingScore(Scores[0]);
                System.out.println(Clown.getStartTime());
                int time =60- Scores[1];
                time = (time-1)*1000;
                Clown.setTime(time);
                Clown.setStartTime(System.currentTimeMillis());
                System.out.println(Clown.getStartTime());
            }
        });
    }

}
