// import swing and awt
import javax.swing.*;
import java.awt.*;


public class RulesOfLife extends JFrame {
	/* Total number of columns in the grid */
	private int n_columns;
	/* Total number of rows in the grid */
	private int n_rows;
	/* Current grid in display */
	CellGrid currentGrid;
	/* Next grid to be displayed */
	CellGrid nextGrid;
	
	public RulesOfLife ()
	{
        super("Game of Life");

        n_columns = 51;
        n_rows = 51;

        currentGrid = new CellGrid(n_columns, n_rows);
        nextGrid = new CellGrid(n_columns, n_rows);

        setLayout(new GridLayout(n_columns,n_rows));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(int col = 0; col < n_columns; col++)
        {
            for (int row=0; row< n_rows; row++)
            {
                add(currentGrid.getSingleCells()[col][row]);
            }
        }
        /* set size for the frame */
        setSize(500, 500);
        /* set frame as not resizable */
        setResizable(false);
        /* Setting location as non-relative */
        setLocationRelativeTo(null);
        /* Make the frame visible */
        setVisible(true);
    }

	public CellGrid getNextGrid ()
	{
		return nextGrid;
	}
	public void setCurrentGrid(CellGrid currentGrid)
	{
		this.currentGrid = currentGrid;
	}
	public CellGrid getCurrentGrid()
	{
		return this.currentGrid;
	}
	public void setNextGrid(CellGrid Grid)
	{
		nextGrid = Grid;
	}

	public int getColumns()
	{
		return n_columns;
	}
	public int getRows()
	{
		return n_rows;
	}
	public void setRows(int r)
	{
		n_rows = r;
	}
	public void setColumns(int c)
	{
		n_columns = c;
	}
	public void startGame()
	{
	}
	
}
