package lapr4.white.s1.core.n1234567.comments.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import csheets.core.Cell;
import csheets.ui.ext.CellDecorator;

import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentsExtension;

/**
 * A decorator for commented cells.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentedCellDecorator extends CellDecorator {

	/** The font used to render the '+' */
	private static final Font FONT = new Font("Dialog", Font.PLAIN, 10);

	/**
	 * Creates a new cell decorator.
	 */
	public CommentedCellDecorator() {}

	/**
	 * Decorates the given graphics context if the cell being rendered
	 * has a comment.
	 * @param component the cell renderer component
	 * @param g the graphics context on which drawing should be done
	 * @param cell the cell being rendered
	 * @param selected whether the cell is selected
	 * @param hasFocus whether the cell has focus
	 */
        @Override
	public void decorate(JComponent component, Graphics g, Cell cell,
			boolean selected, boolean hasFocus) {
		if (enabled) {
			CommentableCell commentableCell = (CommentableCell)cell.getExtension(CommentsExtension.NAME);
                        if (commentableCell.hasComments()) 
			{
				// Stores current graphics context properties
				Graphics2D g2 = (Graphics2D)g;
				Color oldPaint = g2.getColor();
				Font oldFont = g2.getFont();

				// Prints 'A' using own font, then restores the old font
				g2.setColor(Color.red);
				g2.setFont(FONT);
				g2.drawString("+", 4, 12);

				// Restores graphics context properties
				g2.setColor(oldPaint);
				g2.setFont(oldFont);
			}
		}
	}
}
