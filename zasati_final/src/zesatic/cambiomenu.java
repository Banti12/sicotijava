/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zesatic;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import rojeru_san.RSButton;
import rojeru_san.RSMTextFull;
import rojeru_san.RSPanelsSlider;
import rojerusan.RSComboMetro;
import rojerusan.necesario.RSScrollBar;

/**
 *
 * @author Brayan
 */
public class cambiomenu extends javax.swing.JPanel {

    /**
     * Creates new form cambio
     */
    conectar dentro;
    Color transparente= new Color(0,0,0,0);
    String usuario;
    public cambiomenu(String usuario) {
        this.usuario=usuario;
        dentro= new conectar();
        initComponents();
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setBackground(transparente);
        iniciar();
        apagados();
    }
    public void limpiadorbox(RSComboMetro array[]){
        for (int i=0;i<array.length;i++){
            array[i].setSelectedIndex(0);
        }
    }
    public void limpiadorcajatexto(RSMTextFull array[]){
        for (int i=0;i<array.length;i++){
            array[i].setText("");
        }
    }
    public void actualizar_cambio(RSButton cambio){
        if(cambio.getBackground().equals(new Color(0,30,100))){
            RSMTextFull array[]={cambiobuscarjefe,nombrejefecambio,apjefecambio,amjefecambio,nomEmpresa8,nomEmpresa9,nomEmpresa10
                    ,nomEmpresa12,cambiobuscarempresa,nombreempleadocambio,apempleadocambio,amempleadocambio,idjefeempleadocambio};
            RSComboMetro array1[]={puesto1,nivel1,horario1};
            limpiadorcajatexto(array);
            limpiadorbox(array1);
            apagados();
            cambiotablajefe.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Id", "Nombre", "Apellido paterno", "Apellido materno"
                }
            ));
            cambiogrupocliente.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {"5", "Sin grupo"},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {
                    "IdGrupo", "Grupo"
                }
            ));
            cambiotablaempresa.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "IdCliente", "Nombre", "Ingreso", "RFC", "IdGrupo"
                }
            ));
            cambiotablaempleado.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String [] {
                    "Id", "Nombre", "Apellido paterno", "Apellido materno", "IdSocio", "Socio", "Ingreso"
                }
            ));
        }
    }
    public void apagados(){
        errorjefecambio.setVisible(false);
        errorempresacambio.setVisible(false);
        errorempleadocambio.setVisible(false);
    }
    public void iniciar(){

        cambio_socio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(255,69,0)));
        cambiotablajefe.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        cambiogrupocliente.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        cambiotablaempresa.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        cambiotablaempleado.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        jScrollPane15.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane13.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane14.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane11.getVerticalScrollBar().setUI(new RSScrollBar());

        
    }
    public void cambiarcolorreporte(RSButton n , RSButton menu[]){
                n.setBackground(new java.awt.Color(255, 255, 255));
                n.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-azul.png"))); // NOI18N
                n.setColorText(new java.awt.Color(0, 30, 100));
                n.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(255,69,20)));
                n.setColorHover(new Color(255,255,255));
                n.setColorTextHover(new Color(0,30,100));
                n.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                for(int i =0;i< menu.length; i++)
                {
                    menu[i].setBackground(new java.awt.Color(0, 30, 100));
                    menu[i].setColorText(new java.awt.Color(255, 255, 255));
                    menu[i].setBorder(null);
                    menu[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
                    menu[i].setColorHover(new java.awt.Color(204, 204, 255));
                    menu[i].setColorTextHover(new java.awt.Color(0, 30, 100));
                }
            }
    public String verificarnombre(String contraseña){
       char clave;
       String password=contraseña;
       int jota=0;
       for (byte i = 0; i < contraseña.trim().length(); i++) {
               clave = contraseña.charAt(i);
               String passValue = String.valueOf(clave);
               if(passValue.matches("[\\+\\-\\*\\/\\=\\%\\&\\#\\!\\?\\^\\“\\'\\~\\ \\<\\>\\(\\[\\)\\]\\{\\}\\:\\;\\.\\,\"]") && !passValue.endsWith(" ")) {
                    if(!String.valueOf(contraseña.trim().charAt(i-1)).equals("\\")){
                        if(contraseña.trim().lastIndexOf(passValue)==contraseña.trim().length()-1){
                             String aux[]=contraseña.trim().split("\\"+passValue);
                             password="";
                             if(aux.length<=1){
                                  password+=aux[0]+"\\"+passValue;
                                  contraseña=password;
                             }else{
                                     for(int j=0; j<aux.length-1;j++){
                                         password+=aux[j]+"\\"+clave;
                                         jota=j;
                                     }
                                     contraseña=password+aux[jota+1]+"\\"+clave;
                             }
                     }else{
                         String aux[]=contraseña.trim().split("\\"+passValue);
                         password="";
                         if(aux.length<=1){
                              password+=aux[0]+"\\"+passValue;
                              contraseña=password;
                         }else{
                                 for(int j=0; j<aux.length-1;j++){
                                     password+=aux[j]+"\\"+clave;
                                     jota=j;
                                 }
                                 contraseña=password+aux[jota+1];
                         } 
                     }
                     System.out.println(contraseña);
                     jota=0;
                     i++; 
                     }else{
                        i++;
                    }         
            }
        }
       return contraseña;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanelRound2 = new zesatic.JPanelRound();
        rSButtonRiple5 = new rojeru_san.RSButtonRiple();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cambiomenu = new javax.swing.JPanel();
        paneldelreporte1 = new javax.swing.JPanel();
        cambio_socio = new rojeru_san.RSButton();
        cambio_cliente = new rojeru_san.RSButton();
        cambio_colaborador = new rojeru_san.RSButton();
        slidercambio = new rojeru_san.RSPanelsSlider();
        socio2 = new javax.swing.JPanel();
        jPanelRound15 = new zesatic.JPanelRound();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        nombrejefecambio = new rojeru_san.RSMTextFull();
        apjefecambio = new rojeru_san.RSMTextFull();
        amjefecambio = new rojeru_san.RSMTextFull();
        cambiar = new rojeru_san.RSButtonRiple();
        errorjefecambio = new javax.swing.JLabel();
        jPanelRound1 = new zesatic.JPanelRound();
        jScrollPane11 = new javax.swing.JScrollPane();
        cambiotablajefe = new rojerusan.RSTableMetro();
        cambiobuscarjefe = new rojeru_san.RSMTextFull();
        rSButton13 = new rojeru_san.RSButton();
        cliente2 = new javax.swing.JPanel();
        jPanelRound16 = new zesatic.JPanelRound();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        nomEmpresa9 = new rojeru_san.RSMTextFull();
        nomEmpresa10 = new rojeru_san.RSMTextFull();
        nomEmpresa12 = new rojeru_san.RSMTextFull();
        rSButtonRiple23 = new rojeru_san.RSButtonRiple();
        errorempresacambio = new javax.swing.JLabel();
        jPanelRound19 = new zesatic.JPanelRound();
        rSButton16 = new rojeru_san.RSButton();
        cambiobuscarempresa = new rojeru_san.RSMTextFull();
        jScrollPane14 = new javax.swing.JScrollPane();
        cambiotablaempresa = new rojerusan.RSTableMetro();
        nomEmpresa8 = new rojeru_san.RSMTextFull();
        rSButton15 = new rojeru_san.RSButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        cambiogrupocliente = new rojerusan.RSTableMetro();
        colaborador2 = new javax.swing.JPanel();
        jPanelRound17 = new zesatic.JPanelRound();
        jLabel90 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        nombreempleadocambio = new rojeru_san.RSMTextFull();
        apempleadocambio = new rojeru_san.RSMTextFull();
        amempleadocambio = new rojeru_san.RSMTextFull();
        idjefeempleadocambio = new rojeru_san.RSMTextFull();
        Puesto3 = new javax.swing.JLabel();
        puesto1 = new rojerusan.RSComboMetro();
        nivel1 = new rojerusan.RSComboMetro();
        Puesto2 = new javax.swing.JLabel();
        horario1 = new rojerusan.RSComboMetro();
        fechainiciotexto8 = new javax.swing.JLabel();
        cambiomodelsocio1 = new rojerusan.RSComboMetro();
        jPanelRound3 = new zesatic.JPanelRound();
        jScrollPane15 = new javax.swing.JScrollPane();
        cambiotablaempleado = new rojerusan.RSTableMetro();
        cambiobuscarempleado = new rojeru_san.RSMTextFull();
        rSButton17 = new rojeru_san.RSButton();
        errorempleadocambio = new javax.swing.JLabel();
        rSButtonRiple22 = new rojeru_san.RSButtonRiple();

        jFrame1.setMinimumSize(new java.awt.Dimension(312, 173));
        jFrame1.setUndecorated(true);
        jFrame1.getContentPane().setLayout(new java.awt.CardLayout());

        rSButtonRiple5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple5.setText("Aceptar");
        rSButtonRiple5.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSButtonRiple5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple5MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Operación exitosa.");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exito.png"))); // NOI18N

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(rSButtonRiple5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(33, 33, 33))
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound2Layout.createSequentialGroup()
                .addGroup(jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanelRound2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(rSButtonRiple5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jFrame1.getContentPane().add(jPanelRound2, "card3");

        setOpaque(false);

        cambiomenu.setName("cambiomenu"); // NOI18N
        cambiomenu.setOpaque(false);

        cambio_socio.setBackground(new java.awt.Color(255, 255, 255));
        cambio_socio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-azul.png"))); // NOI18N
        cambio_socio.setText("Socio");
        cambio_socio.setColorHover(new java.awt.Color(255, 255, 255));
        cambio_socio.setColorText(new java.awt.Color(0, 30, 100));
        cambio_socio.setColorTextHover(new java.awt.Color(0, 30, 100));
        cambio_socio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cambio_socio.setIconTextGap(20);
        cambio_socio.setNextFocusableComponent(cambio_cliente);
        cambio_socio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cambio_socio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambio_socioMouseClicked(evt);
            }
        });

        cambio_cliente.setBackground(new java.awt.Color(0, 30, 100));
        cambio_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        cambio_cliente.setText("Cliente");
        cambio_cliente.setColorHover(new java.awt.Color(204, 204, 255));
        cambio_cliente.setColorTextHover(new java.awt.Color(0, 30, 100));
        cambio_cliente.setFocusable(false);
        cambio_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cambio_cliente.setIconTextGap(20);
        cambio_cliente.setNextFocusableComponent(cambio_colaborador);
        cambio_cliente.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cambio_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambio_clienteMouseClicked(evt);
            }
        });

        cambio_colaborador.setBackground(new java.awt.Color(0, 30, 100));
        cambio_colaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        cambio_colaborador.setText("Colaborador");
        cambio_colaborador.setColorHover(new java.awt.Color(204, 204, 255));
        cambio_colaborador.setColorTextHover(new java.awt.Color(0, 30, 100));
        cambio_colaborador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cambio_colaborador.setIconTextGap(20);
        cambio_colaborador.setNextFocusableComponent(cambio_socio);
        cambio_colaborador.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cambio_colaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambio_colaboradorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneldelreporte1Layout = new javax.swing.GroupLayout(paneldelreporte1);
        paneldelreporte1.setLayout(paneldelreporte1Layout);
        paneldelreporte1Layout.setHorizontalGroup(
            paneldelreporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambio_socio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(cambio_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(cambio_colaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        paneldelreporte1Layout.setVerticalGroup(
            paneldelreporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldelreporte1Layout.createSequentialGroup()
                .addComponent(cambio_socio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cambio_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cambio_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        slidercambio.setOpaque(false);

        socio2.setName("socio2"); // NOI18N
        socio2.setOpaque(false);

        jLabel85.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("¡Corrige los datos de nuestro ");
        jLabel85.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel85.setFocusable(false);
        jLabel85.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel85.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel86.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("socio! ");
        jLabel86.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel86.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel86.setFocusable(false);
        jLabel86.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel86.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel68.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 51, 51));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Para evitar errores, busca al socio en la ");
        jLabel68.setFocusable(false);
        jLabel68.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel69.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 51, 51));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("tabla de junto y selecciona a quien ");
        jLabel69.setFocusable(false);
        jLabel69.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel70.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(51, 51, 51));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("desees modificar.");
        jLabel70.setFocusable(false);
        jLabel70.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        nombrejefecambio.setForeground(new java.awt.Color(0, 0, 0));
        nombrejefecambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nombrejefecambio.setBotonColor(new java.awt.Color(0, 0, 0));
        nombrejefecambio.setColorTransparente(true);
        nombrejefecambio.setNextFocusableComponent(apjefecambio);
        nombrejefecambio.setPlaceholder("Nombre(s)");

        apjefecambio.setForeground(new java.awt.Color(0, 0, 0));
        apjefecambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        apjefecambio.setBotonColor(new java.awt.Color(0, 0, 0));
        apjefecambio.setColorTransparente(true);
        apjefecambio.setNextFocusableComponent(amjefecambio);
        apjefecambio.setPlaceholder("Apellido paterno");

        amjefecambio.setForeground(new java.awt.Color(0, 0, 0));
        amjefecambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        amjefecambio.setBotonColor(new java.awt.Color(0, 0, 0));
        amjefecambio.setColorTransparente(true);
        amjefecambio.setNextFocusableComponent(cambiobuscarjefe);
        amjefecambio.setPlaceholder("Apellido materno");

        cambiar.setBackground(new java.awt.Color(255, 255, 255));
        cambiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cambiar.setForeground(new java.awt.Color(0, 0, 0));
        cambiar.setText("Cambiar");
        cambiar.setColorHover(new java.awt.Color(204, 204, 204));
        cambiar.setColorText(new java.awt.Color(0, 0, 0));
        cambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarMouseClicked(evt);
            }
        });

        errorjefecambio.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorjefecambio.setForeground(new java.awt.Color(255, 0, 0));
        errorjefecambio.setText("¡Faltan campos por llenar!");
        errorjefecambio.setFocusable(false);

        javax.swing.GroupLayout jPanelRound15Layout = new javax.swing.GroupLayout(jPanelRound15);
        jPanelRound15.setLayout(jPanelRound15Layout);
        jPanelRound15Layout.setHorizontalGroup(
            jPanelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(jLabel85)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70)
                    .addGroup(jPanelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nombrejefecambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addComponent(amjefecambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(apjefecambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRound15Layout.createSequentialGroup()
                        .addComponent(cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorjefecambio)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelRound15Layout.setVerticalGroup(
            jPanelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel70)
                .addGap(18, 18, 18)
                .addComponent(nombrejefecambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(apjefecambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(amjefecambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorjefecambio)
                    .addComponent(cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        cambiotablajefe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido paterno", "Apellido materno"
            }
        ));
        cambiotablajefe.setCellSelectionEnabled(true);
        cambiotablajefe.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        cambiotablajefe.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        cambiotablajefe.setColorBordeHead(new java.awt.Color(214, 214, 214));
        cambiotablajefe.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        cambiotablajefe.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        cambiotablajefe.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        cambiotablajefe.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        cambiotablajefe.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiotablajefe.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiotablajefe.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        cambiotablajefe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiotablajefeMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(cambiotablajefe);

        cambiobuscarjefe.setForeground(new java.awt.Color(255, 255, 255));
        cambiobuscarjefe.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        cambiobuscarjefe.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        cambiobuscarjefe.setBotonColor(new java.awt.Color(0, 0, 0));
        cambiobuscarjefe.setCaretColor(new java.awt.Color(255, 255, 255));
        cambiobuscarjefe.setColorTransparente(true);
        cambiobuscarjefe.setModoMaterial(true);
        cambiobuscarjefe.setNextFocusableComponent(cambiar);
        cambiobuscarjefe.setPlaceholder("Buscar socio...");
        cambiobuscarjefe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cambiobuscarjefeKeyReleased(evt);
            }
        });

        rSButton13.setBackground(new java.awt.Color(255, 255, 255));
        rSButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton13.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton13.setFocusable(false);
        rSButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addComponent(cambiobuscarjefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cambiobuscarjefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout socio2Layout = new javax.swing.GroupLayout(socio2);
        socio2.setLayout(socio2Layout);
        socio2Layout.setHorizontalGroup(
            socio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(socio2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        socio2Layout.setVerticalGroup(
            socio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        slidercambio.add(socio2, "card2");

        cliente2.setName("cliente2"); // NOI18N
        cliente2.setOpaque(false);

        jLabel71.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("¡Corrige los datos de nuestro ");
        jLabel71.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel71.setFocusable(false);
        jLabel71.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel71.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel72.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("cliente! ");
        jLabel72.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel72.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel72.setFocusable(false);
        jLabel72.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel72.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel73.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(51, 51, 51));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Para evitar errores, busca el id del grupo ");
        jLabel73.setFocusable(false);
        jLabel73.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel74.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(51, 51, 51));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("correspondiente en la tabla de junto y da clic");
        jLabel74.setFocusable(false);
        jLabel74.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel75.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(51, 51, 51));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("cuando lo hayas encontrado. Si el cliente no");
        jLabel75.setFocusable(false);
        jLabel75.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel76.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(51, 51, 51));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("tiene grupo selecciona \"Sin grupo\" en la tabla.");
        jLabel76.setFocusable(false);
        jLabel76.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        nomEmpresa9.setForeground(new java.awt.Color(0, 0, 0));
        nomEmpresa9.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa9.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa9.setColorTransparente(true);
        nomEmpresa9.setFocusable(false);
        nomEmpresa9.setPlaceholder("Cliente");

        nomEmpresa10.setForeground(new java.awt.Color(0, 0, 0));
        nomEmpresa10.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa10.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa10.setColorTransparente(true);
        nomEmpresa10.setFocusable(false);
        nomEmpresa10.setPlaceholder("RFC");

        nomEmpresa12.setEditable(false);
        nomEmpresa12.setForeground(new java.awt.Color(0, 0, 0));
        nomEmpresa12.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa12.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa12.setColorTransparente(true);
        nomEmpresa12.setFocusable(false);
        nomEmpresa12.setPlaceholder("IdGrupo");
        nomEmpresa12.setEditable(false);

        rSButtonRiple23.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple23.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple23.setText("Cambiar");
        rSButtonRiple23.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple23.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple23MouseClicked(evt);
            }
        });

        errorempresacambio.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorempresacambio.setForeground(new java.awt.Color(255, 0, 0));
        errorempresacambio.setText("¡Faltan campos por llenar!");
        errorempresacambio.setFocusable(false);

        javax.swing.GroupLayout jPanelRound16Layout = new javax.swing.GroupLayout(jPanelRound16);
        jPanelRound16.setLayout(jPanelRound16Layout);
        jPanelRound16Layout.setHorizontalGroup(
            jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(jLabel74)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)))
                    .addGroup(jPanelRound16Layout.createSequentialGroup()
                        .addGroup(jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nomEmpresa10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomEmpresa9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                .addComponent(nomEmpresa12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanelRound16Layout.createSequentialGroup()
                                .addComponent(rSButtonRiple23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorempresacambio)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRound16Layout.setVerticalGroup(
            jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71)
                .addGap(7, 7, 7)
                .addGroup(jPanelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRound16Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76)
                        .addGap(18, 18, 18)
                        .addComponent(nomEmpresa9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomEmpresa10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomEmpresa12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rSButtonRiple23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorempresacambio))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        rSButton16.setBackground(new java.awt.Color(255, 255, 255));
        rSButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton16.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton16.setFocusable(false);
        rSButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton16MouseClicked(evt);
            }
        });

        cambiobuscarempresa.setForeground(new java.awt.Color(255, 255, 255));
        cambiobuscarempresa.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        cambiobuscarempresa.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        cambiobuscarempresa.setBotonColor(new java.awt.Color(0, 0, 0));
        cambiobuscarempresa.setCaretColor(new java.awt.Color(255, 255, 255));
        cambiobuscarempresa.setColorTransparente(true);
        cambiobuscarempresa.setModoMaterial(true);
        cambiobuscarempresa.setNextFocusableComponent(nomEmpresa8);
        cambiobuscarempresa.setPlaceholder("Buscar cliente...");
        cambiobuscarempresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cambiobuscarempresaKeyReleased(evt);
            }
        });

        cambiotablaempresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdCliente", "Nombre", "Ingreso", "RFC", "IdGrupo"
            }
        ));
        cambiotablaempresa.setCellSelectionEnabled(true);
        cambiotablaempresa.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        cambiotablaempresa.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        cambiotablaempresa.setColorBordeHead(new java.awt.Color(214, 214, 214));
        cambiotablaempresa.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        cambiotablaempresa.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        cambiotablaempresa.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        cambiotablaempresa.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        cambiotablaempresa.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiotablaempresa.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiotablaempresa.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        cambiotablaempresa.setMinimumSize(new java.awt.Dimension(0, 0));
        cambiotablaempresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiotablaempresaMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(cambiotablaempresa);

        nomEmpresa8.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        nomEmpresa8.setForeground(new java.awt.Color(255, 255, 255));
        nomEmpresa8.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        nomEmpresa8.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa8.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa8.setCaretColor(new java.awt.Color(255, 255, 255));
        nomEmpresa8.setColorTransparente(true);
        nomEmpresa8.setModoMaterial(true);
        nomEmpresa8.setNextFocusableComponent(rSButtonRiple23);
        nomEmpresa8.setPlaceholder("Buscar grupo...");
        nomEmpresa8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomEmpresa8KeyReleased(evt);
            }
        });

        rSButton15.setBackground(new java.awt.Color(255, 255, 255));
        rSButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton15.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton15.setFocusable(false);
        rSButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton15MouseClicked(evt);
            }
        });

        cambiogrupocliente.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        cambiogrupocliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"5", "Sin grupo"},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdGrupo", "Grupo"
            }
        ));
        cambiogrupocliente.setCellSelectionEnabled(true);
        cambiogrupocliente.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        cambiogrupocliente.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        cambiogrupocliente.setColorBordeHead(new java.awt.Color(214, 214, 214));
        cambiogrupocliente.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        cambiogrupocliente.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        cambiogrupocliente.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        cambiogrupocliente.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        cambiogrupocliente.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiogrupocliente.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiogrupocliente.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        cambiogrupocliente.setMinimumSize(new java.awt.Dimension(0, 0));
        cambiogrupocliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiogrupoclienteMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(cambiogrupocliente);
        jScrollPane13.getVerticalScrollBar().setUI(new RSScrollBar());

        javax.swing.GroupLayout jPanelRound19Layout = new javax.swing.GroupLayout(jPanelRound19);
        jPanelRound19.setLayout(jPanelRound19Layout);
        jPanelRound19Layout.setHorizontalGroup(
            jPanelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(jPanelRound19Layout.createSequentialGroup()
                        .addGroup(jPanelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound19Layout.createSequentialGroup()
                                .addComponent(cambiobuscarempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRound19Layout.createSequentialGroup()
                                .addComponent(nomEmpresa8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane13))
                .addContainerGap())
        );
        jPanelRound19Layout.setVerticalGroup(
            jPanelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cambiobuscarempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomEmpresa8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout cliente2Layout = new javax.swing.GroupLayout(cliente2);
        cliente2.setLayout(cliente2Layout);
        cliente2Layout.setHorizontalGroup(
            cliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cliente2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        cliente2Layout.setVerticalGroup(
            cliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        slidercambio.add(cliente2, "card3");

        colaborador2.setName("colaborador2"); // NOI18N
        colaborador2.setOpaque(false);

        jPanelRound17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelRound17MouseMoved(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("¡Corrige los datos de nuestro ");
        jLabel90.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel90.setFocusable(false);
        jLabel90.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel90.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel94.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("colaborador! ");
        jLabel94.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel94.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel94.setFocusable(false);
        jLabel94.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel94.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel91.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(51, 51, 51));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Para evitar errores, busca el id del socio ");
        jLabel91.setFocusable(false);
        jLabel91.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel92.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(51, 51, 51));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("correspondiente en caja de opciones de abajo  ");
        jLabel92.setFocusable(false);
        jLabel92.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel93.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(51, 51, 51));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("y da clic cuando lo hayas encontrado.");
        jLabel93.setFocusable(false);
        jLabel93.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        nombreempleadocambio.setForeground(new java.awt.Color(0, 0, 0));
        nombreempleadocambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nombreempleadocambio.setBotonColor(new java.awt.Color(0, 0, 0));
        nombreempleadocambio.setColorTransparente(true);
        nombreempleadocambio.setNextFocusableComponent(apempleadocambio);
        nombreempleadocambio.setPlaceholder("Nombre(s)");

        apempleadocambio.setForeground(new java.awt.Color(0, 0, 0));
        apempleadocambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        apempleadocambio.setBotonColor(new java.awt.Color(0, 0, 0));
        apempleadocambio.setColorTransparente(true);
        apempleadocambio.setNextFocusableComponent(amempleadocambio);
        apempleadocambio.setPlaceholder("Apellido paterno");

        amempleadocambio.setForeground(new java.awt.Color(0, 0, 0));
        amempleadocambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        amempleadocambio.setBotonColor(new java.awt.Color(0, 0, 0));
        amempleadocambio.setColorTransparente(true);
        amempleadocambio.setNextFocusableComponent(cambiobuscarempleado);
        amempleadocambio.setPlaceholder("Apellido materno");

        idjefeempleadocambio.setEditable(false);
        idjefeempleadocambio.setForeground(new java.awt.Color(0, 0, 0));
        idjefeempleadocambio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        idjefeempleadocambio.setBotonColor(new java.awt.Color(0, 0, 0));
        idjefeempleadocambio.setColorTransparente(true);
        idjefeempleadocambio.setFocusable(false);
        idjefeempleadocambio.setPlaceholder("IdSocio");
        idjefeempleadocambio.setEditable(false);

        Puesto3.setFont(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        Puesto3.setForeground(new java.awt.Color(255, 255, 255));
        Puesto3.setText("Puesto");
        Puesto3.setFocusable(false);

        puesto1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", "Gerente", "Supervisor", "Encargado", "Ayudante" }));
        puesto1.setColorArrow(new java.awt.Color(0, 30, 100));
        puesto1.setColorBorde(new java.awt.Color(0, 30, 100));
        puesto1.setColorFondo(new java.awt.Color(0, 30, 100));

        nivel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", "A", "B", "C" }));
        nivel1.setColorArrow(new java.awt.Color(0, 30, 100));
        nivel1.setColorBorde(new java.awt.Color(0, 30, 100));
        nivel1.setColorFondo(new java.awt.Color(0, 30, 100));

        Puesto2.setFont(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        Puesto2.setForeground(new java.awt.Color(255, 255, 255));
        Puesto2.setText("Horario");
        Puesto2.setFocusable(false);

        horario1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", "Tiempo Completo", "Medio Tiempo" }));
        horario1.setColorArrow(new java.awt.Color(0, 30, 100));
        horario1.setColorBorde(new java.awt.Color(0, 30, 100));
        horario1.setColorFondo(new java.awt.Color(0, 30, 100));

        fechainiciotexto8.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        fechainiciotexto8.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto8.setText("Socio:");
        fechainiciotexto8.setFocusable(false);

        cambiomodelsocio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", " " }));
        cambiomodelsocio1.setColorArrow(new java.awt.Color(0, 30, 100));
        cambiomodelsocio1.setColorBorde(new java.awt.Color(0, 30, 100));
        cambiomodelsocio1.setColorFondo(new java.awt.Color(0, 30, 100));
        cambiomodelsocio1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambiomodelsocio1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound17Layout = new javax.swing.GroupLayout(jPanelRound17);
        jPanelRound17.setLayout(jPanelRound17Layout);
        jPanelRound17Layout.setHorizontalGroup(
            jPanelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel91)
                        .addComponent(jLabel92)
                        .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel94)
                        .addComponent(jLabel93)
                        .addComponent(nombreempleadocambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(apempleadocambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amempleadocambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idjefeempleadocambio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Puesto3)
                    .addGroup(jPanelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Puesto2)
                        .addComponent(fechainiciotexto8)
                        .addComponent(horario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelRound17Layout.createSequentialGroup()
                            .addComponent(puesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cambiomodelsocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRound17Layout.setVerticalGroup(
            jPanelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound17Layout.createSequentialGroup()
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel94)
                .addGap(17, 17, 17)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreempleadocambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apempleadocambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(amempleadocambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idjefeempleadocambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Puesto3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(Puesto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechainiciotexto8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cambiomodelsocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        cambiotablaempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido paterno", "Apellido materno", "IdSocio", "Socio", "Ingreso"
            }
        ));
        cambiotablaempleado.setCellSelectionEnabled(true);
        cambiotablaempleado.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        cambiotablaempleado.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        cambiotablaempleado.setColorBordeHead(new java.awt.Color(214, 214, 214));
        cambiotablaempleado.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        cambiotablaempleado.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        cambiotablaempleado.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        cambiotablaempleado.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        cambiotablaempleado.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiotablaempleado.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        cambiotablaempleado.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        cambiotablaempleado.setMinimumSize(new java.awt.Dimension(75, 100));
        cambiotablaempleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiotablaempleadoMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(cambiotablaempleado);

        cambiobuscarempleado.setForeground(new java.awt.Color(255, 255, 255));
        cambiobuscarempleado.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        cambiobuscarempleado.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        cambiobuscarempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        cambiobuscarempleado.setCaretColor(new java.awt.Color(255, 255, 255));
        cambiobuscarempleado.setColorTransparente(true);
        cambiobuscarempleado.setModoMaterial(true);
        cambiobuscarempleado.setNextFocusableComponent(rSButtonRiple22);
        cambiobuscarempleado.setPlaceholder("Buscar colaborador...");
        cambiobuscarempleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cambiobuscarempleadoKeyReleased(evt);
            }
        });

        rSButton17.setBackground(new java.awt.Color(255, 255, 255));
        rSButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton17.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton17.setFocusable(false);
        rSButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton17MouseClicked(evt);
            }
        });

        errorempleadocambio.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorempleadocambio.setForeground(new java.awt.Color(255, 0, 0));
        errorempleadocambio.setText("¡Faltan campos por llenar!");
        errorempleadocambio.setFocusable(false);

        rSButtonRiple22.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple22.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple22.setText("Cambiar");
        rSButtonRiple22.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple22.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound3Layout = new javax.swing.GroupLayout(jPanelRound3);
        jPanelRound3.setLayout(jPanelRound3Layout);
        jPanelRound3Layout.setHorizontalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound3Layout.createSequentialGroup()
                        .addComponent(cambiobuscarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRound3Layout.createSequentialGroup()
                        .addComponent(rSButtonRiple22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorempleadocambio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRound3Layout.setVerticalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cambiobuscarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonRiple22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorempleadocambio))
                .addContainerGap())
        );

        javax.swing.GroupLayout colaborador2Layout = new javax.swing.GroupLayout(colaborador2);
        colaborador2.setLayout(colaborador2Layout);
        colaborador2Layout.setHorizontalGroup(
            colaborador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colaborador2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        colaborador2Layout.setVerticalGroup(
            colaborador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        slidercambio.add(colaborador2, "card4");

        javax.swing.GroupLayout cambiomenuLayout = new javax.swing.GroupLayout(cambiomenu);
        cambiomenu.setLayout(cambiomenuLayout);
        cambiomenuLayout.setHorizontalGroup(
            cambiomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambiomenuLayout.createSequentialGroup()
                .addComponent(paneldelreporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(slidercambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cambiomenuLayout.setVerticalGroup(
            cambiomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneldelreporte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cambiomenuLayout.createSequentialGroup()
                .addComponent(slidercambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cambiomenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cambiomenu, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cambio_socioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambio_socioMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {cambio_cliente,cambio_colaborador};
        cambiarcolorreporte(cambio_socio,menu);
        slidercambio.setPanelSlider(20, socio2, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_cambio_socioMouseClicked

    private void cambio_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambio_clienteMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {cambio_socio,cambio_colaborador};
        cambiarcolorreporte(cambio_cliente,menu);
        slidercambio.setPanelSlider(20, cliente2, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_cambio_clienteMouseClicked

    private void cambio_colaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambio_colaboradorMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {cambio_cliente,cambio_socio};
        cambiarcolorreporte(cambio_colaborador,menu);
        slidercambio.setPanelSlider(20, colaborador2, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_cambio_colaboradorMouseClicked

    private void cambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarMouseClicked
        // TODO add your handling code here:
        if(!nombrejefecambio.getText().equals("") && !apjefecambio.getText().equals("") && !amjefecambio.getText().equals("")
        ){
            RSMTextFull array[]={nombrejefecambio,apjefecambio,amjefecambio,cambiobuscarjefe};
            try {
                int mj= JOptionPane.OK_OPTION;
                int message= JOptionPane.showConfirmDialog(this,"¿Sus datos son correctos?","", mj);
                if(message==0){
                    dentro.cambiojefe(nombrejefecambio.getText(), apjefecambio.getText(), amjefecambio.getText(), cambiotablajefe.getValueAt
                        (cambiotablajefe.getSelectedRow(), 0).toString(),usuario);
                    limpiadorcajatexto(array);
                    cambiotablajefe.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null, null}
                        },
                        new String [] {
                            "Id", "Nombre", "Apellido paterno", "Apellido materno"
                        }
                    ));
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                }

            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            errorjefecambio.setVisible(true);
        }
    }//GEN-LAST:event_cambiarMouseClicked

    private void cambiobuscarjefeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambiobuscarjefeKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            cambiotablajefe.setModel(dentro.buscarjefetabla(cambiobuscarjefe.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cambiobuscarjefeKeyReleased

    private void rSButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton13MouseClicked
        // TODO add your handling code here:
        cambiobuscarjefe.requestFocus();
    }//GEN-LAST:event_rSButton13MouseClicked

    private void cambiotablajefeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiotablajefeMouseClicked
        // TODO add your handling code here:
        nombrejefecambio.setText(cambiotablajefe.getValueAt(cambiotablajefe.getSelectedRow(), 1).toString());
        apjefecambio.setText(cambiotablajefe.getValueAt(cambiotablajefe.getSelectedRow(), 2).toString());
        amjefecambio.setText(cambiotablajefe.getValueAt(cambiotablajefe.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_cambiotablajefeMouseClicked

    private void rSButtonRiple23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple23MouseClicked
        // TODO add your handling code here:
        if(!nomEmpresa9.getText().equals("") &&!nomEmpresa10.getText().equals("")
            &&!nomEmpresa12.getText().equals("")){
            int mj= JOptionPane.YES_NO_OPTION;
            int message= JOptionPane.showConfirmDialog(this, "¿Sus datos son correctos?", "", mj);
            if(message==0){
                try {
                    dentro.cambioempresa(verificarnombre(nomEmpresa9.getText()),nomEmpresa10.getText(),nomEmpresa12.getText(),
                        cambiotablaempresa.getValueAt(cambiotablaempresa.getSelectedRow(), 0).toString(),usuario);
                    cambiotablaempresa.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null, null, null, null}
                        },
                        new String [] {
                            "IdCliente", "Nombre", "Ingreso", "RFC", "IdGrupo", "IdSocio"
                        }
                    ));
                    cambiogrupocliente.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {"Sin grupo", "4"},
                            {null, null}
                        },
                        new String [] {
                            "IdGrupo" ,"Grupo"
                        }
                    ));
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                    nomEmpresa8.setText("");
                    nomEmpresa9.setText("");
                    nomEmpresa10.setText("");
                    nomEmpresa12.setText("");
                    errorempresacambio.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            errorempresacambio.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple23MouseClicked

    private void rSButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton16MouseClicked
        // TODO add your handling code here:
        cambiobuscarempresa.requestFocus();
    }//GEN-LAST:event_rSButton16MouseClicked

    private void cambiobuscarempresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambiobuscarempresaKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            cambiotablaempresa.setModel(dentro.buscarempresatabla1(cambiobuscarempresa.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cambiobuscarempresaKeyReleased

    private void cambiotablaempresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiotablaempresaMouseClicked
        nomEmpresa9.setText(cambiotablaempresa.getValueAt(cambiotablaempresa.getSelectedRow(), 1).toString());
        nomEmpresa10.setText(cambiotablaempresa.getValueAt(cambiotablaempresa.getSelectedRow(), 3).toString());
        nomEmpresa12.setText(cambiotablaempresa.getValueAt(cambiotablaempresa.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_cambiotablaempresaMouseClicked

    private void nomEmpresa8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomEmpresa8KeyReleased
        try {
            // TODO add your handling code here:
            cambiogrupocliente.setModel(dentro.buscargrupotabla(nomEmpresa8.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nomEmpresa8KeyReleased

    private void rSButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton15MouseClicked
        // TODO add your handling code here:
        nomEmpresa8.requestFocus();
    }//GEN-LAST:event_rSButton15MouseClicked

    private void cambiogrupoclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiogrupoclienteMouseClicked
        // TODO add your handling code here:
        nomEmpresa12.setText(cambiogrupocliente.getValueAt(cambiogrupocliente.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_cambiogrupoclienteMouseClicked

    private void cambiomodelsocio1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambiomodelsocio1ItemStateChanged
        // TODO add your handling code here:
        String [] id= cambiomodelsocio1.getSelectedItem().toString().split(" ");
        idjefeempleadocambio.setText(id[id.length-1]);
    }//GEN-LAST:event_cambiomodelsocio1ItemStateChanged

    private void jPanelRound17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRound17MouseMoved
        // TODO add your handling code here:
        if(!idjefeempleadocambio.getText().equals("")){
            try {
                cambiomodelsocio1.setModel(dentro.obtenersocios());
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jPanelRound17MouseMoved

    private void cambiotablaempleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiotablaempleadoMouseClicked
        // TODO add your handling code here:
        nombreempleadocambio.setText(cambiotablaempleado.getValueAt(cambiotablaempleado.getSelectedRow(), 1).toString());
        apempleadocambio.setText(cambiotablaempleado.getValueAt(cambiotablaempleado.getSelectedRow(), 2).toString());
        amempleadocambio.setText(cambiotablaempleado.getValueAt(cambiotablaempleado.getSelectedRow(), 3).toString());
        idjefeempleadocambio.setText(cambiotablaempleado.getValueAt(cambiotablaempleado.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_cambiotablaempleadoMouseClicked

    private void cambiobuscarempleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambiobuscarempleadoKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            cambiotablaempleado.setModel(dentro.buscarempleadotabla1(cambiobuscarempleado.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cambiobuscarempleadoKeyReleased

    private void rSButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton17MouseClicked
        // TODO add your handling code here
        cambiobuscarempleado.requestFocus();
    }//GEN-LAST:event_rSButton17MouseClicked

    private void rSButtonRiple22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple22MouseClicked
        // TODO add your handling code here:
        if(!nombreempleadocambio.getText().equals("") && !apempleadocambio.getText().equals("")
            &&!amempleadocambio.getText().equals("") &&!idjefeempleadocambio.getText().equals("")
            && horario1.getSelectedIndex()>0){

            if(puesto1.getSelectedIndex()>1 && nivel1.getSelectedIndex()>0){
                int mj= JOptionPane.YES_NO_OPTION;
                int message= JOptionPane.showConfirmDialog(this, "¿Sus datos son correctos?", "", mj);
                if(message==0){
                    try {
                        dentro.cambioempleado(nombreempleadocambio.getText(),
                            apempleadocambio.getText(),
                            amempleadocambio.getText(),
                            idjefeempleadocambio.getText(),
                            cambiotablaempleado.getValueAt(cambiotablaempleado.getSelectedRow(),0).toString(),
                            horario1.getSelectedItem().toString(), puesto1.getSelectedItem().toString()+" "+nivel1.getSelectedItem().toString(),
                            usuario);
                        cambiotablaempleado.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {
                                {null, null, null, null, null}
                            },
                            new String [] {
                                "Id", "Nombre", "Apellido paterno", "Apellido materno", "IdSocio"
                            }
                        ));
                        nombreempleadocambio.setText("");
                        apempleadocambio.setText("");
                        amempleadocambio.setText("");
                        idjefeempleadocambio.setText("");
                        cambiobuscarempleado.setText("");
                        errorempleadocambio.setVisible(false);
                        puesto1.setSelectedIndex(0);
                        nivel1.setSelectedIndex(0);
                        horario1.setSelectedIndex(0);
                        jFrame1.setVisible(true);
                        jFrame1.setBackground(transparente);

                    } catch (SQLException ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else if(puesto1.getSelectedIndex()==1){
                int mj= JOptionPane.YES_NO_OPTION;
                int message= JOptionPane.showConfirmDialog(this, "¿Sus datos son correctos?", "", mj);
                if(message==0){
                    try {
                        dentro.cambioempleado(nombreempleadocambio.getText(),
                            apempleadocambio.getText(),
                            amempleadocambio.getText(),
                            idjefeempleadocambio.getText(),
                            cambiotablaempleado.getValueAt(cambiotablaempleado.getSelectedRow(),0).toString(),
                            horario1.getSelectedItem().toString(), puesto1.getSelectedItem().toString(),
                            usuario);
                        cambiotablaempleado.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {
                                {null, null, null, null, null}
                            },
                            new String [] {
                                "Id", "Nombre", "Apellido paterno", "Apellido materno", "IdSocio"
                            }
                        ));
                        nombreempleadocambio.setText("");
                        apempleadocambio.setText("");
                        amempleadocambio.setText("");
                        idjefeempleadocambio.setText("");
                        cambiobuscarempleado.setText("");
                        errorempleadocambio.setVisible(false);
                        puesto1.setSelectedIndex(0);
                        nivel1.setSelectedIndex(0);
                        horario1.setSelectedIndex(0);
                        jFrame1.setVisible(true);
                        jFrame1.setBackground(transparente);

                    } catch (SQLException ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else{
                errorempleadocambio.setVisible(true);
            }
        }else{
            errorempleadocambio.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple22MouseClicked

    private void rSButtonRiple5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple5MouseClicked
        jFrame1.dispose();
        jFrame1.setVisible(false);
    }//GEN-LAST:event_rSButtonRiple5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Puesto2;
    private javax.swing.JLabel Puesto3;
    private rojeru_san.RSMTextFull amempleadocambio;
    private rojeru_san.RSMTextFull amjefecambio;
    private rojeru_san.RSMTextFull apempleadocambio;
    private rojeru_san.RSMTextFull apjefecambio;
    private rojeru_san.RSButtonRiple cambiar;
    private rojeru_san.RSButton cambio_cliente;
    private rojeru_san.RSButton cambio_colaborador;
    private rojeru_san.RSButton cambio_socio;
    private rojeru_san.RSMTextFull cambiobuscarempleado;
    private rojeru_san.RSMTextFull cambiobuscarempresa;
    private rojeru_san.RSMTextFull cambiobuscarjefe;
    private rojerusan.RSTableMetro cambiogrupocliente;
    private javax.swing.JPanel cambiomenu;
    private rojerusan.RSComboMetro cambiomodelsocio1;
    private rojerusan.RSTableMetro cambiotablaempleado;
    private rojerusan.RSTableMetro cambiotablaempresa;
    private rojerusan.RSTableMetro cambiotablajefe;
    private javax.swing.JPanel cliente2;
    private javax.swing.JPanel colaborador2;
    private javax.swing.JLabel errorempleadocambio;
    private javax.swing.JLabel errorempresacambio;
    private javax.swing.JLabel errorjefecambio;
    private javax.swing.JLabel fechainiciotexto8;
    private rojerusan.RSComboMetro horario1;
    private rojeru_san.RSMTextFull idjefeempleadocambio;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private zesatic.JPanelRound jPanelRound1;
    private zesatic.JPanelRound jPanelRound15;
    private zesatic.JPanelRound jPanelRound16;
    private zesatic.JPanelRound jPanelRound17;
    private zesatic.JPanelRound jPanelRound19;
    private zesatic.JPanelRound jPanelRound2;
    private zesatic.JPanelRound jPanelRound3;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private rojerusan.RSComboMetro nivel1;
    private rojeru_san.RSMTextFull nomEmpresa10;
    private rojeru_san.RSMTextFull nomEmpresa12;
    private rojeru_san.RSMTextFull nomEmpresa8;
    private rojeru_san.RSMTextFull nomEmpresa9;
    private rojeru_san.RSMTextFull nombreempleadocambio;
    private rojeru_san.RSMTextFull nombrejefecambio;
    private javax.swing.JPanel paneldelreporte1;
    private rojerusan.RSComboMetro puesto1;
    private rojeru_san.RSButton rSButton13;
    private rojeru_san.RSButton rSButton15;
    private rojeru_san.RSButton rSButton16;
    private rojeru_san.RSButton rSButton17;
    private rojeru_san.RSButtonRiple rSButtonRiple22;
    private rojeru_san.RSButtonRiple rSButtonRiple23;
    private rojeru_san.RSButtonRiple rSButtonRiple5;
    private rojeru_san.RSPanelsSlider slidercambio;
    private javax.swing.JPanel socio2;
    // End of variables declaration//GEN-END:variables
}
