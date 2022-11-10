package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToe extends JFrame
{
    JTextField messageTextField = new JTextField();
    JPanel gamePanel = new JPanel();
    JTextField[] boxTextField = new JTextField[9];
    JLabel[] gridLabel = new JLabel[4];



    public TicTacToe() throws HeadlessException
    {
        setTitle("Tic Tac Toe");
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
        });


        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints;

        messageTextField = new JTextField();
        messageTextField.setPreferredSize(new Dimension(280,50));
        messageTextField.setEditable(false);
        messageTextField.setBackground(Color.YELLOW);
        messageTextField.setForeground(Color.BLUE);
        messageTextField.setText("X's move");
        messageTextField.setHorizontalAlignment(SwingConstants.CENTER);
        messageTextField.setFont(new Font("Ariel", Font.BOLD, 24));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10,10,10,10);
        getContentPane().add(messageTextField, gridBagConstraints);

        gamePanel.setPreferredSize(new Dimension(280, 280));
        gamePanel.setBackground(Color.WHITE);
        gamePanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.insets = new Insets(10,10,10,10);
        getContentPane().add(gamePanel, gridBagConstraints);


        for(int i = 0; i< 9; i++)
        {
            boxTextField[i] = new JTextField();
            boxTextField[i].setPreferredSize(new Dimension(80,80));
            boxTextField[i].setEditable(false);
            boxTextField[i].setBackground(Color.WHITE);
            boxTextField[i].setFont(new Font("Ariel", Font.BOLD, 48));
            boxTextField[i].setBorder(null);
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 2 * (i%3);
            gridBagConstraints.gridy = 2 * (i/3);
            gamePanel.add(boxTextField[i], gridBagConstraints);
            boxTextField[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    boxTextFieldmousePressed(e);
                }
            });
        }

        gridLabel[0] = new JLabel();
        gridLabel[0].setPreferredSize(new Dimension(280,10));
        gridLabel[0].setOpaque(true);
        gridLabel[0].setBackground(Color.BLUE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new Insets(5,0,5,0);
        gamePanel.add(gridLabel[0], gridBagConstraints);


        gridLabel[1] = new JLabel();
        gridLabel[1].setPreferredSize(new Dimension(280,10));
        gridLabel[1].setOpaque(true);
        gridLabel[1].setBackground(Color.BLUE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new Insets(5,0,5,0);
        gamePanel.add(gridLabel[1], gridBagConstraints);
//
//
//        gridLabel[2] = new JLabel();
//        gridLabel[2].setPreferredSize(new Dimension(10,280));
//        gridLabel[2].setOpaque(true);
//        gridLabel[2].setBackground(Color.BLUE);
//        gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.gridx = 1;
//        gridBagConstraints.gridy = 0;
//        gridBagConstraints.gridwidth = 5;
//        gridBagConstraints.insets = new Insets(0,5,0,5);
//        gamePanel.add(gridLabel[2], gridBagConstraints);
//
//        gridLabel[3] = new JLabel();
//        gridLabel[3].setPreferredSize(new Dimension(10,280));
//        gridLabel[3].setOpaque(true);
//        gridLabel[3].setBackground(Color.BLUE);
//        gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.gridx = 3;
//        gridBagConstraints.gridy = 0;
//        gridBagConstraints.gridwidth = 5;
//        gridBagConstraints.insets = new Insets(0,5,0,5);
//        gamePanel.add(gridLabel[3], gridBagConstraints);
//


        pack();
        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    }

    public void exitForm(WindowEvent windowEvent)
    {
        System.exit(0);
    }

    public void boxTextFieldmousePressed(MouseEvent mouseEvent)
    {

    }
}
