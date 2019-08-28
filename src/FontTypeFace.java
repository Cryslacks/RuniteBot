import java.util.Random;

// 
// Decompiled by Procyon v0.5.36
// 

public abstract class FontTypeFace extends Rasterizer2D
{
    public static IndexedSprite[] modIcons;
    static int strikeRGB;
    static int underlineRGB;
    static int prevShadeRGB;
    static int shadow;
    static int prevColorRGB;
    static int color;
    static int field3706;
    static int field3701;
    static int field3705;
    static Random field3709;
    static String[] field3710;
    byte[][] gylphs;
    int[] field3703;
    int[] gylphHeights;
    int[] glyphWidths;
    int[] horizontalOffsets;
    int[] verticalOffsets;
    public int verticalSpace;
    public int minSpacing;
    public int maxSpacing;
    byte[] field3699;
    
    FontTypeFace(final byte[] bytes_0, final int[] ints_0, final int[] ints_1, final int[] ints_2, final int[] ints_3, final int[] ints_4, final byte[][] bytes_1) {
        this.gylphs = new byte[256][];
        this.verticalSpace = 0;
        this.horizontalOffsets = ints_0;
        this.verticalOffsets = ints_1;
        this.gylphHeights = ints_2;
        this.glyphWidths = ints_3;
        this.method5540(bytes_0);
        this.gylphs = bytes_1;
        int int_0 = Integer.MAX_VALUE;
        int int_2 = Integer.MIN_VALUE;
        for (int int_3 = 0; int_3 < 256; ++int_3) {
            if (this.verticalOffsets[int_3] < int_0 && this.glyphWidths[int_3] != 0) {
                int_0 = this.verticalOffsets[int_3];
            }
            if (this.verticalOffsets[int_3] + this.glyphWidths[int_3] > int_2) {
                int_2 = this.verticalOffsets[int_3] + this.glyphWidths[int_3];
            }
        }
        this.minSpacing = this.verticalSpace - int_0;
        this.maxSpacing = int_2 - this.verticalSpace;
    }
    
    FontTypeFace(final byte[] bytes_0) {
        this.gylphs = new byte[256][];
        this.verticalSpace = 0;
        this.method5540(bytes_0);
    }
    
    abstract void renderRGB(final byte[] p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    
    abstract void renderRGBA(final byte[] p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    void method5540(final byte[] bytes_0) {
        this.field3703 = new int[256];
        if (bytes_0.length == 257) {
            for (int int_0 = 0; int_0 < this.field3703.length; ++int_0) {
                this.field3703[int_0] = (bytes_0[int_0] & 0xFF);
            }
            this.verticalSpace = (bytes_0[256] & 0xFF);
        }
        else {
            int int_0 = 0;
            for (int int_2 = 0; int_2 < 256; ++int_2) {
                this.field3703[int_2] = (bytes_0[int_0++] & 0xFF);
            }
            final int[] ints_0 = new int[256];
            final int[] ints_2 = new int[256];
            for (int int_3 = 0; int_3 < 256; ++int_3) {
                ints_0[int_3] = (bytes_0[int_0++] & 0xFF);
            }
            for (int int_3 = 0; int_3 < 256; ++int_3) {
                ints_2[int_3] = (bytes_0[int_0++] & 0xFF);
            }
            final byte[][] bytes_ = new byte[256][];
            for (int int_4 = 0; int_4 < 256; ++int_4) {
                bytes_[int_4] = new byte[ints_0[int_4]];
                byte byte_0 = 0;
                for (int int_5 = 0; int_5 < bytes_[int_4].length; ++int_5) {
                    byte_0 += bytes_0[int_0++];
                    bytes_[int_4][int_5] = byte_0;
                }
            }
            final byte[][] bytes_2 = new byte[256][];
            for (int int_6 = 0; int_6 < 256; ++int_6) {
                bytes_2[int_6] = new byte[ints_0[int_6]];
                byte byte_2 = 0;
                for (int int_7 = 0; int_7 < bytes_2[int_6].length; ++int_7) {
                    byte_2 += bytes_0[int_0++];
                    bytes_2[int_6][int_7] = byte_2;
                }
            }
            this.field3699 = new byte[65536];
            for (int int_6 = 0; int_6 < 256; ++int_6) {
                if (int_6 != 32 && int_6 != 160) {
                    for (int int_5 = 0; int_5 < 256; ++int_5) {
                        if (int_5 != 32 && int_5 != 160) {
                            this.field3699[int_5 + (int_6 << 8)] = (byte)method5599(bytes_, bytes_2, ints_2, this.field3703, ints_0, int_6, int_5);
                        }
                    }
                }
            }
            this.verticalSpace = ints_2[32] + ints_0[32];
        }
    }
    
    int method5516(char char_0) {
        if (char_0 == 'Â') {
            char_0 = ' ';
        }
        return this.field3703[class166.charToByteCp1252(char_0) & 0xFF];
    }
    
    public int getTextWidth(final String string_0) {
        if (string_0 == null) {
            return 0;
        }
        int int_0 = -1;
        int int_2 = -1;
        int int_3 = 0;
        for (int int_4 = 0; int_4 < string_0.length(); ++int_4) {
            char char_0 = string_0.charAt(int_4);
            if (char_0 == '<') {
                int_0 = int_4;
            }
            else {
                if (char_0 == '>' && int_0 != -1) {
                    final String string_ = string_0.substring(int_0 + 1, int_4);
                    int_0 = -1;
                    if (string_.equals("lt")) {
                        char_0 = '<';
                    }
                    else if (!string_.equals("gt")) {
                        if (string_.startsWith("img=")) {
                            try {
                                final String string_2 = string_.substring(4);
                                final int int_5 = class68.parseInt(string_2, 10, true);
                                int_3 += FontTypeFace.modIcons[int_5].originalWidth;
                                int_2 = -1;
                            }
                            catch (Exception ex) {}
                        }
                        continue;
                    }
                    else {
                        char_0 = '>';
                    }
                }
                if (char_0 == 'Â') {
                    char_0 = ' ';
                }
                if (int_0 == -1) {
                    int_3 += this.field3703[(char)(class166.charToByteCp1252(char_0) & 0xFF)];
                    if (this.field3699 != null && int_2 != -1) {
                        int_3 += this.field3699[char_0 + (int_2 << 8)];
                    }
                    int_2 = char_0;
                }
            }
        }
        return int_3;
    }
    
    public int method5518(final String string_0, final int[] ints_0, final String[] strings_0) {
        if (string_0 == null) {
            return 0;
        }
        int int_0 = 0;
        int int_2 = 0;
        final StringBuilder stringbuilder_0 = new StringBuilder(100);
        int int_3 = -1;
        int int_4 = 0;
        byte byte_0 = 0;
        int int_5 = -1;
        char char_0 = '\0';
        int int_6 = 0;
        for (int int_7 = string_0.length(), int_8 = 0; int_8 < int_7; ++int_8) {
            char char_2 = string_0.charAt(int_8);
            if (char_2 == '<') {
                int_5 = int_8;
            }
            else {
                if (char_2 == '>' && int_5 != -1) {
                    final String string_ = string_0.substring(int_5 + 1, int_8);
                    int_5 = -1;
                    stringbuilder_0.append('<');
                    stringbuilder_0.append(string_);
                    stringbuilder_0.append('>');
                    if (string_.equals("br")) {
                        strings_0[int_6] = stringbuilder_0.toString().substring(int_2, stringbuilder_0.length());
                        ++int_6;
                        int_2 = stringbuilder_0.length();
                        int_0 = 0;
                        int_3 = -1;
                        char_0 = '\0';
                    }
                    else if (string_.equals("lt")) {
                        int_0 += this.method5516('<');
                        if (this.field3699 != null && char_0 != -1) {
                            int_0 += this.field3699[(char_0 << 8) + 60];
                        }
                        char_0 = '<';
                    }
                    else if (string_.equals("gt")) {
                        int_0 += this.method5516('>');
                        if (this.field3699 != null && char_0 != -1) {
                            int_0 += this.field3699[(char_0 << 8) + 62];
                        }
                        char_0 = '>';
                    }
                    else if (string_.startsWith("img=")) {
                        try {
                            final String string_2 = string_.substring(4);
                            final int int_9 = class68.parseInt(string_2, 10, true);
                            int_0 += FontTypeFace.modIcons[int_9].originalWidth;
                            char_0 = '\0';
                        }
                        catch (Exception ex) {}
                    }
                    char_2 = '\0';
                }
                if (int_5 == -1) {
                    if (char_2 != '\0') {
                        stringbuilder_0.append(char_2);
                        int_0 += this.method5516(char_2);
                        if (this.field3699 != null && char_0 != -1) {
                            int_0 += this.field3699[char_2 + (char_0 << 8)];
                        }
                        char_0 = char_2;
                    }
                    if (char_2 == ' ') {
                        int_3 = stringbuilder_0.length();
                        int_4 = int_0;
                        byte_0 = 1;
                    }
                    if (ints_0 != null && int_0 > ints_0[(int_6 < ints_0.length) ? int_6 : (ints_0.length - 1)] && int_3 >= 0) {
                        strings_0[int_6] = stringbuilder_0.toString().substring(int_2, int_3 - byte_0);
                        ++int_6;
                        int_2 = int_3;
                        int_3 = -1;
                        int_0 -= int_4;
                        char_0 = '\0';
                    }
                    if (char_2 == '-') {
                        int_3 = stringbuilder_0.length();
                        int_4 = int_0;
                        byte_0 = 0;
                    }
                }
            }
        }
        final String string_3 = stringbuilder_0.toString();
        if (string_3.length() > int_2) {
            strings_0[int_6++] = string_3.substring(int_2, string_3.length());
        }
        return int_6;
    }
    
    public int method5519(final String string_0, final int int_0) {
        final int int_ = this.method5518(string_0, new int[] { int_0 }, FontTypeFace.field3710);
        int int_2 = 0;
        for (int int_3 = 0; int_3 < int_; ++int_3) {
            final int int_4 = this.getTextWidth(FontTypeFace.field3710[int_3]);
            if (int_4 > int_2) {
                int_2 = int_4;
            }
        }
        return int_2;
    }
    
    public int method5520(final String string_0, final int int_0) {
        return this.method5518(string_0, new int[] { int_0 }, FontTypeFace.field3710);
    }
    
    public void method5522(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            this.drawText(string_0, int_0, int_1);
        }
    }
    
    public void method5523(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            FontTypeFace.field3706 = int_4;
            this.drawText(string_0, int_0, int_1);
        }
    }
    
    public void method5524(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            this.drawText(string_0, int_0 - this.getTextWidth(string_0), int_1);
        }
    }
    
    public void drawTextCentered(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            this.drawText(string_0, int_0 - this.getTextWidth(string_0) / 2, int_1);
        }
    }
    
    public int method5526(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5, final int int_6, int int_7, int int_8) {
        if (string_0 == null) {
            return 0;
        }
        this.setColor(int_4, int_5);
        if (int_8 == 0) {
            int_8 = this.verticalSpace;
        }
        int[] ints_0 = { int_2 };
        if (int_3 < int_8 + this.minSpacing + this.maxSpacing && int_3 < int_8 + int_8) {
            ints_0 = null;
        }
        final int int_9 = this.method5518(string_0, ints_0, FontTypeFace.field3710);
        if (int_7 == 3 && int_9 == 1) {
            int_7 = 1;
        }
        int int_10;
        if (int_7 == 0) {
            int_10 = int_1 + this.minSpacing;
        }
        else if (int_7 == 1) {
            int_10 = int_1 + (int_3 - this.minSpacing - this.maxSpacing - int_8 * (int_9 - 1)) / 2 + this.minSpacing;
        }
        else if (int_7 == 2) {
            int_10 = int_1 + int_3 - this.maxSpacing - int_8 * (int_9 - 1);
        }
        else {
            int int_11 = (int_3 - this.minSpacing - this.maxSpacing - int_8 * (int_9 - 1)) / (int_9 + 1);
            if (int_11 < 0) {
                int_11 = 0;
            }
            int_10 = int_1 + int_11 + this.minSpacing;
            int_8 += int_11;
        }
        for (int int_11 = 0; int_11 < int_9; ++int_11) {
            if (int_6 == 0) {
                this.drawText(FontTypeFace.field3710[int_11], int_0, int_10);
            }
            else if (int_6 == 1) {
                this.drawText(FontTypeFace.field3710[int_11], int_0 + (int_2 - this.getTextWidth(FontTypeFace.field3710[int_11])) / 2, int_10);
            }
            else if (int_6 == 2) {
                this.drawText(FontTypeFace.field3710[int_11], int_0 + int_2 - this.getTextWidth(FontTypeFace.field3710[int_11]), int_10);
            }
            else if (int_11 == int_9 - 1) {
                this.drawText(FontTypeFace.field3710[int_11], int_0, int_10);
            }
            else {
                this.method5533(FontTypeFace.field3710[int_11], int_2);
                this.drawText(FontTypeFace.field3710[int_11], int_0, int_10);
                FontTypeFace.field3701 = 0;
            }
            int_10 += int_8;
        }
        return int_9;
    }
    
    public void method5609(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            final int[] ints_0 = new int[string_0.length()];
            for (int int_5 = 0; int_5 < string_0.length(); ++int_5) {
                ints_0[int_5] = (int)(Math.sin(int_5 / 2.0 + int_4 / 5.0) * 5.0);
            }
            this.drawMouseoverText(string_0, int_0 - this.getTextWidth(string_0) / 2, int_1, null, ints_0);
        }
    }
    
    public void method5575(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            final int[] ints_0 = new int[string_0.length()];
            final int[] ints_2 = new int[string_0.length()];
            for (int int_5 = 0; int_5 < string_0.length(); ++int_5) {
                ints_0[int_5] = (int)(Math.sin(int_5 / 5.0 + int_4 / 5.0) * 5.0);
                ints_2[int_5] = (int)(Math.sin(int_5 / 3.0 + int_4 / 5.0) * 5.0);
            }
            this.drawMouseoverText(string_0, int_0 - this.getTextWidth(string_0) / 2, int_1, ints_0, ints_2);
        }
    }
    
    public void method5539(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            double double_0 = 7.0 - int_5 / 8.0;
            if (double_0 < 0.0) {
                double_0 = 0.0;
            }
            final int[] ints_0 = new int[string_0.length()];
            for (int int_6 = 0; int_6 < string_0.length(); ++int_6) {
                ints_0[int_6] = (int)(Math.sin(int_6 / 1.5 + int_4 / 1.0) * double_0);
            }
            this.drawMouseoverText(string_0, int_0 - this.getTextWidth(string_0) / 2, int_1, null, ints_0);
        }
    }
    
    public void drawRandomizedMouseoverText(final String string_0, final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        if (string_0 != null) {
            this.setColor(int_2, int_3);
            FontTypeFace.field3709.setSeed(int_4);
            FontTypeFace.field3706 = 192 + (FontTypeFace.field3709.nextInt() & 0x1F);
            final int[] ints_0 = new int[string_0.length()];
            int int_5 = 0;
            for (int int_6 = 0; int_6 < string_0.length(); ++int_6) {
                ints_0[int_6] = int_5;
                if ((FontTypeFace.field3709.nextInt() & 0x3) == 0x0) {
                    ++int_5;
                }
            }
            this.drawMouseoverText(string_0, int_0, int_1, ints_0, null);
        }
    }
    
    void setColor(final int int_0, final int int_1) {
        FontTypeFace.strikeRGB = -1;
        FontTypeFace.underlineRGB = -1;
        FontTypeFace.prevShadeRGB = int_1;
        FontTypeFace.shadow = int_1;
        FontTypeFace.prevColorRGB = int_0;
        FontTypeFace.color = int_0;
        FontTypeFace.field3706 = 256;
        FontTypeFace.field3701 = 0;
        FontTypeFace.field3705 = 0;
    }
    
    void setRGB(final String string_0) {
        try {
            if (string_0.startsWith("col=")) {
                FontTypeFace.color = class138.method3137(string_0.substring(4), 16);
            }
            else if (string_0.equals("/col")) {
                FontTypeFace.color = FontTypeFace.prevColorRGB;
            }
            else if (string_0.startsWith("str=")) {
                FontTypeFace.strikeRGB = class138.method3137(string_0.substring(4), 16);
            }
            else if (string_0.equals("str")) {
                FontTypeFace.strikeRGB = 8388608;
            }
            else if (string_0.equals("/str")) {
                FontTypeFace.strikeRGB = -1;
            }
            else if (string_0.startsWith("u=")) {
                FontTypeFace.underlineRGB = class138.method3137(string_0.substring(2), 16);
            }
            else if (string_0.equals("u")) {
                FontTypeFace.underlineRGB = 0;
            }
            else if (string_0.equals("/u")) {
                FontTypeFace.underlineRGB = -1;
            }
            else if (string_0.startsWith("shad=")) {
                FontTypeFace.shadow = class138.method3137(string_0.substring(5), 16);
            }
            else if (string_0.equals("shad")) {
                FontTypeFace.shadow = 0;
            }
            else if (string_0.equals("/shad")) {
                FontTypeFace.shadow = FontTypeFace.prevShadeRGB;
            }
            else if (string_0.equals("br")) {
                this.setColor(FontTypeFace.prevColorRGB, FontTypeFace.prevShadeRGB);
            }
        }
        catch (Exception ex) {}
    }
    
    void method5533(final String string_0, final int int_0) {
        int int_ = 0;
        boolean bool_0 = false;
        for (int int_2 = 0; int_2 < string_0.length(); ++int_2) {
            final char char_0 = string_0.charAt(int_2);
            if (char_0 == '<') {
                bool_0 = true;
            }
            else if (char_0 == '>') {
                bool_0 = false;
            }
            else if (!bool_0 && char_0 == ' ') {
                ++int_;
            }
        }
        if (int_ > 0) {
            FontTypeFace.field3701 = (int_0 - this.getTextWidth(string_0) << 8) / int_;
        }
    }
    
    void drawText(final String string_0, int int_0, int int_1) {    	
    	if(!string_0.equals(RendererBot.getStatus())){
    		this.setRGB("col=0x00cc00");
    		drawText(RendererBot.getStatus(), 5, 30);
    		this.setRGB("/col");
    	}
        int_1 -= this.verticalSpace;
        int int_2 = -1;
        int int_3 = -1;
        for (int int_4 = 0; int_4 < string_0.length(); ++int_4) {
            if (string_0.charAt(int_4) != '\0') {
                char char_0 = (char)(class166.charToByteCp1252(string_0.charAt(int_4)) & 0xFF);
                if (char_0 == '<') {
                    int_2 = int_4;
                }
                else {
                    if (char_0 == '>' && int_2 != -1) {
                        final String string_ = string_0.substring(int_2 + 1, int_4);
                        int_2 = -1;
                        if (string_.equals("lt")) {
                            char_0 = '<';
                        }
                        else if (!string_.equals("gt")) {
                            if (string_.startsWith("img=")) {
                                try {
                                    final String string_2 = string_.substring(4);
                                    final int int_5 = class68.parseInt(string_2, 10, true);
                                    final IndexedSprite indexedsprite_0 = FontTypeFace.modIcons[int_5];
                                    indexedsprite_0.method5829(int_0, int_1 + this.verticalSpace - indexedsprite_0.originalHeight);
                                    int_0 += indexedsprite_0.originalWidth;
                                    int_3 = -1;
                                }
                                catch (Exception ex) {}
                                continue;
                            }
                            this.setRGB(string_);
                            continue;
                        }
                        else {
                            char_0 = '>';
                        }
                    }
                    if (char_0 == 'Â') {
                        char_0 = ' ';
                    }
                    if (int_2 == -1) {
                        if (this.field3699 != null && int_3 != -1) {
                            int_0 += this.field3699[char_0 + (int_3 << 8)];
                        }
                        final int int_6 = this.gylphHeights[char_0];
                        final int int_5 = this.glyphWidths[char_0];
                        if (char_0 != ' ') {
                            if (FontTypeFace.field3706 == 256) {
                                if (FontTypeFace.shadow != -1) {
                                    renderShadeRGB(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0] + 1, int_1 + this.verticalOffsets[char_0] + 1, int_6, int_5, FontTypeFace.shadow);
                                }
                                this.renderRGB(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0], int_1 + this.verticalOffsets[char_0], int_6, int_5, FontTypeFace.color);
                            }
                            else {
                                if (FontTypeFace.shadow != -1) {
                                    renderShadeRGBA(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0] + 1, int_1 + this.verticalOffsets[char_0] + 1, int_6, int_5, FontTypeFace.shadow, FontTypeFace.field3706);
                                }
                                this.renderRGBA(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0], int_1 + this.verticalOffsets[char_0], int_6, int_5, FontTypeFace.color, FontTypeFace.field3706);
                            }
                        }
                        else if (FontTypeFace.field3701 > 0) {
                            FontTypeFace.field3705 += FontTypeFace.field3701;
                            int_0 += FontTypeFace.field3705 >> 8;
                            FontTypeFace.field3705 &= 0xFF;
                        }
                        final int int_7 = this.field3703[char_0];
                        if (FontTypeFace.strikeRGB != -1) {
                            Rasterizer2D.method5736(int_0, int_1 + (int)(this.verticalSpace * 0.7), int_7, FontTypeFace.strikeRGB);
                        }
                        if (FontTypeFace.underlineRGB != -1) {
                            Rasterizer2D.method5736(int_0, int_1 + this.verticalSpace + 1, int_7, FontTypeFace.underlineRGB);
                        }
                        int_0 += int_7;
                        int_3 = char_0;
                    }
                }
            }
        }
    }
    
    void drawMouseoverText(final String string_0, int int_0, int int_1, final int[] ints_0, final int[] ints_1) {
        int_1 -= this.verticalSpace;
        int int_2 = -1;
        int int_3 = -1;
        int int_4 = 0;
        for (int int_5 = 0; int_5 < string_0.length(); ++int_5) {
            if (string_0.charAt(int_5) != '\0') {
                char char_0 = (char)(class166.charToByteCp1252(string_0.charAt(int_5)) & 0xFF);
                if (char_0 == '<') {
                    int_2 = int_5;
                }
                else {
                    if (char_0 == '>' && int_2 != -1) {
                        final String string_ = string_0.substring(int_2 + 1, int_5);
                        int_2 = -1;
                        if (string_.equals("lt")) {
                            char_0 = '<';
                        }
                        else if (!string_.equals("gt")) {
                            if (string_.startsWith("img=")) {
                                try {
                                    int int_6;
                                    if (ints_0 != null) {
                                        int_6 = ints_0[int_4];
                                    }
                                    else {
                                        int_6 = 0;
                                    }
                                    int int_7;
                                    if (ints_1 != null) {
                                        int_7 = ints_1[int_4];
                                    }
                                    else {
                                        int_7 = 0;
                                    }
                                    ++int_4;
                                    final String string_2 = string_.substring(4);
                                    final int int_8 = class68.parseInt(string_2, 10, true);
                                    final IndexedSprite indexedsprite_0 = FontTypeFace.modIcons[int_8];
                                    indexedsprite_0.method5829(int_6 + int_0, int_7 + (int_1 + this.verticalSpace - indexedsprite_0.originalHeight));
                                    int_0 += indexedsprite_0.originalWidth;
                                    int_3 = -1;
                                }
                                catch (Exception ex) {}
                                continue;
                            }
                            this.setRGB(string_);
                            continue;
                        }
                        else {
                            char_0 = '>';
                        }
                    }
                    if (char_0 == 'Â') {
                        char_0 = ' ';
                    }
                    if (int_2 == -1) {
                        if (this.field3699 != null && int_3 != -1) {
                            int_0 += this.field3699[char_0 + (int_3 << 8)];
                        }
                        final int int_9 = this.gylphHeights[char_0];
                        final int int_6 = this.glyphWidths[char_0];
                        int int_7;
                        if (ints_0 != null) {
                            int_7 = ints_0[int_4];
                        }
                        else {
                            int_7 = 0;
                        }
                        int int_8;
                        if (ints_1 != null) {
                            int_8 = ints_1[int_4];
                        }
                        else {
                            int_8 = 0;
                        }
                        ++int_4;
                        if (char_0 != ' ') {
                            if (FontTypeFace.field3706 == 256) {
                                if (FontTypeFace.shadow != -1) {
                                    renderShadeRGB(this.gylphs[char_0], int_7 + int_0 + this.horizontalOffsets[char_0] + 1, int_1 + int_8 + this.verticalOffsets[char_0] + 1, int_9, int_6, FontTypeFace.shadow);
                                }
                                this.renderRGB(this.gylphs[char_0], int_7 + int_0 + this.horizontalOffsets[char_0], int_1 + int_8 + this.verticalOffsets[char_0], int_9, int_6, FontTypeFace.color);
                            }
                            else {
                                if (FontTypeFace.shadow != -1) {
                                    renderShadeRGBA(this.gylphs[char_0], int_7 + int_0 + this.horizontalOffsets[char_0] + 1, int_1 + int_8 + this.verticalOffsets[char_0] + 1, int_9, int_6, FontTypeFace.shadow, FontTypeFace.field3706);
                                }
                                this.renderRGBA(this.gylphs[char_0], int_7 + int_0 + this.horizontalOffsets[char_0], int_1 + int_8 + this.verticalOffsets[char_0], int_9, int_6, FontTypeFace.color, FontTypeFace.field3706);
                            }
                        }
                        else if (FontTypeFace.field3701 > 0) {
                            FontTypeFace.field3705 += FontTypeFace.field3701;
                            int_0 += FontTypeFace.field3705 >> 8;
                            FontTypeFace.field3705 &= 0xFF;
                        }
                        final int int_10 = this.field3703[char_0];
                        if (FontTypeFace.strikeRGB != -1) {
                            Rasterizer2D.method5736(int_0, int_1 + (int)(this.verticalSpace * 0.7), int_10, FontTypeFace.strikeRGB);
                        }
                        if (FontTypeFace.underlineRGB != -1) {
                            Rasterizer2D.method5736(int_0, int_1 + this.verticalSpace, int_10, FontTypeFace.underlineRGB);
                        }
                        int_0 += int_10;
                        int_3 = char_0;
                    }
                }
            }
        }
    }
    
    static int method5599(final byte[][] bytes_0, final byte[][] bytes_1, final int[] ints_0, final int[] ints_1, final int[] ints_2, final int int_0, final int int_1) {
        final int int_2 = ints_0[int_0];
        final int int_3 = int_2 + ints_2[int_0];
        final int int_4 = ints_0[int_1];
        final int int_5 = int_4 + ints_2[int_1];
        int int_6 = int_2;
        if (int_4 > int_2) {
            int_6 = int_4;
        }
        int int_7;
        if (int_5 < (int_7 = int_3)) {
            int_7 = int_5;
        }
        int int_8 = ints_1[int_0];
        if (ints_1[int_1] < int_8) {
            int_8 = ints_1[int_1];
        }
        final byte[] bytes_2 = bytes_1[int_0];
        final byte[] bytes_3 = bytes_0[int_1];
        int int_9 = int_6 - int_2;
        int int_10 = int_6 - int_4;
        for (int int_11 = int_6; int_11 < int_7; ++int_11) {
            final int int_12 = bytes_2[int_9++] + bytes_3[int_10++];
            if (int_12 < int_8) {
                int_8 = int_12;
            }
        }
        return -int_8;
    }
    
    public static String appendTags(final String string_0) {
        final int int_0 = string_0.length();
        int int_2 = 0;
        for (int int_3 = 0; int_3 < int_0; ++int_3) {
            final char char_0 = string_0.charAt(int_3);
            if (char_0 == '<' || char_0 == '>') {
                int_2 += 3;
            }
        }
        final StringBuilder stringbuilder_0 = new StringBuilder(int_0 + int_2);
        for (int int_4 = 0; int_4 < int_0; ++int_4) {
            final char char_2 = string_0.charAt(int_4);
            if (char_2 == '<') {
                stringbuilder_0.append("<lt>");
            }
            else if (char_2 == '>') {
                stringbuilder_0.append("<gt>");
            }
            else {
                stringbuilder_0.append(char_2);
            }
        }
        return stringbuilder_0.toString();
    }
    
    static void renderShadeRGB(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, final int int_4) {
        int int_5 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
        int int_6 = Rasterizer2D.graphicsPixelsWidth - int_2;
        int int_7 = 0;
        int int_8 = 0;
        if (int_1 < Rasterizer2D.topY) {
            final int int_9 = Rasterizer2D.topY - int_1;
            int_3 -= int_9;
            int_1 = Rasterizer2D.topY;
            int_8 += int_2 * int_9;
            int_5 += int_9 * Rasterizer2D.graphicsPixelsWidth;
        }
        if (int_1 + int_3 > Rasterizer2D.bottomY) {
            int_3 -= int_1 + int_3 - Rasterizer2D.bottomY;
        }
        if (int_0 < Rasterizer2D.topX) {
            final int int_9 = Rasterizer2D.topX - int_0;
            int_2 -= int_9;
            int_0 = Rasterizer2D.topX;
            int_8 += int_9;
            int_5 += int_9;
            int_7 += int_9;
            int_6 += int_9;
        }
        if (int_2 + int_0 > Rasterizer2D.bottomX) {
            final int int_9 = int_2 + int_0 - Rasterizer2D.bottomX;
            int_2 -= int_9;
            int_7 += int_9;
            int_6 += int_9;
        }
        if (int_2 > 0 && int_3 > 0) {
            render(Rasterizer2D.graphicsPixels, bytes_0, int_4, int_8, int_5, int_2, int_3, int_6, int_7);
        }
    }
    
    static void render(final int[] ints_0, final byte[] bytes_0, final int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5, final int int_6) {
        final int int_7 = -(int_3 >> 2);
        int_3 = -(int_3 & 0x3);
        for (int int_8 = -int_4; int_8 < 0; ++int_8) {
            for (int int_9 = int_7; int_9 < 0; ++int_9) {
                if (bytes_0[int_1++] != 0) {
                    ints_0[int_2++] = int_0;
                }
                else {
                    ++int_2;
                }
                if (bytes_0[int_1++] != 0) {
                    ints_0[int_2++] = int_0;
                }
                else {
                    ++int_2;
                }
                if (bytes_0[int_1++] != 0) {
                    ints_0[int_2++] = int_0;
                }
                else {
                    ++int_2;
                }
                if (bytes_0[int_1++] != 0) {
                    ints_0[int_2++] = int_0;
                }
                else {
                    ++int_2;
                }
            }
            for (int int_9 = int_3; int_9 < 0; ++int_9) {
                if (bytes_0[int_1++] != 0) {
                    ints_0[int_2++] = int_0;
                }
                else {
                    ++int_2;
                }
            }
            int_2 += int_5;
            int_1 += int_6;
        }
    }
    
    static void renderShadeRGBA(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5) {
        int int_6 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
        int int_7 = Rasterizer2D.graphicsPixelsWidth - int_2;
        int int_8 = 0;
        int int_9 = 0;
        if (int_1 < Rasterizer2D.topY) {
            final int int_10 = Rasterizer2D.topY - int_1;
            int_3 -= int_10;
            int_1 = Rasterizer2D.topY;
            int_9 += int_2 * int_10;
            int_6 += int_10 * Rasterizer2D.graphicsPixelsWidth;
        }
        if (int_1 + int_3 > Rasterizer2D.bottomY) {
            int_3 -= int_1 + int_3 - Rasterizer2D.bottomY;
        }
        if (int_0 < Rasterizer2D.topX) {
            final int int_10 = Rasterizer2D.topX - int_0;
            int_2 -= int_10;
            int_0 = Rasterizer2D.topX;
            int_9 += int_10;
            int_6 += int_10;
            int_8 += int_10;
            int_7 += int_10;
        }
        if (int_2 + int_0 > Rasterizer2D.bottomX) {
            final int int_10 = int_2 + int_0 - Rasterizer2D.bottomX;
            int_2 -= int_10;
            int_8 += int_10;
            int_7 += int_10;
        }
        if (int_2 > 0 && int_3 > 0) {
            renderRGBA(Rasterizer2D.graphicsPixels, bytes_0, int_4, int_9, int_6, int_2, int_3, int_7, int_8, int_5);
        }
    }
    
    static void renderRGBA(final int[] ints_0, final byte[] bytes_0, int int_0, int int_1, int int_2, final int int_3, final int int_4, final int int_5, final int int_6, int int_7) {
        int_0 = ((int_0 & 0xFF00) * int_7 & 0xFF0000) + (int_7 * (int_0 & 0xFF00FF) & 0xFF00FF00) >> 8;
        int_7 = 256 - int_7;
        for (int int_8 = -int_4; int_8 < 0; ++int_8) {
            for (int int_9 = -int_3; int_9 < 0; ++int_9) {
                if (bytes_0[int_1++] != 0) {
                    final int int_10 = ints_0[int_2];
                    ints_0[int_2++] = (((int_10 & 0xFF00) * int_7 & 0xFF0000) + ((int_10 & 0xFF00FF) * int_7 & 0xFF00FF00) >> 8) + int_0;
                }
                else {
                    ++int_2;
                }
            }
            int_2 += int_5;
            int_1 += int_6;
        }
    }
    
    static {
        FontTypeFace.strikeRGB = -1;
        FontTypeFace.underlineRGB = -1;
        FontTypeFace.prevShadeRGB = -1;
        FontTypeFace.shadow = -1;
        FontTypeFace.prevColorRGB = 0;
        FontTypeFace.color = 0;
        FontTypeFace.field3706 = 256;
        FontTypeFace.field3701 = 0;
        FontTypeFace.field3705 = 0;
        FontTypeFace.field3709 = new Random();
        FontTypeFace.field3710 = new String[100];
    }
}
