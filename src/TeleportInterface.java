// 
// Decompiled by Procyon v0.5.36
// 

public class TeleportInterface
{
    private static String TITLE;
    private static String[] CATEGORIES;
    private static String[] SUBCATEGORIES;
    private static String[] OPTIONS;
    
    public static void a(String title, final int catIndex, String[] categories, final int size, String[] subcategories, String[] options) {
        if (title.isEmpty()) {
            title = TeleportInterface.TITLE;
        }
        else {
            TeleportInterface.TITLE = title;
        }
        if (categories.length == 0) {
            categories = TeleportInterface.CATEGORIES;
        }
        else {
            TeleportInterface.CATEGORIES = categories;
        }
        if (subcategories.length == 0) {
            subcategories = TeleportInterface.SUBCATEGORIES;
        }
        else {
            TeleportInterface.SUBCATEGORIES = subcategories;
        }
        if (options.length == 0) {
            options = TeleportInterface.OPTIONS;
        }
        else {
            TeleportInterface.OPTIONS = options;
        }
        Widget.get(583, 14).text = title;
        for (int i = 17; i <= 63; ++i) {
            Widget.get(583, i).isHidden = true;
        }
        final Widget mainWidget = Widget.get(583, 16);
        mainWidget.originalX = 23;
        mainWidget.originalY = 58;
        mainWidget.originalWidth = 469;
        mainWidget.originalHeight = 260;
        mainWidget.scrollWidth = 0;
        mainWidget.scrollHeight = 0;
        int n3 = 18;
        final Widget cat = addChild(n3++);
        cat.hasScript = true;
        cat.originalX = 0;
        cat.originalY = 0;
        cat.originalWidth = 120;
        cat.originalHeight = 240;
        cat.hasListener = true;
        cat.onLoadListener = new Object[] { 991, -2147483645, -1 };
        final Widget b2 = addChild(n3++);
        b2.parentHash = cat.interfaceHash;
        b2.hasScript = true;
        b2.dynamicY = 1;
        b2.dynamicWidth = 1;
        b2.buttonType = 1;
        b2.originalX = 4;
        b2.originalWidth = 0;
        b2.originalHeight = 8;
        final Widget subCat = addChild(n3++);
        subCat.hasScript = true;
        subCat.originalX = 122;
        subCat.originalY = 0;
        subCat.originalWidth = 120;
        subCat.originalHeight = 240;
        subCat.hasListener = true;
        subCat.onLoadListener = new Object[] { 991, -2147483645, -1 };
        final Widget b3 = addChild(n3++);
        b3.parentHash = subCat.interfaceHash;
        b3.hasScript = true;
        b3.dynamicY = 1;
        b3.dynamicWidth = 1;
        b3.buttonType = 1;
        b3.originalX = 4;
        b3.originalWidth = 0;
        b3.originalHeight = 8;
        final Widget b4 = addChild(n3++);
        b4.parentHash = subCat.interfaceHash;
        b4.hasScript = true;
        b4.dynamicX = 2;
        b4.dynamicY = 1;
        b4.buttonType = 1;
        b4.originalX = 4;
        b4.originalWidth = 16;
        b4.originalHeight = 8;
        a(b3, subcategories, size);
        cat.originalHeight = 240;
        a(b2, categories, catIndex);
        boolean b5 = false;
        boolean b6 = false;
        boolean b7 = false;
        for (final String s : options) {
            if (s.contains("<img=47>")) {
                b5 = true;
            }
            if (s.contains("<img=46>")) {
                b6 = true;
            }
            if (s.contains("<img=43>")) {
                b7 = true;
            }
        }
        final int n4 = 0;
        final Widget teleports = addChild(n3++);
        teleports.hasScript = true;
        teleports.originalX = 245;
        teleports.originalWidth = 220;
        if (n4 == 0) {
            teleports.originalY = 0;
            teleports.originalHeight = 240;
        }
        else {
            teleports.originalY = n4 * 15 + 5;
            teleports.originalHeight = 241 - (n4 * 15 + 5);
        }
        teleports.hasListener = true;
        teleports.onLoadListener = new Object[] { 991, -2147483645, -1 };
        final Widget b8 = addChild(63);
        b8.parentHash = teleports.interfaceHash;
        b8.hasScript = true;
        b8.dynamicY = 1;
        b8.dynamicWidth = 1;
        b8.buttonType = 1;
        b8.originalX = 4;
        b8.originalWidth = 24;
        b8.originalHeight = 8;
        final Widget b9 = addChild(n3++);
        b9.parentHash = teleports.interfaceHash;
        b9.hasScript = true;
        b9.dynamicX = 2;
        b9.dynamicY = 1;
        b9.buttonType = 1;
        b9.originalX = 4;
        b9.originalWidth = 16;
        b9.originalHeight = 8;
        a(b8, options, -1);
        addScrollBar(b8, b9, options.length * 25);
        final Widget b10 = addChild(n3++);
        b10.hasScript = true;
        b10.type = 4;
        b10.originalX = 90;
        b10.originalY = 246;
        b10.originalWidth = 310;
        b10.originalHeight = 20;
        b10.fontId = 494;
        b10.text = "<img=91> The wizard will heal you after using any teleport.";
        b10.textShadowed = true;
        b10.textColor = 16777215;
    }
    
    private static void a(final Widget em, final String[] array, final int n) {
        int n2 = 0;
        for (int i = 0; i < array.length; ++i) {
            final Widget b = Widget.addChild(em.interfaceHash, 3, n2);
            b.hasScript = true;
            b.originalX = 0;
            b.originalY = n2 * 25;
            b.dynamicWidth = 1;
            b.originalHeight = 25;
            b.filled = true;
            b.opBase = "<col=ff9040>" + array[i].split("\\|")[0] + "</col>";
            b.setAction(0, (n == -1) ? "Teleport" : "Select");
            if (i == n) {
                b.opacity = 125;
                b.onMouseOverListener = new Object[] { 1015, -2147483645, -2147483643, 0, 80 };
                b.onMouseLeaveListener = new Object[] { 1015, -2147483645, -2147483643, 0, 125 };
            }
            else if ((n2 + 1) % 2 != 0) {
                b.opacity = 225;
                b.onMouseOverListener = new Object[] { 1015, -2147483645, -2147483643, class138.method3137((n == -1) ? "743BA9" : "B03A2E", 16), 0 };
                b.onMouseLeaveListener = new Object[] { 1015, -2147483645, -2147483643, 16777215, 255 };
            }
            else {
                b.opacity = 200;
                b.onMouseOverListener = new Object[] { 1015, -2147483645, -2147483643, class138.method3137((n == -1) ? "743BA9" : "B03A2E", 16), 0 };
                b.onMouseLeaveListener = new Object[] { 1015, -2147483645, -2147483643, 0, 225 };
            }
            b.hasListener = true;
            ++n2;
        }
        if (n == -1) {
            for (int j = 0; j < array.length; ++j) {
                final String[] split = array[j].split("\\|");
                final Widget b2 = Widget.addChild(em.interfaceHash, 4, n2++);
                b2.originalX = 3;
                b2.originalY = j * 25;
                b2.originalWidth = 190;
                b2.originalHeight = 25;
                b2.fontId = 495;
                b2.text = split[0];
                b2.fontVerticalAlignment = 1;
                b2.fontHorizontalAlignment = 0;
                b2.textShadowed = true;
                b2.textColor = 16758847;
                if (split.length > 2) {
                    final Widget b3 = Widget.addChild(em.interfaceHash, 4, n2++);
                    b3.originalX = 3;
                    b3.originalY = j * 25;
                    b3.originalWidth = 277;
                    b3.originalHeight = 25;
                    b3.fontId = 494;
                    b3.text = split[1];
                    b3.fontVerticalAlignment = 1;
                    b3.fontHorizontalAlignment = 1;
                    b3.textShadowed = true;
                    b3.textColor = 16758847;
                    final Widget b4 = Widget.addChild(em.interfaceHash, 4, n2++);
                    b4.originalX = 3;
                    b4.originalY = j * 25;
                    b4.originalWidth = 277;
                    b4.originalHeight = 25;
                    b4.fontId = 494;
                    b4.text = split[2];
                    b4.fontVerticalAlignment = 1;
                    b4.fontHorizontalAlignment = 2;
                    b4.textShadowed = true;
                    b4.textColor = 16758847;
                }
                else if (split.length > 1) {
                    final Widget b5 = Widget.addChild(em.interfaceHash, 4, n2++);
                    b5.originalX = 3;
                    b5.originalY = j * 25;
                    b5.originalWidth = 277;
                    b5.originalHeight = 25;
                    b5.fontId = 494;
                    b5.text = split[1];
                    b5.fontVerticalAlignment = 1;
                    b5.fontHorizontalAlignment = 2;
                    b5.textShadowed = true;
                    b5.textColor = 16758847;
                }
            }
        }
        else {
            for (int k = 0; k < array.length; ++k) {
                final Widget b6 = Widget.addChild(em.interfaceHash, 4, n2++);
                b6.originalX = -5;
                b6.originalY = k * 25;
                b6.originalWidth = 121;
                b6.originalHeight = 25;
                b6.fontId = 496;
                b6.text = array[k];
                b6.fontVerticalAlignment = 1;
                b6.fontHorizontalAlignment = 1;
                b6.textShadowed = true;
                b6.textColor = 16758847;
            }
        }
        InterfaceEdits.unlock(em.interfaceHash, 0, n2, 0);
    }
    
    private static void addScrollBar(final Widget widget, final Widget child, final int scrollHeight) {
        widget.scrollY = 0;
        widget.scrollHeight = Math.max(widget.originalHeight, scrollHeight);
        final ScriptEvent script = new ScriptEvent();
        script.objs = new Object[] { 31, child.interfaceHash, widget.interfaceHash, 792, 789, 790, 791, 773, 788 };
        class68.method1696(script);
    }
    
    private static Widget addChild(final int n) {
        final Widget a = Widget.get(583, n);
        final Widget em = new Widget();
        em.parentHash = a.parentHash;
        em.interfaceHash = a.interfaceHash;
        return GameCanvas.widgets[583][n] = em;
    }
}
