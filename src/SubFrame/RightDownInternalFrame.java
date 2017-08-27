package SubFrame;

import Information.Information;
import SubPanel.DrawPanel;
import figure.Figure;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class RightDownInternalFrame extends JInternalFrame implements ListSelectionListener {

    static RightDownInternalFrame instance;
    DefaultListModel<String> listModel;
    int currentFigureCnt = 0;
    private JList<String> stackList;
    private int selectedIndex = 0;


    public RightDownInternalFrame() {
        super("", true, false, false, true);

        listModel = new DefaultListModel<>();
        //create the list
        stackList = new JList<>(listModel);
        stackList.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(stackList);
        this.getContentPane().add(listScrollPane, BorderLayout.CENTER);

        JButton DelButton = new JButton("Delete");
        DelButton.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            DrawPanel current = Information.getCurrentJPanel();

            if (current == null) {
                JOptionPane.showMessageDialog(null, "Error : Can't find current Jpanel", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (selectedIndex > Information.getCurrentJPanel().getVector().size() - 1 || selectedIndex < 0) {
                JOptionPane.showMessageDialog(null, "Error : Cant' find figure", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                current.deleteFigure(selectedIndex--);
            }
        });

        JButton backButton = new JButton("Undo");

        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                if (Information.getCurrentJPanel() != null) {
                    Information.getCurrentJPanel().popStackTrace();
                }
            }
        });

        JButton frontButton = new JButton("Redo");

        frontButton.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            if (Information.getCurrentJPanel() != null) {
                Information.getCurrentJPanel().popStackCaneStack();
            }
        });


        JButton clearButton = new JButton("Clear");

        clearButton.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            DrawPanel current = Information.getCurrentJPanel();
            if (current != null) {
                current.claearFigure();
            } else {
                JOptionPane.showMessageDialog(null, "Error to find current Jpanel", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel bottomPanel = new JPanel();

        bottomPanel.add(DelButton);
        bottomPanel.add(backButton);
        bottomPanel.add(frontButton);
        bottomPanel.add(clearButton);

        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Figure Stack");
        this.setVisible(true);

        setSize(300, 350);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public static RightDownInternalFrame getInstance() {
        if (instance == null) {
            instance = new RightDownInternalFrame();
        }

        return instance;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub
        for (int i = 0; i <= e.getLastIndex(); i++) {
            if (stackList.isSelectedIndex(i)) {
                selectedIndex = currentFigureCnt - i - 1;
                Information.setCurrentFigure(Information.getCurrentJPanel().getVector().get(selectedIndex));
                break;
            }
        }
    }

    public void setListItems(Vector<Figure> dataSet) {
        listModel.clear();
        for (int i = dataSet.size() - 1; i >= 0; i--) {
            listModel.addElement(dataSet.get(i).toString());
        }

        currentFigureCnt = dataSet.size();

    }

    public int getCurrentFigureIndex() {

        return selectedIndex;
    }
}
