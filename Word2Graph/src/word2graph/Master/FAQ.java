/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word2graph.Master;

/**
 *
 * @author Usuario
 */
public class FAQ extends javax.swing.JFrame {

    /**
     * Creates new form FAQ
     */
  
    public FAQ() {
        initComponents();
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setTitle("FAQ");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(40);
        jTextArea1.setText("Bienvenido a Word2Graph, para comenzar a usar este programa se requiere el uso de Gephi en su versión más actualizada (0.9.1), a su vez esindispensable el uso de usuarios para recolectar los textos, los     cuales serán procesados por el Master.\nSi hay errores De lectura y escritura de Archivos, asegúrese de que  tiene permisos para las carpetas a acceder, tanto para lectura como  para escritura.\n\nGephi es un software open-source Multiplataforma distribuido bajo la doble licencia CDDL 1.0 y GNU General Public License v3.\n\nSi desea descargar Gephi 0.9.1 (Versión más actualizada) presione el siguiente link: \nhttps://gephi.org/users/download/\n\nPara más información de cómo usar Gephi, entonces diríjase aquí: https://gephi.org/users/\nCómo se Usa el Programa:\n\n•\tMaster\n\nSe inicia el programa y se selecciona la opción Master, apenas al iniciar, el master debe obtener su IP para poder ser enviada a los usuarios y de esa manera generar la conexión, luego al esperar que los usuarios hayan enviado todos sus archivos, entonces proceda a iniciar el programa(Empezar), el cual al finalizar el procedimiento (el cual depende de la cantidad de Texto) arroja en pantalla un mensaje de proceso finalizado, hasta que no se haya mostrado el mensaje, no realice modificaciones en la interfaz, para finalizar presiona el botón de abrir grafo, el cuál abrirá Gephi automáticamente con el Grafo generado.\n\n•\tUsuario\n\nSe inicia el programa y se selecciona la opción Usuario, empezamos anotando la IP del master para completar la conexión, luego procedemos a seleccionar las carpetas en las cuales estén ubicados los textos que deseamos generar (Agregar Directorios), al seleccionar los directorios correspondientes asegúrese de marcarlos para que verificar los que desea utilizar, y al estar seguro de su decisión, proceda a enviar los archivos al master (Empezar).\nEste proyecto fue desarrollado para la Materia “Programación Orientada a Objetos” de la Universidad Nacional de Colombia, sus desarrolladores fueron:\n\nJuan Jesús Pulido Sánchez\nJohan Sebastián Salamanca Gonzales\nHarold Nicolás Saavedra Alvarado\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAQ().setVisible(true);
                
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}