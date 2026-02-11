public class MaleniaExceptions extends Exception {
    public MaleniaExceptions(String message) {
        super(message);
    }

    public static MaleniaExceptions invalidCommandException() {
        return new MaleniaExceptions("This is an invalid command! Please try again.");
    }

    public static MaleniaExceptions taskListFullException() {
        return new MaleniaExceptions("Task list is full! Please remove some tasks before adding new ones.");
    }

    public static MaleniaExceptions taskIndexOutOfRangeException() {
        return new MaleniaExceptions("Task index out of range!");
    }

    public static MaleniaExceptions missingDescriptionException(String errorMessage) {
        return new MaleniaExceptions(errorMessage);
    }

    public static MaleniaExceptions listInvalidParameterException() {
        return new MaleniaExceptions("The index must be a number.");
    }
}
