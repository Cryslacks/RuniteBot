// 
// Decompiled by Procyon v0.5.36
// 

public enum Permission implements Enumerated
{
    REGULAR(0, -1, true, false, true), 
    MODERATOR(1, 0, true, true, true), 
    ADMINISTRATOR(2, 124, true, true, false), 
    IRONMAN(3, 2, false, false, true), 
    ULTIMATE_IRONMAN(4, 3, false, false, true), 
    HARDCORE_IRONMAN(5, 10, false, false, true), 
    DONATOR(6, 20, false, false, true), 
    SUPER_DONATOR(7, 21, false, false, true), 
    EXTREME_DONATOR(8, 22, false, false, true), 
    ULTIMATE_DONATOR(9, 23, false, false, true), 
    MASTER_DONATOR(10, 24, false, false, true), 
    GODLIKE_DONATOR(11, 25, false, false, true), 
    YOUTUBE(12, 29, false, false, true), 
    DEVELOPER(13, 31, false, false, true), 
    SUPPORT(14, 27, false, false, true), 
    BETA_TESTER(15, 92, false, false, true), 
    YOUTUBER(16, 29, false, false, true), 
    SENIOR_MODERATOR(17, 28, false, false, true), 
    DICER(18, 119, false, false, true), 
    EXECUTIVE_MANAGER(19, 128, false, false, true), 
    CHIEF_DEVELOPMENT_OFFICER(20, 31, false, false, true), 
    COMMUNITY_MANAGER(21, 127, false, false, true), 
    SENIOR_ADVISOR(22, 1, false, false, true), 
    ADVISOR(23, 130, false, false, true), 
    JUNIOR_MODERATOR(24, 0, false, false, true), 
    CADET_MODERATOR(25, 131, false, false, true), 
    DISCORD_MANAGER(26, 125, false, false, true), 
    EVENTS_MODERATOR(27, 124, false, false, true), 
    OWNER(28, 129, false, false, true), 
    PK_MODE(29, 132, false, false, true), 
    CLASSIC_PLAYER(30, 43, false, false, true);
    
    final int field3124;
    public final int field3128;
    public final boolean field3126;
    public final boolean field3127;
    
    private Permission(final int int_1, final int int_2, final boolean bool_0, final boolean bool_1, final boolean bool_2) {
        this.field3124 = int_1;
        this.field3128 = int_2;
        this.field3126 = bool_1;
        this.field3127 = bool_2;
    }
    
    @Override
    public int vmethod5815() {
        return this.field3124;
    }
    
    public static void method4605() {
        if (class250.NetCache_socket != null) {
            class250.NetCache_socket.vmethod3346();
        }
    }
}
