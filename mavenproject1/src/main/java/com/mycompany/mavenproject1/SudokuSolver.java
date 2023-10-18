/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.*;
import java.awt.Color;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class SudokuSolver extends javax.swing.JFrame {
    public static final int ROW_COLUMN = 9;
    private String turn="1";
    private boolean globalFlag=true;
    private String solvedBoard[][]={
        {"2","9","8","5","1","6","7","3","4"},
        {"4","1","3","2","7","8","5","6","9"},
        {"7","5","6","3","4","9","1","2","8"},
        {"8","2","1","4","3","5","6","9","7"},
        {"5","3","4","6","9","7","2","8","1"},
        {"9","6","7","1","8","2","3","4","5"},
        {"1","4","2","8","5","3","9","7","6"},
        {"3","7","5","9","6","4","8","1","2"},
        {"6","8","9","7","2","1","4","5","3"}
    };
    
    private int board[][]={
        {0,0,0,5,0,0,7,3,4},
        {4,0,0,0,7,8,5,0,9},
        {7,0,6,0,4,0,0,2,0},
        {0,0,0,0,3,5,0,9,0},
        {0,3,4,0,0,0,2,8,0},
        {0,6,0,1,8,0,0,0,0},
        {0,4,0,0,5,0,9,0,6},
        {3,0,0,9,6,0,0,0,2},
        {6,8,9,0,0,1,0,0,0}           
    };
    
    
     public static boolean isNumAlreadyInRow(int[][] grid, int num, int row){
        for (int i = 0; i < ROW_COLUMN; i++) {
            if(grid[row][i] == num){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumAlreadyInColumn(int[][] grid, int num, int column){
        for (int i = 0; i < ROW_COLUMN; i++) {
            if(grid[i][column] == num){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumAlreadyInSquare(int[][] grid, int num, int row, int column){
        int squareRow = row - (row % 3);
        int squareColumn = column - (column % 3);
        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareColumn; j < squareColumn + 3; j++) {
                if(grid[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkAll(int[][] grid, int num, int row, int column){
        return !isNumAlreadyInRow(grid, num, row) &&
                !isNumAlreadyInColumn(grid, num, column) &&
                !isNumAlreadyInSquare(grid, num, row, column);
    }

    public static boolean solver(int[][] grid){
        for (int row = 0; row < ROW_COLUMN; row++) {
            for (int column = 0; column < ROW_COLUMN; column++) {
                if(grid[row][column] == 0){
                    for (int num = 1; num <= ROW_COLUMN; num++) {
                        if(checkAll(grid, num, row, column)){
                            grid[row][column] = num;

                            if(solver(grid)){
                                return true;
                            }else{
                                grid[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    //reset game
    private void resetGame(){
        JButton preDefined[] ={r2c1, r3c1, r3c3, r1c4, r2c5, r2c6, r3c5, r1c7, r1c8, r1c9, r2c7, r2c9, r3c8, r5c2, r5c3, r6c3, r6c2, r4c5, r4c5, r4c6, r6c4, r6c5, r4c8, r5c8, r5c7, r8c1, r9c1, r9c2, r9c3, r7c2, r7c5, r8c5, r9c6, r8c4, r7c7, r7c9, r8c9};
        JButton button[][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9}, 
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9}, 
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9}, 
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9}, 
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9}, 
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9}, 
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9}, 
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9}, 
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9}};
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                boolean flag=true;
                for (JButton preDefined1 : preDefined) {
                    if (button[i][j] == preDefined1) {
                        flag=false;
                    }
                }
                if(flag){
                    button[i][j].setText("");
                }
            }
        }
    }
    
    
    
    //solution
    private void seeSolution(){
        JButton preDefined[] ={r2c1, r3c1, r3c3, r1c4, r2c5, r2c6, r3c5, r1c7, r1c8, r1c9, r2c7, r2c9, r3c8, r5c2, r5c3, r6c3, r6c2, r4c5, r4c5, r4c6, r6c4, r6c5, r4c8, r5c8, r5c7, r8c1, r9c1, r9c2, r9c3, r7c2, r7c5, r8c5, r9c6, r8c4, r7c7, r7c9, r8c9};
        JButton button[][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9}, 
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9}, 
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9}, 
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9}, 
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9}, 
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9}, 
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9}, 
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9}, 
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9}};

        if(globalFlag){
            globalFlag=false;
            solution.setText("HIDE");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                boolean flag=true;
                for (JButton preDefined1 : preDefined) {
                    if (button[i][j] == preDefined1) {
                        flag=false;
                    }
                }
                if(flag){
                    button[i][j].setText(solvedBoard[i][j]);
                }
            }
        }
        }
        else{
            globalFlag=true;
            solution.setText("SOLUTION");
            resetGame();
        }
    }
    
    //check moves
    private void checkMoves(JButton btn){
        JButton button[][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9}, 
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9}, 
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9}, 
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9}, 
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9}, 
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9}, 
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9}, 
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9}, 
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9}};
        if(btn.getText().equals("CHECK MOVES")){
            
            boolean flag=false;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(!button[i][j].getText().equals(solvedBoard[i][j]) && !button[i][j].getText().equals("")){
                        button[i][j].setBackground(Color.red);
                        flag=true;
                    }
                }
            }
            if(flag)
                btn.setText("HIDE");
        }
        else{
            btn.setText("CHECK MOVES");
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(!button[i][j].getText().equals(solvedBoard[i][j]) && !button[i][j].getText().equals("")){
                        button[i][j].setBackground(Color.white);
                    }
                }
            }
        }
    }
    
    //Assign the current selection value
    private void AssignTurn(JButton btn){
        selection1.setBackground(Color.black);
        selection2.setBackground(Color.black);
        selection3.setBackground(Color.black);
        selection4.setBackground(Color.black);
        selection5.setBackground(Color.black);
        selection6.setBackground(Color.black);
        selection7.setBackground(Color.black);
        selection8.setBackground(Color.black);
        selection9.setBackground(Color.black);
        
        btn.setBackground(Color.blue);
        turn=btn.getText();
        
    }
    
    private void ActionButton(JButton btn){
        HashSet<JButton> pre =new HashSet<>(Arrays.asList(r2c1, r3c1, r3c3, r1c4, r2c5, r2c6, r3c5, r1c7, r1c8, r1c9, r2c7, r2c9, r3c8, r5c2, r5c3, r6c3, r6c2, r4c5, r4c5, r4c6, r6c4, r6c5, r4c8, r5c8, r5c7, r8c1, r9c1, r9c2, r9c3, r7c2, r7c5, r8c5, r9c6, r8c4, r7c7, r7c9, r8c9));

        if(!pre.contains(btn)){
            btn.setText(turn);  
            btn.setBackground(Color.white);
        }
        else{
            JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);            
        }
    }
    
    private void initGame(){
        JButton button[][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9}, 
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9}, 
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9}, 
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9}, 
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9}, 
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9}, 
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9}, 
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9}, 
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9}};
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=0){
                    button[i][j].setText(board[i][j]+"");
                    button[i][j].setBackground(Color.CYAN);
                }
            }
        }
        
    }
    public SudokuSolver() {
        initComponents();
        initGame();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        r1c1 = new javax.swing.JButton();
        r1c2 = new javax.swing.JButton();
        r1c3 = new javax.swing.JButton();
        r2c1 = new javax.swing.JButton();
        r2c2 = new javax.swing.JButton();
        r2c3 = new javax.swing.JButton();
        r3c2 = new javax.swing.JButton();
        r3c1 = new javax.swing.JButton();
        r3c3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        r1c4 = new javax.swing.JButton();
        r1c5 = new javax.swing.JButton();
        r1c6 = new javax.swing.JButton();
        r2c4 = new javax.swing.JButton();
        r2c5 = new javax.swing.JButton();
        r2c6 = new javax.swing.JButton();
        r3c5 = new javax.swing.JButton();
        r3c4 = new javax.swing.JButton();
        r3c6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        r1c7 = new javax.swing.JButton();
        r1c8 = new javax.swing.JButton();
        r1c9 = new javax.swing.JButton();
        r2c8 = new javax.swing.JButton();
        r2c7 = new javax.swing.JButton();
        r2c9 = new javax.swing.JButton();
        r3c8 = new javax.swing.JButton();
        r3c7 = new javax.swing.JButton();
        r3c9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        r4c1 = new javax.swing.JButton();
        r4c2 = new javax.swing.JButton();
        r4c3 = new javax.swing.JButton();
        r5c2 = new javax.swing.JButton();
        r5c1 = new javax.swing.JButton();
        r5c3 = new javax.swing.JButton();
        r6c2 = new javax.swing.JButton();
        r6c1 = new javax.swing.JButton();
        r6c3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        r4c4 = new javax.swing.JButton();
        r4c5 = new javax.swing.JButton();
        r4c6 = new javax.swing.JButton();
        r5c5 = new javax.swing.JButton();
        r5c4 = new javax.swing.JButton();
        r5c6 = new javax.swing.JButton();
        r6c5 = new javax.swing.JButton();
        r6c4 = new javax.swing.JButton();
        r6c6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        r7c1 = new javax.swing.JButton();
        r7c2 = new javax.swing.JButton();
        r7c3 = new javax.swing.JButton();
        r8c2 = new javax.swing.JButton();
        r8c1 = new javax.swing.JButton();
        r8c3 = new javax.swing.JButton();
        r9c2 = new javax.swing.JButton();
        r9c1 = new javax.swing.JButton();
        r9c3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        r4c7 = new javax.swing.JButton();
        r4c8 = new javax.swing.JButton();
        r4c9 = new javax.swing.JButton();
        r5c8 = new javax.swing.JButton();
        r5c7 = new javax.swing.JButton();
        r5c9 = new javax.swing.JButton();
        r6c8 = new javax.swing.JButton();
        r6c7 = new javax.swing.JButton();
        r6c9 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        r7c4 = new javax.swing.JButton();
        r7c5 = new javax.swing.JButton();
        r7c6 = new javax.swing.JButton();
        r8c5 = new javax.swing.JButton();
        r8c4 = new javax.swing.JButton();
        r8c6 = new javax.swing.JButton();
        r9c5 = new javax.swing.JButton();
        r9c4 = new javax.swing.JButton();
        r9c6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        r7c7 = new javax.swing.JButton();
        r7c8 = new javax.swing.JButton();
        r7c9 = new javax.swing.JButton();
        r8c8 = new javax.swing.JButton();
        r8c7 = new javax.swing.JButton();
        r8c9 = new javax.swing.JButton();
        r9c8 = new javax.swing.JButton();
        r9c7 = new javax.swing.JButton();
        r9c9 = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        solution = new javax.swing.JButton();
        checkMoves = new javax.swing.JButton();
        selection9 = new javax.swing.JButton();
        selection8 = new javax.swing.JButton();
        selection7 = new javax.swing.JButton();
        selection1 = new javax.swing.JButton();
        selection2 = new javax.swing.JButton();
        selection3 = new javax.swing.JButton();
        selection4 = new javax.swing.JButton();
        selection5 = new javax.swing.JButton();
        selection6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 600));
        setPreferredSize(new java.awt.Dimension(500, 600));
        setSize(new java.awt.Dimension(500, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(145, 150));

        r1c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c1ActionPerformed(evt);
            }
        });

        r1c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c2ActionPerformed(evt);
            }
        });

        r1c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c3ActionPerformed(evt);
            }
        });

        r2c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c1ActionPerformed(evt);
            }
        });

        r2c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c2ActionPerformed(evt);
            }
        });

        r2c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c3ActionPerformed(evt);
            }
        });

        r3c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c2ActionPerformed(evt);
            }
        });

        r3c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c1ActionPerformed(evt);
            }
        });

        r3c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(145, 150));

        r1c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c4ActionPerformed(evt);
            }
        });

        r1c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c5ActionPerformed(evt);
            }
        });

        r1c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c6ActionPerformed(evt);
            }
        });

        r2c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c4ActionPerformed(evt);
            }
        });

        r2c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c5ActionPerformed(evt);
            }
        });

        r2c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c6ActionPerformed(evt);
            }
        });

        r3c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c5ActionPerformed(evt);
            }
        });

        r3c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c4ActionPerformed(evt);
            }
        });

        r3c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(145, 150));

        r1c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c7ActionPerformed(evt);
            }
        });

        r1c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c8ActionPerformed(evt);
            }
        });

        r1c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r1c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c9ActionPerformed(evt);
            }
        });

        r2c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c8ActionPerformed(evt);
            }
        });

        r2c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c7ActionPerformed(evt);
            }
        });

        r2c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r2c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c9ActionPerformed(evt);
            }
        });

        r3c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c8ActionPerformed(evt);
            }
        });

        r3c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c7ActionPerformed(evt);
            }
        });

        r3c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r3c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r2c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r3c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(145, 150));

        r4c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c1ActionPerformed(evt);
            }
        });

        r4c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c2ActionPerformed(evt);
            }
        });

        r4c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c3ActionPerformed(evt);
            }
        });

        r5c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c2ActionPerformed(evt);
            }
        });

        r5c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c1ActionPerformed(evt);
            }
        });

        r5c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c3ActionPerformed(evt);
            }
        });

        r6c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c2ActionPerformed(evt);
            }
        });

        r6c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c1ActionPerformed(evt);
            }
        });

        r6c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(145, 150));

        r4c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c4ActionPerformed(evt);
            }
        });

        r4c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c5ActionPerformed(evt);
            }
        });

        r4c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c6ActionPerformed(evt);
            }
        });

        r5c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c5ActionPerformed(evt);
            }
        });

        r5c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c4ActionPerformed(evt);
            }
        });

        r5c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c6ActionPerformed(evt);
            }
        });

        r6c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c5ActionPerformed(evt);
            }
        });

        r6c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c4ActionPerformed(evt);
            }
        });

        r6c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(145, 150));

        r7c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c1ActionPerformed(evt);
            }
        });

        r7c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c2ActionPerformed(evt);
            }
        });

        r7c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c3ActionPerformed(evt);
            }
        });

        r8c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c2ActionPerformed(evt);
            }
        });

        r8c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c1ActionPerformed(evt);
            }
        });

        r8c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c3ActionPerformed(evt);
            }
        });

        r9c2.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c2ActionPerformed(evt);
            }
        });

        r9c1.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c1ActionPerformed(evt);
            }
        });

        r9c3.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r9c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r9c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r9c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(145, 150));

        r4c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c7ActionPerformed(evt);
            }
        });

        r4c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c8ActionPerformed(evt);
            }
        });

        r4c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r4c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c9ActionPerformed(evt);
            }
        });

        r5c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c8ActionPerformed(evt);
            }
        });

        r5c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c7ActionPerformed(evt);
            }
        });

        r5c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r5c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c9ActionPerformed(evt);
            }
        });

        r6c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c8ActionPerformed(evt);
            }
        });

        r6c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c7ActionPerformed(evt);
            }
        });

        r6c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r6c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(145, 150));

        r7c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c4ActionPerformed(evt);
            }
        });

        r7c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c5ActionPerformed(evt);
            }
        });

        r7c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c6ActionPerformed(evt);
            }
        });

        r8c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c5ActionPerformed(evt);
            }
        });

        r8c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c4ActionPerformed(evt);
            }
        });

        r8c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c6ActionPerformed(evt);
            }
        });

        r9c5.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c5ActionPerformed(evt);
            }
        });

        r9c4.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c4ActionPerformed(evt);
            }
        });

        r9c6.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r9c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r9c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r9c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r7c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c7ActionPerformed(evt);
            }
        });

        r7c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c8ActionPerformed(evt);
            }
        });

        r7c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r7c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c9ActionPerformed(evt);
            }
        });

        r8c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c8ActionPerformed(evt);
            }
        });

        r8c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c7ActionPerformed(evt);
            }
        });

        r8c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r8c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c9ActionPerformed(evt);
            }
        });

        r9c8.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c8ActionPerformed(evt);
            }
        });

        r9c7.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c7ActionPerformed(evt);
            }
        });

        r9c9.setPreferredSize(new java.awt.Dimension(40, 40));
        r9c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r9c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r9c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r9c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        reset.setBackground(new java.awt.Color(0, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 0, 51));
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        solution.setBackground(new java.awt.Color(255, 255, 51));
        solution.setText("SOLUTION");
        solution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionActionPerformed(evt);
            }
        });

        checkMoves.setBackground(new java.awt.Color(51, 255, 51));
        checkMoves.setText("CHECK MOVES");
        checkMoves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMovesActionPerformed(evt);
            }
        });

        selection9.setBackground(new java.awt.Color(0, 0, 0));
        selection9.setForeground(new java.awt.Color(255, 255, 255));
        selection9.setText("9");
        selection9.setPreferredSize(new java.awt.Dimension(40, 40));
        selection9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection9ActionPerformed(evt);
            }
        });

        selection8.setBackground(new java.awt.Color(0, 0, 0));
        selection8.setForeground(new java.awt.Color(255, 255, 255));
        selection8.setText("8");
        selection8.setPreferredSize(new java.awt.Dimension(40, 40));
        selection8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection8ActionPerformed(evt);
            }
        });

        selection7.setBackground(new java.awt.Color(0, 0, 0));
        selection7.setForeground(new java.awt.Color(255, 255, 255));
        selection7.setText("7");
        selection7.setPreferredSize(new java.awt.Dimension(40, 40));
        selection7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection7ActionPerformed(evt);
            }
        });

        selection1.setBackground(new java.awt.Color(0, 51, 255));
        selection1.setForeground(new java.awt.Color(255, 255, 255));
        selection1.setText("1");
        selection1.setPreferredSize(new java.awt.Dimension(40, 40));
        selection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection1ActionPerformed(evt);
            }
        });

        selection2.setBackground(new java.awt.Color(0, 0, 0));
        selection2.setForeground(new java.awt.Color(255, 255, 255));
        selection2.setText("2");
        selection2.setPreferredSize(new java.awt.Dimension(40, 40));
        selection2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection2ActionPerformed(evt);
            }
        });

        selection3.setBackground(new java.awt.Color(0, 0, 0));
        selection3.setForeground(new java.awt.Color(255, 255, 255));
        selection3.setText("3");
        selection3.setPreferredSize(new java.awt.Dimension(40, 40));
        selection3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection3ActionPerformed(evt);
            }
        });

        selection4.setBackground(new java.awt.Color(0, 0, 0));
        selection4.setForeground(new java.awt.Color(255, 255, 255));
        selection4.setText("4");
        selection4.setPreferredSize(new java.awt.Dimension(40, 40));
        selection4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection4ActionPerformed(evt);
            }
        });

        selection5.setBackground(new java.awt.Color(0, 0, 0));
        selection5.setForeground(new java.awt.Color(255, 255, 255));
        selection5.setText("5");
        selection5.setPreferredSize(new java.awt.Dimension(40, 40));
        selection5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection5ActionPerformed(evt);
            }
        });

        selection6.setBackground(new java.awt.Color(0, 0, 0));
        selection6.setForeground(new java.awt.Color(255, 255, 255));
        selection6.setText("6");
        selection6.setPreferredSize(new java.awt.Dimension(40, 40));
        selection6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(selection2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selection3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(selection4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(solution, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkMoves, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(selection5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(selection6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(selection7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(selection8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(selection9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(exit)
                    .addComponent(solution)
                    .addComponent(checkMoves))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void r2c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r2c2.setText(turn);
        r2c2.setBackground(Color.white);
    }                                    

    private void r1c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());        
    }                                    

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        JFrame frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Cornfirm if You wnd to Reset the Game", "Sudoku Puzzle", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            resetGame();
        }
        
    }                                     

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JFrame frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Cornfirm if You wnd to Exit", "Exit", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }                                    

    private void r4c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r3c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r3c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r3c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r4c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r5c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r6c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r6c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r8c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
    }                                    

    private void r2c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        ActionButton((JButton)evt.getSource());
        
    }                                    

    private void r7c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r1c2.setText(turn);
        r1c2.setBackground(Color.white);
    }                                    

    private void r1c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r1c3.setText(turn);
        r1c3.setBackground(Color.white);
    }                                    

    private void r1c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r1c5.setText(turn);
        r1c5.setBackground(Color.white);
    }                                    

    private void r1c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r1c6.setText(turn);
        r1c6.setBackground(Color.white);
    }                                    

    private void r2c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r2c3.setText(turn);
        r2c3.setBackground(Color.white);
    }                                    

    private void r2c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r2c4.setText(turn);
        r2c4.setBackground(Color.white);
    }                                    

    private void r2c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r2c8.setText(turn);
        r2c8.setBackground(Color.white);
    }                                    

    private void r3c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r3c6.setText(turn);
        r3c6.setBackground(Color.white);
    }                                    

    private void r3c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r3c7.setText(turn);
        r3c7.setBackground(Color.white);
    }                                    

    private void r3c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r3c9.setText(turn);
        r3c9.setBackground(Color.white);
    }                                    

    private void r4c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r4c1.setText(turn);
        r4c1.setBackground(Color.white);
    }                                    

    private void r4c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r4c2.setText(turn);
        r4c2.setBackground(Color.white);
    }                                    

    private void r4c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r4c4.setText(turn);
        r4c4.setBackground(Color.white);
    }                                    

    private void r4c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r4c7.setText(turn);
        r4c7.setBackground(Color.white);
    }                                    

    private void r4c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r4c9.setText(turn);
        r4c9.setBackground(Color.white);
    }                                    

    private void r5c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r5c1.setText(turn);
        r5c1.setBackground(Color.white);
    }                                    

    private void r5c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r5c4.setText(turn);
        r5c4.setBackground(Color.white);
    }                                    

    private void r5c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r5c5.setText(turn);
        r5c5.setBackground(Color.white);
    }                                    

    private void r5c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r5c6.setText(turn);
        r5c6.setBackground(Color.white);
    }                                    

    private void r5c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r5c9.setText(turn);
        r5c9.setBackground(Color.white);
    }                                    

    private void r6c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r6c1.setText(turn);
        r6c1.setBackground(Color.white);
    }                                    

    private void r6c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r6c3.setText(turn);
        r6c3.setBackground(Color.white);
    }                                    

    private void r6c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r6c6.setText(turn);
        r6c6.setBackground(Color.white);
        
     
    }                                    

    private void r6c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r6c7.setText(turn);
        r6c7.setBackground(Color.white);
    }                                    

    private void r6c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r6c8.setText(turn);
        r6c8.setBackground(Color.white);
    }                                    

    private void r7c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r7c1.setText(turn);
        r7c1.setBackground(Color.white);
    }                                    

    private void r7c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r7c3.setText(turn);
        r7c3.setBackground(Color.white);
    }                                    

    private void r7c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r7c4.setText(turn);
        r7c4.setBackground(Color.white);
    }                                    

    private void r7c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r7c6.setText(turn);
        r7c6.setBackground(Color.white);
    }                                    

    private void r7c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r7c8.setText(turn);
        r7c8.setBackground(Color.white);
    }                                    

    private void r8c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r8c2.setText(turn);
        r8c2.setBackground(Color.white);
    }                                    

    private void r8c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r8c3.setText(turn);
        r8c3.setBackground(Color.white);
    }                                    

    private void r8c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r8c6.setText(turn);
        r8c6.setBackground(Color.white);
    }                                    

    private void r8c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r8c7.setText(turn);
        r8c7.setBackground(Color.white);
    }                                    

    private void r8c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r8c8.setText(turn);
        r8c8.setBackground(Color.white);
    }                                    

    private void r9c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r9c4.setText(turn);
        r9c4.setBackground(Color.white);
    }                                    

    private void r9c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r9c5.setText(turn);
        r9c5.setBackground(Color.white);
    }                                    

    private void r9c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r9c7.setText(turn);
        r9c7.setBackground(Color.white);
    }                                    

    private void r9c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r9c8.setText(turn);
        r9c8.setBackground(Color.white);
    }                                    

    private void r9c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        r9c9.setText(turn);
        r9c9.setBackground(Color.white);
    }                                    

    private void r1c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r4c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r4c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r6c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r6c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Place is already allocated", "Message",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void checkMovesActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        checkMoves((JButton)evt.getSource());
    }                                          

    private void solutionActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        seeSolution();
    }                                        

    private void selection1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
        
    }                                          

    private void selection2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
        
    }                                          

    private void selection3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
        
    }                                          

    private void selection4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
    }                                          

    private void selection5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
    }                                          

    private void selection6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
    }                                          

    private void selection7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        AssignTurn((JButton)evt.getSource());
        // TODO add your handling code here:
    }                                          

    private void selection8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
    }                                          

    private void selection9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        AssignTurn((JButton)evt.getSource());
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SudokuSolver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuSolver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuSolver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuSolver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuSolver().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify                     
    private javax.swing.JButton checkMoves;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton r1c1;
    private javax.swing.JButton r1c2;
    private javax.swing.JButton r1c3;
    private javax.swing.JButton r1c4;
    private javax.swing.JButton r1c5;
    private javax.swing.JButton r1c6;
    private javax.swing.JButton r1c7;
    private javax.swing.JButton r1c8;
    private javax.swing.JButton r1c9;
    private javax.swing.JButton r2c1;
    private javax.swing.JButton r2c2;
    private javax.swing.JButton r2c3;
    private javax.swing.JButton r2c4;
    private javax.swing.JButton r2c5;
    private javax.swing.JButton r2c6;
    private javax.swing.JButton r2c7;
    private javax.swing.JButton r2c8;
    private javax.swing.JButton r2c9;
    private javax.swing.JButton r3c1;
    private javax.swing.JButton r3c2;
    private javax.swing.JButton r3c3;
    private javax.swing.JButton r3c4;
    private javax.swing.JButton r3c5;
    private javax.swing.JButton r3c6;
    private javax.swing.JButton r3c7;
    private javax.swing.JButton r3c8;
    private javax.swing.JButton r3c9;
    private javax.swing.JButton r4c1;
    private javax.swing.JButton r4c2;
    private javax.swing.JButton r4c3;
    private javax.swing.JButton r4c4;
    private javax.swing.JButton r4c5;
    private javax.swing.JButton r4c6;
    private javax.swing.JButton r4c7;
    private javax.swing.JButton r4c8;
    private javax.swing.JButton r4c9;
    private javax.swing.JButton r5c1;
    private javax.swing.JButton r5c2;
    private javax.swing.JButton r5c3;
    private javax.swing.JButton r5c4;
    private javax.swing.JButton r5c5;
    private javax.swing.JButton r5c6;
    private javax.swing.JButton r5c7;
    private javax.swing.JButton r5c8;
    private javax.swing.JButton r5c9;
    private javax.swing.JButton r6c1;
    private javax.swing.JButton r6c2;
    private javax.swing.JButton r6c3;
    private javax.swing.JButton r6c4;
    private javax.swing.JButton r6c5;
    private javax.swing.JButton r6c6;
    private javax.swing.JButton r6c7;
    private javax.swing.JButton r6c8;
    private javax.swing.JButton r6c9;
    private javax.swing.JButton r7c1;
    private javax.swing.JButton r7c2;
    private javax.swing.JButton r7c3;
    private javax.swing.JButton r7c4;
    private javax.swing.JButton r7c5;
    private javax.swing.JButton r7c6;
    private javax.swing.JButton r7c7;
    private javax.swing.JButton r7c8;
    private javax.swing.JButton r7c9;
    private javax.swing.JButton r8c1;
    private javax.swing.JButton r8c2;
    private javax.swing.JButton r8c3;
    private javax.swing.JButton r8c4;
    private javax.swing.JButton r8c5;
    private javax.swing.JButton r8c6;
    private javax.swing.JButton r8c7;
    private javax.swing.JButton r8c8;
    private javax.swing.JButton r8c9;
    private javax.swing.JButton r9c1;
    private javax.swing.JButton r9c2;
    private javax.swing.JButton r9c3;
    private javax.swing.JButton r9c4;
    private javax.swing.JButton r9c5;
    private javax.swing.JButton r9c6;
    private javax.swing.JButton r9c7;
    private javax.swing.JButton r9c8;
    private javax.swing.JButton r9c9;
    private javax.swing.JButton reset;
    private javax.swing.JButton selection1;
    private javax.swing.JButton selection2;
    private javax.swing.JButton selection3;
    private javax.swing.JButton selection4;
    private javax.swing.JButton selection5;
    private javax.swing.JButton selection6;
    private javax.swing.JButton selection7;
    private javax.swing.JButton selection8;
    private javax.swing.JButton selection9;
    private javax.swing.JButton solution;
    // End of variables declaration                   
}
