/**
 * Technical documentation regarding the user story Lang01.1: Block of Instructions.
 * <p>
 *
 * <b>Attention: This feature increment and this documentation are work in
 * progress! You should question what is already done!</b><p>
 *
 *
 * <h2>1. Notes</h2><p>
 *
 * -Notes about the sprint's work.-
 * <p>
 * -In this section you should register important notes regarding your work
 * during the sprint. For instance, if you spend significant time helping a
 * colleague or if you work in more than one feature.-
 * <p>
 * <p>
 * - Helped in LANG03.1 - Conditional Formating implementation, colleague was
 * having trouble updating cells formating after altering the content more than
 * once.
 * <p>
 * - Tried to fix a bug from AssignmentOperator that caused it to loop when
 * incrementing a cell's value(wasn't able to fix it, setContent() calls
 * reevaluate() which causes all dependent cells to evaluate the expression
 * again, and after finishing the reevaluation it calls the setContent() to
 * update the cell's value).
 * <p>
 *
 *
 * <h2>2. Requirement</h2><p>
 * Add the possibility of writing blocks (or sequences) of instructions. A block
 * must be delimited by curly braces and its instructions must be separated by
 * ";". The instructions of a block are executed sequentially and the block
 * "result" is the result of the last statement of the block. For example, the
 * formula "= {1+ 2; sum (A1:A10); B3 + 4 }" must result in the sequential
 * execution of all expressions and the result is the value of the expression
 * "B3 + 4".
 * <p>
 * Add the assign operator (its symbol is ":="). This operator assigns to its
 * left the result of the right expression. At the moment the left of the assign
 * operator can only be a cell reference.
 * <p>
 * The FOR loop should also be implemented based on instruction blocks. For
 * example, the formula
 * <pre>{@code "= FOR {A1: = 1 ; A1 < 10; A2: = A2 + A1; A1: = A1 + 1 }"}</pre>
 * executes a for loop in which: the first expression is the initialization, the
 * second term is the boundary condition, all other expressions are performed
 * for each iteration of the loop.
 * <p>
 *
 * <b>Attention:</b><p>
 * In the class lapr4.gray.s1.lang.n3456789.formula.lang.Language it was
 * necessary to add a new function (FOR) to support the new formula, since it
 * already contains the AssignmentOperator and SequenceOperator.
 * <p>
 *
 *
 * <h2>3. Analysis</h2><p>
 *
 * <h3>3.1 User Stories</h3><p>
 *
 * <b>US1.</b> As a CRM User I want to be able to use formulas to assign values
 * to cell's.(already implemented)<br>
 * <b>US2.</b> As a CRM User I want to be able to use formulas to execute
 * several expressions at once, in a block.(already implemented)<br>
 * <b>US3.</b> As a CRM User I want to be able to use formulas to execute a
 * block of instructions in a loop, until a boundary condition is reached.<br>
 * <p>
 *
 *
 * <h3>3.2 Domain Model</h3><p>
 * <p>
 * <img src="domain_model_formulas.png" alt="image">
 * <p>
 *
 *
 * <h3>3.3 Use Cases (Scenarios)</h3><p>
 *
 * <b>UC1.1 Execute a For Loop (from US1)</b>
 * <p>
 * <img src="analysis.png" alt="image">
 * <p>
 * Alternative and Exception Scenarios<br>
 * Exception 1: Malformed Expression. Repeat use case. <br>
 * Exception 2: Not enough arguments. Repeat use case. <br>
 * <p>
 *
 *
 * <h3>3.4 Acceptance Tests</h3><p>
 *
 * <b>Exception 1</b><br>
 * <pre>
 * {@code
 * Given
 *   Malformed Expression
 * Then
 *   System throws Exception
 * }
 * </pre>
 * <p>
 *
 * <b>Exception 2</b><br>
 * <pre>
 * {@code
 * Given
 *   Expression without the minimum amount of arguments
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 *
 * <h2>4. Design</h2><p>
 *
 * <b>Sequence Diagrams</b><p>
 * <img src="design.png" alt="image">
 * <p>
 *
 * <b>Class Diagram</b>
 * <p>
 *
 *
 *
 * <b>Notes</b><p>
 * - This use case regards essentially the formula compiler and executer. It
 * does not seem to have any impact in other areas of the application.<p>
 * - The entry point for the execution of the formula compiler is the method
 * setContent of the interface Cell.<p>
 * - The setContent method basically does three things:
 * <p>
 * -- storeContent(content); = this compiles the content and produces a Formula
 * object and updates cell dependencies based on the Formula<p>
 * -- fireContentChanged(); = this notifies listeners about content changes<p>
 * -- reevaluate(); = this executes the Formula and notifies listeners about
 * value changes
 * <p>
 * <b>storeContent</b><p>
 * Executes formula=FormulaCompiler.getInstance().compile(content) = this will
 * select the instance of ExpressionCompiler based on the "starter char"
 * <p>
 * - <b>compile</b><p>
 * -- will execute the FormulaParser (generated from ANTLR) to obtain the parser
 * tree.<p>
 * -- the parser tree is then traversed and an Expression is generated.
 * <p>
 * <b>How the parser and executer work together</b><p>
 * Antlr will generate a parser tree. The parser tree includes nodes for grammar
 * elements that are marked with ""^ as a suffix. The other elements in the same
 * rule will become child elements of the node. The elements that are marked
 * with the "!" suffix are not included.<p>
 * For instance, the following grammar rule:
 * <p>
 * L_CURLY_BRACKET^ comparison ( SEMI! comparison )* R_CURLY_BRACKET
 * <p>
 * will generate a node for the L_CURLY_BRACKET and all other elements will be
 * child nodes. The SEMI terminal will not be include in the child elements.
 * <p>
 * <b>Converting parser tree to Expressions</b><p>
 * Each ExpressionCompiler (ExcelExpressionCompiler or any other) will traverse
 * the nodes of the parser tree and generate an Expression for each node. At the
 * end the result is a tree of expressions.<p>
 * The next diagram illustrates the Expression interface and its hierarchy.<p>
 * For the block the idea is to have a new class to support n-ary operations<p>
 * For the assignment the idea is to implement it as a binary operator<p>
 * <p>
 *
 * <b>Tests</b><p>
 * Formulas can be tested interactively using
 * <b>{@link csheets.core.formula.compiler.Console}</b><p>
 * Example of formulas that should be supported by this use case:
 * <p>
 * <b>={ 1+2; sum(a1:a10); b3+4 }</b><p>
 * The following formula will set the value of the its cell to the result of the
 * complete expression (i.e., the result of a3+1+23). An assignment expression
 * will result always in the value of the expression to the right of the
 * assignment operator. Therefore, the execution of this formula also results in
 * the assignement of the result of the expression a3+1 to the a1 cell.<p>
 * We propose to surround the assignment operator with curly brackets so that
 * the impact in the grammar is minor.<p>
 * <b>=(a1:=a3+1)+23</b><p>
 * In the following proposal for the cycle FOR, the first expression is the
 * initialization, the second expression is the limit condition and all the
 * other expressions are to be executed for each iteration of the cycle.<p>
 * <b>=FOR{ a1:=1; a1&lt;10; a2:=a2+a1; a1:=a1+1 }</b><p>
 * See Package lapr4.blue.s1.lang.n1141233.formula:
 * <p>
 * FormulaLoopTest (Should we move/refactor this test to Acceptance Test?)
 * <p>
 *
 * @author Rafael Vieira
 */
package lapr4.blue.s1.lang.n1141233.formula;
