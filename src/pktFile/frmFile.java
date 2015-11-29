package pktFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmFile extends javax.swing.JFrame {
    
    JFileChooser chooser = new JFileChooser();
    
    ArrayList<String> expression_list ;
    
    ArrayList<Boolean> result = new ArrayList<Boolean>();
    
    StringBuilder sb = new StringBuilder();
    String save_file_location ="";
    
    public frmFile() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        file_location = new javax.swing.JLabel();
        analyze_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_area = new javax.swing.JTextArea();
        openButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        saveFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        file_location.setText("Please open a file.");

        analyze_button.setText("Analyze");
        analyze_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyze_buttonActionPerformed(evt);
            }
        });

        result_area.setEditable(false);
        result_area.setBackground(new java.awt.Color(102, 255, 102));
        result_area.setColumns(20);
        result_area.setRows(5);
        jScrollPane1.setViewportView(result_area);

        openButton.setText("Open");
        openButton.setActionCommand("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        saveFileButton.setText("Save File");
        saveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(analyze_button, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                        .addComponent(saveFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(file_location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(file_location, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyze_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analyze_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyze_buttonActionPerformed
        expression_list = new ArrayList<String>();
        result = new ArrayList<>();
        sb = new StringBuilder();
        try{
            
            if(chooser.getSelectedFile()==null){
                JOptionPane.showMessageDialog(rootPane, "Select a file first");
            }
            else{
                Scanner scan = new Scanner ( new FileInputStream(chooser.getCurrentDirectory()+"\\"+chooser.getSelectedFile().getName()));
                
                while(scan.hasNextLine()){
                    Checker check = new Checker();
                    String expression = scan.nextLine();
                    expression_list.add(expression);
                    result.add(check.checkValid(expression.toCharArray()));
                }
                
                System.out.println("");
                sb.append("Expression");
                sb.append("\t\t\t\t");
                sb.append("Result");
                sb.append("\n\n");
                
                sb.append("************");
                sb.append("\t\t\t\t");
                sb.append("************");
                sb.append("\n\n");
                
                for (int i = 0; i < expression_list.size(); i++) {
                    sb.append(expression_list.get(i));
                    sb.append("\t\t\t");
                    sb.append(result.get(i));
                    sb.append('\n');
                    sb.append('\n');
                }
                result_area.setText(sb.toString());
            }
        }
        catch(Exception e){
            System.out.println("Unknown Error");
        }
        
        
    }//GEN-LAST:event_analyze_buttonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        String cad;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Mel FILES", "mel", "mel");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(frmFile.this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            save_file_location = chooser.getCurrentDirectory().toString();
            file_location.setText("You have choosen "+chooser.getCurrentDirectory()+"\\"+chooser.getSelectedFile().getName());
            
        }
    }//GEN-LAST:event_openButtonActionPerformed

    private void saveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileButtonActionPerformed
        int returnVal = chooser.showSaveDialog(frmFile.this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try{
                PrintWriter pw = new PrintWriter( new FileOutputStream(chooser.getSelectedFile()+"_output.mel",true));
                
                for(int i=0;i<expression_list.size();i++){
                
                    pw.print(expression_list.get(i));
                    pw.print("\t\t\t");
                    pw.print(result.get(i));
                    pw.println();
                }
                pw.close();
                 
            }
            catch(Exception e){
                System.out.println("Unknown Error");
                
            }
            JOptionPane.showMessageDialog(rootPane, "File has been saved Successfully !");
              
        }
    }//GEN-LAST:event_saveFileButtonActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFile().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyze_button;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel file_location;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openButton;
    private javax.swing.JTextArea result_area;
    private javax.swing.JButton saveFileButton;
    // End of variables declaration//GEN-END:variables
}
