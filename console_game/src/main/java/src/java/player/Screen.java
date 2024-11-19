/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.java.player;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Brian Ramirez
 */
public class Screen extends javax.swing.JFrame {

    /**
     * Creates new form Screen
     */
    public Screen() {
        initComponents();
        this.setVisible(false);
        for (int i = 0; i < 4; i++)tableLastAttackReceived.setValueAt("", i, 0);
        for (int i = 0; i < 10; i++)tableRankings.setValueAt(String.valueOf(i+1), i, 0);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        rankingLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAgainst = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRankings = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMyStatus = new javax.swing.JTable();
        consolePanel = new javax.swing.JPanel();
        consoleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();
        centrePanel = new javax.swing.JPanel();
        lastAttackReceivedPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lastAttackReceivedTextArea = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableLastAttackReceived = new javax.swing.JTable();
        lastAttackReceivedLabel = new javax.swing.JLabel();
        lastAttackSentPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lastAttackSentTextArea = new javax.swing.JTextArea();
        lastAttackSentLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableLastAttackSent = new javax.swing.JTable();
        rightPanel = new javax.swing.JPanel();
        yourCardsLabel = new javax.swing.JLabel();
        cardsPanel = new javax.swing.JPanel();
        card2Label = new javax.swing.JLabel();
        card3Label = new javax.swing.JLabel();
        card4Label = new javax.swing.JLabel();
        card1Label = new javax.swing.JLabel();
        card1AvgTextField = new javax.swing.JTextField();
        card2AvgTextField = new javax.swing.JTextField();
        card3AvgTextField = new javax.swing.JTextField();
        card4AvgTextField = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableCardStats = new javax.swing.JTable();
        cardPomptTextField = new javax.swing.JTextField();
        chatPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        chatBoxTextArea = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        chatSendButton = new javax.swing.JButton();
        chatLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rankingLabel.setText("Ranking");

        tableAgainst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Wins", null},
                {"Losses", null},
                {"Attacks", null},
                {"Success", null},
                {"Failed", null},
                {"Giveup", null}
            },
            new String [] {
                "Against", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableAgainst);
        if (tableAgainst.getColumnModel().getColumnCount() > 0) {
            tableAgainst.getColumnModel().getColumn(0).setResizable(false);
            tableAgainst.getColumnModel().getColumn(1).setResizable(false);
        }

        tableRankings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Position", "Player", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableRankings);
        if (tableRankings.getColumnModel().getColumnCount() > 0) {
            tableRankings.getColumnModel().getColumn(0).setResizable(false);
        }

        tableMyStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Wins", null},
                {"Losses", null},
                {"Attacks", null},
                {"Success", null},
                {"Failed", null},
                {"Giveup", null}
            },
            new String [] {
                "My Status", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableMyStatus);
        if (tableMyStatus.getColumnModel().getColumnCount() > 0) {
            tableMyStatus.getColumnModel().getColumn(0).setResizable(false);
            tableMyStatus.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(rankingLabel)
                        .addGap(0, 188, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rankingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        consoleLabel.setText("Console");

        consoleTextArea.setEditable(false);
        consoleTextArea.setColumns(20);
        consoleTextArea.setRows(5);
        jScrollPane1.setViewportView(consoleTextArea);

        javax.swing.GroupLayout consolePanelLayout = new javax.swing.GroupLayout(consolePanel);
        consolePanel.setLayout(consolePanelLayout);
        consolePanelLayout.setHorizontalGroup(
            consolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consolePanelLayout.createSequentialGroup()
                .addComponent(consoleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        consolePanelLayout.setVerticalGroup(
            consolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consolePanelLayout.createSequentialGroup()
                .addComponent(consoleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        lastAttackReceivedTextArea.setEditable(false);
        lastAttackReceivedTextArea.setColumns(20);
        lastAttackReceivedTextArea.setRows(5);
        jScrollPane5.setViewportView(lastAttackReceivedTextArea);

        tableLastAttackReceived.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Wins", null},
                {"Losses", null},
                {"Attacks", null},
                {"Success", null}
            },
            new String [] {
                "Character", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableLastAttackReceived);
        if (tableLastAttackReceived.getColumnModel().getColumnCount() > 0) {
            tableLastAttackReceived.getColumnModel().getColumn(0).setResizable(false);
            tableLastAttackReceived.getColumnModel().getColumn(1).setResizable(false);
        }

        lastAttackReceivedLabel.setText("Last attack received");

        javax.swing.GroupLayout lastAttackReceivedPanelLayout = new javax.swing.GroupLayout(lastAttackReceivedPanel);
        lastAttackReceivedPanel.setLayout(lastAttackReceivedPanelLayout);
        lastAttackReceivedPanelLayout.setHorizontalGroup(
            lastAttackReceivedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(lastAttackReceivedPanelLayout.createSequentialGroup()
                .addComponent(lastAttackReceivedLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lastAttackReceivedPanelLayout.setVerticalGroup(
            lastAttackReceivedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastAttackReceivedPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lastAttackReceivedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lastAttackSentTextArea.setEditable(false);
        lastAttackSentTextArea.setColumns(20);
        lastAttackSentTextArea.setRows(5);
        jScrollPane7.setViewportView(lastAttackSentTextArea);

        lastAttackSentLabel.setText("Last attack sent");

        tableLastAttackSent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Stats", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tableLastAttackSent);
        if (tableLastAttackSent.getColumnModel().getColumnCount() > 0) {
            tableLastAttackSent.getColumnModel().getColumn(0).setResizable(false);
            tableLastAttackSent.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout lastAttackSentPanelLayout = new javax.swing.GroupLayout(lastAttackSentPanel);
        lastAttackSentPanel.setLayout(lastAttackSentPanelLayout);
        lastAttackSentPanelLayout.setHorizontalGroup(
            lastAttackSentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
            .addGroup(lastAttackSentPanelLayout.createSequentialGroup()
                .addComponent(lastAttackSentLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        lastAttackSentPanelLayout.setVerticalGroup(
            lastAttackSentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastAttackSentPanelLayout.createSequentialGroup()
                .addComponent(lastAttackSentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout centrePanelLayout = new javax.swing.GroupLayout(centrePanel);
        centrePanel.setLayout(centrePanelLayout);
        centrePanelLayout.setHorizontalGroup(
            centrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centrePanelLayout.createSequentialGroup()
                .addGroup(centrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lastAttackReceivedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastAttackSentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        centrePanelLayout.setVerticalGroup(
            centrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centrePanelLayout.createSequentialGroup()
                .addComponent(lastAttackReceivedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lastAttackSentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        yourCardsLabel.setText("Your Cards");

        card1AvgTextField.setEditable(false);
        card1AvgTextField.setText("0%");

        card2AvgTextField.setEditable(false);
        card2AvgTextField.setText("0%");

        card3AvgTextField.setEditable(false);
        card3AvgTextField.setText("0%");

        card4AvgTextField.setEditable(false);
        card4AvgTextField.setText("0%");

        javax.swing.GroupLayout cardsPanelLayout = new javax.swing.GroupLayout(cardsPanel);
        cardsPanel.setLayout(cardsPanelLayout);
        cardsPanelLayout.setHorizontalGroup(
            cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsPanelLayout.createSequentialGroup()
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(card1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardsPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(card1AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardsPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(card2AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(card3AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(card4AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardsPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(card2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        cardsPanelLayout.setVerticalGroup(
            cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(card2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(card2AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1AvgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tableCardStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ability", "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tableCardStats);
        if (tableCardStats.getColumnModel().getColumnCount() > 0) {
            tableCardStats.getColumnModel().getColumn(0).setResizable(false);
            tableCardStats.getColumnModel().getColumn(1).setResizable(false);
            tableCardStats.getColumnModel().getColumn(2).setResizable(false);
            tableCardStats.getColumnModel().getColumn(3).setResizable(false);
            tableCardStats.getColumnModel().getColumn(4).setResizable(false);
            tableCardStats.getColumnModel().getColumn(5).setResizable(false);
            tableCardStats.getColumnModel().getColumn(6).setResizable(false);
            tableCardStats.getColumnModel().getColumn(7).setResizable(false);
            tableCardStats.getColumnModel().getColumn(8).setResizable(false);
            tableCardStats.getColumnModel().getColumn(9).setResizable(false);
        }

        cardPomptTextField.setEditable(false);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardPomptTextField)
                    .addComponent(yourCardsLabel)
                    .addComponent(cardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourCardsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardPomptTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        chatBoxTextArea.setEditable(false);
        chatBoxTextArea.setColumns(20);
        chatBoxTextArea.setRows(5);
        jScrollPane8.setViewportView(chatBoxTextArea);

        chatTextArea.setColumns(20);
        chatTextArea.setRows(5);
        jScrollPane11.setViewportView(chatTextArea);

        chatSendButton.setText("SEND");
        chatSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatSendButtonActionPerformed(evt);
            }
        });

        chatLabel.setText("CHAT");

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addComponent(chatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chatSendButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addComponent(chatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(consolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(centrePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chatSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatSendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chatSendButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField card1AvgTextField;
    private javax.swing.JLabel card1Label;
    private javax.swing.JTextField card2AvgTextField;
    private javax.swing.JLabel card2Label;
    private javax.swing.JTextField card3AvgTextField;
    private javax.swing.JLabel card3Label;
    private javax.swing.JTextField card4AvgTextField;
    private javax.swing.JLabel card4Label;
    private javax.swing.JTextField cardPomptTextField;
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JPanel centrePanel;
    private javax.swing.JTextArea chatBoxTextArea;
    private javax.swing.JLabel chatLabel;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JButton chatSendButton;
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JLabel consoleLabel;
    private javax.swing.JPanel consolePanel;
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lastAttackReceivedLabel;
    private javax.swing.JPanel lastAttackReceivedPanel;
    private javax.swing.JTextArea lastAttackReceivedTextArea;
    private javax.swing.JLabel lastAttackSentLabel;
    private javax.swing.JPanel lastAttackSentPanel;
    private javax.swing.JTextArea lastAttackSentTextArea;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel rankingLabel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTable tableAgainst;
    private javax.swing.JTable tableCardStats;
    private javax.swing.JTable tableLastAttackReceived;
    private javax.swing.JTable tableLastAttackSent;
    private javax.swing.JTable tableMyStatus;
    private javax.swing.JTable tableRankings;
    private javax.swing.JLabel yourCardsLabel;
    // End of variables declaration//GEN-END:variables

    public JTextField getCard1AvgTextField() {
        return card1AvgTextField;
    }

    public void setCard1AvgTextField(JTextField card1AvgTextField) {
        this.card1AvgTextField = card1AvgTextField;
    }

    public JLabel getCard1Label() {
        return card1Label;
    }

    public void setCard1Label(JLabel card1Label) {
        this.card1Label = card1Label;
    }

    public JTextField getCard2AvgTextField() {
        return card2AvgTextField;
    }

    public void setCard2AvgTextField(JTextField card2AvgTextField) {
        this.card2AvgTextField = card2AvgTextField;
    }

    public JLabel getCard2Label() {
        return card2Label;
    }

    public void setCard2Label(JLabel card2Label) {
        this.card2Label = card2Label;
    }

    public JTextField getCard3AvgTextField() {
        return card3AvgTextField;
    }

    public void setCard3AvgTextField(JTextField card3AvgTextField) {
        this.card3AvgTextField = card3AvgTextField;
    }

    public JLabel getCard3Label() {
        return card3Label;
    }

    public void setCard3Label(JLabel card3Label) {
        this.card3Label = card3Label;
    }

    public JTextField getCard4AvgTextField() {
        return card4AvgTextField;
    }

    public void setCard4AvgTextField(JTextField card4AvgTextField) {
        this.card4AvgTextField = card4AvgTextField;
    }

    public JLabel getCard4Label() {
        return card4Label;
    }

    public void setCard4Label(JLabel card4Label) {
        this.card4Label = card4Label;
    }

    public JTextField getCardPomptTextField() {
        return cardPomptTextField;
    }

    public void setCardPomptTextField(JTextField cardPomptTextField) {
        this.cardPomptTextField = cardPomptTextField;
    }

    public JTextArea getConsoleTextArea() {
        return consoleTextArea;
    }

    public void setConsoleTextArea(JTextArea consoleTextArea) {
        this.consoleTextArea = consoleTextArea;
    }

    public JTextArea getLastAttackReceivedTextArea() {
        return lastAttackReceivedTextArea;
    }

    public void setLastAttackReceivedTextArea(JTextArea lastAttackReceivedTextArea) {
        this.lastAttackReceivedTextArea = lastAttackReceivedTextArea;
    }

    public JTextArea getLastAttackSentTextArea() {
        return lastAttackSentTextArea;
    }

    public void setLastAttackSentTextArea(JTextArea lastAttackSentTextArea) {
        this.lastAttackSentTextArea = lastAttackSentTextArea;
    }

    public JTable getTableAgainst() {
        return tableAgainst;
    }

    public void setTableAgainst(JTable tableAgainst) {
        this.tableAgainst = tableAgainst;
    }

    public JTable getTableCardStats() {
        return tableCardStats;
    }

    public void setTableCardStats(JTable tableCardStats) {
        this.tableCardStats = tableCardStats;
    }

    public JTable getTableLastAttackReceived() {
        return tableLastAttackReceived;
    }

    public void setTableLastAttackReceived(JTable tableLastAttackReceived) {
        this.tableLastAttackReceived = tableLastAttackReceived;
    }

    public JTable getTableMyStatus() {
        return tableMyStatus;
    }

    public void setTableMyStatus(JTable tableMyStatus) {
        this.tableMyStatus = tableMyStatus;
    }

    public JTable getTableRankings() {
        return tableRankings;
    }

    public void setTableRankings(JTable tableRankings) {
        this.tableRankings = tableRankings;
    }

    public JTable getTableLastAttackSent() {
        return tableLastAttackSent;
    }
    
    
    
}
