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

        n_columns = 11;
        n_rows = 11;

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
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		int aliveNeighbours = 0;
		
		while (false == currentGrid.deadGrid(currentGrid.getColumns(), getRows()))
		{
            try
            {
                Thread.sleep(100); // do nothing for 1000 milliseconds (1 second)
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            for (int r = 0; r<currentGrid.getRows(); r++)
            {
                for (int c = 0; c<currentGrid.getColumns(); c++)
                {
                    // Get number of neighbors alive.
                	aliveNeighbours = getCurrentGrid().countNeighboursAlive(currentGrid.getSingleCells()[c][r]);
                    if (currentGrid.getSingleCells()[c][r].isAlive()) // If the cell is alive.
                    {
                        if (aliveNeighbours < 2 || aliveNeighbours > 3) // If number of numbers alive is <2 or >3.
                        {
                            nextGrid.getSingleCells()[c][r].dies(); // The cell will die.
                        }
                    }
                    else // if cell is dead then
                    {
                        if(aliveNeighbours == 3) // check if 3 neighbors are alive
                        {
                            nextGrid.getSingleCells()[c][r].setAlive(); // The becomes alive.
                        }
                    }
                }
            }

            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // Copy next grid into currentGrid
            for (int r = 0; r < currentGrid.getRows(); r++)
            {
                for (int c = 0; c < currentGrid.getColumns(); c++)
                {
                    if (nextGrid.getSingleCells()[c][r].isAlive())
                    {
                        currentGrid.getSingleCells()[c][r].setAlive();
                    }
                    else
                    {
                        currentGrid.getSingleCells()[c][r].dies();
                    }
                }
            }
		}
	}

}
