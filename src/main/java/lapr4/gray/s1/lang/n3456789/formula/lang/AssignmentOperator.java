/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.gray.s1.lang.n3456789.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.CellReference;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s1.lang.n1140953.variables.temporary.Temporary;
import lapr4.blue.s1.lang.n1140953.variables.temporary.TemporaryReference;
import lapr4.blue.s1.lang.n1140953.variables.temporary.TemporaryStorage;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ArrayItem;
import lapr4.red.s2.lang.n1131106.globalvariables.GlobalVariableReference;

/**
 *
 * @author alexandrebraganca
 */
public class AssignmentOperator implements BinaryOperator {

    Value value = null;

    @Override
    public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
        if (leftOperand instanceof CellReference) {
            // do the assignment
            Value value = rightOperand.evaluate();
            CellReference left = (CellReference) leftOperand;
            String content = "";
            try {
                // Need to handle all possible types because the set of a cell only accepts "text" or "formula"!!!
                switch (value.getType()) {
                    case NUMERIC:
                        content = value.toString(new DecimalFormat());
                        break;
                    case TEXT:
                        content = value.toText();
                        break;
                    case BOOLEAN:
                        content = value.toBoolean().toString();
                        break;
                    case DATE:
                        content = value.toDate().toString();
                        break;
                    default:
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                left.getCell().setContent(content);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(AssignmentOperator.class.getName()).log(Level.SEVERE, null, ex);
            }
            return value;
        }
        if (leftOperand instanceof TemporaryReference) {
            value = rightOperand.evaluate();
            TemporaryReference left = (TemporaryReference) leftOperand;
            if (TemporaryStorage.exists(left.getName())) {
                System.out.println("TEMPORARY EXISTS" + " " + value.toDouble());
                TemporaryStorage.update(left.getName(), value);
            } else {
                System.out.println("TEMPORARY NON EXISTS" + " " + value.toDouble());
                TemporaryStorage.add(left.getName(), value);
            }

            return value;
        }
        if((leftOperand instanceof ArrayItem)){
            value = rightOperand.evaluate();
            ArrayItem left = (ArrayItem) leftOperand;
            left.setValue(value);
            //System.out.println(left.getName() +" : "+left.getValue().toText());
            return value;
        }
        if (leftOperand instanceof GlobalVariableReference) {
            GlobalVariableReference varRef = (GlobalVariableReference) leftOperand;

            value = rightOperand.evaluate();

            Workbook workbook = new Workbook();
            workbook.createVariable(varRef.getVariable(), value, varRef.getSpreadSheet());
            return value;
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdentifier() {
        return ":=";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }

    public String toString() {
        return getIdentifier();
    }

}
