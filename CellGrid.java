
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
        init();
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
    
    public void init()
    {
        try
        {
            this.getSingleCells()[2][1].setAlive();
            this.getSingleCells()[2][2].setAlive();
            this.getSingleCells()[1][1].setAlive();
            this.getSingleCells()[1][2].setAlive();
            
            this.getSingleCells()[8][2].setAlive();
            this.getSingleCells()[8][1].setAlive();
            this.getSingleCells()[9][2].setAlive();
            this.getSingleCells()[9][1].setAlive();

            this.getSingleCells()[5][5].setAlive();
            this.getSingleCells()[5][6].setAlive();
            this.getSingleCells()[6][5].setAlive();
            this.getSingleCells()[6][6].setAlive();

            
            this.getSingleCells()[2][8].setAlive();
            this.getSingleCells()[2][9].setAlive();
            this.getSingleCells()[1][8].setAlive();
            this.getSingleCells()[1][9].setAlive();	

            this.getSingleCells()[9][9].setAlive();
            this.getSingleCells()[8][9].setAlive();
            this.getSingleCells()[8][8].setAlive();
            this.getSingleCells()[9][8].setAlive();
            
            this.getSingleCells()[4][3].setAlive();
            this.getSingleCells()[3][4].setAlive();
            
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
