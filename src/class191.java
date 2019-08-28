import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Comparator;

// 
// Decompiled by Procyon v0.5.36
// 

public class class191
{
    public static JagexGame[] method3870() {
        return new JagexGame[] { JagexGame.field3143, JagexGame.field3145, JagexGame.field3146, JagexGame.field3141, JagexGame.field3140, JagexGame.field3142 };
    }
    
    static int method3866(final int int_0, final Script script_0, final boolean bool_0) {
        if (int_0 < 1000) {
            return class32.method540(int_0, script_0, bool_0);
        }
        if (int_0 < 1100) {
            return GameEngine.method909(int_0, script_0, bool_0);
        }
        if (int_0 < 1200) {
            return Resampler.method2238(int_0, script_0, bool_0);
        }
        if (int_0 < 1300) {
            return GraphicsObject.method1768(int_0, script_0, bool_0);
        }
        if (int_0 < 1400) {
            return class21.method274(int_0, script_0, bool_0);
        }
        if (int_0 < 1500) {
            return class228.method4495(int_0, script_0, bool_0);
        }
        if (int_0 < 1600) {
            return World.method1605(int_0, script_0, bool_0);
        }
        if (int_0 < 1700) {
            final Widget widget_1 = bool_0 ? class276.field3561 : KitDefinition.field3301;
            byte byte_0;
            if (int_0 == 1600) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.scrollX;
                byte_0 = 1;
            }
            else if (int_0 == 1601) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.scrollY;
                byte_0 = 1;
            }
            else if (int_0 == 1602) {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = widget_1.text;
                byte_0 = 1;
            }
            else if (int_0 == 1603) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.scrollWidth;
                byte_0 = 1;
            }
            else if (int_0 == 1604) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.scrollHeight;
                byte_0 = 1;
            }
            else if (int_0 == 1605) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.modelZoom;
                byte_0 = 1;
            }
            else if (int_0 == 1606) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.rotationX;
                byte_0 = 1;
            }
            else if (int_0 == 1607) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.rotationY;
                byte_0 = 1;
            }
            else if (int_0 == 1608) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.rotationZ;
                byte_0 = 1;
            }
            else if (int_0 == 1609) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.opacity;
                byte_0 = 1;
            }
            else if (int_0 == 1610) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.field2608;
                byte_0 = 1;
            }
            else if (int_0 == 1611) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.textColor;
                byte_0 = 1;
            }
            else if (int_0 == 1612) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.field2631;
                byte_0 = 1;
            }
            else if (int_0 == 1613) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.field2701.vmethod5815();
                byte_0 = 1;
            }
            else if (int_0 == 1614) {
                class69.intStack[++class69.intStackSize - 1] = (widget_1.field2726 ? 1 : 0);
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 1800) {
            final Widget widget_2 = bool_0 ? class276.field3561 : KitDefinition.field3301;
            byte byte_0;
            if (int_0 == 1700) {
                class69.intStack[++class69.intStackSize - 1] = widget_2.itemId;
                byte_0 = 1;
            }
            else if (int_0 == 1701) {
                if (widget_2.itemId != -1) {
                    class69.intStack[++class69.intStackSize - 1] = widget_2.itemQuantity;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 1702) {
                class69.intStack[++class69.intStackSize - 1] = widget_2.index;
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 1900) {
            return GameEngine.method914(int_0, script_0, bool_0);
        }
        if (int_0 < 2000) {
            return class305.method5659(int_0, script_0, bool_0);
        }
        if (int_0 < 2100) {
            return GameEngine.method909(int_0, script_0, bool_0);
        }
        if (int_0 < 2200) {
            return Resampler.method2238(int_0, script_0, bool_0);
        }
        if (int_0 < 2300) {
            return GraphicsObject.method1768(int_0, script_0, bool_0);
        }
        if (int_0 < 2400) {
            return class21.method274(int_0, script_0, bool_0);
        }
        if (int_0 < 2500) {
            return class228.method4495(int_0, script_0, bool_0);
        }
        if (int_0 < 2600) {
            final Widget widget_1 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
            byte byte_0;
            if (int_0 == 2500) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.relativeX;
                byte_0 = 1;
            }
            else if (int_0 == 2501) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.relativeY;
                byte_0 = 1;
            }
            else if (int_0 == 2502) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.width;
                byte_0 = 1;
            }
            else if (int_0 == 2503) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.height;
                byte_0 = 1;
            }
            else if (int_0 == 2504) {
                class69.intStack[++class69.intStackSize - 1] = (widget_1.isHidden ? 1 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 2505) {
                class69.intStack[++class69.intStackSize - 1] = widget_1.parentHash;
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 2700) {
            return class13.method111(int_0, script_0, bool_0);
        }
        if (int_0 < 2800) {
            return Timer.method3341(int_0, script_0, bool_0);
        }
        if (int_0 < 2900) {
            return OwnWorldComparator.method1126(int_0, script_0, bool_0);
        }
        if (int_0 < 3000) {
            return class305.method5659(int_0, script_0, bool_0);
        }
        if (int_0 < 3200) {
            byte byte_0;
            if (int_0 == 3100) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                class143.sendGameMessage(0, "", string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3101) {
                class69.intStackSize -= 2;
                GameObject.method3102(class138.localPlayer, class69.intStack[class69.intStackSize], class69.intStack[class69.intStackSize + 1]);
                byte_0 = 1;
            }
            else if (int_0 == 3103) {
                final PacketNode packetnode_2 = class26.method433(ClientPacket.CLOSED_WINDOW, Game.field626.field1218);
                Game.field626.method1980(packetnode_2);
                for (WidgetNode widgetnode_0 = (WidgetNode)Game.componentTable.first(); widgetnode_0 != null; widgetnode_0 = (WidgetNode)Game.componentTable.next()) {
                    if (widgetnode_0.owner == 0 || widgetnode_0.owner == 3) {
                        WorldMapData.closeWidget(widgetnode_0, true);
                    }
                }
                if (Game.field744 != null) {
                    Player.method1114(Game.field744);
                    Game.field744 = null;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3104) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                int int_ = 0;
                if (Resampler.method2249(string_0)) {
                    final int int_2 = int_ = class68.parseInt(string_0, 10, true);
                }
                final PacketNode packetnode_3 = class26.method433(ClientPacket.NUMERIC_INTEGER_INPUT, Game.field626.field1218);
                packetnode_3.packetBuffer.putInt(int_);
                Game.field626.method1980(packetnode_3);
                byte_0 = 1;
            }
            else if (int_0 == 3105) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                final PacketNode packetnode_4 = class26.method433(ClientPacket.STRING_INPUT, Game.field626.field1218);
                packetnode_4.packetBuffer.putByte(string_0.length() + 1);
                packetnode_4.packetBuffer.putString(string_0);
                Game.field626.method1980(packetnode_4);
                byte_0 = 1;
            }
            else if (int_0 == 3106) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                final PacketNode packetnode_4 = class26.method433(ClientPacket.field2136, Game.field626.field1218);
                packetnode_4.packetBuffer.putByte(string_0.length() + 1);
                packetnode_4.packetBuffer.putString(string_0);
                Game.field626.method1980(packetnode_4);
                byte_0 = 1;
            }
            else if (int_0 == 3107) {
            	System.out.println("test");
                final int int_3 = class69.intStack[--class69.intStackSize];
                final String string_2 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                final int int_2 = class81.playerIndexesCount;
                final int[] ints_0 = class81.playerIndices;
                boolean bool_ = false;
                final Name name_0 = new Name(string_2, MapIconReference.loginType);
                for (int int_4 = 0; int_4 < int_2; ++int_4) {
                    final Player player_0 = Game.cachedPlayers[ints_0[int_4]];
                    if (player_0 != null && player_0 != class138.localPlayer && player_0.name != null && player_0.name.equals(name_0)) {
                        if (int_3 == 1) {
                            final PacketNode packetnode_5 = class26.method433(ClientPacket.PLAYER_INTERACT_ONE, Game.field626.field1218);
                            packetnode_5.packetBuffer.putByte(0);
                            packetnode_5.packetBuffer.putShort(ints_0[int_4]);
                            Game.field626.method1980(packetnode_5);
                        }
                        else if (int_3 == 4) {
                            final PacketNode packetnode_5 = class26.method433(ClientPacket.PLAYER_INTERACT_FOUR, Game.field626.field1218);
                            packetnode_5.packetBuffer.addLEShortA(ints_0[int_4]);
                            packetnode_5.packetBuffer.putByte(0);
                            Game.field626.method1980(packetnode_5);
                        }
                        else if (int_3 == 6) {
                            final PacketNode packetnode_5 = class26.method433(ClientPacket.PLAYER_INTERACT_SIX, Game.field626.field1218);
                            packetnode_5.packetBuffer.addByteC(0);
                            packetnode_5.packetBuffer.addLEShortA(ints_0[int_4]);
                            Game.field626.method1980(packetnode_5);
                        }
                        else if (int_3 == 7) {
                            final PacketNode packetnode_5 = class26.method433(ClientPacket.PLAYER_INTERACT_SEVEN, Game.field626.field1218);
                            packetnode_5.packetBuffer.addLEShort(ints_0[int_4]);
                            packetnode_5.packetBuffer.addByteA(0);
                            Game.field626.method1980(packetnode_5);
                        }
                        bool_ = true;
                        break;
                    }
                }
                if (!bool_) {
                    class143.sendGameMessage(4, "", "Unable to find " + string_2);
                }
                byte_0 = 1;
            }
            else if (int_0 == 3108) {
                class69.intStackSize -= 3;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                final int int_2 = class69.intStack[class69.intStackSize + 2];
                final Widget widget_2 = Widget.getWidget(int_2);
                ClientPacket.method3447(widget_2, int_3, int_);
                byte_0 = 1;
            }
            else if (int_0 == 3109) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                final Widget widget_3 = bool_0 ? class276.field3561 : KitDefinition.field3301;
                ClientPacket.method3447(widget_3, int_3, int_);
                byte_0 = 1;
            }
            else if (int_0 == 3110) {
                InvType.middleMouseMovesCamera = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3111) {
                class69.intStack[++class69.intStackSize - 1] = (class10.preferences.hideRoofs ? 1 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 3112) {
                class10.preferences.hideRoofs = (class69.intStack[--class69.intStackSize] == 1);
                class54.method1018();
                byte_0 = 1;
            }
            else if (int_0 == 3113) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                final boolean bool_2 = class69.intStack[--class69.intStackSize] == 1;
                HorizontalAlignment.method5156(string_0, bool_2, false);
                byte_0 = 1;
            }
            else if (int_0 == 3115) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                final PacketNode packetnode_4 = class26.method433(ClientPacket.NUMERIC_SHORT_INPUT, Game.field626.field1218);
                packetnode_4.packetBuffer.putShort(int_3);
                Game.field626.method1980(packetnode_4);
                byte_0 = 1;
            }
            else if (int_0 == 3116) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                WidgetNode.scriptStringStackSize -= 2;
                final String string_2 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
                final String string_3 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
                if (string_2.length() > 500) {
                    byte_0 = 1;
                }
                else if (string_3.length() > 500) {
                    byte_0 = 1;
                }
                else {
                    final PacketNode packetnode_6 = class26.method433(ClientPacket.field2167, Game.field626.field1218);
                    packetnode_6.packetBuffer.putShort(1 + class316.getLength(string_2) + class316.getLength(string_3));
                    packetnode_6.packetBuffer.addByteC(int_3);
                    packetnode_6.packetBuffer.putString(string_3);
                    packetnode_6.packetBuffer.putString(string_2);
                    Game.field626.method1980(packetnode_6);
                    byte_0 = 1;
                }
            }
            else if (int_0 == 3117) {
                Game.field726 = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3118) {
                Game.field728 = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3119) {
                Game.field699 = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3120) {
                if (class69.intStack[--class69.intStackSize] == 1) {
                    Game.playerNameMask |= 0x1;
                }
                else {
                    Game.playerNameMask &= 0xFFFFFFFE;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3121) {
                if (class69.intStack[--class69.intStackSize] == 1) {
                    Game.playerNameMask |= 0x2;
                }
                else {
                    Game.playerNameMask &= 0xFFFFFFFD;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3122) {
                if (class69.intStack[--class69.intStackSize] == 1) {
                    Game.playerNameMask |= 0x4;
                }
                else {
                    Game.playerNameMask &= 0xFFFFFFFB;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3123) {
                if (class69.intStack[--class69.intStackSize] == 1) {
                    Game.playerNameMask |= 0x8;
                }
                else {
                    Game.playerNameMask &= 0xFFFFFFF7;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3124) {
                Game.playerNameMask = 0;
                byte_0 = 1;
            }
            else if (int_0 == 3125) {
                Game.field621 = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3126) {
                Game.field677 = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3127) {
                final boolean bool_3 = Game.field727 = (class69.intStack[--class69.intStackSize] == 1);
                byte_0 = 1;
            }
            else if (int_0 == 3128) {
                final int[] ints_2 = class69.intStack;
                final int int_ = ++class69.intStackSize - 1;
                final boolean bool_4 = Game.field727;
                ints_2[int_] = (bool_4 ? 1 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 3129) {
                class69.intStackSize -= 2;
                Game.field750 = class69.intStack[class69.intStackSize];
                Game.field661 = class69.intStack[class69.intStackSize + 1];
                byte_0 = 1;
            }
            else if (int_0 == 3130) {
                class69.intStackSize -= 2;
                byte_0 = 1;
            }
            else if (int_0 == 3131) {
                --class69.intStackSize;
                byte_0 = 1;
            }
            else if (int_0 == 3132) {
                class69.intStack[++class69.intStackSize - 1] = Varcs.canvasWidth;
                class69.intStack[++class69.intStackSize - 1] = BuildType.canvasHeight;
                byte_0 = 1;
            }
            else if (int_0 == 3133) {
                --class69.intStackSize;
                byte_0 = 1;
            }
            else if (int_0 == 3134) {
                byte_0 = 1;
            }
            else if (int_0 == 3138) {
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 3300) {
            byte byte_0;
            if (int_0 == 3200) {
                class69.intStackSize -= 3;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                final int int_2 = class69.intStack[class69.intStackSize + 2];
                if (Game.field814 != 0 && int_ != 0 && Game.queuedSoundEffectCount < 50) {
                    Game.queuedSoundEffectIDs[Game.queuedSoundEffectCount] = int_3;
                    Game.unknownSoundValues1[Game.queuedSoundEffectCount] = int_;
                    Game.unknownSoundValues2[Game.queuedSoundEffectCount] = int_2;
                    Game.audioEffects[Game.queuedSoundEffectCount] = null;
                    Game.soundLocations[Game.queuedSoundEffectCount] = 0;
                    ++Game.queuedSoundEffectCount;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3201) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (int_3 == -1 && !Game.field813) {
                    class9.method88();
                }
                else if (int_3 != -1 && int_3 != Game.field812 && Game.field811 != 0 && !Game.field813) {
                    World.method1602(2, Item.indexTrack1, int_3, 0, Game.field811, false);
                }
                Game.field812 = int_3;
                byte_0 = 1;
            }
            else if (int_0 == 3202) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                if (Game.field811 != 0 && int_3 != -1) {
                    Actor.method1554(OwnWorldComparator.indexTrack2, int_3, 0, Game.field811, false);
                    Game.field813 = true;
                }
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 3400) {
            return class173.method3469(int_0, script_0, bool_0);
        }
        if (int_0 < 3500) {
            byte byte_0;
            if (int_0 == 3400) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                Enum enum_2 = Buffer.method3603(int_3);
                if (enum_2.valType != 's') {}
                for (int int_5 = 0; int_5 < enum_2.size; ++int_5) {
                    if (int_ == enum_2.keys[int_5]) {
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = enum_2.stringVals[int_5];
                        enum_2 = null;
                        break;
                    }
                }
                if (enum_2 != null) {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = enum_2.defaultString;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3408) {
                class69.intStackSize -= 4;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                final int int_2 = class69.intStack[class69.intStackSize + 2];
                final int int_5 = class69.intStack[class69.intStackSize + 3];
                Enum enum_3 = Buffer.method3603(int_2);
                if (int_3 == enum_3.keyType && int_ == enum_3.valType) {
                    for (int int_6 = 0; int_6 < enum_3.size; ++int_6) {
                        if (int_5 == enum_3.keys[int_6]) {
                            if (int_ == 115) {
                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = enum_3.stringVals[int_6];
                            }
                            else {
                                class69.intStack[++class69.intStackSize - 1] = enum_3.intVals[int_6];
                            }
                            enum_3 = null;
                            break;
                        }
                    }
                    if (enum_3 != null) {
                        if (int_ == 115) {
                            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = enum_3.defaultString;
                        }
                        else {
                            class69.intStack[++class69.intStackSize - 1] = enum_3.defaultInt;
                        }
                    }
                    byte_0 = 1;
                }
                else {
                    if (int_ == 115) {
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "null";
                    }
                    else {
                        class69.intStack[++class69.intStackSize - 1] = 0;
                    }
                    byte_0 = 1;
                }
            }
            else if (int_0 == 3411) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                final Enum enum_4 = Buffer.method3603(int_3);
                class69.intStack[++class69.intStackSize - 1] = enum_4.method4980();
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 3700) {
            byte byte_0;
            if (int_0 == 3600) {
                if (DState.friendManager.field976 == 0) {
                    class69.intStack[++class69.intStackSize - 1] = -2;
                }
                else if (DState.friendManager.field976 == 1) {
                    class69.intStack[++class69.intStackSize - 1] = -1;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = DState.friendManager.field970.getCount();
                }
                byte_0 = 1;
            }
            else if (int_0 == 3601) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (DState.friendManager.method1624() && int_3 >= 0 && int_3 < DState.friendManager.field970.getCount()) {
                    final Friend friend_0 = (Friend)DState.friendManager.field970.get(int_3);
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = friend_0.method5288();
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = friend_0.method5289();
                }
                else {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }
                byte_0 = 1;
            }
            else if (int_0 == 3602) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (DState.friendManager.method1624() && int_3 >= 0 && int_3 < DState.friendManager.field970.getCount()) {
                    class69.intStack[++class69.intStackSize - 1] = ((ChatPlayer)DState.friendManager.field970.get(int_3)).world;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3603) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (DState.friendManager.method1624() && int_3 >= 0 && int_3 < DState.friendManager.field970.getCount()) {
                    class69.intStack[++class69.intStackSize - 1] = ((ChatPlayer)DState.friendManager.field970.get(int_3)).rank;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3604) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                final int int_ = class69.intStack[--class69.intStackSize];
                final PacketNode packetnode_3 = class26.method433(ClientPacket.RANK_FRIEND, Game.field626.field1218);
                packetnode_3.packetBuffer.putByte(class316.getLength(string_0) + 1);
                packetnode_3.packetBuffer.addByteA(int_);
                packetnode_3.packetBuffer.putString(string_0);
                Game.field626.method1980(packetnode_3);
                byte_0 = 1;
            }
            else if (int_0 == 3605) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                DState.friendManager.addToFriendsList(string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3606) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                DState.friendManager.method1665(string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3607) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                DState.friendManager.addToIgnoreList(string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3608) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                DState.friendManager.method1636(string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3609) {
                String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                string_0 = class139.method3138(string_0);
                class69.intStack[++class69.intStackSize - 1] = ((DState.friendManager.isFriended(new Name(string_0, MapIconReference.loginType), false) || script_0.id == 73) ? 1 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 3611) {
                if (WorldMapType3.clanMemberManager != null) {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = WorldMapType3.clanMemberManager.field3654;
                }
                else {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }
                byte_0 = 1;
            }
            else if (int_0 == 3612) {
                if (WorldMapType3.clanMemberManager != null) {
                    class69.intStack[++class69.intStackSize - 1] = WorldMapType3.clanMemberManager.getCount();
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3613) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (WorldMapType3.clanMemberManager != null && int_3 < WorldMapType3.clanMemberManager.getCount()) {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = WorldMapType3.clanMemberManager.get(int_3).method5287().getName();
                }
                else {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }
                byte_0 = 1;
            }
            else if (int_0 == 3614) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (WorldMapType3.clanMemberManager != null && int_3 < WorldMapType3.clanMemberManager.getCount()) {
                    class69.intStack[++class69.intStackSize - 1] = ((ChatPlayer)WorldMapType3.clanMemberManager.get(int_3)).method5414();
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3615) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (WorldMapType3.clanMemberManager != null && int_3 < WorldMapType3.clanMemberManager.getCount()) {
                    class69.intStack[++class69.intStackSize - 1] = ((ChatPlayer)WorldMapType3.clanMemberManager.get(int_3)).rank;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3616) {
                class69.intStack[++class69.intStackSize - 1] = ((WorldMapType3.clanMemberManager != null) ? WorldMapType3.clanMemberManager.field3651 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 3617) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                class177.method3508(string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3618) {
                class69.intStack[++class69.intStackSize - 1] = ((WorldMapType3.clanMemberManager != null) ? WorldMapType3.clanMemberManager.field3657 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 3619) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                Size.method110(string_0);
                byte_0 = 1;
            }
            else if (int_0 == 3620) {
                final PacketNode packetnode_2 = class26.method433(ClientPacket.field2153, Game.field626.field1218);
                packetnode_2.packetBuffer.putByte(0);
                Game.field626.method1980(packetnode_2);
                byte_0 = 1;
            }
            else if (int_0 == 3621) {
                if (!DState.friendManager.method1624()) {
                    class69.intStack[++class69.intStackSize - 1] = -1;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = DState.friendManager.field975.getCount();
                }
                byte_0 = 1;
            }
            else if (int_0 == 3622) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (DState.friendManager.method1624() && int_3 >= 0 && int_3 < DState.friendManager.field975.getCount()) {
                    final Ignore ignore_0 = (Ignore)DState.friendManager.field975.get(int_3);
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = ignore_0.method5288();
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = ignore_0.method5289();
                }
                else {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }
                byte_0 = 1;
            }
            else if (int_0 == 3623) {
                String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                string_0 = class139.method3138(string_0);
                class69.intStack[++class69.intStackSize - 1] = (DState.friendManager.isIgnored(new Name(string_0, MapIconReference.loginType)) ? 1 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 3624) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (WorldMapType3.clanMemberManager != null && int_3 < WorldMapType3.clanMemberManager.getCount() && WorldMapType3.clanMemberManager.get(int_3).method5287().equals(class138.localPlayer.name)) {
                    class69.intStack[++class69.intStackSize - 1] = 1;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3625) {
                if (WorldMapType3.clanMemberManager != null && WorldMapType3.clanMemberManager.field3655 != null) {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = WorldMapType3.clanMemberManager.field3655;
                }
                else {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }
                byte_0 = 1;
            }
            else if (int_0 == 3626) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (WorldMapType3.clanMemberManager != null && int_3 < WorldMapType3.clanMemberManager.getCount() && ((ClanMember)WorldMapType3.clanMemberManager.get(int_3)).method5266()) {
                    class69.intStack[++class69.intStackSize - 1] = 1;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3627) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                if (WorldMapType3.clanMemberManager != null && int_3 < WorldMapType3.clanMemberManager.getCount() && ((ClanMember)WorldMapType3.clanMemberManager.get(int_3)).method5267()) {
                    class69.intStack[++class69.intStackSize - 1] = 1;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                byte_0 = 1;
            }
            else if (int_0 == 3628) {
                DState.friendManager.field970.method5346();
                byte_0 = 1;
            }
            else if (int_0 == 3629) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class308(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3630) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class309(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3631) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class143(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3632) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class137(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3633) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class142(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3634) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class145(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3635) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class141(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3636) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class139(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3637) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class138(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3638) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class140(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3639) {
                DState.friendManager.field970.method5337();
                byte_0 = 1;
            }
            else if (int_0 == 3640) {
                DState.friendManager.field975.method5346();
                byte_0 = 1;
            }
            else if (int_0 == 3641) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field975.method5347(new class308(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3642) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field975.method5347(new class309(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3643) {
                DState.friendManager.field975.method5337();
                byte_0 = 1;
            }
            else if (int_0 == 3644) {
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5346();
                }
                byte_0 = 1;
            }
            else if (int_0 == 3645) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class308(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3646) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class309(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3647) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class143(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3648) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class137(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3649) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class142(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3650) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class145(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3651) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class141(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3652) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class139(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3653) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class138(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3654) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class140(bool_3));
                }
                byte_0 = 1;
            }
            else if (int_0 == 3655) {
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5337();
                }
                byte_0 = 1;
            }
            else if (int_0 == 3656) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                DState.friendManager.field970.method5347(new class144(bool_3));
                byte_0 = 1;
            }
            else if (int_0 == 3657) {
                final boolean bool_3 = class69.intStack[--class69.intStackSize] == 1;
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5347(new class144(bool_3));
                }
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 4000) {
            return MapCacheArchiveNames.method477(int_0, script_0, bool_0);
        }
        if (int_0 < 4100) {
            byte byte_0;
            if (int_0 == 4000) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = int_ + int_3;
                byte_0 = 1;
            }
            else if (int_0 == 4001) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = int_3 - int_;
                byte_0 = 1;
            }
            else if (int_0 == 4002) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = int_ * int_3;
                byte_0 = 1;
            }
            else if (int_0 == 4003) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = int_3 / int_;
                byte_0 = 1;
            }
            else if (int_0 == 4004) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                class69.intStack[++class69.intStackSize - 1] = (int)(Math.random() * int_3);
                byte_0 = 1;
            }
            else if (int_0 == 4005) {
                final int int_3 = class69.intStack[--class69.intStackSize];
                class69.intStack[++class69.intStackSize - 1] = (int)(Math.random() * (int_3 + 1));
                byte_0 = 1;
            }
            else if (int_0 == 4006) {
                class69.intStackSize -= 5;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                final int int_2 = class69.intStack[class69.intStackSize + 2];
                final int int_5 = class69.intStack[class69.intStackSize + 3];
                final int int_7 = class69.intStack[class69.intStackSize + 4];
                class69.intStack[++class69.intStackSize - 1] = int_3 + (int_7 - int_2) * (int_ - int_3) / (int_5 - int_2);
                byte_0 = 1;
            }
            else if (int_0 == 4007) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = int_3 + int_ * int_3 / 100;
                byte_0 = 1;
            }
            else if (int_0 == 4008) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = (int_3 | 1 << int_);
                byte_0 = 1;
            }
            else if (int_0 == 4009) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = (int_3 & -1 - (1 << int_));
                byte_0 = 1;
            }
            else if (int_0 == 4010) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = (((int_3 & 1 << int_) != 0x0) ? 1 : 0);
                byte_0 = 1;
            }
            else if (int_0 == 4011) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = int_3 % int_;
                byte_0 = 1;
            }
            else if (int_0 == 4012) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                if (int_3 == 0) {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                }
                else {
                    class69.intStack[++class69.intStackSize - 1] = (int)Math.pow(int_3, int_);
                }
                byte_0 = 1;
            }
            else if (int_0 == 4013) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                if (int_3 == 0) {
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    byte_0 = 1;
                }
                else {
                    switch (int_) {
                        case 0: {
                            class69.intStack[++class69.intStackSize - 1] = Integer.MAX_VALUE;
                            break;
                        }
                        case 1: {
                            class69.intStack[++class69.intStackSize - 1] = int_3;
                            break;
                        }
                        case 2: {
                            class69.intStack[++class69.intStackSize - 1] = (int)Math.sqrt(int_3);
                            break;
                        }
                        case 3: {
                            class69.intStack[++class69.intStackSize - 1] = (int)Math.cbrt(int_3);
                            break;
                        }
                        case 4: {
                            class69.intStack[++class69.intStackSize - 1] = (int)Math.sqrt(Math.sqrt(int_3));
                            break;
                        }
                        default: {
                            class69.intStack[++class69.intStackSize - 1] = (int)Math.pow(int_3, 1.0 / int_);
                            break;
                        }
                    }
                    byte_0 = 1;
                }
            }
            else if (int_0 == 4014) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = (int_3 & int_);
                byte_0 = 1;
            }
            else if (int_0 == 4015) {
                class69.intStackSize -= 2;
                final int int_3 = class69.intStack[class69.intStackSize];
                final int int_ = class69.intStack[class69.intStackSize + 1];
                class69.intStack[++class69.intStackSize - 1] = (int_3 | int_);
                byte_0 = 1;
            }
            else if (int_0 == 4018) {
                class69.intStackSize -= 3;
                final long long_0 = class69.intStack[class69.intStackSize];
                final long long_2 = class69.intStack[class69.intStackSize + 1];
                final long long_3 = class69.intStack[class69.intStackSize + 2];
                class69.intStack[++class69.intStackSize - 1] = (int)(long_3 * long_0 / long_2);
                byte_0 = 1;
            }
            else {
                byte_0 = 2;
            }
            return byte_0;
        }
        if (int_0 < 4200) {
            return MouseRecorder.method1034(int_0, script_0, bool_0);
        }
        if (int_0 < 4300) {
            return class73.method1799(int_0, script_0, bool_0);
        }
        if (int_0 < 5100) {
            return WorldMapType3.method139(int_0, script_0, bool_0);
        }
        if (int_0 < 5400) {
            return class6.method74(int_0, script_0, bool_0);
        }
        if (int_0 < 5600) {
            return DState.method3526(int_0, script_0, bool_0);
        }
        if (int_0 < 5700) {
            return TextureProvider.method2531(int_0, script_0, bool_0);
        }
        if (int_0 < 6300) {
            return class151.method3240(int_0, script_0, bool_0);
        }
        if (int_0 < 6400) {
            return handleCustomInstructions(int_0, script_0, bool_0);
        }
        if (int_0 < 6600) {
            return UnitPriceComparator.method59(int_0, script_0, bool_0);
        }
        if (int_0 < 6700) {
            return CombatInfo1.method1558(int_0, script_0, bool_0);
        }
        return 2;
    }
    
    private static int handleCustomInstructions(final int opcode, final Script script, final boolean flag) {
        final int[] intStack = class69.intStack;
        int isp = class69.intStackSize;
        final String[] stringStack = class69.scriptStringStack;
        int ssp = WidgetNode.scriptStringStackSize;
        switch (opcode) {
            case 6300: {
                intStack[isp++] = (int)(Buffer.safeCurrentTimeMillis() / 60000L);
                break;
            }
            case 6301: {
                intStack[isp++] = (int)(Buffer.safeCurrentTimeMillis() / 86400000L) - 11745;
                break;
            }
            case 6302: {
                isp -= 3;
                final int day = intStack[isp];
                final int month = intStack[isp + 1];
                final int year = intStack[isp + 2];
                class192.GMT_CALENDAR.clear();
                class192.GMT_CALENDAR.set(year, month, day, 12, 0, 0);
                final long timestamp = class192.GMT_CALENDAR.getTime().getTime();
                int runeday = (int)(timestamp / 86400000L) - 11745;
                if (year < 1970) {
                    --runeday;
                }
                intStack[isp++] = runeday;
                break;
            }
            case 6303: {
                class192.LOCAL_CALENDAR.setTime(new Date(Buffer.safeCurrentTimeMillis()));
                intStack[isp++] = class192.LOCAL_CALENDAR.get(1);
                break;
            }
            case 6304: {
                final int year2 = intStack[--isp];
                boolean leap = true;
                if (year2 < 0) {
                    leap = ((year2 + 1) % 4 == 0);
                }
                else if (year2 < 1582) {
                    leap = (year2 % 4 == 0);
                }
                else if (year2 % 4 != 0) {
                    leap = false;
                }
                else if (year2 % 100 != 0) {
                    leap = true;
                }
                else if (year2 % 400 != 0) {
                    leap = false;
                }
                intStack[isp++] = (leap ? 1 : 0);
                break;
            }
            case 6305: {
                final int runeday2 = intStack[--isp];
                class192.LOCAL_CALENDAR.setTime(new Date(86400000L * (runeday2 + 11745)));
                intStack[isp++] = class192.LOCAL_CALENDAR.get(5);
                intStack[isp++] = class192.LOCAL_CALENDAR.get(2);
                intStack[isp++] = class192.LOCAL_CALENDAR.get(1);
                break;
            }
            case 6306: {
                final int runeday2 = intStack[--isp];
                intStack[isp++] = (int)(86400000L * (runeday2 + 11745) / 60000L);
                break;
            }
            case 6307: {
                final int minutes = intStack[--isp];
                class192.GMT_CALENDAR.setTime(new Date(minutes * 60000L));
                final int date = class192.GMT_CALENDAR.get(5);
                final int month2 = class192.GMT_CALENDAR.get(2);
                final int year3 = class192.GMT_CALENDAR.get(1);
                final int hour = class192.GMT_CALENDAR.get(11);
                final int minute = class192.GMT_CALENDAR.get(12);
                final String dateString = Integer.toString(date / 10) + date % 10 + '-' + class192.MONTHS_ABBREVIATED[0][month2] + '-' + year3;
                final String timeString = Integer.toString(hour / 10) + hour % 10 + ":" + minute / 10 + minute % 10;
                stringStack[ssp++] = dateString + " " + timeString + " UTC";
                break;
            }
            case 6308: {
                final int minutes = intStack[--isp];
                final SimpleDateFormat format = new SimpleDateFormat(stringStack[--ssp]);
                class192.GMT_CALENDAR.setTime(new Date(minutes * 60000L));
                stringStack[ssp++] = format.format(class192.GMT_CALENDAR.getTime());
                break;
            }
            case 6309: {
                stringStack[ssp++] = class78.password;
                break;
            }
            default: {
                return 2;
            }
        }
        class69.intStackSize = isp;
        WidgetNode.scriptStringStackSize = ssp;
        return 1;
    }
}
