import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.36
// 

public class Fonts
{
    IndexDataBase field3681;
    IndexDataBase field3679;
    HashMap map;
    
    public Fonts(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1) {
        this.field3681 = indexdatabase_0;
        this.field3679 = indexdatabase_1;
        this.map = new HashMap();
    }
    
    public HashMap createMap(final FontName[] fontnames_0) {
        final HashMap hashmap_0 = new HashMap();
        final FontName[] fontnames_ = fontnames_0;
        for (int int_0 = 0; int_0 < fontnames_.length; ++int_0) {
            final FontName fontname_0 = fontnames_[int_0];
            if (this.map.containsKey(fontname_0)) {
                hashmap_0.put(fontname_0, this.map.get(fontname_0));
            }
            else {
                final IndexDataBase indexdatabase_0 = this.field3681;
                final IndexDataBase indexdatabase_2 = this.field3679;
                final String string_0 = fontname_0.field3666;
                final int int_2 = indexdatabase_0.getFile(string_0);
                final int int_3 = indexdatabase_0.getChild(int_2, "");
                final Font font_0 = MessageNode.method1058(indexdatabase_0, indexdatabase_2, int_2, int_3);
                if (font_0 != null) {
                    this.map.put(fontname_0, font_0);
                    hashmap_0.put(fontname_0, font_0);
                }
            }
        }
        return hashmap_0;
    }
}
