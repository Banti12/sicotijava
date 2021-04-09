/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecxel;

import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import zesatic.conectar;

/**
 *
 * @author Brayan
 */
public class Excel {
    conectar dentro;
    String ruta;
    String [] errores ;
    String [] erroressalida;
    boolean si;
    CellStyle estilo;
    org.apache.poi.ss.usermodel.Font fuente;
    public Excel(){
        si=false;
    }
    public Excel(String ruta){
        dentro = new conectar();
        this.ruta=ruta;
        errores = new String [0];
        erroressalida=new String [0];
        si=false;
    }
    public void imprimir(String [] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public String [] errores() 
    {
        String [] h= new String [0];
        if(!vacio(errores)){
            return erroressalida;         
        }else{
            return h;
        }
        
    }
    
    public boolean vacio(String []a){
        int contador = 0;
        boolean si=true;
        for(int i=0; i<a.length;i++){
            if(a[i] ==null || a[i]==""){
                contador++;
            }else{
                break;
            }
        }
        if(contador==a.length){
            si=true;
        }else{
            si=false;
        }
        return si;
    }
    public void crearEcxel(){
        Workbook libro = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet hoja= libro.createSheet("Hola Banti");
        FileOutputStream archivo = null;
        try {
            archivo = new FileOutputStream("Ecxel.xls");
            libro.write(archivo);
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void crearEcxeldos(){
        Workbook libros = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet hoja=libros.createSheet("Hola banti");
        FileOutputStream archivo = null;
        try {
            archivo = new FileOutputStream("Ecxeldos.xlsx");
            libros.write(archivo);
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void leer() throws IOException{
        
        try {
            FileInputStream file = new FileInputStream(new File(ruta));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet hoja = wb.getSheetAt(0);
            for (int i=0 ;i<=hoja.getLastRowNum();i++){
                Row fila= hoja.getRow(i);
                for (int j =0; j<fila.getLastCellNum();j++){
                    if(fila.getCell(j)!=null){
                        Cell celda = fila.getCell(j);
                        switch(celda.getCellTypeEnum().toString()){
                            case("NUMERIC"):
                                System.out.print(fila.getCell(j).getNumericCellValue()+" ");
                                break;
                            case("FORMULA"):
                                System.out.print(fila.getCell(j).getNumericCellValue()+" ");
                                break;
                            case("STRING"):
                                System.out.print(fila.getCell(j).getStringCellValue()+" ");
                                break;   
                        }
                        
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
    public String [][] leer1() throws IOException{
        String matriz [][]= new String [32][7];
        try {
            FileInputStream file = new FileInputStream(new File(ruta));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet hoja = wb.getSheetAt(0);
            
            for (int i=0 ;i<=hoja.getLastRowNum();i++){
                Row fila= hoja.getRow(i);
                for (int j =0; j<fila.getLastCellNum();j++){
                    if(fila.getCell(j)!=null){
                        Cell celda = fila.getCell(j);
                        switch(celda.getCellTypeEnum().toString()){
                            case("NUMERIC"):
                                matriz[i][j]=Integer.toString((int) fila.getCell(j).getNumericCellValue());
                                System.out.println(matriz[i][j]);
                                break;                           
                            case("STRING"):
                                matriz[i][j]=fila.getCell(j).getStringCellValue();
                                System.out.println(matriz[i][j]);
                                break;   
                        }
                        
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return matriz;
}
    public String [][] leer2() throws IOException{
        String matriz [][]= new String [56][1];
        try {
            FileInputStream file = new FileInputStream(new File(ruta));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet hoja = wb.getSheetAt(0);
            
            for (int i=0 ;i<=hoja.getLastRowNum();i++){
                Row fila= hoja.getRow(i);
                for (int j =0; j<fila.getLastCellNum();j++){
                    if(fila.getCell(j)!=null){
                        Cell celda = fila.getCell(j);
                        switch(celda.getCellTypeEnum().toString()){
                            case("NUMERIC"):
                                matriz[i][j]=Integer.toString((int) fila.getCell(j).getNumericCellValue());
                                System.out.println(matriz[i][j]);
                                break;                           
                            case("STRING"):
                                matriz[i][j]=fila.getCell(j).getStringCellValue();
                                System.out.println(matriz[i][j]);
                                break;   
                        }
                        
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return matriz;
}
    public String [][] leer3() throws IOException{
        String matriz [][]= new String [859][5];
        try {
            FileInputStream file = new FileInputStream(new File(ruta));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet hoja = wb.getSheetAt(0);
            
            for (int i=0 ;i<859;i++){
                Row fila= hoja.getRow(i);
                for (int j=0; j<5;j++){
                    if(fila.getCell(j)!=null){
                        Cell celda = fila.getCell(j);
                        switch(celda.getCellTypeEnum().toString()){
                            case("NUMERIC"):
                                matriz[i][j]=Integer.toString((int) fila.getCell(j).getNumericCellValue());
                                System.out.println(matriz[i][j]);
                                break;                           
                            case("STRING"):
                                matriz[i][j]=fila.getCell(j).getStringCellValue().toString();
                                System.out.println(matriz[i][j]);
                                break;   
                        }
                        
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return matriz;
}
    public boolean leerbd() throws IOException{
        boolean p1=false;
        boolean p2=false;
        boolean p3=false;
        
        try {
            FileInputStream file = new FileInputStream(new File(ruta));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet hoja = wb.getSheetAt(0);
            Row fila1=hoja.getRow(0);
            Row fila2=hoja.getRow(2); 
            String llave="";
            errores = new String[hoja.getLastRowNum()];
            Cell celda0 = null;
            Cell celda1 = null;
            Cell celda2 = null;
            if(hoja.getLastRowNum()>1){
                celda0 = fila1.getCell(0);
                celda1 = fila1.getCell(2);
                celda2 = fila2.getCell(2);
                llave=checador(celda0.getCellTypeEnum().toString(),0,fila1);
            }else{
                llave="";
            }
            if(llave.indexOf("REPORTE DE TIEMPO MENSUAL:")!=-1)
            {
                
                String fecha=checador(celda1.getCellTypeEnum().toString(),2,fila1);
                String idempleado=checador(celda2.getCellTypeEnum().toString(),2,fila2);
                fila1=hoja.getRow(1);
                celda1=fila1.getCell(2);
                String empleado=checador(celda1.getCellTypeEnum().toString(),2,fila1);
                try {
                    if(dentro.buscarempleado(idempleado,empleado))
                    {
                        for (int i=4 ;i<=hoja.getLastRowNum();i++){
                            Row fila= hoja.getRow(i);
                            if(p1 == false){
                                if(!fila.getCell(0).equals(null)){
                                    Cell celda = fila.getCell(0);
                                    String info=checador(celda.getCellTypeEnum().toString().trim(),0,fila);
                                    if(!info.equals("0")&& !info.equals("")){
                                        if(!info.equals("TOTAL CARGABLE")){
                                            String servicio =checador(celda.getCellTypeEnum().toString(),0,fila);
                                            String nombreempresa =checador(celda.getCellTypeEnum().toString(),1,fila);
                                            try {
                                                String idempresa=dentro.buscaidempresa(nombreempresa.trim());
                                                String idservicio=dentro.buscaidservicio(servicio.trim());
                                                if(!idservicio.equals(null) && !idservicio.equals("")){
                                                    if(!idempresa.equals(null) && !idempresa.equals("")){ 
                                                        String idproyecto=dentro.buscaidproyecto(idempresa,idservicio); 
                                                        if(!idproyecto.equals(null) && !idproyecto.equals("")){
                                                            for (int j =2; j<33;j++){
                                                                Cell celda3 = fila.getCell(j);
                                                                if(celda3!=null){
                                                                    String ht=checador(celda3.getCellTypeEnum().toString(),j,fila);
                                                                    if(!ht.equals("")&& !ht.equals(null)&&!ht.equals(" ")){
                                                                        if(j<11){
                                                                            String num="-0"+Integer.toString(j-1);
                                                                            String fechaf=fecha.concat(num);
                                                                            dentro.insertarpe(idproyecto, idempleado, ht, fechaf);
                                                                        }else{
                                                                            String num="-"+Integer.toString(j-1);
                                                                            String fechaf=fecha.concat(num);
                                                                            dentro.insertarpe(idproyecto, idempleado, ht, fechaf);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }else{
                                                            errores[i]=" Ejercicio no iniciado con "+nombreempresa+" Fila: "+Integer.toString(i+1)+"\n";
                                                        }
                                                    }else{
                                                        errores[i]="No existe el cliente "+nombreempresa+" Fila: "+Integer.toString(i+1)+"\n";
                                                    }
                                                }else{
                                                    errores[i]="No existe el servicio "+ servicio+" Fila: "+Integer.toString(i+1)+"\n";
                                                }
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }else{
                                            p1=true;
                                            fila= hoja.getRow(i+1);
                                            i++;
                                        }
                                    }
                                }
                            }
                            if(p1==true && p2==false){
                                if(!fila.getCell(0).equals(null)){
                                    Cell celda = fila.getCell(0);
                                    
                                    String info=checador(celda.getCellTypeEnum().toString(),0,fila);
                                    if(!info.equals("0")&& !info.equals("")){
                                        if(!info.equals("TOTAL NO CARGABLE")){
                                            String hnc =checador(celda.getCellTypeEnum().toString(),0,fila);
                                            try {
                                                String idhnc=dentro.buscaidhnc(hnc);
                                                if(!idhnc.equals(null)&& !idhnc.equals(""))
                                                {
                                                    for (int j =2; j<33;j++){
                                                        Cell celda3 = fila.getCell(j);
                                                        if(celda3!=null){
                                                            String horas=checador(celda3.getCellTypeEnum().toString(),j,fila);
                                                            
                                                            if(!horas.equals("")&& !horas.equals(null)&&!horas.equals(" ")){
                                                                if(j<11){
                                                                    String num="-0"+Integer.toString(j-1);
                                                                    String fechaf=fecha.concat(num);
                                                                    dentro.insertarhnce(idempleado, idhnc, horas, fechaf);                                               
                                                                }else{
                                                                    String num="-"+Integer.toString(j-1);
                                                                    String fechaf=fecha.concat(num);
                                                                    dentro.insertarhnce(idempleado, idhnc, horas, fechaf); 
                                                                }
                                                            }
                                                        }   
                                                    }
                                                }else
                                                {
                                                    errores[i]=hnc+" Fila: "+Integer.toString(i+1)+"\n";
                                                }
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }else{
                                            p2=true;
                                            fila= hoja.getRow(i+5);
                                            i+=5;
                                        }
                                    }
                                }
                            }
                            if(p1==true && p2==true && p3==false){
                                if(!fila.getCell(0).equals(null)){
                                    Cell celda = fila.getCell(0);
                                    String info=checador(celda.getCellTypeEnum().toString(),0,fila);
                                    if(!info.equals("0")&& !info.equals("")){
                                        if(!info.equals("EXPLICACIONES")){
                                            Cell celda4 = fila.getCell(2);
                                            String hnc =checador(celda4.getCellTypeEnum().toString(),2,fila);
                                            try {
                                                String idhnc=dentro.buscaidhnc(hnc);
                                                
                                                if(!idhnc.equals("0")&& !idhnc.equals("")&& idhnc!=null){
                                                    Cell celda3 = fila.getCell(1);
                                                    if(celda3!=null){
                                                        String motivo=checador(celda3.getCellTypeEnum().toString(),1,fila);
                                                        if(Integer.parseInt(info)<10){
                                                            String num="-0"+info;
                                                            String fechaf=fecha.concat(num);
                                                            dentro.updatehnce(motivo, idhnc, fechaf, idempleado);
                                                        }else{
                                                            String num="-"+info;
                                                            String fechaf=fecha.concat(num);
                                                            dentro.updatehnce(motivo, idhnc, fechaf, idempleado);
                                                        }
                                                        
                                                    }
                                                } else
                                                {
                                                    errores[i]=hnc+" Fila: "+Integer.toString(i+1)+"\n";
                                                }
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }else{
                                            p3=true;
                                            
                                        }
                                    }
                                }
                            }
                            if(p1&&p2&&p3){
                                if(!vacio(errores)){
                                    int contador=0;
                                    for(int z=0; z<errores.length;z++){
                                        if(errores[z]!=null && errores[z]!=""){
                                            contador++;
                                        }
                                    }
                                    erroressalida = new String [contador];
                                    contador=0;
                                    for(int z=0; z<errores.length;z++){
                                        if(errores[z] != null && errores[z] !=""){
                                            erroressalida[contador]=errores[z];
                                            contador++;
                                        }
                                    }
                                    
                                }
                                
                                break;
                            }
                        }
                    }else
                    {   
                        errores[0]="No existe el empledo "+empleado+" con el id: " + idempleado;
                        if(!vacio(errores)){
                                    int contador=0;
                                    for(int z=0; z<errores.length;z++){
                                        if(errores[z]!=null && errores[z]!=""){
                                            contador++;
                                        }
                                    }
                                    erroressalida = new String [contador];
                                    contador=0;
                                    for(int z=0; z<errores.length;z++){
                                        if(errores[z] != null && errores[z] !=""){
                                            erroressalida[contador]=errores[z];
                                            contador++;
                                        }
                                    }
                                    
                                }
                        p3=true;
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        dentro.desconectar();
        return p3;
    
}
    public  void escribir() throws IOException{
        
        try {
            FileInputStream file = new FileInputStream(new File(ruta));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet hoja = wb.getSheetAt(0);
            XSSFRow fila= hoja.getRow(0);
            XSSFCell celda= fila.getCell(0);
            if (fila==null){
                fila = hoja.createRow(0);
            }
            if(celda==null){
                celda = fila.createCell(0);
            }
            
            for (int i=0 ;i<=hoja.getLastRowNum();i++){
                fila=hoja.getRow(i);
                if (fila==null){
                    fila = hoja.createRow(i);
                    
                }
                for (int j =0; j<fila.getLastCellNum();j++){
                    celda= fila.getCell(j);
                    if(celda==null){
                        celda = fila.createCell(j);
                    }
                    if(fila.getCell(j)!=null){
                        checador(celda.getCellTypeEnum().toString(),j,fila);
   
                    }
                }
            }
            file.close();
            FileOutputStream output = new FileOutputStream(ruta);
            wb.write(output);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    public String checador(String celda, int j,Row fila){
       String b="";
         switch(celda){
                             case("NUMERIC"):
                                b=Integer.toString((int)fila.getCell(j).getNumericCellValue());
                                break;
                            case("FORMULA"):
                                b=Integer.toString((int)fila.getCell(j).getNumericCellValue());
                                break;
                            case("STRING"):
                                b=fila.getCell(j).getStringCellValue();
                                break;   
                        }
         return b;
    }
  public boolean exportarExcel2(JTable t,JTable t2, JFrame frame,String nombreJefe,String periodo,String idjefe) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile().getName().indexOf(".xls")!=-1 
            || chooser.getSelectedFile().getName().indexOf(".xlsx")!=-1){                
                ruta=chooser.getSelectedFile().getAbsolutePath();
            }else{
                ruta = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("1");
                Row fila1=hoja.createRow(0);
                Cell celda1=fila1.createCell(0);
                celda1.setCellValue("REPORTE DE TIEMPO");
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(1);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue(periodo);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(2);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("Socio " + nombreJefe);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(3);
                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                for (int f = 4; f < t.getRowCount()+4; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) 
                    {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == 4) 
                        {   
                            font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 5;
                
                for (int f = 0; f < t.getRowCount(); f++) {
                    font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.LEFT,false);
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if(c>1){                           
                            if(t.getValueAt(f, c)!=null)
                            {
                                font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            }
                        }else{
                            if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                if(t.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            } 
                        }
                        if(f == t.getRowCount()-1){
                            if(c==0 || c==1)
                            {
                                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                                celda.setCellStyle(estilo);
                            }else{
                                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.RIGHT,true);
                                celda.setCellStyle(estilo);
                            }
                        }
                    }
                }
                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.RIGHT,false);
                filaInicio++;
                int segunda=filaInicio++;
                segunda++;
                for (int f = filaInicio; f < t2.getRowCount()+filaInicio; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == filaInicio) {
                            celda.setCellValue(t2.getColumnName(c));
                        }
                    }
                }
                filaInicio++;
                
                for (int f = 0; f < t2.getRowCount(); f++) {
                    font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.LEFT,false);
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if(c>=1){
                             if(t2.getValueAt(f, c)!=null)
                             {
                                font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                                celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                             }
                        }else{
                            if (t2.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                            } else if (t2.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t2.getValueAt(f, c)));
                            } else {
                                if(t2.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t2.getValueAt(f, c)));
                            }
                          
                        }
                        if(f == t2.getRowCount()-1){
                            if(c==0)
                            {
                                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                                celda.setCellStyle(estilo);
                            }else{
                                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.RIGHT,true);
                                celda.setCellStyle(estilo);
                            }
                            }
                    }
                }           
                hoja.autoSizeColumn(0);
                for (int i = 1; i < t.getRowCount(); i++) {
                    hoja.autoSizeColumn(i);
                }
                hoja.addMergedRegion(new CellRangeAddress(1,1,0,t.getRowCount()+1));
                hoja.addMergedRegion(new CellRangeAddress(0,0,0,t.getRowCount()+1));
                hoja.addMergedRegion(new CellRangeAddress(2,2,0,t.getRowCount()+1));
                //hoja.addMergedRegion(new CellRangeAddress(4,4,1,4));
                //hoja.addMergedRegion(new CellRangeAddress(segunda,segunda,1,3));
                libro.write(archivo);
                frame.dispose();
                archivo.close();
                si=true;
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
        return si;
    }
    public boolean exportarExcel3(JTable t,JTable t2, JFrame frame,String nombre,String periodo,String id) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        String[] fechas = periodo.split(" ");
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile().getName().indexOf(".xls")!=-1 
            || chooser.getSelectedFile().getName().indexOf(".xlsx")!=-1){                
                ruta=chooser.getSelectedFile().getAbsolutePath();
            }else{
                ruta = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.RIGHT,false);
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("1");
                Row fila1=hoja.createRow(0);
                Cell celda1=fila1.createCell(0);
                celda1.setCellValue("REPORTE DE TIEMPO MENSUAL:");
                celda1.setCellStyle(estilo);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.LEFT,false);
                celda1=fila1.createCell(1);
                celda1.setCellValue(periodo);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(1);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.RIGHT,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("Nombre:");
                celda1.setCellStyle(estilo);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.LEFT,false);
                celda1=fila1.createCell(1);
                celda1.setCellValue(nombre);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(2);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.RIGHT,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("ID:");
                celda1.setCellStyle(estilo);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.LEFT,true);
                celda1=fila1.createCell(1);
                celda1.setCellValue(id);
                celda1.setCellStyle(estilo);
                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.LEFT,false);
                for (int f = 4; f < t.getRowCount()+4; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == 4) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 5;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if(c>=2){
                             if(t.getValueAt(f, c)!=null)
                           celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        }else{
                            if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                 if(t.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                            if(f == t.getRowCount()-1){
                                font(true,"Times New Roman",(short)11,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                            }
                        }   
                    }
                }
                filaInicio++;
                
                
                int segunda=filaInicio++;
                segunda++;
                for (int f = filaInicio; f < t2.getRowCount()+filaInicio; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == filaInicio) {
                            celda.setCellValue(t2.getColumnName(c));
                        }
                    }
                }
                filaInicio++;
                for (int f = 0; f < t2.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if(c>=2){
                             if(t2.getValueAt(f, c)!=null)
                           celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                        }else{
                            if (t2.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                            } else if (t2.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t2.getValueAt(f, c)));
                            } else {
                                 if(t2.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t2.getValueAt(f, c)));
                            }
                            if(f == t2.getRowCount()-1){
                                font(true,"Times New Roman",(short)11,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                            }
                        }   
                    }
                }
                filaInicio++;
                hoja.autoSizeColumn(0);
                hoja.addMergedRegion(new CellRangeAddress(1,1,1,15));
                hoja.addMergedRegion(new CellRangeAddress(0,0,1,15));
                hoja.addMergedRegion(new CellRangeAddress(2,2,1,15));
                for (int i = 1; i < t.getRowCount(); i++) {
                    hoja.autoSizeColumn(i);
                }
                //hoja.addMergedRegion(new CellRangeAddress(4,4,1,4));
                //hoja.addMergedRegion(new CellRangeAddress(segunda,segunda,1,3));
                libro.write(archivo);
                frame.dispose();
                archivo.close();
                si=true;
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
        return si;
    }
     public boolean exportarExcel(JTable t,JTable t2, JFrame frame,String nombre,String periodo,String id, String periodo1) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        String[] fechas = periodo1.split(" ");
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile().getName().indexOf(".xls")!=-1 
            || chooser.getSelectedFile().getName().indexOf(".xlsx")!=-1){                
                ruta=chooser.getSelectedFile().getAbsolutePath();
            }else{
                ruta = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("1");
                Row fila1=hoja.createRow(0);
                Cell celda1=fila1.createCell(0);
                celda1.setCellValue("REPORTE DE TIEMPO");
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(1);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue(periodo);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(2);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("Colaborador " + nombre);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(3);
                
                for (int f = 4; f < t.getRowCount()+4; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 4) 
                        {   
                            font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                            celda.setCellStyle(estilo);
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 5;
                for (int f = 0; f < t.getRowCount()-1; f++) 
                {
                    font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.LEFT,false);
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount()+1; c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if(c==0){
                            if (t.getValueAt(f, c) instanceof Double) {
                                font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                        }else if(c==1){
                               if (t.getValueAt(f, c) instanceof Double) {
                               
                                font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }                    
                        }else if(c==3){
                            font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                            celda.setCellStyle(estilo);
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c-1).toString()));                         
                        }else{
                            celda.setCellValue("");
                        }
                    }
                }
                
                try {
                    dentro= new conectar();                  
                    Row fila2=hoja.createRow(filaInicio);
                    Cell celda2=fila2.createCell(0);                    
                    celda2.setCellValue("");
                    celda2 = fila2.createCell(1);                   
                    celda2.setCellValue("");
                    celda2 = fila2.createCell(2);
                    font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                    celda2.setCellStyle(estilo);
                    celda2.setCellValue("Total");
                    celda2 = fila2.createCell(3);
                    font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.RIGHT,true);
                    celda2.setCellStyle(estilo);
                    
                    celda2.setCellValue((double)dentro.horastotalcargable(id, fechas[0], fechas[2]));
                    dentro.desconectar();
                } catch (SQLException ex) {
                    Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                }
                filaInicio++;
                int segunda=filaInicio++;
                segunda++;
                for (int f = filaInicio; f < t2.getRowCount()+filaInicio; f++) {
                    font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == filaInicio) {
                            celda.setCellValue(t2.getColumnName(c));
                        }
                    }
                }
                filaInicio++;
                for (int f = 0; f < t2.getRowCount()-1; f++) {
                    font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.LEFT,false);
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t2.getColumnCount()+1; c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        System.out.println();
                        if(c==0){
                            if (t2.getValueAt(f, c) instanceof Double) {
                                celda.setCellStyle(estilo);
                                celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                                 System.out.println(t2.getValueAt(f, c).toString());
                            } else if (t2.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t2.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(t2.getValueAt(f, c)));
                            }
                        }else if(c==2){
                            font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                            celda.setCellStyle(estilo);
                            celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c-1).toString()));                         
                        }else if(c==3){
                            font(false,"Times New Roman",(short)10,libro,HorizontalAlignment.RIGHT,false);
                            celda.setCellStyle(estilo);
                            celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c-1).toString()));                         
                        }else{
                            celda.setCellValue("");
                        }
                    }
                }
                try {
                    dentro= new conectar();                  
                    Row fila2=hoja.createRow(filaInicio);
                    Cell celda2=fila2.createCell(0);
                    celda2.setCellValue("");
                    celda2 = fila2.createCell(1);
                    font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                    celda2.setCellStyle(estilo);
                    celda2.setCellValue("Total");
                    celda2 = fila2.createCell(2);
                    font(false,"Times New Roman",(short)12,libro,HorizontalAlignment.RIGHT,true);
                    celda2.setCellStyle(estilo);
                    celda2.setCellValue((double)dentro.horastotalnocargable(id, fechas[0], fechas[2]));
                    dentro.desconectar();
                } catch (SQLException ex) {
                    Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                hoja.addMergedRegion(new CellRangeAddress(1,1,0,t.getRowCount()+2));
                hoja.addMergedRegion(new CellRangeAddress(0,0,0,t.getRowCount()+2));
                hoja.addMergedRegion(new CellRangeAddress(2,2,0,t.getRowCount()+2));
                hoja.addMergedRegion(new CellRangeAddress(4,4,2,4));
                hoja.addMergedRegion(new CellRangeAddress(segunda,segunda,1,3));
                
                hoja.autoSizeColumn(0);
                 hoja.autoSizeColumn(1);
                libro.write(archivo);
                frame.dispose();
                archivo.close();
                si=true;
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
        return si;
    }
     public boolean exportarExcel3(JTable t,JFrame frame,String nombreEmpresa,String periodo,String idempresa) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile().getName().indexOf(".xls")!=-1 
            || chooser.getSelectedFile().getName().indexOf(".xlsx")!=-1){                
                ruta=chooser.getSelectedFile().getAbsolutePath();
            }else{
                ruta = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("1");
                Row fila1=hoja.createRow(0);
                Cell celda1=fila1.createCell(0);
                celda1.setCellValue("REPORTE DE TIEMPO");
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(1);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue(periodo);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(2);
                font(true,"Times New Roman",(short)14,libro,HorizontalAlignment.CENTER,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("Cliente " + nombreEmpresa);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(3);
                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.LEFT,false);
                for (int f = 4; f < t.getRowCount()+4; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == 4) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 5;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if(c>=3){
                             if(t.getValueAt(f, c)!=null)
                           celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        }else{
                            if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                 if(t.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                        }
                        if(f == t.getRowCount()-1){
                            if(c==0 || c==1)
                            {
                                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.CENTER,false);
                                celda.setCellStyle(estilo);
                            }else{
                                font(true,"Times New Roman",(short)12,libro,HorizontalAlignment.RIGHT,true);
                                celda.setCellStyle(estilo);
                            }
                        }
                    }
                }
                hoja.autoSizeColumn(0);
                hoja.addMergedRegion(new CellRangeAddress(1,1,0,t.getRowCount()+2));
                hoja.addMergedRegion(new CellRangeAddress(0,0,0,t.getRowCount()+2));
                hoja.addMergedRegion(new CellRangeAddress(2,2,0,t.getRowCount()+2));
                for (int i = 1; i <= t.getRowCount(); i++) {
                    hoja.autoSizeColumn(i);
                }
                //hoja.addMergedRegion(new CellRangeAddress(4,4,1,4));
                //hoja.addMergedRegion(new CellRangeAddress(segunda,segunda,1,3));
                libro.write(archivo);
                frame.dispose();
                archivo.close();
                si=true;
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
        return si;
    }
     public boolean exportarExcel4(JTable t,JFrame frame,String nombreEmpresa,String periodo,String idempresa) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile().getName().indexOf(".xls")!=-1 
            || chooser.getSelectedFile().getName().indexOf(".xlsx")!=-1){                
                ruta=chooser.getSelectedFile().getAbsolutePath();
            }else{
                ruta = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                font(true,"Arial",(short)14,libro,HorizontalAlignment.RIGHT,false);
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("1");
                Row fila1=hoja.createRow(0);
                Cell celda1=fila1.createCell(0);
                celda1.setCellValue("REPORTE DE TIEMPO MENSUAL:");
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.LEFT,false);
                celda1=fila1.createCell(1);
                celda1.setCellValue(periodo);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(1);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.RIGHT,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("Empresa:");
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.LEFT,false);
                celda1=fila1.createCell(1);
                celda1.setCellValue(nombreEmpresa);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(2);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.RIGHT,true);
                celda1=fila1.createCell(0);
                celda1.setCellValue("ID:");
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.LEFT,true);
                celda1=fila1.createCell(1);
                celda1.setCellValue(idempresa);
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)12,libro,HorizontalAlignment.LEFT,false);
                for (int f = 4; f < t.getRowCount()+4; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == 4) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 5;
                boolean si=false;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                           Cell celda = fila.createCell(c);
                            if(c>=2){
                               if(t.getValueAt(f, c)!=null) 
                                    celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            }else{
                                if (t.getValueAt(f, c) instanceof Double) {
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                                } else if (t.getValueAt(f, c) instanceof Float) {
                                    celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                                } else {
                                    if(t.getValueAt(f, c)!=null)
                                    celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                                }
                            
                           }
                             if(f == t.getRowCount()-1){
                                font(true,"Arial",(short)11,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                            }
                    }
                }
                hoja.autoSizeColumn(0);
                hoja.addMergedRegion(new CellRangeAddress(1,1,1,30));
                hoja.addMergedRegion(new CellRangeAddress(0,0,1,30));
                hoja.addMergedRegion(new CellRangeAddress(2,2,1,30));
                for (int i = 1; i <= t.getRowCount(); i++) {
                    hoja.autoSizeColumn(i);
                }
                //hoja.addMergedRegion(new CellRangeAddress(4,4,1,4));
                //hoja.addMergedRegion(new CellRangeAddress(segunda,segunda,1,3));
                libro.write(archivo);
                frame.dispose();
                archivo.close();
                si=true;
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
        return si;
    }
    public void font(boolean negrita,String letra,short corto,Workbook libro,HorizontalAlignment direccion,boolean raya){
                estilo = libro.createCellStyle();
                estilo.setAlignment(direccion);
                if(raya){
                    estilo.setBorderBottom(BorderStyle.DOUBLE);
                    estilo.setBorderTop(BorderStyle.THIN);
                }
                fuente=libro.createFont();
                fuente.setFontHeightInPoints(corto);
                fuente.setBold(negrita);
                fuente.setFontName(letra);
                estilo.setFont(fuente);
                
    }
    public boolean exportarExcel7(JTable t,JTable t2, JFrame frame,String nombreJefe,String periodo,String idjefe) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile().getName().indexOf(".xls")!=-1 
            || chooser.getSelectedFile().getName().indexOf(".xlsx")!=-1){                
                ruta=chooser.getSelectedFile().getAbsolutePath();
            }else{
                ruta = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                font(true,"Arial",(short)14,libro,HorizontalAlignment.RIGHT,false);
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("1");
                Row fila1=hoja.createRow(0);
                Cell celda1=fila1.createCell(0);
                celda1.setCellValue("REPORTE DE TIEMPO MENSUAL:");
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.LEFT,false);
                celda1=fila1.createCell(1);
                celda1.setCellValue(periodo);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(1);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.RIGHT,false);
                celda1=fila1.createCell(0);
                celda1.setCellValue("Jefe:");
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.LEFT,false);
                celda1=fila1.createCell(1);
                celda1.setCellValue(nombreJefe);
                celda1.setCellStyle(estilo);
                fila1=hoja.createRow(2);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.RIGHT,true);
                celda1=fila1.createCell(0);
                celda1.setCellValue("ID:");
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)14,libro,HorizontalAlignment.LEFT,true);
                celda1=fila1.createCell(1);
                celda1.setCellValue(idjefe);
                celda1.setCellStyle(estilo);
                font(true,"Arial",(short)12,libro,HorizontalAlignment.LEFT,false);
                for (int f = 4; f < t.getRowCount()+4; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == 4) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 5;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if(c>=1){
                            if(t.getValueAt(f, c)!=null)
                           celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        }else{
                            if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                if(t.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            } 
                        }
                        if(f == t.getRowCount()-1){
                                font(true,"Arial",(short)12,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                        }
                    }
                }
                
                filaInicio++;
                int segunda=filaInicio++;
                segunda++;
                for (int f = filaInicio; f < t2.getRowCount()+filaInicio; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellStyle(estilo);
                        if (f == filaInicio) {
                            celda.setCellValue(t2.getColumnName(c));
                        }
                    }
                }
                filaInicio++;
                for (int f = 0; f < t2.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if(c>=1){
                             if(t2.getValueAt(f, c)!=null)
                           celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                        }else{
                            if (t2.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                            } else if (t2.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t2.getValueAt(f, c)));
                            } else {
                                if(t2.getValueAt(f, c)!=null)
                                celda.setCellValue(String.valueOf(t2.getValueAt(f, c)));
                            }
                          
                        }
                        if(f == t2.getRowCount()-1){
                                font(true,"Arial",(short)12,libro,HorizontalAlignment.RIGHT,false);
                                celda.setCellStyle(estilo);
                            }
                    }
                }           
                hoja.autoSizeColumn(0);
                hoja.addMergedRegion(new CellRangeAddress(1,1,1,30));
                hoja.addMergedRegion(new CellRangeAddress(0,0,1,30));
                hoja.addMergedRegion(new CellRangeAddress(2,2,1,30));
                for (int i = 1; i < t.getRowCount(); i++) {
                    hoja.autoSizeColumn(i);
                }
                //hoja.addMergedRegion(new CellRangeAddress(4,4,1,4));
                //hoja.addMergedRegion(new CellRangeAddress(segunda,segunda,1,3));
                libro.write(archivo);
                frame.dispose();
                archivo.close();
                si=true;
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
        return si;
    }
}
