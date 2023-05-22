
package unit14.Actividad24_Ampliacion;

import javax.swing.JOptionPane;
import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;
import unit14.Actividad15_Aplicacion.Oficina;

/*
    Swing es una biblioteca gráfica para Java que permite crear ventanas que contienen
    distintos elementos gráficos como botones, cajas de texto, listas desplegables, etc. Se
    pide investigar sobre Swing y añadir una interfaz gráfica sencilla que permita introducir los datos de una ofiicna mediante un 
    formulario y guardar dichos datos en la base de datos
*/

public class Actividad24 extends javax.swing.JFrame {


    public Actividad24() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jlCiudad = new javax.swing.JLabel();
        jtfCiudad = new javax.swing.JTextField();
        jlCiudad1 = new javax.swing.JLabel();
        jtfSuperficie = new javax.swing.JTextField();
        jlCiudad2 = new javax.swing.JLabel();
        jtfVentas = new javax.swing.JTextField();
        jbCrearOficina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("Crear Oficina");

        jlCiudad.setText("Ciudad:");

        jlCiudad1.setText("Superficie:");

        jlCiudad2.setText("Ventas:");

        jbCrearOficina.setText("Crear");
        jbCrearOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearOficinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlCiudad)
                        .addGap(18, 18, 18)
                        .addComponent(jtfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlCiudad2)
                        .addGap(18, 18, 18)
                        .addComponent(jtfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlCiudad1)
                        .addGap(18, 18, 18)
                        .addComponent(jtfSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jbCrearOficina)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCiudad)
                    .addComponent(jtfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCiudad1)
                    .addComponent(jtfSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCiudad2)
                    .addComponent(jtfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jbCrearOficina)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearOficinaActionPerformed
        String ciudad = jtfCiudad.getText(); // Obtenemos los datos del input de Ciudad
        String superficieString = jtfSuperficie.getText(); // Obtenemos los datos del input de Superficie
        String ventasString = jtfVentas.getText(); // Obtenemos los datos del input de Ventas
        boolean isValidOficina = true; // Variable para comprobar si los datos son válidos
        String errorMessage = ""; // Variable para guardar el mensaje de error
        
        if (ciudad.isBlank()) { // Comprobamos si el campo de Ciudad está vacío
            isValidOficina = false;
            errorMessage = "La ciudad no puede estar vacía";
        } else if (!superficieString.matches("\\d+")) { // Comprobamos si el campo de Superficie es numérico
            isValidOficina = false;
            errorMessage = "La superficie debe de ser numérica";
        } else if (Integer.parseInt(superficieString) <= 0) { // Comprobamos si el campo de Superficie es negativo
            isValidOficina = false;
            errorMessage = "La superficie no puede ser negativa";
        } else if (!ventasString.matches("\\d+")) { // Comprobamos si el campo de Ventas es numérico
            isValidOficina = false;
            errorMessage = "Las ventas debe de ser numérica";
        } else if (Integer.parseInt(ventasString) <= 0) { // Comprobamos si el campo de Ventas es negativo
            isValidOficina = false;
            errorMessage = "Las ventas no puede ser negativa";
        }
        
        if (!isValidOficina) { // Si los datos no son válidos, mostramos un mensaje de error
            JOptionPane.showMessageDialog(this, errorMessage,"Error", JOptionPane.ERROR_MESSAGE);
        } else { // Si los datos son válidos, creamos la oficina
            OficinaDAO oficinaDAO = new OficinaDAO(); // Creamos una instancia de OficinaDAO
            // Creamos una nueva instancia de Oficina con los datos introducidos
            Oficina nuevaOficina = new Oficina(0, ciudad, Integer.parseInt(superficieString), Integer.parseInt(ventasString));
            
            oficinaDAO.insert(nuevaOficina); // Insertamos la nueva oficina en la base de datos
        }
    }//GEN-LAST:event_jbCrearOficinaActionPerformed

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
            java.util.logging.Logger.getLogger(Actividad24.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividad24.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividad24.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividad24.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividad24().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCrearOficina;
    private javax.swing.JLabel jlCiudad;
    private javax.swing.JLabel jlCiudad1;
    private javax.swing.JLabel jlCiudad2;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfCiudad;
    private javax.swing.JTextField jtfSuperficie;
    private javax.swing.JTextField jtfVentas;
    // End of variables declaration//GEN-END:variables
}
