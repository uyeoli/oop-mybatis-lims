package lims.api.common.util;

public class ValidationUtil {

    public static boolean isNew(Long id) {
        return id == null || id == 0;
    }
}
