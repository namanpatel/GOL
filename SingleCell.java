import javax.swing.*;
import java.awt.Color;

public class SingleCell extends JPanel {
	private boolean isAlive;
	private int colNum;
	private int rowNum;
	
	public SingleCell()
	{
		isAlive = false;
		rowNum = 0;
		colNum = 0;
        this.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));		
	}
	
	public SingleCell(int column, int row)
	{
		isAlive = false;
		rowNum = row;
		colNum = column;
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        this.setBackground(Color.WHITE);
	}
	
	public int getCurrentRow()
	{
		return rowNum;
	}
	public int getCurrentColumn()
	{
		return colNum;
	}
	public void setCurrentColumn(int col)
	{
		colNum = col;
	}
	public void setCurrentRow(int row)
	{
		rowNum = row;
	}
	public void setAlive()
	{
		isAlive = true;
        this.setBackground(Color.GREEN);
	}
	public void dies()
	{
		isAlive = false;
        this.setBackground(Color.WHITE);
	}
	public boolean isAlive()
	{
		return this.isAlive;
	}
}
