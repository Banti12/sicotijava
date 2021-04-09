/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zesatic;

/**
 *
 * @author Brayan
 */

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Charlie
 */
public class conectar {
        Connection conect = null;
        Statement st;
        DefaultTableModel uno;
        DefaultTableModel dos;
        String insertar;
        String borrar;
        String cambiar;
        String archivo;
        Date date;
        SimpleDateFormat d;
	public conectar()
		{
			try {
				//Cargamos el Driver MySQL
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("org.gjt.mm.mysql.Driver");
				conect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/zesati","root","");
				//System.out.println("conexion establecida ");
				//JOptionPane.showMessageDialog(null,"Conectado");
                                
				//Cargamos el Driver Access
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//Conectar en red base
				//String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb)";DBQ=//servidor/bd_cw/cw.mdb";
				//Conectar Localmente
				//String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb)";DBQ=:/cwnetbeans/cw.mdb";
				//conect = DriverManager.getConnection(strConect,"","");
                                st=(Statement) 
                                conect.createStatement();
                                insertar="Dio de alta: ";
                                cambiar="Cambió: ";
                                archivo="Subió el archivo: ";
                                borrar="Dio de baja: ";
                                date= new Date();
                                d = new SimpleDateFormat("yyyy-MM-dd");
                                //System.out.println("Conexion establecida");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("error de conexion");
				JOptionPane.showMessageDialog(null,"Error de conexion"+e);
			}
		}
                    public void remove(){
                        insertar="Dio de alta: ";
                        cambiar="Cambió: ";
                        archivo="Subió el archivo: ";
                        borrar="Borró: ";
                    }
        
               public void desconectar(){
                    try{
                            conect.close();
                    }catch(Exception ex){}
                    
                }
               public boolean search(String nombre) throws SQLException{
		ResultSet resultado;
		boolean resp=true;
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre"
					+" from usuario"
					+" where nombre is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals(""))
				query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";

			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        if(resultado.getRow()==0){
                            resp=true;
                        }else{                          
                                resp=false;       
                            }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
            
            return resp;
                
	}
               public String regresarpregunta(String nombre) throws SQLException{
		ResultSet resultado;
                String pregunta="";
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select pregunta"
					+" from usuario"
					+" where nombre is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals(""))
                                query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";

			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        pregunta = resultado.getObject(1).toString();           
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
            
            return pregunta;
                
	}
            public DefaultTableModel buscarjefetablavista(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Iniciales");
                uno.addColumn("Nombre");
                uno.addColumn("Activo");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idjefe,iniciales,nombre,ap,am,activo"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros

				query+= " and nombre like '%"+nombre+"%'";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Iniciales");
                        uno.addColumn("Nombre");
                        uno.addColumn("Activo");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                if(i==2){
                                    filas[i]=resultado.getObject(i+1)+" "+resultado.getObject(i+2)+" "+resultado.getObject(i+3);
                                    filas[i+1]= resultado.getObject(i+4);
                                    i++;        
                                }else{
                                    filas[i]= resultado.getObject(i+1);
                                }
                                
                            if(resultado.getObject(6).equals(true))
                            {
                                filas[3]="Si";
                            }else
                            {
                                filas[3]="No";
                            }
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
               public boolean revisarcontrahash(String nombre, String contraseña) throws SQLException{
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select respuesta"
					+" from usuario"
					+" where nombre is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals(""))
				query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";

			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        if(resultado.getRow()==0){
                            resp=false;
                        }else{
                                if(resultado.getObject(1).toString().equals(contraseña))
                                resp=true;
             
                            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
            
            return resp;
                
	}
               public boolean entrar(String nombre, String contraseña) throws SQLException{
		ResultSet resultado;
		boolean resp=true;
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre,contraseña"
					+" from usuario"
					+" where nombre is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals("")){
				query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";
                                query+= " and contraseña COLLATE utf8_bin = '"+contraseña+"'";
                        }else 
                        {
                            resp= false;
                        }

			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        if(resultado.getRow()==0){
                            resp=false;
                        }else{
                                if(resultado.getObject(1).toString().equals(nombre) &&resultado.getObject(2).toString().equals(contraseña))
                                resp=true;       
                            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
            
            return resp;
                
	}
               public void combiocontraseña(String nombre, String contraseña) throws SQLException{
		String 	query="";
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="update usuario"
                        +" set contraseña= '"+contraseña+"'"
			+" where nombre is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals(""))
				query+= " and nombre COLLATE utf8_bin= '"+nombre+"'";

			st.execute(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/                
	}
               public void insertarnuevousuario(String nombre,String contraseña,String respuesta, String pregunta) throws SQLException{
                String qry="";
		try {
			qry="insert into usuario (contraseña,pregunta,nombre,respuesta)"+ " values('"+contraseña+"','"+pregunta+"','"+nombre+"','"+respuesta+"')";
			//System.out.println("qry "+qry)
                        st.execute(qry);
                        
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
               public void insertarnuevojefe(String nombre,String ap,String am,String usuario) throws SQLException{
                String qry="";
                String qry2="";
                String fs="1950-01-01";
                String [] nombres= nombre.split(" ");
                String [] aps= ap.split(" ");
                String [] ams= am.split(" ");
                String iniciales="";
                for(int i=0;i<nombres.length;i++){
                    iniciales+=nombres[i].charAt(0);
                }
                for(int i=0;i<aps.length;i++){
                    iniciales+=aps[i].charAt(0);
                }
                for(int i=0;i<ams.length;i++){
                    iniciales+=ams[i].charAt(0);
                }
                insertar+="Al Socio "+nombre+" "+ap+" "+am+".";
		try {
			qry="insert into jefe(nombre,ap,am,activo,fs,iniciales)"+" values('"+nombre+"','"+ap+"','"+am+"',"+1+",'"+fs+"','"+iniciales.toUpperCase()+"')";
                        st.execute(qry);
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
			st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
               public void insertarnuevoempleado(String nombre,String ap,String am, String fi,String idjefe,String nivel, String horario, String usuario) throws SQLException{
                String qry="";
                String qry2="";
                String fs="1950-01-01";
                insertar+="Al Colaborador "+nombre+" "+ap+" "+am+" con la fecha "+fi;
		try {
			qry="insert into empleado(nombre,ap,am,fi,activo,fs,idjefe,nivel,horario)"+" values('"+nombre+"','"+ap+"','"+am+"','"+fi+"',"+1+",'"+fs+"',"
                                + "'"+idjefe+"','"+nivel+"','"+horario+"')";
                        st.execute(qry);
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
			st.execute(qry2);
                        remove();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
               public void insertarnuevoempleado1(String nombre,String ap,String am, String fi,String idjefe,String nivel, String horario) throws SQLException{
                String qry="";
                String qry2="";
                String fs="1950-01-01";
                insertar+="Al Colaborador "+nombre+" "+ap+" "+am+" con la fecha "+fi;
		try {
			qry="insert into empleado(nombre,ap,am,fi,activo,fs,idjefe,nivel,horario)"+" values('"+nombre+"','"+ap+"','"+am+"','"+fi+"',"+1+",'"+fs+"',"
                                + "'"+idjefe+"','"+nivel+"','"+horario+"')";
                        st.execute(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
            public void insertarnuevoempleado2(String nombre) throws SQLException{
                String qry="";
		try {
			qry="insert into grupo(nombre)"+" values('"+nombre+"')";
                        st.execute(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
            
        public void insertarnuevoempleado3(String codigo,String nombre,String fi,String rfc, String idgrupo ) throws SQLException{
                String qry="";
		try {
			qry="insert into empresa(codigo,nombre,fi,activo,rfc,idgrupo)"+" values('"+codigo+"','"+nombre+"','"+fi+"',"+1+",'"+rfc+"','"+idgrupo+"')";
                        st.execute(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
        
        public DefaultTableModel buscarjefetabla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Nombre");
                uno.addColumn("Apellido Paterno");
                uno.addColumn("Apellido Materno");  
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idjefe,nombre,ap,am"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros

				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = "+1+"";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Nombre");
                        uno.addColumn("Apellido Paterno");
                        uno.addColumn("Apellido Materno");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarjefetabla1(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Nombre");
                uno.addColumn("Socio");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idjefe,nombre,ap,am,iniciales"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros

				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = "+1+"";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Nombre");
                        uno.addColumn("Socio");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount()+2;i++){
                                if(i==1){
                                    filas[i]= resultado.getObject(i+1).toString().concat(" ")+
                                            resultado.getObject(i+2).toString().concat(" ")+
                                            resultado.getObject(i+3).toString();
                                    i+=2;
                                }else if(i>3) {
                                        filas[i-2]= resultado.getObject(i+1);       
                                }else{
                                    filas[i]= resultado.getObject(i+1);
                                }
                                                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarjefetabla3(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("Nombre");
                uno.addColumn("Apellido Paterno");
                uno.addColumn("Apellido Materno");
                uno.addColumn("Iniciales");
                uno.addColumn("IdSocio");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre,ap,am,iniciales,idjefe"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros

				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = "+1+"";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Nombre");
                        uno.addColumn("Apellido Paterno");
                        uno.addColumn("Apellido Materno");
                        uno.addColumn("Iniciales");
                        uno.addColumn("IdSocio");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        
        public DefaultTableModel buscargrupotabla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("IdGrupo");
                uno.addColumn("Grupo");

                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idgrupo,nombre"
					+" from grupo"
			 	+" where idgrupo is not null"
                                +" order by idgrupo";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";               
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("IdGrupo");
                        uno.addColumn("Grupo");
                        while (resultado.next()) {
                            
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarjefetabla2(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("id");
                uno.addColumn("Nombre");
                uno.addColumn("Apellido Paterno");
                uno.addColumn("Apellido Materno");
                uno.addColumn("Ingreso");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idjefe,nombre,ap,am,fi"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("id");
                        uno.addColumn("Nombre");
                        uno.addColumn("Apellido Paterno");
                        uno.addColumn("Apellido Materno");
                        uno.addColumn("Ingreso");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarempresatabla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Nombre");
                uno.addColumn("RFC");
                uno.addColumn("Ingreso");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idempresa,nombre,rfc,fi"
					+" from empresa"
			 	+" where idempresa is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = "+1+"";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Nombre");
                        uno.addColumn("RFC");
                        uno.addColumn("Ingreso");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                if(i==3){
                                    filas[i]= new SimpleDateFormat("dd-MM-yyyy").format(resultado.getObject(i+1));
                                }else{
                                    filas[i]=resultado.getObject(i+1);
                                } 
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarempresatabla1(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Nombre");
                uno.addColumn("Ingreso");
                uno.addColumn("RFC");
                uno.addColumn("IdGrupo");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idempresa,nombre,fi,rfc,idgrupo"
					+" from empresa"
			 	+" where idempresa is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = "+1+"";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Nombre");
                        uno.addColumn("Ingreso");
                        uno.addColumn("RFC");
                        uno.addColumn("IdGrupo");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                if(i==2){
                                    filas[i]= new SimpleDateFormat("dd-MM-yyyy").format(resultado.getObject(i+1));
                                }else{
                                    filas[i]=resultado.getObject(i+1);
                                }
                                
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        
        public DefaultTableModel buscarserviciotabla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("IdServicio");
                uno.addColumn("Servicio");
                uno.addColumn("Descripción Corta");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idservicio,nombre,dc"
					+" from servicio"
			 	+" where idservicio is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = 1"; 
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("IdServicio");
                        uno.addColumn("Servicio");
                        uno.addColumn("Descripción Corta");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarempresa(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Cliente");
                uno.addColumn("Ingreso");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idempresa,nombre,fi"
					+" from empresa"
			 	+" where idempresa is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Cliente");
                        uno.addColumn("Ingreso");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        
        public DefaultTableModel buscarempresapantalla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("Inicio");
                uno.addColumn("Fin");
                uno.addColumn("Cliente");
                uno.addColumn("Horas presupuestadas");
                uno.addColumn("Horas trabajadas");
                uno.addColumn("Resto");
                uno.addColumn("Activo");
                uno.addColumn("Ejercicio");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select p.fi,p.ff,e.nombre,p.hp,p.ht,p.idproyecto"
					+" from empresa e, proyecto p"
			 	+" where e.idempresa = p.idempresa";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and e.nombre like '%"+nombre+"%'";
                                
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Inicio");
                        uno.addColumn("Fin");
                        uno.addColumn("Cliente");
                        uno.addColumn("Horas presupuestadas");
                        uno.addColumn("Horas trabajadas");
                        uno.addColumn("Resto");
                        uno.addColumn("Activo");
                        uno.addColumn("Ejercicio");

                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount()-3;i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    filas[5]=Integer.parseInt(resultado.getObject(4).toString())-Integer.parseInt(resultado.getObject(5).toString());
                    if(resultado.getObject(2).toString().equals("1950-01-01")){
                        filas[1]="Sin terminar";
                        filas[6]="SI";
                    }else{
                        filas[6]="NO";
                    }
                    filas[7]=resultado.getObject(6);
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel vitaempleadoanual(String idempleado, String f1, String f2) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("Empresa");
                uno.addColumn("Servicio");
                uno.addColumn("Horas trabajadas");
                Object [] filas= new Object [uno.getColumnCount()];
                Object [] filas1= new Object [uno.getColumnCount()];
                filas1[1]="Total";
                filas1[2]="0";
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="SELECT e.nombre,s.nombre ,sum(pe.ht)\n" +
                                "from proyecto_empleado pe, empresa e, proyecto p, empleado m, servicio s" +
                                " where m.idempleado="+idempleado+""+
                                " and fecha >='"+f1+"'"+
                                " and fecha <='"+f2+"'" +
                                " and p.idproyecto= pe.idproyecto" +
                                " and p.idempresa = e.idempresa" +
                                " and pe.idempleado = m.idempleado" +
                                " and p.idservicio = s.idservicio" +
                                " GROUP BY e.nombre,s.nombre ";	
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Empresa");
                        uno.addColumn("Servicio");
                        uno.addColumn("Horas trabajadas");
                        int suma=0;
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++)
                            {
                                filas[i]= resultado.getObject(i+1);                           				
                            }
                            suma+=Integer.parseInt(resultado.getObject(3).toString());
                            uno.addRow(filas);    
                        }
                        filas1[2]=Integer.toString(suma);
                        uno.addRow(filas1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
        
        public DefaultTableModel buscarempresa3(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("ID");
                uno.addColumn("Nombre");
                uno.addColumn("Ingreso");
                uno.addColumn("Activo");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idempresa,nombre,fi,activo"
					+" from empresa"
			 	+" where idempresa is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("ID");
                        uno.addColumn("Nombre");
                        uno.addColumn("Ingreso");
                        uno.addColumn("Activo");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                if(i==2)
                                {
                                    String fecha = resultado.getObject(i+1).toString();
                                    String [] fechas = fecha.split("-");
                                    String fechaN = fechas[2]+ "-" + fechas[1]+ "-" + fechas[0];
                                    filas[i]= fechaN;
                                }else
                                {
                                    filas[i]= resultado.getObject(i+1);
                                }
                                if(i==3)
                                    {
                                        if(resultado.getObject(i+1).equals(true))
                                        {
                                            filas[3]="Si";
                                        }else
                                        {
                                            filas[3]="No";
                                        }
                                    }
                                                           				
                            }
                        uno.addRow(filas);                   
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        
        public int horastotalcargable(String idempleado, String f1, String f2) throws SQLException{               
		ResultSet resultado;
                int resultadofinal=0;
                boolean si=true;
		String 	query="";                
		try {	//crea el objeto statement que permitira ejecutar el query					
			query="SELECT sum(p.ht)" +
                                " from proyecto_empleado p, empresa e, proyecto p1, empleado m" +
                                " where m.idempleado="+idempleado+""+
                                " and fecha >='"+f1+"'"+
                                " and fecha <='"+f2+"'" +
                                " and p1.idproyecto= p.idproyecto" +
                                " and p1.idempresa = e.idempresa" +
                                " and  p.idempleado = m.idempleado ";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si = resultado.next();
                        if(si)
                        {
                            resultadofinal = Integer.parseInt(resultado.getObject(1).toString());
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resultadofinal;
	}
        public int horastotalnocargable(String idempleado, String f1, String f2) throws SQLException{               
		ResultSet resultado;
                int resultadofinal=0;
                boolean si=true;
		String 	query="";                
		try {	//crea el objeto statement que permitira ejecutar el query					
			query="SELECT sum(he.horas)" +
                                " from hnc_empleado he, empleado m, hnc h" +
                                " where he.idempleado="+idempleado+""+
                                " and he.fecha >='"+f1+"'"+
                                " and he.fecha <='"+f2+"'" +
                                " and he.idhnc = h.idhnc" +
                                " and m.idempleado = he.idempleado" ;
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si = resultado.next();
                        if(si)
                        {
                            resultadofinal = Integer.parseInt(resultado.getObject(1).toString());
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resultadofinal;
	}
        public DefaultTableModel vitaempleadoanualhnc(String idempleado, String f1, String f2) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("Horas NO cargables");
                uno.addColumn("Horas trabajadas");
                Object [] filas= new Object [uno.getColumnCount()];
                Object [] filas1= new Object [uno.getColumnCount()];
                filas1[0]="Total";
                filas1[1]="0";
		try {	//crea el objeto statement que permitira ejecutar el query	
                        query = " SELECT h.nombre, sum(he.horas)"+
                                " from hnc_empleado he, empleado m, hnc h " +
                                " where he.idempleado="+idempleado+""+
                                " and he.fecha >='"+f1+"'"+
                                " and he.fecha <='"+f2+"'" +
                                " and he.idhnc = h.idhnc" +
                                " and m.idempleado = he.idempleado" +
                                " GROUP BY h.nombre ";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Horas NO cargables");
                        uno.addColumn("Horas trabajadas");
                        int suma=0;
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                            }
                            suma+=Integer.parseInt(resultado.getObject(2).toString());
                            uno.addRow(filas);    
                        }
                        filas1[1]=Integer.toString(suma);
                        uno.addRow(filas1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
        public DefaultTableModel buscarempresa1(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("idEjercicio");
                uno.addColumn("Cliente");
                uno.addColumn("idCliente");
                uno.addColumn("Servicio");
                uno.addColumn("idServicio");
                uno.addColumn("Inicio");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select p.idproyecto,e.nombre,e.idempresa,s.nombre,s.idservicio,p.fi"
				+" from empresa e, proyecto p, servicio s"
			 	+" where e.idempresa = p.idempresa"
                                +" and p.ff COLLATE utf8_bin = '1950-01-01'"
                                +" and s.idservicio=p.idservicio";
				query+= " and e.nombre like '%"+nombre+"%'";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("idEjercicio");
                        uno.addColumn("Cliente");
                        uno.addColumn("idCliente");
                        uno.addColumn("Servicio");
                        uno.addColumn("idServicio");
                        uno.addColumn("Inicio");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarhnctabla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("id");
                uno.addColumn("Nombre");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idhnc,nombre"
					+" from hnc"
			 	+" where idhnc is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = 1";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("id");
                        uno.addColumn("Nombre");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        
        public String buscaidproyecto(String idempresa, String idservicio) throws SQLException{
                
		ResultSet resultado;
                String resultadofinal = null;
		String 	query="";
                String fecha = "1950-01-01";
                boolean si=true;
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idproyecto"
				+" from proyecto"
			 	+" where idproyecto is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " and idempresa = "+idempresa+"";
                                query+= " and idservicio = "+idservicio+"";
                                query+= " and ff COLLATE utf8_bin = '"+fecha+"'"; 			
                                resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                                si=resultado.next();
                                if(si){
                                    resultadofinal=resultado.getObject(1).toString();
                                }else{
                                    resultadofinal="";
                                }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return resultadofinal;
	}
        
        public String buscarfechaproyecto(String idempresa, String idproyecto) throws SQLException{
                
		ResultSet resultado;
                String resultadofinal = null;
		String 	query="";
                String fecha = "1950-01-01";
                boolean si=true;
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select fi"
				+" from proyecto"
			 	+" where idproyecto is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " and idempresa = "+idempresa+"";
                                query+= " and idproyecto = "+idproyecto+"";
                                query+= " and ff COLLATE utf8_bin = '"+fecha+"'"; 			
                                resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                                si=resultado.next();
                                if(si){
                                    resultadofinal=resultado.getObject(1).toString();
                                }else{
                                    resultadofinal="";
                                }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return resultadofinal;
	}
        public DefaultTableModel buscarempleadotabla(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Nombre");
                uno.addColumn("IdSocio");
                uno.addColumn("Nivel");
                uno.addColumn("Ingreso");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idempleado,nombre,ap,am,idjefe,nivel,fi"
					+" from empleado"
			 	+" where idempleado is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and nombre like '%"+nombre+"%'";
                                query+= " and activo = "+1+"";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Nombre");
                        uno.addColumn("IdSocio");
                        uno.addColumn("Nivel");
                        uno.addColumn("Ingreso");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount()+2;i++){
                                if(i==1){
                                    filas[i]= resultado.getObject(i+1).toString().concat(" ")+
                                            resultado.getObject(i+2).toString().concat(" ")+
                                            resultado.getObject(i+3).toString();
                                    i+=2;
                                }else if(i>3) {
                                    if(i==6){
                                        filas[i-2]= new SimpleDateFormat("dd-MM-yyyy").format(resultado.getObject(i+1));
                                    }else{
                                        filas[i-2]= resultado.getObject(i+1); 
                                        }       
                                }else{
                                    filas[i]= resultado.getObject(i+1);
                                }
                                                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public DefaultTableModel buscarempleadotabla1(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Id");
                uno.addColumn("Nombre");
                uno.addColumn("Apellido Paterno");
                uno.addColumn("Apellido Materno");
                uno.addColumn("IdSocio");
                uno.addColumn("Socio");
                uno.addColumn("Ingreso");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select e.idempleado, e.nombre , e.ap,e.am,e.idjefe,j.iniciales,e.fi"
					+" from empleado e, jefe j"
                                        +" where e.idjefe = j.idjefe"
			 	+" and e.idempleado is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			
				query+= " and e.nombre like '%"+nombre+"%'";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Id");
                        uno.addColumn("Nombre");
                        uno.addColumn("Apellido Paterno");
                        uno.addColumn("Apellido Materno");
                        uno.addColumn("IdSocio");
                        uno.addColumn("Socio");
                        uno.addColumn("Ingreso");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);                           				
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
        public void bajaempleado(String idempleado, String usuario) throws SQLException{
		String qry="";
                String qry1="";
                String qry2="";
                borrar+="Al colaborador "+idempleado;
                try {
                    
                        qry+=" update empleado set fs = '"+d.format(date)+"'"+
                            " where idempleado = "+idempleado+";";
                        qry1+="update empleado set activo = 0"+
                            " where idempleado = "+idempleado+"";
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+borrar+"')";
			System.out.println(qry);
			st.execute(qry);//ejecuta el qry
			st.execute(qry1);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
        public void cambioempleado(String nombre, String ap, String am, String idjefe,String idempleado,String horario,String puesto, String usuario) throws SQLException{
		String qry="";
                String qry1="";
                String qry2="";
                String qry3="";
                String qry4="";
                String qry5="";
                String qry6="";
                cambiar+="Al colaborador "+idempleado+", con el nombre: "+nombre+" "+ap+" "+am
                        +", el Socio "+idjefe+", con horario de "+horario+" y nivel de "+puesto;
                try {
                    
                        qry+=" update empleado set nombre = '"+nombre+"'"+
                            " where idempleado = "+idempleado+";";
                        qry1+=" update empleado set ap = '"+ap+"'"+
                            " where idempleado = "+idempleado+";";
                        qry2+=" update empleado set am = '"+am+"'"+
                            " where idempleado = "+idempleado+";";
                        qry3+=" update empleado set idjefe = "+idjefe+""+
                            " where idempleado = "+idempleado+"";
                        qry4+=" update empleado set horario = '"+horario+"'"+
                            " where idempleado = "+idempleado+"";
                        qry5+=" update empleado set nivel= '"+puesto+"'"+
                            " where idempleado = "+idempleado+"";
                        qry6+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+cambiar+"')";
			st.execute(qry);//ejecuta el qry
			st.execute(qry1);
                        st.execute(qry2);
                        st.execute(qry3);
                        st.execute(qry4);
                        st.execute(qry5);
                        st.execute(qry6);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
        public void cambioempresa(String nombre,String rfc,String idgrupo, String idempresa,String usuario) throws SQLException{
		String qry="";
                String qry2="";
                String qry3="";
                String qry4="";
                cambiar+="Al cliente "+idempresa;
                cambiar+=" con el nombre: "+nombre;
                cambiar+=", rfc("+rfc+"),";
                cambiar+=" idgrupo("+idgrupo+"),";
                
                try {

                            qry+=" update empresa set nombre = '"+nombre+"'"+
                            " where idempresa = "+idempresa+";";
                            qry3+=" update empresa set rfc = '"+rfc+"'"+
                            " where idempresa = "+idempresa+";";
                            qry4+=" update empresa set idgrupo = "+idgrupo+""+
                            " where idempresa = "+idempresa+";";

                            
                            st.execute(qry);
                            st.execute(qry3);
                            st.execute(qry4);
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+cambiar+"')";
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void cambioproyecto(String idproyecto,String usuario) throws SQLException{    
            cambiar+="La fecha del ejercicio "+idproyecto+"";                  
            String qry2="";
            String qry="";
                    
                        try {

                            qry+=" update proyecto set ff = '"+d.format(date)+"'"+
                                    " where idproyecto = "+idproyecto+"";
                            qry2+="insert into registro(fecha,usuario,hecho)"+
                                    " values('"+d.format(date)+"','"+usuario+"','"+cambiar+"')";
                            st.execute(qry);//ejecuta el qry
                            st.execute(qry2);
                            remove();
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }       

        }
        public void cambiohnc(String nombre, String idhnc, String usuario) throws SQLException{
		String qry="";
                String qry2="";
                cambiar+="El nombre de la hora No cargable "+idhnc+" a: "+nombre;
                try {
                    
                        qry+=" update hnc set nombre = '"+nombre+"'"+
                            " where idhnc = "+idhnc+";";
			qry2+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+cambiar+"')";
			st.execute(qry);//ejecuta el qry
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void cambiojefe(String nombre, String ap, String am, String idjefe,String usuario) throws SQLException{
		String qry="";
                String qry1="";
                String qry2="";
                String qry3="";
                String qry4="";
                String [] nombres= nombre.split(" ");
                String [] aps= ap.split(" ");
                String [] ams= am.split(" ");
                String iniciales="";
                for(int i=0;i<nombres.length;i++){
                    iniciales+=nombres[i].charAt(0);
                }
                for(int i=0;i<aps.length;i++){
                    iniciales+=aps[i].charAt(0);
                }
                for(int i=0;i<ams.length;i++){
                    iniciales+=ams[i].charAt(0);
                }
                cambiar+="El nombre del Socio a: "+nombre+" "+ap+" "+am;                
                try {
                    
                        qry+=" update jefe set nombre = '"+nombre+"'"+
                            " where idjefe = "+idjefe+";";
                        qry1+=" update jefe set ap = '"+ap+"'"+
                            " where idjefe = "+idjefe+";";
                        qry2+=" update jefe set am = '"+am+"'"+
                            " where idjefe = "+idjefe+";";
                        qry3+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+cambiar+"')";
                        qry4+=" update jefe set iniciales ='"+iniciales+"'"+
                                " where idjefe = "+idjefe+";";
			
			st.execute(qry);//ejecuta el qry
			st.execute(qry1);
                        st.execute(qry2);
                        st.execute(qry3);
                        st.execute(qry4);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
         public void bajaempresa(String idempresa,String usuario) throws SQLException{
		
                String qry1="";
                String qry2="";
                borrar+="Al cliente "+idempresa;
                try {
                        qry1+="update empresa set activo = 0"+
                            " where idempresa = "+idempresa+"";	
                        qry2+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+borrar+"')";
			st.execute(qry1);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
         
         public void bajahnc(String idhnc,String usuario) throws SQLException{
                String qry1="";
                String qry2="";
                borrar="La hora No cargable "+idhnc;
                try {
                        qry1+=" update hnc set activo = 0"+
                            " where idhnc = "+idhnc+"";	
                        qry2+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+borrar+"')";
			st.execute(qry1);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
         
         public void bajaservicio(String idservicio,String usuario) throws SQLException{
                String qry1="";
                String qry2="";
                borrar="El servicio: "+idservicio;
                try {
                        qry1+=" update servicio set activo = 0"+
                            " where idservicio = "+idservicio+"";	
                        qry2+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+borrar+"')";
			st.execute(qry1);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
        
        public void bajajefe(String idjefe,String usuario) throws SQLException{
		String qry="";
                String qry1="";
                String qry2="";
                borrar+="Al socio "+idjefe;
                try {
                    
                        qry+=" update jefe set fs = '"+d.format(date)+"'"+
                            " where idjefe = "+idjefe+";";
                        qry1+="update jefe set activo = 0"+
                            " where idjefe = "+idjefe+"";
                        qry2+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+borrar+"')";
			st.execute(qry);//ejecuta el qry
			st.execute(qry1);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
        
        public void insertarnuevaempresa(String nombre, String fi,String rfc,String idgrupo, String usuario) throws SQLException{
                String qry="";
                String qry2="";
                insertar+="Al cliente "+nombre;
                if(idgrupo.equals("")) idgrupo="1";
                
		try {
			qry="insert into empresa (nombre,fi,activo,rfc,idgrupo)"+ " values('"+nombre+"','"+fi+"',"+1+",'"+rfc+"','"+idgrupo+"')";
			qry2+="insert into registro(fecha,usuario,hecho)"+
                                " values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
                        st.execute(qry);
                        st.execute(qry2);
			remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
                        
		}*/
	}
                public boolean buscarhnc(String nombre) throws SQLException{
		ResultSet resultado;
		boolean resp=true;
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre"
					+" from hnc"
					+" where idhnc is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals("")){
                            query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";
                            query+= " and activo= 1";
                        }
				

			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        if(resultado.getRow()==0){
                            resp=true;
                        }else{                          
                                resp=false;       
                            }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resp;
                
	}
                public boolean buscarservicio(String nombre) throws SQLException{
		ResultSet resultado;
		boolean resp=true;
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre"
					+" from servicio"
					+" where idservicio is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals("")){
                            query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";
                            query+= " and activo = 1";
                        }
				
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        if(resultado.getRow()==0){
                            resp=true;
                        }else{                          
                                resp=false;       
                            }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resp;
                
	}
    public boolean buscargrupo(String nombre) throws SQLException{
		ResultSet resultado;
		boolean resp=true;
		String 	query="";
		
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre"
					+" from grupo"
					+" where idgrupo is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
			
			if(nombre!=null && !nombre.equals(""))
				query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";

			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			resultado.next();
                        if(resultado.getRow()==0){
                            resp=true;
                        }else{                          
                                resp=false;       
                            }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resp;
                
	}
    public boolean buscarempleado(String id, String nombre) throws SQLException{
		ResultSet resultado;
		boolean resp=true;
		String 	query="";
		boolean si;
                String [] nombrec=nombre.split(" ");
                
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select nombre"
					+" from empleado"
					+" where idempleado is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
                    if(nombrec.length>3){
                        if(id!=null && !id.equals("")){
                                query+= " and nombre COLLATE utf8_bin = '"+nombrec[0].concat(" "+nombrec[1])+"' ";
                                 query+= " and ap COLLATE utf8_bin = '"+nombrec[2]+"' ";
                                  query+= " and am COLLATE utf8_bin = '"+nombrec[3]+"' ";
				query+= " and idempleado = "+id+"";
                        }
                    }else{
                        if(id!=null && !id.equals("")){
                                query+= " and nombre COLLATE utf8_bin = '"+nombrec[0]+"' ";
                                 query+= " and ap COLLATE utf8_bin = '"+nombrec[1]+"' ";
                                  query+= " and am COLLATE utf8_bin = '"+nombrec[2]+"' ";
				query+= " and idempleado = "+id+"";
                        }
                    }            
			
                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			si=resultado.next();
                        if(si){
                            resp=true;
                        }else{                          
                                resp=false;       
                            }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resp;
                
	}
    public void insertarhnc(String nombre,String usuario) throws SQLException{
                String qry="";
                String qry2="";
                insertar+="La hora No cargable: "+nombre;
		try {
			qry="insert into hnc (nombre,activo)"+ " values('"+nombre+"',1)";
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
                        st.execute(qry);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void insertargrupo(String nombre,String usuario) throws SQLException{
                String qry="";
                String qry2="";
                insertar+="El grupo: "+nombre;
		try {
			qry="insert into grupo(nombre)"+ " values('"+nombre+"')";
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
                        st.execute(qry);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void insertarservicio(String nombre,String dl, String dc,String usuario) throws SQLException{
                String qry="";
                String qry2="";
                insertar+="El servicio: "+nombre;
		try {
			qry="insert into servicio(nombre,dl,dc,activo)"+ " values('"+nombre+"','"+dl+"','"+dc+"',"+1+")";
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
                        st.execute(qry);
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void insertarproyecto(String idempresa, String fi, String hp,String idservicio,String socio1, String socio2,String usuario) throws SQLException{
                String qry="";
                String qry2="";
                String qry3="";
                String qry4="";
                ResultSet resultado;
                insertar+="Un ejercicio con el cliente "+idempresa+" el día "+fi+", servicio: "+idservicio;
                String ff="1950-01-01";
		try {
			qry+="insert into proyecto(idempresa,hp,ht,fi,ff,idservicio)"+ " values('"+idempresa+"',"+hp+","+0+",'"+fi+"','"+ff+"',"+idservicio+")";			
                        st.execute(qry);
                        qry3+="insert into proyecto_jefe(idproyecto,idjefe)"+ " values('"+max()+"',"+socio1+")";
                        st.execute(qry3);
                        qry4+="insert into proyecto_jefe(idproyecto,idjefe)"+ " values('"+max()+"',"+socio2+")";
                        st.execute(qry4);
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public String max() throws SQLException{
                ResultSet resultado;
                String rs="";
		try {
                        resultado=st.executeQuery("Select max(idproyecto) from proyecto");
                        resultado.next();
                        rs=resultado.getObject(1).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            return rs;
	}
    public void insertarproyecto2(String idempresa, String fi, String hp,String idservicio,String socio1,String usuario) throws SQLException{
                String qry="";
                String qry2="";
                String qry3="";
                ResultSet resultado;
                insertar+="Un ejercicio con el cliente "+idempresa+" el día "+fi+", servicio: "+idservicio;
                String ff="1950-01-01";
		try {
			qry+="insert into proyecto(idempresa,hp,ht,fi,ff,idservicio)"+ " values('"+idempresa+"',"+hp+","+0+",'"+fi+"','"+ff+"',"+idservicio+")";			
                        st.execute(qry);
                        resultado=st.executeQuery("Select max(idproyecto) from proyecto");
                        resultado.next();
                        qry3+="insert into proyecto_jefe(idproyecto,idjefe)"+ " values('"+resultado.getObject(1).toString()+"',"+socio1+")";
                        st.execute(qry3);          
                        qry2+="insert into registro(fecha,usuario,hecho)"+" values('"+d.format(date)+"','"+usuario+"','"+insertar+"')";
                        st.execute(qry2);
                        remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public boolean insertarpe(String idproyecto, String idempleado, String ht, String fecha) throws SQLException{
                String qry="";
                String query="";
                String qry1="";
                boolean si=true;
		try {
                        query="select idproyecto,idempleado,ht,fecha"
				+" from proyecto_empleado"
			 	+" where idproyecto ="+idproyecto+""
                                +" and idempleado ="+idempleado+""
                                +" and ht= "+ht+""
                                +" and fecha COLLATE utf8_bin = '"+fecha+"'";
                        ResultSet resultado=st.executeQuery(query);
                        si= resultado.next();
                        if(!si){
                            qry="insert into proyecto_empleado(idproyecto, idempleado,ht,fecha)"+ 
                                " values("+idproyecto+","+idempleado+","+ht+",'"+fecha+"')";
                            st.execute(qry);
                            qry1="Update proyecto set ht = ht + "+ht+""+
                             " where  idproyecto ="+idproyecto+"";
                            st.execute(qry1);
                        }
                                              
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return si;
	}
    public boolean insertarhnce( String idempleado, String idhnc ,String horas, String fecha) throws SQLException{
                String qry="";
                String query="";
                boolean si = true;
		try {
                        query="select idempleado,idhnc,fecha,horas"
				+" from hnc_empleado"
			 	+" where idempleado = "+idempleado+""
                                +" and idhnc = "+idhnc+""
                                +" and horas= "+horas+""                               
                                +" and fecha COLLATE utf8_bin = '"+fecha+"'";
                        ResultSet resultado=st.executeQuery(query);                       
                        si= resultado.next();
                        String motivo = "MOTIVO";
                        if(!si){
                            qry="insert into hnc_empleado(idempleado, idhnc,fecha,horas,motivo)"+ 
                                " values("+idempleado+","+idhnc+",'"+fecha+"',"+horas+",'"+motivo+"')";
                            st.execute(qry);
                        }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return si;
	}
    public void updatehnce(String motivo,String idhnc,String fecha,String idempleado) throws SQLException{
                String qry="";
		try {               
                        qry+=" update hnc_empleado set motivo = '"+motivo+"'"+
                            " where idhnc = "+idhnc+"";
                        qry+=" and idempleado = "+idempleado+"";
                        qry+=" and fecha COLLATE utf8_bin = '"+fecha+"'";
			st.execute(qry);//ejecuta el qry
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public String buscaidempresa(String nombre) throws SQLException{
                
		ResultSet resultado;
                String resultadofinal = null;
		String 	query="";
                boolean si=true;
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idempresa"
				+" from empresa"
			 	+" where activo = 1";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";      
                                resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                                si=resultado.next();
                                if(si){
                                    resultadofinal=resultado.getObject(1).toString();
                                }else{
                                    resultadofinal="";
                                }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return resultadofinal;
	}
    public String buscaidservicio(String nombre) throws SQLException{
                
		ResultSet resultado;
                String resultadofinal = null;
		String 	query="";
                boolean si=true;
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idservicio"
				+" from servicio"
			 	+" where activo = 1";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " and nombre COLLATE utf8_bin = '"+nombre+"'";      
                                resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                                si=resultado.next();
                                if(si){
                                    resultadofinal=resultado.getObject(1).toString();
                                }else{
                                    resultadofinal="";
                                }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return resultadofinal;
	}
    public String buscaidhnc(String nombre) throws SQLException{
                
		ResultSet resultado;
                String resultadofinal = null;
		String 	query="";
                boolean si = true;
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idhnc"
				+" from hnc";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " where nombre COLLATE utf8_bin = '"+nombre+"'";      
                                resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			                               
                                si=resultado.next();
                                if(si){
                                    resultadofinal=resultado.getObject(1).toString();
                                }else{
                                    resultadofinal="";
                                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return resultadofinal;
	}
     public String buscaidhnc1(String nombre) throws SQLException{
                
		ResultSet resultado;
                String resultadofinal = null;
		String 	query="";
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idhnc"
				+" from hnc";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " where nombre like '"+nombre+"'";      
                                resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                                resultado.next();            
                        resultadofinal=resultado.getObject(1).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return resultadofinal;
	}
     public DefaultTableModel empleadoreporteexcel(String idjefe,String f1,String f2 ) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Nombre");
                uno.addColumn("idColaborador");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="Select em.nombre,em.idempleado"
                                + " from empresa e, empleado em, jefe j, proyecto_empleado pe, proyecto p"
			 	+ " where pe.idproyecto = p.idproyecto"						
				+ " and j.idjefe = em.idjefe" 
                                + " and em.idjefe = "+idjefe+""
                                + " and pe.idempleado = em.idempleado"
                                + " and p.idempresa = e.idempresa"
                                + " and pe.fecha >='"+f1+"' "
                                + " and pe.fecha <='"+f2+"' " 
                                + " GROUP BY em.nombre ";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Nombre");
                        uno.addColumn("idColaborador");
                        while (resultado.next()){
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);
                            }
                            uno.addRow(filas);
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
     
     public DefaultTableModel empresareporteexcel(String idjefe,String f1,String f2 ) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Nombre");
                uno.addColumn("Servicio");
                uno.addColumn("idColaborador");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="Select e.nombre,s.nombre,p.idproyecto "
                                + " from empresa e, empleado em, jefe j, proyecto_empleado pe, proyecto p, servicio s "
			 	+ " where pe.idproyecto = p.idproyecto"						
				+ " and j.idjefe = em.idjefe" 
                                + " and em.idjefe = "+idjefe+""
                                + " and pe.idempleado = em.idempleado"
                                + " and p.idempresa = e.idempresa"
                                + " and pe.fecha >='"+f1+"' "
                                + " and pe.fecha <='"+f2+"' " 
                                + " and s.idservicio = p.idservicio"
                                + " GROUP BY p.idproyecto ";    
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Nombre");
                        uno.addColumn("Servicio");
                        uno.addColumn("idColaborador");
                        while (resultado.next()){
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);
                            }
                            uno.addRow(filas);
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
     public DefaultTableModel hncreporteexcel(String idjefe,String f1,String f2 ) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		String 	query="";
                uno.addColumn("Nombre");
                uno.addColumn("idColaborador");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="Select h.nombre,h.idhnc"
                                + " from hnc h, empleado em, jefe j, hnc_empleado h1"
			 	+ " where h.idhnc=h1.idhnc"						
				+ " and j.idjefe = em.idjefe" 
                                + " and em.idjefe = "+idjefe+""
                                + " and h1.idempleado=em.idempleado"
                                + " and h1.fecha >='"+f1+"' "
                                + " and h1.fecha <='"+f2+"' " 
                                + " GROUP BY h.nombre ";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("Nombre");
                        uno.addColumn("idColaborador");
                        while (resultado.next()){
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);
                            }
                            uno.addRow(filas);
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
     public String htempleado(String idjefe,String idempleado,String idproyecto,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="Select sum(pe.ht)" +
                            " from empresa e, empleado em, jefe j, proyecto_empleado pe, proyecto p" +
                            " where pe.idproyecto = p.idproyecto" +
                            " and j.idjefe = "+idjefe+"" +
                            " and p.idproyecto ="+idproyecto+" " +
                            " and em.idempleado = "+idempleado+"" +
                            " and j.idjefe = em.idjefe" +
                            " and pe.idempleado = em.idempleado" +
                            " and p.idempresa = e.idempresa" +
                            " and pe.fecha>='"+f1+"'" +
                            " and pe.fecha<='"+f2+"'";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
      public String hthnc(String idjefe,String idempleado,String idhnc,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="Select sum(h1.horas)" +
                            " from hnc h, empleado em, jefe j, hnc_empleado h1" +
                            " where h1.idempleado=em.idempleado" +
                            " and h.idhnc=h1.idhnc"+
                            " and j.idjefe = em.idjefe" +
                            " and j.idjefe = "+idjefe+"" +
                            " and h.idhnc ="+idhnc+" " +
                            " and em.idempleado = "+idempleado+"" +                                                      
                            " and h1.fecha>='"+f1+"'" +
                            " and h1.fecha<='"+f2+"'";
                        resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
    public String hthncempleado(String idempleado,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="SELECT sum(h1.horas)" +
                        " FROM empleado e, hnc h, hnc_empleado h1" +
                        " where h.idhnc = h1.idhnc" +
                        " and e.idempleado = h1.idempleado" +
                        " and e.idempleado = "+idempleado+"" +
                        " and h1.fecha >= '"+f1+"'" +
                        " and h1.fecha <= '"+f2+"'" +
                        " ORDER BY h1.fecha";  
                        resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
    public String totalmensualempresa(String idempresa,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="SELECT sum(p.ht)" +
                        " FROM empleado e,empresa em, proyecto_empleado p, proyecto p1" +
                        " where em.idempresa = p1.idempresa" +
                        " and p1.idproyecto = p.idproyecto" +
                        " and p.idempleado = e.idempleado" +
                        " and em.idempresa="+idempresa+"" +
                        " and p.fecha >= '"+f1+"'" +
                        " and p.fecha <= '"+f2+"'";
                        resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
    public String totalmensualempleado(String idempleado,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query=query="SELECT sum(p.ht)" +
                                " FROM empleado e,empresa em, proyecto_empleado p, proyecto p1" +
                                " where em.idempresa = p1.idempresa" +
                                " and p1.idproyecto = p.idproyecto" +
                                " and p.idempleado = e.idempleado" +
                                " and e.idempleado = "+idempleado+"" +
                                " and p.fecha >= '"+f1+"'" +
                                " and p.fecha <= '"+f2+"'" +
                                " ORDER BY p.fecha";  
                        resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
    public String sumatrabajado(String idproyecto,String idjefe,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query=query="Select sum(pe.ht)" +
                        " from empresa e, empleado em, jefe j, proyecto_empleado pe, proyecto p" +
                        " where pe.idproyecto = p.idproyecto" +
                        " and j.idjefe = em.idjefe" +
                        " and j.idjefe = "+idjefe+"" +
                        " and p.idproyecto="+idproyecto+"" +
                        " and pe.idempleado = em.idempleado" +
                        " and p.idempresa = e.idempresa" +
                        " and pe.fecha>='"+f1+"'" +
                        " and pe.fecha<='"+f2+"'";  
                        resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
        
    
    public String sumanotrabajado(String idhnc,String idjefe,String f1,String f2 ) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                String ht="";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query=query="Select sum(h1.horas)" +
                        " from hnc h, empleado em, jefe j, hnc_empleado h1" +
                        " where h1.idempleado=em.idempleado" +
                        " and h.idhnc=h1.idhnc" +
                        " and j.idjefe = em.idjefe" +
                        " and j.idjefe= "+idjefe+"" +
                        " and h.idhnc= "+idhnc+"" +
                        " and h1.fecha>= '"+f1+"'" +
                        " and h1.fecha<= '"+f2+"'";
                        resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
                        si=resultado.next();
                        if(si){
                            if(resultado.getInt(1)!=0){
                                ht=resultado.getObject(1).toString();
                            }else{
                                ht="0";
                            }
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return ht;
	}
    
      public DefaultTableModel vistaanualempresa(String idempresa,String f1,String f2) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
                String ht="";
                uno.addColumn("Colaborador");
                uno.addColumn("Socio");
                uno.addColumn("Servicio");
                uno.addColumn("Horas Trabajadas");
                
                Object [] filas= new Object [uno.getColumnCount()];
                Object [] filas1= new Object [uno.getColumnCount()];
                filas1[2]="Total";
                filas1[3]="0";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="Select em.nombre,em.ap,em.am,j.iniciales,s.nombre,sum(pe.ht)" +
                            " from empleado em, proyecto_empleado pe, empresa e, proyecto p , servicio s, jefe j" +
                            " where pe.idempleado=em.idempleado" +
                            " and j.idjefe = em.idjefe" +
                            " and pe.idproyecto=p.idproyecto" +
                            " and e.idempresa=p.idempresa" +
                            " and s.idservicio=p.idservicio" +
                            " and p.idempresa="+idempresa+"" +
                            " and pe.fecha>='"+f1+"'" +
                            " and pe.fecha<='"+f2+"'" +
                            " GROUP by em.nombre";
                        System.out.println(query);
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                        uno=dos;
                        uno.addColumn("Colaborador");
                        uno.addColumn("Socio");
                        uno.addColumn("Servicio");
                        uno.addColumn("Horas Trabajadas");
                        int suma=0;
                        while(resultado.next())
                        {
                            for(int i=0; i<uno.getColumnCount();i++)
                            {
                                if(i==0)
                                {
                                    filas[i]= resultado.getObject(i+1).toString()+ " " +resultado.getObject(i+2).toString()+ " " +resultado.getObject(i+3).toString();
                                }
                                if(i>0)
                                {
                                    filas[i]= resultado.getObject(i+3);
                                }
                            }
                            suma+=Integer.parseInt(resultado.getObject(6).toString());
                            uno.addRow(filas);                           
                        }
                        filas1[3]=Integer.toString(suma);
                        uno.addRow(filas1);
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
      public DefaultTableModel vistamensualempleado(String idempleado,String f1,String f2) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
                String ht="";
                uno.addColumn("Empresa");
                uno.addColumn("Fecha");
                uno.addColumn("Horas Trabajadas");
                
                Object [] filas= new Object [uno.getColumnCount()];
                Object [] filas1= new Object [uno.getColumnCount()];
                filas1[0]="Total";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="SELECT em.nombre,p.fecha,p.ht" +
                                " FROM empleado e,empresa em, proyecto_empleado p, proyecto p1" +
                                " where em.idempresa = p1.idempresa" +
                                " and p1.idproyecto = p.idproyecto" +
                                " and p.idempleado = e.idempleado" +
                                " and e.idempleado = "+idempleado+"" +
                                " and p.fecha >= '"+f1+"'" +
                                " and p.fecha <= '"+f2+"'" +
                                " ORDER BY p.fecha";  
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                        uno=dos;
                        uno.addColumn("Empresa");
                        uno.addColumn("Fecha");
                        uno.addColumn("Horas Trabajadas");
                        while(resultado.next()){
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);
                            }
                            uno.addRow(filas);
                        }
                        filas1[2]=totalmensualempleado(idempleado,f1,f2);
                        uno.addRow(filas1);
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
      public DefaultTableModel vistamensualempleado2(String idempleado,String f1,String f2) throws SQLException{
                boolean si=false;
		ResultSet resultado;
		String 	query="";
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
                String ht="";
                uno.addColumn("Hora NO cargable");
                uno.addColumn("Fecha");
                uno.addColumn("Total");
                
                Object [] filas= new Object [uno.getColumnCount()];
                Object [] filas1= new Object [uno.getColumnCount()];
                filas1[0]="Total";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="SELECT h.nombre,h1.fecha,h1.horas" +
                        " FROM empleado e, hnc h, hnc_empleado h1" +
                        " where h.idhnc = h1.idhnc" +
                        " and e.idempleado = h1.idempleado" +
                        " and e.idempleado = "+idempleado+"" +
                        " and h1.fecha >= '"+f1+"'" +
                        " and h1.fecha <= '"+f2+"'" +
                        " ORDER BY h1.fecha";  
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                        uno=dos;
                        uno.addColumn("Hora NO cargable");
                        uno.addColumn("Fecha");
                        uno.addColumn("Total");
                        while(resultado.next()){
                            for(int i=0; i<uno.getColumnCount();i++){
                                filas[i]= resultado.getObject(i+1);
                            }
                            uno.addRow(filas);
                        }
                        filas1[2]=hthncempleado(idempleado,f1,f2);
                        uno.addRow(filas1);
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
      public DefaultTableModel buscarempleadotabla3(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("ID");
                uno.addColumn("Nombre");
                uno.addColumn("Activo");
                uno.addColumn("Nivel");
                uno.addColumn("Socio");
                
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select e.idempleado,e.nombre,e.ap,e.am,e.activo,e.nivel,j.iniciales"
					+" from empleado e, jefe j"
			 	+" where idempleado is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros
				query+= " and e.nombre like '%"+nombre+"%'"
                                        +"and e.idjefe = j.idjefe";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("ID");
                        uno.addColumn("Nombre");
                        uno.addColumn("Activo");
                        uno.addColumn("Nivel");
                        uno.addColumn("Socio");
                        
                        while (resultado.next()) 
                        {
                            for(int i=0; i<uno.getColumnCount();i++)
                                {
                                    if(i==1){
                                        filas[i]=resultado.getObject(i+1)+" "+resultado.getObject(i+2)+" "+resultado.getObject(i+3);
                                    }else{
                                        filas[i]= resultado.getObject(i+1);
                                    }

                                    if(i==2)
                                    {
                                        if(resultado.getObject(5).equals(true))
                                        {
                                            filas[2]="Si";
                                        }else
                                        {
                                            filas[2]="No";
                                        }
                                    }
                                    if(i==3)
                                    {
                                        filas[i]= resultado.getObject(i+3);
                                    }
                                    if(i==4)
                                    {
                                        filas[i]= resultado.getObject(i+3);
                                    }
                                    
                                }
                        uno.addRow(filas);                   
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
     public DefaultTableModel buscarjefetabla4(String nombre) throws SQLException{
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
		ResultSet resultado;
		boolean resp=false;
		String 	query="";
                uno.addColumn("ID");
                uno.addColumn("Iniciales");
                uno.addColumn("Nombre");
                uno.addColumn("Activo");
                Object [] filas= new Object [uno.getColumnCount()];
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select idjefe,iniciales,nombre,ap,am,activo"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valores
			        //dependera del paso de parametros

				query+= " and nombre like '%"+nombre+"%'";
                                        
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			uno=dos;
                        uno.addColumn("ID");
                        uno.addColumn("Iniciales");
                        uno.addColumn("Nombre");
                        uno.addColumn("Activo");
                        while (resultado.next()) {
                            for(int i=0; i<uno.getColumnCount();i++){
                                if(i==2){
                                    filas[i]=resultado.getObject(i+1)+" "+resultado.getObject(i+2)+" "+resultado.getObject(i+3);
                                    filas[i+1]= resultado.getObject(i+4);
                                    i++;        
                                }else{
                                    filas[i]= resultado.getObject(i+1);
                                }
                                
                            if(resultado.getObject(6).equals(true))
                            {
                                filas[3]="Si";
                            }else
                            {
                                filas[3]="No";
                            }
                    }
                    uno.addRow(filas);
                    
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return uno;
	}
      
      public DefaultTableModel vistamensualempresa(String idempresa,String f1,String f2) throws SQLException{
		ResultSet resultado;
		String 	query="";
                uno= new DefaultTableModel();
                dos= new DefaultTableModel();
                uno.addColumn("Nombre");
                uno.addColumn("Fecha");
                uno.addColumn("Horas Trabajadas");
                uno.addColumn("ID");
                uno.addColumn("idSocio");
                
                Object [] filas= new Object [uno.getColumnCount()];
                Object [] filas1= new Object [uno.getColumnCount()];
                filas1[0]="Total";
		try {	//crea el objeto statement que permitira ejecutar el query					                 
			query="SELECT e.nombre, e.ap, e.am, p.fecha, p.ht, e.idempleado,e.idjefe" +
                        " FROM empleado e, empresa em, proyecto_empleado p, proyecto p1" +
                        " where em.idempresa = p1.idempresa" +
                        " and p1.idproyecto = p.idproyecto" +
                        " and p.idempleado = e.idempleado" +
                        " and em.idempresa="+idempresa+"" +
                        " and p.fecha >= '"+f1+"'" +
                        " and p.fecha <= '"+f2+"'";  
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet			
                        uno=dos;
                        uno.addColumn("Nombre");
                        uno.addColumn("Fecha");
                        uno.addColumn("Horas Trabajadas");
                        uno.addColumn("ID");
                        uno.addColumn("idSocio");
                        while(resultado.next()){
                            for(int i=0; i<uno.getColumnCount()+2;i++){
                                if(i==0){
                                    filas[i]= resultado.getObject(i+1).toString()+" "+resultado.getObject(i+2).toString()
                                            +" "+resultado.getObject(i+3).toString();
                                }
                                if(i>2){
                                    filas[i-2]= resultado.getObject(i+1);
                                }
                            }
                            uno.addRow(filas);
                        }
                        filas1[2]=totalmensualempresa(idempresa,f1,f2);
                        uno.addRow(filas1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return uno;
	}
      public DefaultComboBoxModel obtenersocios() throws SQLException{
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		ResultSet resultado;
		String 	query="";
		try {	//crea el objeto statement que permitira ejecutar el query		
			
			query="select iniciales,idjefe"
					+" from jefe"
			 	+" where idjefe is not null";//esta condicion se agrega para incluir siempre el where, ya que los otros valore
                        query+=" and activo = 1";
			resultado=st.executeQuery(query);//ejecuta el query y el resultado lo asigna al objeto resultado del tipo ResultSet
			modelo.addElement("- - -");
                        while (resultado.next()) {
                                modelo.addElement(resultado.getObject(1).toString().concat(" Id ")+resultado.getObject(2).toString());
                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally{
			if(st!=null){
                            st.close();
                        }
		}*/
                return modelo;
	}
}
      


