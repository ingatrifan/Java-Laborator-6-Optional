package org.lab6Optional;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private JButton saveBtn = new JButton("Save");
    private JButton loadBtn = new JButton("Load");
    private JButton resetBtn = new JButton("Reset");
    private JButton exitBtn = new JButton("Exit");
    private JFileChooser jfc;

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            jfc.setDialogTitle("Choose a directory to save your file: ");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = jfc.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.canvas.image, "PNG", new File(jfc.getSelectedFile()+"/exemple.png"));
            }
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            jfc.setDialogTitle("Choose a file to load: ");
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                Image image = ImageIO.read(selectedFile);
                frame.canvas.drawImage(image);
            }
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
        System.out.println("reset");
        frame.canvas.resetGraphics();
    }

    private void exit(ActionEvent e) {
            frame.setVisible(false);
            frame.dispose();
    }
}