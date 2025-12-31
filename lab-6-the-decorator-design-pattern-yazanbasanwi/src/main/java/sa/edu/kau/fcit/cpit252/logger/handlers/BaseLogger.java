package sa.edu.kau.fcit.cpit252.logger.handlers;

public abstract class BaseLogger {
    String label = "Unknown label";

    public String getLabel() {
        return label;
    }

    public  abstract String getLevel();

}