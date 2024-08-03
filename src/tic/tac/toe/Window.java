/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tic.tac.toe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


/**
 *
 * @author Lenovo
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    Random ran=new Random();
    private ArrayList<JButton>btnArray;
    private boolean playerchance;
    public Window() {
        
        initComponents();
        setResizable(false);
        addButton();
        firstChance();
        activeActionButtonLoop();
        
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (JButton btn : btnArray) {
                btn.setText("");
                btn.setBackground(Color.white);
                btn.setEnabled(true);
                title.setText("Tic-Tac-Toe");
                
            }
            }
        });
        
    }
    
    public void check(){
        if(
              btn1.getText()!="" &&
              btn2.getText()!="" &&
              btn3.getText()!="" &&
              btn4.getText()!="" &&
              btn5.getText()!="" &&
              btn6.getText()!="" &&
              btn7.getText()!="" &&
              btn8.getText()!="" &&
              btn9.getText()!=""
            ){
            for (JButton btn : btnArray) {
                btn.setEnabled(false);
                title.setText("Game Over!");
                
            }
        }
        //X wining Chances -> 
        if(
                (btn1.getText()=="X") &&
                (btn2.getText()=="X") &&
                (btn3.getText()=="X")
                ){
            xWins(1,2,3);
        }else if(
                (btn1.getText()=="X") &&
                (btn4.getText()=="X") &&
                (btn7.getText()=="X")
                ){
            xWins(1,4,7);
        }else if(
                (btn4.getText()=="X") &&
                (btn5.getText()=="X") &&
                (btn6.getText()=="X")
                ){
            xWins(4,5,6);
        }else if(
                (btn7.getText()=="X") &&
                (btn8.getText()=="X") &&
                (btn9.getText()=="X")
                ){
            xWins(7,8,9);
        }else if(
                (btn2.getText()=="X") &&
                (btn5.getText()=="X") &&
                (btn8.getText()=="X")
                ){
            xWins(2,5,8);
        }else if(
                (btn3.getText()=="X") &&
                (btn6.getText()=="X") &&
                (btn9.getText()=="X")
                ){
            xWins(3,6,9);
        }else if(
                (btn1.getText()=="X") &&
                (btn5.getText()=="X") &&
                (btn9.getText()=="X")
                ){
            xWins(1,5,9);
        }else if(
                (btn3.getText()=="X") &&
                (btn5.getText()=="X") &&
                (btn7.getText()=="X")
                ){
            xWins(3,5,7);
        }
       //O wining Chances -> 
       if(
                (btn1.getText()=="O") &&
                (btn2.getText()=="O") &&
                (btn3.getText()=="O")
                ){
            oWins(1,2,3);
        }else if(
                (btn1.getText()=="O") &&
                (btn4.getText()=="O") &&
                (btn7.getText()=="O")
                ){
            oWins(1,4,7);
        }else if(
                (btn4.getText()=="O") &&
                (btn5.getText()=="O") &&
                (btn6.getText()=="O")
                ){
            oWins(4,5,6);
        }else if(
                (btn7.getText()=="O") &&
                (btn8.getText()=="O") &&
                (btn9.getText()=="O")
                ){
            oWins(7,8,9);
        }else if(
                (btn2.getText()=="O") &&
                (btn5.getText()=="O") &&
                (btn8.getText()=="O")
                ){
            oWins(2,5,8);
        }else if(
                (btn3.getText()=="O") &&
                (btn6.getText()=="O") &&
                (btn9.getText()=="O")
                ){
            oWins(3,6,9);
        }else if(
                (btn1.getText()=="O") &&
                (btn5.getText()=="O") &&
                (btn9.getText()=="O")
                ){
            oWins(1,5,9);
        }else if(
                (btn3.getText()=="O") &&
                (btn5.getText()=="O") &&
                (btn7.getText()=="O")
                ){
            oWins(3,5,7);
        }
    }
    public void xWins(int a,int b,int c){
        btnArray.get(a-1).setBackground(Color.GREEN);
        btnArray.get(b-1).setBackground(Color.GREEN);
        btnArray.get(c-1).setBackground(Color.GREEN);
        title.setText("X Wins");
        for (JButton btn : btnArray) {
                btn.setEnabled(false);
                
               
            }
    }
    public void oWins(int a,int b,int c){
        btnArray.get(a-1).setBackground(Color.GREEN);
        btnArray.get(b-1).setBackground(Color.GREEN);
        btnArray.get(c-1).setBackground(Color.GREEN);
        title.setText("O Wins");
        for (JButton btn : btnArray) {
                btn.setEnabled(false);
               
            }
    }
    public void activeActionButtonLoop(){
        for(JButton btn: btnArray){
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if(playerchance){
                        if(btn.getText()==""){
                            btn.setForeground(Color.blue);
                            btn.setText("X");
                            title.setText("O turn");
                            playerchance=false;
                            check();
                        }
                    }else{
                        if(btn.getText()==""){
                            btn.setForeground(Color.orange);
                            btn.setText("O");
                            title.setText("X turn");
                            playerchance=true;
                            check();
                        }
                    }
                
                }
                
            });
            
        }
        
        
        
        
    }
    public void firstChance(){
        try {
            Thread.sleep(2000);
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if(ran.nextInt(2)==0){
            playerchance=true;
            title.setText("X turn");
        }else{
            playerchance=false;
            title.setText("O turn");
        }
    }
    public void addButton(){
        btnArray=new ArrayList<>();
        btnArray.add(btn1);
        btnArray.add(btn2);
        btnArray.add(btn3);
        btnArray.add(btn4);
        btnArray.add(btn5);
        btnArray.add(btn6);
        btnArray.add(btn7);
        btnArray.add(btn8);
        btnArray.add(btn9);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Tic-Tac-Toe");

        btn1.setBackground(new java.awt.Color(255, 255, 204));
        btn1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(255, 255, 204));
        btn2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btn3.setBackground(new java.awt.Color(255, 255, 204));
        btn3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(255, 255, 204));
        btn4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btn5.setBackground(new java.awt.Color(255, 255, 204));
        btn5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btn6.setBackground(new java.awt.Color(255, 255, 204));
        btn6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btn7.setBackground(new java.awt.Color(255, 255, 204));
        btn7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btn8.setBackground(new java.awt.Color(255, 255, 204));
        btn8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btn9.setBackground(new java.awt.Color(255, 255, 204));
        btn9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        btnReset.setBackground(new java.awt.Color(255, 0, 51));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 87, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
