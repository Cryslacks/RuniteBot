import java.util.HashMap;
import java.util.Map;

// 
// Decompiled by Procyon v0.5.36
// 

public class class83
{
    static final Map chatLineMap;
    static final IterableHashTable messages;
    static final IterableDualNodeQueue field1184;
    static int field1186;
    
    static void method1933(final String string_0, final boolean bool_0) {
        if (Game.field677) {
            final byte byte_0 = 4;
            final int int_0 = 10;
            final int int_2 = 10;
            final int int_3 = Actor.font_p12full.method5519(string_0, 250);
            final int int_4 = Actor.font_p12full.method5520(string_0, 250) * 13;
            Rasterizer2D.Rasterizer2D_fillRectangle(6, 6, 4 + int_3 + 4, 8 + int_4, 0);
            Rasterizer2D.drawRectangle(6, 6, 4 + int_3 + 4, int_4 + 4 + 4, 16777215);
            Actor.font_p12full.method5526(string_0, 10, 10, int_3, int_4, 16777215, -1, 1, 1, 0);
            MouseInput.method948(6, 6, 4 + int_3 + 4, 8 + int_4);
            if (bool_0) {
                GameSocket.rasterProvider.drawFull(0, 0);
            }
            else {
                final int int_5 = 10;
                final int int_6 = 10;
                final int int_7 = int_3;
                final int int_8 = int_4;
                for (int int_9 = 0; int_9 < Game.widgetCount; ++int_9) {
                    if (Game.widgetBoundsWidth[int_9] + Game.widgetPositionX[int_9] > 10 && Game.widgetPositionX[int_9] < 10 + int_7 && Game.widgetBoundsHeight[int_9] + Game.widgetPositionY[int_9] > 10 && Game.widgetPositionY[int_9] < int_8 + 10) {
                        Game.field788[int_9] = true;
                    }
                }
            }
        }
    }
    
    static void method1940() {
        final int int_0 = MouseInput.menuX;
        final int int_2 = WorldComparator.menuY;
        final int int_3 = UrlRequester.field1856;
        final int int_4 = class151.field1933;
        final int int_5 = 6116423;
        Rasterizer2D.Rasterizer2D_fillRectangle(int_0, int_2, int_3, int_4, 6116423);
        Rasterizer2D.Rasterizer2D_fillRectangle(int_0 + 1, int_2 + 1, int_3 - 2, 16, 0);
        Rasterizer2D.drawRectangle(int_0 + 1, int_2 + 18, int_3 - 2, int_4 - 19, 0);
        ClanMemberManager.fontBold12.method5522("Choose Option", int_0 + 3, int_2 + 14, 6116423, -1);
        final int int_6 = MouseInput.mouseLastX;
        final int int_7 = MouseInput.mouseLastY * 673804999;
        for (int int_8 = 0; int_8 < Game.menuOptionCount; ++int_8) {
            final int int_9 = int_2 + (Game.menuOptionCount - 1 - int_8) * 15 + 31;
            int int_10 = 16777215;
            if (int_6 > int_0 && int_6 < int_3 + int_0 && int_7 > int_9 - 13 && int_7 < int_9 + 3) {
                int_10 = 16776960;
            }
            ClanMemberManager.fontBold12.method5522(WorldMapType1.method176(int_8), int_0 + 3, int_9, int_10, 0);
        }
        int int_8 = MouseInput.menuX;
        final int int_9 = WorldComparator.menuY;
        int int_10 = UrlRequester.field1856;
        final int int_11 = class151.field1933;
        for (int int_12 = 0; int_12 < Game.widgetCount; ++int_12) {
            if (Game.widgetBoundsWidth[int_12] + Game.widgetPositionX[int_12] > int_8 && Game.widgetPositionX[int_12] < int_8 + int_10 && Game.widgetBoundsHeight[int_12] + Game.widgetPositionY[int_12] > int_9 && Game.widgetPositionY[int_12] < int_9 + int_11) {
                Game.field788[int_12] = true;
            }
        }
    }
    
    static void method1923(final Widget[] widgets_0, final int int_0) {
        for (int int_ = 0; int_ < widgets_0.length; ++int_) {
            final Widget widget_0 = widgets_0[int_];
            if (widget_0 != null) {
                if (widget_0.type == 0) {
                    if (widget_0.children != null) {
                        method1923(widget_0.children, int_0);
                    }
                    final WidgetNode widgetnode_0 = (WidgetNode)Game.componentTable.get(widget_0.interfaceHash);
                    if (widgetnode_0 != null) {
                        final int int_2 = widgetnode_0.id;
                        if (CombatInfo2.loadWidget(int_2)) {
                            method1923(GameCanvas.widgets[int_2], int_0);
                        }
                    }
                }
                if (int_0 == 0 && widget_0.onDialogAbortListener != null) {
                    final ScriptEvent scriptevent_0 = new ScriptEvent();
                    scriptevent_0.widget = widget_0;
                    scriptevent_0.objs = widget_0.onDialogAbortListener;
                    class68.method1696(scriptevent_0);
                }
                if (int_0 == 1 && widget_0.onSubChangeListener != null) {
                    if (widget_0.index >= 0) {
                        final Widget widget_2 = Widget.getWidget(widget_0.interfaceHash);
                        if (widget_2 == null || widget_2.children == null || widget_0.index >= widget_2.children.length) {
                            continue;
                        }
                        if (widget_0 != widget_2.children[widget_0.index]) {
                            continue;
                        }
                    }
                    final ScriptEvent scriptevent_0 = new ScriptEvent();
                    scriptevent_0.widget = widget_0;
                    scriptevent_0.objs = widget_0.onSubChangeListener;
                    class68.method1696(scriptevent_0);
                }
            }
        }
    }
    
    static {
        chatLineMap = new HashMap();
        messages = new IterableHashTable(1024);
        field1184 = new IterableDualNodeQueue();
        class83.field1186 = 0;
    }
}
