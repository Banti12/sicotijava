package zesatic;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class RenderCelda extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) 
    {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(row %2 ==0){
            cell.setBackground(Color.white);
            if(column==5){
                if( value instanceof Integer )
                {
                    Integer amount = (Integer) value;
                    if( amount <= 5 )
                    {
                        cell.setForeground(Color.RED);
                        
                    }else{

                        cell.setForeground(Color.BLACK);
                    }
               }
            }else{
                    cell.setForeground(Color.BLACK);
                }
        }else{
            cell.setBackground(new Color(234,234,234));
            if(column==5){
                if( value instanceof Integer )
                {
                    Integer amount = (Integer) value;
                    if( amount <= 5 )
                    {
                        cell.setForeground(Color.RED);
                    }else{

                        cell.setForeground(Color.BLACK);
                     }
               }
            }else{
                    cell.setForeground(Color.BLACK);
                }
        }
        return cell;
    }
}