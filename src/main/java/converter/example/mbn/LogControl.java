package converter.example.mbn;

public class LogControl implements LogControlMBean {
    private boolean logEnabled = true;

    @Override
    public void enableLog() {
        logEnabled = true;
        System.out.println("Log is enabled .");
    }

    @Override
    public void disableLog() {
        logEnabled = false;
        System.out.println("Log is disabled.");
    }

    @Override
    public boolean isLogEnabled() {
        return logEnabled;
    }
}
