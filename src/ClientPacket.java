// 
// Decompiled by Procyon v0.5.36
// 

public class ClientPacket implements class167
{
    static final ClientPacket SPELL_ON_NPC;
    static final ClientPacket field2136;
    static final ClientPacket PLAYER_INTERACT_THREE;
    static final ClientPacket RANK_FRIEND;
    static final ClientPacket OBJECT_ACTION_FIVE;
    static final ClientPacket NUMERIC_SHORT_INPUT;
    static final ClientPacket field2153;
    static final ClientPacket field2142;
    static final ClientPacket WORLD_MAP_TELEPORT;
    static final ClientPacket INTERFACE_ACTION_4;
    static final ClientPacket field2145;
    static final ClientPacket INTERFACE_ACTION_2;
    static final ClientPacket field2147;
    static final ClientPacket field2148;
    static final ClientPacket field2151;
    static final ClientPacket NUMERIC_INTEGER_INPUT;
    static final ClientPacket OBJECT_THIRD_ACTION;
    static final ClientPacket field2152;
    static final ClientPacket field2174;
    static final ClientPacket PRIVATE_MESSAGE;
    static final ClientPacket INTERFACE_ACTION_3;
    static final ClientPacket THIRD_NPC_ACTION;
    static final ClientPacket INTERFACE_ACTION_9;
    static final ClientPacket field2171;
    static final ClientPacket field2210;
    static final ClientPacket INTERFACE_ACTION_7;
    static final ClientPacket TAKE_ITEM;
    static final ClientPacket field2234;
    static final ClientPacket PLAYER_INTERACT_SIX;
    static final ClientPacket TWO_INTERFACES_MOVE_ITEM;
    static final ClientPacket EXAMINE_NPC;
    static final ClientPacket field2140;
    static final ClientPacket field2167;
    static final ClientPacket EXAMINE_ITEM;
    static final ClientPacket OBJECT_SECOND_ACTION;
    static final ClientPacket MOVE_ITEM;
    static final ClientPacket OBJECT_FIRST_ACTION;
    static final ClientPacket ITEM_ON_INTERFACE;
    static final ClientPacket APPEARANCE;
    static final ClientPacket THIRD_ITEM_ACTION;
    static final ClientPacket FIRST_ITEM_ACTION;
    static final ClientPacket field2176;
    static final ClientPacket DROP_ITEM;
    static final ClientPacket ITEM_ON_NPC;
    static final ClientPacket CHATBOX_INPUT;
    static final ClientPacket INTERFACE_ACTION_10;
    static final ClientPacket PLAYER_INTERACT_TWO;
    static final ClientPacket OBJECT_FOURTH_ACTION;
    static final ClientPacket REMOVE_IGNORE;
    static final ClientPacket SPELL_ON_ITEM;
    static final ClientPacket field2183;
    static final ClientPacket field2205;
    static final ClientPacket field2190;
    static final ClientPacket field2188;
    static final ClientPacket ITEM_ON_PLAYER;
    static final ClientPacket SPELL_ON_GROUND_ITEM;
    static final ClientPacket FOURTH_ITEM_ACTION;
    static final ClientPacket SETTINGS;
    static final ClientPacket SECOND_ITEM_ACTION;
    static final ClientPacket ADD_FRIEND;
    static final ClientPacket field2159;
    static final ClientPacket ITEM_ON_ITEM;
    static final ClientPacket field2227;
    static final ClientPacket INTERFACE_ACTION_1;
    static final ClientPacket ITEM_ON_OBJECT;
    static final ClientPacket field2200;
    static final ClientPacket field2201;
    static final ClientPacket field2202;
    static final ClientPacket REMOVE_FRIEND;
    static final ClientPacket CLOSED_WINDOW;
    static final ClientPacket REGION_UPDATE;
    static final ClientPacket PLAYER_INTERACT_ONE;
    static final ClientPacket FIRST_NPC_ACTION;
    static final ClientPacket FIFTH_NPC_ACTION;
    static final ClientPacket STRING_INPUT;
    static final ClientPacket field2185;
    static final ClientPacket field2211;
    static final ClientPacket SPELL_ON_PLAYER;
    static final ClientPacket INTERFACE_ACTION_5;
    static final ClientPacket field2214;
    static final ClientPacket RESIZE_CLIENT_FRAME;
    static final ClientPacket EXAMINE_OBJECT;
    static final ClientPacket PLAYER_INTERACT_FIVE;
    static final ClientPacket field2218;
    static final ClientPacket WALK;
    static final ClientPacket PLAYER_INTERACT_FOUR;
    static final ClientPacket ADD_IGNORE;
    static final ClientPacket PLAYER_INTERACT_SEVEN;
    static final ClientPacket SECOND_NPC_ACTION;
    static final ClientPacket PLAYER_INTERACT_EIGHT;
    static final ClientPacket CLIENT_COMMAND;
    static final ClientPacket INTERFACE_ACTION_8;
    static final ClientPacket ADVANCE_DIALOGUE;
    static final ClientPacket field2228;
    static final ClientPacket FOURTH_NPC_ACTION;
    static final ClientPacket SMALL_BUTTON_PRESS;
    static final ClientPacket INTERFACE_ACTION_6;
    static final ClientPacket MINIMAP_WALK;
    final int packetId;
    final int packetLength;
    
    ClientPacket(final int packetId, final int packetLength) {
        this.packetId = packetId;
        this.packetLength = packetLength;
    }
    
    static void method3446(final int[] ints_0, final int[] ints_1) {
        if (ints_0 != null && ints_1 != null) {
            class183.field2348 = ints_0;
            class183.field2347 = new int[ints_0.length];
            class183.field2341 = new byte[ints_0.length][][];
            for (int int_0 = 0; int_0 < class183.field2348.length; ++int_0) {
                class183.field2341[int_0] = new byte[ints_1[int_0]][];
            }
        }
        else {
            class183.field2348 = null;
            class183.field2347 = null;
            class183.field2341 = null;
        }
    }
    
    static void method3447(final Widget widget_0, final int int_0, final int int_1) {
        if (Game.draggedWidget == null && !Game.isMenuOpen && widget_0 != null && class21.method264(widget_0) != null) {
            Game.draggedWidget = widget_0;
            Game.field752 = class21.method264(widget_0);
            Game.field753 = int_0;
            Game.field749 = int_1;
            class6.field39 = 0;
            Game.draggingWidget = false;
            final int int_2 = Game.menuOptionCount - 1;
            if (int_2 != -1) {
                class229.topContextMenuRow = new ContextMenuRow();
                class229.topContextMenuRow.param0 = Game.menuActionParams0[int_2];
                class229.topContextMenuRow.param1 = Game.menuActionParams1[int_2];
                class229.topContextMenuRow.type = Game.menuTypes[int_2];
                class229.topContextMenuRow.identifier = Game.menuIdentifiers[int_2];
                class229.topContextMenuRow.option = Game.menuOptions[int_2];
            }
        }
    }
    
    static {
        SPELL_ON_NPC = new ClientPacket(0, 9);
        field2136 = new ClientPacket(1, -1);
        PLAYER_INTERACT_THREE = new ClientPacket(2, 3);
        RANK_FRIEND = new ClientPacket(3, -1);
        OBJECT_ACTION_FIVE = new ClientPacket(4, 7);
        NUMERIC_SHORT_INPUT = new ClientPacket(5, 2);
        field2153 = new ClientPacket(6, -1);
        field2142 = new ClientPacket(7, 0);
        WORLD_MAP_TELEPORT = new ClientPacket(8, 9);
        INTERFACE_ACTION_4 = new ClientPacket(9, 8);
        field2145 = new ClientPacket(10, -1);
        INTERFACE_ACTION_2 = new ClientPacket(11, 8);
        field2147 = new ClientPacket(12, 7);
        field2148 = new ClientPacket(13, 4);
        field2151 = new ClientPacket(14, 8);
        NUMERIC_INTEGER_INPUT = new ClientPacket(15, 4);
        OBJECT_THIRD_ACTION = new ClientPacket(16, 7);
        field2152 = new ClientPacket(17, 0);
        field2174 = new ClientPacket(18, -1);
        PRIVATE_MESSAGE = new ClientPacket(19, -2);
        INTERFACE_ACTION_3 = new ClientPacket(20, 8);
        THIRD_NPC_ACTION = new ClientPacket(21, 3);
        INTERFACE_ACTION_9 = new ClientPacket(22, 8);
        field2171 = new ClientPacket(23, 8);
        field2210 = new ClientPacket(24, 7);
        INTERFACE_ACTION_7 = new ClientPacket(25, 8);
        TAKE_ITEM = new ClientPacket(26, 7);
        field2234 = new ClientPacket(27, 15);
        PLAYER_INTERACT_SIX = new ClientPacket(28, 3);
        TWO_INTERFACES_MOVE_ITEM = new ClientPacket(29, 16);
        EXAMINE_NPC = new ClientPacket(30, 2);
        field2140 = new ClientPacket(31, 8);
        field2167 = new ClientPacket(32, -2);
        EXAMINE_ITEM = new ClientPacket(33, 2);
        OBJECT_SECOND_ACTION = new ClientPacket(34, 7);
        MOVE_ITEM = new ClientPacket(35, 9);
        OBJECT_FIRST_ACTION = new ClientPacket(36, 7);
        ITEM_ON_INTERFACE = new ClientPacket(37, 13);
        APPEARANCE = new ClientPacket(38, 13);
        THIRD_ITEM_ACTION = new ClientPacket(39, 8);
        FIRST_ITEM_ACTION = new ClientPacket(40, 8);
        field2176 = new ClientPacket(41, 10);
        DROP_ITEM = new ClientPacket(42, 8);
        ITEM_ON_NPC = new ClientPacket(43, 11);
        CHATBOX_INPUT = new ClientPacket(44, -1);
        INTERFACE_ACTION_10 = new ClientPacket(45, 8);
        PLAYER_INTERACT_TWO = new ClientPacket(46, 3);
        OBJECT_FOURTH_ACTION = new ClientPacket(47, 7);
        REMOVE_IGNORE = new ClientPacket(48, -1);
        SPELL_ON_ITEM = new ClientPacket(49, 14);
        field2183 = new ClientPacket(50, 4);
        field2205 = new ClientPacket(51, 7);
        field2190 = new ClientPacket(52, 4);
        field2188 = new ClientPacket(53, 6);
        ITEM_ON_PLAYER = new ClientPacket(54, 11);
        SPELL_ON_GROUND_ITEM = new ClientPacket(55, 13);
        FOURTH_ITEM_ACTION = new ClientPacket(56, 8);
        SETTINGS = new ClientPacket(57, 3);
        SECOND_ITEM_ACTION = new ClientPacket(58, 8);
        ADD_FRIEND = new ClientPacket(59, -1);
        field2159 = new ClientPacket(60, 16);
        ITEM_ON_ITEM = new ClientPacket(61, 16);
        field2227 = new ClientPacket(62, 1);
        INTERFACE_ACTION_1 = new ClientPacket(63, 8);
        ITEM_ON_OBJECT = new ClientPacket(64, 15);
        field2200 = new ClientPacket(65, 8);
        field2201 = new ClientPacket(66, -1);
        field2202 = new ClientPacket(67, 8);
        REMOVE_FRIEND = new ClientPacket(68, -1);
        CLOSED_WINDOW = new ClientPacket(69, 0);
        REGION_UPDATE = new ClientPacket(70, 0);
        PLAYER_INTERACT_ONE = new ClientPacket(71, 3);
        FIRST_NPC_ACTION = new ClientPacket(72, 3);
        FIFTH_NPC_ACTION = new ClientPacket(73, 3);
        STRING_INPUT = new ClientPacket(74, -1);
        field2185 = new ClientPacket(75, -1);
        field2211 = new ClientPacket(76, 0);
        SPELL_ON_PLAYER = new ClientPacket(77, 9);
        INTERFACE_ACTION_5 = new ClientPacket(78, 8);
        field2214 = new ClientPacket(79, 7);
        RESIZE_CLIENT_FRAME = new ClientPacket(80, 5);
        EXAMINE_OBJECT = new ClientPacket(81, 2);
        PLAYER_INTERACT_FIVE = new ClientPacket(82, 3);
        field2218 = new ClientPacket(83, -2);
        WALK = new ClientPacket(84, -1);
        PLAYER_INTERACT_FOUR = new ClientPacket(85, 3);
        ADD_IGNORE = new ClientPacket(86, -1);
        PLAYER_INTERACT_SEVEN = new ClientPacket(87, 3);
        SECOND_NPC_ACTION = new ClientPacket(88, 3);
        PLAYER_INTERACT_EIGHT = new ClientPacket(89, 3);
        CLIENT_COMMAND = new ClientPacket(90, -1);
        INTERFACE_ACTION_8 = new ClientPacket(91, 8);
        ADVANCE_DIALOGUE = new ClientPacket(92, 6);
        field2228 = new ClientPacket(93, -1);
        FOURTH_NPC_ACTION = new ClientPacket(94, 3);
        SMALL_BUTTON_PRESS = new ClientPacket(95, 4);
        INTERFACE_ACTION_6 = new ClientPacket(96, 8);
        MINIMAP_WALK = new ClientPacket(97, -1);
    }
}
