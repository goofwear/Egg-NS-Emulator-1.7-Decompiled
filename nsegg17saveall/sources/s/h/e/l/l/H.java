package s.h.e.l.l;

public class H {
    public static native void i(int i);

    static {
        System.loadLibrary("execv3");
    }
}
