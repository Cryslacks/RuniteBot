// 
// Decompiled by Procyon v0.5.36
// 

public class CombatInfo1 extends Node
{
    static int[] field936;
    int cycle;
    int healthRatio;
    int health;
    int int2;
    
    CombatInfo1(final int int_0, final int int_1, final int int_2, final int int_3) {
    	//System.out.println("<combatInfo1 #Consturctor#> Args: "+int_0+", "+int_1+", "+int_2+", "+int_3);
        this.cycle = int_0;
        this.healthRatio = int_1;
        this.health = int_2;
        this.int2 = int_3;
    }
    
    void set(final int int_0, final int int_1, final int int_2, final int int_3) {
    	//System.out.println("<set> Args: "+int_0+", "+int_1+", "+int_2+", "+int_3);
        this.cycle = int_0;
        this.healthRatio = int_1;
        this.health = int_2;
        this.int2 = int_3;
    }
    
    static void method1560() {
        class224.field2554 = new int[2000];
        int int_0 = 0;
        int int_2 = 240;
        final byte byte_0 = 12;
        while (int_0 < 16) {
            final int int_3 = class143.method3167(int_2 / 360.0f, 0.9998999834060669, 0.075f + int_0 * 0.425f / 16.0f);
            class224.field2554[int_0] = int_3;
            ++int_0;
            int_2 -= 12;
        }
        int_2 = 48;
        final int int_4 = int_2 / 6;
        while (int_0 < class224.field2554.length) {
            final int int_3 = int_0 * 2;
            final int int_5 = class143.method3167(int_2 / 360.0f, 0.9998999834060669, 0.5);
            while (int_0 < int_3 && int_0 < class224.field2554.length) {
                class224.field2554[int_0] = int_5;
                ++int_0;
            }
            int_2 -= int_4;
        }
    }
    
    static int method1558(final int int_0, final Script script_0, final boolean bool_0) {
        if (int_0 == 6600) {
            final int int_ = class13.plane;
            final int int_2 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
            final int int_3 = (class138.localPlayer.y >> 7) + Game.baseY;
            WorldMapType1.method196().method6011(int_, int_2, int_3, true);
            return 1;
        }
        if (int_0 == 6601) {
            final int int_ = class69.intStack[--class69.intStackSize];
            String string_0 = "";
            final WorldMapData worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
            if (worldmapdata_0 != null) {
                string_0 = worldmapdata_0.getName();
            }
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
            return 1;
        }
        if (int_0 == 6602) {
            final int int_ = class69.intStack[--class69.intStackSize];
            WorldMapType1.method196().method6012(int_);
            return 1;
        }
        if (int_0 == 6603) {
            class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6026();
            return 1;
        }
        if (int_0 == 6604) {
            final int int_ = class69.intStack[--class69.intStackSize];
            WorldMapType1.method196().method6023(int_);
            return 1;
        }
        if (int_0 == 6605) {
            class69.intStack[++class69.intStackSize - 1] = (WorldMapType1.method196().method6096() ? 1 : 0);
            return 1;
        }
        if (int_0 == 6606) {
            final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
            WorldMapType1.method196().setWorldMapPositionTarget(coordinates_3.worldX, coordinates_3.worldY);
            return 1;
        }
        if (int_0 == 6607) {
            final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
            WorldMapType1.method196().method6031(coordinates_3.worldX, coordinates_3.worldY);
            return 1;
        }
        if (int_0 == 6608) {
            final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
            WorldMapType1.method196().method6046(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
            return 1;
        }
        if (int_0 == 6609) {
            final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
            WorldMapType1.method196().method6033(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
            return 1;
        }
        if (int_0 == 6610) {
            class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6002();
            class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6035();
            return 1;
        }
        if (int_0 == 6611) {
            final int int_ = class69.intStack[--class69.intStackSize];
            final WorldMapData worldmapdata_2 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
            if (worldmapdata_2 == null) {
                class69.intStack[++class69.intStackSize - 1] = 0;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.method256().bitpack();
            }
            return 1;
        }
        if (int_0 == 6612) {
            final int int_ = class69.intStack[--class69.intStackSize];
            final WorldMapData worldmapdata_2 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
            if (worldmapdata_2 == null) {
                class69.intStack[++class69.intStackSize - 1] = 0;
                class69.intStack[++class69.intStackSize - 1] = 0;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = (worldmapdata_2.method214() - worldmapdata_2.getMinX() + 1) * 64;
                class69.intStack[++class69.intStackSize - 1] = (worldmapdata_2.method249() - worldmapdata_2.getMinY() + 1) * 64;
            }
            return 1;
        }
        if (int_0 == 6613) {
            final int int_ = class69.intStack[--class69.intStackSize];
            final WorldMapData worldmapdata_2 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
            if (worldmapdata_2 == null) {
                class69.intStack[++class69.intStackSize - 1] = 0;
                class69.intStack[++class69.intStackSize - 1] = 0;
                class69.intStack[++class69.intStackSize - 1] = 0;
                class69.intStack[++class69.intStackSize - 1] = 0;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.getMinX() * 64;
                class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.getMinY() * 64;
                class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.method214() * 64 + 64 - 1;
                class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.method249() * 64 + 64 - 1;
            }
            return 1;
        }
        if (int_0 == 6614) {
            final int int_ = class69.intStack[--class69.intStackSize];
            final WorldMapData worldmapdata_2 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
            if (worldmapdata_2 == null) {
                class69.intStack[++class69.intStackSize - 1] = -1;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.getInitialMapSurfaceZoom();
            }
            return 1;
        }
        if (int_0 == 6615) {
            final Coordinates coordinates_3 = WorldMapType1.method196().method6001();
            if (coordinates_3 == null) {
                class69.intStack[++class69.intStackSize - 1] = -1;
                class69.intStack[++class69.intStackSize - 1] = -1;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = coordinates_3.worldX;
                class69.intStack[++class69.intStackSize - 1] = coordinates_3.worldY;
            }
            return 1;
        }
        if (int_0 == 6616) {
            class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6153();
            return 1;
        }
        if (int_0 == 6617) {
            final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
            final WorldMapData worldmapdata_2 = WorldMapType1.method196().method6014();
            if (worldmapdata_2 == null) {
                class69.intStack[++class69.intStackSize - 1] = -1;
                class69.intStack[++class69.intStackSize - 1] = -1;
                return 1;
            }
            final int[] ints_0 = worldmapdata_2.method213(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
            if (ints_0 == null) {
                class69.intStack[++class69.intStackSize - 1] = -1;
                class69.intStack[++class69.intStackSize - 1] = -1;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = ints_0[0];
                class69.intStack[++class69.intStackSize - 1] = ints_0[1];
            }
            return 1;
        }
        else if (int_0 == 6618) {
            final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
            final WorldMapData worldmapdata_2 = WorldMapType1.method196().method6014();
            if (worldmapdata_2 == null) {
                class69.intStack[++class69.intStackSize - 1] = -1;
                class69.intStack[++class69.intStackSize - 1] = -1;
                return 1;
            }
            final Coordinates coordinates_4 = worldmapdata_2.method205(coordinates_3.worldX, coordinates_3.worldY);
            if (coordinates_4 == null) {
                class69.intStack[++class69.intStackSize - 1] = -1;
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = coordinates_4.bitpack();
            }
            return 1;
        }
        else {
            if (int_0 == 6619) {
                class69.intStackSize -= 2;
                final int int_ = class69.intStack[class69.intStackSize];
                final Coordinates coordinates_5 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
                final WorldMapData worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
                final int int_4 = class138.localPlayer.field567;
                final int int_5 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
                final int int_6 = (class138.localPlayer.y >> 7) + Game.baseY;
                final Coordinates coordinates_6 = new Coordinates(int_4, int_5, int_6);
                WorldMapType1.method196().method6073(worldmapdata_0, coordinates_6, coordinates_5, false);
                return 1;
            }
            if (int_0 == 6620) {
                class69.intStackSize -= 2;
                final int int_ = class69.intStack[class69.intStackSize];
                final Coordinates coordinates_5 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
                final WorldMapData worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
                final int int_4 = class138.localPlayer.field567;
                final int int_5 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
                final int int_6 = (class138.localPlayer.y >> 7) + Game.baseY;
                final Coordinates coordinates_6 = new Coordinates(int_4, int_5, int_6);
                WorldMapType1.method196().method6073(worldmapdata_0, coordinates_6, coordinates_5, true);
                return 1;
            }
            if (int_0 == 6621) {
                class69.intStackSize -= 2;
                final int int_ = class69.intStack[class69.intStackSize];
                final Coordinates coordinates_5 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
                final WorldMapData worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_);
                if (worldmapdata_0 == null) {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    return 1;
                }
                class69.intStack[++class69.intStackSize - 1] = (worldmapdata_0.containsCoord(coordinates_5.plane, coordinates_5.worldX, coordinates_5.worldY) ? 1 : 0);
                return 1;
            }
            else {
                if (int_0 == 6622) {
                    class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6142();
                    class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6038();
                    return 1;
                }
                if (int_0 == 6623) {
                    final Coordinates coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
                    final WorldMapData worldmapdata_2 = WorldMapType1.method196().getWorldMapDataContainingCoord(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
                    if (worldmapdata_2 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = worldmapdata_2.getFileId();
                    }
                    return 1;
                }
                if (int_0 == 6624) {
                    WorldMapType1.method196().method6089(class69.intStack[--class69.intStackSize]);
                    return 1;
                }
                if (int_0 == 6625) {
                    WorldMapType1.method196().method6040();
                    return 1;
                }
                if (int_0 == 6626) {
                    WorldMapType1.method196().method6041(class69.intStack[--class69.intStackSize]);
                    return 1;
                }
                if (int_0 == 6627) {
                    WorldMapType1.method196().method6042();
                    return 1;
                }
                if (int_0 == 6628) {
                    final boolean bool_ = class69.intStack[--class69.intStackSize] == 1;
                    WorldMapType1.method196().method6034(bool_);
                    return 1;
                }
                if (int_0 == 6629) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    WorldMapType1.method196().method6106(int_);
                    return 1;
                }
                if (int_0 == 6630) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    WorldMapType1.method196().method6152(int_);
                    return 1;
                }
                if (int_0 == 6631) {
                    WorldMapType1.method196().method6114();
                    return 1;
                }
                if (int_0 == 6632) {
                    final boolean bool_ = class69.intStack[--class69.intStackSize] == 1;
                    WorldMapType1.method196().method6047(bool_);
                    return 1;
                }
                if (int_0 == 6633) {
                    class69.intStackSize -= 2;
                    final int int_ = class69.intStack[class69.intStackSize];
                    final boolean bool_2 = class69.intStack[class69.intStackSize + 1] == 1;
                    WorldMapType1.method196().method6048(int_, bool_2);
                    return 1;
                }
                if (int_0 == 6634) {
                    class69.intStackSize -= 2;
                    final int int_ = class69.intStack[class69.intStackSize];
                    final boolean bool_2 = class69.intStack[class69.intStackSize + 1] == 1;
                    WorldMapType1.method196().method6049(int_, bool_2);
                    return 1;
                }
                if (int_0 == 6635) {
                    class69.intStack[++class69.intStackSize - 1] = (WorldMapType1.method196().method6050() ? 1 : 0);
                    return 1;
                }
                if (int_0 == 6636) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    class69.intStack[++class69.intStackSize - 1] = (WorldMapType1.method196().method6051(int_) ? 1 : 0);
                    return 1;
                }
                if (int_0 == 6637) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    class69.intStack[++class69.intStackSize - 1] = (WorldMapType1.method196().method6052(int_) ? 1 : 0);
                    return 1;
                }
                if (int_0 == 6638) {
                    class69.intStackSize -= 2;
                    final int int_ = class69.intStack[class69.intStackSize];
                    final Coordinates coordinates_5 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
                    final Coordinates coordinates_4 = WorldMapType1.method196().method6100(int_, coordinates_5);
                    if (coordinates_4 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = coordinates_4.bitpack();
                    }
                    return 1;
                }
                if (int_0 == 6639) {
                    final MapIcon mapicon_0 = WorldMapType1.method196().method6146();
                    if (mapicon_0 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = mapicon_0.areaId;
                        class69.intStack[++class69.intStackSize - 1] = mapicon_0.field236.bitpack();
                    }
                    return 1;
                }
                if (int_0 == 6640) {
                    final MapIcon mapicon_0 = WorldMapType1.method196().method6186();
                    if (mapicon_0 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = mapicon_0.areaId;
                        class69.intStack[++class69.intStackSize - 1] = mapicon_0.field236.bitpack();
                    }
                    return 1;
                }
                if (int_0 == 6693) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    final Area area_0 = Area.mapAreaType[int_];
                    if (area_0.name == null) {
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    }
                    else {
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = area_0.name;
                    }
                    return 1;
                }
                if (int_0 == 6694) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    final Area area_0 = Area.mapAreaType[int_];
                    class69.intStack[++class69.intStackSize - 1] = area_0.field3243;
                    return 1;
                }
                if (int_0 == 6695) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    final Area area_0 = Area.mapAreaType[int_];
                    if (area_0 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = area_0.field3240;
                    }
                    return 1;
                }
                if (int_0 == 6696) {
                    final int int_ = class69.intStack[--class69.intStackSize];
                    final Area area_0 = Area.mapAreaType[int_];
                    if (area_0 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = area_0.spriteId;
                    }
                    return 1;
                }
                if (int_0 == 6697) {
                    class69.intStack[++class69.intStackSize - 1] = ClassInfo.field3750.areaId;
                    return 1;
                }
                if (int_0 == 6698) {
                    class69.intStack[++class69.intStackSize - 1] = ClassInfo.field3750.field311.bitpack();
                    return 1;
                }
                if (int_0 == 6699) {
                    class69.intStack[++class69.intStackSize - 1] = ClassInfo.field3750.field308.bitpack();
                    return 1;
                }
                return 2;
            }
        }
    }
    
    static void method1563(final Widget widget_0, final int int_0, final int int_1, final boolean bool_0) {
        final int int_2 = widget_0.width;
        final int int_3 = widget_0.height;
        if (widget_0.dynamicWidth == 0) {
            widget_0.width = widget_0.originalWidth;
        }
        else if (widget_0.dynamicWidth == 1) {
            widget_0.width = int_0 - widget_0.originalWidth;
        }
        else if (widget_0.dynamicWidth == 2) {
            widget_0.width = widget_0.originalWidth * int_0 >> 14;
        }
        if (widget_0.buttonType == 0) {
            widget_0.height = widget_0.originalHeight;
        }
        else if (widget_0.buttonType == 1) {
            widget_0.height = int_1 - widget_0.originalHeight;
        }
        else if (widget_0.buttonType == 2) {
            widget_0.height = int_1 * widget_0.originalHeight >> 14;
        }
        if (widget_0.dynamicWidth == 4) {
            widget_0.width = widget_0.height * widget_0.field2622 / widget_0.field2623;
        }
        if (widget_0.buttonType == 4) {
            widget_0.height = widget_0.field2623 * widget_0.width / widget_0.field2622;
        }
        if (widget_0.contentType == 1337) {
            Game.field784 = widget_0;
        }
        if (bool_0 && widget_0.onResizeListener != null && (int_2 != widget_0.width || int_3 != widget_0.height)) {
            final ScriptEvent scriptevent_0 = new ScriptEvent();
            scriptevent_0.widget = widget_0;
            scriptevent_0.objs = widget_0.onResizeListener;
            Game.field638.addFront(scriptevent_0);
        }
    }
}
