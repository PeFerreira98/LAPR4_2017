package lapr4.green.s2.core.n1130626.insertimage;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s2.core.n1130626.insertimage.ui.UIExtensionImages;

/**
 * An extension to support images on cells.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author Pedro Pereira
 */
public class ImagesExtension extends Extension {
    
        /** The name of the extension */
	public static final String NAME = "Images";
        public static final int VERSION = 1;
        public static final String DESCRIPTION = "Original Images Extension, allows to add images references to cell's";

        /**
         * Creates a new Image Extension.
         */
        public ImagesExtension() {
            super(NAME, VERSION, DESCRIPTION);
        }
    
        /**
         * Makes the given cell imagenable.
         * @param cell the cell to accept images
         * @return a imagenable cell
         */
        @Override
        public ImagenableCell extend(Cell cell) {
            return new ImagenableCell(cell);
        }
        
        /**
         * Returns the user interface extension of this extension
         * @param uiController the user interface controller
         * @return a user interface extension, or null if none is provided
         */
        @Override
        public UIExtension getUIExtension(UIController uiController) {
            return new UIExtensionImages(this, uiController);
        }
}
