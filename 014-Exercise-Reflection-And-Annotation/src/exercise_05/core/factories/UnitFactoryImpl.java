package src.exercise_05.core.factories;

import src.exercise_05.interfaces.Unit;
import src.exercise_05.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = "src.exercise_05.models.units.";

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


        return unit;
    }
}
