package src.exercise_04.core.factories;

import src.exercise_04.interfaces.Unit;
import src.exercise_04.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = "src.exercise_04.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        // done with reflection

        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);

            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            unit = (Unit) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // done with switch
//		switch (unitType) {
//		case "Swordsman":
//			unit = new Swordsman();
//			break;
//		case "Archer":
//			unit = new Archer();
//			break;
//		case "Pikeman":
//			unit = new Pikeman();
//			break;
//		case "Horseman":
//			unit = new Horseman();
//			break;
//		case "Gunner":
//			unit = new Gunner();
//			break;
//		}

        return unit;
    }
}
