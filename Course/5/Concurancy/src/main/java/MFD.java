public class MFD {
    private final Object mon1 = new Object();
    private final Object mon2 = new Object();
    public void print(int count, int document) {
        synchronized (mon1) {
            for (int i = 1; i<count+1; i++) {
                System.out.println("Отпечатано " + i + "стр, " +document + " док");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void scan(int count, int document) {
        synchronized (mon2) {
            for (int i = 1; i<count+1; i++) {
                System.out.println("Отсканировано " + i + "стр, " +document + " док");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
