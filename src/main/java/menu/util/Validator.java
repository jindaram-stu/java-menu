package menu.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.constants.ExceptionMessage;

public class Validator {

    private static final String SEPARATOR = ",";

    private static final int MINIMUM_LENGTH = 2;
    private static final int MAXIMUM_LENGTH = 4;

    private static final int MINIMUM_NUMBER = 2;
    private static final int MAXIMUM_NUMBER = 5;

    private static final int NOT_EAT_FOOD_MINIMUM_NUMBER = 0;
    private static final int NOT_EAT_FOOD_MAXIMUM_NUMBER = 2;

    public static void validateCoach(String coachesByRest) {
        List<String> coaches = Arrays.asList(coachesByRest.split(SEPARATOR,-1));
        coaches.stream()
                .forEach(coachName -> validateCoachName(coachName));
        validateCoachNumber(coaches);
        validateDuplicateCoachName(coaches);
    }

    public static void validateNotEatFoods(String notEatFoods) {
        List<String> notEatFoodNames = Arrays.asList(notEatFoods.split(SEPARATOR,-1));
        validateNotEatFoodNumber(notEatFoodNames);
        validateDuplicateNotEatFoods(notEatFoodNames);
    }

    private static void validateCoachName(String name) {
        if (name.equals("") || name == null) {
            throw new IllegalArgumentException(ExceptionMessage.COACH_NAME_NOT_EMPTY);
        }
        if (!(name.length() >= MINIMUM_LENGTH && name.length() <= MAXIMUM_LENGTH)) {
            throw new IllegalArgumentException(ExceptionMessage.COACH_NAME_LENGTH);
        }
    }

    private static void validateDuplicateCoachName(List<String> coachNames) {
        Set<String> distinct = new HashSet<>(coachNames);
        if (coachNames.size() != distinct.size()) {
            throw new IllegalArgumentException(ExceptionMessage.COACH_NAME_DUPLICATE);
        }
    }

    private static void validateCoachNumber(List<String> coaches) {
        if (!(coaches.size() >= MINIMUM_NUMBER && coaches.size() <= MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotEatFoodNumber(List<String> notEatFoods) {
        if (!(notEatFoods.size() >= NOT_EAT_FOOD_MINIMUM_NUMBER && notEatFoods.size() <= NOT_EAT_FOOD_MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EAT_FOOD_NUMBER);
        }
    }

    private static void validateDuplicateNotEatFoods(List<String> notEatFoods) {
        Set<String> distinct = new HashSet<>(notEatFoods);
        if (notEatFoods.size() != distinct.size()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EAT_FOOD_DUPLICATE);
        }
    }
}