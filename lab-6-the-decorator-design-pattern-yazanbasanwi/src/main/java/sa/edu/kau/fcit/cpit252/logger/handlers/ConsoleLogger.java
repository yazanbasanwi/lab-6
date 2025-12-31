package sa.edu.kau.fcit.cpit252.logger.handlers;

public class ConsoleLogger extends BaseLogger {
    public ConsoleLogger() {
        super.label = "Console logger";
    }
    @Override
    public String getLevel() {
        return "info";
    }
}