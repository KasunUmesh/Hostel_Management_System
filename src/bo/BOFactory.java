package bo;

import bo.custom.impl.RoomBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance() {
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case ROOM:
                return (T) new RoomBOImpl();
            default:
                return null;
        }
    }

    public enum BOType {
        ROOM
    }
}
