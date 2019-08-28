import java.util.Date;

// 
// Decompiled by Procyon v0.5.36
// 

public class MouseRecorder implements Runnable
{
    static int mapX;
    boolean isRunning;
    Object lock;
    int index;
    int[] xs;
    int[] ys;
    
    MouseRecorder() {
        this.isRunning = true;
        this.lock = new Object();
        this.index = 0;
        this.xs = new int[500];
        this.ys = new int[500];
    }
    
    @Override
    public void run() {
        while (this.isRunning) {
            synchronized (this.lock) {
                if (this.index < 500) {
                    this.xs[this.index] = MouseInput.mouseLastX;
                    this.ys[this.index] = MouseInput.mouseLastY * 673804999;
                    ++this.index;
                }
            }
            Actor.method1539(50L);
        }
    }
    
    public static Spotanim getSpotAnimType(final int int_0) {
        Spotanim spotanim_0 = (Spotanim)Spotanim.spotanims.get(int_0);
        if (spotanim_0 != null) {
            return spotanim_0;
        }
        final byte[] bytes_0 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, int_0);
        spotanim_0 = new Spotanim();
        spotanim_0.id = int_0;
        if (bytes_0 != null) {
            spotanim_0.decode(new Buffer(bytes_0));
            spotanim_0.postDecode();
        }
        Spotanim.spotanims.put(spotanim_0, int_0);
        return spotanim_0;
    }
    
    static int method1034(final int int_0, final Script script_0, final boolean bool_0) {
    	//System.out.println("<method1034> Args: "+int_0+", "+script_0.toString()+", "+bool_0);
    	if (int_0 == 4100) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            final int int_ = class69.intStack[--class69.intStackSize];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0 + int_;
            return 1;
        }
        if (int_0 == 4101) {
            WidgetNode.scriptStringStackSize -= 2;
            final String string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
            final String string_2 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0 + string_2;
            return 1;
        }
        if (int_0 == 4102) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            final int int_ = class69.intStack[--class69.intStackSize];
            final String[] strings_0 = class69.scriptStringStack;
            final int int_2 = ++WidgetNode.scriptStringStackSize - 1;
            String string_3;
            if (int_ < 0) {
                string_3 = Integer.toString(int_);
            }
            else {
                int int_3;
                String string_4;
                if ((int_3 = int_) < 0) {
                    string_4 = Integer.toString(int_, 10);
                }
                else {
                    int int_4 = 2;
                    for (int int_5 = int_ / 10; int_5 != 0; int_5 /= 10, ++int_4) {}
                    final char[] chars_0 = new char[int_4];
                    chars_0[0] = '+';
                    for (int int_6 = int_4 - 1; int_6 > 0; --int_6) {
                        final int int_7 = int_3;
                        int_3 /= 10;
                        final int int_8 = int_7 - int_3 * 10;
                        if (int_8 >= 10) {
                            chars_0[int_6] = (char)(int_8 + 87);
                        }
                        else {
                            chars_0[int_6] = (char)(int_8 + 48);
                        }
                    }
                    string_4 = new String(chars_0);
                }
                string_3 = string_4;
            }
            strings_0[int_2] = string_0 + string_3;
            return 1;
        }
        if (int_0 == 4103) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0.toLowerCase();
            return 1;
        }
        if (int_0 == 4104) {
            final int int_9 = class69.intStack[--class69.intStackSize];
            final long long_0 = 86400000L * (int_9 + 11745L);
            class69.field1007.setTime(new Date(long_0));
            final int int_2 = class69.field1007.get(5);
            final int int_10 = class69.field1007.get(2);
            final int int_11 = class69.field1007.get(1);
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = int_2 + "-" + class69.field998[int_10] + "-" + int_11;
            return 1;
        }
        if (int_0 == 4105) {
            WidgetNode.scriptStringStackSize -= 2;
            final String string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
            final String string_2 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
            if (class138.localPlayer.composition != null && class138.localPlayer.composition.isFemale) {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_2;
            }
            else {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
            }
            return 1;
        }
        if (int_0 == 4106) {
            final int int_9 = class69.intStack[--class69.intStackSize];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = Integer.toString(int_9);
            return 1;
        }
        if (int_0 == 4107) {
            WidgetNode.scriptStringStackSize -= 2;
            final int[] ints_1 = class69.intStack;
            final int int_ = ++class69.intStackSize - 1;
            final int int_2 = class155.method3269(class69.scriptStringStack[WidgetNode.scriptStringStackSize], class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1], Game.languageId);
            byte byte_0;
            if (int_2 > 0) {
                byte_0 = 1;
            }
            else if (int_2 < 0) {
                byte_0 = -1;
            }
            else {
                byte_0 = 0;
            }
            ints_1[int_] = byte_0;
            return 1;
        }
        if (int_0 == 4108) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            class69.intStackSize -= 2;
            final int int_ = class69.intStack[class69.intStackSize];
            final int int_12 = class69.intStack[class69.intStackSize + 1];
            final byte[] bytes_0 = class50.indexCache13.getConfigData(int_12, 0);
            final Font font_0 = new Font(bytes_0);
            class69.intStack[++class69.intStackSize - 1] = font_0.method5520(string_0, int_);
            return 1;
        }
        if (int_0 == 4109) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            class69.intStackSize -= 2;
            final int int_ = class69.intStack[class69.intStackSize];
            final int int_12 = class69.intStack[class69.intStackSize + 1];
            final byte[] bytes_0 = class50.indexCache13.getConfigData(int_12, 0);
            final Font font_0 = new Font(bytes_0);
            class69.intStack[++class69.intStackSize - 1] = font_0.method5519(string_0, int_);
            return 1;
        }
        if (int_0 == 4110) {
            WidgetNode.scriptStringStackSize -= 2;
            final String string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
            final String string_2 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
            if (class69.intStack[--class69.intStackSize] == 1) {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
            }
            else {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_2;
            }
            return 1;
        }
        if (int_0 == 4111) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = FontTypeFace.appendTags(string_0);
            return 1;
        }
        if (int_0 == 4112) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            final int int_ = class69.intStack[--class69.intStackSize];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0 + (char)int_;
            return 1;
        }
        if (int_0 == 4113) {
            final int int_9 = class69.intStack[--class69.intStackSize];
            class69.intStack[++class69.intStackSize - 1] = (class52.method1002((char)int_9) ? 1 : 0);
            return 1;
        }
        if (int_0 == 4114) {
            final int int_9 = class69.intStack[--class69.intStackSize];
            class69.intStack[++class69.intStackSize - 1] = (class161.method3362((char)int_9) ? 1 : 0);
            return 1;
        }
        if (int_0 == 4115) {
            final int int_9 = class69.intStack[--class69.intStackSize];
            final int[] ints_2 = class69.intStack;
            final int int_12 = ++class69.intStackSize - 1;
            final char char_0 = (char)int_9;
            final boolean bool_ = (char_0 >= 'A' && char_0 <= 'Z') || (char_0 >= 'a' && char_0 <= 'z');
            ints_2[int_12] = (bool_ ? 1 : 0);
            return 1;
        }
        if (int_0 == 4116) {
            final int int_9 = class69.intStack[--class69.intStackSize];
            final int[] ints_2 = class69.intStack;
            final int int_12 = ++class69.intStackSize - 1;
            final char char_0 = (char)int_9;
            final boolean bool_ = char_0 >= '0' && char_0 <= '9';
            ints_2[int_12] = (bool_ ? 1 : 0);
            return 1;
        }
        if (int_0 == 4117) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            if (string_0 != null) {
                class69.intStack[++class69.intStackSize - 1] = string_0.length();
            }
            else {
                class69.intStack[++class69.intStackSize - 1] = 0;
            }
            return 1;
        }
        if (int_0 == 4118) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            class69.intStackSize -= 2;
            final int int_ = class69.intStack[class69.intStackSize];
            final int int_12 = class69.intStack[class69.intStackSize + 1];
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0.substring(int_, int_12);
            return 1;
        }
        if (int_0 == 4119) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            final StringBuilder stringbuilder_0 = new StringBuilder(string_0.length());
            boolean bool_2 = false;
            for (int int_2 = 0; int_2 < string_0.length(); ++int_2) {
                final char char_0 = string_0.charAt(int_2);
                if (char_0 == '<') {
                    bool_2 = true;
                }
                else if (char_0 == '>') {
                    bool_2 = false;
                }
                else if (!bool_2) {
                    stringbuilder_0.append(char_0);
                }
            }
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = stringbuilder_0.toString();
            return 1;
        }
        if (int_0 == 4120) {
            final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            final int int_ = class69.intStack[--class69.intStackSize];
            class69.intStack[++class69.intStackSize - 1] = string_0.indexOf(int_);
            return 1;
        }
        if (int_0 == 4121) {
            WidgetNode.scriptStringStackSize -= 2;
            final String string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
            final String string_2 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
            final int int_12 = class69.intStack[--class69.intStackSize];
            class69.intStack[++class69.intStackSize - 1] = string_0.indexOf(string_2, int_12);
            return 1;
        }
        return 2;
    }
    
    public static void method1036() {
        ItemComposition.items.reset();
        ItemComposition.itemModelCache.reset();
        ItemComposition.itemSpriteCache.reset();
    }
}
