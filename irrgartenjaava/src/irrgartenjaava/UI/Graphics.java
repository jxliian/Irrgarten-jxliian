/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package irrgartenjaava.UI;

import irrgartenjaava.GameState;
import irrgartenjaava.Directions;

/**
 *
 * @author jxlig0d
 */
public class Graphics extends javax.swing.JFrame implements UI{

    
    private Cursors cursor;
    
    /**
     * Creates new form Graphics
     */
    public Graphics() {
        initComponents();
        cursor= new Cursors(this, true);
        ganador_mark.setVisible(false); // Para que la etiqueta de ganador no sea visible.
        setVisible(true);
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
        laberinto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        monstruos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jugadores = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        ganador_mark = new javax.swing.JLabel();
        jugadores_m = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jugador = new javax.swing.JTextField();
        log_m = new javax.swing.JLabel();
        monstruos_m = new javax.swing.JLabel();
        jugador_m = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        laberinto.setColumns(20);
        laberinto.setRows(5);
        jScrollPane1.setViewportView(laberinto);

        monstruos.setColumns(20);
        monstruos.setRows(5);
        jScrollPane2.setViewportView(monstruos);

        jugadores.setColumns(20);
        jugadores.setRows(5);
        jScrollPane3.setViewportView(jugadores);

        log.setColumns(20);
        log.setRows(5);
        jScrollPane4.setViewportView(log);

        ganador_mark.setText("jLabel1");

        jugadores_m.setText("jLabel1");

        titulo.setText("jLabel1");

        jugador.setText("jTextField1");

        log_m.setText("jLabel1");

        monstruos_m.setText("jLabel1");

        jugador_m.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monstruos_m)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ganador_mark, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jugadores_m, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(40, 40, 40))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addComponent(log_m)
                    .addComponent(jugador_m)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ganador_mark)
                        .addGap(15, 15, 15)
                        .addComponent(jugadores_m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monstruos_m)
                        .addGap(151, 151, 151)
                        .addComponent(jugador_m)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(log_m)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // no main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ganador_mark;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jugador;
    private javax.swing.JLabel jugador_m;
    private javax.swing.JTextArea jugadores;
    private javax.swing.JLabel jugadores_m;
    private javax.swing.JTextArea laberinto;
    private javax.swing.JTextArea log;
    private javax.swing.JLabel log_m;
    private javax.swing.JTextArea monstruos;
    private javax.swing.JLabel monstruos_m;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showGame(GameState gameState){
        
        this.laberinto.setText(gameState.getLabyrinth());
        this.monstruos.setText(gameState.getMonsters());
        this.jugadores.setText(gameState.getPlayers());
        this.log.setText(gameState.getLog());

        this.jugador.setText("Player " + Integer.toString(gameState.getCurrentPlayer()));

        if (gameState.isWinner()) {
            // Mostrar la etiqueta de ganador
            this.ganador_mark.setVisible(true);
        }

        repaint(); // Para actualizar la interfaz gráfica
    }
    
    @Override
    public Directions nextMove(){
        return this.cursor.getDirection();
    }

}
