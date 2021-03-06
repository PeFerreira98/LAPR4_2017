/**
 * Technical documentation regarding the user story Core07.1: Workbook Search
 * <p>
 * <b>Requirement</b><p>
 * The extension should provide a new sidebar window for searching the contents of the active workbook.
The window should be composed of two parts. The first part (upper part of the window) should contain
a textbox for the user to enter a regular expression to be the basis for the search. This part should also
contain a button to launch the search. The second part (lower part of the window) should be used to
display the search results (cell coordinates and value or contents). The search should include no only the
content of the cell (i.e., the text entered by the user) but also its value (that could have been calculated
by a formula).
* 
 * <b>Class Diagram</b><p>
 * <img src="core07.1_class.png" alt="image"> 
 * 
 * <b>Analysis</b><p>
 * This option will be placed on sidebar window.<p>
 * The user will be able to input the regular expression that he wants to search. The result will be displayed on a list with the cell coordinates and value or contents.
 *
 * <img src="core07.1_analysis.png" alt="image"> 
 * <p>
 * 
 * <b>Design</b><p>
 * <img src="core07.1_design.png" alt="image"> 
 * <p>
 * 
 * <b>Tests</b><p>
 * <b>Test1:</b>WorkbookSearchControllerTest<p>
 * See Package lapr4.blue.s3.core.n1140956.WorkbookSearch:<p>
 * WorkbookSearchControllerTest<p>
 * 
 *  
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.blue.s3.core.n1140956.WorkbookSearch:<p>
 * {@link lapr4.blue.s3.core.n1140956.WorkbookSearch.SearchExtension}
 * {@link lapr4.blue.s3.core.n1140956.WorkbookSearch.WorkbookSearchController}
 * 
 * <p>
 * Package lapr4.blue.s3.core.n1140956.WorkbookSearch.ui:<p>
 * {@link lapr4.blue.s3.core.n1140956.WorkbookSearch.ui.SearchPanel}
 * {@link lapr4.blue.s3.core.n1140956.WorkbookSearch.ui.UIExtensionSearch}
 * 
 * @author Marcos Dourado (1140956)
 */
package lapr4.blue.s3.core.n1140956.WorkbookSearch;
