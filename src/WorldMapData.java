import java.util.Iterator;
import java.util.LinkedList;

// 
// Decompiled by Procyon v0.5.36
// 

public class WorldMapData
{
    static int field172;
    int fileId;
    String identifier;
    String name;
    int field163;
    int initialMapSurfaceZoom;
    Coordinates field165;
    int minX;
    int field167;
    int minY;
    int field162;
    boolean field173;
    LinkedList field160;
    
    public WorldMapData() {
        this.fileId = -1;
        this.field163 = -1;
        this.initialMapSurfaceZoom = -1;
        this.field165 = null;
        this.minX = Integer.MAX_VALUE;
        this.field167 = 0;
        this.minY = Integer.MAX_VALUE;
        this.field162 = 0;
        this.field173 = false;
    }
    
    public void loadMapData(final Buffer buffer_0, final int int_0) {
        this.fileId = int_0;
        this.identifier = buffer_0.readString();
        this.name = buffer_0.readString();
        this.field165 = new Coordinates(buffer_0.readInt());
        this.field163 = buffer_0.readInt();
        buffer_0.readUnsignedByte();
        this.field173 = (buffer_0.readUnsignedByte() == 1);
        this.initialMapSurfaceZoom = buffer_0.readUnsignedByte();
        final int int_ = buffer_0.readUnsignedByte();
        this.field160 = new LinkedList();
        for (int int_2 = 0; int_2 < int_; ++int_2) {
            this.field160.add(this.method201(buffer_0));
        }
        this.method206();
    }
    
    WorldMapSectionBase method201(final Buffer buffer_0) {
        final int int_0 = buffer_0.readUnsignedByte();
        final class15 class15_0 = (class15)class76.forOrdinal(class15.getWorldMapTypes(), int_0);
        Object object_0 = null;
        switch (class15_0.worldMapType) {
            case 0: {
                object_0 = new WorldMapType3();
                break;
            }
            case 1: {
                object_0 = new class37();
                break;
            }
            case 2: {
                object_0 = new WorldMapType1();
                break;
            }
            case 3: {
                object_0 = new WorldMapType2();
                break;
            }
            default: {
                throw new IllegalStateException("");
            }
        }
        ((WorldMapSectionBase)object_0).vmethod639(buffer_0);
        return (WorldMapSectionBase)object_0;
    }
    
    public boolean containsCoord(final int int_0, final int int_1, final int int_2) {
        for (final Object worldmapsectionbase_0 : this.field160) {
            if (((WorldMapSectionBase)worldmapsectionbase_0).containsCoord(int_0, int_1, int_2)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean surfaceContainsPosition(final int int_0, final int int_1) {
        final int int_2 = int_0 / 64;
        final int int_3 = int_1 / 64;
        if (int_2 < this.minX || int_2 > this.field167) {
            return false;
        }
        if (int_3 >= this.minY && int_3 <= this.field162) {
            for (final Object worldmapsectionbase_0 : this.field160) {
                if (((WorldMapSectionBase)worldmapsectionbase_0).vmethod637(int_0, int_1)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public int[] method213(final int int_0, final int int_1, final int int_2) {
        for (final Object worldmapsectionbase_0 : this.field160) {
            if (((WorldMapSectionBase)worldmapsectionbase_0).containsCoord(int_0, int_1, int_2)) {
                return ((WorldMapSectionBase)worldmapsectionbase_0).vmethod638(int_0, int_1, int_2);
            }
        }
        return null;
    }
    
    public Coordinates method205(final int int_0, final int int_1) {
        for (final Object worldmapsectionbase_0 : this.field160) {
            if (((WorldMapSectionBase)worldmapsectionbase_0).vmethod637(int_0, int_1)) {
                return ((WorldMapSectionBase)worldmapsectionbase_0).vmethod659(int_0, int_1);
            }
        }
        return null;
    }
    
    void method206() {
        for (final Object worldmapsectionbase_0 : this.field160) {
        	((WorldMapSectionBase)worldmapsectionbase_0).vmethod635(this);
        }
    }
    
    public int getFileId() {
        return this.fileId;
    }
    
    public boolean method208() {
        return this.field173;
    }
    
    public String getIdentifier() {
        return this.identifier;
    }
    
    public String getName() {
        return this.name;
    }
    
    int method211() {
        return this.field163;
    }
    
    public int getInitialMapSurfaceZoom() {
        return this.initialMapSurfaceZoom;
    }
    
    public int getMinX() {
        return this.minX;
    }
    
    public int method214() {
        return this.field167;
    }
    
    public int getMinY() {
        return this.minY;
    }
    
    public int method249() {
        return this.field162;
    }
    
    public int method217() {
        return this.field165.worldX;
    }
    
    public int method218() {
        return this.field165.plane;
    }
    
    public int method219() {
        return this.field165.worldY;
    }
    
    public Coordinates method256() {
        return new Coordinates(this.field165);
    }
    
    public static Permission[] method216() {
        return new Permission[] { Permission.REGULAR, Permission.HARDCORE_IRONMAN, Permission.ADMINISTRATOR, Permission.IRONMAN, Permission.ULTIMATE_IRONMAN, Permission.MODERATOR, Permission.DONATOR, Permission.SUPER_DONATOR, Permission.EXTREME_DONATOR, Permission.ULTIMATE_DONATOR, Permission.MASTER_DONATOR, Permission.GODLIKE_DONATOR, Permission.YOUTUBE, Permission.DEVELOPER, Permission.SUPPORT, Permission.BETA_TESTER, Permission.YOUTUBER, Permission.SENIOR_MODERATOR, Permission.DICER, Permission.OWNER, Permission.EXECUTIVE_MANAGER, Permission.CHIEF_DEVELOPMENT_OFFICER, Permission.COMMUNITY_MANAGER, Permission.SENIOR_ADVISOR, Permission.ADVISOR, Permission.JUNIOR_MODERATOR, Permission.CADET_MODERATOR, Permission.DISCORD_MANAGER, Permission.EVENTS_MODERATOR, Permission.PK_MODE, Permission.CLASSIC_PLAYER };
    }
    
    public static long method262(final int int_0) {
        return class120.field1647[int_0];
    }
    
    static boolean method260() {
        return (Game.playerNameMask & 0x4) != 0x0;
    }
    
    static void closeWidget(final WidgetNode widgetnode_0, final boolean bool_0) {
        final int int_0 = widgetnode_0.id;
        final int int_2 = (int)widgetnode_0.hash;
        widgetnode_0.unlink();
        if (bool_0 && InterfaceEdits.allowUnload(int_0)) {
            Preferences.method1622(int_0);
        }
        Frames.method3077(int_0);
        final Widget widget_0 = Widget.getWidget(int_2);
        if (widget_0 != null) {
            Player.method1114(widget_0);
        }
        LoginPacket.method3448();
        if (Game.widgetRoot != -1) {
            final int int_3 = Game.widgetRoot;
            if (CombatInfo2.loadWidget(int_3)) {
                class83.method1923(GameCanvas.widgets[int_3], 1);
            }
        }
    }
}
