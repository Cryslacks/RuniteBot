// 
// Decompiled by Procyon v0.5.36
// 

public abstract class Actor extends Renderable
{
    static AbstractSoundSystem soundSystem1;
    static Font font_p12full;
    static int field932;
    int x;
    int y;
    int angle;
    boolean field873;
    int field874;
    int field889;
    int idlePoseAnimation;
    int field877;
    int field878;
    int field899;
    int field880;
    int field870;
    int field882;
    int field883;
    String overhead;
    boolean field885;
    boolean field886;
    int overheadTextCyclesRemaining;
    int field888;
    int field927;
    byte field890;
    int[] hitsplatTypes;
    int[] hitsplatValues;
    int[] hitsplatCycles;
    int[] field894;
    int[] field921;
    CombatInfoList combatInfoList;
    int interacting;
    boolean field898;
    int field920;
    int poseAnimation;
    int poseFrame;
    int poseFrameCycle;
    int animation;
    int actionFrame;
    int actionFrameCycle;
    int actionAnimationDisable;
    int field907;
    int graphic;
    int spotAnimFrame;
    int spotAnimFrameCycle;
    int graphicsDelay;
    int field871;
    int field913;
    int field916;
    int field915;
    int field929;
    int field917;
    int field918;
    int field919;
    int npcCycle;
    int logicalHeight;
    int orientation;
    int field875;
    int field924;
    int queueSize;
    int[] pathX;
    int[] pathY;
    byte[] pathTraversed;
    int field923;
    int field930;
    
    Actor() {
        this.field873 = false;
        this.field874 = 1;
        this.idlePoseAnimation = -1;
        this.field877 = -1;
        this.field878 = -1;
        this.field899 = -1;
        this.field880 = -1;
        this.field870 = -1;
        this.field882 = -1;
        this.field883 = -1;
        this.overhead = null;
        this.field886 = false;
        this.overheadTextCyclesRemaining = 100;
        this.field888 = 0;
        this.field927 = 0;
        this.field890 = 0;
        this.hitsplatTypes = new int[4];
        this.hitsplatValues = new int[4];
        this.hitsplatCycles = new int[4];
        this.field894 = new int[4];
        this.field921 = new int[4];
        this.combatInfoList = new CombatInfoList();
        this.interacting = -1;
        this.field898 = false;
        this.field920 = -1;
        this.poseAnimation = -1;
        this.poseFrame = 0;
        this.poseFrameCycle = 0;
        this.animation = -1;
        this.actionFrame = 0;
        this.actionFrameCycle = 0;
        this.actionAnimationDisable = 0;
        this.field907 = 0;
        this.graphic = -1;
        this.spotAnimFrame = 0;
        this.spotAnimFrameCycle = 0;
        this.npcCycle = 0;
        this.logicalHeight = 200;
        this.field875 = 0;
        this.field924 = 32;
        this.queueSize = 0;
        this.pathX = new int[10];
        this.pathY = new int[10];
        this.pathTraversed = new byte[10];
        this.field923 = 0;
        this.field930 = 0;
    }
    
    boolean hasConfig() {
        return false;
    }
    
    void method1540() {
        this.queueSize = 0;
        this.field930 = 0;
    }
    
    void applyActorHitsplat(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5) {
    	//System.out.println("<applyActorHitsplat> Args: "+int_0+", "+int_1+", "+int_2+", "+int_3+", "+int_4+", "+int_5);
        boolean bool_0 = true;
        boolean bool_2 = true;
        for (int int_6 = 0; int_6 < 4; ++int_6) {
            if (this.hitsplatCycles[int_6] > int_4) {
                bool_0 = false;
            }
            else {
                bool_2 = false;
            }
        }
        int int_6 = -1;
        int int_7 = -1;
        int int_8 = 0;
        if (int_0 >= 0) {
            final class267 class267_0 = WorldMapType3.method123(int_0);
            int_7 = class267_0.field3360;
            int_8 = class267_0.field3355;
        }
        if (bool_2) {
            if (int_7 == -1) {
                return;
            }
            int_6 = 0;
            int int_9 = 0;
            if (int_7 == 0) {
                int_9 = this.hitsplatCycles[0];
            }
            else if (int_7 == 1) {
                int_9 = this.hitsplatValues[0];
            }
            for (int int_10 = 1; int_10 < 4; ++int_10) {
                if (int_7 == 0) {
                    if (this.hitsplatCycles[int_10] < int_9) {
                        int_6 = int_10;
                        int_9 = this.hitsplatCycles[int_10];
                    }
                }
                else if (int_7 == 1 && this.hitsplatValues[int_10] < int_9) {
                    int_6 = int_10;
                    int_9 = this.hitsplatValues[int_10];
                }
            }
            if (int_7 == 1 && int_9 >= int_1) {
                return;
            }
        }
        else {
            if (bool_0) {
                this.field890 = 0;
            }
            for (int int_9 = 0; int_9 < 4; ++int_9) {
                final byte byte_0 = this.field890;
                this.field890 = (byte)((this.field890 + 1) % 4);
                if (this.hitsplatCycles[byte_0] <= int_4) {
                    int_6 = byte_0;
                    break;
                }
            }
        }
        if (int_6 >= 0) {
            this.hitsplatTypes[int_6] = int_0;
            this.hitsplatValues[int_6] = int_1;
            this.field894[int_6] = int_2;
            this.field921[int_6] = int_3;
            this.hitsplatCycles[int_6] = int_4 + int_8 + int_5;
        }
    }
    
    void setCombatInfo(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5) {
        CombatInfo2 combatinfo2_0 = (CombatInfo2)CombatInfo2.field3305.get(int_0);
        CombatInfo2 combatinfo2_2;
        if (combatinfo2_0 != null) {
            combatinfo2_2 = combatinfo2_0;
        }
        else {
            final byte[] bytes_0 = CombatInfo2.field3304.getConfigData(33, int_0);
            combatinfo2_0 = new CombatInfo2();
            if (bytes_0 != null) {
                combatinfo2_0.read(new Buffer(bytes_0));
            }
            CombatInfo2.field3305.put(combatinfo2_0, int_0);
            combatinfo2_2 = combatinfo2_0;
        }
        combatinfo2_0 = combatinfo2_2;
        CombatInfoListHolder combatinfolistholder_2 = null;
        CombatInfoListHolder combatinfolistholder_3 = null;
        int int_6 = combatinfo2_2.field3307;
        int int_7 = 0;
        for (CombatInfoListHolder combatinfolistholder_4 = (CombatInfoListHolder)this.combatInfoList.last(); combatinfolistholder_4 != null; combatinfolistholder_4 = (CombatInfoListHolder)this.combatInfoList.previous()) {
            ++int_7;
            if (combatinfolistholder_4.combatInfo2.field3317 == combatinfo2_0.field3317) {
                combatinfolistholder_4.method1772(int_1 + int_3, int_4, int_5, int_2);
                return;
            }
            if (combatinfolistholder_4.combatInfo2.field3310 <= combatinfo2_0.field3310) {
                combatinfolistholder_2 = combatinfolistholder_4;
            }
            if (combatinfolistholder_4.combatInfo2.field3307 > int_6) {
                combatinfolistholder_3 = combatinfolistholder_4;
                int_6 = combatinfolistholder_4.combatInfo2.field3307;
            }
        }
        if (combatinfolistholder_3 != null || int_7 < 4) {
            final CombatInfoListHolder combatinfolistholder_4 = new CombatInfoListHolder(combatinfo2_0);
            if (combatinfolistholder_2 == null) {
                this.combatInfoList.addLast(combatinfolistholder_4);
            }
            else {
                CombatInfoList.method4036(combatinfolistholder_4, combatinfolistholder_2);
            }
            combatinfolistholder_4.method1772(int_1 + int_3, int_4, int_5, int_2);
            if (int_7 >= 4) {
                combatinfolistholder_3.unlink();
            }
        }
    }
    
    void method1557(final int int_0) {
        CombatInfo2 combatinfo2_0 = (CombatInfo2)CombatInfo2.field3305.get(int_0);
        CombatInfo2 combatinfo2_2;
        if (combatinfo2_0 != null) {
            combatinfo2_2 = combatinfo2_0;
        }
        else {
            final byte[] bytes_0 = CombatInfo2.field3304.getConfigData(33, int_0);
            combatinfo2_0 = new CombatInfo2();
            if (bytes_0 != null) {
                combatinfo2_0.read(new Buffer(bytes_0));
            }
            CombatInfo2.field3305.put(combatinfo2_0, int_0);
            combatinfo2_2 = combatinfo2_0;
        }
        combatinfo2_0 = combatinfo2_2;
        for (CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder)this.combatInfoList.last(); combatinfolistholder_0 != null; combatinfolistholder_0 = (CombatInfoListHolder)this.combatInfoList.previous()) {
            if (combatinfo2_0 == combatinfolistholder_0.combatInfo2) {
                combatinfolistholder_0.unlink();
                return;
            }
        }
    }
    
    public static void method1539(final long long_0) {
        if (long_0 > 0L) {
            if (long_0 % 10L == 0L) {
                final long long_ = long_0 - 1L;
                try {
                    Thread.sleep(long_);
                }
                catch (InterruptedException ex) {}
                try {
                    Thread.sleep(1L);
                }
                catch (InterruptedException ex2) {}
            }
            else {
                try {
                    Thread.sleep(long_0);
                }
                catch (InterruptedException ex3) {}
            }
        }
    }
    
    public static VarPlayerType method1549(final int int_0) {
        VarPlayerType varplayertype_0 = (VarPlayerType)VarPlayerType.varplayers.get(int_0);
        if (varplayertype_0 != null) {
            return varplayertype_0;
        }
        final byte[] bytes_0 = WorldComparator.varplayer_ref.getConfigData(16, int_0);
        varplayertype_0 = new VarPlayerType();
        if (bytes_0 != null) {
            varplayertype_0.decode(new Buffer(bytes_0));
        }
        VarPlayerType.varplayers.put(varplayertype_0, int_0);
        return varplayertype_0;
    }
    
    public static void method1554(final IndexDataBase indexdatabase_0, final int int_0, final int int_1, final int int_2, final boolean bool_0) {
        class217.field2460 = 1;
        class138.field1871 = indexdatabase_0;
        class217.field2461 = int_0;
        class217.field2462 = int_1;
        class309.field3740 = int_2;
        class217.field2463 = bool_0;
        class6.field37 = 10000;
    }
}
