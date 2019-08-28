// 
// Decompiled by Procyon v0.5.36
// 

public class FontName
{
    public static final FontName FontName_plain11;
    public static final FontName FontName_plain12;
    public static final FontName FontName_bold12;
    public static final FontName field3673;
    public static final FontName field3670;
    public static final FontName field3669;
    static int[] landMapFileIds;
    final String field3671;
    String field3666;
    
    FontName(final String string_0, final String string_1) {
        this.field3671 = string_0;
        this.field3666 = string_1;
    }
    
    public static FontName[] method5498() {
        return new FontName[] { FontName.field3673, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_plain12, FontName.field3670, FontName.field3669 };
    }
    
    static void method5502(final Actor actor_0) {
        actor_0.field873 = false;
        if (actor_0.poseAnimation != -1) {
            final Sequence sequence_0 = TotalQuantityComparator.getAnimation(actor_0.poseAnimation);
            if (sequence_0 != null && sequence_0.frameIDs != null) {
                ++actor_0.poseFrameCycle;
                if (actor_0.poseFrame < sequence_0.frameIDs.length && actor_0.poseFrameCycle > sequence_0.frameLengths[actor_0.poseFrame]) {
                    actor_0.poseFrameCycle = 1;
                    class173.queueAnimationSound(sequence_0, ++actor_0.poseFrame, actor_0.x, actor_0.y);
                }
                if (actor_0.poseFrame >= sequence_0.frameIDs.length) {
                    actor_0.poseFrameCycle = 0;
                    class173.queueAnimationSound(sequence_0, actor_0.poseFrame = 0, actor_0.x, actor_0.y);
                }
            }
            else {
                actor_0.poseAnimation = -1;
            }
        }
        if (actor_0.graphic != -1 && Game.gameCycle >= actor_0.graphicsDelay) {
            if (actor_0.spotAnimFrame < 0) {
                actor_0.spotAnimFrame = 0;
            }
            final int int_0 = MouseRecorder.getSpotAnimType(actor_0.graphic).animationId;
            if (int_0 != -1) {
                final Sequence sequence_2 = TotalQuantityComparator.getAnimation(int_0);
                if (sequence_2 != null && sequence_2.frameIDs != null) {
                    ++actor_0.spotAnimFrameCycle;
                    if (actor_0.spotAnimFrame < sequence_2.frameIDs.length && actor_0.spotAnimFrameCycle > sequence_2.frameLengths[actor_0.spotAnimFrame]) {
                        actor_0.spotAnimFrameCycle = 1;
                        class173.queueAnimationSound(sequence_2, ++actor_0.spotAnimFrame, actor_0.x, actor_0.y);
                    }
                    if (actor_0.spotAnimFrame >= sequence_2.frameIDs.length && (actor_0.spotAnimFrame < 0 || actor_0.spotAnimFrame >= sequence_2.frameIDs.length)) {
                        actor_0.graphic = -1;
                    }
                }
                else {
                    actor_0.graphic = -1;
                }
            }
            else {
                actor_0.graphic = -1;
            }
        }
        if (actor_0.animation != -1 && actor_0.actionAnimationDisable <= 1) {
            final Sequence sequence_0 = TotalQuantityComparator.getAnimation(actor_0.animation);
            if (sequence_0.precedenceAnimating == 1 && actor_0.field930 > 0 && actor_0.field917 <= Game.gameCycle && actor_0.field918 < Game.gameCycle) {
                actor_0.actionAnimationDisable = 1;
                return;
            }
        }
        if (actor_0.animation != -1 && actor_0.actionAnimationDisable == 0) {
            final Sequence sequence_0 = TotalQuantityComparator.getAnimation(actor_0.animation);
            if (sequence_0 != null && sequence_0.frameIDs != null) {
                ++actor_0.actionFrameCycle;
                if (actor_0.actionFrame < sequence_0.frameIDs.length && actor_0.actionFrameCycle > sequence_0.frameLengths[actor_0.actionFrame]) {
                    actor_0.actionFrameCycle = 1;
                    class173.queueAnimationSound(sequence_0, ++actor_0.actionFrame, actor_0.x, actor_0.y);
                }
                if (actor_0.actionFrame >= sequence_0.frameIDs.length) {
                    actor_0.actionFrame -= sequence_0.frameStep;
                    ++actor_0.field907;
                    if (actor_0.field907 >= sequence_0.maxLoops) {
                        actor_0.animation = -1;
                    }
                    else if (actor_0.actionFrame >= 0 && actor_0.actionFrame < sequence_0.frameIDs.length) {
                        class173.queueAnimationSound(sequence_0, actor_0.actionFrame, actor_0.x, actor_0.y);
                    }
                    else {
                        actor_0.animation = -1;
                    }
                }
                actor_0.field873 = sequence_0.stretches;
            }
            else {
                actor_0.animation = -1;
            }
        }
        if (actor_0.actionAnimationDisable > 0) {
            --actor_0.actionAnimationDisable;
        }
    }
    
    static void method5501() {
        for (WidgetNode widgetnode_0 = (WidgetNode)Game.componentTable.first(); widgetnode_0 != null; widgetnode_0 = (WidgetNode)Game.componentTable.next()) {
            final int int_0 = widgetnode_0.id;
            if (CombatInfo2.loadWidget(int_0)) {
                boolean bool_0 = true;
                final Widget[] widgets_0 = GameCanvas.widgets[int_0];
                for (int int_2 = 0; int_2 < widgets_0.length; ++int_2) {
                    if (widgets_0[int_2] != null) {
                        bool_0 = widgets_0[int_2].hasScript;
                        break;
                    }
                }
                if (!bool_0) {
                    final int int_2 = (int)widgetnode_0.hash;
                    final Widget widget_0 = Widget.getWidget(int_2);
                    if (widget_0 != null) {
                        Player.method1114(widget_0);
                    }
                }
            }
        }
    }
    
    static {
        FontName_plain11 = new FontName("PLAIN11", "p11_full");
        FontName_plain12 = new FontName("PLAIN12", "p12_full");
        FontName_bold12 = new FontName("BOLD12", "b12_full");
        field3673 = new FontName("VERDANA11", "verdana_11pt_regular");
        field3670 = new FontName("VERDANA13", "verdana_13pt_regular");
        field3669 = new FontName("VERDANA15", "verdana_15pt_regular");
    }
}
