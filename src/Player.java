// 
// Decompiled by Procyon v0.5.36
// 

public final class Player extends Actor
{
    Name name;
    PlayerComposition composition;
    int skullIcon;
    int overheadIcon;
    String[] actions;
    int combatLevel;
    int totalLevel;
    int field562;
    int animationCycleStart;
    int animationCycleEnd;
    int field556;
    int field557;
    int field558;
    Model model;
    int field559;
    int field547;
    int field565;
    int field553;
    boolean isLowDetail;
    int team;
    boolean hidden;
    int field567;
    int playerId;
    class289 field569;
    class289 field554;
    boolean field571;
    int field572;
    int field573;
    private String prefix;
    private String suffix;
    private SwitchGrading timedSwitch;
    
    Player() {
        this.skullIcon = -1;
        this.overheadIcon = -1;
        this.actions = new String[3];
        for (int int_0 = 0; int_0 < 3; ++int_0) {
            this.actions[int_0] = "";
        }
        this.combatLevel = 0;
        this.totalLevel = 0;
        this.animationCycleStart = 0;
        this.animationCycleEnd = 0;
        this.isLowDetail = false;
        this.team = 0;
        this.hidden = false;
        this.field569 = class289.field3633;
        this.field554 = class289.field3633;
        this.field571 = false;
    }
    
    void decodeApperance(final Buffer buffer_0) {
        buffer_0.offset = 0;
        final int int_0 = buffer_0.readUnsignedByte();
        this.skullIcon = buffer_0.readByte();
        this.overheadIcon = buffer_0.readByte();
        int int_2 = -1;
        this.team = 0;
        final int[] ints_0 = new int[12];
        for (int int_3 = 0; int_3 < 12; ++int_3) {
            final int int_4 = buffer_0.readUnsignedByte();
            if (int_4 == 0) {
                ints_0[int_3] = 0;
            }
            else {
                final int int_5 = buffer_0.readUnsignedByte();
                ints_0[int_3] = int_5 + (int_4 << 8);
                if (int_3 == 0 && ints_0[0] == 65535) {
                    int_2 = buffer_0.readUnsignedShort();
                    break;
                }
                if (ints_0[int_3] >= 512) {
                    final int int_6 = TextureProvider.getItemDefinition(ints_0[int_3] - 512).team;
                    if (int_6 != 0) {
                        this.team = int_6;
                    }
                }
            }
        }
        final int[] ints_2 = new int[5];
        for (int int_4 = 0; int_4 < 5; ++int_4) {
            int int_5 = buffer_0.readUnsignedByte();
            if (int_5 < 0 || int_5 >= PlayerComposition.colorsToReplace[int_4].length) {
                int_5 = 0;
            }
            ints_2[int_4] = int_5;
        }
        super.idlePoseAnimation = buffer_0.readUnsignedShort();
        if (super.idlePoseAnimation == 65535) {
            super.idlePoseAnimation = -1;
        }
        super.field877 = buffer_0.readUnsignedShort();
        if (super.field877 == 65535) {
            super.field877 = -1;
        }
        super.field878 = super.field877;
        super.field899 = buffer_0.readUnsignedShort();
        if (super.field899 == 65535) {
            super.field899 = -1;
        }
        super.field880 = buffer_0.readUnsignedShort();
        if (super.field880 == 65535) {
            super.field880 = -1;
        }
        super.field870 = buffer_0.readUnsignedShort();
        if (super.field870 == 65535) {
            super.field870 = -1;
        }
        super.field882 = buffer_0.readUnsignedShort();
        if (super.field882 == 65535) {
            super.field882 = -1;
        }
        super.field883 = buffer_0.readUnsignedShort();
        if (super.field883 == 65535) {
            super.field883 = -1;
        }
        this.name = new Name(buffer_0.readString(), MapIconReference.loginType);
        this.prefix = buffer_0.readString();
        this.suffix = buffer_0.readString();
        this.method1084();
        this.method1086();
        if (this == class138.localPlayer) {
            RunException.field1939 = this.name.getName();
        }
        this.combatLevel = buffer_0.readUnsignedByte();
        this.totalLevel = buffer_0.readUnsignedShort();
        this.hidden = (buffer_0.readUnsignedByte() == 1);
        if (Game.socketType == 0 && Game.rights >= 2) {
            this.hidden = false;
        }
        if (this.composition == null) {
            this.composition = new PlayerComposition();
        }
        this.composition.method4462(ints_0, ints_2, int_0 == 1, int_2);
        if (this == class138.localPlayer) {
            Game.customizedAppearance.method4462(ints_0, ints_2, int_0 == 1, int_2);
            if (this.timedSwitch == null) {
                this.timedSwitch = new SwitchGrading();
            }
            this.timedSwitch.check(this);
        }
    }
    
    boolean isFriend() {
        if (this.field569 == class289.field3633) {
            this.method1085();
        }
        return this.field569 == class289.field3631;
    }
    
    void method1084() {
        this.field569 = class289.field3633;
    }
    
    void method1085() {
        this.field569 = (DState.friendManager.method1637(this.name) ? class289.field3631 : class289.field3634);
    }
    
    boolean isClanMember() {
        if (this.field554 == class289.field3633) {
            this.method1087();
        }
        return this.field554 == class289.field3631;
    }
    
    void method1086() {
        this.field554 = class289.field3633;
    }
    
    void method1087() {
        this.field554 = ((WorldMapType3.clanMemberManager != null && WorldMapType3.clanMemberManager.isMember(this.name)) ? class289.field3631 : class289.field3634);
    }
    
    int getSize() {
        return (this.composition != null && this.composition.transformedNpcId != -1) ? HorizontalAlignment.getNpcDefinition(this.composition.transformedNpcId).size : 1;
    }
    
    @Override
    protected Model getModel() {
        if (this.composition == null) {
            return null;
        }
        final Sequence sequence_0 = (super.animation != -1 && super.actionAnimationDisable == 0) ? TotalQuantityComparator.getAnimation(super.animation) : null;
        final Sequence sequence_2 = (super.poseAnimation == -1 || this.isLowDetail || (super.poseAnimation == super.idlePoseAnimation && sequence_0 != null)) ? null : TotalQuantityComparator.getAnimation(super.poseAnimation);
        Model model_0 = this.composition.getModel(sequence_0, super.actionFrame, sequence_2, super.poseFrame);
        if (model_0 == null) {
            return null;
        }
        model_0.calculateBoundsCylinder();
        super.logicalHeight = model_0.modelHeight;
        if (!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
            final Model model_2 = MouseRecorder.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
            if (model_2 != null) {
                model_2.offsetBy(0, -super.field871, 0);
                final Model[] models_0 = { model_0, model_2 };
                model_0 = new Model(models_0, 2);
            }
        }
        if (!this.isLowDetail && this.model != null) {
            if (Game.gameCycle >= this.animationCycleEnd) {
                this.model = null;
            }
            if (Game.gameCycle >= this.animationCycleStart && Game.gameCycle < this.animationCycleEnd) {
                final Model model_2 = this.model;
                model_2.offsetBy(this.field556 - super.x, this.field557 - this.field562, this.field558 - super.y);
                if (super.orientation == 512) {
                    model_2.rotateY90Ccw();
                    model_2.rotateY90Ccw();
                    model_2.rotateY90Ccw();
                }
                else if (super.orientation == 1024) {
                    model_2.rotateY90Ccw();
                    model_2.rotateY90Ccw();
                }
                else if (super.orientation == 1536) {
                    model_2.rotateY90Ccw();
                }
                final Model[] models_0 = { model_0, model_2 };
                model_0 = new Model(models_0, 2);
                if (super.orientation == 512) {
                    model_2.rotateY90Ccw();
                }
                else if (super.orientation == 1024) {
                    model_2.rotateY90Ccw();
                    model_2.rotateY90Ccw();
                }
                else if (super.orientation == 1536) {
                    model_2.rotateY90Ccw();
                    model_2.rotateY90Ccw();
                    model_2.rotateY90Ccw();
                }
                model_2.offsetBy(super.x - this.field556, this.field562 - this.field557, super.y - this.field558);
            }
        }
        model_0.field1603 = true;
        return model_0;
    }
    
    void method1106(final int int_0, final int int_1, final byte byte_0) {
        if (super.animation != -1 && TotalQuantityComparator.getAnimation(super.animation).priority == 1) {
            super.animation = -1;
        }
        super.field920 = -1;
        if (int_0 >= 0 && int_0 < 104 && int_1 >= 0 && int_1 < 104) {
            if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
                if (byte_0 == 2) {
                    PendingSpawn.method1538(this, int_0, int_1, (byte)2);
                }
                this.method1105(int_0, int_1, byte_0);
            }
            else {
                this.method1103(int_0, int_1);
            }
        }
        else {
            this.method1103(int_0, int_1);
        }
    }
    
    void method1103(final int int_0, final int int_1) {
        super.queueSize = 0;
        super.field930 = 0;
        super.field923 = 0;
        super.pathX[0] = int_0;
        super.pathY[0] = int_1;
        final int int_2 = this.getSize();
        super.x = int_2 * 64 + super.pathX[0] * 128;
        super.y = int_2 * 64 + super.pathY[0] * 128;
    }
    
    void method1105(final int int_0, final int int_1, final byte byte_0) {
        if (super.queueSize < 9) {
            ++super.queueSize;
        }
        for (int int_2 = super.queueSize; int_2 > 0; --int_2) {
            super.pathX[int_2] = super.pathX[int_2 - 1];
            super.pathY[int_2] = super.pathY[int_2 - 1];
            super.pathTraversed[int_2] = super.pathTraversed[int_2 - 1];
        }
        super.pathX[0] = int_0;
        super.pathY[0] = int_1;
        super.pathTraversed[0] = byte_0;
    }
    
    public String getName(final boolean useTitle) {
        if (!useTitle || RuinMisc.HIDE_TITLES) {
            return this.name.name;
        }
        if (this.prefix != null) {
            return this.prefix + this.name.getName();
        }
        if (this.suffix != null) {
            return this.name.getName() + this.suffix;
        }
        return this.name.name;
    }
    
    @Override
    boolean hasConfig() {
        return this.composition != null;
    }
    
    static void method1120(final int int_0, final int int_1) {
        class171.method3451(class229.topContextMenuRow, int_0, int_1);
        class229.topContextMenuRow = null;
    }
    
    static void method1114(final Widget widget_0) {
        if (widget_0.loopCycle == Game.field830) {
            Game.field697[widget_0.boundsIndex] = true;
        }
    }
}
