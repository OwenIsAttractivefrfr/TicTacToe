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
    JPanel playersPanel = new JPanel();
    ButtonGroup playersButtonGroup = new ButtonGroup();
    JRadioButton twoPlayerRadioButton = new JRadioButton();
    JRadioButton onePlayerRadioButton = new JRadioButton();
    ButtonGroup firstButtonGroup = new ButtonGroup();
    JRadioButton playerFirst = new JRadioButton();
    JRadioButton computerFirst = new JRadioButton();
    JPanel firstPanel = new JPanel();
    JPanel computerPanel = new JPanel();
    ButtonGroup computerButtonGroup = new ButtonGroup();
    JRadioButton randomRadioButton = new JRadioButton();
    JRadioButton smartRadioButton = new JRadioButton();
    JButton startStopButton = new JButton();
    JButton exitButton = new JButton();
    JPanel buttonsPanel = new JPanel();
    boolean xturn;
    boolean canClick = false;
    int numberClicks;


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
//
//
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
        System.out.println( gridLabel[1]);


        gridLabel[2] = new JLabel();
        gridLabel[2].setPreferredSize(new Dimension(10,280));
        gridLabel[2].setOpaque(true);
        gridLabel[2].setBackground(Color.BLUE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx =1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new Insets(0,5,0,5);
        gamePanel.add(gridLabel[2], gridBagConstraints);

        gridLabel[3] = new JLabel();
        gridLabel[3].setPreferredSize(new Dimension(10,280));
        gridLabel[3].setOpaque(true);
        gridLabel[3].setBackground(Color.BLUE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new Insets(0,5,0,5);
        gamePanel.add(gridLabel[3], gridBagConstraints);

        playersPanel.setPreferredSize(new Dimension(160,75));
        playersPanel.setBackground(Color.WHITE);
        playersPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        playersPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5,10,5,10);
        getContentPane().add(playersPanel, gridBagConstraints);

        onePlayerRadioButton.setText("One Player");
        onePlayerRadioButton.setBackground(Color.WHITE);
        playersButtonGroup.add(onePlayerRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        playersPanel.add(onePlayerRadioButton, gridBagConstraints);
        onePlayerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onePlayerRadioButtonAction(e);
            }
        });

        twoPlayerRadioButton.setText("Two Player");
        twoPlayerRadioButton.setBackground(Color.WHITE);
        playersButtonGroup.add(twoPlayerRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        playersPanel.add(twoPlayerRadioButton, gridBagConstraints);
        twoPlayerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                twoPlayerRadioButtonAction(e);
            }
        });

        firstPanel.setPreferredSize(new Dimension(160,75));
        firstPanel.setBackground(Color.WHITE);
        firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        firstPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(firstPanel, gridBagConstraints);

        playerFirst.setText("You first");
        playerFirst.setBackground(Color.PINK);
        playerFirst.setSelected(true);
        firstButtonGroup.add(playerFirst);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        firstPanel.add(playerFirst, gridBagConstraints);

        computerFirst.setText("Computer First");
        computerFirst.setBackground(Color.RED);
        firstButtonGroup.add(computerFirst);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        firstPanel.add(computerFirst, gridBagConstraints);


        computerPanel.setPreferredSize(new Dimension(160,75));
        computerPanel.setBackground(Color.BLUE);
        computerPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        computerPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 10,5,10);
        getContentPane().add(computerPanel, gridBagConstraints);


        randomRadioButton.setText("Random Computer");
        randomRadioButton.setBackground(Color.MAGENTA);
        randomRadioButton.setSelected(true);
        computerButtonGroup.add(randomRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        computerPanel.add(randomRadioButton, gridBagConstraints);


        smartRadioButton.setText("Smart Computer");
        smartRadioButton.setBackground(Color.LIGHT_GRAY);
        computerButtonGroup.add(smartRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        computerPanel.add(smartRadioButton, gridBagConstraints);


        buttonsPanel.setPreferredSize(new Dimension(160,70));
        buttonsPanel.setBackground(Color.GREEN);
        buttonsPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        getContentPane().add(buttonsPanel, gridBagConstraints);


        startStopButton.setText("Start Game");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        buttonsPanel.add(startStopButton, gridBagConstraints);


        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startStopButtonPressed(e);
            }
        });

        exitButton.setText("Exit Game");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy= 1;
        gridBagConstraints.insets = new Insets(10,0,0,0);
        buttonsPanel.add(exitButton, gridBagConstraints);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonPressed(e);
            }
        });


        pack();
        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());


        messageTextField.setText("Game Stopped");
        playerFirst.setEnabled(false);
        computerFirst.setEnabled(false);
        randomRadioButton.setEnabled(false);
        smartRadioButton.setEnabled(false);

    }

    public void exitForm(WindowEvent windowEvent)
    {
        System.exit(0);
    }

    public void boxTextFieldmousePressed(MouseEvent mouseEvent)
    {

    }

    public void onePlayerRadioButtonAction(ActionEvent actionEvent)
    {

    }

    public void twoPlayerRadioButtonAction(ActionEvent actionEvent)
    {

    }

    public void startStopButtonPressed(ActionEvent actionEvent)
    {
        if(startStopButton.getText().equals("Start Game"))
        {
            startStopButton.setText("Stop Game");
            twoPlayerRadioButton.setEnabled(false);
            onePlayerRadioButton.setEnabled(false);
            playerFirst.setEnabled(false);
            computerFirst.setEnabled(false);
            randomRadioButton.setEnabled(false);
            smartRadioButton.setEnabled(false);
            exitButton.setEnabled(false);
            xturn = true;
            messageTextField.setText("X's turn");
            for (int i = 0; i < 9; i++) {
                boxTextField[i].setText("");
            }
            canClick = true;
            numberClicks = 0;
        }
        else
        {
            startStopButton.setText("Start Game");
            messageTextField.setText("Game Stop");
            twoPlayerRadioButton.setEnabled(true);
            onePlayerRadioButton.setEnabled(true);
            if(onePlayerRadioButton.isSelected())
            {
                playerFirst.setEnabled(true);
                computerFirst.setEnabled(true);
                randomRadioButton.setEnabled(true);
                smartRadioButton.setEnabled(true);
            }
            exitButton.setEnabled(true);
            canClick = false;
        }
    }
    public void exitButtonPressed(ActionEvent actionEvent)
    {
        System.exit(0);
    }
}
