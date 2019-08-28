// 
// Decompiled by Procyon v0.5.36
// 

public class PlayerComposition
{
    public static short[] colorsToFind;
    public static short[][] colorsToReplace;
    public static short[] field2577;
    public static short[][] field2578;
    static final int[] field2579;
    static NodeCache field2580;
    int[] equipmentIds;
    int[] bodyPartColours;
    public boolean isFemale;
    public int transformedNpcId;
    long hash;
    long field2574;
    
    public void method4462(int[] ints_0, final int[] ints_1, final boolean bool_0, final int int_0) {
        if (ints_0 == null) {
            ints_0 = new int[12];
            for (int int_ = 0; int_ < 7; ++int_) {
                for (int int_2 = 0; int_2 < KitDefinition.field3294; ++int_2) {
                    final KitDefinition kitdefinition_0 = GrandExchangeEvent.getKitDefinition(int_2);
                    if (kitdefinition_0 != null && !kitdefinition_0.nonSelectable && (bool_0 ? 7 : 0) + int_ == kitdefinition_0.bodyPartId) {
                        ints_0[PlayerComposition.field2579[int_]] = int_2 + 256;
                        break;
                    }
                }
            }
        }
        this.equipmentIds = ints_0;
        this.bodyPartColours = ints_1;
        this.isFemale = bool_0;
        this.transformedNpcId = int_0;
        this.setHash();
    }
    
    public void method4478(final int int_0, final boolean bool_0) {
        if (int_0 != 1 || !this.isFemale) {
            int int_ = this.equipmentIds[PlayerComposition.field2579[int_0]];
            if (int_ != 0) {
                int_ -= 256;
                KitDefinition kitdefinition_0;
                do {
                    if (!bool_0) {
                        if (--int_ < 0) {
                            int_ = KitDefinition.field3294 - 1;
                        }
                    }
                    else if (++int_ >= KitDefinition.field3294) {
                        int_ = 0;
                    }
                    kitdefinition_0 = GrandExchangeEvent.getKitDefinition(int_);
                } while (kitdefinition_0 == null || kitdefinition_0.nonSelectable || int_0 + (this.isFemale ? 7 : 0) != kitdefinition_0.bodyPartId);
                this.equipmentIds[PlayerComposition.field2579[int_0]] = int_ + 256;
                this.setHash();
            }
        }
    }
    
    public void method4493(final int int_0, final boolean bool_0) {
        int int_ = this.bodyPartColours[int_0];
        if (!bool_0) {
            boolean bool_;
            do {
                if (--int_ < 0) {
                    int_ = PlayerComposition.colorsToReplace[int_0].length - 1;
                }
                bool_ = (int_0 != 4 || int_ < 8);
            } while (!bool_);
        }
        else {
            boolean bool_;
            do {
                if (++int_ >= PlayerComposition.colorsToReplace[int_0].length) {
                    int_ = 0;
                }
                bool_ = (int_0 != 4 || int_ < 8);
            } while (!bool_);
        }
        this.bodyPartColours[int_0] = int_;
        this.setHash();
    }
    
    public void method4465(final boolean bool_0) {
        if (this.isFemale != bool_0) {
            this.method4462(null, this.bodyPartColours, bool_0, -1);
        }
    }
    
    public void method4466(final Buffer buffer_0) {
        buffer_0.putByte(this.isFemale ? 1 : 0);
        for (int int_0 = 0; int_0 < 7; ++int_0) {
            final int int_2 = this.equipmentIds[PlayerComposition.field2579[int_0]];
            if (int_2 == 0) {
                buffer_0.putByte(-1);
            }
            else {
                buffer_0.putByte(int_2 - 256);
            }
        }
        for (int int_0 = 0; int_0 < 5; ++int_0) {
            buffer_0.putByte(this.bodyPartColours[int_0]);
        }
    }
    
    void setHash() {
        final long long_0 = this.hash;
        final int int_0 = this.equipmentIds[5];
        final int int_2 = this.equipmentIds[9];
        this.equipmentIds[5] = int_2;
        this.equipmentIds[9] = int_0;
        this.hash = 0L;
        for (int int_3 = 0; int_3 < 12; ++int_3) {
            this.hash <<= 4;
            if (this.equipmentIds[int_3] >= 256) {
                this.hash += this.equipmentIds[int_3] - 256;
            }
        }
        if (this.equipmentIds[0] >= 256) {
            this.hash += this.equipmentIds[0] - 256 >> 4;
        }
        if (this.equipmentIds[1] >= 256) {
            this.hash += this.equipmentIds[1] - 256 >> 8;
        }
        for (int int_3 = 0; int_3 < 5; ++int_3) {
            this.hash <<= 3;
            this.hash += this.bodyPartColours[int_3];
        }
        this.hash <<= 1;
        this.hash += (this.isFemale ? 1 : 0);
        this.equipmentIds[5] = int_0;
        this.equipmentIds[9] = int_2;
        if (long_0 != 0L && this.hash != long_0) {
            PlayerComposition.field2580.remove(long_0);
        }
    }
    
    public Model getModel(final Sequence sequence_0, final int int_0, final Sequence sequence_1, final int int_1) {
        if (this.transformedNpcId != -1) {
            return HorizontalAlignment.getNpcDefinition(this.transformedNpcId).getModel(sequence_0, int_0, sequence_1, int_1);
        }
        long long_0 = this.hash;
        int[] ints_0 = this.equipmentIds;
        if (sequence_0 != null && (sequence_0.leftHandItem >= 0 || sequence_0.rightHandItem >= 0)) {
            ints_0 = new int[12];
            for (int int_2 = 0; int_2 < 12; ++int_2) {
                ints_0[int_2] = this.equipmentIds[int_2];
            }
            if (sequence_0.leftHandItem >= 0) {
                long_0 += sequence_0.leftHandItem - this.equipmentIds[5] << 8;
                ints_0[5] = sequence_0.leftHandItem;
            }
            if (sequence_0.rightHandItem >= 0) {
                long_0 += sequence_0.rightHandItem - this.equipmentIds[3] << 16;
                ints_0[3] = sequence_0.rightHandItem;
            }
        }
        Model model_0 = (Model)PlayerComposition.field2580.get(long_0);
        if (model_0 == null) {
            boolean bool_0 = false;
            for (int int_3 = 0; int_3 < 12; ++int_3) {
                final int int_4 = ints_0[int_3];
                if (int_4 >= 256 && int_4 < 512 && !GrandExchangeEvent.getKitDefinition(int_4 - 256).ready()) {
                    bool_0 = true;
                }
                if (int_4 >= 512 && !TextureProvider.getItemDefinition(int_4 - 512).readyWorn(this.isFemale)) {
                    bool_0 = true;
                }
            }
            if (bool_0) {
                if (this.field2574 != -1L) {
                    model_0 = (Model)PlayerComposition.field2580.get(this.field2574);
                }
                if (model_0 == null) {
                    return null;
                }
            }
            if (model_0 == null) {
                final ModelData[] modeldatas_0 = new ModelData[12];
                int int_4 = 0;
                for (int int_5 = 0; int_5 < 12; ++int_5) {
                    final int int_6 = ints_0[int_5];
                    if (int_6 >= 256 && int_6 < 512) {
                        final ModelData modeldata_0 = GrandExchangeEvent.getKitDefinition(int_6 - 256).getModelData();
                        if (modeldata_0 != null) {
                            modeldatas_0[int_4++] = modeldata_0;
                        }
                    }
                    if (int_6 >= 512) {
                        final ModelData modeldata_0 = TextureProvider.getItemDefinition(int_6 - 512).getWornModelData(this.isFemale);
                        if (modeldata_0 != null) {
                            modeldatas_0[int_4++] = modeldata_0;
                        }
                    }
                }
                final ModelData modeldata_2 = new ModelData(modeldatas_0, int_4);
                for (int int_6 = 0; int_6 < 5; ++int_6) {
                    if (this.bodyPartColours[int_6] < PlayerComposition.colorsToReplace[int_6].length) {
                        modeldata_2.recolor(PlayerComposition.colorsToFind[int_6], PlayerComposition.colorsToReplace[int_6][this.bodyPartColours[int_6]]);
                    }
                    if (this.bodyPartColours[int_6] < PlayerComposition.field2578[int_6].length) {
                        modeldata_2.recolor(PlayerComposition.field2577[int_6], PlayerComposition.field2578[int_6][this.bodyPartColours[int_6]]);
                    }
                }
                model_0 = modeldata_2.light(64, 850, -30, -50, -30);
                PlayerComposition.field2580.put(model_0, long_0);
                this.field2574 = long_0;
            }
        }
        if (sequence_0 == null && sequence_1 == null) {
            return model_0;
        }
        Model model_2;
        if (sequence_0 != null && sequence_1 != null) {
            model_2 = sequence_0.applyTransformations(model_0, int_0, sequence_1, int_1);
        }
        else if (sequence_0 != null) {
            model_2 = sequence_0.transformActorModel(model_0, int_0);
        }
        else {
            model_2 = sequence_1.transformActorModel(model_0, int_1);
        }
        return model_2;
    }
    
    ModelData method4469() {
        if (this.transformedNpcId != -1) {
            return HorizontalAlignment.getNpcDefinition(this.transformedNpcId).method5158();
        }
        boolean bool_0 = false;
        for (int int_0 = 0; int_0 < 12; ++int_0) {
            final int int_2 = this.equipmentIds[int_0];
            if (int_2 >= 256 && int_2 < 512 && !GrandExchangeEvent.getKitDefinition(int_2 - 256).method4905()) {
                bool_0 = true;
            }
            if (int_2 >= 512 && !TextureProvider.getItemDefinition(int_2 - 512).method5097(this.isFemale)) {
                bool_0 = true;
            }
        }
        if (bool_0) {
            return null;
        }
        final ModelData[] modeldatas_0 = new ModelData[12];
        int int_2 = 0;
        for (int int_3 = 0; int_3 < 12; ++int_3) {
            final int int_4 = this.equipmentIds[int_3];
            if (int_4 >= 256 && int_4 < 512) {
                final ModelData modeldata_0 = GrandExchangeEvent.getKitDefinition(int_4 - 256).method4899();
                if (modeldata_0 != null) {
                    modeldatas_0[int_2++] = modeldata_0;
                }
            }
            if (int_4 >= 512) {
                final ModelData modeldata_0 = TextureProvider.getItemDefinition(int_4 - 512).method5098(this.isFemale);
                if (modeldata_0 != null) {
                    modeldatas_0[int_2++] = modeldata_0;
                }
            }
        }
        final ModelData modeldata_2 = new ModelData(modeldatas_0, int_2);
        for (int int_4 = 0; int_4 < 5; ++int_4) {
            if (this.bodyPartColours[int_4] < PlayerComposition.colorsToReplace[int_4].length) {
                modeldata_2.recolor(PlayerComposition.colorsToFind[int_4], PlayerComposition.colorsToReplace[int_4][this.bodyPartColours[int_4]]);
            }
            if (this.bodyPartColours[int_4] < PlayerComposition.field2578[int_4].length) {
                modeldata_2.recolor(PlayerComposition.field2577[int_4], PlayerComposition.field2578[int_4][this.bodyPartColours[int_4]]);
            }
        }
        return modeldata_2;
    }
    
    public int method4483() {
        return (this.transformedNpcId == -1) ? ((this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20)) : (305419896 + HorizontalAlignment.getNpcDefinition(this.transformedNpcId).id);
    }
    
    static {
        field2579 = new int[] { 8, 11, 4, 6, 9, 7, 10 };
        PlayerComposition.field2580 = new NodeCache(260);
    }
}
