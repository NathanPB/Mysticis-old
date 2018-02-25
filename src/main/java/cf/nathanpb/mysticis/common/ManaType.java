package cf.nathanpb.mysticis.common;

public enum ManaType {
    AIR(ManaType.NATURE),
    FIRE(ManaType.ICE),
    WATER(ManaType.FIRE),
    ICE(ManaType.WATER),
    NATURE(ManaType.AIR),
    MAGIC(ManaType.DARK),
    DARK(ManaType.MAGIC);

    private ManaType cancel;
    ManaType(ManaType type){
        this.cancel = type;
    }

    public ManaType getAgainst() {
        return cancel;
    }
}
