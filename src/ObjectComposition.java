// 
// Decompiled by Procyon v0.5.36
// 

public class ObjectComposition extends CacheableNode
{
    public static boolean objectCompositionLowDetail;
    public static IndexDataBase objects_ref;
    static NodeCache objects;
    public static NodeCache field3391;
    static NodeCache cachedModels;
    static NodeCache field3374;
    static ModelData[] field3375;
    static IndexData indexTextures;
    public int id;
    int[] objectModels;
    int[] objectTypes;
    public String name;
    short[] recolorToFind;
    short[] recolorToReplace;
    short[] textureToFind;
    short[] textureToReplace;
    public int width;
    public int length;
    public int clipType;
    public boolean blocksProjectile;
    public int int1;
    int contouredGround;
    boolean nonFlatShading;
    public boolean modelClipped;
    public int animationId;
    public int decorDisplacement;
    int ambient;
    int contrast;
    public String[] actions;
    public int mapIconId;
    public int mapSceneId;
    boolean isRotated;
    public boolean clipped;
    int modelSizeX;
    int modelSizeHeight;
    int modelSizeY;
    int offsetX;
    int offsetHeight;
    int offsetY;
    public boolean obstructsGround;
    boolean isHollow;
    public int supportItems;
    public int[] impostorIds;
    int varpId;
    int configId;
    public int ambientSoundId;
    public int int4;
    public int int5;
    public int int6;
    public int[] field3417;
    IterableHashTable params;
    
    private void copy(final int id) {
        final ObjectComposition from = FileOnDisk.getObjectDefinition(id);
        this.name = from.name;
        this.width = from.width;
        this.length = from.length;
        this.clipType = from.clipType;
        this.blocksProjectile = from.blocksProjectile;
        this.int1 = from.int1;
        this.contouredGround = from.contouredGround;
        this.nonFlatShading = from.nonFlatShading;
        this.modelClipped = from.modelClipped;
        this.animationId = from.animationId;
        this.decorDisplacement = from.decorDisplacement;
        this.ambient = from.ambient;
        this.contrast = from.contrast;
        this.actions = from.actions;
        this.mapIconId = from.mapIconId;
        this.mapSceneId = from.mapSceneId;
        this.isRotated = from.isRotated;
        this.clipped = from.clipped;
        this.modelSizeX = from.modelSizeX;
        this.modelSizeHeight = from.modelSizeHeight;
        this.modelSizeY = from.modelSizeY;
        this.offsetX = from.offsetX;
        this.offsetHeight = from.offsetHeight;
        this.offsetY = from.offsetY;
        this.obstructsGround = from.obstructsGround;
        this.isHollow = from.isHollow;
        this.supportItems = from.supportItems;
        this.varpId = from.varpId;
        this.configId = from.configId;
        this.ambientSoundId = from.ambientSoundId;
        this.int4 = from.int4;
        this.int5 = from.int5;
        this.int6 = from.int6;
        this.objectModels = from.objectModels;
    }
    
    ObjectComposition() {
        this.name = "null";
        this.width = 1;
        this.length = 1;
        this.clipType = 2;
        this.blocksProjectile = true;
        this.int1 = -1;
        this.contouredGround = -1;
        this.nonFlatShading = false;
        this.modelClipped = false;
        this.animationId = -1;
        this.decorDisplacement = 16;
        this.ambient = 0;
        this.contrast = 0;
        this.actions = new String[5];
        this.mapIconId = -1;
        this.mapSceneId = -1;
        this.isRotated = false;
        this.clipped = true;
        this.modelSizeX = 128;
        this.modelSizeHeight = 128;
        this.modelSizeY = 128;
        this.offsetX = 0;
        this.offsetHeight = 0;
        this.offsetY = 0;
        this.obstructsGround = false;
        this.isHollow = false;
        this.supportItems = -1;
        this.varpId = -1;
        this.configId = -1;
        this.ambientSoundId = -1;
        this.int4 = 0;
        this.int5 = 0;
        this.int6 = 0;
    }
    
    void post() {
    	//System.out.println("Object Post: "+this.name);
        if (this.int1 == -1) {
            this.int1 = 0;
            if (this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
                this.int1 = 1;
            }
            for (int int_0 = 0; int_0 < 5; ++int_0) {
                if (this.actions[int_0] != null) {
                    this.int1 = 1;
                }
            }
        }
        if (this.supportItems == -1) {
            this.supportItems = ((this.clipType != 0) ? 1 : 0);
        }
    }
    
    void decode(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0) {
                break;
            }
            this.loadData(buffer_0, int_0);
        }
    }
    
    void postDecode() {
    	if(this.name.equals("Silver stall")){
    		System.out.println(this.name+", "+this.id+", "+this.actions[0]+", "+this.actions[1]+", "+this.actions[2]);
    		this.actions[0] = "Bot";
    	}
    	if (this.id == 1534) {
            this.actions[0] = null;
        }
        else if (this.id == 18258) {
            this.actions[0] = "Pray-at";
            this.actions[1] = "Spellbook";
        }
        else if (this.id == 11833) {
            this.actions[1] = "Practice";
        }
        else if (this.id == 32758) {
            this.name = "Loyalty Chest";
            this.actions[0] = "Loot";
            this.actions[1] = "About";
            this.actions[2] = null;
            this.actions[3] = null;
            this.actions[4] = null;
        }
        else if (this.id == 32759) {
            this.name = "Loyalty Chest";
            this.actions[0] = null;
            this.actions[1] = null;
            this.actions[2] = null;
            this.actions[3] = null;
            this.actions[4] = null;
        }
        else if (this.id == 31379) {
            this.name = "Donation table";
            this.int1 = 1;
            final int n = 2;
            this.length = n;
            this.width = n;
            this.obstructsGround = false;
            this.supportItems = 1;
            this.impostorIds = null;
            this.objectModels = new int[] { 32153 };
            this.varpId = -1;
            this.actions[0] = "Buy-credits";
        }
        else if (this.id == 25203) {
            this.actions[0] = "Loot";
        }
        else if (this.id == 29226) {
            if (WorldType.isPVP()) {
                this.name = "Pet list";
                this.actions[4] = null;
            }
        }
        else if (this.id == 6045) {
            if (WorldType.isPVP()) {
                this.actions[0] = "Dump-ore";
            }
        }
        else if (this.id == 3581) {
            this.name = "Ticket exchange";
            this.actions[0] = "Use";
        }
        else if (this.id == 15477) {
            if (WorldType.isPVP()) {
                this.name = "Chambers of Xeric";
                this.actions[1] = null;
                this.actions[2] = null;
                this.actions[3] = null;
                this.actions[4] = null;
            }
        }
        else if (this.id == 11508 || this.id == 11509) {
            this.clipType = 0;
        }
        else if (this.id == 30395) {
            this.name = "Great Portal";
            this.actions[0] = "Teleport";
            this.actions[1] = "Teleport-previous";
        }
        else if (this.id == 31380) {
            this.name = "Rejuvenation pool";
            this.int1 = 1;
            final int n2 = 2;
            this.length = n2;
            this.width = n2;
            this.animationId = 7304;
            this.int4 = 3;
            this.blocksProjectile = false;
            this.actions[0] = "Drink";
            this.ambientSoundId = 2149;
            this.clipType = 1;
            this.obstructsGround = false;
            this.impostorIds = null;
            this.ambient = 40;
            this.objectModels = new int[] { 32101 };
            this.varpId = -1;
        }
        else if (this.id == 31378) {
            this.name = "Portal";
            this.int1 = 1;
            this.animationId = 7304;
            this.int4 = 3;
            this.blocksProjectile = false;
            this.actions = new String[] { "Enter", "Home", "Build mode", "Friend's house", null };
            this.clipType = 1;
            this.obstructsGround = false;
            this.impostorIds = null;
            this.objectModels = new int[] { 11242, 11234 };
            this.width = 2;
            this.length = 2;
            this.ambientSoundId = 3139;
            this.ambient = 40;
            this.varpId = -1;
        }
        else if (this.id == 30352) {
            this.name = "test";
            this.actions[1] = "Practice";
        }
        else if (this.id == 539) {
            this.name = "Donator Area";
        }
        else if (this.id == 33114) {
            this.name = "PvP Supply Chest";
            this.actions[0] = "Check-timer";
        }
        else if (this.id == 33115) {
            this.name = "PvP Supply Chest";
        }
        else if (this.id == 31583) {
            this.name = "PvP Supply Chest";
        }
        else if (this.id == 32572) {
            this.name = "Bloody Chest";
            this.actions[1] = "Information";
        }
        else if (this.id == 32573) {
            this.name = "Bloody Chest";
            this.actions[0] = null;
            this.actions[1] = null;
            this.actions[2] = null;
            this.actions[3] = null;
            this.actions[4] = null;
        }
        else if (this.id == 30169) {
            this.actions[0] = "Instance";
            this.actions[1] = "Peek";
        }
        else if (this.id == 1816) {
            this.actions[1] = "Instance";
            this.actions[2] = "Commune";
        }
        else if (this.id == 535) {
            this.actions[1] = "Instance";
            this.actions[2] = "Peek";
        }
        else if (this.id == 23104) {
            this.actions[1] = "Instance";
            this.actions[2] = "Peek";
        }
        else if (this.id == 29705) {
            this.actions[0] = "Instance";
            this.actions[1] = "Peek";
        }
        else if (this.id >= 26502 && this.id <= 26505) {
            this.actions[1] = "Instance";
            this.actions[2] = "Peek";
        }
        else if (this.id == 31618 || this.id == 4407) {
            this.name = "Boss instance portal";
            this.actions[0] = "Use";
        }
        else if (this.id == 19038) {
            this.name = "Christmas tree";
            this.actions[0] = "Grab-present";
        }
        else if (this.id == 29709) {
            this.name = "Snowball Exchange";
            this.actions[0] = "Open";
            this.actions[1] = "Information";
        }
        else if (this.id == 40000) {
            this.copy(32546);
            this.name = "Giveaway booth";
            this.actions[0] = "Use";
        }
        else if (this.id == 40001) {
            this.copy(4525);
            this.actions[0] = "Exit";
            this.actions[1] = null;
            this.actions[4] = null;
        }
        else if (this.id == 40002) {
            this.copy(32424);
            this.name = "Consumables";
        }
        else if (this.id == 40003) {
            this.copy(32425);
            this.name = "Equipment";
        }
        else if (this.id == 28925) {
            this.name = "Fun PVP Portal";
        }
        else if (this.id == 14845 || this.id == 14844) {
            this.name = "PVP Instance Portal";
        }
        else if (this.id == 2654) {
            this.name = "Bloody Fountain";
            this.actions[0] = "Drink";
            this.actions[1] = null;
            this.modelSizeHeight = 200;
            this.modelSizeX = 200;
            this.modelSizeY = 200;
            this.width = 3;
            this.length = 3;
        }
        else if (this.id == 4470) {
            this.name = "Donator Zone";
            this.actions[0] = "Enter";
        }
        else if (this.id == 40004) {
            this.copy(29241);
            this.actions[4] = null;
        }
        else if (this.id == 40005) {
            this.copy(31858);
            this.actions[0] = "Pray-at";
            this.actions[1] = "Spellbook";
            this.actions[2] = null;
            this.actions[3] = null;
            this.actions[4] = null;
        }
        else if (this.id == 40006) {
            this.copy(4537);
            this.actions[4] = null;
        }
        else if (this.id == 40007) {
            this.copy(13619);
            this.name = "Fun PVP Portal";
            this.actions[4] = null;
        }
        else if (this.id == 40008) {
            this.copy(20839);
            this.name = "Tournament Barrier";
            this.actions[0] = "Use";
        }
        else if (this.id == 40009) {
            this.copy(18774);
            this.name = "Cosmetic Chest";
            this.actions[0] = "Open";
            this.actions[1] = "View-rewards";
            this.actions[2] = null;
            this.actions[3] = null;
            this.actions[4] = null;
        }
        else if (this.id == 31846) {
            this.name = "Tournament Information";
            this.actions[0] = "Read";
        }
        else if (this.id == 29087) {
            this.name = "Ticket Exchange";
            this.actions[0] = "Use";
        }
        else if (this.id == 172) {
            this.name = "Crystal Chest";
        }
        else if (this.id == 40010) {
            this.copy(18775);
            this.name = "Cosmetic Chest";
            this.actions[0] = null;
            this.actions[1] = null;
            this.actions[2] = null;
            this.actions[3] = null;
            this.actions[4] = null;
        }
    }
    
    void loadData(final Buffer buffer_0, final int int_0) {
        if (int_0 == 1) {
            final int int_ = buffer_0.readUnsignedByte();
            if (int_ > 0) {
                if (this.objectModels != null && !ObjectComposition.objectCompositionLowDetail) {
                    buffer_0.offset += 3 * int_;
                }
                else {
                    this.objectTypes = new int[int_];
                    this.objectModels = new int[int_];
                    for (int int_2 = 0; int_2 < int_; ++int_2) {
                        this.objectModels[int_2] = buffer_0.readUnsignedShort();
                        this.objectTypes[int_2] = buffer_0.readUnsignedByte();
                    }
                }
            }
        }
        else if (int_0 == 2) {
            this.name = buffer_0.readString();
        }
        else if (int_0 == 5) {
            final int int_ = buffer_0.readUnsignedByte();
            if (int_ > 0) {
                if (this.objectModels != null && !ObjectComposition.objectCompositionLowDetail) {
                    buffer_0.offset += 2 * int_;
                }
                else {
                    this.objectTypes = null;
                    this.objectModels = new int[int_];
                    for (int int_2 = 0; int_2 < int_; ++int_2) {
                        this.objectModels[int_2] = buffer_0.readUnsignedShort();
                    }
                }
            }
        }
        else if (int_0 == 14) {
            this.width = buffer_0.readUnsignedByte();
        }
        else if (int_0 == 15) {
            this.length = buffer_0.readUnsignedByte();
        }
        else if (int_0 == 17) {
            this.clipType = 0;
            this.blocksProjectile = false;
        }
        else if (int_0 == 18) {
            this.blocksProjectile = false;
        }
        else if (int_0 == 19) {
            this.int1 = buffer_0.readUnsignedByte();
        }
        else if (int_0 == 21) {
            this.contouredGround = 0;
        }
        else if (int_0 == 22) {
            this.nonFlatShading = true;
        }
        else if (int_0 == 23) {
            this.modelClipped = true;
        }
        else if (int_0 == 24) {
            this.animationId = buffer_0.readUnsignedShort();
            if (this.animationId == 65535) {
                this.animationId = -1;
            }
        }
        else if (int_0 == 27) {
            this.clipType = 1;
        }
        else if (int_0 == 28) {
            this.decorDisplacement = buffer_0.readUnsignedByte();
        }
        else if (int_0 == 29) {
            this.ambient = buffer_0.readByte();
        }
        else if (int_0 == 39) {
            this.contrast = buffer_0.readByte() * 25;
        }
        else if (int_0 >= 30 && int_0 < 35) {
            this.actions[int_0 - 30] = buffer_0.readString();
            if (this.actions[int_0 - 30].equalsIgnoreCase("Hidden")) {
                this.actions[int_0 - 30] = null;
            }
        }
        else if (int_0 == 40) {
            final int int_ = buffer_0.readUnsignedByte();
            this.recolorToFind = new short[int_];
            this.recolorToReplace = new short[int_];
            for (int int_2 = 0; int_2 < int_; ++int_2) {
                this.recolorToFind[int_2] = (short)buffer_0.readUnsignedShort();
                this.recolorToReplace[int_2] = (short)buffer_0.readUnsignedShort();
            }
        }
        else if (int_0 == 41) {
            final int int_ = buffer_0.readUnsignedByte();
            this.textureToFind = new short[int_];
            this.textureToReplace = new short[int_];
            for (int int_2 = 0; int_2 < int_; ++int_2) {
                this.textureToFind[int_2] = (short)buffer_0.readUnsignedShort();
                this.textureToReplace[int_2] = (short)buffer_0.readUnsignedShort();
            }
        }
        else if (int_0 == 62) {
            this.isRotated = true;
        }
        else if (int_0 == 64) {
            this.clipped = false;
        }
        else if (int_0 == 65) {
            this.modelSizeX = buffer_0.readUnsignedShort();
        }
        else if (int_0 == 66) {
            this.modelSizeHeight = buffer_0.readUnsignedShort();
        }
        else if (int_0 == 67) {
            this.modelSizeY = buffer_0.readUnsignedShort();
        }
        else if (int_0 == 68) {
            this.mapSceneId = buffer_0.readUnsignedShort();
        }
        else if (int_0 == 69) {
            buffer_0.readUnsignedByte();
        }
        else if (int_0 == 70) {
            this.offsetX = buffer_0.readShort();
        }
        else if (int_0 == 71) {
            this.offsetHeight = buffer_0.readShort();
        }
        else if (int_0 == 72) {
            this.offsetY = buffer_0.readShort();
        }
        else if (int_0 == 73) {
            this.obstructsGround = true;
        }
        else if (int_0 == 74) {
            this.isHollow = true;
        }
        else if (int_0 == 75) {
            this.supportItems = buffer_0.readUnsignedByte();
        }
        else if (int_0 != 77 && int_0 != 92) {
            if (int_0 == 78) {
                this.ambientSoundId = buffer_0.readUnsignedShort();
                this.int4 = buffer_0.readUnsignedByte();
            }
            else if (int_0 == 79) {
                this.int5 = buffer_0.readUnsignedShort();
                this.int6 = buffer_0.readUnsignedShort();
                this.int4 = buffer_0.readUnsignedByte();
                final int int_ = buffer_0.readUnsignedByte();
                this.field3417 = new int[int_];
                for (int int_2 = 0; int_2 < int_; ++int_2) {
                    this.field3417[int_2] = buffer_0.readUnsignedShort();
                }
            }
            else if (int_0 == 81) {
                this.contouredGround = buffer_0.readUnsignedByte() * 256;
            }
            else if (int_0 == 82) {
                this.mapIconId = buffer_0.readUnsignedShort();
            }
            else if (int_0 == 249) {
                this.params = KeyFocusListener.readStringIntParameters(buffer_0, this.params);
            }
        }
        else {
            this.varpId = buffer_0.readUnsignedShort();
            if (this.varpId == 65535) {
                this.varpId = -1;
            }
            this.configId = buffer_0.readUnsignedShort();
            if (this.configId == 65535) {
                this.configId = -1;
            }
            int int_ = -1;
            if (int_0 == 92) {
                int_ = buffer_0.readUnsignedShort();
                if (int_ == 65535) {
                    int_ = -1;
                }
            }
            final int int_2 = buffer_0.readUnsignedByte();
            this.impostorIds = new int[int_2 + 2];
            for (int int_3 = 0; int_3 <= int_2; ++int_3) {
                this.impostorIds[int_3] = buffer_0.readUnsignedShort();
                if (this.impostorIds[int_3] == 65535) {
                    this.impostorIds[int_3] = -1;
                }
            }
            this.impostorIds[int_2 + 1] = int_;
        }
    }
    
    public boolean method5048(final int int_0) {
        if (this.objectTypes != null) {
            for (int int_ = 0; int_ < this.objectTypes.length; ++int_) {
                if (this.objectTypes[int_] == int_0) {
                    return Frames.field1801.tryLoadRecord(this.objectModels[int_] & 0xFFFF, 0);
                }
            }
            return true;
        }
        if (this.objectModels == null) {
            return true;
        }
        if (int_0 != 10) {
            return true;
        }
        boolean bool_0 = true;
        for (int int_2 = 0; int_2 < this.objectModels.length; ++int_2) {
            bool_0 &= Frames.field1801.tryLoadRecord(this.objectModels[int_2] & 0xFFFF, 0);
        }
        return bool_0;
    }
    
    public boolean method5051() {
        if (this.objectModels == null) {
            return true;
        }
        boolean bool_0 = true;
        for (int int_0 = 0; int_0 < this.objectModels.length; ++int_0) {
            bool_0 &= Frames.field1801.tryLoadRecord(this.objectModels[int_0] & 0xFFFF, 0);
        }
        return bool_0;
    }
    
    public Renderable getModel(final int int_0, final int int_1, final int[][] ints_0, final int int_2, final int int_3, final int int_4) {
        long long_0;
        if (this.objectTypes == null) {
            long_0 = int_1 + (this.id << 10);
        }
        else {
            long_0 = int_1 + (int_0 << 3) + (this.id << 10);
        }
        Object object_0 = ObjectComposition.cachedModels.get(long_0);
        if (object_0 == null) {
            final ModelData modeldata_0 = this.getModel(int_0, int_1);
            if (modeldata_0 == null) {
                return null;
            }
            if (!this.nonFlatShading) {
                object_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            }
            else {
                modeldata_0.field1486 = (short)(this.ambient + 64);
                modeldata_0.contrast = (short)(this.contrast + 768);
                modeldata_0.computeNormals();
                object_0 = modeldata_0;
            }
            ObjectComposition.cachedModels.put((CacheableNode)object_0, long_0);
        }
        if (this.nonFlatShading) {
            object_0 = ((ModelData)object_0).method2650();
        }
        if (this.contouredGround >= 0) {
            if (object_0 instanceof Model) {
                object_0 = ((Model)object_0).method2665(ints_0, int_2, int_3, int_4, true, this.contouredGround);
            }
            else if (object_0 instanceof ModelData) {
                object_0 = ((ModelData)object_0).method2567(ints_0, int_2, int_3, int_4, true, this.contouredGround);
            }
        }
        return (Renderable)object_0;
    }
    
    public Model method5031(final int int_0, final int int_1, final int[][] ints_0, final int int_2, final int int_3, final int int_4) {
        long long_0;
        if (this.objectTypes == null) {
            long_0 = int_1 + (this.id << 10);
        }
        else {
            long_0 = int_1 + (int_0 << 3) + (this.id << 10);
        }
        Model model_0 = (Model)ObjectComposition.field3374.get(long_0);
        if (model_0 == null) {
            final ModelData modeldata_0 = this.getModel(int_0, int_1);
            if (modeldata_0 == null) {
                return null;
            }
            model_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            ObjectComposition.field3374.put(model_0, long_0);
        }
        if (this.contouredGround >= 0) {
            model_0 = model_0.method2665(ints_0, int_2, int_3, int_4, true, this.contouredGround);
        }
        return model_0;
    }
    
    public Model method5032(final int int_0, final int int_1, final int[][] ints_0, final int int_2, final int int_3, final int int_4, final Sequence sequence_0, final int int_5) {
        long long_0;
        if (this.objectTypes == null) {
            long_0 = int_1 + (this.id << 10);
        }
        else {
            long_0 = int_1 + (int_0 << 3) + (this.id << 10);
        }
        Model model_0 = (Model)ObjectComposition.field3374.get(long_0);
        if (model_0 == null) {
            final ModelData modeldata_0 = this.getModel(int_0, int_1);
            if (modeldata_0 == null) {
                return null;
            }
            model_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            ObjectComposition.field3374.put(model_0, long_0);
        }
        if (sequence_0 == null && this.contouredGround == -1) {
            return model_0;
        }
        if (sequence_0 != null) {
            model_0 = sequence_0.transformObjectModel(model_0, int_5, int_1);
        }
        else {
            model_0 = model_0.toSharedModel(true);
        }
        if (this.contouredGround >= 0) {
            model_0 = model_0.method2665(ints_0, int_2, int_3, int_4, false, this.contouredGround);
        }
        return model_0;
    }
    
    ModelData getModel(final int int_0, int int_1) {
        ModelData modeldata_0 = null;
        if (this.objectTypes == null) {
            if (int_0 != 10) {
                return null;
            }
            if (this.objectModels == null) {
                return null;
            }
            boolean bool_0 = this.isRotated;
            if (int_0 == 2 && int_1 > 3) {
                bool_0 = !bool_0;
            }
            final int int_2 = this.objectModels.length;
            for (int int_3 = 0; int_3 < int_2; ++int_3) {
                int int_4 = this.objectModels[int_3];
                if (bool_0) {
                    int_4 += 65536;
                }
                modeldata_0 = (ModelData)ObjectComposition.field3391.get(int_4);
                if (modeldata_0 == null) {
                    modeldata_0 = ModelData.method2568(Frames.field1801, int_4 & 0xFFFF, 0);
                    if (modeldata_0 == null) {
                        return null;
                    }
                    if (bool_0) {
                        modeldata_0.method2583();
                    }
                    ObjectComposition.field3391.put(modeldata_0, int_4);
                }
                if (int_2 > 1) {
                    ObjectComposition.field3375[int_3] = modeldata_0;
                }
            }
            if (int_2 > 1) {
                modeldata_0 = new ModelData(ObjectComposition.field3375, int_2);
            }
        }
        else {
            int int_5 = -1;
            for (int int_2 = 0; int_2 < this.objectTypes.length; ++int_2) {
                if (this.objectTypes[int_2] == int_0) {
                    int_5 = int_2;
                    break;
                }
            }
            if (int_5 == -1) {
                return null;
            }
            int int_2 = this.objectModels[int_5];
            final boolean bool_2 = this.isRotated ^ int_1 > 3;
            if (bool_2) {
                int_2 += 65536;
            }
            modeldata_0 = (ModelData)ObjectComposition.field3391.get(int_2);
            if (modeldata_0 == null) {
                modeldata_0 = ModelData.method2568(Frames.field1801, int_2 & 0xFFFF, 0);
                if (modeldata_0 == null) {
                    return null;
                }
                if (bool_2) {
                    modeldata_0.method2583();
                }
                ObjectComposition.field3391.put(modeldata_0, int_2);
            }
        }
        boolean bool_0 = this.modelSizeX != 128 || this.modelSizeHeight != 128 || this.modelSizeY != 128;
        final boolean bool_3 = this.offsetX != 0 || this.offsetHeight != 0 || this.offsetY != 0;
        final ModelData modeldata_2 = new ModelData(modeldata_0, int_1 == 0 && !bool_0 && !bool_3, this.recolorToFind == null, this.textureToFind == null, true);
        if (int_0 == 4 && int_1 > 3) {
            modeldata_2.method2653(256);
            modeldata_2.method2580(45, 0, -45);
        }
        int_1 &= 0x3;
        if (int_1 == 1) {
            modeldata_2.method2576();
        }
        else if (int_1 == 2) {
            modeldata_2.method2573();
        }
        else if (int_1 == 3) {
            modeldata_2.method2578();
        }
        if (this.recolorToFind != null) {
            for (int int_4 = 0; int_4 < this.recolorToFind.length; ++int_4) {
                modeldata_2.recolor(this.recolorToFind[int_4], this.recolorToReplace[int_4]);
            }
        }
        if (this.textureToFind != null) {
            for (int int_4 = 0; int_4 < this.textureToFind.length; ++int_4) {
                modeldata_2.method2582(this.textureToFind[int_4], this.textureToReplace[int_4]);
            }
        }
        if (bool_0) {
            modeldata_2.method2592(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
        }
        if (bool_3) {
            modeldata_2.method2580(this.offsetX, this.offsetHeight, this.offsetY);
        }
        return modeldata_2;
    }
    
    public ObjectComposition getImpostor() {
        int int_0 = -1;
        if (this.varpId != -1) {
            int_0 = GameSocket.getVarbit(this.varpId);
        }
        else if (this.configId != -1) {
            int_0 = class225.clientVarps[this.configId];
        }
        int int_2;
        if (int_0 >= 0 && int_0 < this.impostorIds.length - 1) {
            int_2 = this.impostorIds[int_0];
        }
        else {
            int_2 = this.impostorIds[this.impostorIds.length - 1];
        }
        return (int_2 != -1) ? FileOnDisk.getObjectDefinition(int_2) : null;
    }
    
    public int method5035(final int int_0, final int int_1) {
        return FriendManager.method1668(this.params, int_0, int_1);
    }
    
    public String method5036(final int int_0, final String string_0) {
    	System.out.println("<method5036> Args: "+int_0+", "+string_0);
        return WorldMapRectangle.method171(this.params, int_0, string_0);
    }
    
    public boolean method5024() {
        if (this.impostorIds == null) {
            return this.ambientSoundId != -1 || this.field3417 != null;
        }
        for (int int_0 = 0; int_0 < this.impostorIds.length; ++int_0) {
            if (this.impostorIds[int_0] != -1) {
                final ObjectComposition objectcomposition_1 = FileOnDisk.getObjectDefinition(this.impostorIds[int_0]);
                if (objectcomposition_1.ambientSoundId != -1 || objectcomposition_1.field3417 != null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static void decodeSprite(final byte[] bytes_0) {
        final Buffer buffer_0 = new Buffer(bytes_0);
        buffer_0.offset = bytes_0.length - 2;
        class319.indexedSpriteCount = buffer_0.readUnsignedShort();
        class7.indexedSpriteOffsetXs = new int[class319.indexedSpriteCount];
        class225.indexedSpriteOffsetYs = new int[class319.indexedSpriteCount];
        class319.indexSpriteWidths = new int[class319.indexedSpriteCount];
        class319.indexedSpriteHeights = new int[class319.indexedSpriteCount];
        class319.spritePixels = new byte[class319.indexedSpriteCount][];
        buffer_0.offset = bytes_0.length - 7 - class319.indexedSpriteCount * 8;
        class305.indexedSpriteWidth = buffer_0.readUnsignedShort();
        class319.indexedSpriteHeight = buffer_0.readUnsignedShort();
        final int int_0 = (buffer_0.readUnsignedByte() & 0xFF) + 1;
        for (int int_2 = 0; int_2 < class319.indexedSpriteCount; ++int_2) {
            class7.indexedSpriteOffsetXs[int_2] = buffer_0.readUnsignedShort();
        }
        for (int int_2 = 0; int_2 < class319.indexedSpriteCount; ++int_2) {
            class225.indexedSpriteOffsetYs[int_2] = buffer_0.readUnsignedShort();
        }
        for (int int_2 = 0; int_2 < class319.indexedSpriteCount; ++int_2) {
            class319.indexSpriteWidths[int_2] = buffer_0.readUnsignedShort();
        }
        for (int int_2 = 0; int_2 < class319.indexedSpriteCount; ++int_2) {
            class319.indexedSpriteHeights[int_2] = buffer_0.readUnsignedShort();
        }
        buffer_0.offset = bytes_0.length - 7 - class319.indexedSpriteCount * 8 - (int_0 - 1) * 3;
        PacketNode.indexedSpritePalette = new int[int_0];
        for (int int_2 = 1; int_2 < int_0; ++int_2) {
            PacketNode.indexedSpritePalette[int_2] = buffer_0.read24BitInt();
            if (PacketNode.indexedSpritePalette[int_2] == 0) {
                PacketNode.indexedSpritePalette[int_2] = 1;
            }
        }
        buffer_0.offset = 0;
        for (int int_2 = 0; int_2 < class319.indexedSpriteCount; ++int_2) {
            final int int_3 = class319.indexSpriteWidths[int_2];
            final int int_4 = class319.indexedSpriteHeights[int_2];
            final int int_5 = int_3 * int_4;
            final byte[] bytes_ = new byte[int_5];
            class319.spritePixels[int_2] = bytes_;
            final int int_6 = buffer_0.readUnsignedByte();
            if (int_6 == 0) {
                for (int int_7 = 0; int_7 < int_5; ++int_7) {
                    bytes_[int_7] = buffer_0.readByte();
                }
            }
            else if (int_6 == 1) {
                for (int int_7 = 0; int_7 < int_3; ++int_7) {
                    for (int int_8 = 0; int_8 < int_4; ++int_8) {
                        bytes_[int_7 + int_8 * int_3] = buffer_0.readByte();
                    }
                }
            }
        }
    }
    
    static void method5085() {
        for (int int_0 = 0; int_0 < Game.queuedSoundEffectCount; ++int_0) {
            final int[] unknownSoundValues2 = Game.unknownSoundValues2;
            final int n = int_0;
            --unknownSoundValues2[n];
            if (Game.unknownSoundValues2[int_0] >= -10) {
                SoundEffect soundeffect_0 = Game.audioEffects[int_0];
                if (soundeffect_0 == null) {
                    soundeffect_0 = SoundEffect.getTrack(UrlRequester.indexCache4, Game.queuedSoundEffectIDs[int_0], 0);
                    if (soundeffect_0 == null) {
                        continue;
                    }
                    final int[] unknownSoundValues3 = Game.unknownSoundValues2;
                    final int n2 = int_0;
                    unknownSoundValues3[n2] += soundeffect_0.calculateDelay();
                    Game.audioEffects[int_0] = soundeffect_0;
                }
                if (Game.unknownSoundValues2[int_0] < 0) {
                    int int_8;
                    if (Game.soundLocations[int_0] != 0) {
                        final int int_2 = (Game.soundLocations[int_0] & 0xFF) * 128;
                        final int int_3 = Game.soundLocations[int_0] >> 16 & 0xFF;
                        int int_4 = int_3 * 128 + 64 - class138.localPlayer.x;
                        if (int_4 < 0) {
                            int_4 = -int_4;
                        }
                        final int int_5 = Game.soundLocations[int_0] >> 8 & 0xFF;
                        int int_6 = int_5 * 128 + 64 - class138.localPlayer.y;
                        if (int_6 < 0) {
                            int_6 = -int_6;
                        }
                        int int_7 = int_6 + int_4 - 128;
                        if (int_7 > int_2) {
                            Game.unknownSoundValues2[int_0] = -100;
                            continue;
                        }
                        if (int_7 < 0) {
                            int_7 = 0;
                        }
                        int_8 = (int_2 - int_7) * Game.field815 / int_2;
                    }
                    else {
                        int_8 = Game.field814;
                    }
                    if (int_8 > 0) {
                        final RawAudioNode rawaudionode_0 = soundeffect_0.method2069().applyResampler(OwnWorldComparator.field577);
                        final class103 class103_0 = class103.method2287(rawaudionode_0, 100, int_8);
                        class103_0.method2258(Game.unknownSoundValues1[int_0] - 1);
                        MapIconReference.field310.method2032(class103_0);
                    }
                    Game.unknownSoundValues2[int_0] = -100;
                }
            }
            else {
                --Game.queuedSoundEffectCount;
                for (int int_9 = int_0; int_9 < Game.queuedSoundEffectCount; ++int_9) {
                    Game.queuedSoundEffectIDs[int_9] = Game.queuedSoundEffectIDs[int_9 + 1];
                    Game.audioEffects[int_9] = Game.audioEffects[int_9 + 1];
                    Game.unknownSoundValues1[int_9] = Game.unknownSoundValues1[int_9 + 1];
                    Game.unknownSoundValues2[int_9] = Game.unknownSoundValues2[int_9 + 1];
                    Game.soundLocations[int_9] = Game.soundLocations[int_9 + 1];
                }
                --int_0;
            }
        }
        if (Game.field813) {
            final boolean bool_0 = class217.field2460 != 0 || class217.field2459.method4203();
            if (!bool_0) {
                if (Game.field811 != 0 && Game.field812 != -1) {
                    Actor.method1554(Item.indexTrack1, Game.field812, 0, Game.field811, false);
                }
                Game.field813 = false;
            }
        }
    }
    
    static {
        ObjectComposition.objectCompositionLowDetail = false;
        ObjectComposition.objects = new NodeCache(4096);
        ObjectComposition.field3391 = new NodeCache(500);
        ObjectComposition.cachedModels = new NodeCache(30);
        ObjectComposition.field3374 = new NodeCache(30);
        ObjectComposition.field3375 = new ModelData[4];
    }
}
