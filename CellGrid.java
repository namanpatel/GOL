
public class CellGrid {
    private int n_rows;
    private int n_columns;
	private SingleCell[][] cells;

	public CellGrid()
	{
		
	}
	public CellGrid(int columns, int rows)
	{
		n_rows = rows;
		n_columns = columns;
		cells = new SingleCell[n_columns][n_rows];
        for(int loop_row = 0; loop_row < n_rows; loop_row++)
        {
            for (int loop_column=0; loop_column< n_rows; loop_column++)
            {
                cells[loop_column][loop_row] = new SingleCell(loop_column,loop_row);
            }
        }		
	}
	public int getColumns()
	{
		return n_columns;
	}
	public void setColumns(int column)
	{
		n_columns = column;
	}
	public int getRows()
	{
		return n_rows;
	}
	public void setRows(int row)
	{
		n_rows = row;
	}
    public SingleCell[][] getSingleCells() {
        return cells;
    }

    public boolean deadGrid(int columns, int rows)
    {
        for(int r = 0; r < rows; r++)
        {
            for (int c=0; c< columns; c++)
            {
                if (cells[c][r].isAlive())
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int countNeighboursAlive(SingleCell cell)
    {
    	int countAlive = 0;
    	int xPoint = cell.getCurrentRow();
    	int yPoint = cell.getCurrentColumn();
    	
        if (xPoint > 0 && xPoint+1 < this.getColumns())
        {
            if (yPoint > 0 && yPoint+1 < this.getRows())
            {
                if (this.getSingleCells()[xPoint-1][yPoint+1].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint-1][yPoint-1].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint-1][yPoint].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint+1][yPoint+1].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint+1][yPoint-1].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint+1][yPoint].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint][yPoint+1].isAlive())
                {
                    countAlive++;
                }
                if (this.getSingleCells()[xPoint][yPoint-1].isAlive())
                {
                    countAlive++;
                }            	
            }
        }
    	return countAlive;
    }
}
