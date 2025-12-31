package sa.edu.kau.fcit.cpit252.logger.handlers;

public class DatabaseLogger extends BaseLogger {
    public DatabaseLogger() {
        label = "Database logger";
    }

    public String getLevel() {
        return "error";
    }
}
